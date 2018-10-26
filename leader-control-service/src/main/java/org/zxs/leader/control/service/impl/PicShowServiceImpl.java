package org.zxs.leader.control.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.zxs.leader.control.dao.interf.IPicShowMapper;
import org.zxs.leader.control.dao.model.PicShow;
import org.zxs.leader.control.dao.model.PicShowExample;
import org.zxs.leader.control.dao.model.PicShowExample.Criteria;
import org.zxs.leader.control.service.interf.IPicShowService;


@Service
public class PicShowServiceImpl implements IPicShowService {

	@Resource
	private IPicShowMapper pShowMapper;

	@Override
	public List<PicShow> getActivePicList() {
		PicShowExample example = new PicShowExample();
		Criteria criteria = example.createCriteria();
		criteria.andActiveOrderGreaterThan((byte) 0);
		example.setOrderByClause("active_order");
		return pShowMapper.selectByExample(example);
	}


}
