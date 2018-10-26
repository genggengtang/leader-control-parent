package org.zxs.leader.control.service.interf;

import java.util.List;

import org.zxs.leader.control.dao.model.PrjContact;
import org.zxs.leader.control.dao.model.vo.output.PrcSearchOut;
import org.zxs.leader.control.dao.model.vo.output.PrjContactOut;
import org.zxs.leader.control.dao.model.vo.output.rows.PrjContactRow;

import com.github.pagehelper.PageInfo;

public interface IPrjContactService {

	/**
	 * 根据项目编号、联系人类型获取联系人列表
	 * @param prjId
	 * @param type
	 * @return
	 */
	List<PrjContactOut> getContactByPrjIdAndType(PrjContact prjContact, int userLevel);
	
	/**
	 * 模糊查询项目业主信息
	 * @param query
	 * @return
	 */
	List<PrcSearchOut> getPrjOwnerByNameLike(String nameLike);

	/**
	 * 判断用户是否与项目有关系
	 * @param userId
	 * @param prjId
	 * @return
	 */
	boolean isUserRelateLdprj(int userId, int prjId);
	
	/**
	 * 
	* @Title: getPrjContactOutsByPage 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pageNum
	* @param @param pageSize
	* @param @param keyword
	* @param @return  参数说明 
	* @return PageInfo<PrjContactRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月18日 上午9:56:17
	 */
	PageInfo<PrjContactRow> getPrjContactOutsByPage(Integer pageNum, Integer pageSize, String keyword);

	/**
	 * 
	* @Title: findById 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param id
	* @param @return  参数说明 
	* @return PrjContact    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月1日 上午9:22:40
	 */
	PrjContact findById(Integer id);
	
	/**
	 * 
	* @Title: insert 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param prjContact
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月1日 上午9:22:56
	 */
	int insert(PrjContact prjContact);
	
	/**
	 * 
	* @Title: update 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param prjContact
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月1日 上午9:22:59
	 */
	int update(PrjContact prjContact);
	
	/**
	 * 
	* @Title: insertWithResult 
	* @Description: 新增记录，如果出现异常则返回异常信息
	* @param @param record
	* @param @return  参数说明 
	* @return String    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月9日 上午9:00:35
	 */
	String insertWithResult(PrjContact record);
}
