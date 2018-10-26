package org.zxs.leader.control.dao.model.vo.output;

import java.util.List;

/**
 * 城建计划项目摘要详情
 * @author Administrator
 *
 */
public class CbSimpleDetailOut{
	private Integer id;
	private String name;
	private String cbFeatureDis;
	private String cbTypeDis;
	private Integer isFundPrj; // 是否经费开支项目
	private String labels; // 属性标签
	private String[] labelArray;
	private Integer starNum; // 重点星数
	private String prjDbNo; // 项目库编码
	private String address;
	private Integer prjInvestTotal; // 项目计划总投资
	private Integer planInvestTotal; // 本期计划总投资
	private Integer planStartYear; // 本期计划开始年份
	private Integer planEndYear; // 本期计划竣工年份
	private String planStartDate;
	private String planEndDate;
	private String prjContent; // 项目建设内容
	private String content; // 本期建设内容
	private String areaName; // 所属区域，多个区域以逗号分隔
	private String adminOrgName; 
	private String remark;
	private Integer favoriteId;
	private List<PrjContactOut> ownerList; // 业主联系人集合
	private List<InvestSourceOut> sourceFundList; // 资金来源集合
	private Integer isCurrentPlan; // 是否当前期数
	private Integer prjStartYear; // 项目计划开工年
	private Integer prjEndYear; // 项目计划结束年
	private Integer yearPlanInvest; // 年度计划投资额
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCbFeatureDis() {
		return cbFeatureDis;
	}
	public void setCbFeatureDis(String cbFeatureDis) {
		this.cbFeatureDis = cbFeatureDis;
	}
	public String getCbTypeDis() {
		return cbTypeDis;
	}
	public void setCbTypeDis(String cbTypeDis) {
		this.cbTypeDis = cbTypeDis;
	}
	public Integer getIsFundPrj() {
		return isFundPrj;
	}
	public void setIsFundPrj(Integer isFundPrj) {
		this.isFundPrj = isFundPrj;
	}
	public String getLabels() {
		return labels;
	}
	public void setLabels(String labels) {
		this.labels = labels;
		if(null != labels && !labels.isEmpty())
			this.labelArray = labels.split(",");
	}
	public String[] getLabelArray() {
		return labelArray;
	}
	public void setLabelArray(String[] labelArray) {
		this.labelArray = labelArray;
	}
	public Integer getStarNum() {
		return starNum;
	}
	public void setStarNum(Integer starNum) {
		this.starNum = starNum;
	}
	public String getPrjDbNo() {
		return prjDbNo;
	}
	public void setPrjDbNo(String prjDbNo) {
		this.prjDbNo = prjDbNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getPrjInvestTotal() {
		return prjInvestTotal;
	}
	public void setPrjInvestTotal(Integer prjInvestTotal) {
		this.prjInvestTotal = prjInvestTotal;
	}
	public Integer getPlanInvestTotal() {
		return planInvestTotal;
	}
	public void setPlanInvestTotal(Integer planInvestTotal) {
		this.planInvestTotal = planInvestTotal;
	}
	public Integer getPlanStartYear() {
		return planStartYear;
	}
	public void setPlanStartYear(Integer planStartYear) {
		this.planStartYear = planStartYear;
	}
	public Integer getPlanEndYear() {
		return planEndYear;
	}
	public void setPlanEndYear(Integer planEndYear) {
		this.planEndYear = planEndYear;
	}
	public String getPlanStartDate() {
		return planStartDate;
	}
	public void setPlanStartDate(String planStartDate) {
		this.planStartDate = planStartDate;
	}
	public String getPlanEndDate() {
		return planEndDate;
	}
	public void setPlanEndDate(String planEndDate) {
		this.planEndDate = planEndDate;
	}
	public String getPrjContent() {
		return prjContent;
	}
	public void setPrjContent(String prjContent) {
		this.prjContent = prjContent;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getAdminOrgName() {
		return adminOrgName;
	}
	public void setAdminOrgName(String adminOrgName) {
		this.adminOrgName = adminOrgName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getFavoriteId() {
		return favoriteId;
	}
	public void setFavoriteId(Integer favoriteId) {
		this.favoriteId = favoriteId;
	}
	public List<PrjContactOut> getOwnerList() {
		return ownerList;
	}
	public void setOwnerList(List<PrjContactOut> ownerList) {
		this.ownerList = ownerList;
	}
	public List<InvestSourceOut> getSourceFundList() {
		return sourceFundList;
	}
	public void setSourceFundList(List<InvestSourceOut> sourceFundList) {
		this.sourceFundList = sourceFundList;
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
	public Integer getYearPlanInvest() {
		return yearPlanInvest == null ? 0 : yearPlanInvest;
	}
	public void setYearPlanInvest(Integer yearPlanInvest) {
		this.yearPlanInvest = yearPlanInvest;
	}
	
}
