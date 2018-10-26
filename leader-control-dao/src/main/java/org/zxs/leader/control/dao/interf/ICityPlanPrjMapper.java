package org.zxs.leader.control.dao.interf;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zxs.leader.control.dao.model.CityPlanPrj;
import org.zxs.leader.control.dao.model.vo.output.CpPrjDetailOut;
import org.zxs.leader.control.dao.model.vo.output.CpPrjPageOut;
import org.zxs.leader.control.dao.model.vo.output.rows.CityPlanPrjRow;
import org.zxs.leader.control.dao.model.vo.query.CpPrjPageQuery;

import tk.mybatis.mapper.common.Mapper;

public interface ICityPlanPrjMapper extends Mapper<CityPlanPrj> {

	/**
	 * 按条件查询市统筹项目列表
	 * @param query
	 * @return
	 */
	List<CpPrjPageOut> selectListInfo(@Param("query")CpPrjPageQuery query);

	/**
	 * 根据项目编号获取详情
	 * @param id
	 * @return
	 */
	CpPrjDetailOut selectDetailById(@Param("id")int id);

	/**
	 * 
	* @Title: selectAllOuts 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<CityPlanPrjRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月16日 下午3:55:32
	 */
	List<CityPlanPrjRow> selectAllOuts();
	
	/**
	 * 
	* @Title: selectRowsByKeyword 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param keyword
	* @param @return  参数说明 
	* @return List<CityPlanPrjRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月27日 上午10:53:02
	 */
	List<CityPlanPrjRow> selectRowsByKeyword(String keyword);

}