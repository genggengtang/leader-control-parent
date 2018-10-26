package org.zxs.leader.control.dao.interf;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zxs.leader.control.dao.model.MsgStatus;
import org.zxs.leader.control.dao.model.vo.output.ChatGroupSimpleOut;

import tk.mybatis.mapper.common.Mapper;

public interface IMsgStatusMapper extends Mapper<MsgStatus>{
	/**
	 * 根据消息编号、用户编号更新消息已读状态
	 * @param msgId
	 * @param userId
	 * @return
	 */
	int updateByMsgIdAndUserId(@Param("msgId")long msgId, @Param("userId")int userId);
	
	/**
	 * 根据聊天群编号、用户编号更新消息已读状态
	 * @param msgId
	 * @param userId
	 * @return
	 */
	int updateByCgIdAndUserId(@Param("cgId")long cgId, @Param("userId")int userId);
	
	/**
	 * 根据用户编号查询各个群聊组未读消息数,不包括系统消息
	 * @param userId
	 * @return
	 */
	List<ChatGroupSimpleOut> selectUnreadCount(@Param("userId")int userId);

}