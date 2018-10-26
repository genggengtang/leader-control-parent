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
import org.zxs.leader.control.controller.CityPlanPrjController;
import org.zxs.leader.control.dao.model.CityPlanPrj;
import org.zxs.leader.control.dao.model.DictHeader;
import org.zxs.leader.control.dao.model.vo.output.EditOptionsOut;
import org.zxs.leader.control.dao.model.vo.output.OptionsOut;
import org.zxs.leader.control.dao.model.vo.output.rows.CityPlanPrjRow;
import org.zxs.leader.control.service.interf.IAreaNnService;
import org.zxs.leader.control.service.interf.ICityPlanPrjService;
import org.zxs.leader.control.service.interf.IDicInfoService;
import org.zxs.leader.control.service.interf.IHeaderService;
import org.zxs.leader.control.service.interf.IMeetingNoteService;
import org.zxs.leader.control.service.interf.IPrjInfoService;
import org.zxs.leader.control.service.interf.IPrjMonthPlanService;
import org.zxs.leader.control.service.interf.IPrjProveService;
import org.zxs.leader.control.service.interf.IPrjYearPlanService;

import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;

@RequestMapping("/tables/city-plan-prj/")
@RestController
@Api(tags="市统筹项目查询接口")
public class TableCityPlanPrjController {

	private static final Log logger = LogFactory.getLog(CityPlanPrjController.class);
	
	private static final String tableName = "city_plan_prj";
	
	@Resource
	private IPrjInfoService prjInfoService;
	
	@Resource
	private ICityPlanPrjService cityPlanPrjService;
	
	@Resource
	private IPrjProveService prjProveSerivce;
	
	@Resource
	private IMeetingNoteService mNoteService;
	
	@Resource
	private IPrjYearPlanService yearSerivce;
	
	@Resource
	private IPrjMonthPlanService monthService;
	
	@Resource
	private IHeaderService headerService;
	
	@Resource
	private IDicInfoService dicInfoService;
	
	@Resource
	private IAreaNnService areaNnService;
	
	/**
	 * 
	* @Title: getCityPlanPrjTableRows 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pageNum
	* @param @param pageSize
	* @param @return  参数说明 
	* @return DataTablesBean<CityPlanPrjRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月16日 下午3:52:15
	 */
	@RequestMapping(value = "rows", method = {RequestMethod.GET, RequestMethod.POST})
	public DataTablesBean<CityPlanPrjRow> getCityPlanPrjTableRows(
			@RequestParam(required=false,value="pageNum", defaultValue="1") Integer pageNum, 
			@RequestParam(required=false,value="pageSize", defaultValue="10") Integer pageSize,
			@RequestParam(required=false, value="keyword") String keyword) {
		PageInfo<CityPlanPrjRow> page = this.cityPlanPrjService.getCityPlanPrjRowsByPage(pageNum, pageSize, keyword);
		DataTablesBean<CityPlanPrjRow> table = new DataTablesBean<>();
		table.setErrorCode(0);
		table.setData(page.getList());
		table.setRecordsTotal(page.getTotal());
		table.setRecordsFiltered(page.getPageSize());
		return table;
	}
	
	/**
	 * 
	* @Title: getCityPlanPrjTableCols 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<HashMap<String,Object>>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月16日 下午4:29:25
	 */
	@RequestMapping(value = "cols", method = {RequestMethod.GET, RequestMethod.POST})
	public List<HashMap<String, Object>> getCityPlanPrjTableCols() {
		List<HashMap<String, Object>> headers = headerService.getHeadersByClassType(tableName, CityPlanPrjRow.class);
		return headers;
	}
	
