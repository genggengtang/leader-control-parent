package org.zxs.leader.control.admin.controller.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zxs.base.model.CommonReturnBean;
import org.zxs.leader.control.dao.model.BatchInsertRes;
import org.zxs.leader.control.service.admin.interf.ExcelImportService;

import io.swagger.annotations.Api;

@RestController
@Api(tags="Excel批量导入接口")
public class ExcelImportController {

	private static final Log logger = LogFactory.getLog(ExcelImportController.class);
	
	@Autowired
	private ExcelImportService excelImportService;
	
	/**
	 * 
	* @Title: importExcel 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param file
	* @param @param table
	* @param @param redirectAttributes
	* @param @return  参数说明 
	* @return CommonReturnBean<BatchInsertRes>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月3日 下午4:55:56
	 */
	@RequestMapping(value = "admin/import-excel/{table}", method = RequestMethod.POST)
	public CommonReturnBean<BatchInsertRes> importExcel(@RequestParam("file") MultipartFile file, 
			@PathVariable("table") String table, RedirectAttributes redirectAttributes) {
		CommonReturnBean<BatchInsertRes> ret = new CommonReturnBean<>();
		if (null == file || file.getSize() <= 0) {
			ret.setErrorCode(-1);
			ret.setErrorMsg("Excel上传文件为空！");
			logger.info("Excel文件上传为空！");
			return ret;
		}
		String fileName = file.getOriginalFilename();
		InputStream inputStream = null;
		try {
			inputStream = file.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
			ret.setErrorCode(-1);
			ret.setErrorMsg("Excel文件上传失败！");
			logger.info("Excel文件上传失败！");
			return ret;
		}
		if (null == inputStream) {
			ret.setErrorCode(-1);
			ret.setErrorMsg("Excel上传流为空！");
			logger.info("Excel上传流为空！");
			return ret;
		}
		// handle uploaded excel file
		BatchInsertRes res = this.excelImportService.batchImport(inputStream, fileName, table);
		ret.setErrorCode(0);
		ret.setErrorMsg("批量导入结果信息。");
		ret.setData(res);
		return ret;
	}
	
}
