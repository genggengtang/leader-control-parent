package org.zxs.leader.control.controller;

import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zxs.base.model.CommonReturnBean;
import org.zxs.leader.control.controller.annotation.Trace;
import org.zxs.leader.control.dao.consts.IDicInfoConst;
import org.zxs.leader.control.dao.model.CbStatics;
import org.zxs.leader.control.dao.model.PrjChart;
import org.zxs.leader.control.dao.model.vo.output.PrjChartOut;
import org.zxs.leader.control.service.interf.IPrjChartService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(tags="计划内容和进度图片")
public class PrjChartController {
	private static final Log log = LogFactory.getLog(PrjChartController.class);
	
	@Resource
	private IPrjChartService pChartService;
	
	@RequestMapping(value = "prj-chart", method = RequestMethod.GET)
	@ApiOperation(httpMethod = "GET", value = "查询计划内容或进度图", produces = MediaType.APPLICATION_JSON_VALUE)
	@Trace(type=IDicInfoConst.OPT_PRGR_PRJ)
	public PrjChartOut getPrjChart(
			@RequestParam(required=false,value="prjType", defaultValue=""+IDicInfoConst.PRJ_LEADER_CONTROL) Integer prjType,
			@RequestParam(required=false,value="chartType") Integer chartType,
			@RequestParam(required=false,value="year") Integer year,
			@RequestParam(required=false,value="month") Integer month) {
		Calendar date = Calendar.getInstance();
		PrjChart pChart = new PrjChart();
		pChart.setPrjType(prjType);
		if(null != chartType) {
			pChart.setChartType(chartType.byteValue());
		}
		if(null != year) {
			pChart.setYear(year.shortValue());
		}else {
	        year = date.get(Calendar.YEAR);
		}
		
		if(chartType != null && chartType == 2) { // 计划进度
			if(null != month)
				pChart.setMonth(month.byteValue());
			else
				pChart.setMonth((byte) (date.get(Calendar.MONTH) + 1));
		}
		
		return pChartService.getPrjChart(pChart);
	}
	
	@RequestMapping(value = "cb/prj-chart", method = RequestMethod.GET)
	@ApiOperation(httpMethod = "GET", value = "查询城建计划统计内容", produces = MediaType.APPLICATION_JSON_VALUE)
	@Trace(type=IDicInfoConst.OPT_PRGR_PRJ, prjType=IDicInfoConst.PRJ_CITY_BUILD)
	public CbStatics getCbChart(@RequestParam(required=false,value="planNo", defaultValue=""+IDicInfoConst.CB_LATEST_PLAN) Integer planNo) {
		return pChartService.getCbPrjStaticsByPlanNo(planNo);
	}
	
	@RequestMapping(value = "add-prj-chart", method = RequestMethod.POST)
	@ApiOperation(httpMethod = "POST", value = "添加计划内容或进度图", produces = MediaType.APPLICATION_JSON_VALUE)
	public CommonReturnBean<Integer> addPrjChart(
		@ApiParam(value = "项目类型，对应字典表214字段", required = true,
		allowableValues=IDicInfoConst.PRJ_LEADER_CONTROL+","+IDicInfoConst.PRJ_CITY_PLAN+","+IDicInfoConst.PRJ_CITY_BUILD)
		@RequestParam(required=true,value="prjType", defaultValue=""+IDicInfoConst.PRJ_LEADER_CONTROL) Integer prjType,
		@ApiParam(value = "图表类型，1为计划内容，2为计划进度", required = true, allowableValues="1,2")
		@RequestParam(required=true,value="chartType", defaultValue="1") Integer chartType,
		@ApiParam(value = "年份", required = true)
		@RequestParam(required=true,value="year") Integer year,
		@ApiParam("月份") @RequestParam(required=false,value="month") Integer month,
		@ApiParam(value = "图片URL地址", required = true)
		@RequestParam(required=true,value="url") String url) {
		
		CommonReturnBean<Integer> addRet = new CommonReturnBean<>();
		PrjChart pchart = new PrjChart();
		pchart.setChartType(chartType.byteValue());
		pchart.setPrjType(prjType);
		pchart.setYear(year.shortValue());
		pchart.setUrl(url.trim());
		if(null != month)
			pchart.setMonth(month.byteValue());
		Date nowTime = new Date();
		pchart.setCreateAt(nowTime);
		pchart.setUpdateAt(nowTime);
		int saveCnt = pChartService.saveOrUpdatePrjChart(pchart);
		if(saveCnt != 1 ) {
			addRet.setErrorCode(-140);
			addRet.setErrorMsg("添加项目内容图或进度图失败!");
			return addRet;
		}
		
		addRet.setErrorCode(0);
		addRet.setErrorMsg("添加项目内容图或进度图成功!");
		return addRet;
	}
	
}
