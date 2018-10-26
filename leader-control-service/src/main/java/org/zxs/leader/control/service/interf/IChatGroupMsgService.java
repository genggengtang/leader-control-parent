package org.zxs.leader.control.service.interf;

import java.io.IOException;
import java.util.List;

import org.zxs.leader.control.dao.model.vo.output.ChatMsgOut;
import org.zxs.leader.control.dao.model.vo.query.MsgHisQuery;

import com.qiniu.common.QiniuException;

public interface IChatGroupMsgService {
	
	/**
	 * 保存聊天记录，返回消息编号
	 * @param data
	 * @param chatRoom
	 * @return
	 * @throws IOException 
	 * @throws QiniuException 
	 */
	ChatMsgOut saveChatMsg(ChatMsgOut data, Integer chatRoom) throws QiniuException, IOException;
	
	/**
	 * 获取最新的聊天记录
	 * @return
	 */
	List<ChatMsgOut> getLatestMsgHisById(MsgHisQuery query);

	/**
	 * 保存系统通知消息
	 * @param sysMsg
	 */
	int saveSYSMsg(String sysMsg);
}
