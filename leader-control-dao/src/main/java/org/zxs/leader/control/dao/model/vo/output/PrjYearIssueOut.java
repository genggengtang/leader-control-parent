package org.zxs.leader.control.dao.model.vo.output;

import java.util.List;

/**
 * 项目年沟通汇总信息
 * @author Administrator
 */
public class PrjYearIssueOut {
	
	private Integer year;
	
	private List<PrjMonthIssueOut> issueYearList;

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public List<PrjMonthIssueOut> getIssueYearList() {
		return issueYearList;
	}

	public void setIssueYearList(List<PrjMonthIssueOut> issueYearList) {
		this.issueYearList = issueYearList;
	}

}
