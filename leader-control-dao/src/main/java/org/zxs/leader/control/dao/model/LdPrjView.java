package org.zxs.leader.control.dao.model;
/**
 * 市领导联系项目基础信息视图
 * @author Administrator
 *
 */
public class LdPrjView extends PrjInfo{
	private String rspLeaderName;
	private String industryDis;
	private String planStatusDis;
	private String actualStatusDis;
	private String areaName;
	
	public String getRspLeaderName() {
		return rspLeaderName;
	}
	public void setRspLeaderName(String rspLeaderName) {
		this.rspLeaderName = rspLeaderName;
	}
	public String getIndustryDis() {
		return industryDis;
	}
	public void setIndustryDis(String industryDis) {
		this.industryDis = industryDis;
	}
	public String getPlanStatusDis() {
		return planStatusDis;
	}
	public void setPlanStatusDis(String planStatusDis) {
		this.planStatusDis = planStatusDis;
	}
	public String getActualStatusDis() {
		return actualStatusDis;
	}
	public void setActualStatusDis(String actualStatusDis) {
		this.actualStatusDis = actualStatusDis;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
}
