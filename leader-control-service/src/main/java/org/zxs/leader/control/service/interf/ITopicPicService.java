package org.zxs.leader.control.service.interf;

import java.util.List;

import org.zxs.base.model.BussinessException;
import org.zxs.leader.control.dao.model.TopicPic;
import org.zxs.leader.control.dao.model.vo.output.TopicDetailOut;
import org.zxs.leader.control.dao.model.vo.output.TopicPicOut;
import org.zxs.leader.control.dao.model.vo.output.rows.TopicPicRow;

import com.github.pagehelper.PageInfo;

public interface ITopicPicService {
	
	/**
	 * 保存随手拍主题，同时添加主题未读消息记录
	 * @param topicPic
	 * @return
	 */
	int saveTopicPic(TopicPic topicPic, List<Integer> userList) throws BussinessException;

	/**
	 * 获取与用户相关的主题分页列表，即自己发出的，或者主题接收的对象中包括自己的
	 * @param pageNum
	 * @param pageSize
	 * @param userId
	 * @return
	 */
	PageInfo<TopicPicOut> getMyTopicByPage(Integer pageNum, Integer pageSize, int userId);

	/**
	 * 获取主题详情
	 * @param id
	 * @return
	 */
	TopicDetailOut getTopicDetail(int id);
	
	/**
	 * 发送评论
	 * @param topicId 随手拍主题编号
	 * @param userId 评论用户
	 * @param comment 评论内容
	 * 
	 * @return
	 */
	int sendComment(int topicId, int userId, String comment);
	
	/**
	 * 根据编号获取主题基本信息
	 * @param id
	 * @return
	 */
	TopicPic getBaseTopic(int id);

	/**
	 * 软删除随手拍主题
	 * @param tp
	 * @return 
	 */
	int deleteTopic(TopicPic tp);
	
	/**
	 * 
	* @Title: getTopicPicOutsByPage 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pageNum
	* @param @param pageSize
	* @param @param keyword
	* @param @return  参数说明 
	* @return PageInfo<TopicPicRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月19日 下午4:23:43
	 */
	PageInfo<TopicPicRow> getTopicPicOutsByPage(Integer pageNum, Integer pageSize, String keyword);
	
}
