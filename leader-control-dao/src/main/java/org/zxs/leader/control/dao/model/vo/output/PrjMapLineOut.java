package org.zxs.leader.control.dao.model.vo.output;

import java.util.List;

import org.zxs.leader.control.dao.model.PrjPoint;

/**
 * 项目地图线和点集合信息
 * @author Administrator
 */
public class PrjMapLineOut {
	
	private Integer lineId;
	
	private List<PrjPoint> pointList;

	public Integer getLineId() {
		return lineId;
	}

	public void setLineId(Integer lineId) {
		this.lineId = lineId;
	}

	public List<PrjPoint> getPointList() {
		return pointList;
	}

	public void setPointList(List<PrjPoint> pointList) {
		this.pointList = pointList;
	}
	
	
}
