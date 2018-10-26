package org.zxs.leader.control.service.interf;

import java.util.List;
import java.util.Map;

import org.zxs.leader.control.dao.model.CbPlanPrj;
import org.zxs.leader.control.dao.model.vo.output.CbClauseOut;
import org.zxs.leader.control.dao.model.vo.output.CbFullDetailOut;
import org.zxs.leader.control.dao.model.vo.output.CbPrjPageInfoOut;
import org.zxs.leader.control.dao.model.vo.output.CbSimpleDetailOut;
import org.zxs.leader.control.dao.model.vo.output.OptionsOut;
import org.zxs.leader.control.dao.model.vo.output.PrcSearchOut;
import org.zxs.leader.control.dao.model.vo.output.PrjContactOut;
import org.zxs.leader.control.dao.model.vo.output.PrjMapOut;
import org.zxs.leader.control.dao.model.vo.output.PrjStaticsOut;
import org.zxs.leader.control.dao.model.vo.output.rows.CbPlanPrjRow;
import org.zxs.leader.control.dao.model.vo.query.CbPrjPageQuery;
import org.zxs.leader.control.dao.model.vo.query.PrjDetailQuery;

import com.github.pagehelper.PageInfo;

public interface ICbPlanPrjService {

	/**
	 * 获取城建计划项目列表
	 * @param query
	 * @return
	 */
	List<CbPrjPageInfoOut> getCbPrjList(CbPrjPageQuery query);

	/**
	 * 获取城建计划项目分页列表
	 * @param query
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	PageInfo<CbPrjPageInfoOut> getInfoByPage(CbPrjPageQuery query, Integer pageNum, Integer pageSize);
	
	/**
	 * 根据关键字模糊查询项目名
	 * @param nameLike
	 * @param planNo 
	 * @param isKeyPrj 
	 * @return
	 */
	List<PrcSearchOut> getCbPrjByNameLike(String nameLike, Integer planNo, Integer isKeyPrj);
	
	/**
	 * 根据关键字模糊查询项目业主单位
	 * @param nameLike
	 * @param planNo 
	 * @param isKeyPrj 
	 * @return
	 */
	List<PrcSearchOut> getPrjOwnerByNameLike(String nameLike, Integer planNo, Integer isKeyPrj);
	
	/**
	 * 根据城建项目编号，获取基本详情信息
	 * @param id
	 * @return
	 */
	CbSimpleDetailOut getSimpleDetailById(int id);
	
	/**
	 * 根据城建项目编号，获取全部详情信息
	 * @param id
	 * @return
	 */
	CbFullDetailOut getFullDetail(PrjDetailQuery query);
	
	/**
	 * 根据城建计划项目编号获取业主联系人信息
	 * @param id
	 * @return
	 */
	List<PrjContactOut> getOwnerListById(int id);

	/**
	 * 获取城建计划项目计数，返回项目计划期名称和对应的计数
	 * @param planNo
	 * @param label
	 * @param isKeyPrj
	 * @return
	 */
	Map<String, Integer> getCbCount(int planNo, Integer label, Integer isKeyPrj);

	/**
	 * 获取所有城建计划项目统计信息
	 * @return
	 */
	PrjStaticsOut getTotalStatics();

	/**
	 * 根据领导者编号获取统计信息
	 * @param leaderId 负责领导人编号
	 * @param isSelf 是否查本人，0为查其他人，1为查本人，空为查所有人
	 * @return
	 */
	List<PrjStaticsOut> getStaticsByLeaderId(Integer userId, Integer isSelf);

	/**
	 * 根据关注项目获取统计信息
	 * @param userId 项目关注者编号
	 * @return
	 */
	List<PrjStaticsOut> getStaticsByFavorite(int userId);
	
	/**
	 * 根据城建计划期数，获取项目分类及重点分类字典内容
	 * @param planNo
	 * @return
	 */
	CbClauseOut getCbClauseList(int planNo);

	/**
	 * 根据城建项目编号，获取地图线信息
	 * @param id
	 * @return
	 */
	PrjMapOut getMapInfoById(Integer id);

	/**
	 * 判断用户与项目是否有关联关系
	 * @param userId
	 * @param id
	 * @return
	 */
	boolean isUserRelateCbprj(int userId, Integer id);
	
	/**
	 * 
	* @Title: getCbPlanPrjOutsByPage 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pageNum
	* @param @param pageSize
	* @param @param keyword
	* @param @return  参数说明 
	* @return PageInfo<CbPlanPrjRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月13日 下午5:46:50
	 */
	PageInfo<CbPlanPrjRow> getCbPlanPrjOutsByPage(Integer pageNum, Integer pageSize, String keyword);

	/**
	 * 
	* @Title: getPrjPlanIdNameOptions 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<OptionsOut>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月16日 上午9:15:27
	 */
	List<OptionsOut> getPrjPlanIdNameOptions();

	/**
	 * 
	* @Title: findById 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param id
	* @param @return  参数说明 
	* @return CbPlanPrj    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月27日 上午11:54:01
	 */
	CbPlanPrj findById(Integer id);

	/**
	 * 
	* @Title: insert 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param cbPlanPrj
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月27日 上午11:54:18
	 */
	int insert(CbPlanPrj cbPlanPrj);

	/**
	 * 
	* @Title: update 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param cbPlanPrj
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月27日 上午11:54:22
	 */
	int update(CbPlanPrj cbPlanPrj);

	/**
	 * 
	* @Title: insertIncrementalWithResult 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param record
	* @param @return  参数说明 
	* @return String    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月9日 下午6:05:36
	 */
	String insertIncrementalWithResult(CbPlanPrj record);

}
