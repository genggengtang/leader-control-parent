package org.zxs.leader.control.dao.interf;

import java.util.List;

import org.zxs.leader.control.dao.model.AreaNn;
import org.zxs.leader.control.dao.model.vo.output.OptionsOut;

import tk.mybatis.mapper.common.Mapper;

public interface IAreaNnMapper extends Mapper<AreaNn>{

	/**
	 * 获取除了省以外所有地区数据
	 * @return
	 */
	List<OptionsOut> selectAllWithoutProv();
	
	/**
	 * 
	* @Title: selectAllAreaNameOptions 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<OptionsOut>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月16日 下午4:46:06
	 */
	List<OptionsOut> selectAllAreaNameOptions();

}