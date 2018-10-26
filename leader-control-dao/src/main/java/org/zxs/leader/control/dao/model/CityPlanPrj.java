package org.zxs.leader.control.dao.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;

@Table(name="city_plan_prj")
public class CityPlanPrj {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JSONField(ordinal=1)
    private Integer id;

	@JSONField(ordinal=2)
	@Column(name="name")
    private String name;

	@JSONField(ordinal=3)
	@Column(name="type")
    private Integer type;

	@JSONField(ordinal=4)
	@Column(name="label")
    private String label;

	@JSONField(ordinal=5)
	@Column(name="content")
    private String content;

	@JSONField(ordinal=6)
	@Column(name="plan_start_year")
    private Integer planStartYear;

	@JSONField(ordinal=7)
	@Column(name="plan_end_year")
    private Integer planEndYear;

	@JSONField(ordinal=8)
	@Column(name="plan_start_month")
    private Byte planStartMonth;
	
	@JSONField(ordinal=9)
	@Column(name="plan_end_month")
    private Byte planEndMonth;

	@JSONField(ordinal=10)
	@Column(name="plan_status")
    private Integer planStatus;

	@JSONField(ordinal=11)
	@Column(name="invest_source")
    private String investSource;

	@JSONField(ordinal=12)
	@Column(name="plan_invest_total")
    private Integer planInvestTotal;

	@JSONField(ordinal=13)
	@Column(name="area")
    private String area;

	@JSONField(ordinal=14)
	@Column(name="area_admin")
    private Short areaAdmin;

	@JSONField(ordinal=15)
	@Column(name="prj_db_id")
    private String prjDbId;

	@JSONField(ordinal=16)
	@Column(name="prj_db_no")
    private String prjDbNo;

	@JSONField(ordinal=17)
	@Column(name="is_prj_db")
    private Byte isPrjDb;
	
	@JSONField(ordinal=18)
	@Column(name="latest_year_id")
    private Integer latestYearId;

	@JSONField(ordinal=19)
	@Column(name="remark")
    private String remark;
	
	@JSONField(ordinal=20)
	@Column(name="remark_display")
    private String remarkDisplay;

	@JSONField(ordinal=21)
	@Column(name="create_at")
    private Date createAt;
	
	@JSONField(ordinal=22)
	@Column(name="is_deleted")
    private Boolean isDeleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

	public Integer getPlanStatus() {
        return planStatus;
    }

    public void setPlanStatus(Integer planStatus) {
        this.planStatus = planStatus;
    }

    public String getInvestSource() {
        return investSource;
    }

    public void setInvestSource(String investSource) {
        this.investSource = investSource == null ? null : investSource.trim();
    }

    public Integer getPlanInvestTotal() {
        return planInvestTotal;
    }

    public void setPlanInvestTotal(Integer planInvestTotal) {
        this.planInvestTotal = planInvestTotal;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public Short getAreaAdmin() {
        return areaAdmin;
    }

    public void setAreaAdmin(Short areaAdmin) {
        this.areaAdmin = areaAdmin;
    }

    public String getPrjDbId() {
		return prjDbId;
	}

	public void setPrjDbId(String prjDbId) {
		this.prjDbId = prjDbId == null ? null : prjDbId.trim();
	}

	public String getPrjDbNo() {
        return prjDbNo;
    }

    public void setPrjDbNo(String prjDbNo) {
        this.prjDbNo = prjDbNo == null ? null : prjDbNo.trim();
    }

    public Byte getIsPrjDb() {
        return isPrjDb;
    }

    public void setIsPrjDb(Byte isPrjDb) {
        this.isPrjDb = isPrjDb;
    }

    public Integer getLatestYearId() {
		return latestYearId;
	}

	public void setLatestYearId(Integer latestYearId) {
		this.latestYearId = latestYearId;
	}

	public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
        CityPlanPrj other = (CityPlanPrj) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getLabel() == null ? other.getLabel() == null : this.getLabel().equals(other.getLabel()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getPlanStartYear() == null ? other.getPlanStartYear() == null : this.getPlanStartYear().equals(other.getPlanStartYear()))
            && (this.getPlanEndYear() == null ? other.getPlanEndYear() == null : this.getPlanEndYear().equals(other.getPlanEndYear()))
            && (this.getPlanStartMonth() == null ? other.getPlanStartMonth() == null : this.getPlanStartMonth().equals(other.getPlanStartMonth()))
            && (this.getPlanEndMonth() == null ? other.getPlanEndMonth() == null : this.getPlanEndMonth().equals(other.getPlanEndMonth()))
            && (this.getPlanStatus() == null ? other.getPlanStatus() == null : this.getPlanStatus().equals(other.getPlanStatus()))
            && (this.getInvestSource() == null ? other.getInvestSource() == null : this.getInvestSource().equals(other.getInvestSource()))
            && (this.getPlanInvestTotal() == null ? other.getPlanInvestTotal() == null : this.getPlanInvestTotal().equals(other.getPlanInvestTotal()))
            && (this.getArea() == null ? other.getArea() == null : this.getArea().equals(other.getArea()))
            && (this.getAreaAdmin() == null ? other.getAreaAdmin() == null : this.getAreaAdmin().equals(other.getAreaAdmin()))
            && (this.getPrjDbId() == null ? other.getPrjDbId() == null : this.getPrjDbId().equals(other.getPrjDbId()))
            && (this.getPrjDbNo() == null ? other.getPrjDbNo() == null : this.getPrjDbNo().equals(other.getPrjDbNo()))
            && (this.getIsPrjDb() == null ? other.getIsPrjDb() == null : this.getIsPrjDb().equals(other.getIsPrjDb()))
            && (this.getLatestYearId() == null ? other.getLatestYearId() == null : this.getLatestYearId().equals(other.getLatestYearId()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getRemarkDisplay() == null ? other.getRemarkDisplay() == null : this.getRemarkDisplay().equals(other.getRemarkDisplay()))
            && (this.getCreateAt() == null ? other.getCreateAt() == null : this.getCreateAt().equals(other.getCreateAt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getLabel() == null) ? 0 : getLabel().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getPlanStartYear() == null) ? 0 : getPlanStartYear().hashCode());
        result = prime * result + ((getPlanEndYear() == null) ? 0 : getPlanEndYear().hashCode());
        result = prime * result + ((getPlanStartMonth() == null) ? 0 : getPlanStartMonth().hashCode());
        result = prime * result + ((getPlanEndMonth() == null) ? 0 : getPlanEndMonth().hashCode());
        result = prime * result + ((getPlanStatus() == null) ? 0 : getPlanStatus().hashCode());
        result = prime * result + ((getInvestSource() == null) ? 0 : getInvestSource().hashCode());
        result = prime * result + ((getPlanInvestTotal() == null) ? 0 : getPlanInvestTotal().hashCode());
        result = prime * result + ((getArea() == null) ? 0 : getArea().hashCode());
        result = prime * result + ((getAreaAdmin() == null) ? 0 : getAreaAdmin().hashCode());
        result = prime * result + ((getPrjDbId() == null) ? 0 : getPrjDbId().hashCode());
        result = prime * result + ((getPrjDbNo() == null) ? 0 : getPrjDbNo().hashCode());
        result = prime * result + ((getIsPrjDb() == null) ? 0 : getIsPrjDb().hashCode());
        result = prime * result + ((getLatestYearId() == null) ? 0 : getLatestYearId().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getRemarkDisplay() == null) ? 0 : getRemarkDisplay().hashCode());
        result = prime * result + ((getCreateAt() == null) ? 0 : getCreateAt().hashCode());
        return result;
    }
}