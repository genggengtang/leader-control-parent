package org.zxs.leader.control.dao.model.vo.output;

import java.math.BigDecimal;
import java.util.List;

/**
 * 项目摘要详情
 * @author Administrator
 *
 */
public class PrjSimpleDetailOut{
	private Integer id;
	private String fullName;
	private String shortName;
	private BigDecimal lng;
	private BigDecimal lat;
	private Short type;
	private String planStatusDis; // 计划建设阶段释义
	private String actualStatusDis; // 实际建设阶段释义
	private Integer is60thWelfare;
	private Integer isPrvcPlan;
	private Integer totalPlanInvest; // 计划总投资
	private Integer totalActualInvest; // 实际总投资
	private Integer yearPlanInvest; // 当年计划投资
	private String groupName;
	private String rspLeaderName;
	private String industryName;
	private String contactLeaderName;
	private String contactName;
	private String contactPhone;
	private String contactOrgName;
	private Integer contactLevel; // 联系人级别
	private String areaName;
	
	private String content;
	private String yearContent;
	private String remark;
	private String remarkDisplay;
	
	private Boolean isOwner;
//	private Boolean isFavorite;
	private Integer favoriteId;
	private List<PrjContactOut> ownerList; // 业主联系人集合
	
	private List<PrjContactOut> rspContactList; // 责任单位联系人数组
	
	private List<PrjContactOut> directList; // 现场联系人数组
	
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
	public Integer getIs60thWelfare() {
		return is60thWelfare;
	}
	public void setIs60thWelfare(Integer is60thWelfare) {
		this.is60thWelfare = is60thWelfare;
	}
	public Integer getIsPrvcPlan() {
		return isPrvcPlan;
	}
	public void setIsPrvcPlan(Integer isPrvcPlan) {
		this.isPrvcPlan = isPrvcPlan;
	}
	public Integer getTotalPlanInvest() {
		return totalPlanInvest;
	}
	public void setTotalPlanInvest(Integer totalPlanInvest) {
		this.totalPlanInvest = totalPlanInvest;
	}
	public Integer getTotalActualInvest() {
		return totalActualInvest;
	}
	public void setTotalActualInvest(Integer totalActualInvest) {
		this.totalActualInvest = totalActualInvest;
	}
	public Integer getYearPlanInvest() {
		return yearPlanInvest;
	}
	public void setYearPlanInvest(Integer yearPlanInvest) {
		this.yearPlanInvest = yearPlanInvest;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getIndustryName() {
		return industryName;
	}
	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}
	public String getRspLeaderName() {
		return rspLeaderName;
	}
	public void setRspLeaderName(String rspLeaderName) {
		this.rspLeaderName = rspLeaderName;
	}
	public String getContactLeaderName() {
		return contactLeaderName;
	}
	public void setContactLeaderName(String contactLeaderName) {
		this.contactLeaderName = contactLeaderName;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	public String getContactOrgName() {
		return contactOrgName;
	}
	public void setContactOrgName(String contactOrgName) {
		this.contactOrgName = contactOrgName;
	}
	public Integer getContactLevel() {
		return contactLevel;
	}
	public void setContactLevel(Integer contactLevel) {
		this.contactLevel = contactLevel;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getYearContent() {
		return yearContent;
	}
	public void setYearContent(String yearContent) {
		this.yearContent = yearContent;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getRemarkDisplay() {
		return remarkDisplay;
	}
	public void setRemarkDisplay(String remarkDisplay) {
		this.remarkDisplay = remarkDisplay;
	}
	public Boolean getIsOwner() {
		return isOwner;
	}
	public void setIsOwner(Boolean isOwner) {
		this.isOwner = isOwner;
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
	public List<PrjContactOut> getRspContactList() {
		return rspContactList;
	}
	public void setRspContactList(List<PrjContactOut> rspContactList) {
		this.rspContactList = rspContactList;
	}
	public List<PrjContactOut> getDirectList() {
		return directList;
	}
	public void setDirectList(List<PrjContactOut> directList) {
		this.directList = directList;
	}
	
}
