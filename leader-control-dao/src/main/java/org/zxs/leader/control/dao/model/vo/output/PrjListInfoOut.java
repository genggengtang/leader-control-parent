package org.zxs.leader.control.dao.model.vo.output;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 项目列表信息
 * @author Administrator
 *
 */
public class PrjListInfoOut {
	
	private Integer id;
	
	private String fullName;
	
	private String shortName;
	
	private BigDecimal lng;
	
	private BigDecimal lat;
	
	private Short type;
	
	private String planStatusDis; // 计划建设阶段释义
	
	private String actualStatusDis; // 实际建设阶段释义
	
	private Boolean is60thWelfare;
	
	private Boolean isPrvcPlan;
	
	private String planStartDt;
	
	private String planEndDt;
	
	private Integer totalPlanInvest; // 计划总投资
	
	private Integer accmPlanInvest; // 当年至本月累计计划投资
	
	private Integer accmActualInvest; // 当年至本月累计实际投资
	
	private Integer yearPlanInvest; // 当年计划投资
	
	private Short completeRateByMonth; // 月度投资完成百分比
	
	private Short completeRateByYear; // 年度投资完成百分比
	
	private String groupName;
	
	private String ownerName; // 业主单位
	
	private String ownerNameSub; // 业主单位，截取前14个字
	
	private String completeStatusDis; // 完成状态
	
	private Integer buildStatus; // 建设状态，1为开工，2为在建
	
	private String actualCompletionStatus; // 根据实际竣工日期（actual_end_dt）
	
	private Date createAt;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public BigDecimal getLng() {
		return lng;
	}
	public void setLng(BigDecimal lng) {
		this.lng = lng;
	}
	public BigDecimal getLat() {
		return lat;
	}
	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}
	public Short getType() {
		return type;
	}
	public void setType(Short type) {
		this.type = type;
	}
	public String getPlanStatusDis() {
		return planStatusDis;
	}
	public void setPlanStatusDis(String planStatusDis) {
		this.planStatusDis = planStatusDis;
	}
	public String getActualStatusDis() {
		return actualStatusDis;
	}
	public void setActualStatusDis(String actualStatusDis) {
		this.actualStatusDis = actualStatusDis;
	}
	public Boolean getIs60thWelfare() {
		return is60thWelfare;
	}
	public void setIs60thWelfare(Boolean is60thWelfare) {
		this.is60thWelfare = is60thWelfare;
	}
	public Boolean getIsPrvcPlan() {
		return isPrvcPlan;
	}
	public void setIsPrvcPlan(Boolean isPrvcPlan) {
		this.isPrvcPlan = isPrvcPlan;
	}
	public String getPlanStartDt() {
		return planStartDt;
	}
	public void setPlanStartDt(String planStartDt) {
		this.planStartDt = planStartDt;
	}
	public String getPlanEndDt() {
		return planEndDt;
	}
	public void setPlanEndDt(String planEndDt) {
		this.planEndDt = planEndDt;
	}
	
	public Integer getTotalPlanInvest() {
		return totalPlanInvest;
	}
	public void setTotalPlanInvest(Integer totalPlanInvest) {
		this.totalPlanInvest = totalPlanInvest;
	}
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
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getOwnerNameSub() {
		return ownerNameSub;
	}
	public void setOwnerNameSub(String ownerNameSub) {
		this.ownerNameSub = ownerNameSub;
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
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public String getActualCompletionStatus() {
		return actualCompletionStatus;
	}
	public void setActualCompletionStatus(String actualCompletionStatus) {
		this.actualCompletionStatus = actualCompletionStatus;
	}
	
}
