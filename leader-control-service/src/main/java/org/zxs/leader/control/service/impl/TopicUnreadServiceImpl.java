package org.zxs.leader.control.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zxs.leader.control.dao.interf.ITopicCommentMapper;
import org.zxs.leader.control.dao.interf.ITopicUnreadMapper;
import org.zxs.leader.control.dao.model.TopicComment;
import org.zxs.leader.control.dao.model.TopicUnread;
import org.zxs.leader.control.dao.model.TopicUnreadExample;
import org.zxs.leader.control.dao.model.TopicUnreadExample.Criteria;
import org.zxs.leader.control.service.interf.ITopicUnreadService;


@Service
public class TopicUnreadServiceImpl implements ITopicUnreadService {

	@Resource
	private ITopicCommentMapper topicCommentMapper;
	
	@Resource
	private ITopicUnreadMapper topicUnreadMapper;

	@Override
	@Transactional
	public int updateUnreadCommentStatus(int topicId, int userId) {
		TopicUnreadExample example = new TopicUnreadExample();
		Criteria criteria = example.createCriteria();
		criteria.andTopicIdEqualTo(topicId);
		criteria.andUserIdEqualTo(userId);
		criteria.andCommentIdIsNotNull();
		criteria.andReadStatusEqualTo((byte) 0);
		
		TopicUnread updRecord = new TopicUnread();
		updRecord.setReadStatus((byte) 1);
		updRecord.setUpdateAt(new Date());
		return topicUnreadMapper.updateByExampleSelective(updRecord, example);
	}

	@Override
	public int getMyUnreadNum(int userId) {
		TopicUnread unreadRecord = new TopicUnread();
		unreadRecord.setUserId(userId);
		unreadRecord.setReadStatus((byte) 0);
		return topicUnreadMapper.selectCount(unreadRecord);
	}

	@Override
	public int getUnpushTopicCnt(int userId) {
		TopicUnread unreadRecord = new TopicUnread();
		unreadRecord.setUserId(userId);
		unreadRecord.setPushStatus((byte) 0);
		return topicUnreadMapper.selectCount(unreadRecord);
	}


}