	/**
	 * 
	* @Title: getCityPlanPrjTableOptions 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return EditOptionsOut    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月16日 下午4:36:52
	 */
	@RequestMapping(value = "edit-page", method = RequestMethod.GET)
	public EditOptionsOut getCityPlanPrjTableOptions() {
		EditOptionsOut options = new EditOptionsOut();
		List<DictHeader> headers = this.headerService.getWebHeadersByTableName(tableName);
		if (!headers.isEmpty() || null != headers) {
			options.setHeaders(headers);
		}
		List<OptionsOut> typeTrans = this.dicInfoService.getOptionsByType(203); // type
		if (!typeTrans.isEmpty() || null != typeTrans) {
			options.getOptions().put("typeTrans", typeTrans);
		}
		List<OptionsOut> labelTrans = this.dicInfoService.getOptionsByType(213); // label
		if (!labelTrans.isEmpty() || null != labelTrans) {
			options.getOptions().put("labelTrans", labelTrans);
		}
		List<OptionsOut> planStatusTrans = this.dicInfoService.getOptionsByType(204); // plan_status
		if (!planStatusTrans.isEmpty() || null != planStatusTrans) {
			options.getOptions().put("planStatusTrans", planStatusTrans);
		}
		List<OptionsOut> areaAdminTrans = this.areaNnService.getAllAreaNameOptions(); // area admin
		if (!areaAdminTrans.isEmpty() || null != areaAdminTrans) {
			options.getOptions().put("areaAdminTrans", areaAdminTrans);
		}
		List<OptionsOut> areaTrans = this.areaNnService.getAllAreaNameOptions(); // areas
		if (!areaTrans.isEmpty() || null != areaTrans) {
			options.getOptions().put("areaTrans", areaTrans);
		}
		List<OptionsOut> prjDbNoTrans = this.prjInfoService.getAllPrjInfoOptions();
		if (!prjDbNoTrans.isEmpty() || null != prjDbNoTrans) {
			options.getOptions().put("prjDbNoTrans", prjDbNoTrans);
		}
		List<OptionsOut> prjDbIdTrans = this.prjInfoService.getAllPrjInfoOptions();
		if (!prjDbIdTrans.isEmpty() || null != prjDbIdTrans) {
			options.getOptions().put("prjDbIdTrans", prjDbIdTrans);
		}
		return options;
	}
	
	/**
	 * 
	* @Title: cityPlanPrjTableUpdate 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param cityPlanPrj
	* @param @return  参数说明 
	* @return CommonReturnBean<Integer>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月31日 上午10:03:00
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST, consumes = "application/json")
	public CommonReturnBean<Integer> cityPlanPrjTableUpdate(@RequestBody CityPlanPrj cityPlanPrj) {
		CommonReturnBean<Integer> ret = new CommonReturnBean<>();
		if (null == cityPlanPrj) {
			ret.setErrorCode(-1);
			ret.setErrorMsg("请求对象为空。");
			logger.info("请求对象为空。");
			return ret;
		}
		boolean exist = null != this.cityPlanPrjService.findById(cityPlanPrj.getId());
		// id不存在，新增记录
		if (!exist) {
			boolean inserted = this.cityPlanPrjService.insert(cityPlanPrj) > 0 ? true : false;
			if (inserted) { // 新增成功
				ret.setErrorCode(0);
				ret.setErrorMsg(String.format("新增市统筹项目成功！ID:%s", cityPlanPrj.getId()));
				logger.info(String.format("新增市统筹项目成功！ID:%s", cityPlanPrj.getId()));
				return ret;
			} else {
				ret.setErrorCode(-1);
				ret.setErrorMsg(String.format("新增市统筹项目失败！ID:%s", cityPlanPrj.getId()));
				logger.info(String.format("新增市统筹项目失败！ID:%s", cityPlanPrj.getId()));
				return ret;
			}
		} else { // id存在，根据id更新记录
			boolean updated = this.cityPlanPrjService.update(cityPlanPrj) > 0 ? true : false;
			if (updated) { // 更新成功
				ret.setErrorCode(0);
				ret.setErrorMsg(String.format("更新市统筹项目成功！ID:%s", cityPlanPrj.getId()));
				logger.info(String.format("更新市统筹项目成功！ID:%s", cityPlanPrj.getId()));
				return ret;
			} else {
				ret.setErrorCode(-1);
				ret.setErrorMsg(String.format("更新市统筹项目失败！ID:%s", cityPlanPrj.getId()));
				logger.info(String.format("更新市统筹项目失败！ID:%s", cityPlanPrj.getId()));
				return ret;
			}
		}
	}
	
}
