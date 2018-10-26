package org.zxs.leader.control.dao.model.vo.output.rows;

import org.zxs.leader.control.dao.model.OrgUser;

public class OrgUserRow extends OrgUser {
	
	private String orgIdTrans;
	
	private String phoneListTypeTrans;

	public String getOrgIdTrans() {
		return orgIdTrans;
	}

	public void setOrgIdTrans(String orgIdTrans) {
		this.orgIdTrans = orgIdTrans;
	}

	public String getPhoneListTypeTrans() {
		return phoneListTypeTrans;
	}

	public void setPhoneListTypeTrans(String phoneListTypeTrans) {
		this.phoneListTypeTrans = phoneListTypeTrans;
	}

}
