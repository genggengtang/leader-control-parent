package org.zxs.leader.control.service.interf;

import org.zxs.leader.control.dao.model.FavoritePrj;

public interface IFavoritePrjService {

	/**
	 * 是否本人收藏项目
	 * @param prjId
	 * @param prjId
	 * @param prjType
	 * @return
	 */
	boolean isFavoritePrj(int prjId, int prjType, int userId);
	
	/**
	 * 根据用户和项目编号获取关注编号
	 * @param prjId
	 * @param prjId
	 * @param prjType
	 * @return
	 */
	Integer getFavoriteIdByUserAndPrj(int userId, int prjType, int prjId);
	
	/**
	 * 添加关注，返回关注编号
	 * @param favor
	 * @return
	 */
	int addFavorite(FavoritePrj favor);
	
	/**
	 * 取消关注
	 * @param id 关注编号
	 * @return
	 */
	int removeFavorite(int id);
	
	/**
	 * 关注编号是否存在
	 * @param prjId
	 * @param userId
	 * @return
	 */
	boolean isFavoriteExist(int id);
}
