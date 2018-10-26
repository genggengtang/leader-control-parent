package org.zxs.leader.control.service.interf;

import java.util.List;

import org.zxs.leader.control.dao.model.MeetingNote;
import org.zxs.leader.control.dao.model.vo.output.MyMeetingNoteOut;
import org.zxs.leader.control.dao.model.vo.output.OptionsOut;
import org.zxs.leader.control.dao.model.vo.output.rows.MeetingNoteRow;
import org.zxs.leader.control.dao.model.vo.query.MeetingNoteQuery;

import com.github.pagehelper.PageInfo;

public interface IMeetingNoteService {

	/**
	 * 查询会议纪要分页列表
	 * @param query
	 * @return
	 */
	PageInfo<MyMeetingNoteOut> getMeetingNoteByPage(int pageNum, int pageSize, MeetingNoteQuery query);

	/**
	 * 会议纪要是否存在
	 * @param id
	 * @return
	 */
	boolean isMeetingNoteExist(Integer id);
	
	/**
	 * 根据项目编号及项目类型，获取相关附件信息
	 * @param prjId
	 * @param prjType
	 * @return
	 */
	List<MeetingNote> getPrjAttachments(int prjId, int prjType);
	
	/**
	 * 根据项目编号、类型及用户，获取相关附件信息
	 * @param prjId
	 * @param prjType
	 * @return
	 */
	List<MyMeetingNoteOut> getPrjAttachments(int prjId, int prjType, int userId);
	
	/**
	 * 
	* @Title: getMeetingNoteOutsByPage 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pageNum
	* @param @param pageSize
	* @param @param keyword
	* @param @return  参数说明 
	* @return PageInfo<MeetingNoteRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月16日 下午6:07:01
	 */
	PageInfo<MeetingNoteRow> getMeetingNoteOutsByPage(Integer pageNum, Integer pageSize, String keyword);
	
	/**
	 * 
	* @Title: getAllMeetingNoteOptions 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<OptionsOut>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月16日 下午6:51:18
	 */
	List<OptionsOut> getAllMeetingNoteOptions();

	/**
	 * 
	* @Title: findById 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param id
	* @param @return  参数说明 
	* @return MeetingNote    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月1日 上午8:52:12
	 */
	MeetingNote findById(Integer id);
	
	/**
	 * 
	* @Title: insert 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param meetingNote
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月1日 上午8:52:20
	 */
	int insert(MeetingNote meetingNote);
	
	/**
	 * 
	* @Title: update 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param meetingNote
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月1日 上午8:52:29
	 */
	int update(MeetingNote meetingNote);
	
	/**
	 * 
	* @Title: insertWithResult 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param record
	* @param @return  参数说明 
	* @return String    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月9日 上午11:45:21
	 */
	String insertWithResult(MeetingNote record);
}
