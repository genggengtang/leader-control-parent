package org.zxs.leader.control.service.interf;

import java.util.List;

import org.zxs.leader.control.dao.model.LdPrjView;
import org.zxs.leader.control.dao.model.PrjInfo;
import org.zxs.leader.control.dao.model.PrjInfoInsertResult;
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

import com.github.pagehelper.PageInfo;

public interface IPrjInfoService {

	/**
	 * 查询项目列表
	 * @param query
	 * @return
	 */
	List<PrjListInfoOut> getAllInfo(PrjPageQuery query);
	
	/**
	 * 查询项目分页列表
	 * @param query
	 * @return
	 */
	PageInfo<PrjListInfoOut> getInfoByPage(PrjPageQuery query, int pageNum, int pageSize);
	
	/**
	 * 是否本人负责项目
	 * @param id
	 * @param userId
	 * @return
	 */
	boolean isPrjRspLeader(int id, int userId);
	
	/**
	 * 根据项目编号获取项目详情
	 * @param level 
	 * @param userId 
	 * @return
	 */
	PrjFullDetailOut getFullInfoById(PrjDetailQuery query);
	
	/**
	 * 根据关键字模糊查询项目名
	 * @param nameLike
	 * @return
	 */
	List<PrcSearchOut> getPrjByNameLike(String nameLike);
	
	/**
	 * 获取所有项目统计信息
	 * @return
	 */
	PrjStaticsOut getTotalStatics();
	
	/**
	 * 根据领导者编号获取统计信息
	 * @param leaderId 用户编号，为空时查询所有服务队统计信息
	 * @return
	 */
	List<PrjStaticsOut> getStaticsByLeaderId(Integer leaderId);
	
	/**
	 * 根据关注项目获取统计信息
	 * @param userId 项目关注者编号
	 * @return
	 */
	List<PrjStaticsOut> getStaticsByFavorite(int userId);
	
	/**
	 * 判断项目是否存在
	 * @param id
	 * @return
	 */
	boolean isPrjExist(int id);
	
	/**
	 * 获取项目计数
	 * @param query
	 * @return
	 */
	int getPrjCount(PrjCountQuery query);

	/**
	 * 根据用户信息获取项目基本信息
	 * @param id
	 * @param userId
	 * @param level
	 * @return
	 */
	PrjSimpleDetailOut getInfoById(PrjDetailQuery query);
	
	/**
	 * 根据项目编号获取地图展示信息
	 * @param id
	 * @param userId
	 * @param level
	 * @return
	 */
	PrjMapOut getMapInfoById(int id);
	
	/**
	 * 查询项目分页视图信息列表
	 * @param query
	 * @return
	 */
	PageInfo<LdPrjView> getViewByPage(PrjViewQuery query, int pageNum, int pageSize);
	
	/**
	 * 根据编号获取项目表信息
	 * @param prjId
	 * @return
	 */
	PrjInfo getPrjById(int prjId);
	
	/**
	 * 根据编号获取项目表信息
	 * @param prjId
	 * @return
	 */
	int updatePrjById(PrjInfo prj);
	
	/**
	 * 获取所有服务队领导信息
	 * @return
	 */
	List<OptionsOut> getAllLeaderList();
	
	/**
	 * 获取所有产业列表
	 * @return
	 */
	List<OptionsOut> getAllIndustryList();
	
	/**
	 * 获取所有建设进度列表
	 * @return
	 */
	List<OptionsOut> getAllBuildStatusList();
	
	/**
	 * 新增项目记录
	 * @param prj
	 * @return
	 */
	int createPrjInfo(PrjInfo prj);
	
	/**
	 * 获取所有项目信息
	 * @return
	 */
	List<PrjInfo> getAllPrjInfo();
	
	/**
	 * 批量插入项目信息
	 * @param prjInfoList
	 * @return
	 */
	PrjInfoInsertResult insertBatchIncremental(List<PrjInfo> prjInfoList);
	
	/**
	 * 增量插入项目信息
	 * @param prjInfo
	 * @return
	 */
	int insertIncremental(PrjInfo prjInfo);
	
	/**
	 * 
	* @Title: deleteById 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param id
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年6月28日 上午11:28:51
	 */
	int deleteById(int id);
	
	/**
	 * 
	* @Title: deleteByIdList 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param idList
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年6月28日 下午5:05:20
	 */
	int deleteByIdList(List<Integer> idList);
	
	/**
	 * 
	* @Title: getAllPrjInfoSoft 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<PrjInfo>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月5日 上午9:04:40
	 */
	List<PrjInfo> getAllPrjInfoSoft();

	/**
	 * 
	* @Title: getAllPrjInfoOptions 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<OptionsOut>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月16日 上午11:33:06
	 */
	List<OptionsOut> getAllPrjInfoOptions();

}
