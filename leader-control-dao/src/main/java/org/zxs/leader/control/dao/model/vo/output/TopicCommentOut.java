package org.zxs.leader.control.dao.model.vo.output;

import org.zxs.leader.control.dao.model.TopicComment;

public class TopicCommentOut extends TopicComment{
	private String commentUserName; // 评论者名称

	public String getCommentUserName() {
		return commentUserName;
	}

	public void setCommentUserName(String commentUserName) {
		this.commentUserName = commentUserName;
	}
	
}
