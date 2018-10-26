package org.zxs.leader.control.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zxs.leader.control.dao.interf.IOptInfoMapper;
import org.zxs.leader.control.dao.model.OptInfo;
import org.zxs.leader.control.service.interf.IOptInfoService;


@Service
public class OptInfoServiceImpl implements IOptInfoService {

	@Resource
	private IOptInfoMapper optInfoMapper;

	@Override
	@Transactional
	public int addOptInfo(OptInfo opt) {
		return optInfoMapper.insertSelective(opt);
	}


}
