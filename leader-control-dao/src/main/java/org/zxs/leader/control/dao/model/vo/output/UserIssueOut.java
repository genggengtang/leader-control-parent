package org.zxs.leader.control.dao.model.vo.output;

import org.zxs.leader.control.dao.model.UserIssue;

/**
 * 用户意见对象
 * @author Administrator
 *
 */
public class UserIssueOut extends UserIssue{
	
	private String statusDis; // 意见状态释义

	public String getStatusDis() {
		return statusDis;
	}

	public void setStatusDis(String statusDis) {
		this.statusDis = statusDis;
	}
	
	public void setStatus(Byte status) {
		super.setStatus(status);
		switch(status) {
			case 1:
				this.statusDis = "已回复";
				break;
			default:
				this.statusDis = "待回复";
		}
	}
}
