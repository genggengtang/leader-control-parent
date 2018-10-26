package org.zxs.leader.control.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zxs.leader.control.dao.interf.IChatGroupMsgMapper;
import org.zxs.leader.control.dao.interf.IMsgStatusMapper;
import org.zxs.leader.control.dao.interf.ITopicUnreadMapper;
import org.zxs.leader.control.dao.model.MsgStatus;
import org.zxs.leader.control.dao.model.MsgStatusExample;
import org.zxs.leader.control.dao.model.MsgStatusExample.Criteria;
import org.zxs.leader.control.dao.model.TopicUnread;
import org.zxs.leader.control.dao.model.TopicUnreadExample;
import org.zxs.leader.control.dao.model.vo.output.ChatMsgOut;
import org.zxs.leader.control.dao.model.vo.output.UnreadMsgOut;
import org.zxs.leader.control.service.interf.IMsgStatusService;


@Service
public class MsgStatusServiceImpl implements IMsgStatusService {
	private static Log log = LogFactory.getLog(MsgStatusServiceImpl.class);

	@Resource
	private IMsgStatusMapper msgStatusMapper;
	
	@Resource
	private IChatGroupMsgMapper cgMsgMapper;
	
	@Resource
	private ITopicUnreadMapper topicUnreadMapper;

	@Override
	@Transactional
	public int updateMsgReadStatus(int userId, long msgId) {
		MsgStatus mStatus = new MsgStatus();
		mStatus.setGroupMsgId(msgId);
		mStatus.setUserId(userId);
		mStatus.setUpdateAt(new Date());
		return msgStatusMapper.updateByMsgIdAndUserId(msgId, userId);
	}

	@Override
	@Transactional
	public int updateMsgReadStatusByUserIdAndCgId(int userId, long cgId) {
		return msgStatusMapper.updateByCgIdAndUserId(cgId, userId);
	}

	@Override
	public int getTotalUnreadMsgCnt(int userId) {
		MsgStatusExample example = new MsgStatusExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		criteria.andReadStatusEqualTo(MsgStatus.STATUS_UNREAD);
		criteria.andChatGroupIdNotEqualTo(0);
		return msgStatusMapper.selectCountByExample(example);
	}

	@Override
	public UnreadMsgOut getUnreadMsgCnt(int userId) {
		log.info("获取用户[" + userId + "]未读消息！");
		UnreadMsgOut unreadRet = new UnreadMsgOut();
		unreadRet.setUserId(userId);
		int totalUnread = getTotalUnreadMsgCnt(userId);
		log.info("用户[" + userId + "]未读消息总数为[" + totalUnread + "]");
		unreadRet.setTotalUnreadNum(totalUnread);
		
		unreadRet.setUnreadList(msgStatusMapper.selectUnreadCount(userId));
		return unreadRet;
	}

	@Override
	@Transactional
	public int delete(MsgStatus msgStatus) {
		return msgStatusMapper.delete(msgStatus);
	}

	@Override
	public List<String> getUnpushSysMsg(int userId) {
		return cgMsgMapper.selectUnpushSysMsg(userId);
	}

	@Override
	public int getUnpushChatCnt(int userId) {
		MsgStatusExample example = new MsgStatusExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		criteria.andPushStatusEqualTo(MsgStatus.STATUS_UNPUSH);
		criteria.andChatGroupIdNotEqualTo(0);
		return msgStatusMapper.selectCountByExample(example);
	}

	@Override
	@Transactional
	public int updateAllPushStatus(int userId) {
		MsgStatusExample example = new MsgStatusExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		criteria.andPushStatusEqualTo(MsgStatus.STATUS_UNPUSH);
		
		MsgStatus ms = new MsgStatus();
		ms.setPushStatus(MsgStatus.STATUS_PUSH);
		ms.setUpdateAt(new Date());
		int msgCnt = msgStatusMapper.updateByExampleSelective(ms, example);
		
		TopicUnreadExample tuExample = new TopicUnreadExample();
		org.zxs.leader.control.dao.model.TopicUnreadExample.Criteria tuCriteria = tuExample.createCriteria();
		tuCriteria.andUserIdEqualTo(userId);
		tuCriteria.andPushStatusEqualTo(MsgStatus.STATUS_UNPUSH);
		
		TopicUnread tu = new TopicUnread();
		tu.setPushStatus((byte) 1);
		tu.setUpdateAt(new Date());
		int tuCnt = topicUnreadMapper.updateByExampleSelective(tu, tuExample);
		return msgCnt + tuCnt;
	}


}
