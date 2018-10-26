package org.zxs.leader.control.service.interf;

import java.util.List;

import org.zxs.leader.control.dao.model.OrgUser;
import org.zxs.leader.control.dao.model.vo.output.LoginUserOut;
import org.zxs.leader.control.dao.model.vo.output.OptionsOut;
import org.zxs.leader.control.dao.model.vo.output.PhoneListOut;
import org.zxs.leader.control.dao.model.vo.output.rows.OrgUserRow;
import org.zxs.leader.control.dao.model.vo.query.PhoneListQuery;

import com.github.pagehelper.PageInfo;

public interface IOrgUserService {

	/**
	 * 判断用户名是否存在
	 * @param username 用户名
	 * @return
	 */
	boolean isUserExist(String username);
	
	/**
	 * 根据用户名和密码查找用户，返回用户基本信息
	 * @param username
	 * @param password
	 * @return
	 */
	List<LoginUserOut> getLoginInfo(String username, String password);
	
	/**
	 * 是否服务队领导
	 * @param userId
	 * @return
	 */
	boolean isGroupLeader(int userId);
	
	/**
	 * 判断用户名是否存在
	 * @param id 用户编号
	 * @return
	 */
	boolean isUserExist(int id);

	/**
	 * 根据用户名查询用户列表
	 */
	List<OrgUser> getByUserName(String username);
	
	/**
	 * 根据用户ID、密码查找用户，返回用户基本信息
	 * @param id
	 * @param password
	 * @return
	 */
	LoginUserOut getLoginInfoById(int id, String password);
	
	/**
	 * 查询通讯录
	 * @param query
	 * @return
	 */
	List<PhoneListOut> getPhoneList(PhoneListQuery query);
	
	/**
	 * 修改密码
	 * @param userId
	 * @param pswdNew
	 * @return
	 */
	int updatePassword(int userId, String pswdNew);
	
	/**
	 * 
	* @Title: getAllOrgUser 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<OrgUser>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月6日 上午11:54:39
	 */
	List<OrgUser> getAllOrgUser();

	/**
	 * 
	* @Title: getRowsByPage 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pageNum
	* @param @param pageSize
	* @param @param keyword
	* @param @return  参数说明 
	* @return PageInfo<OrgUserRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月9日 上午9:59:59
	 */
	PageInfo<OrgUserRow> getRowsByPage(Integer pageNum, Integer pageSize, String keyword);

	/**
	 * 
	* @Title: findById 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param id
	* @param @return  参数说明 
	* @return OrgUser    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月12日 下午3:41:07
	 */
	OrgUser findById(Integer id);

	/**
	 * 
	* @Title: insert 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param orgUser
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月12日 下午3:47:11
	 */
	int insert(OrgUser orgUser);

	/**
	 * 
	* @Title: update 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param orgUser
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月12日 下午3:49:07
	 */
	int update(OrgUser orgUser);

	/**
	 * 
	* @Title: getAllUserIdOpts 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<OptionsOut>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月16日 上午9:30:18
	 */
	List<OptionsOut> getAllUserIdOpts();

	/**
	 * 
	* @Title: insertWithResult 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param record
	* @param @return  参数说明 
	* @return String    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月9日 上午10:16:29
	 */
	String insertWithResult(OrgUser record);

}
