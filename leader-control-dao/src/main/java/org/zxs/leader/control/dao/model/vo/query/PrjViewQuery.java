package org.zxs.leader.control.dao.model.vo.query;

/**
 * 项目预览信息查询对象
 * @author Administrator
 *
 */
public class PrjViewQuery{
	private Integer prjId;	
	private Integer planStatus;
	private Integer industry;
	private Integer rspLeaderId; // 项目负责领导编号
	private Integer is60thWelfare;
	private Integer isPrvcPlan;
	private String nameLike; // 项目名模糊查询
	private String keyword; // 关键字，项目编号或名称
	private String orderBy; // 默认按创建时间、项目编号升序排列
	private Integer isDeleted;
	
	public Integer getPrjId() {
		return prjId;
	}
	public void setPrjId(Integer prjId) {
		this.prjId = prjId;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
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
	public Integer getRspLeaderId() {
		return rspLeaderId;
	}
	public void setRspLeaderId(Integer rspLeaderId) {
		this.rspLeaderId = rspLeaderId;
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
	public String getNameLike() {
		return nameLike;
	}
	public void setNameLike(String nameLike) {
		this.nameLike = nameLike;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Integer getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}
}
