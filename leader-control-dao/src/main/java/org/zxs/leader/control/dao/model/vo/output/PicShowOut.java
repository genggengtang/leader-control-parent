package org.zxs.leader.control.dao.model.vo.output;

import org.zxs.leader.control.dao.model.PicShow;

public class PicShowOut extends PicShow{
	private Boolean readable; // 用户是否可查看项目详情
	
	public PicShowOut() {}
	
	public PicShowOut(PicShow pShow) {
		this.setActiveOrder(pShow.getActiveOrder());
		this.setCreateAt(pShow.getCreateAt());
		this.setId(pShow.getId());
		this.setPicUrl(pShow.getPicUrl());
		this.setPrjId(pShow.getPrjId());
		this.setPrjType(pShow.getPrjType());
		this.setTitle(pShow.getTitle());
		this.readable = true;
	}

	public Boolean getReadable() {
		return readable;
	}

	public void setReadable(Boolean readable) {
		this.readable = readable;
	}

}
