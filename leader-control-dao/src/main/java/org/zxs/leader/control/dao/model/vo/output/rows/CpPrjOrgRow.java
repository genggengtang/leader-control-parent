package org.zxs.leader.control.dao.model.vo.output.rows;

import org.zxs.leader.control.dao.model.CpPrjOrg;

public class CpPrjOrgRow extends CpPrjOrg{
	
	private String prjTypeTrans;
	
	private String cpPrjIdTrans;
	
	private String orgIdTrans;
	
	private String relateTypeTrans;

	public String getPrjTypeTrans() {
		return prjTypeTrans;
	}

	public void setPrjTypeTrans(String prjTypeTrans) {
		this.prjTypeTrans = prjTypeTrans;
	}

	public String getCpPrjIdTrans() {
		return cpPrjIdTrans;
	}

	public void setCpPrjIdTrans(String cpPrjIdTrans) {
		this.cpPrjIdTrans = cpPrjIdTrans;
	}

	public String getOrgIdTrans() {
		return orgIdTrans;
	}

	public void setOrgIdTrans(String orgIdTrans) {
		this.orgIdTrans = orgIdTrans;
	}

	public String getRelateTypeTrans() {
		return relateTypeTrans;
	}

	public void setRelateTypeTrans(String relateTypeTrans) {
		this.relateTypeTrans = relateTypeTrans;
	}
	
}
