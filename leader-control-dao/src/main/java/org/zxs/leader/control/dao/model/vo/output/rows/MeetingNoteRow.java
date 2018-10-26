package org.zxs.leader.control.dao.model.vo.output.rows;

import org.zxs.leader.control.dao.model.MeetingNote;

public class MeetingNoteRow extends MeetingNote {
	
	private String prjTypeTrans;
	
	private String typeTrans;

	public String getPrjTypeTrans() {
		return prjTypeTrans;
	}

	public void setPrjTypeTrans(String prjTypeTrans) {
		this.prjTypeTrans = prjTypeTrans;
	}

	public String getTypeTrans() {
		return typeTrans;
	}

	public void setTypeTrans(String typeTrans) {
		this.typeTrans = typeTrans;
	}

}
