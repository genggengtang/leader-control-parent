package org.zxs.leader.control.dao.model.vo.output;

import org.zxs.leader.control.dao.model.CityPlanPrj;

/**
 * 市统筹项目分页列表信息
 * @author Administrator
 *
 */
public class CpPrjPageOut extends CityPlanPrj{
	
	private String planStatusDis; // 计划建设阶段释义
	private String ownerName; // 业主单位，多个单位以逗号分隔
	private String[] ownerArray; // 业主单位数组
	private String labels; // 项目属性标签释义，多个以逗号分隔
	private String[] labelArray; // 项目属性标签释义数组
	private Integer yearPlanInvest; // 当年计划总投资
	
	
	public String getPlanStatusDis() {
		return planStatusDis;
	}
	public void setPlanStatusDis(String planStatusDis) {
		this.planStatusDis = planStatusDis;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
		if(null != ownerName && !ownerName.isEmpty()) {
			this.ownerArray = ownerName.split(",");
		}
	}
	public String[] getOwnerArray() {
		return ownerArray;
	}
	public void setOwnerArray(String[] ownerArray) {
		this.ownerArray = ownerArray;
	}
	public String getLabels() {
		return labels;
	}
	public void setLabels(String labels) {
		this.labels = labels;
		if(null != labels && !labels.isEmpty())
			this.labelArray = labels.split(",");
	}
	public String[] getLabelArray() {
		return labelArray;
	}
	public void setLabelArray(String[] labelArray) {
		this.labelArray = labelArray;
	}
	public Integer getYearPlanInvest() {
		return yearPlanInvest;
	}
	public void setYearPlanInvest(Integer yearPlanInvest) {
		this.yearPlanInvest = yearPlanInvest;
	}
	
}
