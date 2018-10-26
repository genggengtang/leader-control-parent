package org.zxs.leader.control.dao.model.vo.output.rows;

import org.zxs.leader.control.dao.model.CityPlanPrj;

public class CityPlanPrjRow extends CityPlanPrj {
	
	private String typeTrans;
	
	private String labelTrans;
	
	private String planStatusTrans;
	
	private String areaTrans;
	
	private String areaAdminTrans;
	
	private String latestYearIdTrans;

	public String getTypeTrans() {
		return typeTrans;
	}

	public void setTypeTrans(String typeTrans) {
		this.typeTrans = typeTrans;
	}

	public String getLabelTrans() {
		return labelTrans;
	}

	public void setLabelTrans(String labelTrans) {
		this.labelTrans = labelTrans;
	}

	public String getPlanStatusTrans() {
		return planStatusTrans;
	}

	public void setPlanStatusTrans(String planStatusTrans) {
		this.planStatusTrans = planStatusTrans;
	}

	public String getAreaTrans() {
		return areaTrans;
	}

	public void setAreaTrans(String areaTrans) {
		this.areaTrans = areaTrans;
	}

	public String getAreaAdminTrans() {
		return areaAdminTrans;
	}

	public void setAreaAdminTrans(String areaAdminTrans) {
		this.areaAdminTrans = areaAdminTrans;
	}

	public String getLatestYearIdTrans() {
		return latestYearIdTrans;
	}

	public void setLatestYearIdTrans(String latestYearIdTrans) {
		this.latestYearIdTrans = latestYearIdTrans;
	}

}
