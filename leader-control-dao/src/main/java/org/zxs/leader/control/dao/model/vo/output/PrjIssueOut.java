package org.zxs.leader.control.dao.model.vo.output;

/**
 * 项目沟通信息
 * @author Administrator
 */
public class PrjIssueOut {
	
	private Integer IssueId;
	
	private String title;
	
	private String issueType;
	
	private String issueDt;
	
	private String content;
	
	private String contentSub;
	
	private String action;
	
	private String attachmentName;
	
	private String attachmentUrl;
	
	public Integer getIssueId() {
		return IssueId;
	}

	public void setIssueId(Integer issueId) {
		IssueId = issueId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIssueType() {
		return issueType;
	}

	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}

	public String getIssueDt() {
		return issueDt;
	}

	public void setIssueDt(String issueDt) {
		this.issueDt = issueDt;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContentSub() {
		return contentSub;
	}

	public void setContentSub(String contentSub) {
		this.contentSub = contentSub;
		if(content.length() > this.contentSub.length()) {
			this.contentSub += "...";
		}
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getAttachmentName() {
		return attachmentName;
	}

	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}

	public String getAttachmentUrl() {
		return attachmentUrl;
	}

	public void setAttachmentUrl(String attachmentUrl) {
		this.attachmentUrl = attachmentUrl;
	}

}
