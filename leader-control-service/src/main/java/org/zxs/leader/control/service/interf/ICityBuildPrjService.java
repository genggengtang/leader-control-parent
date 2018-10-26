package org.zxs.leader.control.service.interf;

import org.zxs.leader.control.dao.model.CityBuildPrj;
import org.zxs.leader.control.dao.model.vo.output.rows.CityBuildPrjRow;

import com.github.pagehelper.PageInfo;

public interface ICityBuildPrjService {
	
	/**
	 * 
	* @Title: getCityBuildPrjRowsByPage 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pageNum
	* @param @param pageSize
	* @param @param keyword
	* @param @return  参数说明 
	* @return PageInfo<CityBuildPrjRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月31日 上午8:55:57
	 */
	PageInfo<CityBuildPrjRow> getCityBuildPrjRowsByPage(Integer pageNum, Integer pageSize, String keyword);

	/**
	 * 
	* @Title: findById 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param id
	* @param @return  参数说明 
	* @return CityBuildPrj    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月31日 上午8:56:01
	 */
	CityBuildPrj findById(Integer id);
	
	/**
	 * 
	* @Title: insert 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param cityBuildPrj
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月31日 上午8:56:36
	 */
	int insert(CityBuildPrj cityBuildPrj);
	
	/**
	 * 
	* @Title: update 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param cityBuildPrj
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月31日 上午8:57:10
	 */
	int update(CityBuildPrj cityBuildPrj);
	
	/**
	 * 
	* @Title: insertIncrementalWithResult 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param record
	* @param @return  参数说明 
	* @return String    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月10日 上午9:15:46
	 */
	String insertIncrementalWithResult(CityBuildPrj record);

}
