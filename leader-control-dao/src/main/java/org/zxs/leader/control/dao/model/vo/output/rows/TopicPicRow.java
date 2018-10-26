package org.zxs.leader.control.dao.model.vo.output.rows;

import org.zxs.leader.control.dao.model.TopicPic;

public class TopicPicRow extends TopicPic {
	
	private String sendUserIdTrans;
	
	private String receiveCgIdTrans;

	public String getSendUserIdTrans() {
		return sendUserIdTrans;
	}

	public void setSendUserIdTrans(String sendUserIdTrans) {
		this.sendUserIdTrans = sendUserIdTrans;
	}

	public String getReceiveCgIdTrans() {
		return receiveCgIdTrans;
	}

	public void setReceiveCgIdTrans(String receiveCgIdTrans) {
		this.receiveCgIdTrans = receiveCgIdTrans;
	}
	
}
