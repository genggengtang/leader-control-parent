package org.zxs.leader.control.dao.interf;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zxs.leader.control.dao.model.MeetingNote;
import org.zxs.leader.control.dao.model.PrjAttachment;
import org.zxs.leader.control.dao.model.vo.output.MyMeetingNoteOut;
import org.zxs.leader.control.dao.model.vo.output.rows.PrjAttachmentRow;

import tk.mybatis.mapper.common.Mapper;

public interface IPrjAttachmentMapper extends Mapper<PrjAttachment> {
	
	/**
	 * 根据项目编号及用户编号获取项目所有相关文件
	 * @param prjId
	 * @param userId
	 * @return
	 */
	List<MyMeetingNoteOut> selectByPrjAndUser(@Param("prjId")int prjId, @Param("prjType")int prjType, @Param("userId")int userId);

	/**
	 * 根据项目类型及编号，获取附件信息
	 * @param prjId
	 * @param prjType
	 * @return
	 */
	List<MeetingNote> selectByPrjAndType(@Param("prjId")int prjId, @Param("prjType")int prjType);

	/**
	 * 
	* @Title: selectAllOuts 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<PrjAttachmentRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月16日 下午6:38:39
	 */
	List<PrjAttachmentRow> selectAllOuts();

	/**
	 * 
	* @Title: selectRowsByKeyword 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param keyword
	* @param @return  参数说明 
	* @return List<PrjAttachmentRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月23日 上午8:21:47
	 */
	List<PrjAttachmentRow> selectRowsByKeyword(String keyword);
	
}