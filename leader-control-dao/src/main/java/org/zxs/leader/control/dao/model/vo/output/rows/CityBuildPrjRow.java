package org.zxs.leader.control.dao.model.vo.output.rows;

import org.zxs.leader.control.dao.model.CityBuildPrj;

public class CityBuildPrjRow extends CityBuildPrj {
	
	private String prjDbNoTrans;
	
	private String currentPlanNoTrans;
	
	public String getPrjDbNoTrans() {
		return prjDbNoTrans;
	}

	public void setPrjDbNoTrans(String prjDbNoTrans) {
		this.prjDbNoTrans = prjDbNoTrans;
	}

	public String getCurrentPlanNoTrans() {
		return currentPlanNoTrans;
	}

	public void setCurrentPlanNoTrans(String currentPlanNoTrans) {
		this.currentPlanNoTrans = currentPlanNoTrans;
	}

}
