package org.zxs.leader.control.dao.interf;

import java.util.List;

import org.zxs.leader.control.dao.model.OrgUnit;
import org.zxs.leader.control.dao.model.vo.output.OptionsOut;
import org.zxs.leader.control.dao.model.vo.output.rows.OrgUnitRow;

import tk.mybatis.mapper.common.Mapper;

public interface IOrgUnitMapper extends Mapper<OrgUnit>{
	
	/**
	 * 
	* @Title: selectAllRows
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<OrgUnit>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月4日 下午5:11:04
	 */
	List<OrgUnitRow> selectAllRows();
	
	/**
	 * 
	* @Title: getAllOrgIdOptions 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<OptionsOut>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月12日 下午3:06:05
	 */
	List<OptionsOut> getAllOrgIdOptions();

	/**
	 * 
	* @Title: selectRowsByKeyword 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param keyword
	* @param @return  参数说明 
	* @return List<OrgUnitRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月20日 上午9:13:22
	 */
	List<OrgUnitRow> selectRowsByKeyword(String keyword);
	
}