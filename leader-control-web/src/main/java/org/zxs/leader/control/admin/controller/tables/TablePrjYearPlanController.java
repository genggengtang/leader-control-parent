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
import org.zxs.leader.control.dao.interf.IPrjYearPlanMapper;
import org.zxs.leader.control.dao.model.DictHeader;
import org.zxs.leader.control.dao.model.PrjYearPlan;
import org.zxs.leader.control.dao.model.vo.output.EditOptionsOut;
import org.zxs.leader.control.dao.model.vo.output.OptionsOut;
import org.zxs.leader.control.dao.model.vo.output.rows.PrjYearPlanRow;
import org.zxs.leader.control.service.interf.IDicInfoService;
import org.zxs.leader.control.service.interf.IHeaderService;
import org.zxs.leader.control.service.interf.IPrjYearPlanService;

import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;

@RequestMapping("/tables/prj-year-plan")
@RestController
@Api(tags="年度项目计划表")
public class TablePrjYearPlanController {
	
	private static final Log logger = LogFactory.getLog(TablePrjYearPlanController.class);
	
	private final String tableName = "prj_year_plan";
	
	@Resource
	private IPrjYearPlanService prjYearPlanService;
	
	@Resource
	private IHeaderService headerService;
	
	@Resource
	private IDicInfoService dicInfoService;
	
	@Resource
	private IPrjYearPlanMapper prjYearPlanMapper;
	
	/**
	 * 
	* @Title: getOrgUnitByPage 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pageNum
	* @param @param pageSize
	* @param @return  参数说明 
	* @return DataTablesBean<PrjYearPlanRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月13日 下午3:12:40
	 */
	@RequestMapping(value = "rows", method = {RequestMethod.GET, RequestMethod.POST})
	public DataTablesBean<PrjYearPlanRow> getOrgUnitByPage(
			@RequestParam(required=false,value="pageNum", defaultValue="1") Integer pageNum, 
			@RequestParam(required=false,value="pageSize", defaultValue="10") Integer pageSize,
			@RequestParam(required = false, value = "keyword") String keyword) {
		PageInfo<PrjYearPlanRow> pageInfo = prjYearPlanService.getPrjYearPlanRowsByPageAndKeyword(pageNum, pageSize, keyword);
		DataTablesBean<PrjYearPlanRow> table = new DataTablesBean<>();
		table.setErrorCode(0);
		table.setData(pageInfo.getList());
		table.setRecordsTotal(pageInfo.getTotal());
		table.setRecordsFiltered(pageInfo.getTotal());
		return table;
	}
	
	/**
	 * 
	* @Title: getOrgUnitTableHeader 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<HashMap<String,Object>>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月13日 下午3:12:37
	 */
	@RequestMapping(value = "cols", method = {RequestMethod.GET, RequestMethod.POST})
	public List<HashMap<String, Object>> getOrgUnitTableHeader() {
		List<HashMap<String, Object>> headers = headerService.getHeadersByClassType(tableName, PrjYearPlanRow.class);
		return headers;
	}
	
	/**
	 * 
	* @Title: getPrjYearPlanTableOptions 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return EditOptionsOut    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月13日 下午3:15:21
	 */
	@RequestMapping(value = "edit-page", method = RequestMethod.GET)
	public EditOptionsOut getPrjYearPlanTableOptions() {
		EditOptionsOut options = new EditOptionsOut();
		List<DictHeader> headers = this.headerService.getWebHeadersByTableName(tableName);
		if (!headers.isEmpty() || null != headers) {
			options.setHeaders(headers);
		}
		List<OptionsOut> sourceNoTrans = this.dicInfoService.getOptionsByType(214);
		if (!sourceNoTrans.isEmpty() || null != sourceNoTrans) {
			options.getOptions().put("prjTypeTrans", sourceNoTrans);
		}
		return options;
	}
	
	/**
	 * 
	* @Title: prjYearPlanUpdate 
	* @Description: 创建新的记录或更新旧的记录
	* @param @param orgUser
	* @param @return  参数说明 
	* @return CommonReturnBean<Integer>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月20日 上午10:24:43
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST, consumes = "application/json")
	public CommonReturnBean<Integer> prjYearPlanUpdate(@RequestBody PrjYearPlan prjYearPlan) {
		CommonReturnBean<Integer> ret = new CommonReturnBean<>();
		String errorMsg = "";
		if (null == prjYearPlan) {
			errorMsg = "表单提交失败，表单对象为空。";
			ret.setErrorCode(-2);
			ret.setErrorMsg(errorMsg);
			logger.info(errorMsg);
		}
		
		// check if record exist
		boolean exist = null != this.prjYearPlanService.findById(prjYearPlan.getId());
		
		// not exist
		if (!exist) {
			int res = this.prjYearPlanService.insert(prjYearPlan);
			if (res > 0) {
				errorMsg = String.format("新记录添加成功。ID[%s] - PlanContent[%s]", prjYearPlan.getId(), prjYearPlan.getPlanContent());
				ret.setErrorCode(0);
				ret.setErrorMsg(errorMsg);
				logger.info(errorMsg);
				return ret;
			} else {
				errorMsg = String.format("记录新增失败！ID[%s] - PlanContent[%s]", prjYearPlan.getId(), prjYearPlan.getPlanContent());
				ret.setErrorCode(-1);
				ret.setErrorMsg(errorMsg);
				logger.info(errorMsg);
				return ret;
			}
		}
		
		// already exist
		int res = this.prjYearPlanService.update(prjYearPlan);
		if (res > 0) {
			errorMsg = String.format("记录更新成功！ID[%s] - PlanContent[%s]", prjYearPlan.getId(), prjYearPlan.getPlanContent());
			ret.setErrorCode(0);
			ret.setErrorMsg(errorMsg);
			logger.info(errorMsg);
			return ret;
		} else {
			errorMsg = String.format("记录更新失败！ID[%s]", prjYearPlan.getId());
			ret.setErrorCode(-1);
			ret.setErrorMsg(errorMsg);
			logger.info(errorMsg);
			return ret;
		}
	}

}
