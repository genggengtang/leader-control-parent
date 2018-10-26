package org.zxs.leader.control.dao.interf;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zxs.leader.control.dao.model.PrjContact;
import org.zxs.leader.control.dao.model.vo.output.PrcSearchOut;
import org.zxs.leader.control.dao.model.vo.output.PrjContactOut;
import org.zxs.leader.control.dao.model.vo.output.rows.PrjContactRow;

import tk.mybatis.mapper.common.Mapper;

public interface IPrjContactMapper extends Mapper<PrjContact> {
	
	/**
	 * 根据项目编号、联系人类型、查询用户级别查询项目联系人集合
	 * @return
	 */
	List<PrjContactOut> selectByPrjIdAndType(@Param("record")PrjContact record, @Param("userLevel")Integer userLevel);
	
	/**
	 * 模糊查询项目业主信息
	 * @param query
	 * @return
	 */
	List<PrcSearchOut> selectByNameLike(String nameLike);
	
	/**
	 * 判断用户与项目的关系
	 * @param userId
	 * @param prjId
	 * @return
	 */
	int selectCountByUser(@Param("userId")int userId, @Param("prjId")int prjId);

	/**
	 * 
	* @Title: selectAllOuts 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<PrjContactRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月18日 上午10:01:55
	 */
	List<PrjContactRow> selectAllOuts();

	/**
	 * 
	* @Title: selectRowsByKeyword 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param keyword
	* @param @return  参数说明 
	* @return List<PrjContactRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月23日 上午10:53:43
	 */
	List<PrjContactRow> selectRowsByKeyword(String keyword);
}