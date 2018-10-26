package org.zxs.leader.control.service.interf;

import java.util.List;

import org.zxs.leader.control.dao.model.ChatGroupInfo;
import org.zxs.leader.control.dao.model.vo.output.ChatGroupBaseOut;
import org.zxs.leader.control.dao.model.vo.output.ChatGroupListOut;
import org.zxs.leader.control.dao.model.vo.output.ChatGroupSimpleOut;
import org.zxs.leader.control.dao.model.vo.output.OptionsOut;
import org.zxs.leader.control.dao.model.vo.output.rows.ChatGroupInfoRow;

import com.github.pagehelper.PageInfo;

public interface IChatGroupInfoService {

	/**
	 * 获取聊天群信息
	 * @return
	 */
	List<ChatGroupInfo> getAllChatGroup();
	
	/**
	 * 创建群聊
	 * @param cgInfo
	 * @param userArray
	 * @return
	 */
	Integer createChatRoom(ChatGroupInfo cgInfo, Integer createId, List<Integer> userArray);
	
	/**
	 * 获取群组详细信息
	 * @param cgInfo
	 * @param userId
	 * @return
	 */
	ChatGroupListOut getChatGroupFullInfo(int userId);
	
	/**
	 * 获取群组详细信息
	 * @param cgInfo
	 * @param userId
	 * @return
	 */
	ChatGroupListOut getChatGroupFullInfoWithNameLike(int userId, String nameLike);
	
	/**
	 * 根据群组编号获取信息
	 * @return
	 */
	ChatGroupBaseOut getFullChatGroupInfoById(int id);
	
	/**
	 * 根据群组编号获取基础信息
	 * @return
	 */
	ChatGroupSimpleOut getSimpleChatGroupInfoById(int id);
	
	/**
	 * 根据项目编号获取群聊组基础信息
	 * @return
	 */
	List<ChatGroupBaseOut> getPrjChatGroupInfoByPrjId(int prjType, int prjId, int userId);
	
	/**
	 * 根据群聊组编号，删除群聊组及相关记录
	 * @param id
	 * @return
	 */
	int deleteChatGroupById(int id);
	
	/**
	 * 修改群聊组名称
	 * @param id
	 * @param name
	 * @return
	 */
	int updateCgName(int id, String name);
	
	/**
	 * 
	* @Title: getChatGroupInfoOutsByPage 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pageNum
	* @param @param pageSize
	* @param @param keyword
	* @param @return  参数说明 
	* @return PageInfo<ChatGroupInfoRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月16日 上午11:01:19
	 */
	PageInfo<ChatGroupInfoRow> getChatGroupInfoOutsByPage(Integer pageNum, Integer pageSize, String keyword);

	/**
	 * 
	* @Title: getAllchatGroupInfoOptions 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<OptionsOut>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月16日 下午2:58:44
	 */
	List<OptionsOut> getAllchatGroupInfoOptions();

	/**
	 * 
	* @Title: findById 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param id
	* @param @return  参数说明 
	* @return ChatGroupInfo    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月30日 下午5:29:53
	 */
	ChatGroupInfo findById(Integer id);
	
	/**
	 * 
	* @Title: insert 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param chatGroupInfo
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月30日 下午5:30:04
	 */
	int insert(ChatGroupInfo chatGroupInfo);

	/**
	 * 
	* @Title: update 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param chatGroupInfo
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月30日 下午5:30:14
	 */
	int update(ChatGroupInfo chatGroupInfo);

}
