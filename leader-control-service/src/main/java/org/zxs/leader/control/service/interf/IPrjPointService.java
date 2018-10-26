package org.zxs.leader.control.service.interf;

import org.zxs.leader.control.dao.model.PrjPoint;
import org.zxs.leader.control.dao.model.vo.output.rows.PrjPointRow;

import com.github.pagehelper.PageInfo;

public interface IPrjPointService {

	/**
	 * 
	* @Title: getPrjPointOutsByPage 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pageNum
	* @param @param pageSize
	* @param @param keyword
	* @param @return  参数说明 
	* @return PageInfo<PrjPointRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月19日 下午2:48:03
	 */
	PageInfo<PrjPointRow> getPrjPointOutsByPage(Integer pageNum, Integer pageSize, String keyword);
	
	/**
	 * 
	* @Title: findById 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param id
	* @param @return  参数说明 
	* @return PrjPoint    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月1日 上午11:06:52
	 */
	PrjPoint findById(Long id);
	
	/**
	 * 
	* @Title: insert 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param prjPoint
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月1日 上午11:06:55
	 */
	int insert(PrjPoint prjPoint);

	/**
	 * 
	* @Title: update 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param prjPoint
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月1日 上午11:06:58
	 */
	int update(PrjPoint prjPoint);
	
	/**
	 * 
	* @Title: insertWithResult 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param prjPoint
	* @param @return  参数说明 
	* @return String    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月8日 上午9:41:49
	 */
	String insertWithResult(PrjPoint prjPoint);

}
