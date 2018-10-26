package org.zxs.leader.control.dao.model.vo.output.rows;

import org.zxs.leader.control.dao.model.OrgUnit;

public class OrgUnitRow extends OrgUnit {
	
	private String areaIdTrans;
	
	private String typeTrans;

	public String getAreaIdTrans() {
		return areaIdTrans;
	}

	public void setAreaIdTrans(String areaIdTrans) {
		this.areaIdTrans = areaIdTrans;
	}

	public String getTypeTrans() {
		return typeTrans;
	}

	public void setTypeTrans(String typeTrans) {
		this.typeTrans = typeTrans;
	}

}
