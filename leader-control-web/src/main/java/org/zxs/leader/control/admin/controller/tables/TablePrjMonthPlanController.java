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
import org.zxs.leader.control.dao.model.PrjMonthPlan;
import org.zxs.leader.control.dao.model.vo.output.EditOptionsOut;
import org.zxs.leader.control.dao.model.vo.output.OptionsOut;
import org.zxs.leader.control.dao.model.vo.output.rows.PrjMonthPlanRow;
import org.zxs.leader.control.service.interf.IHeaderService;
import org.zxs.leader.control.service.interf.IPrjMonthPlanService;

import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/tables/prj-month-plan")
@Api(tags="项目月度计划表")
public class TablePrjMonthPlanController {
	
	private static final Log logger = LogFactory.getLog(TablePrjMonthPlanController.class);
	
	private final String tableName = "prj_month_plan";
	
	@Resource
	private IHeaderService headerService;
	
	@Resource
	private IPrjMonthPlanService prjMonthPlanService;
	
	/**
	 * 
	* @Title: getPrjMonthPlanTableRows 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pageNum
	* @param @param pageSize
	* @param @param keyword
	* @param @return  参数说明 
	* @return DataTablesBean<PrjMonthPlanRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月12日 上午8:18:30
	 */
	@RequestMapping(value = "rows", method = {RequestMethod.GET, RequestMethod.POST})
	public DataTablesBean<PrjMonthPlanRow> getPrjMonthPlanTableRows(
			@RequestParam(required=false,value="pageNum", defaultValue="1") Integer pageNum, 
			@RequestParam(required=false,value="pageSize", defaultValue="10") Integer pageSize,
			@RequestParam(required=false, value="keyword") String keyword) {
		PageInfo<PrjMonthPlanRow> pageInfo = prjMonthPlanService.getPrjMonthPlanOutsByPage(pageNum, pageSize, keyword);
		DataTablesBean<PrjMonthPlanRow> table = new DataTablesBean<>();
		table.setErrorCode(0);
		table.setData(pageInfo.getList());
		table.setRecordsTotal(pageInfo.getTotal());
		table.setRecordsFiltered(pageInfo.getTotal());
		return table;
	}
	
	/**
	 * 
	* @Title: getPrjMonthPlanTableCols 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<HashMap<String,Object>>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月12日 上午8:18:37
	 */
	@RequestMapping(value = "cols", method = {RequestMethod.GET, RequestMethod.POST})
	public List<HashMap<String, Object>> getPrjMonthPlanTableCols() {
		List<HashMap<String, Object>> headers = headerService.getHeadersByClassType(tableName, PrjMonthPlanRow.class);
		return headers;
	}
	
	/**
	 * 
	* @Title: getPrjMonthPlanTableOptions 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return EditOptionsOut    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月16日 上午8:26:12
	 */
	@RequestMapping(value = "edit-page", method = RequestMethod.GET)
	public EditOptionsOut getPrjMonthPlanTableOptions() {
		EditOptionsOut options = new EditOptionsOut();
		List<DictHeader> headers = this.headerService.getWebHeadersByTableName(tableName);
		if (!headers.isEmpty() || null != headers) {
			options.setHeaders(headers);
		}
		List<OptionsOut> yearIdTrans = this.prjMonthPlanService.getYearIdOptions(); // year_id
		if (!yearIdTrans.isEmpty() || null != yearIdTrans) {
			options.getOptions().put("yearIdTrans", yearIdTrans);
		}
		return options;
	}
	
	/**
	 * 
	* @Title: prjMonthPlanUpdate 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param prjYearPlan
	* @param @return  参数说明 
	* @return CommonReturnBean<Integer>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月20日 下午4:11:18
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST, consumes = "application/json")
	public CommonReturnBean<Integer> prjMonthPlanUpdate(@RequestBody PrjMonthPlan prjMonthPlan) {
		CommonReturnBean<Integer> ret = new CommonReturnBean<>();
		String errorMsg = "";
		if (null == prjMonthPlan) {
			errorMsg = "表单提交失败，表单对象为空。";
			ret.setErrorCode(-2);
			ret.setErrorMsg(errorMsg);
			logger.info(errorMsg);
		}
		
		// check if record exist
		boolean exist = null != this.prjMonthPlanService.findById(prjMonthPlan.getId());
		
		// not exist
		if (!exist) {
			int res = this.prjMonthPlanService.insert(prjMonthPlan);
			if (res > 0) {
				errorMsg = String.format("记录新增成功！ID[%s] - Title[%s]", prjMonthPlan.getId(), prjMonthPlan.getTitle());
				ret.setErrorCode(0);
				ret.setErrorMsg(errorMsg);
				logger.info(errorMsg);
				return ret;
			} else {
				errorMsg = String.format("记录新增失败！ID[%s] - Title[%s]", prjMonthPlan.getId(), prjMonthPlan.getTitle());
				ret.setErrorCode(-1);
				ret.setErrorMsg(errorMsg);
				logger.info(errorMsg);
				return ret;
			}
		}
		
		// already exist
		int res = this.prjMonthPlanService.update(prjMonthPlan);
		if (res > 0) {
			errorMsg = String.format("记录更新成功！ID[%s] - Title[%s]", prjMonthPlan.getId(), prjMonthPlan.getTitle());
			ret.setErrorCode(0);
			ret.setErrorMsg(errorMsg);
			logger.info(errorMsg);
			return ret;
		} else {
			errorMsg = String.format("记录更新失败！ID[%s] - Title[%s]", prjMonthPlan.getId(), prjMonthPlan.getTitle());
			ret.setErrorCode(-1);
			ret.setErrorMsg(errorMsg);
			logger.info(errorMsg);
			return ret;
		}
	}

}
