package org.zxs.leader.control.dao.model.vo.output.rows;

import org.zxs.leader.control.dao.model.PrjAttachment;

public class PrjAttachmentRow extends PrjAttachment {
	
	private String prjTypeTrans;
	
	private String prjIdTrans;
	
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

	public String getMnIdTrans() {
		return mnIdTrans;
	}

	public void setMnIdTrans(String mnIdTrans) {
		this.mnIdTrans = mnIdTrans;
	}
	
}
