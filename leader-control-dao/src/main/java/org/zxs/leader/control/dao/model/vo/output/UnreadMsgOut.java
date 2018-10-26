package org.zxs.leader.control.dao.model.vo.output;

import java.util.List;

/**
 * 未读消息数
 * @author Administrator
 *
 */
public class UnreadMsgOut {
	private Integer userId; // 用户编号
	private Integer totalUnreadNum; // 所有未读消息总数
	private List<ChatGroupSimpleOut> unreadList; // 群聊组未读消息集合
	private Integer unreadTopicNum; // 所有未读随手拍消息总数	
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getTotalUnreadNum() {
		return totalUnreadNum;
	}
	public void setTotalUnreadNum(Integer totalUnreadNum) {
		this.totalUnreadNum = totalUnreadNum;
	}
	public List<ChatGroupSimpleOut> getUnreadList() {
		return unreadList;
	}
	public void setUnreadList(List<ChatGroupSimpleOut> unreadList) {
		this.unreadList = unreadList;
	}
	public Integer getUnreadTopicNum() {
		return unreadTopicNum;
	}
	public void setUnreadTopicNum(Integer unreadTopicNum) {
		this.unreadTopicNum = unreadTopicNum;
	}
	
}
