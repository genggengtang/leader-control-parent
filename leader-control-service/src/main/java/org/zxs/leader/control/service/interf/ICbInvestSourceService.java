package org.zxs.leader.control.service.interf;

import org.zxs.leader.control.dao.model.CbInvestSource;
import org.zxs.leader.control.dao.model.vo.output.rows.CbInvestSourceRow;

import com.github.pagehelper.PageInfo;

public interface ICbInvestSourceService {
	
	/**
	 * 
	* @Title: getCbInvestSourceOutsByPage 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pageNum
	* @param @param pageSize
	* @param @param keyword
	* @param @return  参数说明 
	* @return PageInfo<CbInvestSourceRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月26日 上午9:27:46
	 */
	PageInfo<CbInvestSourceRow> getCbInvestSourceOutsByPage(Integer pageNum, Integer pageSize, String keyword);

	/**
	 * 
	* @Title: findById 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param id
	* @param @return  参数说明 
	* @return CbInvestSource    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月26日 上午9:28:14
	 */
	CbInvestSource findById(Integer id);
	
	/**
	 * 
	* @Title: insert 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param cbInvestSource
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月26日 上午9:30:22
	 */
	int insert(CbInvestSource cbInvestSource);
	
	/**
	 * 
	* @Title: update 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param cbInvestSource
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月26日 上午9:36:17
	 */
	int update(CbInvestSource cbInvestSource);

	/**
	 * 
	* @Title: insertIncrementalWithResult 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param record
	* @param @return  参数说明 
	* @return String    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月9日 下午4:24:33
	 */
	String insertIncrementalWithResult(CbInvestSource record);
	
}
