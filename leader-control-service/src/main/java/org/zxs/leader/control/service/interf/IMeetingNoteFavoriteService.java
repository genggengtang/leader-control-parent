package org.zxs.leader.control.service.interf;

import org.zxs.leader.control.dao.model.FavoriteNote;

public interface IMeetingNoteFavoriteService {

	/**
	 * 是否本人收藏会议纪要
	 * @param prjId
	 * @param userId
	 * @return
	 */
	boolean isFavoriteMeetingNote(int noteId, int userId);
	
	/**
	 * 取消关注
	 * @param id 关注编号
	 * @return
	 */
	int removeFavorite(int id);
	
	/**
	 * 收藏编号是否存在
	 * @param prjId
	 * @param userId
	 * @return
	 */
	boolean isFavoriteExist(int id);

	/**
	 * 添加收藏记录，返回收藏编号
	 * @param favor
	 * @return
	 */
	int addFavorite(FavoriteNote favor);
}
