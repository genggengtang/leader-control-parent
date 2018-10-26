package org.zxs.leader.control.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zxs.leader.control.dao.consts.IDicInfoConst;
import org.zxs.leader.control.dao.interf.IChatGroupInfoMapper;
import org.zxs.leader.control.dao.interf.IChatGroupUserMapper;
import org.zxs.leader.control.dao.interf.IOrgUserMapper;
import org.zxs.leader.control.dao.model.ChatGroupInfo;
import org.zxs.leader.control.dao.model.ChatGroupInfoExample;
import org.zxs.leader.control.dao.model.ChatGroupUser;
import org.zxs.leader.control.dao.model.ChatGroupUserExample;
import org.zxs.leader.control.dao.model.ChatGroupUserExample.Criteria;
import org.zxs.leader.control.dao.model.OrgUser;
import org.zxs.leader.control.dao.model.vo.output.ChatGroupBaseOut;
import org.zxs.leader.control.dao.model.vo.output.ChatGroupListOut;
import org.zxs.leader.control.dao.model.vo.output.ChatGroupPrjOut;
import org.zxs.leader.control.dao.model.vo.output.ChatGroupSimpleOut;
import org.zxs.leader.control.dao.model.vo.output.OptionsOut;
import org.zxs.leader.control.dao.model.vo.output.SimpleUserOut;
import org.zxs.leader.control.dao.model.vo.output.rows.ChatGroupInfoRow;
import org.zxs.leader.control.service.interf.IChatGroupInfoService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ChatGroupInfoServiceImpl implements IChatGroupInfoService {
	
	private static Log log = LogFactory.getLog(ChatGroupInfoServiceImpl.class);

	@Resource
	private IChatGroupInfoMapper cgInfoMapper;

	@Resource
	private IOrgUserMapper orgUserMapper;

	@Resource
	private IChatGroupUserMapper cgUserMapper;

	@Override
	public List<ChatGroupInfo> getAllChatGroup() {
		ChatGroupInfoExample example = new ChatGroupInfoExample();
		org.zxs.leader.control.dao.model.ChatGroupInfoExample.Criteria criteria = example.createCriteria();
		criteria.andTypeLessThan((byte) 3); // 只查询工作群及我的群
		return cgInfoMapper.selectByExample(example);
	}

	@Override
	@Transactional
	public Integer createChatRoom(ChatGroupInfo cgInfo, Integer createId, List<Integer> userArray) {
		String groupName = cgInfo.getGroupName();
		if (null == groupName || groupName.isEmpty()) {
			List<Integer> userList = new ArrayList<>();
			userList.add(createId);
			userList.addAll(userArray);
			groupName = orgUserMapper.selectNameInRow(userList);
		}

		 if(groupName.length() > 50) {
			 cgInfo.setGroupName(groupName.substring(0, 50) + "...");
		 }else {
			 cgInfo.setGroupName(groupName);
		 }
		 
		 cgInfo.setEnableNameUpdate((short) 1); // 允许修改群名
		// 保存群组
		int cgInfoSaveRet = cgInfoMapper.insert(cgInfo);

		if (cgInfoSaveRet == 1) {
			Integer cgId = cgInfo.getId();
			// 创建者
			int creatorSaveRet = saveCgUser(createId, cgId, ChatGroupUser.ROLE_OWNER);

			if (creatorSaveRet == 1) { // 保存成功
				// 组员
				if (null != userArray && userArray.size() > 0) {
					for (Integer userId : userArray) {
						int memberSaveRet = saveCgUser(userId, cgId, ChatGroupUser.ROLE_ADMIN);
						if (memberSaveRet != 1) {// 保存失败
							log.error("添加聊天组成员[" + userId + "]失败！");
							return null;
						}
					}
				}
				return cgId;
			}
		}

		return null;
	}

	/*
	 * 保存单个群组用户
	 */
	private int saveCgUser(Integer createId, Integer cgId, byte role) {
		OrgUser createUser = orgUserMapper.selectByPrimaryKey(createId);
		Date nowtime = new Date();

		ChatGroupUser creator = new ChatGroupUser();
		creator.setChatGroupId(cgId);
		creator.setUserId(createId);
		creator.setNickname(createUser.getRealName());
		creator.setRole(role);
		creator.setRemoveable(ChatGroupUser.REMOVE_ALLOW);
		creator.setCreateAt(nowtime);

		return cgUserMapper.insert(creator);
	}

	@Override
	public ChatGroupListOut getChatGroupFullInfo(int userId) {
		return getChatGroupFullInfoWithNameLike(userId, null);
	}

	@Override
	public ChatGroupBaseOut getFullChatGroupInfoById(int id) {
		ChatGroupBaseOut cgBaseOut = cgInfoMapper.selectFullChatGroupInfoById(id);
		if(null != cgBaseOut) {
			List<SimpleUserOut> memberList = cgUserMapper.selectMembersByGroupId(id);
			cgBaseOut.setMemberList(memberList);
			cgBaseOut.setGroupNum(memberList.size() + 1);
		}
		return cgBaseOut;
	}

	@Override
	public ChatGroupSimpleOut getSimpleChatGroupInfoById(int id) {
		return cgInfoMapper.selectSimpleChatGroupInfoById(id);
	}

	@Override
	public List<ChatGroupBaseOut> getPrjChatGroupInfoByPrjId(int prjType, int prjId, int userId) {
		return cgInfoMapper.selectPrjChatGroupInfo(prjType, prjId, userId);
	}

	@Override
	@Transactional
	public int deleteChatGroupById(int id) {
		ChatGroupUserExample cgExample = new ChatGroupUserExample();
		Criteria cgCriteria = cgExample.createCriteria();
		cgCriteria.andChatGroupIdEqualTo(id);
		int iUserDelRet = cgUserMapper.deleteByExample(cgExample);
		log.info("已经移除[" + iUserDelRet + "]位聊天群组[" + id + "]的成员！");
		return cgInfoMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateCgName(int id, String name) {
		ChatGroupInfo cgInfo = new ChatGroupInfo();
		cgInfo.setId(id);
		cgInfo.setGroupName(name);
		cgInfo.setEnableNameUpdate((short) 0);
		return cgInfoMapper.updateByPrimaryKeySelective(cgInfo);
	}

	@Override
	public ChatGroupListOut getChatGroupFullInfoWithNameLike(int userId, String nameLike) {
		ChatGroupListOut cgOut = new ChatGroupListOut();
		int wgCnt = 0;
		
		// 获取服务队聊天群组
		List<ChatGroupBaseOut> leaderGroupList = cgInfoMapper.selectLeaderChatGroupInfo(userId, nameLike);
		if(leaderGroupList != null && !leaderGroupList.isEmpty()) {
			int leaderGroupSize = leaderGroupList.size();
			wgCnt += leaderGroupSize;
			cgOut.setServiceGroup(leaderGroupList);
		}
		
		// 获取市领导联系项目群组
		List<ChatGroupPrjOut> lcPrjList = cgInfoMapper.selectPrjList(userId, nameLike, IDicInfoConst.PRJ_LEADER_CONTROL);
		if(!lcPrjList.isEmpty()) {
			for(ChatGroupPrjOut lcPrjOut : lcPrjList) {
				List<ChatGroupBaseOut> prjChatGroupList = cgInfoMapper.selectPrjChatGroupInfo(IDicInfoConst.PRJ_LEADER_CONTROL,lcPrjOut.getPrjId(), userId);
				lcPrjOut.setWorkPrjGroup(prjChatGroupList);
				int prjGroupCnt = prjChatGroupList.size();
				lcPrjOut.setPrjGroupNum(prjGroupCnt);
				wgCnt += prjGroupCnt;
			}
			cgOut.setLcGroup(lcPrjList);
		}
		
		// 获取城建项目编号
		List<ChatGroupPrjOut> cbPrjList = cgInfoMapper.selectPrjList(userId, nameLike, IDicInfoConst.PRJ_CITY_BUILD);
		if(!cbPrjList.isEmpty()) {
			for(ChatGroupPrjOut cbPrjOut : cbPrjList) {
				List<ChatGroupBaseOut> prjChatGroupList = cgInfoMapper.selectPrjChatGroupInfo(IDicInfoConst.PRJ_CITY_BUILD,cbPrjOut.getPrjId(), userId);
				cbPrjOut.setWorkPrjGroup(prjChatGroupList);
				int prjGroupCnt = prjChatGroupList.size();
				cbPrjOut.setPrjGroupNum(prjGroupCnt);
				wgCnt += prjGroupCnt;
			}
			cgOut.setCbGroup(cbPrjList);
		}
		
		List<ChatGroupBaseOut> myGroupList = cgInfoMapper.selectMyChatGroupInfo(userId, nameLike);
		cgOut.setMyGroup(myGroupList);
		cgOut.setMyGroupCnt(myGroupList.size());
		
		cgOut.setWorkGroupCnt(wgCnt);
		
		return cgOut;
	}

	@Override
	public PageInfo<ChatGroupInfoRow> getChatGroupInfoOutsByPage(Integer pageNum, Integer pageSize, String keyword) {
		PageHelper.startPage(pageNum, pageSize);
		List<ChatGroupInfoRow> rows = null;
		if (null == keyword) {
			rows = this.cgInfoMapper.selectAllOuts();
		} else {
			rows = this.cgInfoMapper.selectRowsByKeyword(keyword);
		}
		return new PageInfo<>(rows);
	}

	@Override
	public List<OptionsOut> getAllchatGroupInfoOptions() {
		return this.cgInfoMapper.selectAllchatGroupInfoOptions();
	}

	@Override
	public ChatGroupInfo findById(Integer id) {
		return this.cgInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public int insert(ChatGroupInfo chatGroupInfo) {
		return this.cgInfoMapper.insert(chatGroupInfo);
	}

	@Override
	public int update(ChatGroupInfo chatGroupInfo) {
		return this.cgInfoMapper.updateByPrimaryKey(chatGroupInfo);
	}

}
