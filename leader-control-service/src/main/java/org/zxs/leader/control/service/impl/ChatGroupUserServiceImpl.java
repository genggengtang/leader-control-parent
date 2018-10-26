package org.zxs.leader.control.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zxs.base.model.CommonReturnBean;
import org.zxs.leader.control.dao.interf.IChatGroupInfoMapper;
import org.zxs.leader.control.dao.interf.IChatGroupMsgMapper;
import org.zxs.leader.control.dao.interf.IChatGroupUserMapper;
import org.zxs.leader.control.dao.interf.IMsgStatusMapper;
import org.zxs.leader.control.dao.interf.IOrgUserMapper;
import org.zxs.leader.control.dao.model.ChatGroupInfo;
import org.zxs.leader.control.dao.model.ChatGroupMsg;
import org.zxs.leader.control.dao.model.ChatGroupUser;
import org.zxs.leader.control.dao.model.MsgStatus;
import org.zxs.leader.control.dao.model.OrgUser;
import org.zxs.leader.control.dao.model.vo.output.ChatMemberOut;
import org.zxs.leader.control.dao.model.vo.output.rows.ChatGroupUserRow;
import org.zxs.leader.control.service.interf.IChatGroupUserService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Service
public class ChatGroupUserServiceImpl implements IChatGroupUserService {
	
	private static Log log = LogFactory.getLog(ChatGroupUserServiceImpl.class);
	
	@Resource
	private IChatGroupUserMapper chatGroupUserMapper;
	
	@Resource
	private IChatGroupInfoMapper chatGroupInfoMapper;
	
	@Resource
	private IChatGroupMsgMapper cgMsgMapper;
	
	@Resource
	private IMsgStatusMapper msgStatusMapper;
	
	@Resource
	private IOrgUserMapper orgUserMapper;

	@Override
	public boolean isUserInGroup(int userId, int cgId) {
		ChatGroupUser cgUser = new ChatGroupUser();
		cgUser.setChatGroupId(cgId);
		cgUser.setUserId(userId);
		return chatGroupUserMapper.selectCount(cgUser) > 0;
	}
	
	@Override
	public boolean isUserGroupOwner(int userId, int cgId) {
		ChatGroupUser cgUser = new ChatGroupUser();
		cgUser.setChatGroupId(cgId);
		cgUser.setUserId(userId);
		cgUser.setRole((byte) 0);
		return chatGroupUserMapper.selectCount(cgUser) > 0;
	}

