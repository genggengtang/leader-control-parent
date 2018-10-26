package org.zxs.leader.control.dao.model.vo.output.rows;

import org.zxs.leader.control.dao.model.ChatGroupUser;

public class ChatGroupUserRow extends ChatGroupUser {
	
	private String chatGroupIdTrans;

	public String getChatGroupIdTrans() {
		return chatGroupIdTrans;
	}

	public void setChatGroupIdTrans(String chatGroupIdTrans) {
		this.chatGroupIdTrans = chatGroupIdTrans;
	}

}
