package org.zxs.leader.control.dao.interf;

import org.apache.ibatis.annotations.Param;
import org.zxs.leader.control.dao.model.PrjChart;
import org.zxs.leader.control.dao.model.vo.output.PrjChartOut;

import tk.mybatis.mapper.common.Mapper;

public interface IPrjChartMapper extends Mapper<PrjChart> {

	/**
	 * 获取项目内容或进度图
	 * @param pChart
	 * @return
	 */
	PrjChartOut selectPrjChartOne(@Param("pChart")PrjChart pChart);

}