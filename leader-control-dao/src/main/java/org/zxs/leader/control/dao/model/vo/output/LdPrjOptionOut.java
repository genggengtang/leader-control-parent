package org.zxs.leader.control.dao.model.vo.output;

import java.util.List;

/**
 * 市领导联系项目选项列表
 * @author Administrator
 *
 */
public class LdPrjOptionOut {
	private List<OptionsOut> leaderList;
	private List<OptionsOut> buildStatusList;
	private List<OptionsOut> industryList;
	private List<OptionsOut> areaList;
	
	public List<OptionsOut> getLeaderList() {
		return leaderList;
	}
	public void setLeaderList(List<OptionsOut> leaderList) {
		this.leaderList = leaderList;
	}
	public List<OptionsOut> getBuildStatusList() {
		return buildStatusList;
	}
	public void setBuildStatusList(List<OptionsOut> buildStatusList) {
		this.buildStatusList = buildStatusList;
	}
	public List<OptionsOut> getIndustryList() {
		return industryList;
	}
	public void setIndustryList(List<OptionsOut> industryList) {
		this.industryList = industryList;
	}
	public List<OptionsOut> getAreaList() {
		return areaList;
	}
	public void setAreaList(List<OptionsOut> areaList) {
		this.areaList = areaList;
	}
	
}
