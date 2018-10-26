package org.zxs.leader.control.dao.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;

@Table(name="prj_year_plan")
public class PrjYearPlan {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JSONField(ordinal=1)
    private Integer id;
	
	@JSONField(ordinal=2)
	@Column(name="prj_type")
    private Integer prjType;

	@JSONField(ordinal=3)
	@Column(name="prj_id")
    private Integer prjId;

	@JSONField(ordinal=4)
	@Column(name="year")
    private Short year;

	@JSONField(ordinal=5)
	@Column(name="plan_invest")
    private Integer planInvest;

	@JSONField(ordinal=6)
	@Column(name="plan_content")
    private String planContent;
	
	@JSONField(ordinal=7)
	@Column(name="pre_content")
    private String preContent;

//	@JSONField(ordinal=8)
//	@Column(name="actual_invest")
//    private Integer actualInvest;

	@JSONField(ordinal=8)
	@Column(name="actual_content")
    private String actualContent;
	
	@JSONField(ordinal=9)
	@Column(name="accm_plan_invest")
    private Integer accmPlanInvest;
	
	@JSONField(ordinal=10)
	@Column(name="accm_actual_invest")
    private Integer accmActualInvest;
	
	@JSONField(ordinal=11)
	@Column(name="s1_plan_invest")
    private Integer s1PlanInvest;
	
	@JSONField(ordinal=12)
	@Column(name="s2_plan_invest")
    private Integer s2PlanInvest;
	
	@JSONField(ordinal=13)
	@Column(name="s3_plan_invest")
    private Integer s3PlanInvest;
	
	@JSONField(ordinal=14)
	@Column(name="s4_plan_invest")
    private Integer s4PlanInvest;
	
	@JSONField(ordinal=15)
	@Column(name="s1_plan_content")
    private String s1PlanContent;
	
	@JSONField(ordinal=16)
	@Column(name="s2_plan_content")
    private String s2PlanContent;
	
	@JSONField(ordinal=17)
	@Column(name="s3_plan_content")
    private String s3PlanContent;
	
	@JSONField(ordinal=18)
	@Column(name="s4_plan_content")
    private String s4PlanContent;

	@JSONField(ordinal=19)
	@Column(name="create_at")
    private Date createAt;

	@JSONField(ordinal=20)
	@Column(name="update_at")
    private Date updateAt;
	
	@JSONField(ordinal=21)
	@Column(name="is_deleted")
	private Boolean isDeleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrjType() {
		return prjType;
	}

	public void setPrjType(Integer prjType) {
		this.prjType = prjType;
	}

	public Integer getPrjId() {
        return prjId;
    }

    public void setPrjId(Integer prjId) {
        this.prjId = prjId;
    }

    public Short getYear() {
        return year;
    }

    public void setYear(Short year) {
        this.year = year;
    }

    public Integer getPlanInvest() {
        return planInvest;
    }

    public void setPlanInvest(Integer planInvest) {
        this.planInvest = planInvest;
    }

    public String getPlanContent() {
        return planContent;
    }

    public void setPlanContent(String planContent) {
        this.planContent = planContent == null ? null : planContent.trim();
    }

    public String getPreContent() {
		return preContent;
	}

	public void setPreContent(String preContent) {
		this.preContent = preContent == null ? null : preContent.trim();
	}

    public String getActualContent() {
        return actualContent;
    }

