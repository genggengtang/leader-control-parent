package org.zxs.leader.control.dao.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;

@Table(name="chat_group_user")
public class ChatGroupUser {
	public static final byte ROLE_OWNER = 0;
	public static final byte ROLE_ADMIN = 1;
	public static final byte ROLE_MEMBER = 2;
	
	public static final byte REMOVE_REJECT = 0;
	public static final byte REMOVE_ALLOW = 1;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JSONField(ordinal=1)
    private Integer id;

	@JSONField(ordinal=2)
	@Column(name="chat_group_id")
    private Integer chatGroupId;

	@JSONField(ordinal=3)
	@Column(name="user_id")
    private Integer userId;

	@JSONField(ordinal=4)
	@Column(name="nickname")
    private String nickname;

	@JSONField(ordinal=5)
	@Column(name="role")
    private Byte role;
	
	@JSONField(ordinal=6)
	@Column(name="removeable")
    private Byte removeable;

	@JSONField(ordinal=7)
	@Column(name="create_at")
    private Date createAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getChatGroupId() {
        return chatGroupId;
    }

    public void setChatGroupId(Integer chatGroupId) {
        this.chatGroupId = chatGroupId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public Byte getRole() {
        return role;
    }

	public void setRole(Byte role) {
        this.role = role;
    }
	
	public Byte getRemoveable() {
		return removeable;
	}

	public void setRemoveable(Byte removeable) {
		this.removeable = removeable;
	}

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
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
        ChatGroupUser other = (ChatGroupUser) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getChatGroupId() == null ? other.getChatGroupId() == null : this.getChatGroupId().equals(other.getChatGroupId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getNickname() == null ? other.getNickname() == null : this.getNickname().equals(other.getNickname()))
            && (this.getRole() == null ? other.getRole() == null : this.getRole().equals(other.getRole()))
            && (this.getRemoveable() == null ? other.getRemoveable() == null : this.getRemoveable().equals(other.getRemoveable()))
            && (this.getCreateAt() == null ? other.getCreateAt() == null : this.getCreateAt().equals(other.getCreateAt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getChatGroupId() == null) ? 0 : getChatGroupId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getNickname() == null) ? 0 : getNickname().hashCode());
        result = prime * result + ((getRole() == null) ? 0 : getRole().hashCode());
        result = prime * result + ((getRemoveable() == null) ? 0 : getRemoveable().hashCode());
        result = prime * result + ((getCreateAt() == null) ? 0 : getCreateAt().hashCode());
        return result;
    }
}