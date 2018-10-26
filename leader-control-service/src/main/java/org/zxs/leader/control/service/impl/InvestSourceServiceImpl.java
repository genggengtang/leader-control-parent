package org.zxs.leader.control.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.zxs.leader.control.dao.interf.ICbInvestSourceMapper;
import org.zxs.leader.control.dao.model.vo.output.InvestSourceOut;
import org.zxs.leader.control.service.interf.IInvestSourceService;


@Service
public class InvestSourceServiceImpl implements IInvestSourceService {

	@Resource
	private ICbInvestSourceMapper iSourceMapper;

	@Override
	public List<InvestSourceOut> getInvestSourceListByPrj(int prjId) {
		return iSourceMapper.selectInvestSourceByPrjId(prjId);
	}


}
