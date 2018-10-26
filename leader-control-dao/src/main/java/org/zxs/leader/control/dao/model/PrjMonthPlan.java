package org.zxs.leader.control.dao.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;

@Table(name="prj_month_plan")
public class PrjMonthPlan {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JSONField(ordinal=1)
    private Integer id;

	@JSONField(ordinal=2)
	@Column(name="month")
    private Byte month;

	@JSONField(ordinal=3)
	@Column(name="year_id")
    private Integer yearId;

	@JSONField(ordinal=4)
	@Column(name="plan_invest")
    private Integer planInvest;

	@JSONField(ordinal=5)
	@Column(name="plan_content")
    private String planContent;

	@JSONField(ordinal=6)
	@Column(name="actual_invest")
    private Integer actualInvest;
	
	@JSONField(ordinal=7)
	@Column(name="title")
    private String title;

	@JSONField(ordinal=8)
	@Column(name="actual_content")
    private String actualContent;
	
	@JSONField(ordinal=9)
	@Column(name="pic_url")
    private String picUrl;
	
	@JSONField(ordinal=10)
	@Column(name="pic_clear_url")
    private String picClearUrl;
	
	@JSONField(ordinal=11)
	@Column(name="pic_name")
    private String picName;
	
	@JSONField(ordinal=12)
	@Column(name="issue_content")
    private String issueContent;
	
	@JSONField(ordinal=13)
	@Column(name="proposal")
	private String proposal;

	@JSONField(ordinal=14)
	@Column(name="actual_url")
    private String actualUrl;
	
	@JSONField(ordinal=15)
	@Column(name="status")
    private Short status;
	
	@JSONField(ordinal=16)
	@Column(name="create_at")
    private Date createAt;

	@JSONField(ordinal=17)
	@Column(name="update_at")
    private Date updateAt;
	
	@JSONField(ordinal=18)
	@Column(name="is_deleted")
    private Boolean isDeleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getMonth() {
        return month;
    }

    public void setMonth(Byte month) {
        this.month = month;
    }

    public Integer getYearId() {
        return yearId;
    }

    public void setYearId(Integer yearId) {
        this.yearId = yearId;
    }

    public Integer getPlanInvest() {
        return planInvest;
    }

    public void setPlanInvest(Integer planInvest) {
        this.planInvest = planInvest;
    }

    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPlanContent() {
        return planContent;
    }

    public void setPlanContent(String planContent) {
        this.planContent = planContent == null ? null : planContent.trim();
    }

    public Integer getActualInvest() {
        return actualInvest;
    }

    public void setActualInvest(Integer actualInvest) {
        this.actualInvest = actualInvest;
    }

    public String getActualContent() {
        return actualContent;
    }

    public void setActualContent(String actualContent) {
        this.actualContent = actualContent == null ? null : actualContent.trim();
    }

    public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl == null ? null : picUrl.trim();
	}

	public String getPicClearUrl() {
		return picClearUrl;
	}

	public void setPicClearUrl(String picClearUrl) {
		this.picClearUrl = picClearUrl == null ? null : picClearUrl.trim();
	}

	public String getPicName() {
		return picName;
	}

	public void setPicName(String picName) {
		this.picName = picName == null ? null : picName.trim();
	}

	public String getIssueContent() {
		return issueContent;
	}

	public void setIssueContent(String issueContent) {
		this.issueContent = issueContent;
	}

	public String getProposal() {
		return proposal;
	}

	public void setProposal(String proposal) {
		this.proposal = proposal;
	}

	public String getActualUrl() {
        return actualUrl;
    }

    public void setActualUrl(String actualUrl) {
        this.actualUrl = actualUrl == null ? null : actualUrl.trim();
    }

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
    
	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        PrjMonthPlan other = (PrjMonthPlan) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMonth() == null ? other.getMonth() == null : this.getMonth().equals(other.getMonth()))
            && (this.getYearId() == null ? other.getYearId() == null : this.getYearId().equals(other.getYearId()))
            && (this.getPlanInvest() == null ? other.getPlanInvest() == null : this.getPlanInvest().equals(other.getPlanInvest()))
            && (this.getPlanContent() == null ? other.getPlanContent() == null : this.getPlanContent().equals(other.getPlanContent()))
            && (this.getActualInvest() == null ? other.getActualInvest() == null : this.getActualInvest().equals(other.getActualInvest()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getActualContent() == null ? other.getActualContent() == null : this.getActualContent().equals(other.getActualContent()))
            && (this.getPicUrl() == null ? other.getPicUrl() == null : this.getPicUrl().equals(other.getPicUrl()))
            && (this.getPicClearUrl() == null ? other.getPicClearUrl() == null : this.getPicClearUrl().equals(other.getPicClearUrl()))
            && (this.getPicName() == null ? other.getPicName() == null : this.getPicName().equals(other.getPicName()))
            && (this.getIssueContent() == null ? other.getIssueContent() == null : this.getIssueContent().equals(other.getIssueContent()))
            && (this.getProposal() == null ? other.getProposal() == null : this.getProposal().equals(other.getProposal()))
            && (this.getActualUrl() == null ? other.getActualUrl() == null : this.getActualUrl().equals(other.getActualUrl()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateAt() == null ? other.getCreateAt() == null : this.getCreateAt().equals(other.getCreateAt()))
            && (this.getUpdateAt() == null ? other.getUpdateAt() == null : this.getUpdateAt().equals(other.getUpdateAt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMonth() == null) ? 0 : getMonth().hashCode());
        result = prime * result + ((getYearId() == null) ? 0 : getYearId().hashCode());
        result = prime * result + ((getPlanInvest() == null) ? 0 : getPlanInvest().hashCode());
        result = prime * result + ((getPlanContent() == null) ? 0 : getPlanContent().hashCode());
        result = prime * result + ((getActualInvest() == null) ? 0 : getActualInvest().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getActualContent() == null) ? 0 : getActualContent().hashCode());
        result = prime * result + ((getPicUrl() == null) ? 0 : getPicUrl().hashCode());
        result = prime * result + ((getPicClearUrl() == null) ? 0 : getPicClearUrl().hashCode());
        result = prime * result + ((getPicName() == null) ? 0 : getPicName().hashCode());
        result = prime * result + ((getIssueContent() == null) ? 0 : getIssueContent().hashCode());
        result = prime * result + ((getProposal() == null) ? 0 : getProposal().hashCode());
        result = prime * result + ((getActualUrl() == null) ? 0 : getActualUrl().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateAt() == null) ? 0 : getCreateAt().hashCode());
        result = prime * result + ((getUpdateAt() == null) ? 0 : getUpdateAt().hashCode());
        return result;
    }
}