package org.zxs.leader.control.dao.model.vo.output;

/**
 * 群组简单信息
 * @author Administrator
 *
 */
public class ChatGroupSimpleOut{
	private Integer id;
	private String createName; // 群主姓名
	private String groupName; // 群组名
	private Integer groupNum; // 群人数
	
	private String prjName;  // 项目名称
	private String createAt; // 群聊创建时间
	
	private Integer enableNameUpdate;  // 是否允许改名
	private Integer enableRemove;  // 是否允许解散
	
	private Integer unreadNum;
	private String lastAt;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCreateName() {
		return createName;
	}
	public void setCreateName(String createName) {
		this.createName = createName;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public Integer getGroupNum() {
		return groupNum;
	}
	public void setGroupNum(Integer groupNum) {
		this.groupNum = groupNum;
	}
	public String getPrjName() {
		return prjName;
	}
	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}
	public String getCreateAt() {
		return createAt;
	}
	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}
	public Integer getEnableNameUpdate() {
		return enableNameUpdate;
	}
	public void setEnableNameUpdate(Integer enableNameUpdate) {
		this.enableNameUpdate = enableNameUpdate;
	}
	public Integer getEnableRemove() {
		return enableRemove;
	}
	public void setEnableRemove(Integer enableRemove) {
		this.enableRemove = enableRemove;
	}
	public Integer getUnreadNum() {
		return unreadNum;
	}
	public void setUnreadNum(Integer unreadNum) {
		this.unreadNum = unreadNum;
	}
	public String getLastAt() {
		return lastAt;
	}
	public void setLastAt(String lastAt) {
		this.lastAt = lastAt;
	}
	
}
