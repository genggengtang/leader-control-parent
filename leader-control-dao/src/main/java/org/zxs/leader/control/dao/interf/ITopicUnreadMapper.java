package org.zxs.leader.control.dao.interf;

import org.zxs.leader.control.dao.model.TopicUnread;

import tk.mybatis.mapper.common.Mapper;

public interface ITopicUnreadMapper extends Mapper<TopicUnread>{

	/**
	 * 更新未读评论的状态
	 * @param topicId
	 * @param userId
	 * @return
	 */
	// int updateUnreadCommentStatus(int topicId, int userId);
}