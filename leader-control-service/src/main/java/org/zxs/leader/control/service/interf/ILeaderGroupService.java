package org.zxs.leader.control.service.interf;

import org.zxs.leader.control.dao.model.LeaderGroup;
import org.zxs.leader.control.dao.model.vo.output.rows.LeaderGroupRow;

import com.github.pagehelper.PageInfo;

public interface ILeaderGroupService {
	
	/**
	 * 
	* @Title: getLeaderGroupRowsByPage 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pageNum
	* @param @param pageSize
	* @param @param keyword
	* @param @return  参数说明 
	* @return PageInfo<LeaderGroupRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月16日 下午5:35:00
	 */
	PageInfo<LeaderGroupRow> getLeaderGroupRowsByPage(Integer pageNum, Integer pageSize, String keyword);
	
	/**
	 * 
	* @Title: findById 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param id
	* @param @return  参数说明 
	* @return LeaderGroup    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月31日 下午6:09:36
	 */
	LeaderGroup findById(Integer id);
	
	/**
	 * 
	* @Title: insert 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param leaderGroup
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月31日 下午5:46:03
	 */
	int insert(LeaderGroup leaderGroup);

	/**
	 * 
	* @Title: update 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param leaderGroup
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月31日 下午5:46:07
	 */
	int update(LeaderGroup leaderGroup);

}
