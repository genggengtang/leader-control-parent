package org.zxs.leader.control.dao.interf;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zxs.leader.control.dao.model.ChatGroupInfo;
import org.zxs.leader.control.dao.model.vo.output.ChatGroupBaseOut;
import org.zxs.leader.control.dao.model.vo.output.ChatGroupPrjOut;
import org.zxs.leader.control.dao.model.vo.output.ChatGroupSimpleOut;
import org.zxs.leader.control.dao.model.vo.output.OptionsOut;
import org.zxs.leader.control.dao.model.vo.output.rows.ChatGroupInfoRow;

import tk.mybatis.mapper.common.Mapper;

public interface IChatGroupInfoMapper extends Mapper<ChatGroupInfo> {
	/**
	 * 获取我的群聊组详情信息
	 * @param userId
	 * @return
	 */
	List<ChatGroupBaseOut> selectMyChatGroupInfo(@Param("userId")int userId, @Param("nameLike")String nameLike);
	
	/**
	 * 获取项目群聊组基本信息
	 * @param prjType
	 * @param prjId
	 * @param userId
	 * @return
	 */
	List<ChatGroupBaseOut> selectPrjChatGroupInfo(@Param("prjType")int prjType, @Param("prjId")int prjId, @Param("userId")int userId);
	
	/**
	 * 获取与用户相关市领导联系项目编号
	 * @param userId
	 * @return
	 */
	List<ChatGroupPrjOut> selectPrjList(@Param("userId")int userId, @Param("nameLike")String nameLike, @Param("prjType")Integer prjType);
	
	/**
	 * 根据ID获取群组详细信息
	 * @param id
	 * @return
	 */
	ChatGroupBaseOut selectFullChatGroupInfoById(int id);
	
	/**
	 * 根据ID获取群组基础信息
	 * @param id
	 * @return
	 */
	ChatGroupSimpleOut selectSimpleChatGroupInfoById(int id);
	
	/**
	 * 获取服务队群聊组详情信息
	 * @param userId
	 * @return
	 */
	List<ChatGroupBaseOut> selectLeaderChatGroupInfo(@Param("userId")int userId, @Param("nameLike")String nameLike);

	/**
	 * 
	* @Title: selectAllOuts 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<ChatGroupInfoRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月16日 上午11:02:50
	 */
	List<ChatGroupInfoRow> selectAllOuts();

	/**
	 * 
	* @Title: selectAllchatGroupInfoOptions 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<OptionsOut>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月16日 下午2:59:41
	 */
	List<OptionsOut> selectAllchatGroupInfoOptions();

	/**
	 * 
	* @Title: selectRowsByKeyword 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param keyword
	* @param @return  参数说明 
	* @return List<ChatGroupInfoRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月27日 上午8:20:29
	 */
	List<ChatGroupInfoRow> selectRowsByKeyword(String keyword);

}