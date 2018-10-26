package org.zxs.leader.control.service.admin.interf;

import java.util.List;

import org.zxs.leader.control.dao.model.OrgUnit;
import org.zxs.leader.control.dao.model.vo.output.OptionsOut;
import org.zxs.leader.control.dao.model.vo.output.rows.OrgUnitRow;

import com.github.pagehelper.PageInfo;

public interface OrgUnitService {
	
	/**
	 * 
	* @Title: getOrgUnitOutsByPage 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pageNum
	* @param @param pageSize
	* @param @param keyword
	* @param @return  参数说明 
	* @return PageInfo<OrgUnitRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月4日 下午5:14:08
	 */
	PageInfo<OrgUnitRow> getOrgUnitOutsByPage(int pageNum, int pageSize, String keyword);
	
	/**
	 * 
	* @Title: getAllOrgUnit 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<OrgUnit>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月6日 上午8:18:43
	 */
	List<OrgUnit> getAllOrgUnit();
	
	/**
	 * 
	* @Title: insertOrgUnit 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param orgUnit
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月12日 上午8:08:39
	 */
	int insertOrgUnit(OrgUnit orgUnit);
	
	/**
	 * 
	* @Title: updateOrgUnit 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param orgUnit
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月12日 上午8:29:41
	 */
	int updateOrgUnit(OrgUnit orgUnit);
	
	/**
	 * 
	* @Title: findById 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param id
	* @param @return  参数说明 
	* @return OrgUnit    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月12日 上午9:22:51
	 */
	OrgUnit findById(Integer id);

	/**
	 * 
	* @Title: getAllOrgIdOptions 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<OptionsOut>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月12日 下午3:02:36
	 */
	List<OptionsOut> getAllOrgIdOptions();

	/**
	 * 
	* @Title: insertWithResult 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param record
	* @param @return  参数说明 
	* @return String    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月9日 上午10:16:21
	 */
	String insertWithResult(OrgUnit record);

}
