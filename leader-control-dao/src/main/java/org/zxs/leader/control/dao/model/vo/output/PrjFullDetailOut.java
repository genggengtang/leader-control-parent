package org.zxs.leader.control.dao.model.vo.output;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 市领导联系项目全部详情
 * @author Administrator
 *
 */
public class PrjFullDetailOut extends PrjSimpleDetailOut{
	private Integer accmPlanInvest;
	
	private Integer accmActualInvest;
	
	private Integer completeRateByMonth;
	
	private Integer completeRateByYear;
	
	private String completeStatusDis;
	
	private String seasonChar;
	
	private Integer seasonPlanInvest;
	
	private String seasonPlanContent;
	
	private String seasonPlanContentSub;

	private List<PrjProveOut> proveList; // 审批信息数组
	
	private List<PrjMonthSimpleOut> monthReportList; // 月报
	
	private List<PrjYearIssueOut> issueList; // 沟通信息
	
	private List<MyMeetingNoteOut> attachmentList; // 附件信息
	
	private List<PrjYearPrgOut> yearPrgList; // 建设进度
	
	private String years; // 进度记录年份,多个以逗号分隔
	
	private String[] yearArray; // 进度记录年份数组
	
	private String actualCompletionStatus; // 根据实际竣工日期（actual_end_dt）

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

	public String getSeasonChar() {
		return seasonChar;
	}

	public void setSeasonChar(String seasonChar) {
		this.seasonChar = seasonChar;
	}

	public Integer getSeasonPlanInvest() {
		return seasonPlanInvest;
	}

	public void setSeasonPlanInvest(Integer seasonPlanInvest) {
		this.seasonPlanInvest = seasonPlanInvest;
	}

	public String getSeasonPlanContent() {
		return seasonPlanContent;
	}

	public void setSeasonPlanContent(String seasonPlanContent) {
		this.seasonPlanContent = seasonPlanContent;
	}

	public String getSeasonPlanContentSub() {
		return seasonPlanContentSub;
	}

	public void setSeasonPlanContentSub(String seasonPlanContentSub) {
		this.seasonPlanContentSub = seasonPlanContentSub;
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

	public String getActualCompletionStatus() {
		return actualCompletionStatus;
	}

	public void setActualCompletionStatus(String actualCompletionStatus) {
		this.actualCompletionStatus = actualCompletionStatus;
	}
	
}
