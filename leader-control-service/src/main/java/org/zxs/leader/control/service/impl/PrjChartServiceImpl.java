package org.zxs.leader.control.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zxs.leader.control.dao.interf.ICbStaticsMapper;
import org.zxs.leader.control.dao.interf.IPrjChartMapper;
import org.zxs.leader.control.dao.model.CbStatics;
import org.zxs.leader.control.dao.model.PrjChart;
import org.zxs.leader.control.dao.model.vo.output.PrjChartOut;
import org.zxs.leader.control.service.interf.IPrjChartService;


@Service
public class PrjChartServiceImpl implements IPrjChartService {

	@Resource
	private IPrjChartMapper pcMapper;
	
	@Resource
	private ICbStaticsMapper cbStaticsMapper;

	@Override
	public PrjChartOut getPrjChart(PrjChart pChart) {
		return pcMapper.selectPrjChartOne(pChart);
	}

	@Override
	@Transactional
	public int saveOrUpdatePrjChart(PrjChart pChart) {
		PrjChart record = new PrjChart();
		record.setChartType(pChart.getChartType());
		record.setPrjType(pChart.getPrjType());
		record.setYear(pChart.getYear());
		record.setMonth(pChart.getMonth());
		PrjChart prjChart = pcMapper.selectOne(record);
		
		if(null != prjChart) {
			pChart.setId(prjChart.getId());
			return pcMapper.updateByPrimaryKeySelective(pChart);
		}
		
		return pcMapper.insert(pChart);
	}

	@Override
	public CbStatics getCbPrjStaticsByPlanNo(int planNo) {
		CbStatics cStatics = new CbStatics();
		cStatics.setPlanNo(planNo);
		return cbStaticsMapper.selectOne(cStatics);
	}

}
