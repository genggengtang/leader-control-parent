package org.zxs.leader.control.dao.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

@Table(name="prj_info")
public class PrjInfo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JSONField(ordinal=1)
    private Integer id;
	
	@JSONField(ordinal=2)
	@Column(name="latest_year_id")
    private Integer latestYearId;

	@JSONField(ordinal=3)
	@Column(name="full_name")
    private String fullName;

	@JSONField(ordinal=4)
	@Column(name="short_name")
    private String shortName;

	@JSONField(ordinal=5)
	@Column(name="lng")
    private BigDecimal lng;

	@JSONField(ordinal=6)
	@Column(name="lat")
    private BigDecimal lat;

	@JSONField(ordinal=7)
	@Column(name="rsp_leader_id")
    private Integer rspLeaderId;

	@JSONField(ordinal=8)
	@Column(name="contact_leader_id")
    private Integer contactLeaderId;

	@JSONField(ordinal=9)
	@Column(name="contact_id")
    private Integer contactId;

	@JSONField(ordinal=10)
	@Column(name="type")
    private Short type;

	@JSONField(ordinal=11)
	@Column(name="content")
    private String content;

	@JSONField(ordinal=12)
	@Column(name="total_invest")
    private Integer totalInvest;
	
	@JSONField(ordinal=13)
	@Column(name="actual_invest")
    private Integer actualInvest;

	@JSONField(ordinal=14)
	@Column(name="submit_org_id")
    private Integer submitOrgId;

	@JSONField(ordinal=15)
	@Column(name="industry")
    private Integer industry;

	@JSONField(ordinal=16)
	@Column(name="plan_status")
    private Integer planStatus;

	@JSONField(ordinal=17)
	@Column(name="actual_status")
    private Integer actualStatus;

	@JSONField(ordinal=18)
	@Column(name="area_id")
    private String areaId;

	@JSONField(ordinal=19)
	@Column(name="remark")
    private String remark;

	@JSONField(ordinal=20)
	@Column(name="plan_start_dt")
	@JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date planStartDt;

	@JSONField(ordinal=21)
	@Column(name="plan_end_dt")
	@JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date planEndDt;
	
	@JSONField(ordinal=22)
	@JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name="actual_start_dt")
    private Date actualStartDt;

	@JSONField(ordinal=23)
	@Column(name="actual_end_dt")
	@JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date actualEndDt;
	
	@JSONField(ordinal=24)
	@Column(name="is_60th_welfare")
	private Short is60thWelfare;
	
	@JSONField(ordinal=25)
	@Column(name="is_prvc_plan")
	private Short isPrvcPlan;
	
	
	@JSONField(ordinal=26)
	@Column(name="owner_org_name")
	private String ownerOrgName;
	
	@JSONField(ordinal=27)
	@Column(name="remark_display")
    private String remarkDisplay;

	@JSONField(ordinal=28)
	@Column(name="create_at")
	@JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createAt;

	@JSONField(ordinal=29)
	@Column(name="update_at")
	@JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updateAt;
	
	@JSONField(ordinal=30)
	@Column(name="is_deleted")
	private Short isDeleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLatestYearId() {
		return latestYearId;
	}

	public void setLatestYearId(Integer latestYearId) {
		this.latestYearId = latestYearId;
	}

	public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName == null ? null : fullName.trim();
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName == null ? null : shortName.trim();
    }

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

    public Integer getRspLeaderId() {
        return rspLeaderId;
    }

    public void setRspLeaderId(Integer rspLeaderId) {
        this.rspLeaderId = rspLeaderId;
    }

    public Integer getContactLeaderId() {
        return contactLeaderId;
    }

    public void setContactLeaderId(Integer contactLeaderId) {
        this.contactLeaderId = contactLeaderId;
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getTotalInvest() {
        return totalInvest;
    }

    public void setTotalInvest(Integer totalInvest) {
        this.totalInvest = totalInvest;
    }

    public Integer getActualInvest() {
		return actualInvest;
	}

	public void setActualInvest(Integer actualInvest) {
		this.actualInvest = actualInvest;
	}

	public Integer getSubmitOrgId() {
        return submitOrgId;
    }

    public void setSubmitOrgId(Integer submitOrgId) {
        this.submitOrgId = submitOrgId;
    }

    public Integer getIndustry() {
        return industry;
    }

    public void setIndustry(Integer industry) {
        this.industry = industry;
    }

    public Integer getPlanStatus() {
        return planStatus;
    }

    public void setPlanStatus(Integer planStatus) {
        this.planStatus = planStatus;
    }

    public Integer getActualStatus() {
        return actualStatus;
    }

    public void setActualStatus(Integer actualStatus) {
        this.actualStatus = actualStatus;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId == null ? null : areaId.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getPlanStartDt() {
        return planStartDt;
    }

    public void setPlanStartDt(Date planStartDt) {
        this.planStartDt = planStartDt;
    }

    public Date getPlanEndDt() {
        return planEndDt;
    }

    public void setPlanEndDt(Date planEndDt) {
        this.planEndDt = planEndDt;
    }

    public Date getActualStartDt() {
		return actualStartDt;
	}

	public void setActualStartDt(Date actualStartDt) {
		this.actualStartDt = actualStartDt;
	}

	public Date getActualEndDt() {
		return actualEndDt;
	}

	public void setActualEndDt(Date actualEndDt) {
		this.actualEndDt = actualEndDt;
	}

	public Short getIs60thWelfare() {
		return is60thWelfare;
	}

	public void setIs60thWelfare(Short is60thWelfare) {
		this.is60thWelfare = is60thWelfare;
	}

	public Short getIsPrvcPlan() {
		return isPrvcPlan;
	}

	public void setIsPrvcPlan(Short isPrvcPlan) {
		this.isPrvcPlan = isPrvcPlan;
	}

	public String getOwnerOrgName() {
		return ownerOrgName;
	}

	public void setOwnerOrgName(String ownerOrgName) {
		this.ownerOrgName = ownerOrgName == null ? null : ownerOrgName.trim();
	}

	public String getRemarkDisplay() {
		return remarkDisplay;
	}

	public void setRemarkDisplay(String remarkDisplay) {
		this.remarkDisplay = remarkDisplay == null ? null : remarkDisplay.trim();
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

    public Short getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Short isDeleted) {
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
        PrjInfo other = (PrjInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        	&& (this.getLatestYearId() == null ? other.getLatestYearId() == null : this.getLatestYearId().equals(other.getLatestYearId()))
            && (this.getFullName() == null ? other.getFullName() == null : this.getFullName().equals(other.getFullName()))
            && (this.getShortName() == null ? other.getShortName() == null : this.getShortName().equals(other.getShortName()))
            && (this.getLng() == null ? other.getLng() == null : this.getLng().equals(other.getLng()))
            && (this.getLat() == null ? other.getLat() == null : this.getLat().equals(other.getLat()))
            && (this.getRspLeaderId() == null ? other.getRspLeaderId() == null : this.getRspLeaderId().equals(other.getRspLeaderId()))
            && (this.getContactLeaderId() == null ? other.getContactLeaderId() == null : this.getContactLeaderId().equals(other.getContactLeaderId()))
            && (this.getContactId() == null ? other.getContactId() == null : this.getContactId().equals(other.getContactId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getTotalInvest() == null ? other.getTotalInvest() == null : this.getTotalInvest().equals(other.getTotalInvest()))
            && (this.getActualInvest() == null ? other.getActualInvest() == null : this.getActualInvest().equals(other.getActualInvest()))
            && (this.getSubmitOrgId() == null ? other.getSubmitOrgId() == null : this.getSubmitOrgId().equals(other.getSubmitOrgId()))
            && (this.getIndustry() == null ? other.getIndustry() == null : this.getIndustry().equals(other.getIndustry()))
            && (this.getPlanStatus() == null ? other.getPlanStatus() == null : this.getPlanStatus().equals(other.getPlanStatus()))
            && (this.getActualStatus() == null ? other.getActualStatus() == null : this.getActualStatus().equals(other.getActualStatus()))
            && (this.getAreaId() == null ? other.getAreaId() == null : this.getAreaId().equals(other.getAreaId()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getPlanStartDt() == null ? other.getPlanStartDt() == null : this.getPlanStartDt().equals(other.getPlanStartDt()))
            && (this.getPlanEndDt() == null ? other.getPlanEndDt() == null : this.getPlanEndDt().equals(other.getPlanEndDt()))
            && (this.getActualStartDt() == null ? other.getActualStartDt() == null : this.getActualStartDt().equals(other.getActualStartDt()))
            && (this.getActualEndDt() == null ? other.getActualEndDt() == null : this.getActualEndDt().equals(other.getActualEndDt()))
            && (this.getIs60thWelfare() == null ? other.getIs60thWelfare() == null : this.getIs60thWelfare().equals(other.getIs60thWelfare()))
            && (this.getIsPrvcPlan() == null ? other.getIsPrvcPlan() == null : this.getIsPrvcPlan().equals(other.getIsPrvcPlan()))
            && (this.getOwnerOrgName() == null ? other.getOwnerOrgName() == null : this.getOwnerOrgName().equals(other.getOwnerOrgName()))
            && (this.getRemarkDisplay() == null ? other.getRemarkDisplay() == null : this.getRemarkDisplay().equals(other.getRemarkDisplay()))
            && (this.getCreateAt() == null ? other.getCreateAt() == null : this.getCreateAt().equals(other.getCreateAt()))
            && (this.getUpdateAt() == null ? other.getUpdateAt() == null : this.getUpdateAt().equals(other.getUpdateAt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getLatestYearId() == null) ? 0 : getLatestYearId().hashCode());
        result = prime * result + ((getFullName() == null) ? 0 : getFullName().hashCode());
        result = prime * result + ((getShortName() == null) ? 0 : getShortName().hashCode());
        result = prime * result + ((getLng() == null) ? 0 : getLng().hashCode());
        result = prime * result + ((getLat() == null) ? 0 : getLat().hashCode());
        result = prime * result + ((getRspLeaderId() == null) ? 0 : getRspLeaderId().hashCode());
        result = prime * result + ((getContactLeaderId() == null) ? 0 : getContactLeaderId().hashCode());
        result = prime * result + ((getContactId() == null) ? 0 : getContactId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getTotalInvest() == null) ? 0 : getTotalInvest().hashCode());
        result = prime * result + ((getActualInvest() == null) ? 0 : getActualInvest().hashCode());
        result = prime * result + ((getSubmitOrgId() == null) ? 0 : getSubmitOrgId().hashCode());
        result = prime * result + ((getIndustry() == null) ? 0 : getIndustry().hashCode());
        result = prime * result + ((getPlanStatus() == null) ? 0 : getPlanStatus().hashCode());
        result = prime * result + ((getActualStatus() == null) ? 0 : getActualStatus().hashCode());
        result = prime * result + ((getAreaId() == null) ? 0 : getAreaId().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getPlanStartDt() == null) ? 0 : getPlanStartDt().hashCode());
        result = prime * result + ((getPlanEndDt() == null) ? 0 : getPlanEndDt().hashCode());
        result = prime * result + ((getActualStartDt() == null) ? 0 : getActualStartDt().hashCode());
        result = prime * result + ((getActualEndDt() == null) ? 0 : getActualEndDt().hashCode());       
        result = prime * result + ((getIs60thWelfare() == null) ? 0 : getIs60thWelfare().hashCode());
        result = prime * result + ((getIsPrvcPlan() == null) ? 0 : getIsPrvcPlan().hashCode());
        result = prime * result + ((getOwnerOrgName() == null) ? 0 : getOwnerOrgName().hashCode());
        result = prime * result + ((getRemarkDisplay() == null) ? 0 : getRemarkDisplay().hashCode());
        result = prime * result + ((getCreateAt() == null) ? 0 : getCreateAt().hashCode());
        result = prime * result + ((getUpdateAt() == null) ? 0 : getUpdateAt().hashCode());
        return result;
    }

	@Override
	public String toString() {
		return "PrjInfo [id=" + id + ", latestYearId=" + latestYearId + ", fullName=" + fullName + ", shortName="
				+ shortName + ", lng=" + lng + ", lat=" + lat + ", rspLeaderId=" + rspLeaderId + ", contactLeaderId="
				+ contactLeaderId + ", contactId=" + contactId + ", type=" + type + ", content=" + content
				+ ", totalInvest=" + totalInvest + ", actualInvest=" + actualInvest + ", submitOrgId=" + submitOrgId
				+ ", industry=" + industry + ", planStatus=" + planStatus + ", actualStatus=" + actualStatus
				+ ", areaId=" + areaId + ", remark=" + remark + ", planStartDt=" + planStartDt + ", planEndDt="
				+ planEndDt + ", actualStartDt=" + actualStartDt + ", actualEndDt=" + actualEndDt + ", is60thWelfare="
				+ is60thWelfare + ", isPrvcPlan=" + isPrvcPlan + ", ownerOrgName=" + ownerOrgName + ", remarkDisplay="
				+ remarkDisplay + ", createAt=" + createAt + ", updateAt=" + updateAt + "]";
	}
    
}