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
import org.zxs.leader.control.admin.annotation.AuthGroup;
import org.zxs.leader.control.dao.model.CbPlanPrj;
import org.zxs.leader.control.dao.model.DictHeader;
import org.zxs.leader.control.dao.model.vo.output.EditOptionsOut;
import org.zxs.leader.control.dao.model.vo.output.OptionsOut;
import org.zxs.leader.control.dao.model.vo.output.rows.CbPlanPrjRow;
import org.zxs.leader.control.service.interf.ICbPlanPrjService;
import org.zxs.leader.control.service.interf.IDicInfoService;
import org.zxs.leader.control.service.interf.IHeaderService;
import org.zxs.leader.control.service.interf.IOrgUserService;

import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;

@RequestMapping("/tables/cb-plan-prj/")
@RestController
@Api(tags="城建计划项目查询")
public class TableCbPlanPrjController {
	
	private static final Log logger = LogFactory.getLog(TableCbPlanPrjController.class);
	
	private static final String tableName = "cb_plan_prj";
	
	@Resource
	private ICbPlanPrjService cbPlanPrjService;
	
	@Resource
	private IHeaderService headerService;
	
	@Resource
	private IDicInfoService dicInfoService;
	
	@Resource
	private IOrgUserService orgUserService;
	
	/**
	 * 
	* @Title: getCbPlanPrjTableRows 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pageNum
	* @param @param pageSize
	* @param @return  参数说明 
	* @return DataTablesBean<CbPlanPrjRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月13日 下午5:57:42
	 */
	@AuthGroup(permits={"ADMIN","PROGRESS","DATA"})
	@RequestMapping(value = "rows", method = {RequestMethod.GET, RequestMethod.POST})
	public DataTablesBean<CbPlanPrjRow> getCbPlanPrjTableRows(
			@RequestParam(required=false,value="pageNum", defaultValue="1") Integer pageNum, 
			@RequestParam(required=false,value="pageSize", defaultValue="10") Integer pageSize,
			@RequestParam(required=false, value="keyword") String keyword) {
		PageInfo<CbPlanPrjRow> page = this.cbPlanPrjService.getCbPlanPrjOutsByPage(pageNum, pageSize, keyword);
		DataTablesBean<CbPlanPrjRow> table = new DataTablesBean<>();
		table.setErrorCode(0);
		table.setData(page.getList());
		table.setRecordsTotal(page.getTotal());
		table.setRecordsFiltered(page.getPageSize());
		return table;
	}
	
	/**
	 * 
	* @Title: getCbPlanPrjTableCols 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<HashMap<String,Object>>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月16日 上午9:05:00
	 */
	@RequestMapping(value = "cols", method = {RequestMethod.GET, RequestMethod.POST})
	public List<HashMap<String, Object>> getCbPlanPrjTableCols() {
		List<HashMap<String, Object>> headers = headerService.getHeadersByClassType(tableName, CbPlanPrjRow.class);
		return headers;
	}
	
	/**
	 * 
	* @Title: getCbPlanPrjTableOptions 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return EditOptionsOut    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月16日 上午10:02:01
	 */
	@RequestMapping(value = "edit-page", method = RequestMethod.GET)
	public EditOptionsOut getCbPlanPrjTableOptions() {
		EditOptionsOut options = new EditOptionsOut();
		List<DictHeader> headers = this.headerService.getWebHeadersByTableName(tableName);
		if (!headers.isEmpty() || null != headers) {
			options.setHeaders(headers);
		}
		List<OptionsOut> planNoTrans = this.dicInfoService.getOptionsByType(218);
		if (!planNoTrans.isEmpty() || null != planNoTrans) {
			options.getOptions().put("planNoTrans", planNoTrans);
		}
		List<OptionsOut> cbTypeTrans = this.dicInfoService.getOptionsByType(216); 
		if (!cbTypeTrans.isEmpty() || null != cbTypeTrans) {
			options.getOptions().put("cbTypeTrans", cbTypeTrans);
		}
		List<OptionsOut> labelTrans = this.dicInfoService.getOptionsByType(217);
		if (!labelTrans.isEmpty() || null != labelTrans) {
			options.getOptions().put("labelTrans", labelTrans);
		}
		List<OptionsOut> rspLeaderIdTrans = this.orgUserService.getAllUserIdOpts();
		if (!rspLeaderIdTrans.isEmpty() || null != rspLeaderIdTrans) {
			options.getOptions().put("rspLeaderIdTrans", rspLeaderIdTrans);
		}
		List<OptionsOut> cbFeatureTrans = this.dicInfoService.getOptionsByType(215);
		if (!cbFeatureTrans.isEmpty() || null != cbFeatureTrans) {
			options.getOptions().put("cbFeatureTrans", cbFeatureTrans);
		}
		// there're two types of city-built plans in dic_info table
		List<OptionsOut> extraCbTypeTrans = this.dicInfoService.getAllCityBuildTypeOptions();
		if (!extraCbTypeTrans.isEmpty() || null != extraCbTypeTrans) {
			options.getOptions().put("extraCbTypeTrans", extraCbTypeTrans);
		}
		return options;
	}
	
	/**
	 * 
	* @Title: cbPlanPrjTableUpdate 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param cbPlanPrj
	* @param @return  参数说明 
	* @return CommonReturnBean<Integer>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月27日 上午11:55:50
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST, consumes = "application/json")
	public CommonReturnBean<Integer> cbPlanPrjTableUpdate(@RequestBody CbPlanPrj cbPlanPrj) {
		CommonReturnBean<Integer> ret = new CommonReturnBean<>();
		if (null == cbPlanPrj) {
			ret.setErrorCode(-1);
			ret.setErrorMsg("请求对象为空。");
			logger.info("请求对象为空。");
			return ret;
		}
		boolean exist = null != this.cbPlanPrjService.findById(cbPlanPrj.getId());
		
		// id不存在，新增记录
		if (!exist) {
			boolean inserted = this.cbPlanPrjService.insert(cbPlanPrj) > 0 ? true : false;
			if (inserted) { // 新增成功
				ret.setErrorCode(0);
				ret.setErrorMsg(String.format("新增对象成功！ID:%s", cbPlanPrj.getId()));
				logger.info(String.format("新增对象成功！ID:%s", cbPlanPrj.getId()));
				return ret;
			} else {
				ret.setErrorCode(-1);
				ret.setErrorMsg(String.format("新增对象失败！ID:%s", cbPlanPrj.getId()));
				logger.info(String.format("新增对象失败！ID:%s", cbPlanPrj.getId()));
				return ret;
			}
		} else { // id存在，依据id更新记录
			boolean updated = this.cbPlanPrjService.update(cbPlanPrj) > 0 ? true : false;
			if (updated) { // 更新成功
				ret.setErrorCode(0);
				ret.setErrorMsg(String.format("更新对象成功！ID:%s", cbPlanPrj.getId()));
				logger.info(String.format("更新对象成功！ID:%s", cbPlanPrj.getId()));
				return ret;
			} else {
				ret.setErrorCode(-1);
				ret.setErrorMsg(String.format("更新对象失败！ID:%s", cbPlanPrj.getId()));
				logger.info(String.format("更新对象失败！ID:%s", cbPlanPrj.getId()));
				return ret;
			}
		}
	}

}
