package org.zxs.leader.control.dao.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;

@Table(name="cb_plan_prj")
public class CbPlanPrj {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JSONField(ordinal=1)
    private Integer id;

	@JSONField(ordinal=2)
	@Column(name="cb_id")
    private Integer cbId;

	@JSONField(ordinal=3)
	@Column(name="plan_no")
    private Integer planNo;

	@JSONField(ordinal=4)
	@Column(name="name")
    private String name;

	@JSONField(ordinal=5)
	@Column(name="lng")
    private BigDecimal lng;

	@JSONField(ordinal=6)
	@Column(name="lat")
    private BigDecimal lat;

	@JSONField(ordinal=7)
	@Column(name="star_num")
    private Byte starNum;

	@JSONField(ordinal=8)
	@Column(name="cb_type")
    private Integer cbType;

	@JSONField(ordinal=9)
	@Column(name="label")
    private String label;

	@JSONField(ordinal=10)
	@Column(name="content")
    private String content;

	@JSONField(ordinal=11)
	@Column(name="rsp_leader_id")
    private Integer rspLeaderId;
	
	@JSONField(ordinal=12)
	@Column(name="is_key_prj")
    private Short isKeyPrj;

	@JSONField(ordinal=13)
	@Column(name="is_fund_prj")
    private Byte isFundPrj;

	@JSONField(ordinal=14)
	@Column(name="area")
    private String area;
	
	@JSONField(ordinal=15)
	@Column(name="address")
    private String address;

	@JSONField(ordinal=16)
	@Column(name="plan_start_year")
    private Integer planStartYear;

	@JSONField(ordinal=17)
	@Column(name="plan_end_year")
    private Integer planEndYear;

	@JSONField(ordinal=18)
	@Column(name="plan_start_month")
    private Byte planStartMonth;

	@JSONField(ordinal=19)
	@Column(name="plan_end_month")
    private Byte planEndMonth;
	
	@JSONField(ordinal=20)
	@Column(name="plan_start_date")
    private Byte planStartDate;

	@JSONField(ordinal=21)
	@Column(name="plan_end_date")
    private Byte planEndDate;

	@JSONField(ordinal=22)
	@Column(name="actual_end_date")
    private Date actualEndDate;

	@JSONField(ordinal=23)
	@Column(name="cb_feature")
    private Integer cbFeature;

	@JSONField(ordinal=24)
	@Column(name="plan_invest_total")
    private Integer planInvestTotal;
	
	@JSONField(ordinal=25)
	@Column(name="extra_cb_type")
    private String extraCbType;

	@JSONField(ordinal=26)
	@Column(name="remark")
    private String remark;

	@JSONField(ordinal=27)
	@Column(name="create_at")
    private Date createAt;

	@JSONField(ordinal=28)
	@Column(name="update_at")
    private Date updateAt;
	
	@JSONField(ordinal=29)
	@Column(name="is_deleted")
    private Boolean isDeleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCbId() {
        return cbId;
    }

    public void setCbId(Integer cbId) {
        this.cbId = cbId;
    }

    public Integer getPlanNo() {
        return planNo;
    }

