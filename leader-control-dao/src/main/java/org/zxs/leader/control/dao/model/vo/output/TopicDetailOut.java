package org.zxs.leader.control.dao.model.vo.output;

import java.util.List;

public class TopicDetailOut extends TopicPicOut{
	private List<TopicCommentOut> commentList; // 评论列表

	public List<TopicCommentOut> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<TopicCommentOut> commentList) {
		this.commentList = commentList;
	}
	
}
