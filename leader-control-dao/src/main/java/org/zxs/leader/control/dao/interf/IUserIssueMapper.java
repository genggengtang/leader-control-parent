package org.zxs.leader.control.dao.interf;

import java.util.List;

import org.zxs.leader.control.dao.model.UserIssue;
import org.zxs.leader.control.dao.model.vo.output.UserIssueOut;
import org.zxs.leader.control.dao.model.vo.output.rows.UserIssueRow;

import tk.mybatis.mapper.common.Mapper;

public interface IUserIssueMapper extends Mapper<UserIssue>{

	/**
	 * 根据用户编号获取意见列表
	 * @param userId
	 * @return
	 */
	List<UserIssueOut> selectIssueListByUser(int userId);

	/**
	 * 
	* @Title: selectAllOuts 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<UserIssueVo>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月19日 下午4:05:54
	 */
	List<UserIssueRow> selectAllOuts();

	/**
	 * 
	* @Title: selectRowsByKeyword 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param keyword
	* @param @return  参数说明 
	* @return List<UserIssueRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月23日 上午8:40:17
	 */
	List<UserIssueRow> selectRowsByKeyword(String keyword);
}