package org.zxs.leader.control.dao.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;

@Table(name="msg_status")
public class MsgStatus {
	public static final byte STATUS_UNREAD = 0;
	public static final byte STATUS_READ = 1;
	
	public static final byte STATUS_UNPUSH = 0;
	public static final byte STATUS_PUSH = 1;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JSONField(ordinal=1)
    private Long id;
	
	@JSONField(ordinal=2)
	@Column(name="chat_group_id")
    private Integer chatGroupId;

	@JSONField(ordinal=3)
	@Column(name="group_msg_id")
    private Long groupMsgId;

	@JSONField(ordinal=4)
	@Column(name="user_id")
    private Integer userId;

	@JSONField(ordinal=5)
	@Column(name="read_status")
    private Byte readStatus;
	
	@JSONField(ordinal=6)
	@Column(name="push_status")
    private Byte pushStatus;

	@JSONField(ordinal=7)
	@Column(name="create_at")
    private Date createAt;

	@JSONField(ordinal=8)
	@Column(name="update_at")
    private Date updateAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getChatGroupId() {
		return chatGroupId;
	}

	public void setChatGroupId(Integer chatGroupId) {
		this.chatGroupId = chatGroupId;
	}

	public Long getGroupMsgId() {
        return groupMsgId;
    }

    public void setGroupMsgId(Long groupMsgId) {
        this.groupMsgId = groupMsgId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Byte getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(Byte readStatus) {
        this.readStatus = readStatus;
    }

    public Byte getPushStatus() {
		return pushStatus;
	}

	public void setPushStatus(Byte pushStatus) {
		this.pushStatus = pushStatus;
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
        MsgStatus other = (MsgStatus) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        	&& (this.getChatGroupId() == null ? other.getChatGroupId() == null : this.getChatGroupId().equals(other.getChatGroupId()))
            && (this.getGroupMsgId() == null ? other.getGroupMsgId() == null : this.getGroupMsgId().equals(other.getGroupMsgId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getReadStatus() == null ? other.getReadStatus() == null : this.getReadStatus().equals(other.getReadStatus()))
            && (this.getPushStatus() == null ? other.getPushStatus() == null : this.getPushStatus().equals(other.getPushStatus()))
            && (this.getCreateAt() == null ? other.getCreateAt() == null : this.getCreateAt().equals(other.getCreateAt()))
            && (this.getUpdateAt() == null ? other.getUpdateAt() == null : this.getUpdateAt().equals(other.getUpdateAt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getChatGroupId() == null) ? 0 : getChatGroupId().hashCode());
        result = prime * result + ((getGroupMsgId() == null) ? 0 : getGroupMsgId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getReadStatus() == null) ? 0 : getReadStatus().hashCode());
        result = prime * result + ((getPushStatus() == null) ? 0 : getPushStatus().hashCode());
        result = prime * result + ((getCreateAt() == null) ? 0 : getCreateAt().hashCode());
        result = prime * result + ((getUpdateAt() == null) ? 0 : getUpdateAt().hashCode());
        return result;
    }
}