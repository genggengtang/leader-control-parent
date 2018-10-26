package org.zxs.leader.control.dao.model.vo.query;

/**
 * 项目分页信息查询对象
 * @author Administrator
 *
 */
public class PrjPageQuery{
	private Integer prjId;
	private String prjName;
	private Integer leaderId;
	private Integer orgId; //项目业主单位编号
	private Integer is60thWelfare;
	private Integer isPrvcPlan;
	private Integer group;
	private String orderBy; // 默认按创建时间、项目编号升序排列
	private Integer areaId;
	private Integer planStatus;
	private Integer industry;
	private Integer completeStatus; // 完成状态，1为超前，2为正常，3为滞后，4为其他 
	private Integer isFavorite;
	private Integer isLngAndLatNotNull = 0; // 经纬度是否非空，默认为否
	private Integer isAreaCross; // 是否跨城区，0为否，1为是 int
	private Integer isSelf; // 是否用户自己负责项目
	private String keyword; // 模糊查询关键字,项目名或联系领导名或业主单位名
	private Integer rspLeaderId; // 项目负责领导编号
	private Integer userLevel; // 用户级别
	private String nameLike; // 项目名模糊查询
	private String month; // 年月，即当月开工或在建的项目，格式为"yyyy-MM"
	private String ownerLike; // 业主名模糊查询
	private Integer prjUser; // 项目管理用户
	
	public Integer getPrjId() {
		return prjId;
	}
	public void setPrjId(Integer prjId) {
		this.prjId = prjId;
	}
	public String getPrjName() {
		return prjName;
	}
	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}
	public Integer getLeaderId() {
		return leaderId;
	}
	public void setLeaderId(Integer leaderId) {
		this.leaderId = leaderId;
	}
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
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
	public Integer getGroup() {
		return group;
	}
	public void setGroup(Integer group) {
		this.group = group;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public Integer getAreaId() {
		return areaId;
	}
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	public Integer getPlanStatus() {
		return planStatus;
	}
	public void setPlanStatus(Integer planStatus) {
		this.planStatus = planStatus;
	}
	public Integer getIndustry() {
		return industry;
	}
	public void setIndustry(Integer industry) {
		this.industry = industry;
	}
	public Integer getCompleteStatus() {
		return completeStatus;
	}
	public void setCompleteStatus(Integer completeStatus) {
		this.completeStatus = completeStatus;
	}
	public Integer getIsFavorite() {
		return isFavorite;
	}
	public void setIsFavorite(Integer isFavorite) {
		this.isFavorite = isFavorite;
	}
	public Integer getIsLngAndLatNotNull() {
		return isLngAndLatNotNull;
	}
	public void setIsLngAndLatNotNull(Integer isLngAndLatNotNull) {
		this.isLngAndLatNotNull = isLngAndLatNotNull;
	}
	public Integer getIsAreaCross() {
		return isAreaCross;
	}
	public void setIsAreaCross(Integer isAreaCross) {
		this.isAreaCross = isAreaCross;
	}
	public Integer getIsSelf() {
		return isSelf;
	}
	public void setIsSelf(Integer isSelf) {
		this.isSelf = isSelf;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Integer getRspLeaderId() {
		return rspLeaderId;
	}
	public void setRspLeaderId(Integer rspLeaderId) {
		this.rspLeaderId = rspLeaderId;
	}
	public Integer getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(Integer userLevel) {
		this.userLevel = userLevel;
	}
	public String getNameLike() {
		return nameLike;
	}
	public void setNameLike(String nameLike) {
		this.nameLike = nameLike;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getOwnerLike() {
		return ownerLike;
	}
	public void setOwnerLike(String ownerLike) {
		this.ownerLike = ownerLike;
	}
	public Integer getPrjUser() {
		return prjUser;
	}
	public void setPrjUser(Integer prjUser) {
		this.prjUser = prjUser;
	}
	
}
