package org.zxs.leader.control.dao.model.vo.output;

import java.util.List;

/**
 * 项目地图线和点集合信息
 * @author Administrator
 */
public class PrjMapOut {
	
	private String planStatusDis; // 计划建设阶段
	
	private String completeStatusDis; // 项目完成状态
	
	private List<PrjMapLineOut> lineList;
	
	public String getPlanStatusDis() {
		return planStatusDis;
	}

	public void setPlanStatusDis(String planStatusDis) {
		this.planStatusDis = planStatusDis;
	}

	public String getCompleteStatusDis() {
		return completeStatusDis;
	}

	public void setCompleteStatusDis(String completeStatusDis) {
		this.completeStatusDis = completeStatusDis;
	}

	public List<PrjMapLineOut> getLineList() {
		return lineList;
	}

	public void setLineList(List<PrjMapLineOut> lineList) {
		this.lineList = lineList;
	}

	
}
