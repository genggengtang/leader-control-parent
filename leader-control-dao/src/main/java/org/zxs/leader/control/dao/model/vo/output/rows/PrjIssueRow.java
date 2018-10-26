package org.zxs.leader.control.dao.model.vo.output.rows;

import org.zxs.leader.control.dao.model.PrjIssue;

public class PrjIssueRow extends PrjIssue {
	
	private String prjTypeTrans;
	
	private String prjIdTrans;
	
	private String typeTrans;
	
	private String mnIdTrans;

	public String getPrjTypeTrans() {
		return prjTypeTrans;
	}

	public void setPrjTypeTrans(String prjTypeTrans) {
		this.prjTypeTrans = prjTypeTrans;
	}

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

	public String getMnIdTrans() {
		return mnIdTrans;
	}

	public void setMnIdTrans(String mnIdTrans) {
		this.mnIdTrans = mnIdTrans;
	}

}
