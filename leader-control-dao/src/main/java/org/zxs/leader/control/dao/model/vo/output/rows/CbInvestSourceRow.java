package org.zxs.leader.control.dao.model.vo.output.rows;

import org.zxs.leader.control.dao.model.CbInvestSource;

public class CbInvestSourceRow extends CbInvestSource{
	
	private String prjPlanIdTrans;
	
	private String sourceNoTrans;
	
	private String sourceTypeNoTrans;
	
	public String getPrjPlanIdTrans() {
		return prjPlanIdTrans;
	}

	public void setPrjPlanIdTrans(String prjPlanIdTrans) {
		this.prjPlanIdTrans = prjPlanIdTrans;
	}

	public String getSourceNoTrans() {
		return sourceNoTrans;
	}

	public void setSourceNoTrans(String sourceNoTrans) {
		this.sourceNoTrans = sourceNoTrans;
	}

	public String getSourceTypeNoTrans() {
		return sourceTypeNoTrans;
	}

	public void setSourceTypeNoTrans(String sourceTypeNoTrans) {
		this.sourceTypeNoTrans = sourceTypeNoTrans;
	}
	
}
