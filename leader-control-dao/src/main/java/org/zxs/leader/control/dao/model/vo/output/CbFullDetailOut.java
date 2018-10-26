package org.zxs.leader.control.dao.model.vo.output;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 城建计划项目全部详情
 * @author Administrator
 *
 */
public class CbFullDetailOut extends CbSimpleDetailOut{
	private BigDecimal lng;
	private BigDecimal lat;
	private Integer accmPlanInvest;
	private Integer accmActualInvest;
	private Integer completeRateByMonth;
	private Integer completeRateByYear;
	private String completeStatusDis;
	private String years; // 进度记录年份,多个以逗号分隔
	private String[] yearArray;
	
	private List<PrjProveOut> proveList; // 审批信息数组
	private List<PrjMonthSimpleOut> monthReportList; // 月报
	private List<PrjYearIssueOut> issueList; // 沟通信息
	private List<MyMeetingNoteOut> attachmentList; // 附件信息
	private List<PrjYearPrgOut> yearPrgList; // 建设进度
	
	public BigDecimal getLng() {
		return lng;
	}
	public void setLng(BigDecimal lng) {
		this.lng = lng;
	}
	public BigDecimal getLat() {
		return lat;
	}
	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}
	public Integer getAccmPlanInvest() {
		return accmPlanInvest;
	}
	public void setAccmPlanInvest(Integer accmPlanInvest) {
		this.accmPlanInvest = accmPlanInvest;
	}
	public Integer getAccmActualInvest() {
		return accmActualInvest;
	}
	public void setAccmActualInvest(Integer accmActualInvest) {
		this.accmActualInvest = accmActualInvest;
	}
	public Integer getCompleteRateByMonth() {
		return completeRateByMonth;
	}
	public void setCompleteRateByMonth(Integer completeRateByMonth) {
		this.completeRateByMonth = completeRateByMonth;
	}
	public Integer getCompleteRateByYear() {
		return completeRateByYear;
	}
	public void setCompleteRateByYear(Integer completeRateByYear) {
		this.completeRateByYear = completeRateByYear;
	}
	public String getCompleteStatusDis() {
		return completeStatusDis;
	}
	public void setCompleteStatusDis(String completeStatusDis) {
		this.completeStatusDis = completeStatusDis;
	}
	public String getYears() {
		return years;
	}
	public void setYears(String years) {
		this.years = years;
		if(null != years && !years.isEmpty()) {
			this.yearArray = years.split(",");
			Collections.reverse(Arrays.asList(this.yearArray));
		}
	}
	public String[] getYearArray() {
		return yearArray;
	}
	public void setYearArray(String[] yearArray) {
		this.yearArray = yearArray;
	}
	public List<PrjProveOut> getProveList() {
		return proveList;
	}
	public void setProveList(List<PrjProveOut> proveList) {
		this.proveList = proveList;
	}
	public List<PrjMonthSimpleOut> getMonthReportList() {
		return monthReportList;
	}
	public void setMonthReportList(List<PrjMonthSimpleOut> monthReportList) {
		this.monthReportList = monthReportList;
	}
	public List<PrjYearIssueOut> getIssueList() {
		return issueList;
	}
	public void setIssueList(List<PrjYearIssueOut> issueList) {
		this.issueList = issueList;
	}
	public List<MyMeetingNoteOut> getAttachmentList() {
		return attachmentList;
	}
	public void setAttachmentList(List<MyMeetingNoteOut> attachmentList) {
		this.attachmentList = attachmentList;
	}
	public List<PrjYearPrgOut> getYearPrgList() {
		return yearPrgList;
	}
	public void setYearPrgList(List<PrjYearPrgOut> yearPrgList) {
		this.yearPrgList = yearPrgList;
	}
	
	
}
