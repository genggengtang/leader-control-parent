package org.zxs.leader.control.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.zxs.leader.control.dao.interf.IDicInfoMapper;
import org.zxs.leader.control.dao.model.vo.output.OptionsOut;
import org.zxs.leader.control.service.interf.IDicInfoService;

@Service
public class DicInfoServiceImpl implements IDicInfoService {

	@Resource
	private IDicInfoMapper dicInfoMapper;
	
	@Override
	public List<OptionsOut> getAllOrgTypeOptions() {
		return this.dicInfoMapper.selectAllOrgTypeOptions();
	}
	
	@Override
	public List<OptionsOut> getAllPhoneListTypeOptions() {
		return this.dicInfoMapper.selectAllPhoneListTypeOptions();
	}

	@Override
	public List<OptionsOut> getOptionsByType(Integer type) {
		return dicInfoMapper.selectOptionsByType(type);
	}
	
	@Override
	public List<OptionsOut> getOptionsById(Integer id) {
		return dicInfoMapper.selectOptionsById(id);
	}

	@Override
	public List<OptionsOut> getAllCityBuildTypeOptions() {
		List<OptionsOut> allOptions = new ArrayList<OptionsOut>();
		List<OptionsOut> extraCbTypeTrans216 = this.dicInfoMapper.selectOptionsByType(216); // 216 城建项目分类
		List<OptionsOut> extraCbTypeTrans217 = this.dicInfoMapper.selectOptionsByType(217); // 217 城建项目分类
		List<OptionsOut> extraCbTypeTrans221 = this.dicInfoMapper.selectOptionsByType(221); // 217 城建项目分类
		List<OptionsOut> extraCbTypeTrans222 = this.dicInfoMapper.selectOptionsByType(222); // 217 城建项目分类
		allOptions.addAll(extraCbTypeTrans216);
		allOptions.addAll(extraCbTypeTrans217);
		allOptions.addAll(extraCbTypeTrans221);
		allOptions.addAll(extraCbTypeTrans222);
		return allOptions;
	}

}
