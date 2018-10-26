package org.zxs.leader.control.admin.controller.tables;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zxs.base.model.DataTablesBean;
import org.zxs.leader.control.dao.model.DictHeader;
import org.zxs.leader.control.dao.model.vo.output.EditOptionsOut;
import org.zxs.leader.control.dao.model.vo.output.OptionsOut;
import org.zxs.leader.control.dao.model.vo.output.rows.UserIssueRow;
import org.zxs.leader.control.service.interf.IDicInfoService;
import org.zxs.leader.control.service.interf.IHeaderService;
import org.zxs.leader.control.service.interf.IOrgUserService;
import org.zxs.leader.control.service.interf.IUserIssueService;

import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;

@RequestMapping("/tables/user-issue/")
@RestController
@Api(tags="用户意见接口查询")
public class TableUserIssueController {
	
	private static final String tableName = "user_issue";
	
	@Resource
	private IUserIssueService userIssueService;
	
	@Resource
	private IOrgUserService orgUserService;
	
	@Resource
	private IHeaderService headerService;
	
	@Resource
	private IDicInfoService dicInfoService;

	/**
	 * 
	* @Title: getUserIssueTableRows 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pageNum
	* @param @param pageSize
	* @param @return  参数说明 
	* @return DataTablesBean<UserIssueVo>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月19日 下午4:05:01
	 */
	@RequestMapping(value = "rows", method = {RequestMethod.GET, RequestMethod.POST})
	public DataTablesBean<UserIssueRow> getUserIssueTableRows(
			@RequestParam(required=false,value="pageNum", defaultValue="1") Integer pageNum,
			@RequestParam(required=false,value="pageSize", defaultValue="10") Integer pageSize,
			@RequestParam(required = false, value = "keyword") String keyword) {
		PageInfo<UserIssueRow> pageInfo = this.userIssueService.getUserIssueOutsByPage(pageNum, pageSize, keyword);
		DataTablesBean<UserIssueRow> table = new DataTablesBean<>();
		table.setErrorCode(0);
		table.setData(pageInfo.getList());
		table.setRecordsTotal(pageInfo.getTotal());
		table.setRecordsFiltered(pageInfo.getTotal());
		return table;
	}
	
	/**
	 * 
	* @Title: getUserIssueTableCols 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<HashMap<String,Object>>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月19日 下午4:12:11
	 */
	@RequestMapping(value = "cols", method = {RequestMethod.GET, RequestMethod.POST})
	public List<HashMap<String, Object>> getUserIssueTableCols() {
		List<HashMap<String, Object>> headers = headerService.getHeadersByClassType(tableName, UserIssueRow.class);
		return headers;
	}
	
	/**
	 * 
	* @Title: getUserIssueTableOptions 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return EditOptionsOut    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月19日 下午4:12:53
	 */
	@RequestMapping(value = "edit-page", method = RequestMethod.GET)
	public EditOptionsOut getUserIssueTableOptions() {
		EditOptionsOut options = new EditOptionsOut();
		List<DictHeader> headers = this.headerService.getWebHeadersByTableName(tableName);
		if (!headers.isEmpty() || null != headers) {
			options.setHeaders(headers);
		}
		List<OptionsOut> userIdTrans = this.orgUserService.getAllUserIdOpts();
		if (!userIdTrans.isEmpty() || null != userIdTrans) {
			options.getOptions().put("userIdTrans", userIdTrans);
		}
		return options;
	}
	
}
