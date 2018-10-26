package org.zxs.leader.control.service.interf;

import org.zxs.leader.control.dao.model.WorkInfo;

import com.github.pagehelper.PageInfo;

public interface IWorkInfoService {

	/**
	 * 查询工作资讯分页列表
	 * @param query
	 * @return
	 */
	PageInfo<WorkInfo> getInfoByPage(int pageNum, int pageSize);
	
	/**
	 * 
	* @Title: getAllWorkInfoByPage 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pageNum
	* @param @param pageSize
	* @param @param keyword
	* @param @return  参数说明 
	* @return PageInfo<WorkInfo>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月19日 下午3:49:27
	 */
	PageInfo<WorkInfo> getAllWorkInfoByPage(Integer pageNum, Integer pageSize, String keyword);

	/**
	 * 
	* @Title: findById 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param id
	* @param @return  参数说明 
	* @return WorkInfo    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月3日 上午11:49:51
	 */
	WorkInfo findById(Integer id);
	
	/**
	 * 
	* @Title: insert 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param workInfo
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月3日 上午11:49:55
	 */
	int insert(WorkInfo workInfo);

	/**
	 * 
	* @Title: update 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param workInfo
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月3日 上午11:49:58
	 */
	int update(WorkInfo workInfo);

}
