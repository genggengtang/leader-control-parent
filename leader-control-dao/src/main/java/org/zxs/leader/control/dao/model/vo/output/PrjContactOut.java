package org.zxs.leader.control.dao.model.vo.output;

import org.zxs.leader.control.dao.model.PrjContact;

/**
 * 项目相关人员信息
 * @author Administrator
 */
public class PrjContactOut extends PrjContact {

	private String orgName;
	
	private String userName;
	
	private String mobilePhone;

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

}
