package org.zxs.leader.control.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zxs.leader.control.dao.interf.IFavoritePrjMapper;
import org.zxs.leader.control.dao.model.FavoritePrj;
import org.zxs.leader.control.service.interf.IFavoritePrjService;


@Service
public class FavoritePrjServiceImpl implements IFavoritePrjService {

	@Resource
	private IFavoritePrjMapper favoritePrjMapper;

	@Override
	public boolean isFavoritePrj(int prjId, int prjType, int userId) {
		FavoritePrj fPrj = new FavoritePrj();
		fPrj.setPrjType(prjType);
		fPrj.setPrjId(prjId);
		fPrj.setUserId(userId);
		return favoritePrjMapper.selectCount(fPrj) > 0;
	}

	@Transactional
	@Override
	public int addFavorite(FavoritePrj favor) {
		int ret = favoritePrjMapper.insert(favor);
		return ret == 1 ? favor.getId() : 0;
	}

	@Transactional
	@Override
	public int removeFavorite(int id) {
		return favoritePrjMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Integer getFavoriteIdByUserAndPrj(int userId, int prjType, int prjId) {
		FavoritePrj fPrj = new FavoritePrj();
		fPrj.setPrjType(prjType);
		fPrj.setPrjId(prjId);
		fPrj.setUserId(userId);
		FavoritePrj ret = favoritePrjMapper.selectOne(fPrj);
		return ret == null ? null : ret.getId();
	}

	@Override
	public boolean isFavoriteExist(int id) {
		return favoritePrjMapper.selectByPrimaryKey(id) == null;
	}

}