	@Override
	@Transactional
	public CommonReturnBean<ChatMemberOut> addCgMember(int cgId, List<Integer> userArray) {
		CommonReturnBean<ChatMemberOut> addRet = new CommonReturnBean<>();
		ChatMemberOut addOut = new ChatMemberOut();
		addOut.setType(ChatMemberOut.TYPE_ADD);
		String sNames = "";
		String sIds = "";
		Date nowTime = new Date();
		
		ChatGroupInfo cgInfo = chatGroupInfoMapper.selectByPrimaryKey(cgId);
		if(null == cgInfo) {
			log.error("聊天群组[" + cgId + "]可能已解散，不能添加成员!");
			addRet.setErrorCode(-304);
			addRet.setErrorMsg("该聊天群组可能已解散，不能添加成员!");
			return addRet;
		}
		
		byte cgType = cgInfo.getType();
		
		for(Integer userId : userArray) {
			OrgUser member = orgUserMapper.selectByPrimaryKey(userId);
			String memberName = member.getRealName();
			
			ChatGroupUser cgUser = new ChatGroupUser();
			cgUser.setChatGroupId(cgId);
			cgUser.setUserId(userId);
			cgUser.setNickname(memberName);
			if(cgType == ChatGroupInfo.TYPE_WORK)
				cgUser.setRole(ChatGroupUser.ROLE_MEMBER);
			else
				cgUser.setRole(ChatGroupUser.ROLE_ADMIN);
			cgUser.setRemoveable(ChatGroupUser.REMOVE_ALLOW);
			cgUser.setCreateAt(nowTime);
			
			int isExist = chatGroupUserMapper.selectCount(cgUser);
			if(isExist > 0) { // 用户已存在
				log.error("用户[" + memberName + "]在群组[" + cgId + "]中已存在!");
				addRet.setErrorCode(-305);
				addRet.setErrorMsg("存在重复添加的群组成员！");
				return addRet;
			}
			
			int iSaveRet = chatGroupUserMapper.insert(cgUser);
			if(iSaveRet != 1) { // 插入失败
				log.error("用户[" + memberName + "]加入群组[" + cgId + "]失败!");
				addRet.setErrorCode(-306);
				addRet.setErrorMsg("添加群组成员失败！");
				return addRet;
			}
			
			if(!sNames.isEmpty()) {
				sNames += ",";
				sIds += ",";
			}
				
			sNames += memberName;
			sIds += userId;
		}
		
		if(cgInfo.getEnableNameUpdate() == 1) { // 可以修改组名 
			String groupName = cgInfo.getGroupName();
			if(groupName != null) {
				if(!groupName.isEmpty())
					groupName += ",";
				groupName += sNames;
			}else
				groupName = sNames;
			cgInfo.setGroupName(groupName);
			cgInfo.setUpdateAt(nowTime);
			int updCnt = chatGroupInfoMapper.updateByPrimaryKey(cgInfo);
			
			if(updCnt != 1) {
				log.error("用户加入群组[" + cgId + "]失败, 更改群组名失败!");
				addRet.setErrorCode(-307);
				addRet.setErrorMsg("添加群组成员失败, 更改群组名失败!");
				return addRet;
			}
		}
		int userCnt = userArray.size();
		
		// 往消息表添加一条“添加成员”记录
		ChatGroupMsg msg = new ChatGroupMsg();
		msg.setChatGroupId(cgId);
		msg.setChatType(ChatGroupMsg.TYPE_ADD_MEMBER);
		msg.setUserIds(sIds);
		msg.setUserNames(sNames);
		msg.setUserCnt(userCnt);
		msg.setCreateAt(nowTime);
		int iSaveMsgRet = cgMsgMapper.insert(msg);
		
		if(iSaveMsgRet != 1) {
			log.error("用户加入群组[" + cgId + "]失败, 插入添加成员消息记录失败!");
			addRet.setErrorCode(-308);
			addRet.setErrorMsg("添加群组成员失败, 插入添加成员消息记录失败!");
			return addRet;
		}
		
		// 添加消息状态记录
		Long msgId = msg.getId();
		ChatGroupUser userExp = new ChatGroupUser();
		userExp.setChatGroupId(cgId);
		List<ChatGroupUser> userList = chatGroupUserMapper.select(userExp);
		if(!userList.isEmpty()) {
			for(ChatGroupUser rcvUser : userList) {
				MsgStatus mStatus = new MsgStatus();
				mStatus.setChatGroupId(cgId);
				mStatus.setGroupMsgId(msgId);
				mStatus.setReadStatus(MsgStatus.STATUS_UNREAD);
				mStatus.setPushStatus(MsgStatus.STATUS_UNPUSH);
				mStatus.setUserId(rcvUser.getUserId());
				mStatus.setCreateAt(nowTime);
				mStatus.setUpdateAt(nowTime);
				int msgStatusRet = msgStatusMapper.insert(mStatus);
				if(msgStatusRet != 1) {
					// TODO 插入失败
				}
			}
		}
					
		addOut.setCount((short) userCnt);
		addOut.setsIds(sIds);
		addOut.setsNames(sNames);
		
		addRet.setErrorCode(0);
		addRet.setErrorMsg("添加群聊组成员成功！");
		addRet.setData(addOut);
		return addRet;
	}

