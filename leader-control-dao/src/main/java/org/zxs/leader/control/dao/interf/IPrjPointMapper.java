package org.zxs.leader.control.dao.interf;

import java.util.List;

import org.zxs.leader.control.dao.model.PrjPoint;
import org.zxs.leader.control.dao.model.vo.output.rows.PrjPointRow;

import tk.mybatis.mapper.common.Mapper;

public interface IPrjPointMapper extends Mapper<PrjPoint> {
	
	/**
	 * 
	* @Title: selectAllRows 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<PrjPointRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月1日 上午11:22:54
	 */
	List<PrjPointRow> selectAllRows();

	/**
	 * 
	* @Title: selectRowsByKeyword 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param keyword
	* @param @return  参数说明 
	* @return List<PrjPointRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月23日 上午10:10:19
	 */
	List<PrjPointRow> selectRowsByKeyword(String keyword);

}