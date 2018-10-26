package org.zxs.leader.control.service.interf;

import java.util.List;

import org.zxs.leader.control.dao.model.ChatGroupMsg;
import org.zxs.leader.control.dao.model.MsgStatus;
import org.zxs.leader.control.dao.model.vo.output.ChatMsgOut;
import org.zxs.leader.control.dao.model.vo.output.UnreadMsgOut;

public interface IMsgStatusService {
	
	/**
	 * 根据用户、消息编号，更新消息已读状态、推送状态
	 * @param userId
	 * @param msgId
	 * @return
	 */
	int updateMsgReadStatus(int userId, long msgId);
	
	/**
	 * 根据用户、群聊组编号，更新消息已读状态
	 * @param userId
	 * @param cgId
	 * @return
	 */
	int updateMsgReadStatusByUserIdAndCgId(int userId, long cgId);
	
	/**
	 * 查询用户未读消息总数，不包括系统消息
	 * @param userId
	 * @return
	 */
	int getTotalUnreadMsgCnt(int userId);
	
	/**
	 * 查询用户未读消息数，不包括系统消息
	 * @param userId
	 * @return
	 */
	UnreadMsgOut getUnreadMsgCnt(int userId);
	
	/**
	 * 按条件删除未读消息记录
	 * @param msgStatus
	 * @return
	 */
	int delete(MsgStatus msgStatus);

	/**
	 * 获取未推送系统消息列表，按时间降序排列
	 * @param userId
	 * @return
	 */
	List<String> getUnpushSysMsg(int userId);

	/**
	 * 获取未推送聊天消息数
	 * @param userId
	 * @return
	 */
	int getUnpushChatCnt(int userId);

	/**
	 * 更新所有推送消息的状态为已推送，包括系统通知、聊天消息、随手拍
	 * @param userId
	 */
	int updateAllPushStatus(int userId);
}
