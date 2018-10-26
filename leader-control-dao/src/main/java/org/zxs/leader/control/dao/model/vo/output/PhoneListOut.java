package org.zxs.leader.control.dao.model.vo.output;

import java.util.List;

/**
 * 通讯录组对象
 * @author Administrator
 *
 */
public class PhoneListOut {
	private String groupName;
	private List<SimpleUserOut> groupMembers;
	
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public List<SimpleUserOut> getGroupMembers() {
		return groupMembers;
	}
	public void setGroupMembers(List<SimpleUserOut> groupMembers) {
		this.groupMembers = groupMembers;
	}
	
}
