package org.zxs.leader.control.dao.interf;

import java.util.List;

import org.zxs.leader.control.dao.model.LeaderGroup;
import org.zxs.leader.control.dao.model.vo.output.OptionsOut;
import org.zxs.leader.control.dao.model.vo.output.rows.LeaderGroupRow;

import tk.mybatis.mapper.common.Mapper;

public interface ILeaderGroupMapper extends Mapper<LeaderGroup> {
	
	/**
	 * 获取所有服务队领导列表
	 * @return
	 */
	List<OptionsOut> selectLeaderList();

	/**
	 * 
	* @Title: selectAllOuts 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<LeaderGroupRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月16日 下午5:34:54
	 */
	List<LeaderGroupRow> selectAllOuts();

	/**
	 * 
	* @Title: selectRowsByKeyword 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param keyword
	* @param @return  参数说明 
	* @return List<LeaderGroupRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月23日 上午10:42:24
	 */
	List<LeaderGroupRow> selectRowsByKeyword(String keyword);
	
}