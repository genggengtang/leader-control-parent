package org.zxs.leader.control.dao.model.vo.output.rows;

import org.zxs.leader.control.dao.model.PrjContact;

public class PrjContactRow extends PrjContact {
	
	private String prjIdTrans;
	
	private String typeTrans;
	
	private String orgIdTrans;
	
	private String userIdTrans;

	public String getPrjIdTrans() {
		return prjIdTrans;
	}

	public void setPrjIdTrans(String prjIdTrans) {
		this.prjIdTrans = prjIdTrans;
	}

	public String getTypeTrans() {
		return typeTrans;
	}

	public void setTypeTrans(String typeTrans) {
		this.typeTrans = typeTrans;
	}

	public String getOrgIdTrans() {
		return orgIdTrans;
	}

	public void setOrgIdTrans(String orgIdTrans) {
		this.orgIdTrans = orgIdTrans;
	}

	public String getUserIdTrans() {
		return userIdTrans;
	}

	public void setUserIdTrans(String userIdTrans) {
		this.userIdTrans = userIdTrans;
	}
	
}
