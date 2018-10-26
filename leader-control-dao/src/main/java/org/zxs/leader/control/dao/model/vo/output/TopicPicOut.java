package org.zxs.leader.control.dao.model.vo.output;

import org.zxs.leader.control.dao.model.TopicPic;

public class TopicPicOut extends TopicPic{
	private String sendUserName; // 主题发起者姓名
	private String receiveCgName; // 主题接收群聊组名称
	private String contentSub; // 内容摘要
	private Integer commentNum; // 总评论数
	private Integer unreadNum; // 未回复主题或未读评论数
	private Integer isAuthor; // 是否主题发起者
	private String commentStatus; // 回复状态描述
	private String receiveUserNames; // 主题接收用户名称，多个以逗号分隔
	private String[] receiveUserList; // 主题接收用户集合
	private String receiveUserNamesSub; // 主题接收用户简称
	
	public String getSendUserName() {
		return sendUserName;
	}
	public void setSendUserName(String sendUserName) {
		this.sendUserName = sendUserName;
	}
	public String getReceiveCgName() {
		return receiveCgName;
	}
	public void setReceiveCgName(String receiveCgName) {
		this.receiveCgName = receiveCgName;
	}
	public String getContentSub() {
		return contentSub;
	}
	public void setContentSub(String contentSub) {
		this.contentSub = contentSub;
		if(getContent().length() > this.contentSub.length()) {
			this.contentSub += "...";
		}
	}
	public Integer getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(Integer commentNum) {
		this.commentNum = commentNum;
	}
	public Integer getUnreadNum() {
		return unreadNum;
	}
	public void setUnreadNum(Integer unreadNum) {
		this.unreadNum = unreadNum;
	}
	public String getCommentStatus() {
		return commentStatus;
	}
	public void setCommentStatus(String commentStatus) {
		if(isAuthor == 1) {
			this.commentStatus = "";
		}else {
			this.commentStatus = commentStatus;
		}
	}
	public Integer getIsAuthor() {
		return isAuthor;
	}
	public void setIsAuthor(Integer isAuthor) {
		this.isAuthor = isAuthor;
	}
	public String getReceiveUserNames() {
		return receiveUserNames;
	}
	public void setReceiveUserNames(String receiveUserNames) {
		this.receiveUserNames = receiveUserNames;
		if(null != receiveUserNames && !receiveUserNames.isEmpty()) {
			this.receiveUserList = receiveUserNames.split(",");
			if(this.receiveUserList.length > 5) {
				this.receiveUserNamesSub = "";
				for(int i=0;i<5;i++) {
					if(i > 0)
						this.receiveUserNamesSub += ",";
					this.receiveUserNamesSub += receiveUserList[i];
				}
				this.receiveUserNamesSub += "...";
			}else {
				this.receiveUserNamesSub = this.receiveUserNames;
			}
		}
	}
	public String[] getReceiveUserList() {
		return receiveUserList;
	}
	public void setReceiveUserList(String[] receiveUserList) {
		this.receiveUserList = receiveUserList;
	}
	public String getReceiveUserNamesSub() {
		return receiveUserNamesSub;
	}
	public void setReceiveUserNamesSub(String receiveUserNamesSub) {
		this.receiveUserNamesSub = receiveUserNamesSub;
	}
	
}
