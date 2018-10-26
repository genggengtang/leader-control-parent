package org.zxs.leader.control.dao.model.vo.output;

import java.util.List;

/**
 * 项目审批信息
 * @author Administrator
 */
public class PrjProveOut {
	
	private Short proveStatus;
	
	private String proveType;
	
	private String ids;
	
	private List<PrjAttachmentOut> attamentList;

	public Short getProveStatus() {
		return proveStatus;
	}

	public void setProveStatus(Short proveStatus) {
		this.proveStatus = proveStatus;
	}

	public String getProveType() {
		return proveType;
	}

	public void setProveType(String proveType) {
		this.proveType = proveType;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public List<PrjAttachmentOut> getAttamentList() {
		return attamentList;
	}

	public void setAttamentList(List<PrjAttachmentOut> attamentList) {
		this.attamentList = attamentList;
	}

}
