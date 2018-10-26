package org.zxs.leader.control.dao.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;

@Table(name="opt_info")
public class OptInfo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JSONField(ordinal=1)
    private Long id;

	@JSONField(ordinal=2)
	@Column(name="device_id")
    private Integer deviceId;

	@JSONField(ordinal=3)
	@Column(name="user_id")
    private Integer userId;

	@JSONField(ordinal=4)
	@Column(name="opt_type")
    private Integer optType;
	
	@JSONField(ordinal=5)
	@Column(name="prj_type")
    private Integer prjType;

	@JSONField(ordinal=6)
	@Column(name="opt_ret")
    private Byte optRet;

	@JSONField(ordinal=7)
	@Column(name="opt_msg")
    private String optMsg;

	@JSONField(ordinal=8)
	@Column(name="opt_at")
    private Date optAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOptType() {
        return optType;
    }

    public void setOptType(Integer optType) {
        this.optType = optType;
    }

    public Integer getPrjType() {
		return prjType;
	}

	public void setPrjType(Integer prjType) {
		this.prjType = prjType;
	}

	public Byte getOptRet() {
        return optRet;
    }

    public void setOptRet(Byte optRet) {
        this.optRet = optRet;
    }

    public String getOptMsg() {
        return optMsg;
    }

    public void setOptMsg(String optMsg) {
        this.optMsg = optMsg == null ? null : optMsg.trim();
    }

    public Date getOptAt() {
        return optAt;
    }

    public void setOptAt(Date optAt) {
        this.optAt = optAt;
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
        OptInfo other = (OptInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDeviceId() == null ? other.getDeviceId() == null : this.getDeviceId().equals(other.getDeviceId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getOptType() == null ? other.getOptType() == null : this.getOptType().equals(other.getOptType()))
            && (this.getPrjType() == null ? other.getPrjType() == null : this.getPrjType().equals(other.getPrjType()))
            && (this.getOptRet() == null ? other.getOptRet() == null : this.getOptRet().equals(other.getOptRet()))
            && (this.getOptMsg() == null ? other.getOptMsg() == null : this.getOptMsg().equals(other.getOptMsg()))
            && (this.getOptAt() == null ? other.getOptAt() == null : this.getOptAt().equals(other.getOptAt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDeviceId() == null) ? 0 : getDeviceId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getOptType() == null) ? 0 : getOptType().hashCode());
        result = prime * result + ((getPrjType() == null) ? 0 : getPrjType().hashCode());
        result = prime * result + ((getOptRet() == null) ? 0 : getOptRet().hashCode());
        result = prime * result + ((getOptMsg() == null) ? 0 : getOptMsg().hashCode());
        result = prime * result + ((getOptAt() == null) ? 0 : getOptAt().hashCode());
        return result;
    }
}