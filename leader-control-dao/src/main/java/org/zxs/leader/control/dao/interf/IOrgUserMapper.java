package org.zxs.leader.control.dao.interf;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zxs.leader.control.dao.model.OrgUser;
import org.zxs.leader.control.dao.model.vo.output.LoginUserOut;
import org.zxs.leader.control.dao.model.vo.output.OptionsOut;
import org.zxs.leader.control.dao.model.vo.output.PrcSearchOut;
import org.zxs.leader.control.dao.model.vo.output.SimpleUserOut;
import org.zxs.leader.control.dao.model.vo.output.rows.OrgUserRow;
import org.zxs.leader.control.dao.model.vo.query.OrgUserQuery;
import org.zxs.leader.control.dao.model.vo.query.PhoneListQuery;

import tk.mybatis.mapper.common.Mapper;

public interface IOrgUserMapper extends Mapper<OrgUser>{
	
	List<LoginUserOut> selectLoginInfoByLoginNameAndPsw(@Param("record")OrgUserQuery record);
	
	/**
	 * 根据姓名左匹配查询领导人用户
	 * @param nameLike
	 * @return
	 */
	List<PrcSearchOut> selectLeaderPrjByNameLike(String nameLike);
	
	/**
	 * 根据yonghu编号获取用户登录信息
	 * @param id
	 * @param password
	 * @return
	 */
	LoginUserOut selectLoginInfoById(@Param("id")int id, @Param("password")String password);
	
	/**
	 * 根据用户编号数组，返回名字串，以逗号分隔
	 * @param idArray
	 * @return
	 */
	String selectNameInRow(List<Integer> ids);
	
	/**
	 * 根据通讯录分组获取用户基本信息
	 * @param query
	 * @param phoneListType
	 * @return
	 */
	List<SimpleUserOut> selectPhoneListByType(@Param("query")PhoneListQuery query, @Param("type")Integer phoneListType);
	
	/**
	 * 修改密码
	 * @param userId
	 * @param pswdNew
	 * @param updateAt
	 * @return
	 */
	int updatePassword(@Param("userId")int userId, @Param("pswdNew")String pswdNew);

	/**
	 * 根据关键字获取城建项目负责领导
	 * @param nameLike
	 * @return
	 */
	List<PrcSearchOut> selectCbLeaderByNameLike(String nameLike);
	
	/**
	 * 
	* @Title: selectAllRows 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<OrgUserRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月9日 上午10:07:30
	 */
	List<OrgUserRow> selectAllRows();
	
	/**
	 * 
	* @Title: selectAllUserIdOpts 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<OptionsOut>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月16日 上午9:31:54
	 */
	List<OptionsOut> selectAllUserIdOpts();

	/**
	 * 
	* @Title: selectRowsByKeyword 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param keyword
	* @param @return  参数说明 
	* @return List<OrgUserRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月10日 下午4:52:55
	 */
	List<OrgUserRow> selectRowsByKeyword(String keyword);

}