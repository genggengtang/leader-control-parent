package org.zxs.leader.control.dao.interf;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zxs.leader.control.dao.model.ChatGroupMsg;
import org.zxs.leader.control.dao.model.vo.output.ChatMsgOut;
import org.zxs.leader.control.dao.model.vo.query.MsgHisQuery;

import tk.mybatis.mapper.common.Mapper;

public interface IChatGroupMsgMapper extends Mapper<ChatGroupMsg>{

	/**
	 * 查询最新的消息记录
	 * @param query
	 * @return
	 */
	List<ChatMsgOut> selectLatestMsgHis(@Param("query")MsgHisQuery query);
	
	/**
	 * 获取未推送系统消息
	 * @param userId
	 * @return
	 */
	List<String> selectUnpushSysMsg(@Param("userId")int userId);
}