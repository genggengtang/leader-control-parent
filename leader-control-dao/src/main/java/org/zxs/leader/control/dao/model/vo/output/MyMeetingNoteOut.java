package org.zxs.leader.control.dao.model.vo.output;

import org.zxs.leader.control.dao.model.MeetingNote;

/**
 * 会议纪要对象
 * @author Administrator
 *
 */
public class MyMeetingNoteOut extends MeetingNote{
	private Integer favoriteId;
	private Integer prjId;

	public Integer getFavoriteId() {
		return favoriteId;
	}

	public void setFavoriteId(Integer favoriteId) {
		this.favoriteId = favoriteId;
	}

	public Integer getPrjId() {
		return prjId;
	}

	public void setPrjId(Integer prjId) {
		this.prjId = prjId;
	}
	
}