    public void setActualContent(String actualContent) {
        this.actualContent = actualContent == null ? null : actualContent.trim();
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

	public Integer getS1PlanInvest() {
		return s1PlanInvest;
	}

	public void setS1PlanInvest(Integer s1PlanInvest) {
		this.s1PlanInvest = s1PlanInvest;
	}

	public Integer getS2PlanInvest() {
		return s2PlanInvest;
	}

	public void setS2PlanInvest(Integer s2PlanInvest) {
		this.s2PlanInvest = s2PlanInvest;
	}

	public Integer getS3PlanInvest() {
		return s3PlanInvest;
	}

	public void setS3PlanInvest(Integer s3PlanInvest) {
		this.s3PlanInvest = s3PlanInvest;
	}

	public Integer getS4PlanInvest() {
		return s4PlanInvest;
	}

	public void setS4PlanInvest(Integer s4PlanInvest) {
		this.s4PlanInvest = s4PlanInvest;
	}

	public String getS1PlanContent() {
		return s1PlanContent;
	}

	public void setS1PlanContent(String s1PlanContent) {
		this.s1PlanContent = s1PlanContent;
	}

	public String getS2PlanContent() {
		return s2PlanContent;
	}

	public void setS2PlanContent(String s2PlanContent) {
		this.s2PlanContent = s2PlanContent;
	}

	public String getS3PlanContent() {
		return s3PlanContent;
	}

	public void setS3PlanContent(String s3PlanContent) {
		this.s3PlanContent = s3PlanContent;
	}

	public String getS4PlanContent() {
		return s4PlanContent;
	}

	public void setS4PlanContent(String s4PlanContent) {
		this.s4PlanContent = s4PlanContent;
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
        PrjYearPlan other = (PrjYearPlan) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        	&& (this.getPrjType() == null ? other.getPrjType() == null : this.getPrjType().equals(other.getPrjType()))
            && (this.getPrjId() == null ? other.getPrjId() == null : this.getPrjId().equals(other.getPrjId()))
            && (this.getYear() == null ? other.getYear() == null : this.getYear().equals(other.getYear()))
            && (this.getPlanInvest() == null ? other.getPlanInvest() == null : this.getPlanInvest().equals(other.getPlanInvest()))
            && (this.getPlanContent() == null ? other.getPlanContent() == null : this.getPlanContent().equals(other.getPlanContent()))
            && (this.getPreContent() == null ? other.getPreContent() == null : this.getPreContent().equals(other.getPreContent()))
            && (this.getActualContent() == null ? other.getActualContent() == null : this.getActualContent().equals(other.getActualContent()))
            && (this.getAccmPlanInvest() == null ? other.getAccmPlanInvest() == null : this.getAccmPlanInvest().equals(other.getAccmPlanInvest()))
            && (this.getAccmActualInvest() == null ? other.getAccmActualInvest() == null : this.getAccmActualInvest().equals(other.getAccmActualInvest()))
            && (this.getS1PlanInvest() == null ? other.getS1PlanInvest() == null : this.getS1PlanInvest().equals(other.getS1PlanInvest()))
            && (this.getS2PlanInvest() == null ? other.getS2PlanInvest() == null : this.getS2PlanInvest().equals(other.getS2PlanInvest()))
            && (this.getS3PlanInvest() == null ? other.getS3PlanInvest() == null : this.getS3PlanInvest().equals(other.getS3PlanInvest()))
            && (this.getS4PlanInvest() == null ? other.getS4PlanInvest() == null : this.getS4PlanInvest().equals(other.getS4PlanInvest()))
            && (this.getS1PlanContent() == null ? other.getS1PlanContent() == null : this.getS1PlanContent().equals(other.getS1PlanContent()))
            && (this.getS2PlanContent() == null ? other.getS2PlanContent() == null : this.getS2PlanContent().equals(other.getS2PlanContent()))
            && (this.getS3PlanContent() == null ? other.getS3PlanContent() == null : this.getS3PlanContent().equals(other.getS3PlanContent()))
            && (this.getS4PlanContent() == null ? other.getS4PlanContent() == null : this.getS4PlanContent().equals(other.getS4PlanContent()))
            && (this.getCreateAt() == null ? other.getCreateAt() == null : this.getCreateAt().equals(other.getCreateAt()))
            && (this.getUpdateAt() == null ? other.getUpdateAt() == null : this.getUpdateAt().equals(other.getUpdateAt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPrjType() == null) ? 0 : getPrjType().hashCode());
        result = prime * result + ((getPrjId() == null) ? 0 : getPrjId().hashCode());
        result = prime * result + ((getYear() == null) ? 0 : getYear().hashCode());
        result = prime * result + ((getPlanInvest() == null) ? 0 : getPlanInvest().hashCode());
        result = prime * result + ((getPlanContent() == null) ? 0 : getPlanContent().hashCode());
        result = prime * result + ((getPreContent() == null) ? 0 : getPreContent().hashCode());
        result = prime * result + ((getActualContent() == null) ? 0 : getActualContent().hashCode());
        result = prime * result + ((getAccmPlanInvest() == null) ? 0 : getAccmPlanInvest().hashCode());
        result = prime * result + ((getAccmActualInvest() == null) ? 0 : getAccmActualInvest().hashCode());
        result = prime * result + ((getS1PlanInvest() == null) ? 0 : getS1PlanInvest().hashCode());
        result = prime * result + ((getS2PlanInvest() == null) ? 0 : getS2PlanInvest().hashCode());
        result = prime * result + ((getS3PlanInvest() == null) ? 0 : getS3PlanInvest().hashCode());
        result = prime * result + ((getS4PlanInvest() == null) ? 0 : getS4PlanInvest().hashCode());
        result = prime * result + ((getS1PlanContent() == null) ? 0 : getS1PlanContent().hashCode());
        result = prime * result + ((getS2PlanContent() == null) ? 0 : getS2PlanContent().hashCode());
        result = prime * result + ((getS3PlanContent() == null) ? 0 : getS3PlanContent().hashCode());
        result = prime * result + ((getS4PlanContent() == null) ? 0 : getS4PlanContent().hashCode());
        result = prime * result + ((getCreateAt() == null) ? 0 : getCreateAt().hashCode());
        result = prime * result + ((getUpdateAt() == null) ? 0 : getUpdateAt().hashCode());
        return result;
    }
}