package org.zxs.leader.control.dao.model.vo.output.rows;

import org.zxs.leader.control.dao.model.CbPlanPrj;

public class CbPlanPrjRow extends CbPlanPrj {
	
	private String planNoTrans;
	
	private String cbTypeTrans;
	
	private String labelTrans;
	
	private String rspLeaderIdTrans;
	
	private String cbFeatureTrans;
	
	private String extraCbTypeTrans;

	public String getPlanNoTrans() {
		return planNoTrans;
	}

	public void setPlanNoTrans(String planNoTrans) {
		this.planNoTrans = planNoTrans;
	}

	public String getCbTypeTrans() {
		return cbTypeTrans;
	}

	public void setCbTypeTrans(String cbTypeTrans) {
		this.cbTypeTrans = cbTypeTrans;
	}

	public String getLabelTrans() {
		return labelTrans;
	}

	public void setLabelTrans(String labelTrans) {
		this.labelTrans = labelTrans;
	}

	public String getRspLeaderIdTrans() {
		return rspLeaderIdTrans;
	}

	public void setRspLeaderIdTrans(String rspLeaderIdTrans) {
		this.rspLeaderIdTrans = rspLeaderIdTrans;
	}

	public String getCbFeatureTrans() {
		return cbFeatureTrans;
	}

	public void setCbFeatureTrans(String cbFeatureTrans) {
		this.cbFeatureTrans = cbFeatureTrans;
	}

	public String getExtraCbTypeTrans() {
		return extraCbTypeTrans;
	}

	public void setExtraCbTypeTrans(String extraCbTypeTrans) {
		this.extraCbTypeTrans = extraCbTypeTrans;
	}
	
}
