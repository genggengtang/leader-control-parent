package org.zxs.leader.control.dao.model.vo.output;

import java.util.Date;

/**
 * 通讯录单个用户对象
 * @author Administrator
 *
 */
public class SimpleUserOut {
	private Integer userId;
	private String userName;
	private String orgName;
	private String mobilePhone;
	private String position;
	private Integer isInGroup; // 是否在群组中
	private Integer isSelected; // 是否已选择
	private Date createAt;
	private Byte role;
	private Byte removeable;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Integer getIsInGroup() {
		return isInGroup;
	}
	public void setIsInGroup(Integer isInGroup) {
		this.isInGroup = isInGroup;
	}
	public Integer getIsSelected() {
		return isSelected;
	}
	public void setIsSelected(Integer isSelected) {
		this.isSelected = isSelected;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public Byte getRole() {
		return role;
	}
	public void setRole(Byte role) {
		this.role = role;
	}
	public Byte getRemoveable() {
		return removeable;
	}
	public void setRemoveable(Byte removeable) {
		this.removeable = removeable;
	}
	
}
