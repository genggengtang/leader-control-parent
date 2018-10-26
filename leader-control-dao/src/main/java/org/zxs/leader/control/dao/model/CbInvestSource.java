package org.zxs.leader.control.dao.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;

@Table(name="cb_invest_source")
public class CbInvestSource {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JSONField(ordinal=1)
    private Integer id;

	@JSONField(ordinal=2)
	@Column(name="prj_plan_id")
    private Integer prjPlanId;

	@JSONField(ordinal=3)
	@Column(name="source_no")
    private Integer sourceNo;

	@JSONField(ordinal=4)
	@Column(name="source_type_no")
    private Integer sourceTypeNo;

	@JSONField(ordinal=5)
	@Column(name="plan_invest")
    private Integer planInvest;

	@JSONField(ordinal=6)
	@Column(name="actual_invest")
    private Integer actualInvest;

	@JSONField(ordinal=7)
	@Column(name="create_at")
    private Date createAt;

	@JSONField(ordinal=8)
	@Column(name="update_at")
    private Date updateAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrjPlanId() {
        return prjPlanId;
    }

    public void setPrjPlanId(Integer prjPlanId) {
        this.prjPlanId = prjPlanId;
    }

    public Integer getSourceNo() {
        return sourceNo;
    }

    public void setSourceNo(Integer sourceNo) {
        this.sourceNo = sourceNo;
    }

    public Integer getSourceTypeNo() {
        return sourceTypeNo;
    }

    public void setSourceTypeNo(Integer sourceTypeNo) {
        this.sourceTypeNo = sourceTypeNo;
    }

    public Integer getPlanInvest() {
        return planInvest;
    }

    public void setPlanInvest(Integer planInvest) {
        this.planInvest = planInvest;
    }

    public Integer getActualInvest() {
        return actualInvest;
    }

    public void setActualInvest(Integer actualInvest) {
        this.actualInvest = actualInvest;
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
        CbInvestSource other = (CbInvestSource) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPrjPlanId() == null ? other.getPrjPlanId() == null : this.getPrjPlanId().equals(other.getPrjPlanId()))
            && (this.getSourceNo() == null ? other.getSourceNo() == null : this.getSourceNo().equals(other.getSourceNo()))
            && (this.getSourceTypeNo() == null ? other.getSourceTypeNo() == null : this.getSourceTypeNo().equals(other.getSourceTypeNo()))
            && (this.getPlanInvest() == null ? other.getPlanInvest() == null : this.getPlanInvest().equals(other.getPlanInvest()))
            && (this.getActualInvest() == null ? other.getActualInvest() == null : this.getActualInvest().equals(other.getActualInvest()))
            && (this.getCreateAt() == null ? other.getCreateAt() == null : this.getCreateAt().equals(other.getCreateAt()))
            && (this.getUpdateAt() == null ? other.getUpdateAt() == null : this.getUpdateAt().equals(other.getUpdateAt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPrjPlanId() == null) ? 0 : getPrjPlanId().hashCode());
        result = prime * result + ((getSourceNo() == null) ? 0 : getSourceNo().hashCode());
        result = prime * result + ((getSourceTypeNo() == null) ? 0 : getSourceTypeNo().hashCode());
        result = prime * result + ((getPlanInvest() == null) ? 0 : getPlanInvest().hashCode());
        result = prime * result + ((getActualInvest() == null) ? 0 : getActualInvest().hashCode());
        result = prime * result + ((getCreateAt() == null) ? 0 : getCreateAt().hashCode());
        result = prime * result + ((getUpdateAt() == null) ? 0 : getUpdateAt().hashCode());
        return result;
    }

	@Override
	public String toString() {
		return "CbInvestSource [id=" + id + ", prjPlanId=" + prjPlanId + ", sourceNo=" + sourceNo + ", sourceTypeNo="
				+ sourceTypeNo + ", planInvest=" + planInvest + ", actualInvest=" + actualInvest + ", createAt="
				+ createAt + ", updateAt=" + updateAt + "]";
	}
    
}