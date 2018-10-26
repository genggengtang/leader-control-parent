package org.zxs.leader.control.dao.interf;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zxs.leader.control.dao.model.CbInvestSource;
import org.zxs.leader.control.dao.model.vo.output.InvestSourceOut;
import org.zxs.leader.control.dao.model.vo.output.rows.CbInvestSourceRow;

import tk.mybatis.mapper.common.Mapper;

public interface ICbInvestSourceMapper extends Mapper<CbInvestSource>{

	/**
	 * 根据项目编号及类型获取资金来源信息
	 * @param prjId
	 * @param prjType
	 * @return
	 */
	List<InvestSourceOut> selectInvestSourceByPrjId(@Param("prjId")int prjId);
	
	/**
	 * 
	* @Title: selectAllOuts 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<CbInvestSourceRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月13日 下午4:53:16
	 */
	List<CbInvestSourceRow> selectAllOuts();

	/**
	 * 
	* @Title: selectRowsByKeyword 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param keyword
	* @param @return  参数说明 
	* @return List<CbInvestSourceRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月20日 下午4:23:37
	 */
	List<CbInvestSourceRow> selectRowsByKeyword(String keyword);
}