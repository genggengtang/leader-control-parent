package org.zxs.leader.control.dao.model.vo.output.rows;

import org.zxs.leader.control.dao.model.PrjMapLine;

public class PrjMapLineRow extends PrjMapLine {
	
	private String prjTypeTrans;
	
	private String prjIdTrans;

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

}
