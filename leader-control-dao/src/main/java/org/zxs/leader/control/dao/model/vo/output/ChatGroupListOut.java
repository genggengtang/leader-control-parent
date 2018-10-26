package org.zxs.leader.control.dao.model.vo.output;

import java.util.List;

/**
 * 群组基本信息
 * @author Administrator
 *
 */
public class ChatGroupListOut{
	private Integer workGroupCnt; // 工作群聊数
	
	private List<ChatGroupPrjOut> workGroup; // 工作组
	
	private Integer myGroupCnt; // 我的群聊数
	
	private List<ChatGroupBaseOut> myGroup; // 我的群组
	
//	private ChatGroupPrjOut serviceGroup; 
	private List<ChatGroupBaseOut> serviceGroup; // 服务队
	
	private List<ChatGroupPrjOut> lcGroup; // 市领导联系项目群
	
	private List<ChatGroupPrjOut> cbGroup; // 城建计划项目群

	public Integer getWorkGroupCnt() {
		return workGroupCnt;
	}

	public void setWorkGroupCnt(Integer workGroupCnt) {
		this.workGroupCnt = workGroupCnt;
	}

	public List<ChatGroupPrjOut> getWorkGroup() {
		return workGroup;
	}

	public void setWorkGroup(List<ChatGroupPrjOut> workGroup) {
		this.workGroup = workGroup;
	}

	public Integer getMyGroupCnt() {
		return myGroupCnt;
	}

	public void setMyGroupCnt(Integer myGroupCnt) {
		this.myGroupCnt = myGroupCnt;
	}

	public List<ChatGroupBaseOut> getMyGroup() {
		return myGroup;
	}

	public void setMyGroup(List<ChatGroupBaseOut> myGroup) {
		this.myGroup = myGroup;
	}

	public List<ChatGroupBaseOut> getServiceGroup() {
		return serviceGroup;
	}

	public void setServiceGroup(List<ChatGroupBaseOut> serviceGroup) {
		this.serviceGroup = serviceGroup;
	}

	public List<ChatGroupPrjOut> getLcGroup() {
		return lcGroup;
	}

	public void setLcGroup(List<ChatGroupPrjOut> lcGroup) {
		this.lcGroup = lcGroup;
	}

	public List<ChatGroupPrjOut> getCbGroup() {
		return cbGroup;
	}

	public void setCbGroup(List<ChatGroupPrjOut> cbGroup) {
		this.cbGroup = cbGroup;
	}
	
}
