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
import org.zxs.leader.control.dao.model.CbInvestSource;
import org.zxs.leader.control.dao.model.DictHeader;
import org.zxs.leader.control.dao.model.vo.output.EditOptionsOut;
import org.zxs.leader.control.dao.model.vo.output.OptionsOut;
import org.zxs.leader.control.dao.model.vo.output.rows.CbInvestSourceRow;
import org.zxs.leader.control.service.interf.ICbInvestSourceService;
import org.zxs.leader.control.service.interf.ICbPlanPrjService;
import org.zxs.leader.control.service.interf.IDicInfoService;
import org.zxs.leader.control.service.interf.IHeaderService;

import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;

@RequestMapping("/tables/cb-invest-source/")
@RestController
@Api(tags="项目计划资金来源表")
public class TableCbInvestSourceController {
	
	private static final Log logger = LogFactory.getLog(TableCbInvestSourceController.class);
	
	private static final String tableName = "cb_invest_source";
	
	@Resource
	private ICbInvestSourceService cbInvestSourceService;
	
	@Resource
	private ICbPlanPrjService cbPrjPlanService;
	
	@Resource
	private IHeaderService headerService;
	
	@Resource
	private IDicInfoService dicInfoService;
	
	/**
	 * 
	* @Title: getInvestSourceByPage 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pageNum
	* @param @param pageSize
	* @param @return  参数说明 
	* @return DataTablesBean<CbInvestSourceRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月13日 下午5:10:13
	 */
	@AuthGroup(permits={"ADMIN","PROGRESS","DATA"})
	@RequestMapping(value = "rows", method = {RequestMethod.GET, RequestMethod.POST})
	public DataTablesBean<CbInvestSourceRow> getInvestSourceByPage(
			@RequestParam(required=false,value="pageNum", defaultValue="1") Integer pageNum, 
			@RequestParam(required=false,value="pageSize", defaultValue="10") Integer pageSize,
			@RequestParam(required = false, value = "keyword") String keyword) {
		PageInfo<CbInvestSourceRow> pageInfo = cbInvestSourceService.getCbInvestSourceOutsByPage(pageNum, pageSize, keyword);
		DataTablesBean<CbInvestSourceRow> table = new DataTablesBean<>();
		table.setErrorCode(0);
		table.setData(pageInfo.getList());
		table.setRecordsTotal(pageInfo.getTotal());
		table.setRecordsFiltered(pageInfo.getTotal());
		return table;
	}
	
	/**
	 * 
	* @Title: getCbInvestSourceTableWebHeader 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<HashMap<String,Object>>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月13日 下午5:13:44
	 */
	@AuthGroup(permits={"ADMIN","PROGRESS","DATA"})
	@RequestMapping(value = "cols", method = {RequestMethod.GET, RequestMethod.POST})
	public List<HashMap<String, Object>> getCbInvestSourceTableCols() {
		List<HashMap<String, Object>> headers = headerService.getHeadersByClassType(tableName, CbInvestSourceRow.class);
		return headers;
	}
	
	/**
	 * 
	* @Title: getCbInvestSourceTableOptions 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return EditOptionsOut    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月13日 下午5:25:32
	 */
	@AuthGroup(permits={"ADMIN","PROGRESS","DATA"})
	@RequestMapping(value = "edit-page", method = RequestMethod.GET)
	public EditOptionsOut getCbInvestSourceTableOptions() {
		EditOptionsOut options = new EditOptionsOut();
		List<DictHeader> headers = this.headerService.getWebHeadersByTableName(tableName);
		if (!headers.isEmpty() || null != headers) {
			options.setHeaders(headers);
		}
		List<OptionsOut> prjPlanIdTrans = this.cbPrjPlanService.getPrjPlanIdNameOptions();
		if (!prjPlanIdTrans.isEmpty() || null != prjPlanIdTrans) {
			options.getOptions().put("prjPlanIdTrans", prjPlanIdTrans);
		}
		List<OptionsOut> sourceNoTrans = this.dicInfoService.getOptionsByType(219); // source_no
		if (!sourceNoTrans.isEmpty() || null != sourceNoTrans) {
			options.getOptions().put("sourceNoTrans", sourceNoTrans);
		}
		List<OptionsOut> sourceTypeNoTrans = this.dicInfoService.getOptionsByType(220); // source_type_no
		if (!sourceTypeNoTrans.isEmpty() || null != sourceTypeNoTrans) {
			options.getOptions().put("sourceTypeNoTrans", sourceTypeNoTrans);
		}
		return options;
	}
	
	/**
	 * 
	* @Title: cbInvestSourceTableUpdate 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param cbInvestSource
	* @param @return  参数说明 
	* @return CommonReturnBean<Integer>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月26日 上午9:53:39
	 */
	@AuthGroup(permits={"ADMIN","PROGRESS","DATA"})
	@RequestMapping(value = "update", method = RequestMethod.POST, consumes = "application/json")
	public CommonReturnBean<Integer> cbInvestSourceTableUpdate(@RequestBody CbInvestSource cbInvestSource) {
		CommonReturnBean<Integer> ret = new CommonReturnBean<>();
		if (null == cbInvestSource) {
			ret.setErrorCode(-1);
			ret.setErrorMsg("请求对象CbInvestSource为空。");
			logger.info("请求对象CbInvestSource为空。");
			return ret;
		}
		boolean exist = null != this.cbInvestSourceService.findById(cbInvestSource.getId());
		// not exist
		if (!exist) { // insert
			boolean inserted = this.cbInvestSourceService.insert(cbInvestSource) > 0 ? true : false;
			if (inserted) {
				ret.setErrorCode(0);
				ret.setErrorMsg(String.format("新增记录成功！ID:%s", cbInvestSource.getId()));
				logger.info(String.format("新增CbInvestSource对象成功！ID:%s", cbInvestSource.getId()));
				return ret;
			} else {
				ret.setErrorCode(-1);
				ret.setErrorMsg(String.format("新增记录失败！ID:%s", cbInvestSource.getId()));
				logger.info(String.format("新增CbInvestSource对象失败！ID:%s", cbInvestSource.getId()));
				return ret;
			}
		} else { // update
			boolean updated = this.cbInvestSourceService.update(cbInvestSource) > 0 ? true : false;
			if (updated) {
				ret.setErrorCode(0);
				ret.setErrorMsg(String.format("更新记录成功！ID:%s", cbInvestSource.getId()));
				logger.info(String.format("更新CbInvestSource对象成功！ID:%s", cbInvestSource.getId()));
				return ret;
			} else {
				ret.setErrorCode(-1);
				ret.setErrorMsg(String.format("更新记录失败！ID:%s", cbInvestSource.getId()));
				logger.info(String.format("更新CbInvestSource对象失败！ID:%s", cbInvestSource.getId()));
				return ret;
			}
		}
	}

}
