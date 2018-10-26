package org.zxs.leader.control.dao.interf;

import java.util.List;

import org.zxs.leader.control.dao.model.TopicComment;
import org.zxs.leader.control.dao.model.vo.output.TopicCommentOut;
import org.zxs.leader.control.dao.model.vo.output.rows.TopicCommentRow;

import tk.mybatis.mapper.common.Mapper;

public interface ITopicCommentMapper extends Mapper<TopicComment> {

	/**
	 * 根据主题获取相关评论列表
	 * @param topicId
	 * @return
	 */
	List<TopicCommentOut> selectByTopic(int topicId);

	/**
	 * 
	* @Title: selectAllOuts 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<TopicCommentRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月19日 下午4:54:24
	 */
	List<TopicCommentRow> selectAllOuts();

	/**
	 * 
	* @Title: selectRowsByKeyword 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param keyword
	* @param @return  参数说明 
	* @return List<TopicCommentRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月27日 下午3:35:33
	 */
	List<TopicCommentRow> selectRowsByKeyword(String keyword);
	
}