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
import org.zxs.leader.control.dao.model.DictHeader;
import org.zxs.leader.control.dao.model.PrjAttachment;
import org.zxs.leader.control.dao.model.vo.output.EditOptionsOut;
import org.zxs.leader.control.dao.model.vo.output.OptionsOut;
import org.zxs.leader.control.dao.model.vo.output.rows.PrjAttachmentRow;
import org.zxs.leader.control.service.interf.IDicInfoService;
import org.zxs.leader.control.service.interf.IHeaderService;
import org.zxs.leader.control.service.interf.IMeetingNoteService;
import org.zxs.leader.control.service.interf.IPrjAttachmentService;
import org.zxs.leader.control.service.interf.IPrjInfoService;

import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;

@RequestMapping("/tables/prj-attachment")
@RestController
@Api(tags="项目附件表")
public class TablePrjAttachmentController {
	
	private static final Log logger = LogFactory.getLog(TablePrjAttachmentController.class);
	
	private static final String tableName = "prj_attachment";
	
	@Resource
	private IPrjAttachmentService prjAttachmentService;
	
	@Resource
	private IPrjInfoService prjInfoService;
	
	@Resource
	private IMeetingNoteService meetingNoteService;
	
	@Resource
	private IHeaderService headerService;
	
	@Resource
	private IDicInfoService dicInfoService;

	/**
	 * 
	* @Title: getPrjAttachmentTableRows 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pageNum
	* @param @param pageSize
	* @param @return  参数说明 
	* @return DataTablesBean<PrjAttachmentRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月16日 下午6:45:08
	 */
	@RequestMapping(value = "rows", method = {RequestMethod.GET, RequestMethod.POST})
	public DataTablesBean<PrjAttachmentRow> getPrjAttachmentTableRows(
			@RequestParam(required=false,value="pageNum", defaultValue="1") Integer pageNum, 
			@RequestParam(required=false,value="pageSize", defaultValue="10") Integer pageSize,
			@RequestParam(required = false, value = "keyword") String keyword) {
		PageInfo<PrjAttachmentRow> pageInfo = this.prjAttachmentService.getPrjAttachmentOutsByPage(pageNum, pageSize, keyword);
		DataTablesBean<PrjAttachmentRow> table = new DataTablesBean<>();
		table.setErrorCode(0);
		table.setData(pageInfo.getList());
		table.setRecordsTotal(pageInfo.getTotal());
		table.setRecordsFiltered(pageInfo.getTotal());
		return table;
	}
	
	/**
	 * 
	* @Title: getPrjAttachmentTableCols 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<HashMap<String,Object>>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月16日 下午6:46:36
	 */
	@RequestMapping(value = "cols", method = {RequestMethod.GET, RequestMethod.POST})
	public List<HashMap<String, Object>> getPrjAttachmentTableCols() {
		List<HashMap<String, Object>> headers = headerService.getHeadersByClassType(tableName, PrjAttachmentRow.class);
		return headers;
	}
	
	/**
	 * 
	* @Title: getPrjAttachmentTableOptions 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return EditOptionsOut    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月16日 下午6:47:34
	 */
	@RequestMapping(value = "edit-page", method = RequestMethod.GET)
	public EditOptionsOut getPrjAttachmentTableOptions() {
		EditOptionsOut options = new EditOptionsOut();
		List<DictHeader> headers = this.headerService.getWebHeadersByTableName(tableName);
		if (!headers.isEmpty() || null != headers) {
			options.setHeaders(headers);
		}
		List<OptionsOut> prjTypeTrans = this.dicInfoService.getOptionsByType(214); // prj_type
		if (!prjTypeTrans.isEmpty() || null != prjTypeTrans) {
			options.getOptions().put("prjTypeTrans", prjTypeTrans);
		}
		List<OptionsOut> prjIdTrans = this.prjInfoService.getAllPrjInfoOptions();
		if (!prjIdTrans.isEmpty() || null != prjIdTrans) {
			options.getOptions().put("prjIdTrans", prjIdTrans);
		}
		List<OptionsOut> mnIdTrans = this.meetingNoteService.getAllMeetingNoteOptions();
		if (!mnIdTrans.isEmpty() || null != mnIdTrans) {
			options.getOptions().put("mnIdTrans", mnIdTrans);
		}
		return options;
	}
	
	/**
	 * 
	* @Title: prjAttachmentTableUpdate 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param prjAttachment
	* @param @return  参数说明 
	* @return CommonReturnBean<Integer>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月1日 上午9:13:54
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST, consumes = "application/json")
	public CommonReturnBean<Integer> prjAttachmentTableUpdate(@RequestBody PrjAttachment prjAttachment) {
		CommonReturnBean<Integer> ret = new CommonReturnBean<>();
		if (null == prjAttachment) {
			ret.setErrorCode(-1);
			ret.setErrorMsg("请求对象为空。");
			logger.info("请求对象为空。");
			return ret;
		}
		boolean exist = null != this.prjAttachmentService.findById(prjAttachment.getId());
		// id不存在，新增记录
		if (!exist) {
			boolean inserted = this.prjAttachmentService.insert(prjAttachment) > 0 ? true : false;
			if (inserted) { // 新增成功
				ret.setErrorCode(0);
				ret.setErrorMsg(String.format("新增项目附件成功！ID:%s", prjAttachment.getId()));
				logger.info(String.format("新增项目附件成功！ID:%s", prjAttachment.getId()));
				return ret;
			} else {
				ret.setErrorCode(-1);
				ret.setErrorMsg(String.format("新增项目附件失败！ID:%s", prjAttachment.getId()));
				logger.info(String.format("新增项目附件失败！ID:%s", prjAttachment.getId()));
				return ret;
			}
		} else { // id存在，根据id更新记录
			boolean updated = this.prjAttachmentService.update(prjAttachment) > 0 ? true : false;
			if (updated) { // 更新成功
				ret.setErrorCode(0);
				ret.setErrorMsg(String.format("更新项目附件成功！ID:%s", prjAttachment.getId()));
				logger.info(String.format("更新项目附件成功！ID:%s", prjAttachment.getId()));
				return ret;
			} else {
				ret.setErrorCode(-1);
				ret.setErrorMsg(String.format("更新项目附件失败！ID:%s", prjAttachment.getId()));
				logger.info(String.format("更新项目附件失败！ID:%s", prjAttachment.getId()));
				return ret;
			}
		}
	}
	
}
