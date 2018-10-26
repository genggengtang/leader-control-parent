package org.zxs.leader.control.service.interf;

import java.util.List;

import org.zxs.leader.control.dao.model.PrjProve;
import org.zxs.leader.control.dao.model.vo.output.PrjProveOut;
import org.zxs.leader.control.dao.model.vo.output.rows.PrjProveRow;

import com.github.pagehelper.PageInfo;

public interface IPrjProveService {

	/**
	 * 根据项目编号获取审批详情
	 * @param prjId
	 * @param prjType
	 * @return
	 */
	List<PrjProveOut> getByPrjId(int prjId, int prjType);

	/**
	 * 
	* @Title: getPrjProveOutsByPage 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pageNum
	* @param @param pageSize
	* @param @param keyword
	* @param @return  参数说明 
	* @return PageInfo<PrjProveRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月19日 下午3:21:10
	 */
	PageInfo<PrjProveRow> getPrjProveOutsByPage(Integer pageNum, Integer pageSize, String keyword);
	
	/**
	 * 
	* @Title: findById 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param id
	* @param @return  参数说明 
	* @return PrjProve    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月3日 上午10:25:40
	 */
	PrjProve findById(Integer id);

	/**
	 * 
	* @Title: insert 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param prjProve
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月3日 上午10:25:44
	 */
	int insert(PrjProve prjProve);

	/**
	 * 
	* @Title: update 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param prjProve
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月3日 上午10:25:48
	 */
	int update(PrjProve prjProve);
	
	/**
	 * 
	* @Title: insertWithResult 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param record
	* @param @return  参数说明 
	* @return String    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月9日 下午3:11:11
	 */
	String insertWithResult(PrjProve record);
	
}
