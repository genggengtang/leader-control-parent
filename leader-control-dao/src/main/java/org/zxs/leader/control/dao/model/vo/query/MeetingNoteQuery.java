package org.zxs.leader.control.dao.model.vo.query;

import java.util.Date;

/**
 * 会议纪要查询对象
 * @author Administrator
 *
 */
public class MeetingNoteQuery{
	private String type; // 类型，多个以逗号分隔
	private Integer prjType;
	private Integer userId;
	private String keyword;
	private String orderBy;
	private Integer isFavorite;
	private Date startAt;
	private Date endAt;
	private Integer isInspectIn; // 是否包括督查报告
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getPrjType() {
		return prjType;
	}
	public void setPrjType(Integer prjType) {
		this.prjType = prjType;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public Integer getIsFavorite() {
		return isFavorite;
	}
	public void setIsFavorite(Integer isFavorite) {
		this.isFavorite = isFavorite;
	}
	public Date getStartAt() {
		return startAt;
	}
	public void setStartAt(Date startAt) {
		this.startAt = startAt;
	}
	public Date getEndAt() {
		return endAt;
	}
	public void setEndAt(Date endAt) {
		this.endAt = endAt;
	}
	public Integer getIsInspectIn() {
		return isInspectIn;
	}
	public void setIsInspectIn(Integer isInspectIn) {
		this.isInspectIn = isInspectIn;
	}

}
