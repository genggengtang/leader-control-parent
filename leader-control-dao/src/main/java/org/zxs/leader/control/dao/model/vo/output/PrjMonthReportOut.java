package org.zxs.leader.control.dao.model.vo.output;

import java.util.Map;

/**
 * 项目月报信息
 * @author Administrator
 */
public class PrjMonthReportOut {
	
	private Integer monthId;
	
	private Integer year;
	
	private Integer month;
	
	private String title;
	
	private String actualContent;
	
	private String actualContentSub;
	
	private String picName; // 图片名称,多图片以逗号分隔

	private String picUrl; // 图片url,多图片以逗号分隔
	
	private String[] picUrlArray;
	
	private Map<String, String> picUrlMap;
	
	private String issueContent;
	
	private String issueContentSub;
	
	private String proposal;
	
	private String proposalSub;
	
	private String actualUrl;
	
	private Integer accmPlanInvest2Month; // 当年至本月累计计划投资额
	
	private Integer accmActualInvest2Month; // 当年至本月累计实际投资额
	
	public Integer getMonthId() {
		return monthId;
	}

	public void setMonthId(Integer monthId) {
		this.monthId = monthId;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getActualContent() {
		return actualContent;
	}

	public void setActualContent(String actualContent) {
		this.actualContent = actualContent;
	}

	public String getActualContentSub() {
		return actualContentSub;
	}

	public void setActualContentSub(String actualContentSub) {
		this.actualContentSub = actualContentSub;
		if(actualContent.length() > this.actualContentSub.length()) {
			this.actualContentSub += "...";
		}
	}

	public String getPicName() {
		return picName;
	}

	public void setPicName(String picName) {
		this.picName = picName;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
		if(null != picUrl && !picUrl.isEmpty()) {
			this.picUrlArray = picUrl.split(",");
		}
	}
	
	public String[] getPicUrlArray() {
		return picUrlArray;
	}

	public void setPicUrlArray(String[] picUrlArray) {
		this.picUrlArray = picUrlArray;
	}

	public Map<String, String> getPicUrlMap() {
		return picUrlMap;
	}

	public void setPicUrlMap(Map<String, String> picUrlMap) {
		this.picUrlMap = picUrlMap;
	}

	public String getIssueContent() {
		return issueContent;
	}

	public void setIssueContent(String issueContent) {
		this.issueContent = issueContent;
	}

	public String getIssueContentSub() {
		return issueContentSub;
	}

	public void setIssueContentSub(String issueContentSub) {
		this.issueContentSub = issueContentSub;
		if(issueContent.length() > this.issueContentSub.length()) {
			this.issueContentSub += "...";
		}
	}

	public String getProposal() {
		return proposal;
	}

	public void setProposal(String proposal) {
		this.proposal = proposal;
	}

	public String getProposalSub() {
		return proposalSub;
	}

	public void setProposalSub(String proposalSub) {
		this.proposalSub = proposalSub;
		if(proposal.length() > this.proposalSub.length()) {
			this.proposalSub += "...";
		}
	}

	public String getActualUrl() {
		return actualUrl;
	}

	public void setActualUrl(String actualUrl) {
		this.actualUrl = actualUrl;
	}

	public Integer getAccmPlanInvest2Month() {
		return accmPlanInvest2Month;
	}

	public void setAccmPlanInvest2Month(Integer accmPlanInvest2Month) {
		this.accmPlanInvest2Month = accmPlanInvest2Month;
	}

	public Integer getAccmActualInvest2Month() {
		return accmActualInvest2Month;
	}

	public void setAccmActualInvest2Month(Integer accmActualInvest2Month) {
		this.accmActualInvest2Month = accmActualInvest2Month;
	}

}
