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
import org.zxs.leader.control.dao.consts.IDicInfoConst;
import org.zxs.leader.control.dao.model.DictHeader;
import org.zxs.leader.control.dao.model.PrjIssue;
import org.zxs.leader.control.dao.model.vo.output.EditOptionsOut;
import org.zxs.leader.control.dao.model.vo.output.OptionsOut;
import org.zxs.leader.control.dao.model.vo.output.rows.PrjIssueRow;
import org.zxs.leader.control.service.interf.IDicInfoService;
import org.zxs.leader.control.service.interf.IHeaderService;
import org.zxs.leader.control.service.interf.IMeetingNoteService;
import org.zxs.leader.control.service.interf.IPrjInfoService;
import org.zxs.leader.control.service.interf.IPrjIssueService;

import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;

@RequestMapping("/tables/prj-issue/")
@RestController
@Api(tags="项目问题表")
public class TablePrjIssueController {
	
	private static final Log logger = LogFactory.getLog(TablePrjIssueController.class);
	
	private static final String tableName = "prj_issue";
	
	@Resource
	private IHeaderService headerService;
	
	@Resource
	private IDicInfoService dicInfoService;
	
	@Resource
	private IPrjInfoService prjInfoService;
	
	@Resource
	private IPrjIssueService prjIssueService;
	
	@Resource
	private IMeetingNoteService meetingNoteService;
	
	@Resource
	private IPrjIssueService issueService;

	/**
	 * 
	* @Title: getPrjIssueTableRows 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pageNum
	* @param @param pageSize
	* @param @return  参数说明 
	* @return DataTablesBean<PrjIssueRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月18日 上午11:11:12
	 */
	@RequestMapping(value = "rows", method = {RequestMethod.GET, RequestMethod.POST})
	public DataTablesBean<PrjIssueRow> getPrjIssueTableRows(
			@RequestParam(required=false,value="pageNum", defaultValue="1") Integer pageNum, 
			@RequestParam(required=false,value="pageSize", defaultValue="10") Integer pageSize,
			@RequestParam(required = false, value = "keyword") String keyword) {
		PageInfo<PrjIssueRow> pageInfo = this.prjIssueService.getPrjIssueOutsByPage(pageNum, pageSize, keyword);
		DataTablesBean<PrjIssueRow> table = new DataTablesBean<>();
		table.setErrorCode(0);
		table.setData(pageInfo.getList());
		table.setRecordsTotal(pageInfo.getTotal());
		table.setRecordsFiltered(pageInfo.getTotal());
		return table;
	}
	
	/**
	 * 
	* @Title: getPrjIssueTableCols 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<HashMap<String,Object>>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月18日 下午4:33:00
	 */
	@RequestMapping(value = "cols", method = {RequestMethod.GET, RequestMethod.POST})
	public List<HashMap<String, Object>> getPrjIssueTableCols() {
		List<HashMap<String, Object>> headers = headerService.getHeadersByClassType(tableName, PrjIssueRow.class);
		return headers;
	}
	
	/**
	 * 
	* @Title: getPrjIssueTableOptions 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return EditOptionsOut    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月18日 下午5:30:56
	 */
	@RequestMapping(value = "edit-page", method = RequestMethod.GET)
	public EditOptionsOut getPrjIssueTableOptions() {
		EditOptionsOut options = new EditOptionsOut();
		List<DictHeader> headers = this.headerService.getWebHeadersByTableName(tableName);
		if (!headers.isEmpty() || null != headers) {
			options.setHeaders(headers);
		}
		List<OptionsOut> prjTypeTrans = this.dicInfoService.getOptionsByType(IDicInfoConst.TYPE_PRJ_TYPE);
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
		List<OptionsOut> type = this.dicInfoService.getOptionsByType(IDicInfoConst.TYPE_QUESTION_TYPE);
		if (!type.isEmpty() || null != type) {
			options.getOptions().put("typeTrans", type);
		}
		return options;
	}
	
	/**
	 * 
	* @Title: prjIssueTableUpdate 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param prjIssue
	* @param @return  参数说明 
	* @return CommonReturnBean<Integer>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月1日 上午9:34:54
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST, consumes = "application/json")
	public CommonReturnBean<Integer> prjIssueTableUpdate(@RequestBody PrjIssue prjIssue) {
		CommonReturnBean<Integer> ret = new CommonReturnBean<>();
		if (null == prjIssue) {
			ret.setErrorCode(-1);
			ret.setErrorMsg("请求对象为空。");
			logger.info("请求对象为空。");
			return ret;
		}
		boolean exist = null != this.prjIssueService.findById(prjIssue.getId());
		// id不存在，新增记录
		if (!exist) {
			boolean inserted = this.prjIssueService.insert(prjIssue) > 0 ? true : false;
			if (inserted) { // 新增成功
				ret.setErrorCode(0);
				ret.setErrorMsg(String.format("新增项目沟通表成功！ID:%s", prjIssue.getId()));
				logger.info(String.format("新增项目沟通表成功！ID:%s", prjIssue.getId()));
				return ret;
			} else {
				ret.setErrorCode(-1);
				ret.setErrorMsg(String.format("新增项目沟通表失败！ID:%s", prjIssue.getId()));
				logger.info(String.format("新增项目沟通表失败！ID:%s", prjIssue.getId()));
				return ret;
			}
		} else { // id存在，根据id更新记录
			boolean updated = this.prjIssueService.update(prjIssue) > 0 ? true : false;
			if (updated) { // 更新成功
				ret.setErrorCode(0);
				ret.setErrorMsg(String.format("更新项目沟通表成功！ID:%s", prjIssue.getId()));
				logger.info(String.format("更新项目沟通表成功！ID:%s", prjIssue.getId()));
				return ret;
			} else {
				ret.setErrorCode(-1);
				ret.setErrorMsg(String.format("更新项目沟通表失败！ID:%s", prjIssue.getId()));
				logger.info(String.format("更新项目沟通表失败！ID:%s", prjIssue.getId()));
				return ret;
			}
		}
	}
	
}
