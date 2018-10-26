package org.zxs.leader.control.dao.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;

@Table(name="chat_group_info")
public class ChatGroupInfo {
	public static final byte TYPE_WORK = 1;
	public static final byte TYPE_MIME = 2;
	public static final byte TYPE_OTHER = 3;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JSONField(ordinal=1)
    private Integer id;

	@JSONField(ordinal=2)
	@Column(name="group_name")
    private String groupName;

	@JSONField(ordinal=3)
	@Column(name="type")
    private Byte type;
	
	@JSONField(ordinal=4)
	@Column(name="prj_type")
    private Integer prjType;

	@JSONField(ordinal=5)
	@Column(name="prj_id")
    private Integer prjId;

	@JSONField(ordinal=6)
	@Column(name="introduce")
    private String introduce;
	
	@JSONField(ordinal=7)
	@Column(name="enable_name_update", columnDefinition="是否允许修改群名")
    private Short enableNameUpdate;
	
	@JSONField(ordinal=8)
	@Column(name="enable_remove", columnDefinition="是否允许群解散")
    private Short enableRemove;

	@JSONField(ordinal=9)
	@Column(name="create_at")
    private Date createAt;
	
	@JSONField(ordinal=10)
	@Column(name="update_at")
    private Date updateAt;
	
	@JSONField(ordinal=11)
	@Column(name="is_deleted")
    private Boolean isDeleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
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

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    public Short getEnableNameUpdate() {
		return enableNameUpdate;
	}

	public void setEnableNameUpdate(Short enableNameUpdate) {
		this.enableNameUpdate = enableNameUpdate;
	}

	public Short getEnableRemove() {
		return enableRemove;
	}

	public void setEnableRemove(Short enableRemove) {
		this.enableRemove = enableRemove;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
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
        ChatGroupInfo other = (ChatGroupInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGroupName() == null ? other.getGroupName() == null : this.getGroupName().equals(other.getGroupName()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getPrjType() == null ? other.getPrjType() == null : this.getPrjType().equals(other.getPrjType()))
            && (this.getPrjId() == null ? other.getPrjId() == null : this.getPrjId().equals(other.getPrjId()))
            && (this.getIntroduce() == null ? other.getIntroduce() == null : this.getIntroduce().equals(other.getIntroduce()))
            && (this.getEnableNameUpdate() == null ? other.getEnableNameUpdate() == null : this.getEnableNameUpdate().equals(other.getEnableNameUpdate()))
            && (this.getEnableRemove() == null ? other.getEnableRemove() == null : this.getEnableRemove().equals(other.getEnableRemove()))
            && (this.getCreateAt() == null ? other.getCreateAt() == null : this.getCreateAt().equals(other.getCreateAt()))
            && (this.getUpdateAt() == null ? other.getUpdateAt() == null : this.getUpdateAt().equals(other.getUpdateAt()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGroupName() == null) ? 0 : getGroupName().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getPrjType() == null) ? 0 : getPrjType().hashCode());
        result = prime * result + ((getPrjId() == null) ? 0 : getPrjId().hashCode());
        result = prime * result + ((getIntroduce() == null) ? 0 : getIntroduce().hashCode());
        result = prime * result + ((getEnableNameUpdate() == null) ? 0 : getEnableNameUpdate().hashCode());
        result = prime * result + ((getEnableRemove() == null) ? 0 : getEnableRemove().hashCode());
        result = prime * result + ((getCreateAt() == null) ? 0 : getCreateAt().hashCode());
        result = prime * result + ((getUpdateAt() == null) ? 0 : getUpdateAt().hashCode());
        result = prime * result + ((getIsDeleted() == null) ? 0 : getIsDeleted().hashCode());
        return result;
    }
}