package org.zxs.leader.control.admin.controller.common;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zxs.base.model.CommonReturnBean;
import org.zxs.leader.control.service.interf.ITableRecordDeleteService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/tables")
@Api(tags="表记录删除控制接口")
public class DeleteController {
	
	private static final Log logger = LogFactory.getLog(DeleteController.class);
	
	@Resource
	private ITableRecordDeleteService tableRecordDeleteService;
	
	/**
	 * 
	* @Title: deleteTableRecordById 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param response
	* @param @param table
	* @param @param id
	* @param @return  参数说明 
	* @return CommonReturnBean<Integer>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月12日 下午6:03:01
	 */
	@RequestMapping(value = "/delete-by-id", method = {RequestMethod.GET, RequestMethod.POST})
	public CommonReturnBean<Integer> deleteTableRecordById(HttpServletResponse response,
			@RequestParam(value="table", required=true) String table,
			@RequestParam(value="id", required=true) Integer id) {
		CommonReturnBean<Integer> ret = new CommonReturnBean<>();
		String errorMsg = "";
		if (null == table || null == id) {
			errorMsg = "请求参数table或者id为空！";
			ret.setErrorCode(-1);
			ret.setErrorMsg(errorMsg);
			logger.info(errorMsg);
			return ret;
		}
		int res = this.tableRecordDeleteService.delete(table, id);
		if (res < 1) {
			errorMsg = String.format("无法删除[%s]表中ID为[%s]的记录。", table, id);
			ret.setErrorCode(-1);
			ret.setErrorMsg(errorMsg);
			logger.info(errorMsg);
			return ret;
		}
		errorMsg = String.format("成功删除[%s]表中ID为[%s]的记录。", table, id);
		ret.setErrorCode(0);
		ret.setErrorMsg(errorMsg);
		logger.info(errorMsg);
		return ret;
	}

}