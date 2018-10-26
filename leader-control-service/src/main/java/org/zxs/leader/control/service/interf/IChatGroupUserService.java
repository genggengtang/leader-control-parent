package org.zxs.leader.control.service.interf;

import java.util.List;

import org.zxs.base.model.CommonReturnBean;
import org.zxs.leader.control.dao.model.ChatGroupUser;
import org.zxs.leader.control.dao.model.vo.output.ChatMemberOut;
import org.zxs.leader.control.dao.model.vo.output.rows.ChatGroupUserRow;

import com.github.pagehelper.PageInfo;

public interface IChatGroupUserService {
	/**
	 * 判断用户是否在群组中
	 * @param userId
	 * @param cgId
	 * @return
	 */
	boolean isUserInGroup(int userId, int cgId);
	
	/**
	 * 判断用户是否群主
	 * @param userId
	 * @param cgId
	 * @return
	 */
	boolean isUserGroupOwner(int userId, int cgId);
	
	/**
	 * 是否群管理员，能否加、减成员
	 * @param userId
	 * @param cgId
	 * @return
	 */
	boolean isGroupAdmin(int userId, int cgId);
	
	/**
	 * 添加群组成员
	 * @param cgId
	 * @param userArray
	 * @return
	 */
	CommonReturnBean<ChatMemberOut> addCgMember(int cgId, List<Integer> userArray);
	
	/**
	 * 移除群组成员
	 * @param cgId
	 * @param userArray
	 * @return
	 */
	CommonReturnBean<ChatMemberOut> removeCgMember(int cgId, List<Integer> userArray);
	
	/**
	 * 根据聊天群组编号，获取群组成员编号集合
	 * @return
	 */
	List<Integer> getUserByCgId(int cgId, Integer selfId);

	/**
	 * 
	* @Title: getChatGroupUserOutsByPage 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pageNum
	* @param @param pageSize
	* @param @param keyword
	* @param @return  参数说明 
	* @return PageInfo<ChatGroupUserRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月16日 上午11:55:45
	 */
	PageInfo<ChatGroupUserRow> getChatGroupUserOutsByPage(Integer pageNum, Integer pageSize, String keyword);
	
	/**
	 * 
	* @Title: findById 
	* @Description: 根据id查找群聊用户表中的用户
	* @param @param id
	* @param @return  参数说明 
	* @return ChatGroupUser    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月31日 上午8:30:35
	 */
	ChatGroupUser findById(Integer id);

	/**
	 * 
	* @Title: update 
	* @Description: 更新群聊用户表
	* @param @param chatGroupUser
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月31日 上午8:31:03
	 */
	int update(ChatGroupUser chatGroupUser);

}
