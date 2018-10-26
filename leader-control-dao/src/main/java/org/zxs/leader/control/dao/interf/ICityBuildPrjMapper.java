package org.zxs.leader.control.dao.interf;

import java.util.List;

import org.zxs.leader.control.dao.model.CityBuildPrj;
import org.zxs.leader.control.dao.model.vo.output.rows.CityBuildPrjRow;

import tk.mybatis.mapper.common.Mapper;

public interface ICityBuildPrjMapper extends Mapper<CityBuildPrj> {
	
	/**
	 * 
	* @Title: selectAllOuts 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<CityBuildPrjRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月27日 上午9:55:01
	 */
	List<CityBuildPrjRow> selectAllOuts();

	/**
	 * 
	* @Title: selectRowsByKeyword 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param keyword
	* @param @return  参数说明 
	* @return List<CityBuildPrjRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月27日 上午9:55:04
	 */
	List<CityBuildPrjRow> selectRowsByKeyword(String keyword);

}