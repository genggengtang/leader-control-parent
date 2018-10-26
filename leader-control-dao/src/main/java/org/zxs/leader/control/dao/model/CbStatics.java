package org.zxs.leader.control.dao.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;

@Table(name="cb_statics")
public class CbStatics {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JSONField(ordinal=1)
    private Integer id;

	@JSONField(ordinal=2)
	@Column(name="plan_no")
    private Integer planNo;

	@JSONField(ordinal=3)
	@Column(name="plan_name")
    private String planName;

	@JSONField(ordinal=4)
	@Column(name="plan_invest")
    private BigDecimal planInvest;

	@JSONField(ordinal=5)
	@Column(name="actual_invest")
    private BigDecimal actualInvest;

	@JSONField(ordinal=6)
	@Column(name="fund_cost")
    private BigDecimal fundCost;

	@JSONField(ordinal=7)
	@Column(name="prj_num")
    private Integer prjNum;

	@JSONField(ordinal=8)
	@Column(name="new_prj_num")
    private Integer newPrjNum;

	@JSONField(ordinal=9)
	@Column(name="extend_prj_num")
    private Integer extendPrjNum;

	@JSONField(ordinal=10)
	@Column(name="source_city_finance")
    private BigDecimal sourceCityFinance;

	@JSONField(ordinal=11)
	@Column(name="source_social")
    private BigDecimal sourceSocial;

	@JSONField(ordinal=12)
	@Column(name="cb_type_no")
    private Short cbTypeNo;

	@JSONField(ordinal=13)
	@Column(name="cb_label_no")
    private Short cbLabelNo;

	@JSONField(ordinal=14)
	@Column(name="url")
    private String url;
	
	@JSONField(ordinal=15)
	@Column(name="first_url")
    private String firstUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPlanNo() {
        return planNo;
    }

    public void setPlanNo(Integer planNo) {
        this.planNo = planNo;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName == null ? null : planName.trim();
    }

    public BigDecimal getPlanInvest() {
        return planInvest;
    }

    public void setPlanInvest(BigDecimal planInvest) {
        this.planInvest = planInvest;
    }

    public BigDecimal getActualInvest() {
        return actualInvest;
    }

    public void setActualInvest(BigDecimal actualInvest) {
        this.actualInvest = actualInvest;
    }

    public BigDecimal getFundCost() {
        return fundCost;
    }

    public void setFundCost(BigDecimal fundCost) {
        this.fundCost = fundCost;
    }

    public Integer getPrjNum() {
        return prjNum;
    }

    public void setPrjNum(Integer prjNum) {
        this.prjNum = prjNum;
    }

    public Integer getNewPrjNum() {
        return newPrjNum;
    }

    public void setNewPrjNum(Integer newPrjNum) {
        this.newPrjNum = newPrjNum;
    }

    public Integer getExtendPrjNum() {
        return extendPrjNum;
    }

    public void setExtendPrjNum(Integer extendPrjNum) {
        this.extendPrjNum = extendPrjNum;
    }

    public BigDecimal getSourceCityFinance() {
        return sourceCityFinance;
    }

    public void setSourceCityFinance(BigDecimal sourceCityFinance) {
        this.sourceCityFinance = sourceCityFinance;
    }

    public BigDecimal getSourceSocial() {
        return sourceSocial;
    }

    public void setSourceSocial(BigDecimal sourceSocial) {
        this.sourceSocial = sourceSocial;
    }

    public Short getCbTypeNo() {
        return cbTypeNo;
    }

    public void setCbTypeNo(Short cbTypeNo) {
        this.cbTypeNo = cbTypeNo;
    }

    public Short getCbLabelNo() {
        return cbLabelNo;
    }

    public void setCbLabelNo(Short cbLabelNo) {
        this.cbLabelNo = cbLabelNo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

	public String getFirstUrl() {
		return firstUrl;
	}

	public void setFirstUrl(String firstUrl) {
		this.firstUrl = firstUrl == null ? null : firstUrl.trim();
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
        CbStatics other = (CbStatics) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPlanNo() == null ? other.getPlanNo() == null : this.getPlanNo().equals(other.getPlanNo()))
            && (this.getPlanName() == null ? other.getPlanName() == null : this.getPlanName().equals(other.getPlanName()))
            && (this.getPlanInvest() == null ? other.getPlanInvest() == null : this.getPlanInvest().equals(other.getPlanInvest()))
            && (this.getActualInvest() == null ? other.getActualInvest() == null : this.getActualInvest().equals(other.getActualInvest()))
            && (this.getFundCost() == null ? other.getFundCost() == null : this.getFundCost().equals(other.getFundCost()))
            && (this.getPrjNum() == null ? other.getPrjNum() == null : this.getPrjNum().equals(other.getPrjNum()))
            && (this.getNewPrjNum() == null ? other.getNewPrjNum() == null : this.getNewPrjNum().equals(other.getNewPrjNum()))
            && (this.getExtendPrjNum() == null ? other.getExtendPrjNum() == null : this.getExtendPrjNum().equals(other.getExtendPrjNum()))
            && (this.getSourceCityFinance() == null ? other.getSourceCityFinance() == null : this.getSourceCityFinance().equals(other.getSourceCityFinance()))
            && (this.getSourceSocial() == null ? other.getSourceSocial() == null : this.getSourceSocial().equals(other.getSourceSocial()))
            && (this.getCbTypeNo() == null ? other.getCbTypeNo() == null : this.getCbTypeNo().equals(other.getCbTypeNo()))
            && (this.getCbLabelNo() == null ? other.getCbLabelNo() == null : this.getCbLabelNo().equals(other.getCbLabelNo()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
            && (this.getFirstUrl() == null ? other.getFirstUrl() == null : this.getFirstUrl().equals(other.getFirstUrl()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPlanNo() == null) ? 0 : getPlanNo().hashCode());
        result = prime * result + ((getPlanName() == null) ? 0 : getPlanName().hashCode());
        result = prime * result + ((getPlanInvest() == null) ? 0 : getPlanInvest().hashCode());
        result = prime * result + ((getActualInvest() == null) ? 0 : getActualInvest().hashCode());
        result = prime * result + ((getFundCost() == null) ? 0 : getFundCost().hashCode());
        result = prime * result + ((getPrjNum() == null) ? 0 : getPrjNum().hashCode());
        result = prime * result + ((getNewPrjNum() == null) ? 0 : getNewPrjNum().hashCode());
        result = prime * result + ((getExtendPrjNum() == null) ? 0 : getExtendPrjNum().hashCode());
        result = prime * result + ((getSourceCityFinance() == null) ? 0 : getSourceCityFinance().hashCode());
        result = prime * result + ((getSourceSocial() == null) ? 0 : getSourceSocial().hashCode());
        result = prime * result + ((getCbTypeNo() == null) ? 0 : getCbTypeNo().hashCode());
        result = prime * result + ((getCbLabelNo() == null) ? 0 : getCbLabelNo().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getFirstUrl() == null) ? 0 : getFirstUrl().hashCode());
        return result;
    }
}