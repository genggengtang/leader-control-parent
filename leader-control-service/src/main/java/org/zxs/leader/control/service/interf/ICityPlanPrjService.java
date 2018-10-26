package org.zxs.leader.control.service.interf;


import java.util.List;

import org.zxs.leader.control.dao.model.CityPlanPrj;
import org.zxs.leader.control.dao.model.vo.output.CpPrjDetailOut;
import org.zxs.leader.control.dao.model.vo.output.CpPrjPageOut;
import org.zxs.leader.control.dao.model.vo.output.rows.CityPlanPrjRow;
import org.zxs.leader.control.dao.model.vo.query.CpPrjPageQuery;

import com.github.pagehelper.PageInfo;

public interface ICityPlanPrjService {

	/**
	 * 市统筹项目分页查询
	 * @param pageNum
	 * @param pageSize
	 * @param query
	 * @return
	 */
	PageInfo<CpPrjPageOut> getInfoByPage(Integer pageNum, Integer pageSize, CpPrjPageQuery query);

	/**
	 * 根据市统筹项目编号获取详情
	 * @param id
	 * @return
	 */
	CpPrjDetailOut getDetailById(int id);
	
	/**
	 * 根据项目库编码获取所有市统筹项目
	 * @return
	 */
	List<CityPlanPrj> getAllByPrjDb();
	
	/**
	 * 更新市统筹项目信息
	 * @param cpPrj
	 * @return
	 */
	int updateCityPlanPrj(CityPlanPrj cpPrj);
	
	/**
	 * 
	* @Title: getCityPlanPrjRowsByPage 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pageNum
	* @param @param pageSize
	* @param @param keyword
	* @param @return  参数说明 
	* @return PageInfo<CityPlanPrjRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月16日 下午3:54:38
	 */
	PageInfo<CityPlanPrjRow> getCityPlanPrjRowsByPage(Integer pageNum, Integer pageSize, String keyword);

	/**
	 * 
	* @Title: findById 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param id
	* @param @return  参数说明 
	* @return CityPlanPrj    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月31日 上午9:57:23
	 */
	CityPlanPrj findById(Integer id);

	/**
	 * 
	* @Title: insert 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param cityPlanPrj
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月31日 上午9:57:34
	 */
	int insert(CityPlanPrj cityPlanPrj);

	/**
	 * 
	* @Title: update 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param cityPlanPrj
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月31日 上午9:57:43
	 */
	int update(CityPlanPrj cityPlanPrj);
	
	/**
	 * 
	* @Title: insertIncrementalWithResult 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param record
	* @param @return  参数说明 
	* @return String    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月10日 上午9:15:57
	 */
	String insertIncrementalWithResult(CityPlanPrj record);
}
