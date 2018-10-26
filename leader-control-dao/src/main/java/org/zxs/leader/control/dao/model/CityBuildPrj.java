package org.zxs.leader.control.dao.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;

@Table(name="city_build_prj")
public class CityBuildPrj {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JSONField(ordinal=1)
    private Integer id;

	@JSONField(ordinal=2)
	@Column(name="prj_db_no")
    private String prjDbNo;

	@JSONField(ordinal=3)
	@Column(name="current_plan_no")
    private Integer currentPlanNo;
	
	@JSONField(ordinal=4)
	@Column(name="prj_content")
    private String prjContent;

	@JSONField(ordinal=5)
	@Column(name="prj_start_year")
    private Integer prjStartYear;

	@JSONField(ordinal=6)
	@Column(name="prj_end_year")
    private Integer prjEndYear;
	
	@JSONField(ordinal=7)
	@Column(name="actual_start_date")
    private Date actualStartDate;

	@JSONField(ordinal=8)
	@Column(name="actual_end_date")
    private Date actualEndDate;

	@JSONField(ordinal=9)
	@Column(name="prj_invest_total")
    private Integer prjInvestTotal;

	@JSONField(ordinal=10)
	@Column(name="remark")
    private String remark;

	@JSONField(ordinal=11)
	@Column(name="create_at")
    private Date createAt;

	@JSONField(ordinal=12)
	@Column(name="update_at")
    private Date updateAt;
	
	@JSONField(ordinal=13)
	@Column(name="is_deleted")
    private Boolean isDeleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrjDbNo() {
        return prjDbNo;
    }

    public void setPrjDbNo(String prjDbNo) {
        this.prjDbNo = prjDbNo == null ? null : prjDbNo.trim();
    }

    public Integer getCurrentPlanNo() {
        return currentPlanNo;
    }

    public void setCurrentPlanNo(Integer currentPlanNo) {
        this.currentPlanNo = currentPlanNo;
    }

    public String getPrjContent() {
		return prjContent;
	}

	public void setPrjContent(String prjContent) {
		this.prjContent = prjContent == null ? null : prjContent.trim();
	}

	public Integer getPrjStartYear() {
        return prjStartYear;
    }

    public void setPrjStartYear(Integer prjStartYear) {
        this.prjStartYear = prjStartYear;
    }

    public Integer getPrjEndYear() {
        return prjEndYear;
    }

    public void setPrjEndYear(Integer prjEndYear) {
        this.prjEndYear = prjEndYear;
    }

    public Date getActualStartDate() {
		return actualStartDate;
	}

	public void setActualStartDate(Date actualStartDate) {
		this.actualStartDate = actualStartDate;
	}

	public Date getActualEndDate() {
        return actualEndDate;
    }

    public void setActualEndDate(Date actualEndDate) {
        this.actualEndDate = actualEndDate;
    }

    public Integer getPrjInvestTotal() {
        return prjInvestTotal;
    }

    public void setPrjInvestTotal(Integer prjInvestTotal) {
        this.prjInvestTotal = prjInvestTotal;
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
        CityBuildPrj other = (CityBuildPrj) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPrjDbNo() == null ? other.getPrjDbNo() == null : this.getPrjDbNo().equals(other.getPrjDbNo()))
            && (this.getCurrentPlanNo() == null ? other.getCurrentPlanNo() == null : this.getCurrentPlanNo().equals(other.getCurrentPlanNo()))
            && (this.getPrjContent() == null ? other.getPrjContent() == null : this.getPrjContent().equals(other.getPrjContent()))
            && (this.getPrjStartYear() == null ? other.getPrjStartYear() == null : this.getPrjStartYear().equals(other.getPrjStartYear()))
            && (this.getPrjEndYear() == null ? other.getPrjEndYear() == null : this.getPrjEndYear().equals(other.getPrjEndYear()))
            && (this.getActualStartDate() == null ? other.getActualStartDate() == null : this.getActualStartDate().equals(other.getActualStartDate()))
            && (this.getActualEndDate() == null ? other.getActualEndDate() == null : this.getActualEndDate().equals(other.getActualEndDate()))
            && (this.getPrjInvestTotal() == null ? other.getPrjInvestTotal() == null : this.getPrjInvestTotal().equals(other.getPrjInvestTotal()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getCreateAt() == null ? other.getCreateAt() == null : this.getCreateAt().equals(other.getCreateAt()))
            && (this.getUpdateAt() == null ? other.getUpdateAt() == null : this.getUpdateAt().equals(other.getUpdateAt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPrjDbNo() == null) ? 0 : getPrjDbNo().hashCode());
        result = prime * result + ((getCurrentPlanNo() == null) ? 0 : getCurrentPlanNo().hashCode());
        result = prime * result + ((getPrjContent() == null) ? 0 : getPrjContent().hashCode());
        result = prime * result + ((getPrjStartYear() == null) ? 0 : getPrjStartYear().hashCode());
        result = prime * result + ((getPrjEndYear() == null) ? 0 : getPrjEndYear().hashCode());
        result = prime * result + ((getActualStartDate() == null) ? 0 : getActualStartDate().hashCode());
        result = prime * result + ((getActualEndDate() == null) ? 0 : getActualEndDate().hashCode());
        result = prime * result + ((getPrjInvestTotal() == null) ? 0 : getPrjInvestTotal().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCreateAt() == null) ? 0 : getCreateAt().hashCode());
        result = prime * result + ((getUpdateAt() == null) ? 0 : getUpdateAt().hashCode());
        return result;
    }

	@Override
	public String toString() {
		return "CityBuildPrj [id=" + id + ", prjDbNo=" + prjDbNo + ", currentPlanNo=" + currentPlanNo + ", prjContent="
				+ prjContent + ", prjStartYear=" + prjStartYear + ", prjEndYear=" + prjEndYear + ", actualStartDate="
				+ actualStartDate + ", actualEndDate=" + actualEndDate + ", prjInvestTotal=" + prjInvestTotal
				+ ", remark=" + remark + ", createAt=" + createAt + ", updateAt=" + updateAt + ", isDeleted="
				+ isDeleted + "]";
	}
    
}