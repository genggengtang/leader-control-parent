package org.zxs.leader.control.dao.interf;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zxs.leader.control.dao.model.CbPlanPrj;
import org.zxs.leader.control.dao.model.vo.output.CbFullDetailOut;
import org.zxs.leader.control.dao.model.vo.output.CbPrjPageInfoOut;
import org.zxs.leader.control.dao.model.vo.output.CbSimpleDetailOut;
import org.zxs.leader.control.dao.model.vo.output.OptionsOut;
import org.zxs.leader.control.dao.model.vo.output.PrcSearchOut;
import org.zxs.leader.control.dao.model.vo.output.PrjMapOut;
import org.zxs.leader.control.dao.model.vo.output.PrjStaticsOut;
import org.zxs.leader.control.dao.model.vo.output.rows.CbPlanPrjRow;
import org.zxs.leader.control.dao.model.vo.query.CbPrjPageQuery;
import org.zxs.leader.control.dao.model.vo.query.PrjDetailQuery;

import tk.mybatis.mapper.common.Mapper;

public interface ICbPlanPrjMapper extends Mapper<CbPlanPrj> {
	/**
	 * 查询项目列表信息
	 * @param query
	 * @return
	 */
	List<CbPrjPageInfoOut> selectListInfo(@Param("record")CbPrjPageQuery query);

	/**
	 * 根据关键字查询城建计划项目
	 * @param nameLike
	 * @param planNo 
	 * @param isKeyPrj 
	 * @return
	 */
	List<PrcSearchOut> selectCbPrjbyNameLike(@Param("nameLike")String nameLike, @Param("planNo")Integer planNo, @Param("isKeyPrj")Integer isKeyPrj);

	/**
	 * 根据项目编号获取基本详情信息
	 * @param id
	 * @return
	 */
	CbSimpleDetailOut selectSimpleInfoById(int id);

	/**
	 * 获取项目全部详情
	 * @param query
	 * @return
	 */
	CbFullDetailOut selectFullInfo(@Param("query")PrjDetailQuery query);

	/**
	 * 获取项目计数
	 * @param planNo
	 * @param label
	 * @param isKeyPrj
	 * @return
	 */
	int selectCbCount(@Param("planNo")int planNo, @Param("label")Integer label, @Param("isKeyPrj")Integer isKeyPrj);

	/**
	 * 获取所有项目统计信息
	 * @return
	 */
	PrjStaticsOut selectTotalStatics();

	/**
	 * 根据领导人编号获取领导人统计
	 * @param leaderId 领导人编号
	 * @param isSelf 是否查询本人负责项目,0为查询其他人负责，1为查询本人负责，null为所有人
	 * @return
	 */
	List<PrjStaticsOut> selectLeaderStaticsByLeaderId(@Param("userId")Integer userId, @Param("isSelf")Integer isSelf);

	/**
	 * 根据关注项目获取统计信息
	 * @param userId
	 * @return
	 */
	List<PrjStaticsOut> selectStaticsByFavorite(@Param("userId")int userId);

	/**
	 * 根据项目编号获取地图展示信息
	 * @param id
	 * @return
	 */
	PrjMapOut selectMapInfoById(Integer id);
	
	/**
	 * 
	* @Title: selectAllOuts 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<CbPlanPrjRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月13日 下午5:53:25
	 */
	List<CbPlanPrjRow> selectAllOuts();

	/**
	 * 
	* @Title: selectPrjPlanIdNameOptions 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<OptionsOut>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月26日 上午10:53:36
	 */
	List<OptionsOut> selectPrjPlanIdNameOptions();
	
	/**
	 * 
	* @Title: selectRowsByKeyword 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param keyword
	* @param @return  参数说明 
	* @return List<CbPlanPrjRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月23日 上午11:44:56
	 */
	List<CbPlanPrjRow> selectRowsByKeyword(String keyword);
	
}