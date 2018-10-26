package org.zxs.leader.control.admin.controller.tables;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zxs.base.model.CommonReturnBean;
import org.zxs.base.model.DataTablesBean;
import org.zxs.leader.control.controller.MeetingNoteController;
import org.zxs.leader.control.dao.model.DictHeader;
import org.zxs.leader.control.dao.model.MeetingNote;
import org.zxs.leader.control.dao.model.vo.output.EditOptionsOut;
import org.zxs.leader.control.dao.model.vo.output.OptionsOut;
import org.zxs.leader.control.dao.model.vo.output.rows.MeetingNoteRow;
import org.zxs.leader.control.service.interf.IDicInfoService;
import org.zxs.leader.control.service.interf.IHeaderService;
import org.zxs.leader.control.service.interf.IMeetingNoteFavoriteService;
import org.zxs.leader.control.service.interf.IMeetingNoteService;

import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;

@RequestMapping("/tables/meeting-note/")
@RestController
@Api(tags="管理后台 - 会议纪要表接口")
public class TableMeetingNoteController {
	
	private static final Log log = LogFactory.getLog(MeetingNoteController.class);
	
	private static final String tableName = "meeting_note";
	
	@Resource
	private IMeetingNoteService meetingNoteService;
	
	@Resource
	private IMeetingNoteFavoriteService meetingNoteFavoriteService;
	
	@Resource
	private IHeaderService headerService;
	
	@Resource
	private IDicInfoService dicInfoService;
	
	/**
	 * 
	* @Title: getMeetingNoteTableRows 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pageNum
	* @param @param pageSize
	* @param @return  参数说明 
	* @return DataTablesBean<MeetingNoteRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月16日 下午6:07:29
	 */
	@RequestMapping(value = "rows", method = {RequestMethod.GET, RequestMethod.POST})
	public DataTablesBean<MeetingNoteRow> getMeetingNoteTableRows(
			@RequestParam(required=false,value="pageNum", defaultValue="1") Integer pageNum, 
			@RequestParam(required=false,value="pageSize", defaultValue="10") Integer pageSize,
			@RequestParam(required=false, value="keyword") String keyword) {
		PageInfo<MeetingNoteRow> pageInfo = this.meetingNoteService.getMeetingNoteOutsByPage(pageNum, pageSize, keyword);
		DataTablesBean<MeetingNoteRow> table = new DataTablesBean<>();
		table.setErrorCode(0);
		table.setData(pageInfo.getList());
		table.setRecordsTotal(pageInfo.getTotal());
		table.setRecordsFiltered(pageInfo.getTotal());
		return table;
	}
	
	/**
	 * 
	* @Title: getMeetingNoteTableCols 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<HashMap<String,Object>>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月16日 下午6:21:07
	 */
	@RequestMapping(value = "cols", method = {RequestMethod.GET, RequestMethod.POST})
	public List<HashMap<String, Object>> getMeetingNoteTableCols() {
		List<HashMap<String, Object>> headers = headerService.getHeadersByClassType(tableName, MeetingNoteRow.class);
		return headers;
	}
	
	/**
	 * 
	* @Title: getMeetingNoteTableOptions 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return EditOptionsOut    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月16日 下午6:23:11
	 */
	@RequestMapping(value = "edit-page", method = RequestMethod.GET)
	public EditOptionsOut getMeetingNoteTableOptions() {
		EditOptionsOut options = new EditOptionsOut();
		List<DictHeader> headers = this.headerService.getWebHeadersByTableName(tableName);
		if (!headers.isEmpty() || null != headers) {
			options.setHeaders(headers);
		}
		List<OptionsOut> prjTypeTrans = this.dicInfoService.getOptionsByType(214); // prj_type
		if (!prjTypeTrans.isEmpty() || null != prjTypeTrans) {
			options.getOptions().put("prjTypeTrans", prjTypeTrans);
		}
		List<OptionsOut> typeTrans = this.dicInfoService.getOptionsByType(209); // type
		if (!typeTrans.isEmpty() || null != typeTrans) {
			options.getOptions().put("typeTrans", typeTrans);
		}
		return options;
	}
	
	/**
	 * 
	* @Title: meetingNoteTableUpdate 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param meetingNote
	* @param @return  参数说明 
	* @return CommonReturnBean<Integer>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月1日 上午8:53:23
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST, consumes = "application/json")
	public CommonReturnBean<Integer> meetingNoteTableUpdate(@RequestBody MeetingNote meetingNote) {
		CommonReturnBean<Integer> ret = new CommonReturnBean<>();
		if (null == meetingNote) {
			ret.setErrorCode(-1);
			ret.setErrorMsg("请求对象为空。");
			log.info("请求对象为空。");
			return ret;
		}
		boolean exist = null != this.meetingNoteService.findById(meetingNote.getId());
		// id不存在，新增记录
		if (!exist) {
			boolean inserted = this.meetingNoteService.insert(meetingNote) > 0 ? true : false;
			if (inserted) { // 新增成功
				ret.setErrorCode(0);
				ret.setErrorMsg(String.format("新增会议纪要成功！ID:%s", meetingNote.getId()));
				log.info(String.format("新增会议纪要成功！ID:%s", meetingNote.getId()));
				return ret;
			} else {
				ret.setErrorCode(-1);
				ret.setErrorMsg(String.format("新增会议纪要失败！ID:%s", meetingNote.getId()));
				log.info(String.format("新增会议纪要失败！ID:%s", meetingNote.getId()));
				return ret;
			}
		} else { // id存在，根据id更新记录
			boolean updated = this.meetingNoteService.update(meetingNote) > 0 ? true : false;
			if (updated) { // 更新成功
				ret.setErrorCode(0);
				ret.setErrorMsg(String.format("更新会议纪要成功！ID:%s", meetingNote.getId()));
				log.info(String.format("更新会议纪要成功！ID:%s", meetingNote.getId()));
				return ret;
			} else {
				ret.setErrorCode(-1);
				ret.setErrorMsg(String.format("更新会议纪要失败！ID:%s", meetingNote.getId()));
				log.info(String.format("更新会议纪要失败！ID:%s", meetingNote.getId()));
				return ret;
			}
		}
	}

}
