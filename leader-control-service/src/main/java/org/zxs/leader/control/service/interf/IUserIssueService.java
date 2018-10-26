package org.zxs.leader.control.service.interf;

import org.zxs.leader.control.dao.model.UserIssue;
import org.zxs.leader.control.dao.model.vo.output.UserIssueOut;
import org.zxs.leader.control.dao.model.vo.output.rows.UserIssueRow;

import com.github.pagehelper.PageInfo;

public interface IUserIssueService {

	/**
	 * 保存用户意见
	 * @param userIssue
	 * @return
	 */
	int saveUserIssue(UserIssue userIssue);

	/**
	 * 获取用户意见分页列表
	 * @param pageNum
	 * @param pageSize
	 * @param userId
	 * @return
	 */
	PageInfo<UserIssueOut> getIssueByPage(Integer pageNum, Integer pageSize, int userId);
	
	/**
	 * 
	* @Title: getUserIssueOutsByPage 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pageNum
	* @param @param pageSize
	* @param @param keyword
	* @param @return  参数说明 
	* @return PageInfo<UserIssueRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月19日 下午4:05:14
	 */
	PageInfo<UserIssueRow> getUserIssueOutsByPage(Integer pageNum, Integer pageSize, String keyword);
}
