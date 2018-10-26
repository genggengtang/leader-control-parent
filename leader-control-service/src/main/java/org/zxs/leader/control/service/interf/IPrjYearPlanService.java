package org.zxs.leader.control.service.interf;

import java.util.List;

import org.zxs.leader.control.dao.model.PrjYearPlan;
import org.zxs.leader.control.dao.model.vo.output.PrjYearPrgOut;
import org.zxs.leader.control.dao.model.vo.output.rows.PrjYearPlanRow;

import com.github.pagehelper.PageInfo;

public interface IPrjYearPlanService {

	/**
	 * 根据项目编号获取年进度信息
	 * @param prjId
	 * @param prjType
	 * @param baseUrl 进度url前缀
	 * @return
	 */
	List<PrjYearPrgOut> getYearInfoByPrjId(int prjId, int prjType, String baseUrl);
	
	/**
	 * 根据年度编号获取年记录
	 * @param id
	 * @return
	 */
	PrjYearPlan getYearInfoById(int id);
	
	/**
	 * 
	* @Title: getPrjYearPlanRowsByPageAndKeyword 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pageNum
	* @param @param pageSize
	* @param @param keyword
	* @param @return  参数说明 
	* @return PageInfo<PrjYearPlanRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月9日 上午9:31:10
	 */
	PageInfo<PrjYearPlanRow> getPrjYearPlanRowsByPageAndKeyword(Integer pageNum, Integer pageSize, String keyword);
	
	/**
	 * 
	* @Title: findById 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param id
	* @param @return  参数说明 
	* @return PrjYearPlan    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月20日 上午10:27:32
	 */
	PrjYearPlan findById(Integer id);

	/**
	 * 
	* @Title: insert 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param prjYearPlan
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月20日 上午10:31:03
	 */
	int insert(PrjYearPlan prjYearPlan);

	/**
	 * 
	* @Title: update 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param prjYearPlan
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月20日 上午10:35:08
	 */
	int update(PrjYearPlan prjYearPlan);

	/**
	 * 
	* @Title: insertIncrementalWithResult 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param record
	* @param @return  参数说明 
	* @return String    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月9日 下午3:25:44
	 */
	String insertIncrementalWithResult(PrjYearPlan record);

}
