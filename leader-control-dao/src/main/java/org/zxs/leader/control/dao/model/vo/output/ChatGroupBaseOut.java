package org.zxs.leader.control.dao.model.vo.output;

import java.util.List;

import org.zxs.leader.control.dao.model.ChatGroupInfo;

/**
 * 群组基本信息
 * @author Administrator
 *
 */
public class ChatGroupBaseOut extends ChatGroupInfo{
	private String createName; // 创建者名称
	private Integer unreadNum; // 未读消息数
	private Integer createId;  // 创建者编号
	private Boolean isGroupAdmin;  // 是否能管理群成员
	private Short enableRemove;  // 是否能解散
	private String prjName; // 项目名
	private Integer groupNum; // 群组成员数
	private List<SimpleUserOut> memberList;
	
	public String getCreateName() {
		return createName;
	}
	public void setCreateName(String createName) {
		this.createName = createName;
	}
	public Integer getUnreadNum() {
		return unreadNum;
	}
	public void setUnreadNum(Integer unreadNum) {
		this.unreadNum = unreadNum;
	}
	public Integer getCreateId() {
		return createId;
	}
	public void setCreateId(Integer createId) {
		this.createId = createId;
	}
	public String getPrjName() {
		return prjName;
	}
	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}
	public Integer getGroupNum() {
		return groupNum;
	}
	public void setGroupNum(Integer groupNum) {
		this.groupNum = groupNum;
	}
	public List<SimpleUserOut> getMemberList() {
		return memberList;
	}
	public void setMemberList(List<SimpleUserOut> memberList) {
		this.memberList = memberList;
	}
	public Boolean getIsGroupAdmin() {
		return isGroupAdmin;
	}
	public void setIsGroupAdmin(Boolean isGroupAdmin) {
		this.isGroupAdmin = isGroupAdmin;
	}
	public Short getEnableRemove() {
		return enableRemove;
	}
	public void setEnableRemove(Short enableRemove) {
		this.enableRemove = enableRemove;
	}
	
}
