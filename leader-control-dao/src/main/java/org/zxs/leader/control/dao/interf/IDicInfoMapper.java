package org.zxs.leader.control.dao.interf;

import java.util.List;

import org.zxs.leader.control.dao.model.DicInfo;
import org.zxs.leader.control.dao.model.vo.output.OptionsOut;

import tk.mybatis.mapper.common.Mapper;

public interface IDicInfoMapper extends Mapper<DicInfo> {
	
	/**
	 * 
	* @Title: selectAllOrgTypeOptions 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<OptionsOut>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月12日 下午3:00:35
	 */
	List<OptionsOut> selectAllOrgTypeOptions();
	
	/**
	 * 
	* @Title: selectAllPhoneListTypeOptions 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<OptionsOut>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月12日 下午3:00:41
	 */
	List<OptionsOut> selectAllPhoneListTypeOptions();

	/**
	 * 
	* @Title: selectOptionsByType 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param type
	* @param @return  参数说明 
	* @return List<OptionsOut>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月13日 下午5:21:17
	 */
	List<OptionsOut> selectOptionsByType(Integer type);
	
	/**
	 * 
	* @Title: selectOptionsById 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param id
	* @param @return  参数说明 
	* @return List<OptionsOut>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月16日 上午9:42:58
	 */
	List<OptionsOut> selectOptionsById(Integer id);
	
}