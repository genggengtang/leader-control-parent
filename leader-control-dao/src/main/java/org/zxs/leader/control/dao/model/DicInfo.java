package org.zxs.leader.control.dao.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;

@Table(name="dic_info")
public class DicInfo {
	@Id
	@JSONField(ordinal=1)
    private Integer id;

	@JSONField(ordinal=2)
	@Column(name="type")
    private Short type;

	@JSONField(ordinal=3)
	@Column(name="type_remark")
    private String typeRemark;

	@JSONField(ordinal=4)
	@Column(name="value_remark")
    private String valueRemark;
	
	@JSONField(ordinal=5)
	@Column(name="short_remark")
    private String shortRemark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public String getTypeRemark() {
        return typeRemark;
    }

    public void setTypeRemark(String typeRemark) {
        this.typeRemark = typeRemark == null ? null : typeRemark.trim();
    }

    public String getValueRemark() {
        return valueRemark;
    }

    public void setValueRemark(String valueRemark) {
        this.valueRemark = valueRemark == null ? null : valueRemark.trim();
    }

    public String getShortRemark() {
		return shortRemark;
	}

	public void setShortRemark(String shortRemark) {
		this.shortRemark = shortRemark == null ? null : shortRemark.trim();
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
        DicInfo other = (DicInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getTypeRemark() == null ? other.getTypeRemark() == null : this.getTypeRemark().equals(other.getTypeRemark()))
            && (this.getValueRemark() == null ? other.getValueRemark() == null : this.getValueRemark().equals(other.getValueRemark()))
            && (this.getShortRemark() == null ? other.getShortRemark() == null : this.getShortRemark().equals(other.getShortRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getTypeRemark() == null) ? 0 : getTypeRemark().hashCode());
        result = prime * result + ((getValueRemark() == null) ? 0 : getValueRemark().hashCode());
        result = prime * result + ((getShortRemark() == null) ? 0 : getShortRemark().hashCode());
        return result;
    }
}