    public void setPlanNo(Integer planNo) {
        this.planNo = planNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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

    public Byte getStarNum() {
        return starNum;
    }

    public void setStarNum(Byte starNum) {
        this.starNum = starNum;
    }

    public Integer getCbType() {
        return cbType;
    }

    public void setCbType(Integer cbType) {
        this.cbType = cbType;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getRspLeaderId() {
        return rspLeaderId;
    }

    public void setRspLeaderId(Integer rspLeaderId) {
        this.rspLeaderId = rspLeaderId;
    }

    public Short getIsKeyPrj() {
		return isKeyPrj;
	}

	public void setIsKeyPrj(Short isKeyPrj) {
		this.isKeyPrj = isKeyPrj;
	}

	public Byte getIsFundPrj() {
        return isFundPrj;
    }

    public void setIsFundPrj(Byte isFundPrj) {
        this.isFundPrj = isFundPrj;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	public Integer getPlanStartYear() {
        return planStartYear;
    }

    public void setPlanStartYear(Integer planStartYear) {
        this.planStartYear = planStartYear;
    }

    public Integer getPlanEndYear() {
        return planEndYear;
    }

    public void setPlanEndYear(Integer planEndYear) {
        this.planEndYear = planEndYear;
    }

    public Byte getPlanStartMonth() {
        return planStartMonth;
    }

    public void setPlanStartMonth(Byte planStartMonth) {
        this.planStartMonth = planStartMonth;
    }

    public Byte getPlanEndMonth() {
        return planEndMonth;
    }

    public void setPlanEndMonth(Byte planEndMonth) {
        this.planEndMonth = planEndMonth;
    }

    public Byte getPlanStartDate() {
		return planStartDate;
	}

	public void setPlanStartDate(Byte planStartDate) {
		this.planStartDate = planStartDate;
	}

	public Byte getPlanEndDate() {
		return planEndDate;
	}

	public void setPlanEndDate(Byte planEndDate) {
		this.planEndDate = planEndDate;
	}

	public Date getActualEndDate() {
        return actualEndDate;
    }

    public void setActualEndDate(Date actualEndDate) {
        this.actualEndDate = actualEndDate;
    }

    public Integer getCbFeature() {
        return cbFeature;
    }

    public void setCbFeature(Integer cbFeature) {
        this.cbFeature = cbFeature;
    }

    public Integer getPlanInvestTotal() {
        return planInvestTotal;
    }

    public void setPlanInvestTotal(Integer planInvestTotal) {
        this.planInvestTotal = planInvestTotal;
    }

    public String getExtraCbType() {
		return extraCbType;
	}

	public void setExtraCbType(String extraCbType) {
		this.extraCbType = extraCbType == null ? null : extraCbType.trim();
	}

	public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
        CbPlanPrj other = (CbPlanPrj) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCbId() == null ? other.getCbId() == null : this.getCbId().equals(other.getCbId()))
            && (this.getPlanNo() == null ? other.getPlanNo() == null : this.getPlanNo().equals(other.getPlanNo()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getLng() == null ? other.getLng() == null : this.getLng().equals(other.getLng()))
            && (this.getLat() == null ? other.getLat() == null : this.getLat().equals(other.getLat()))
            && (this.getStarNum() == null ? other.getStarNum() == null : this.getStarNum().equals(other.getStarNum()))
            && (this.getCbType() == null ? other.getCbType() == null : this.getCbType().equals(other.getCbType()))
            && (this.getLabel() == null ? other.getLabel() == null : this.getLabel().equals(other.getLabel()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getRspLeaderId() == null ? other.getRspLeaderId() == null : this.getRspLeaderId().equals(other.getRspLeaderId()))
            && (this.getIsKeyPrj() == null ? other.getIsKeyPrj() == null : this.getIsKeyPrj().equals(other.getIsKeyPrj()))
            && (this.getIsFundPrj() == null ? other.getIsFundPrj() == null : this.getIsFundPrj().equals(other.getIsFundPrj()))
            && (this.getArea() == null ? other.getArea() == null : this.getArea().equals(other.getArea()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getPlanStartYear() == null ? other.getPlanStartYear() == null : this.getPlanStartYear().equals(other.getPlanStartYear()))
            && (this.getPlanEndYear() == null ? other.getPlanEndYear() == null : this.getPlanEndYear().equals(other.getPlanEndYear()))
            && (this.getPlanStartMonth() == null ? other.getPlanStartMonth() == null : this.getPlanStartMonth().equals(other.getPlanStartMonth()))
            && (this.getPlanEndMonth() == null ? other.getPlanEndMonth() == null : this.getPlanEndMonth().equals(other.getPlanEndMonth()))
            && (this.getPlanStartDate() == null ? other.getPlanStartDate() == null : this.getPlanStartDate().equals(other.getPlanStartDate()))
            && (this.getPlanEndDate() == null ? other.getPlanEndDate() == null : this.getPlanEndDate().equals(other.getPlanEndDate()))
            && (this.getActualEndDate() == null ? other.getActualEndDate() == null : this.getActualEndDate().equals(other.getActualEndDate()))
            && (this.getCbFeature() == null ? other.getCbFeature() == null : this.getCbFeature().equals(other.getCbFeature()))
            && (this.getPlanInvestTotal() == null ? other.getPlanInvestTotal() == null : this.getPlanInvestTotal().equals(other.getPlanInvestTotal()))
            && (this.getExtraCbType() == null ? other.getExtraCbType() == null : this.getExtraCbType().equals(other.getExtraCbType()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getCreateAt() == null ? other.getCreateAt() == null : this.getCreateAt().equals(other.getCreateAt()))
            && (this.getUpdateAt() == null ? other.getUpdateAt() == null : this.getUpdateAt().equals(other.getUpdateAt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCbId() == null) ? 0 : getCbId().hashCode());
        result = prime * result + ((getPlanNo() == null) ? 0 : getPlanNo().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getLng() == null) ? 0 : getLng().hashCode());
        result = prime * result + ((getLat() == null) ? 0 : getLat().hashCode());
        result = prime * result + ((getStarNum() == null) ? 0 : getStarNum().hashCode());
        result = prime * result + ((getCbType() == null) ? 0 : getCbType().hashCode());
        result = prime * result + ((getLabel() == null) ? 0 : getLabel().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getRspLeaderId() == null) ? 0 : getRspLeaderId().hashCode());
        result = prime * result + ((getIsKeyPrj() == null) ? 0 : getIsKeyPrj().hashCode());
        result = prime * result + ((getIsFundPrj() == null) ? 0 : getIsFundPrj().hashCode());
        result = prime * result + ((getArea() == null) ? 0 : getArea().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getPlanStartYear() == null) ? 0 : getPlanStartYear().hashCode());
        result = prime * result + ((getPlanEndYear() == null) ? 0 : getPlanEndYear().hashCode());
        result = prime * result + ((getPlanStartMonth() == null) ? 0 : getPlanStartMonth().hashCode());
        result = prime * result + ((getPlanEndMonth() == null) ? 0 : getPlanEndMonth().hashCode());
        result = prime * result + ((getPlanStartDate() == null) ? 0 : getPlanStartDate().hashCode());
        result = prime * result + ((getPlanEndDate() == null) ? 0 : getPlanEndDate().hashCode());
        result = prime * result + ((getActualEndDate() == null) ? 0 : getActualEndDate().hashCode());
        result = prime * result + ((getCbFeature() == null) ? 0 : getCbFeature().hashCode());
        result = prime * result + ((getPlanInvestTotal() == null) ? 0 : getPlanInvestTotal().hashCode());
        result = prime * result + ((getExtraCbType() == null) ? 0 : getExtraCbType().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCreateAt() == null) ? 0 : getCreateAt().hashCode());
        result = prime * result + ((getUpdateAt() == null) ? 0 : getUpdateAt().hashCode());
        return result;
    }

	@Override
	public String toString() {
		return "CbPlanPrj [id=" + id + ", cbId=" + cbId + ", planNo=" + planNo + ", name=" + name + ", lng=" + lng
				+ ", lat=" + lat + ", starNum=" + starNum + ", cbType=" + cbType + ", label=" + label + ", content="
				+ content + ", rspLeaderId=" + rspLeaderId + ", isKeyPrj=" + isKeyPrj + ", isFundPrj=" + isFundPrj
				+ ", area=" + area + ", address=" + address + ", planStartYear=" + planStartYear + ", planEndYear="
				+ planEndYear + ", planStartMonth=" + planStartMonth + ", planEndMonth=" + planEndMonth
				+ ", planStartDate=" + planStartDate + ", planEndDate=" + planEndDate + ", actualEndDate="
				+ actualEndDate + ", cbFeature=" + cbFeature + ", planInvestTotal=" + planInvestTotal + ", extraCbType="
				+ extraCbType + ", remark=" + remark + ", createAt=" + createAt + ", updateAt=" + updateAt
				+ ", isDeleted=" + isDeleted + "]";
	}
    
}