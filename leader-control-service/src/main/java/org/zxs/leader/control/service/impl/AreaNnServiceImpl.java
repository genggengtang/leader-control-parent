package org.zxs.leader.control.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.zxs.leader.control.dao.interf.IAreaNnMapper;
import org.zxs.leader.control.dao.model.vo.output.OptionsOut;
import org.zxs.leader.control.service.interf.IAreaNnService;


@Service
public class AreaNnServiceImpl implements IAreaNnService {

	@Resource
	private IAreaNnMapper areaMapper;

	@Override
	public List<OptionsOut> getAllFullNameList() {
		return null;
	}

	@Override
	public List<OptionsOut> getAllListWithoutProv() {
		return areaMapper.selectAllWithoutProv();
	}

	@Override
	public List<OptionsOut> getAllAreaNameOptions() {
		return this.areaMapper.selectAllAreaNameOptions();
	}

}
