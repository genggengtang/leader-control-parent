package org.zxs.leader.control.dao.model.vo.output.rows;

import org.zxs.leader.control.dao.model.LeaderGroup;

public class LeaderGroupRow extends LeaderGroup {
	
	private String cgIdTrans;
	
	private String userIdTrans;

	public String getCgIdTrans() {
		return cgIdTrans;
	}

	public void setCgIdTrans(String cgIdTrans) {
		this.cgIdTrans = cgIdTrans;
	}

	public String getUserIdTrans() {
		return userIdTrans;
	}

	public void setUserIdTrans(String userIdTrans) {
		this.userIdTrans = userIdTrans;
	}

}
