package org.zxs.leader.control.dao.model.vo.output;

import java.util.List;

/**
 * 项目月沟通汇总信息
 * @author Administrator
 */
public class PrjMonthIssueOut {
	
	private Integer month; 
	
	private List<PrjIssueOut> issueMonthList;

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public List<PrjIssueOut> getIssueMonthList() {
		return issueMonthList;
	}

	public void setIssueMonthList(List<PrjIssueOut> issueMonthList) {
		this.issueMonthList = issueMonthList;
	}
	
}
