package org.zxs.leader.control.dao.model.vo.output;

/**
 * 项目月报简要信息
 * @author Administrator
 */
public class PrjMonthSimpleOut {
	
	private Integer month;
	
	private Integer accmPlanInvest2Month; // 当年至本月累计计划投资额
	
	private Integer accmActualInvest2Month; // 当年至本月累计实际投资额

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getAccmPlanInvest2Month() {
		return accmPlanInvest2Month;
	}

	public void setAccmPlanInvest2Month(Integer accmPlanInvest2Month) {
		this.accmPlanInvest2Month = accmPlanInvest2Month;
	}

	public Integer getAccmActualInvest2Month() {
		return accmActualInvest2Month;
	}

	public void setAccmActualInvest2Month(Integer accmActualInvest2Month) {
		this.accmActualInvest2Month = accmActualInvest2Month;
	}

	
}
