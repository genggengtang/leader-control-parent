package org.zxs.leader.control.dao.model.vo.output;

/**
 * 聊天消息
 * @author Administrator
 *
 */
public class ChatMsgOut {
	private Long msgId; // 消息编号
	private Integer userId; // 发送者编号
	private String userName; // 用户名
	private String msgContent; // 消息内容
	private String msgAt; // 消息时间
	
	private int shMsgType; // 消息类型,参见字典表211
	private String sUserNames; // 添加或删除成员名单，多人以逗号分隔
	private String sUserIds; // 添加或删除成员编号，多人以逗号分隔
	private short shUserNum; // 添加或删除总人数
	
	private Integer isSelf; // 是否本人
	
//	private byte[] arrayBuffer; // 文件二进制数组
	private String fileName; // 文件名
	private String fileUrl; // 文件URL地址
	
	private Integer topicId; // 随手拍主题编号
	
	public Long getMsgId() {
		return msgId;
	}
	public void setMsgId(Long msgId) {
		this.msgId = msgId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMsgContent() {
		return msgContent;
	}
	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}
	public String getMsgAt() {
		return msgAt;
	}
	public void setMsgAt(String msgAt) {
		this.msgAt = msgAt;
	}
	public int getShMsgType() {
		return shMsgType;
	}
	public void setShMsgType(int shMsgType) {
		this.shMsgType = shMsgType;
	}
	public String getsUserNames() {
		return sUserNames;
	}
	public void setsUserNames(String sUserNames) {
		this.sUserNames = sUserNames;
	}
	public String getsUserIds() {
		return sUserIds;
	}
	public void setsUserIds(String sUserIds) {
		this.sUserIds = sUserIds;
	}
	public short getShUserNum() {
		return shUserNum;
	}
	public void setShUserNum(short shUserNum) {
		this.shUserNum = shUserNum;
	}
	public Integer getIsSelf() {
		return isSelf;
	}
	public void setIsSelf(Integer isSelf) {
		this.isSelf = isSelf;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	public Integer getTopicId() {
		return topicId;
	}
	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

}
