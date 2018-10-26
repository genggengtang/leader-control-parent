package org.zxs.leader.control.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zxs.leader.control.dao.interf.IFavoriteNoteMapper;
import org.zxs.leader.control.dao.model.FavoriteNote;
import org.zxs.leader.control.dao.model.FavoritePrj;
import org.zxs.leader.control.service.interf.IMeetingNoteFavoriteService;


@Service
public class FavoriteMeetingNoteServiceImpl implements IMeetingNoteFavoriteService {

	@Resource
	private IFavoriteNoteMapper favoriteNoteMapper;

	@Override
	public boolean isFavoriteMeetingNote(int noteId, int userId) {
		FavoriteNote fNote = new FavoriteNote();
		fNote.setNoteId(noteId);
		fNote.setUserId(userId);
		return favoriteNoteMapper.selectCount(fNote) > 0;
	}

	@Override
	@Transactional
	public int removeFavorite(int id) {
		return favoriteNoteMapper.deleteByPrimaryKey(id);
	}

	@Override
	public boolean isFavoriteExist(int id) {
		return favoriteNoteMapper.selectByPrimaryKey(id) != null;
	}

	@Override
	@Transactional
	public int addFavorite(FavoriteNote favor) {
		int ret = favoriteNoteMapper.insert(favor);
		return ret == 1 ? favor.getId() : 0;
	}

	
}
