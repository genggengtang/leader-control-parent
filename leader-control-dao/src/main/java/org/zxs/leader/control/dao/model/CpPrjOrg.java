package org.zxs.leader.control.dao.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;

@Table(name="cp_prj_org")
public class CpPrjOrg {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JSONField(ordinal=1)
    private Integer id;
	
	@JSONField(ordinal=2)
	@Column(name="prj_type")
    private Integer prjType;

	@JSONField(ordinal=3)
	@Column(name="cp_prj_id")
    private Integer cpPrjId;

	@JSONField(ordinal=4)
	@Column(name="org_id")
    private Integer orgId;

	@JSONField(ordinal=5)
	@Column(name="relate_type")
    private Integer relateType;
	
	@JSONField(ordinal=6)
	@Column(name="contact_name")
    private String contactName;
	
	@JSONField(ordinal=7)
	@Column(name="contact_phone")
    private String contactPhone;
	
	@JSONField(ordinal=8)
	@Column(name="is_mth_org_show")
	private Byte isMthOrgShow;

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

	public Integer getCpPrjId() {
        return cpPrjId;
    }

    public void setCpPrjId(Integer cpPrjId) {
        this.cpPrjId = cpPrjId;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getRelateType() {
        return relateType;
    }

    public void setRelateType(Integer relateType) {
        this.relateType = relateType;
    }

    public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public Byte getIsMthOrgShow() {
		return isMthOrgShow;
	}

	public void setIsMthOrgShow(Byte isMthOrgShow) {
		this.isMthOrgShow = isMthOrgShow;
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
        CpPrjOrg other = (CpPrjOrg) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        	&& (this.getPrjType() == null ? other.getPrjType() == null : this.getPrjType().equals(other.getPrjType()))
            && (this.getCpPrjId() == null ? other.getCpPrjId() == null : this.getCpPrjId().equals(other.getCpPrjId()))
            && (this.getOrgId() == null ? other.getOrgId() == null : this.getOrgId().equals(other.getOrgId()))
            && (this.getRelateType() == null ? other.getRelateType() == null : this.getRelateType().equals(other.getRelateType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPrjType() == null) ? 0 : getPrjType().hashCode());
        result = prime * result + ((getCpPrjId() == null) ? 0 : getCpPrjId().hashCode());
        result = prime * result + ((getOrgId() == null) ? 0 : getOrgId().hashCode());
        result = prime * result + ((getRelateType() == null) ? 0 : getRelateType().hashCode());
        return result;
    }
}