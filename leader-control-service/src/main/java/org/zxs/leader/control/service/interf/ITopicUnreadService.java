package org.zxs.leader.control.service.interf;

public interface ITopicUnreadService {
	
	/**
	 * 更新某一主题下，所有状态为未读的评论记录的状态
	 * @param topicId
	 * @param userId
	 * @return
	 */
	int updateUnreadCommentStatus(int topicId, int userId);

	/**
	 * 获取用户未读消息数
	 * @param userId
	 * @return
	 */
	int getMyUnreadNum(int userId);

	/**
	 * 获取随手拍为推送消息数
	 * @param userId
	 * @return
	 */
	int getUnpushTopicCnt(int userId);
}
