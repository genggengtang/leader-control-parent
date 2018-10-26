package org.zxs.leader.control.dao.interf;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zxs.leader.control.dao.model.PrjMonthPlan;
import org.zxs.leader.control.dao.model.vo.output.OptionsOut;
import org.zxs.leader.control.dao.model.vo.output.PrjMonthReportOut;
import org.zxs.leader.control.dao.model.vo.output.PrjMonthSimpleOut;
import org.zxs.leader.control.dao.model.vo.output.rows.PrjMonthPlanRow;
import org.zxs.leader.control.dao.model.vo.query.MonthReportQuery;

import tk.mybatis.mapper.common.Mapper;

public interface IPrjMonthPlanMapper extends Mapper<PrjMonthPlan>{
	/**
	 * 根据项目编号、年份查询月报信息
	 * @param prjId
	 * @return
	 */
	List<PrjMonthSimpleOut> selectByPrjIdAndYear(@Param("prjId")Integer prjId, @Param("prjType")Integer prjType, @Param("year")Integer year);
	
	/**
	 * 根据年度计划ID获取月进度，日期截止当前月
	 * @param yearId
	 * @param baseUrl actualUrl前缀信息
	 * @return
	 */
	List<PrjMonthReportOut> selectByYearId(@Param("yearId")Integer yearId, @Param("baseUrl")String baseUrl);
	
	/**
	 * 根据年度计划ID获取月进度，日期截止当前月
	 * @param yearId
	 * @return
	 */
	List<PrjMonthSimpleOut> selectSimpleByYearId(Integer yearId);

	/**
	 * 获取月度记录分页列表
	 * @param query
	 * @return
	 */
	List<PrjMonthReportOut> selectListInfo(@Param("query")MonthReportQuery query);

	/**
	 * 查询图片名为空、地址非空的数据
	 * @return
	 */
	List<PrjMonthPlan> selectPicNameList();

	/**
	 * 
	* @Title: selectAllSoft 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<PrjMonthPlanRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月9日 上午10:33:20
	 */
	List<PrjMonthPlanRow> selectAllSoft();

	/**
	 * 
	* @Title: selectYearIdOptions 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<OptionsOut>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月16日 上午8:46:13
	 */
	List<OptionsOut> selectYearIdOptions();

	/**
	 * 
	* @Title: selectRowsByKeyword 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param keyword
	* @param @return  参数说明 
	* @return List<PrjMonthPlanRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月20日 下午4:07:03
	 */
	List<PrjMonthPlanRow> selectRowsByKeyword(String keyword);
}