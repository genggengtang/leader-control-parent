package org.zxs.leader.control.dao.model.vo.output;

import java.util.List;

/**
 * 项目群组信息
 * @author Administrator
 *
 */
public class ChatGroupPrjOut{
	private Integer prjType; // 项目类型
	private Integer prjId; // 项目编号
	private String prjName; // 项目名
	private Integer prjGroupNum; // 项目群组数
	private List<ChatGroupBaseOut> workPrjGroup; // 项目群组
	
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
	public String getPrjName() {
		return prjName;
	}
	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}
	public Integer getPrjGroupNum() {
		return prjGroupNum;
	}
	public void setPrjGroupNum(Integer prjGroupNum) {
		this.prjGroupNum = prjGroupNum;
	}
	public List<ChatGroupBaseOut> getWorkPrjGroup() {
		return workPrjGroup;
	}
	public void setWorkPrjGroup(List<ChatGroupBaseOut> workPrjGroup) {
		this.workPrjGroup = workPrjGroup;
	}

}
