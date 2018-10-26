package org.zxs.leader.control.service.interf;

import org.zxs.leader.control.dao.model.vo.output.rows.TopicCommentRow;

import com.github.pagehelper.PageInfo;

public interface ITopicCommentService {

	/**
	 * 
	* @Title: getTopicCommentVosByPage 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pageNum
	* @param @param pageSize
	* @param @param keyword
	* @param @return  参数说明 
	* @return PageInfo<TopicCommentRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月19日 下午4:52:50
	 */
	PageInfo<TopicCommentRow> getTopicCommentVosByPage(Integer pageNum, Integer pageSize, String keyword);

}
