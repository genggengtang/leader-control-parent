package org.zxs.leader.control.dao.model.vo.output;

import java.util.List;

/**
 * 年度建设进度
 * @author Administrator
 *
 */
public class PrjYearPrgOut {
	private Integer yearId;
	private Integer year;
	private List<PrjMonthReportOut> monthList;
	
	public Integer getYearId() {
		return yearId;
	}
	public void setYearId(Integer yearId) {
		this.yearId = yearId;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public List<PrjMonthReportOut> getMonthList() {
		return monthList;
	}
	public void setMonthList(List<PrjMonthReportOut> monthList) {
		this.monthList = monthList;
	}
	
	
}
