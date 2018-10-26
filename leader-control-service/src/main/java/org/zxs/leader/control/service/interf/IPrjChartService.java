package org.zxs.leader.control.service.interf;

import org.zxs.leader.control.dao.model.CbStatics;
import org.zxs.leader.control.dao.model.PrjChart;
import org.zxs.leader.control.dao.model.vo.output.PrjChartOut;

public interface IPrjChartService {

	/**
	 * 根据项目类型、图表类型、年份，查询工作内容或进度图
	 * @return
	 */
	PrjChartOut getPrjChart(PrjChart pChart);
	
	/**
	 * 保存项目内容或进度图
	 * @param pChart
	 * @return
	 */
	int saveOrUpdatePrjChart(PrjChart pChart);
	
	/**
	 * 根据城建计划期数获取统计表数据
	 * @param planNo
	 * @return
	 */
	CbStatics getCbPrjStaticsByPlanNo(int planNo);
}
