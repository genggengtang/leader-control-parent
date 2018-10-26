package org.zxs.leader.control.dao.interf;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zxs.leader.control.dao.model.LdPrjView;
import org.zxs.leader.control.dao.model.PrjInfo;
import org.zxs.leader.control.dao.model.vo.output.OptionsOut;
import org.zxs.leader.control.dao.model.vo.output.PrcSearchOut;
import org.zxs.leader.control.dao.model.vo.output.PrjFullDetailOut;
import org.zxs.leader.control.dao.model.vo.output.PrjListInfoOut;
import org.zxs.leader.control.dao.model.vo.output.PrjMapOut;
import org.zxs.leader.control.dao.model.vo.output.PrjSimpleDetailOut;
import org.zxs.leader.control.dao.model.vo.output.PrjStaticsOut;
import org.zxs.leader.control.dao.model.vo.query.PrjCountQuery;
import org.zxs.leader.control.dao.model.vo.query.PrjDetailQuery;
import org.zxs.leader.control.dao.model.vo.query.PrjPageQuery;
import org.zxs.leader.control.dao.model.vo.query.PrjViewQuery;

import tk.mybatis.mapper.common.Mapper;

public interface IPrjInfoMapper extends Mapper<PrjInfo>{
	/**
	 * 查询项目信息
	 * @param query
	 * @return
	 */
	List<PrjListInfoOut> selectAllInfo(@Param("record")PrjPageQuery query);
	
	/**
	 * 根据编号、用户信息获取项目基本信息
	 * @param id
	 * @param userId
	 * @param level
	 * @return
	 */
	PrjSimpleDetailOut selectBaseInfoById(@Param("query")PrjDetailQuery query);
	
	/**
	 * 根据ID查询详细信息
	 * @param id
	 * @return
	 */
	PrjFullDetailOut selectFullInfoById(@Param("query")PrjDetailQuery query);
	
	/**
	 * 模糊查询项目名称信息
	 * @param query
	 * @return
	 */
	List<PrcSearchOut> selectByNameLike(String nameLike);
	
	/**
	 * 根据领导人编号获取领导人统计
	 * @param leaderId 用户编号，为空时查询所有服务队统计信息
	 * @return
	 */
	List<PrjStaticsOut> selectStaticsBySelf(@Param("leaderId")Integer leaderId);
	
	/**
	 * 按服务队获取项目统计
	 * @param leaderExclude 结果中排除的用户编号，为空时查询所有服务队统计信息
	 * @return
	 */
	List<PrjStaticsOut> selectGroupStaticsByLeaderId(@Param("leaderExclude")Integer leaderExclude);
	
	/**
	 * 根据关注项目获取统计信息
	 * @param userId
	 * @return
	 */
	List<PrjStaticsOut> selectStaticsByFavorite(Integer userId);

	/**
	 * 项目计数
	 * @return
	 */
	int selectByPrjCount(@Param("query")PrjCountQuery query);
	
	/**
	 * 获取所有项目统计信息
	 * @return
	 */
	PrjStaticsOut selectTotalStatics();
	
	/**
	 * 根据项目编号获取地图展示信息
	 * @param id
	 * @return
	 */
	PrjMapOut selectMapInfoById(int id);
	
	/**
	 * 获取项目预览信息
	 * @param query
	 * @return
	 */
	List<LdPrjView> selectPrjView(@Param("query")PrjViewQuery query);
	
	/**
	 * 
	* @Title: insertIncremental 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param prjInfo
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年6月25日 下午5:11:23
	 */
	int insertIncremental(PrjInfo prjInfo);
	
	/**
	 * 
	* @Title: deleteByIdList 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param idList
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年6月28日 下午5:10:59
	 */
	int deleteByIdList(List<Integer> idList);
	
	/**
	 * 
	* @Title: deleteByIdSoft 
	* @Description: 软删除，仅修改is_deleted字段，0为未删除，1为已删除。 
	* @param @param id
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年6月29日 上午8:35:15
	 */
	int deleteByIdSoft(int prjInfoId);
	
	/**
	 * 
	* @Title: deleteByIdList 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param idList
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年6月29日 上午8:48:34
	 */
	int deleteByIdListSoft(List<Integer> idList);
	
	/**
	 * 
	* @Title: selectAllSoft 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<PrjInfo>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月2日 上午11:42:30
	 */
	List<PrjInfo> selectAllSoft();
	
	/**
	 * 
	* @Title: selectAllPrjInfoOptions 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<OptionsOut>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月16日 上午11:36:24
	 */
	List<OptionsOut> selectAllPrjInfoOptions();

}