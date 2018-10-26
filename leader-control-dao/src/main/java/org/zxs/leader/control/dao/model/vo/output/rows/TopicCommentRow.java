package org.zxs.leader.control.dao.model.vo.output.rows;

import org.zxs.leader.control.dao.model.TopicComment;

public class TopicCommentRow extends TopicComment {
	
	private String commentUserIdTrans;

	public String getCommentUserIdTrans() {
		return commentUserIdTrans;
	}

	public void setCommentUserIdTrans(String commentUserIdTrans) {
		this.commentUserIdTrans = commentUserIdTrans;
	}

}
