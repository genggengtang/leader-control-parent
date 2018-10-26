package org.zxs.leader.control.dao.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;

@Table(name="prj_point")
public class PrjPoint {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JSONField(ordinal=1)
    private Long id;

	@JSONField(ordinal=2)
	@Column(name="prj_line_id")
    private Integer prjLineId;

	@JSONField(ordinal=3)
	@Column(name="lng")
    private BigDecimal lng;

	@JSONField(ordinal=4)
	@Column(name="lat")
    private BigDecimal lat;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPrjLineId() {
        return prjLineId;
    }

    public void setPrjLineId(Integer prjLineId) {
        this.prjLineId = prjLineId;
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
        PrjPoint other = (PrjPoint) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPrjLineId() == null ? other.getPrjLineId() == null : this.getPrjLineId().equals(other.getPrjLineId()))
            && (this.getLng() == null ? other.getLng() == null : this.getLng().equals(other.getLng()))
            && (this.getLat() == null ? other.getLat() == null : this.getLat().equals(other.getLat()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPrjLineId() == null) ? 0 : getPrjLineId().hashCode());
        result = prime * result + ((getLng() == null) ? 0 : getLng().hashCode());
        result = prime * result + ((getLat() == null) ? 0 : getLat().hashCode());
        return result;
    }

	@Override
	public String toString() {
		return "PrjPoint [id=" + id + ", prjLineId=" + prjLineId + ", lng=" + lng + ", lat=" + lat + "]";
	}
    
}