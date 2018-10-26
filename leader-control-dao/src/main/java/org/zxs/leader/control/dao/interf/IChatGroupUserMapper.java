package org.zxs.leader.control.dao.interf;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zxs.leader.control.dao.model.ChatGroupUser;
import org.zxs.leader.control.dao.model.vo.output.SimpleUserOut;
import org.zxs.leader.control.dao.model.vo.output.rows.ChatGroupUserRow;

import tk.mybatis.mapper.common.Mapper;

public interface IChatGroupUserMapper extends Mapper<ChatGroupUser> {
	/**
	 * 根据群组编号，获取组员信息，不包括群主
	 * @param cgId
	 * @return
	 */
	List<SimpleUserOut> selectMembersByGroupId(int cgId);
	
	/**
	 * 获取移除用户之外的用户名字符串，用逗号分隔
	 * @param cgId
	 * @param removeList
	 * @return
	 */
	String selectUserNameWithoutRemoveArray(@Param("cgId")int cgId, @Param("removeList")List<Integer> removeList);
	
	/**
	 * 获取组员编号集合
	 * @param cgId
	 * @param selfId 查询结果是否排除自己的编号
	 * @return
	 */
	List<Integer> selectUserIdByCgId(@Param("cgId")int cgId, @Param("selfId")Integer selfId);

	/**
	 * 
	* @Title: selectAllOuts 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<ChatGroupUserRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月16日 上午11:57:25
	 */
	List<ChatGroupUserRow> selectAllOuts();

	/**
	 * 
	* @Title: selectRowsByKeyword 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param keyword
	* @param @return  参数说明 
	* @return List<ChatGroupUserRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月27日 上午8:36:22
	 */
	List<ChatGroupUserRow> selectRowsByKeyword(String keyword);
}