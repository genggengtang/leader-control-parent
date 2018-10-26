package org.zxs.leader.control.dao.model.vo.output;

import java.util.List;

import org.zxs.leader.control.dao.model.DicInfo;

/**
 * 城建计划项目分类及重点分类返回对象
 * @author Administrator
 *
 */
public class CbClauseOut {
	private List<DicInfo> cbTypeList;
	private List<DicInfo> cbLabelList;
	
	public List<DicInfo> getCbTypeList() {
		return cbTypeList;
	}
	public void setCbTypeList(List<DicInfo> cbTypeList) {
		this.cbTypeList = cbTypeList;
	}
	public List<DicInfo> getCbLabelList() {
		return cbLabelList;
	}
	public void setCbLabelList(List<DicInfo> cbLabelList) {
		this.cbLabelList = cbLabelList;
	}
}
