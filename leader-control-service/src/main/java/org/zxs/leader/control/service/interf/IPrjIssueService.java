package org.zxs.leader.control.service.interf;

import java.util.List;

import org.zxs.leader.control.dao.model.PrjIssue;
import org.zxs.leader.control.dao.model.vo.output.PrjIssueOut;
import org.zxs.leader.control.dao.model.vo.output.PrjYearIssueOut;
import org.zxs.leader.control.dao.model.vo.output.rows.PrjIssueRow;

import com.github.pagehelper.PageInfo;

public interface IPrjIssueService {

	/**
	 * 根据项目编号获取项目问题列表
	 * @param prjId
	 * @param prjType
	 * @return
	 */
	List<PrjYearIssueOut> getIssueByPrjIdAndType(int prjId, int prjType);
	
	/**
	 * 根据编号获取沟通详情
	 * @param id
	 * @return
	 */
	PrjIssueOut getIssueById(int id);
	
	/**
	 * 
	* @Title: getPrjIssueOutsByPage 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pageNum
	* @param @param pageSize
	* @param @param keyword
	* @param @return  参数说明 
	* @return PageInfo<PrjIssueRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月18日 上午10:31:04
	 */
	PageInfo<PrjIssueRow> getPrjIssueOutsByPage(Integer pageNum, Integer pageSize, String keyword);
	
	/**
	 * 
	* @Title: findById 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param id
	* @param @return  参数说明 
	* @return PrjIssue    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月1日 上午9:32:15
	 */
	PrjIssue findById(Integer id);

	/**
	 * 
	* @Title: insert 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param prjIssue
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月1日 上午9:32:19
	 */
	int insert(PrjIssue prjIssue);
	
	/**
	 * 
	* @Title: update 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param prjIssue
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月1日 上午9:32:30
	 */
	int update(PrjIssue prjIssue);
	
	/**
	 * 
	* @Title: insertWithResult 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param record
	* @param @return  参数说明 
	* @return String    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月9日 下午3:03:37
	 */
	String insertWithResult(PrjIssue record);
	
}
