package org.zxs.leader.control.admin.controller.common;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zxs.leader.control.admin.util.CommonExcelUtil;
import org.zxs.leader.control.dao.model.DictHeader;
import org.zxs.leader.control.service.admin.interf.ExcelExportService;
import org.zxs.leader.control.service.impl.HeaderServiceImpl;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/tables")
@Api(tags="Excel批量导出接口")
public class ExcelExportController {

	private static final Log logger = LogFactory.getLog(ExcelExportController.class);
	
	@Resource
	private ExcelExportService excelExportService;
	
	@Resource
	private HeaderServiceImpl headerService;
	
	/**
	 * 
	* @Title: exportExcel 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param response
	* @param @param table
	* @param @param title  参数说明 
	* @return void    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月6日 下午5:04:10
	 */
	@RequestMapping(value = "/export-excel", method = {RequestMethod.GET, RequestMethod.POST})
	public void exportExcel(HttpServletResponse response, @RequestParam(value="table", required=true) String tableName) {
		logger.info(String.format("开始转换[%s]表为Excel文件...", tableName));
		List<Object> oList = excelExportService.getTableList(tableName);
		if (null == oList || oList.size() == 0) {
			logger.info("查询失败！ " + tableName + "表不存在，或者" + tableName + "表数据为空！");
			return;
		}
		// convert to object list
		List<Object> list = new ArrayList<Object>(oList);
		// get excel headers
		List<DictHeader> headers = headerService.getExcelHeadersByTableName(tableName);
		// sort headers by expected excel order
		headerService.sortHeadersByExcelOrder(headers);
		// convert list data to byte array
		CommonExcelUtil commonExcelUtil = new CommonExcelUtil();
		ByteArrayOutputStream out = commonExcelUtil.convertOutputStream(list, headers);
		// fire up downloading process  
		commonExcelUtil.fireDownloadTask(response, out);
		logger.info(String.format("开始下载[%s]表中的[%s]条记录...", tableName, oList.size()));
	}
	
	/*
	 * helper
	 * to be deleted
	 */
	@RequestMapping(value = "/view-list", method = {RequestMethod.GET, RequestMethod.POST})
	public List<Object> viewList(@RequestParam(value="table", required=true) String tableName) {
		logger.info("收到export-excel接口请求，参数: table=" + tableName);
		List<Object> oList = excelExportService.getTableList(tableName);
		return oList;
	}

}
