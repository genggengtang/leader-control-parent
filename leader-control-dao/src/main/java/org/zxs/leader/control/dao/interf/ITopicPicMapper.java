package org.zxs.leader.control.dao.interf;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zxs.leader.control.dao.model.TopicPic;
import org.zxs.leader.control.dao.model.vo.output.TopicDetailOut;
import org.zxs.leader.control.dao.model.vo.output.TopicPicOut;
import org.zxs.leader.control.dao.model.vo.output.rows.TopicPicRow;

import tk.mybatis.mapper.common.Mapper;

public interface ITopicPicMapper extends Mapper<TopicPic> {

	/**
	 * 根据用户编号，获取相关主题信息
	 * @param userId
	 * @return
	 */
	List<TopicPicOut> selectTopicByUser(int userId);

	/**
	 * 根据主题编号和用户编号，获取主题详情信息
	 * @param id
	 * @param userId 
	 * @return
	 */
	TopicDetailOut selectDetailById(@Param("id")int id);

	/**
	 * 
	* @Title: selectAllOuts 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<TopicPicRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月19日 下午4:24:56
	 */
	List<TopicPicRow> selectAllOuts();

	/**
	 * 
	* @Title: selectRowsByKeyword 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param keyword
	* @param @return  参数说明 
	* @return List<TopicPicRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月23日 上午11:10:17
	 */
	List<TopicPicRow> selectRowsByKeyword(String keyword);
}