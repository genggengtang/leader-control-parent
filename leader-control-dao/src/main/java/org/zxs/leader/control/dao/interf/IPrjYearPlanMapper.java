package org.zxs.leader.control.dao.interf;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zxs.leader.control.dao.model.PrjYearPlan;
import org.zxs.leader.control.dao.model.vo.output.rows.PrjYearPlanRow;

import tk.mybatis.mapper.common.Mapper;

public interface IPrjYearPlanMapper extends Mapper<PrjYearPlan>{

	/**
	 * 根据项目编号、项目类型获取相关年信息
	 * @param prjId
	 * @param prjType
	 * @return
	 */
	List<PrjYearPlan> selectYearListByPrj(@Param("prjId")int prjId, @Param("prjType")int prjType);
	
	/**
	 * 
	* @Title: selectAllSoft 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<PrjYearPlanRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月9日 上午9:28:56
	 */
	List<PrjYearPlanRow> selectAllSoft();

	/**
	 * 
	* @Title: selectRowsByKeyword 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param keyword
	* @param @return  参数说明 
	* @return List<PrjYearPlanRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月20日 上午9:35:43
	 */
	List<PrjYearPlanRow> selectRowsByKeyword(String keyword);

}