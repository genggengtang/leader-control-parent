package org.zxs.leader.control.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.zxs.leader.control.dao.interf.IOrgUserMapper;
import org.zxs.leader.control.dao.model.vo.output.PrcSearchOut;
import org.zxs.leader.control.service.interf.IPrjSearchService;


@Service
public class PrjSearchServiceImpl implements IPrjSearchService {

	@Resource
	private IOrgUserMapper orgUserMapper;

	@Override
	public List<PrcSearchOut> getLeaderByNameLike(String nameLike) {
		return orgUserMapper.selectLeaderPrjByNameLike(nameLike);
	}

	@Override
	public List<PrcSearchOut> getCbLeaderByNameLike(String nameLike) {
		return orgUserMapper.selectCbLeaderByNameLike(nameLike);
	}

}
