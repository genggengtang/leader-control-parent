package org.zxs.leader.control.dao.interf;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zxs.leader.control.dao.model.PrjMapLine;
import org.zxs.leader.control.dao.model.vo.output.OptionsOut;
import org.zxs.leader.control.dao.model.vo.output.PrjMapOut;
import org.zxs.leader.control.dao.model.vo.output.rows.PrjMapLineRow;

import tk.mybatis.mapper.common.Mapper;

public interface IPrjMapLineMapper extends Mapper<PrjMapLine> {
	
	/**
	 * 根据项目编号、类型，获取地图展示信息
	 * @return
	 */
	PrjMapOut selectPrjMapInfoById(@Param("prjId")int prjId, @Param("prjType")int prjType);

	/**
	 * 
	* @Title: selectAllOuts 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<PrjMapLineRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月19日 上午11:21:26
	 */
	List<PrjMapLineRow> selectAllOuts();
	
	/**
	 * 
	* @Title: selectOptions 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<OptionsOut>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月1日 上午11:36:03
	 */
	List<OptionsOut> selectOptions();

	/**
	 * 
	* @Title: selectRowsByKeyword 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param keyword
	* @param @return  参数说明 
	* @return List<PrjMapLineRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月23日 上午9:56:32
	 */
	List<PrjMapLineRow> selectRowsByKeyword(String keyword);
}