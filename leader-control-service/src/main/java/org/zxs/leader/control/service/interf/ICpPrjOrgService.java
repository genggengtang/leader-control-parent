package org.zxs.leader.control.service.interf;

import org.zxs.leader.control.dao.model.CpPrjOrg;
import org.zxs.leader.control.dao.model.vo.output.rows.CpPrjOrgRow;

import com.github.pagehelper.PageInfo;

public interface ICpPrjOrgService {
	
	/**
	 * 
	* @Title: getCpPrjOrgOutsByPage 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pageNum
	* @param @param pageSize
	* @param @param keyword
	* @param @return  参数说明 
	* @return PageInfo<CpPrjOrgRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月15日 下午4:59:20
	 */
	PageInfo<CpPrjOrgRow> getCpPrjOrgOutsByPage(Integer pageNum, Integer pageSize, String keyword);
	
	/**
	 * 
	* @Title: findById 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param id
	* @param @return  参数说明 
	* @return CpPrjOrg    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月31日 下午4:59:16
	 */
	CpPrjOrg findById(Integer id);
	
	/**
	 * 
	* @Title: insert 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param cpPrjOrg
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月31日 下午4:59:58
	 */
	int insert(CpPrjOrg cpPrjOrg);
	
	/**
	 * 
	* @Title: update 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param cpPrjOrg
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月31日 下午5:00:01
	 */
	int update(CpPrjOrg cpPrjOrg);
	
	/**
	 * 
	* @Title: insertIncrementalWithResult 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param record
	* @param @return  参数说明 
	* @return String    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月10日 上午10:38:29
	 */
	String insertIncrementalWithResult(CpPrjOrg record);

}
