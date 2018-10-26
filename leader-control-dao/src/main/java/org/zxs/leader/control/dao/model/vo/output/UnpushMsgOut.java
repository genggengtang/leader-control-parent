package org.zxs.leader.control.dao.model.vo.output;

import java.util.Collections;
import java.util.List;

/**
 * 未推送消息
 * @author Administrator
 *
 */
public class UnpushMsgOut {
	private Integer userId; // 用户编号
	private Integer pushType; // 推送类型，0为多条合并，1为单条
	private String pushContent; // 推送内容
	private List<String> systemNoticeList; // 系统通知列表
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getPushType() {
		return pushType;
	}
	public void setPushType(Integer pushType) {
		this.pushType = pushType;
	}
	public String getPushContent() {
		return pushContent;
	}
	public void setPushContent(String pushContent) {
		this.pushContent = pushContent;
	}
	public List<String> getSystemNoticeList() {
		return systemNoticeList == null ? Collections.emptyList() : systemNoticeList;
	}
	public void setSystemNoticeList(List<String> systemNoticeList) {
		this.systemNoticeList = systemNoticeList;
	}
	
}
