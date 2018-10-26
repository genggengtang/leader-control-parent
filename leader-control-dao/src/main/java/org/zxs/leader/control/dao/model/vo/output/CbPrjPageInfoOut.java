package org.zxs.leader.control.dao.model.vo.output;

import org.zxs.leader.control.dao.model.CbPlanPrj;

/**
 * 城建计划项目列表信息
 * @author Administrator
 *
 */
public class CbPrjPageInfoOut extends CbPlanPrj{
	
	private Integer accmPlanInvest; // 当年至本月累计计划投资
	
	private Integer accmActualInvest; // 当年至本月累计实际投资
	
	private Integer yearPlanInvest; // 当年计划投资
	
	private Short completeRateByMonth; // 月度投资完成百分比
	
	private Short completeRateByYear; // 年度投资完成百分比
	
	private String ownerName; // 业主单位，多个以逗号分隔
	
	private String labels; // 重大项目分类标签
	
	private String[] labelArray; // 重大项目分类标签数组
	
	private String completeStatusDis; // 完成状态
	
	private Integer buildStatus; // 建设状态，1为开工，2为在建
	
	private String cbFeatureDis; // 城建性质释义
	
	private Integer isCurrentPlan; // 是否最新期数
	
	private Integer prjStartYear; // 项目计划开工年
	
	private Integer prjEndYear; // 项目计划结束年
	
	private Integer prjInvestTotal; // 项目总投资
	
	public Integer getAccmPlanInvest() {
		return accmPlanInvest;
	}
	public void setAccmPlanInvest(Integer accmPlanInvest) {
		this.accmPlanInvest = accmPlanInvest;
	}
	public Integer getAccmActualInvest() {
		return accmActualInvest;
	}
	public void setAccmActualInvest(Integer accmActualInvest) {
		this.accmActualInvest = accmActualInvest;
	}
	public Integer getYearPlanInvest() {
		return yearPlanInvest;
	}
	public void setYearPlanInvest(Integer yearPlanInvest) {
		this.yearPlanInvest = yearPlanInvest;
	}
	public Short getCompleteRateByMonth() {
		return completeRateByMonth;
	}
	public void setCompleteRateByMonth(Short completeRateByMonth) {
		this.completeRateByMonth = completeRateByMonth;
	}
	public Short getCompleteRateByYear() {
		return completeRateByYear;
	}
	public void setCompleteRateByYear(Short completeRateByYear) {
		this.completeRateByYear = completeRateByYear;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getLabels() {
		return labels;
	}
	public void setLabels(String labels) {
		this.labels = labels;
		if(null != labels && !labels.isEmpty()) {
			this.labelArray = labels.split(",");
		}
	}
	public String[] getLabelArray() {
		return labelArray;
	}
	public void setLabelArray(String[] labelArray) {
		this.labelArray = labelArray;
	}
	public String getCompleteStatusDis() {
		return completeStatusDis;
	}
	public void setCompleteStatusDis(String completeStatusDis) {
		this.completeStatusDis = completeStatusDis;
	}
	public Integer getBuildStatus() {
		return buildStatus;
	}
	public void setBuildStatus(Integer buildStatus) {
		this.buildStatus = buildStatus;
	}
	public String getCbFeatureDis() {
		return cbFeatureDis;
	}
	public void setCbFeatureDis(String cbFeatureDis) {
		this.cbFeatureDis = cbFeatureDis;
	}
	public Integer getIsCurrentPlan() {
		return isCurrentPlan;
	}
	public void setIsCurrentPlan(Integer isCurrentPlan) {
		this.isCurrentPlan = isCurrentPlan;
	}
	public Integer getPrjStartYear() {
		return prjStartYear;
	}
	public void setPrjStartYear(Integer prjStartYear) {
		this.prjStartYear = prjStartYear;
	}
	public Integer getPrjEndYear() {
		return prjEndYear;
	}
	public void setPrjEndYear(Integer prjEndYear) {
		this.prjEndYear = prjEndYear;
	}
	public Integer getPrjInvestTotal() {
		return prjInvestTotal;
	}
	public void setPrjInvestTotal(Integer prjInvestTotal) {
		this.prjInvestTotal = prjInvestTotal;
	}
	
}
