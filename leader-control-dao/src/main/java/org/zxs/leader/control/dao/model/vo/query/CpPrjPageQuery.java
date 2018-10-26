package org.zxs.leader.control.dao.model.vo.query;

import java.util.List;

/**
 * 市统筹项目分页信息查询对象
 * @author Administrator
 *
 */
public class CpPrjPageQuery{
	private String orderBy = "id"; // 默认按项目编号升序排列
	private Integer ownerUserId; // 业主用户编号
	private Integer prjType;
	private Integer planStatus;
	private Integer industry;
	private String nameLike; // 项目名模糊查询
	private Integer areaAdmin; // 所属行政管理区域
	private List<Integer> labels;
	
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public Integer getOwnerUserId() {
		return ownerUserId;
	}
	public void setOwnerUserId(Integer ownerUserId) {
		this.ownerUserId = ownerUserId;
	}
	public Integer getPrjType() {
		return prjType;
	}
	public void setPrjType(Integer prjType) {
		this.prjType = prjType;
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
	public String getNameLike() {
		return nameLike;
	}
	public void setNameLike(String nameLike) {
		this.nameLike = nameLike;
	}
	public Integer getAreaAdmin() {
		return areaAdmin;
	}
	public void setAreaAdmin(Integer areaAdmin) {
		this.areaAdmin = areaAdmin;
	}
	public List<Integer> getLabels() {
		return labels;
	}
	public void setLabels(List<Integer> labels) {
		this.labels = labels;
	}
	
}
