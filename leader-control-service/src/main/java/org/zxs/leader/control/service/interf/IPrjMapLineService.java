package org.zxs.leader.control.service.interf;

import java.util.List;

import org.zxs.leader.control.dao.model.PrjMapLine;
import org.zxs.leader.control.dao.model.vo.output.OptionsOut;
import org.zxs.leader.control.dao.model.vo.output.rows.PrjMapLineRow;

import com.github.pagehelper.PageInfo;

public interface IPrjMapLineService {

	/**
	 * 
	* @Title: getPrjMapLineOutsByPage 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pageNum
	* @param @param pageSize
	* @param @param keyword
	* @param @return  参数说明 
	* @return PageInfo<PrjMapLineRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月19日 上午11:21:33
	 */
	PageInfo<PrjMapLineRow> getPrjMapLineOutsByPage(Integer pageNum, Integer pageSize, String keyword);
	
	/**
	 * 
	* @Title: findById 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param id
	* @param @return  参数说明 
	* @return PrjMapLine    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月1日 上午10:52:20
	 */
	PrjMapLine findById(Integer id);
	
	/**
	 * 
	* @Title: insert 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param prjMapLine
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月1日 上午10:52:23
	 */
	int insert(PrjMapLine prjMapLine);
	
	/**
	 * 
	* @Title: update 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param prjMapLine
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月1日 上午10:52:27
	 */
	int update(PrjMapLine prjMapLine);
	
	/**
	 * 
	* @Title: getOptions 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<OptionsOut>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月1日 上午11:51:31
	 */
	List<OptionsOut> getOptions();

	/**
	 * 
	* @Title: insertWithResult 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param record
	* @param @return  参数说明 
	* @return String    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月9日 上午9:56:15
	 */
	String insertWithResult(PrjMapLine record);

}
