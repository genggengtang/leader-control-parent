package org.zxs.leader.control.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zxs.leader.control.dao.interf.IChatGroupMsgMapper;
import org.zxs.leader.control.dao.interf.IChatGroupUserMapper;
import org.zxs.leader.control.dao.interf.IMsgStatusMapper;
import org.zxs.leader.control.dao.interf.IOrgUserMapper;
import org.zxs.leader.control.dao.model.ChatGroupMsg;
import org.zxs.leader.control.dao.model.ChatGroupUser;
import org.zxs.leader.control.dao.model.ChatGroupUserExample;
import org.zxs.leader.control.dao.model.ChatGroupUserExample.Criteria;
import org.zxs.leader.control.dao.model.MsgStatus;
import org.zxs.leader.control.dao.model.OrgUser;
import org.zxs.leader.control.dao.model.vo.output.ChatMsgOut;
import org.zxs.leader.control.dao.model.vo.query.MsgHisQuery;
import org.zxs.leader.control.service.interf.IChatGroupMsgService;
import org.zxs.utils.CommonUtil;
import com.qiniu.common.QiniuException;

@Service
public class ChatGroupMsgServiceImpl implements IChatGroupMsgService {

	@Resource
	private IChatGroupUserMapper cgUserMapper;
	
	@Resource
	private IChatGroupMsgMapper cgMsgMapper;
	
	@Resource
	private IMsgStatusMapper msgStatusMapper;
	
	@Resource
	private IOrgUserMapper orgUserMapper;

	@Override
	@Transactional
	public ChatMsgOut saveChatMsg(ChatMsgOut data, Integer chatRoom) throws QiniuException, IOException {
		int submitMsgType = data.getShMsgType();
		ChatGroupMsg msg = new ChatGroupMsg();
		msg.setChatGroupId(chatRoom);
		msg.setFromId(data.getUserId());
		msg.setFromName(data.getUserName());
		
		if(submitMsgType == ChatGroupMsg.TYPE_PIC || submitMsgType == ChatGroupMsg.TYPE_DOC) { // 图片或文件消息
			msg.setChatType(submitMsgType);
			String fileName = data.getFileName();
			
			msg.setFileName(fileName);
			msg.setFileUrl(data.getFileUrl());
		} else if(submitMsgType == ChatGroupMsg.TYPE_TOPIC) { // 随手拍
			msg.setChatType(submitMsgType);
			String fileName = data.getFileName();
			
			msg.setFileName(fileName);
			msg.setFileUrl(data.getFileUrl());
			msg.setRelateId(data.getTopicId());
			msg.setContent(data.getMsgContent());
		} else {
			msg.setContent(data.getMsgContent());
			msg.setChatType(ChatGroupMsg.TYPE_MSSAGE);
			
			data.setShMsgType(ChatGroupMsg.TYPE_MSSAGE);
		}
		
		Date nowtime = new Date();
		msg.setCreateAt(nowtime);
		
		int iSaveRet = cgMsgMapper.insert(msg);
		if(iSaveRet == 1) { // 消息记录插入成功,添加消息阅读状态记录
			// 获取该群组所有成员，除本人
			Long msgId = msg.getId();
			ChatGroupUserExample userExp = new ChatGroupUserExample();
			Criteria userCriteria = userExp.createCriteria();
			userCriteria.andChatGroupIdEqualTo(chatRoom);
//			userCriteria.andUserIdNotEqualTo(data.getUserId());
			List<ChatGroupUser> userList = cgUserMapper.selectByExample(userExp);
			if(!userList.isEmpty()) {
				for(ChatGroupUser rcvUser : userList) {
					MsgStatus mStatus = new MsgStatus();
					mStatus.setChatGroupId(chatRoom);
					mStatus.setGroupMsgId(msgId);
					mStatus.setReadStatus(MsgStatus.STATUS_UNREAD);
					mStatus.setPushStatus(MsgStatus.STATUS_UNPUSH);
					mStatus.setUserId(rcvUser.getUserId());
					mStatus.setCreateAt(nowtime);
					mStatus.setUpdateAt(nowtime);
					int msgStatusRet = msgStatusMapper.insert(mStatus);
					if(msgStatusRet != 1) {
						// TODO 插入失败
					}
				}
			}
			data.setMsgId(msgId);
			data.setMsgAt(CommonUtil.formMysqlDate(nowtime));
			return data;
		}
		
		return null;
	}

	@Override
	public List<ChatMsgOut> getLatestMsgHisById(MsgHisQuery query) {
		return cgMsgMapper.selectLatestMsgHis(query);
	}

	@Override
	@Transactional
	public int saveSYSMsg(String sysMsg) {
		Date nowTime = new Date();
		ChatGroupMsg cgMsg = new ChatGroupMsg();
		cgMsg.setChatGroupId(0);
		cgMsg.setChatType(ChatGroupMsg.TYPE_MSSAGE);
		cgMsg.setContent(sysMsg);
		cgMsg.setCreateAt(nowTime);
		int insertCnt = cgMsgMapper.insertSelective(cgMsg);
		if(insertCnt == 1) { // 消息记录保存成功
			long msgId = cgMsg.getId();
			List<OrgUser> userList = orgUserMapper.selectAll();
			for(OrgUser user : userList) {
				// 添加未读、未推送消息记录
				MsgStatus mStatus = new MsgStatus();
				mStatus.setChatGroupId(0);
				mStatus.setGroupMsgId(msgId);
				mStatus.setReadStatus(MsgStatus.STATUS_UNREAD);
				mStatus.setPushStatus(MsgStatus.STATUS_UNPUSH);
				mStatus.setUserId(user.getId());
				mStatus.setCreateAt(nowTime);
				mStatus.setUpdateAt(nowTime);
				int msgStatusRet = msgStatusMapper.insert(mStatus);
				if(msgStatusRet != 1) {
					// TODO 插入失败
				}
			}
			
		}
		return insertCnt;
	}

}
