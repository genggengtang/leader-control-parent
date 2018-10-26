package org.zxs.leader.control.dao.model.vo.query;

import java.util.List;

/**
 * 通讯录查询对象
 * @author Administrator
 *
 */
public class PhoneListQuery{
	private Integer userId;
	private Integer cgId;
	private Integer prjId;
	private Integer isUserIn;
	private Integer userLevel;
	private String nameLike;
	private Integer prjType;
	private List<Integer> userSelected;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getCgId() {
		return cgId;
	}
	public void setCgId(Integer cgId) {
		this.cgId = cgId;
	}
	public Integer getPrjId() {
		return prjId;
	}
	public void setPrjId(Integer prjId) {
		this.prjId = prjId;
	}
	public Integer getIsUserIn() {
		return isUserIn;
	}
	public void setIsUserIn(Integer isUserIn) {
		this.isUserIn = isUserIn;
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
	public Integer getPrjType() {
		return prjType;
	}
	public void setPrjType(Integer prjType) {
		this.prjType = prjType;
	}
	public List<Integer> getUserSelected() {
		return userSelected;
	}
	public void setUserSelected(List<Integer> userSelected) {
		this.userSelected = userSelected;
	}
	
}
