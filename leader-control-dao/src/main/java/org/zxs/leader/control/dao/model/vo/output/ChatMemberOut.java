package org.zxs.leader.control.dao.model.vo.output;

/**
 * 添加或移除群组成员返回信息
 * @author Administrator
 *
 */
public class ChatMemberOut {
	public static final short TYPE_ADD = 1;
	public static final short TYPE_REMOVE = 2;
	
	private short type;
	private String sNames;
	private String sIds;
	private short count;
	
	public short getType() {
		return type;
	}
	public void setType(short type) {
		this.type = type;
	}
	public String getsNames() {
		return sNames;
	}
	public void setsNames(String sNames) {
		this.sNames = sNames;
	}
	public String getsIds() {
		return sIds;
	}
	public void setsIds(String sIds) {
		this.sIds = sIds;
	}
	public short getCount() {
		return count;
	}
	public void setCount(short count) {
		this.count = count;
	}
}