	@Override
	@Transactional
	public CommonReturnBean<ChatMemberOut> removeCgMember(int cgId, List<Integer> userArray) {
		CommonReturnBean<ChatMemberOut> removeRet = new CommonReturnBean<>();
		ChatMemberOut removeOut = new ChatMemberOut();
		removeOut.setType(ChatMemberOut.TYPE_REMOVE);
		String sNames = "";
		String sIds = "";
		Date nowTime = new Date();
		
		ChatGroupInfo cgInfo = chatGroupInfoMapper.selectByPrimaryKey(cgId);
		if(null == cgInfo) {
			log.error("聊天群组[" + cgId + "]可能已解散，不能删除成员!");
			removeRet.setErrorCode(-304);
			removeRet.setErrorMsg("该聊天群组可能已解散!");
			return removeRet;
		}
		
		for(Integer userId : userArray) {
			OrgUser member = orgUserMapper.selectByPrimaryKey(userId);
			String realName = member.getRealName();
			
			ChatGroupUser cgUser = new ChatGroupUser();
			cgUser.setChatGroupId(cgId);
			cgUser.setUserId(userId);
//			cgUser.setRole(ChatGroupUser.ROLE_MEMBER);
			
//			int isExist = cgUserMapper.selectCount(cgUser);
			ChatGroupUser groupMember = chatGroupUserMapper.selectOne(cgUser);
			
			if(groupMember == null) { // 用户不存在
				log.error("用户[" + realName + "]在群组[" + cgId + "]中不存在!");
				removeRet.setErrorCode(-309);
				removeRet.setErrorMsg("不能移除不在该群组的成员！");
				return removeRet;
			}
			
			if(groupMember.getRemoveable() == 0) {
				log.error("用户[" + realName + "]在群组[" + cgId + "]中不能被删除!");
				removeRet.setErrorCode(-313);
				removeRet.setErrorMsg("不能移除群组中的固定成员[" + cgUser.getNickname() + "]！");
				return removeRet;
			}
			
			// 删除未读消息
			MsgStatus msgStatus = new MsgStatus();
			msgStatus.setReadStatus(MsgStatus.STATUS_UNREAD);
			msgStatus.setChatGroupId(cgId);
			msgStatus.setUserId(userId);
			msgStatusMapper.delete(msgStatus);
			
			int iSaveRet = chatGroupUserMapper.delete(cgUser);
			if(iSaveRet != 1) { // 删除失败
				log.error("删除群组[" + cgId + "]用户[" + realName + "]失败!");
				removeRet.setErrorCode(-310);
				removeRet.setErrorMsg("删除群组成员失败！");
				return removeRet;
			}
			String memberName = realName;
			
			if(!sNames.isEmpty()) {
				sNames += ",";
				sIds += ",";
			}
				
			sNames += memberName;
			sIds += userId;
		}
		
		if(cgInfo.getEnableNameUpdate() == 1) { // 可以修改组名 
			String groupNameNew = chatGroupUserMapper.selectUserNameWithoutRemoveArray(cgId, userArray);
			cgInfo.setGroupName(groupNameNew);
			cgInfo.setUpdateAt(nowTime);
			int updCnt = chatGroupInfoMapper.updateByPrimaryKey(cgInfo);
			
			if(updCnt != 1) {
				log.error("移除群组[" + cgId + "]用户失败, 更改群组名失败!");
				removeRet.setErrorCode(-311);
				removeRet.setErrorMsg("添加群组成员失败, 更改群组名失败!");
				return removeRet;
			}
		}
		int userCnt = userArray.size();
		
		// 往消息表添加一条“删除成员”记录
		ChatGroupMsg msg = new ChatGroupMsg();
		msg.setChatGroupId(cgId);
		msg.setChatType(ChatGroupMsg.TYPE_REMOVE_MEMBER);
		msg.setUserIds(sIds);
		msg.setUserNames(sNames);
		msg.setUserCnt(userCnt);
		msg.setCreateAt(nowTime);
		int iSaveMsgRet = cgMsgMapper.insert(msg);
		
		if(iSaveMsgRet != 1) {
			log.error("删除群组[" + cgId + "]成员失败, 插入添加成员消息记录失败!");
			removeRet.setErrorCode(-312);
			removeRet.setErrorMsg("移除群组成员失败, 插入删除成员消息记录失败!");
			return removeRet;
		}
		
		// 添加消息状态记录
		Long msgId = msg.getId();
		ChatGroupUser userExp = new ChatGroupUser();
		userExp.setChatGroupId(cgId);
		List<ChatGroupUser> userList = chatGroupUserMapper.select(userExp);
		if(!userList.isEmpty()) {
			for(ChatGroupUser rcvUser : userList) {
				MsgStatus mStatus = new MsgStatus();
				mStatus.setChatGroupId(cgId);
				mStatus.setGroupMsgId(msgId);
				mStatus.setReadStatus(MsgStatus.STATUS_UNREAD);
				mStatus.setPushStatus(MsgStatus.STATUS_UNPUSH);
				mStatus.setUserId(rcvUser.getUserId());
				mStatus.setCreateAt(nowTime);
				mStatus.setUpdateAt(nowTime);
				int msgStatusRet = msgStatusMapper.insert(mStatus);
				if(msgStatusRet != 1) {
					// TODO 插入失败
				}
			}
		}
					
		removeOut.setCount((short) userCnt);
		removeOut.setsIds(sIds);
		removeOut.setsNames(sNames);
		
		removeRet.setErrorCode(0);
		removeRet.setErrorMsg("删除群聊组成员成功！");
		removeRet.setData(removeOut);
		return removeRet;
	}

	@Override
	public List<Integer> getUserByCgId(int cgId, Integer selfId) {
		return chatGroupUserMapper.selectUserIdByCgId(cgId, selfId);
	}

	@Override
	public boolean isGroupAdmin(int userId, int cgId) {
		ChatGroupUser cond = new ChatGroupUser();
		cond.setChatGroupId(cgId);
		cond.setUserId(userId);
		ChatGroupUser user = chatGroupUserMapper.selectOne(cond);
		if(null == user)
			return false;
		int role = user.getRole();
		return role < 2;
	}

	@Override
	public PageInfo<ChatGroupUserRow> getChatGroupUserOutsByPage(Integer pageNum, Integer pageSize, String keyword) {
		PageHelper.startPage(pageNum, pageSize);
		List<ChatGroupUserRow> rows = null;
		if (null == keyword) {
			rows = this.chatGroupUserMapper.selectAllOuts();
		} else {
			rows = this.chatGroupUserMapper.selectRowsByKeyword(keyword);
		}
		return new PageInfo<>(rows);
	}

	@Override
	public ChatGroupUser findById(Integer id) {
		return this.chatGroupUserMapper.selectByPrimaryKey(id);
	}

	@Override
	public int update(ChatGroupUser chatGroupUser) {
		return this.chatGroupUserMapper.updateByPrimaryKey(chatGroupUser);
	}

}
