package org.zxs.leader.control.dao.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;

@Table(name="topic_pic")
public class TopicPic {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JSONField(ordinal=1)
    private Integer id;

	@JSONField(ordinal=2)
	@Column(name="send_user_id")
    private Integer sendUserId;

	@JSONField(ordinal=3)
	@Column(name="receive_cg_id")
    private Integer receiveCgId;
	
	@JSONField(ordinal=4)
	@Column(name="is_new_group")
    private Byte isNewGroup;

	@JSONField(ordinal=5)
	@Column(name="content")
    private String content;

	@JSONField(ordinal=6)
	@Column(name="pic_url")
    private String picUrl;
	
	@JSONField(ordinal=7)
	@Column(name="reply_status")
    private Byte replyStatus;
	
	@JSONField(ordinal=8)
	@Column(name="active_status")
    private Byte activeStatus;

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

    public Integer getSendUserId() {
        return sendUserId;
    }

    public void setSendUserId(Integer sendUserId) {
        this.sendUserId = sendUserId;
    }

    public Integer getReceiveCgId() {
        return receiveCgId;
    }

    public void setReceiveCgId(Integer receiveCgId) {
        this.receiveCgId = receiveCgId;
    }

    public Byte getIsNewGroup() {
		return isNewGroup;
	}

	public void setIsNewGroup(Byte isNewGroup) {
		this.isNewGroup = isNewGroup;
	}

	public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

	public Byte getReplyStatus() {
		return replyStatus;
	}

	public void setReplyStatus(Byte replyStatus) {
		this.replyStatus = replyStatus;
	}

	public Byte getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(Byte activeStatus) {
		this.activeStatus = activeStatus;
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
        TopicPic other = (TopicPic) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSendUserId() == null ? other.getSendUserId() == null : this.getSendUserId().equals(other.getSendUserId()))
            && (this.getReceiveCgId() == null ? other.getReceiveCgId() == null : this.getReceiveCgId().equals(other.getReceiveCgId()))
            && (this.getIsNewGroup() == null ? other.getIsNewGroup() == null : this.getIsNewGroup().equals(other.getIsNewGroup()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getPicUrl() == null ? other.getPicUrl() == null : this.getPicUrl().equals(other.getPicUrl()))
            && (this.getReplyStatus() == null ? other.getReplyStatus() == null : this.getReplyStatus().equals(other.getReplyStatus()))
            && (this.getActiveStatus() == null ? other.getActiveStatus() == null : this.getActiveStatus().equals(other.getActiveStatus()))
            && (this.getCreateAt() == null ? other.getCreateAt() == null : this.getCreateAt().equals(other.getCreateAt()))
            && (this.getUpdateAt() == null ? other.getUpdateAt() == null : this.getUpdateAt().equals(other.getUpdateAt()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSendUserId() == null) ? 0 : getSendUserId().hashCode());
        result = prime * result + ((getReceiveCgId() == null) ? 0 : getReceiveCgId().hashCode());
        result = prime * result + ((getIsNewGroup() == null) ? 0 : getIsNewGroup().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getPicUrl() == null) ? 0 : getPicUrl().hashCode());
        result = prime * result + ((getReplyStatus() == null) ? 0 : getReplyStatus().hashCode());
        result = prime * result + ((getActiveStatus() == null) ? 0 : getActiveStatus().hashCode());
        result = prime * result + ((getCreateAt() == null) ? 0 : getCreateAt().hashCode());
        result = prime * result + ((getUpdateAt() == null) ? 0 : getUpdateAt().hashCode());
        result = prime * result + ((getIsDeleted() == null) ? 0 : getIsDeleted().hashCode());
        return result;
    }
}