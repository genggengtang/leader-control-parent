package org.zxs.leader.control.dao.interf;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zxs.leader.control.dao.model.MeetingNote;
import org.zxs.leader.control.dao.model.vo.output.MyMeetingNoteOut;
import org.zxs.leader.control.dao.model.vo.output.OptionsOut;
import org.zxs.leader.control.dao.model.vo.output.rows.MeetingNoteRow;
import org.zxs.leader.control.dao.model.vo.query.MeetingNoteQuery;

import tk.mybatis.mapper.common.Mapper;

public interface IMeetingNoteMapper extends Mapper<MeetingNote> {
	
	/**
	 * 查询我的会议纪要分页列表
	 * @param query
	 * @return
	 */
	List<MyMeetingNoteOut> selectMyMeetingNote(@Param("query")MeetingNoteQuery query);

	/**
	 * 
	* @Title: selectAllOuts 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<MeetingNoteRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月16日 下午6:08:53
	 */
	List<MeetingNoteRow> selectAllOuts();

	/**
	 * 
	* @Title: selectAllMeetingNoteOptions 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<OptionsOut>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月16日 下午6:52:18
	 */
	List<OptionsOut> selectAllMeetingNoteOptions();

	/**
	 * 
	* @Title: selectRowsByKeyword 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param keyword
	* @param @return  参数说明 
	* @return List<MeetingNoteRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月23日 上午11:31:39
	 */
	List<MeetingNoteRow> selectRowsByKeyword(String keyword);

}