package org.zxs.leader.control.service.admin.interf;

import java.io.InputStream;

import org.zxs.leader.control.dao.model.BatchInsertRes;

public interface ExcelImportService {
	
	/**
	 * 
	* @Title: batchImport 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param inputStream
	* @param @param fileName
	* @param @param table
	* @param @return  参数说明 
	* @return BatchInsertRes    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月3日 下午4:31:36
	 */
	BatchInsertRes batchImport(InputStream inputStream, String fileName, String table);
	
}
