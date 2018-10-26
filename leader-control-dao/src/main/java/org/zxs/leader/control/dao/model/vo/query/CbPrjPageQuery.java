package org.zxs.leader.control.dao.model.vo.query;

/**
 * 城建计划项目列表信息查询对象
 * @author Administrator
 *
 */
public class CbPrjPageQuery{
	private Integer prjId;
	private Integer orgId; //项目业主单位编号
	private Integer rspLeaderId; // 项目负责领导编号
	private Integer planNo; // 计划期数
	private String orderBy = "create_at, id"; // 默认按创建时间、项目编号升序排列
	private Integer areaId;
	private Integer isKeyPrj; // 是否重点项目
	private Integer cbFeture; // 城建性质，对应字段表215
	private Integer cbType; // 城建项目分类，参见字典表216
	private Integer label; // 重大项目分类标签，对应字典表217
	private Integer completeStatus; // 完成状态，1为超前，2为正常，3为滞后，4为其他 
	private Integer isSelf; // 是否领导自己负责项目，0为否，1为是
	private Integer isFavorite;
	private Integer favorUserId; // 关注用户编号
	private Integer isLngAndLatNotNull = 0; // 经纬度是否非空，默认为否
	private Integer isAreaCross; // 是否跨城区，0为否，1为是 int
	private String keyword; // 模糊查询关键字,项目名或联系领导名或业主单位名
	private String nameLike; // 项目名模糊查询
	private String month; // 年月，即当月开工或在建的项目，格式为"yyyy-MM"
	private Integer userLevel; // 用户级别
	private Integer ownerId; // 业主联系人编号
	private Integer isLeaderContact; // 是否市领导联系项目
	
	public Integer getPrjId() {
		return prjId;
	}
	public void setPrjId(Integer prjId) {
		this.prjId = prjId;
	}
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	public Integer getRspLeaderId() {
		return rspLeaderId;
	}
	public void setRspLeaderId(Integer rspLeaderId) {
		this.rspLeaderId = rspLeaderId;
	}
	public Integer getPlanNo() {
		return planNo;
	}
	public void setPlanNo(Integer planNo) {
		this.planNo = planNo;
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
	public Integer getIsKeyPrj() {
		return isKeyPrj;
	}
	public void setIsKeyPrj(Integer isKeyPrj) {
		this.isKeyPrj = isKeyPrj;
	}
	public Integer getCbFeture() {
		return cbFeture;
	}
	public void setCbFeture(Integer cbFeture) {
		this.cbFeture = cbFeture;
	}
	public Integer getCbType() {
		return cbType;
	}
	public void setCbType(Integer cbType) {
		this.cbType = cbType;
	}
	public Integer getLabel() {
		return label;
	}
	public void setLabel(Integer label) {
		this.label = label;
	}
	public Integer getCompleteStatus() {
		return completeStatus;
	}
	public void setCompleteStatus(Integer completeStatus) {
		this.completeStatus = completeStatus;
	}
	public Integer getIsSelf() {
		return isSelf;
	}
	public void setIsSelf(Integer isSelf) {
		this.isSelf = isSelf;
	}
	public Integer getIsFavorite() {
		return isFavorite;
	}
	public void setIsFavorite(Integer isFavorite) {
		this.isFavorite = isFavorite;
	}
	public Integer getFavorUserId() {
		return favorUserId;
	}
	public void setFavorUserId(Integer favorUserId) {
		this.favorUserId = favorUserId;
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
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
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
	public Integer getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(Integer userLevel) {
		this.userLevel = userLevel;
	}
	public Integer getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}
	public Integer getIsLeaderContact() {
		return isLeaderContact;
	}
	public void setIsLeaderContact(Integer isLeaderContact) {
		this.isLeaderContact = isLeaderContact;
	}
	
}
