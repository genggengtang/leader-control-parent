package org.zxs.leader.control.dao.interf;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zxs.leader.control.dao.model.PrjIssue;
import org.zxs.leader.control.dao.model.vo.output.PrjIssueOut;
import org.zxs.leader.control.dao.model.vo.output.rows.PrjIssueRow;

import tk.mybatis.mapper.common.Mapper;

public interface IPrjIssueMapper extends Mapper<PrjIssue> {
	
	/**
	 * 根据项目编号获取沟通情况信息
	 * @param prjId
	 * @param month 年月，格式为“yymm”
	 * @param month2 
	 * @return
	 */
	List<PrjIssueOut> selectByPrjId(@Param("prjId")Integer prjId, @Param("prjType")Integer prjType, @Param("year")Integer year, @Param("month")Integer month);
	
	/**
	 * 根据项目编号获取所有沟通信息月份
	 * @param prjId
	 * @param year
	 * @param year2 
	 * @return
	 */
	List<Integer> selectIssueMonth(@Param("prjId")Integer prjId, @Param("prjType")Integer prjType, @Param("year")Integer year);
	
	/**
	 * 根据项目编号、类型，获取所有沟通年信息
	 * @param prjId
	 * @return
	 */
	List<Integer> selectIssueYear(@Param("prjId")Integer prjId, @Param("prjType")Integer prjType);
	
	/**
	 * 根据编号获取详情
	 * @param id
	 * @return
	 */
	PrjIssueOut selectIssueById(int id);

	/**
	 * 
	* @Title: selectAllOuts 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<PrjIssueVo>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月18日 下午4:46:07
	 */
	List<PrjIssueRow> selectAllOuts();

	/**
	 * 
	* @Title: selectRowsByKeyword 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param keyword
	* @param @return  参数说明 
	* @return List<PrjIssueRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月23日 上午9:19:12
	 */
	List<PrjIssueRow> selectRowsByKeyword(String keyword);
}