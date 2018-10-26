package org.zxs.leader.control.service.interf;

import java.util.List;
import java.util.Map;

import org.zxs.leader.control.dao.model.PrjMonthPlan;
import org.zxs.leader.control.dao.model.vo.output.OptionsOut;
import org.zxs.leader.control.dao.model.vo.output.PrjMonthReportOut;
import org.zxs.leader.control.dao.model.vo.output.PrjMonthSimpleOut;
import org.zxs.leader.control.dao.model.vo.output.rows.PrjMonthPlanRow;
import org.zxs.leader.control.dao.model.vo.query.MonthReportQuery;

import com.github.pagehelper.PageInfo;

public interface IPrjMonthPlanService {

	/**
	 * 根据项目编号获取月报信息
	 * @param prjId
	 * @return
	 */
	List<PrjMonthSimpleOut> getMonthReportByPrjIdAndYear(int prjId, int prjType, Integer year);
	
	/**
	 * 根据项目编号、项目类型获取月报信息
	 * @param prjId
	 * @param prjType
	 * @return
	 */
	Map<Integer, List<PrjMonthSimpleOut>> getMonthReportByPrjId(int prjId, int prjType);
	
	/**
	 * 根据项目信息获取月度记录
	 * @param prjType
	 * @param prjId
	 * @param year
	 * @param month
	 * @return
	 */
	PrjMonthPlan getMonthPlan(int prjType, int prjId, int year, int month);
	
	/**
	 * 根据ID获取月度记录
	 * @param id
	 * @return
	 */
	PrjMonthPlan getMonthPlanById(int id);
	
	/**
	 * 更新月度进度信息
	 * @param monthPlan
	 * @return
	 */
	int updateMonthPlan(PrjMonthPlan monthPlan);
	
	/**
	 * 保存月度进度信息
	 * @param monthPlan
	 * @return
	 */
	int saveMonthPlan(PrjMonthPlan monthPlan);

	/**
	 * 获取月记录分页信息
	 * @param pageNum
	 * @param pageSize
	 * @param query
	 * @return
	 */
	PageInfo<PrjMonthReportOut> getMonthInfoByPage(Integer pageNum, Integer pageSize, MonthReportQuery query);
	
	/**
	 * 获取图片名为空、图片地址非空的月进度信息
	 * @return
	 */
	List<PrjMonthPlan> getPicNameList();
	
	/**
	 * 
	* @Title: getPrjMonthPlanOutsByPage 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pageNum
	* @param @param pageSize
	* @param @param keyword
	* @param @return  参数说明 
	* @return PageInfo<PrjMonthPlanRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月9日 上午10:31:42
	 */
	PageInfo<PrjMonthPlanRow> getPrjMonthPlanOutsByPage(Integer pageNum, Integer pageSize, String keyword);

	/**
	 * 
	* @Title: getYearIdOptions 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<OptionsOut>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月16日 上午8:41:00
	 */
	List<OptionsOut> getYearIdOptions();

	/**
	 * 
	* @Title: findById 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param id
	* @param @return  参数说明 
	* @return PrjMonthPlan    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月20日 下午4:17:17
	 */
	PrjMonthPlan findById(Integer id);

	/**
	 * 
	* @Title: insert 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param prjMonthPlan
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月20日 下午4:19:58
	 */
	int insert(PrjMonthPlan prjMonthPlan);

	/**
	 * 
	* @Title: update 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param prjMonthPlan
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月20日 下午4:20:01
	 */
	int update(PrjMonthPlan prjMonthPlan);

	/**
	 * 
	* @Title: insertIncrementalWithResult 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param record
	* @param @return  参数说明 
	* @return String    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月9日 下午3:25:53
	 */
	String insertIncrementalWithResult(PrjMonthPlan record);
}
