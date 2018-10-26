package org.zxs.leader.control.dao.model.vo.query;

import org.zxs.leader.control.dao.model.OrgUser;

public class OrgUserQuery extends OrgUser{
	private String inputPsw; // 输入密码

	public String getInputPsw() {
		return inputPsw;
	}

	public void setInputPsw(String inputPsw) {
		this.inputPsw = inputPsw;
	}
	
}
