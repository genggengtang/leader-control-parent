package org.zxs.leader.control.dao.model.vo.query;

/**
 * 聊天消息查询对象
 * @author Administrator
 *
 */
public class MsgHisQuery{
	private Integer cgId;
	private Integer msgId;
	private Integer userId;
	private Integer num; // 每次最大查询总数
	
	public Integer getCgId() {
		return cgId;
	}
	public void setCgId(Integer cgId) {
		this.cgId = cgId;
	}
	public Integer getMsgId() {
		return msgId;
	}
	public void setMsgId(Integer msgId) {
		this.msgId = msgId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	
}
