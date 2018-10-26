package org.zxs.leader.control.dao.model.vo.output;

import java.util.Date;

public class AdminUserOut {
	
	private Integer id;
	
    private String loginName;
    
    private String nickName;
    
    private String avatar;
    
    private Byte role;
    
    private String adminGroup;
    
    private Date createAt;
    
    private Date updateAt;
    
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getLoginName() {
		return loginName;
	}
	
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
	public String getNickName() {
		return nickName;
	}
	
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	public String getAvatar() {
		return avatar;
	}
	
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	public Byte getRole() {
		return role;
	}
	
	public void setRole(Byte role) {
		this.role = role;
	}
	
	public Date getCreateAt() {
		return createAt;
	}
	
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
	public Date getUpdateAt() {
		return updateAt;
	}
	
	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	public String getAdminGroup() {
		return adminGroup;
	}

	public void setAdminGroup(String adminGroup) {
		this.adminGroup = adminGroup;
	}

	@Override
	public String toString() {
		return "AdminUserOut [id=" + id + ", loginName=" + loginName + ", nickName=" + nickName + ", avatar=" + avatar
				+ ", role=" + role + ", adminGroup=" + adminGroup + ", createAt=" + createAt + ", updateAt=" + updateAt
				+ "]";
	}

}
