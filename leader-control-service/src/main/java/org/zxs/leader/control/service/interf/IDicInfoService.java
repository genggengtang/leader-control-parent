package org.zxs.leader.control.service.interf;

import java.util.List;

import org.zxs.leader.control.dao.model.vo.output.OptionsOut;

public interface IDicInfoService {
	
	List<OptionsOut> getAllOrgTypeOptions();
	
	/**
	 * 
	* @Title: getAllPhoneListTypeOptions 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<OptionsOut>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月12日 下午3:00:10
	 */
	List<OptionsOut> getAllPhoneListTypeOptions();

	/**
	 * 
	* @Title: getOptionsByType 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param type
	* @param @return  参数说明 
	* @return List<OptionsOut>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月13日 下午5:20:52
	 */
	List<OptionsOut> getOptionsByType(Integer type);
	
	/**
	 * 
	* @Title: getOptionsById 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param id
	* @param @return  参数说明 
	* @return List<OptionsOut>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月16日 上午9:49:41
	 */
	List<OptionsOut> getOptionsById(Integer id);
	
	/**
	 * 
	* @Title: getAllCityBuildTypeOptions 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<OptionsOut>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月31日 下午3:20:10
	 */
	List<OptionsOut> getAllCityBuildTypeOptions();
}
