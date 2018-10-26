package org.zxs.leader.control.dao.model.vo.output;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * 登录用户返回信息
 * @author Administrator
 */
public class LoginUserOut implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int userId;
	
	private String loginName;
	
	private String username;
	
	private String orgName;
	
	private String position;
	
	private String avatar;
	
	private String token;
	
	private int level;
	
	private Date createAt;
	
	private int unreadNum; // 未读消息总数
	
	private Map<Integer, String> loginMap; // 当有多个返回值时，提供ID-NAME返回前端
	
	private Integer deviceId; // 终端设备编号
	
	private Integer hasLdPrj; // 是否有关联的市领导联系项目
	
	private Integer hasCbPrj; // 是否有城建关联的市领导联系项目
	
	private Integer isPrjLeader; // 是否责任领导或联系领导

	public int getUserId() {
		return userId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position == null ? "":position;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public int getUnreadNum() {
		return unreadNum;
	}

	public void setUnreadNum(int unreadNum) {
		this.unreadNum = unreadNum;
	}

	public Map<Integer, String> getLoginMap() {
		return loginMap;
	}

	public void setLoginMap(Map<Integer, String> loginMap) {
		this.loginMap = loginMap;
	}

	public Integer getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}

	public Integer getHasLdPrj() {
		return hasLdPrj;
	}

	public void setHasLdPrj(Integer hasLdPrj) {
		this.hasLdPrj = hasLdPrj;
	}
	
	public Integer getHasCbPrj() {
		return hasCbPrj;
	}

	public void setHasCbPrj(Integer hasCbPrj) {
		this.hasCbPrj = hasCbPrj;
	}

	public Integer getIsPrjLeader() {
		return isPrjLeader;
	}

	public void setIsPrjLeader(Integer isPrjLeader) {
		this.isPrjLeader = isPrjLeader;
	}

	@Override
	public String toString() {
		return "LoginUserOut [userId=" + userId + ", loginName=" + loginName + ", username=" + username + ", orgName="
				+ orgName + ", position=" + position + ", avatar=" + avatar + ", token=" + token + ", level=" + level
				+ ", createAt=" + createAt + ", unreadNum=" + unreadNum + ", loginMap=" + loginMap + ", deviceId="
				+ deviceId + ", hasLdPrj=" + hasLdPrj + ", hasCbPrj=" + hasCbPrj + ", isPrjLeader=" + isPrjLeader + "]";
	}

}
