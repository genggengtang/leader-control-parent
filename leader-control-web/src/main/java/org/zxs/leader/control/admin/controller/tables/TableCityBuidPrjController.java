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
import org.zxs.leader.control.dao.model.CityBuildPrj;
import org.zxs.leader.control.dao.model.DictHeader;
import org.zxs.leader.control.dao.model.vo.output.EditOptionsOut;
import org.zxs.leader.control.dao.model.vo.output.OptionsOut;
import org.zxs.leader.control.dao.model.vo.output.rows.CityBuildPrjRow;
import org.zxs.leader.control.service.interf.ICityBuildPrjService;
import org.zxs.leader.control.service.interf.IDicInfoService;
import org.zxs.leader.control.service.interf.IHeaderService;
import org.zxs.leader.control.service.interf.IPrjInfoService;

import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;

@RequestMapping("/tables/city-build-prj")
@RestController
@Api(tags="城建计划项目总表")
public class TableCityBuidPrjController {
	
	private static final Log logger = LogFactory.getLog(TableCityBuidPrjController.class);
	
	private static final String tableName = "city_build_prj";
	
	@Resource
	private ICityBuildPrjService cityBuildPrjService;
	
	@Resource
	private IPrjInfoService prjInfoService;
	
	@Resource
	private IHeaderService headerService;
	
	@Resource
	private IDicInfoService dicInfoService;
	
	/**
	 * 
	* @Title: getCityBuildPrjTableRows 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pageNum
	* @param @param pageSize
	* @param @return  参数说明 
	* @return DataTablesBean<CityBuildPrjRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月16日 下午3:23:41
	 */
	@RequestMapping(value = "rows", method = {RequestMethod.GET, RequestMethod.POST})
	public DataTablesBean<CityBuildPrjRow> getCityBuildPrjTableRows(
			@RequestParam(required=false,value="pageNum", defaultValue="1") Integer pageNum, 
			@RequestParam(required=false,value="pageSize", defaultValue="10") Integer pageSize,
			@RequestParam(required=false, value="keyword") String keyword) {
		PageInfo<CityBuildPrjRow> pageInfo = this.cityBuildPrjService.getCityBuildPrjRowsByPage(pageNum, pageSize, keyword);
		DataTablesBean<CityBuildPrjRow> table = new DataTablesBean<>();
		table.setErrorCode(0);
		table.setData(pageInfo.getList());
		table.setRecordsTotal(pageInfo.getTotal());
		table.setRecordsFiltered(pageInfo.getTotal());
		return table;
	}
	
	/**
	 * 
	* @Title: getCityBuildPrjTableCols 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<HashMap<String,Object>>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月16日 下午3:26:26
	 */
	@RequestMapping(value = "cols", method = {RequestMethod.GET, RequestMethod.POST})
	public List<HashMap<String, Object>> getCityBuildPrjTableCols() {
		List<HashMap<String, Object>> headers = headerService.getHeadersByClassType(tableName, CityBuildPrjRow.class);
		return headers;
	}
	
	/**
	 * 
	* @Title: getCityBuildPrjTableOptions 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return EditOptionsOut    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月16日 下午3:41:03
	 */
	@RequestMapping(value = "edit-page", method = RequestMethod.GET)
	public EditOptionsOut getCityBuildPrjTableOptions() {
		EditOptionsOut options = new EditOptionsOut();
		List<DictHeader> headers = this.headerService.getWebHeadersByTableName(tableName);
		if (!headers.isEmpty() || null != headers) {
			options.setHeaders(headers);
		}
		List<OptionsOut> prjDbNoTrans = this.prjInfoService.getAllPrjInfoOptions();
		if (!prjDbNoTrans.isEmpty() || null != prjDbNoTrans) {
			options.getOptions().put("prjDbNoTrans", prjDbNoTrans);
		}
		List<OptionsOut> currentPlanNoTrans = this.dicInfoService.getOptionsByType(218); // current_plan_no
		if (!currentPlanNoTrans.isEmpty() || null != currentPlanNoTrans) {
			options.getOptions().put("currentPlanNoTrans", currentPlanNoTrans);
		}
		logger.info(String.format("成功获取[%s]个表头信息和[%s]个选项数据。", options.getHeaders().size(), options.getOptions().size()));
		return options;
	}

	/**
	 * 
	* @Title: cityBuildPrjTableUpdate 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param cityBuildPrj
	* @param @return  参数说明 
	* @return CommonReturnBean<Integer>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月31日 上午8:55:38
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST, consumes = "application/json")
	public CommonReturnBean<Integer> cityBuildPrjTableUpdate(@RequestBody CityBuildPrj cityBuildPrj) {
		CommonReturnBean<Integer> ret = new CommonReturnBean<>();
		if (null == cityBuildPrj) {
			ret.setErrorCode(-1);
			ret.setErrorMsg("请求对象为空。");
			logger.info("请求对象为空。");
			return ret;
		}
		logger.info(String.format("正在写入ID[%s] - 内容[%s]", cityBuildPrj.getId(), cityBuildPrj.getPrjContent()));
		boolean exist = null != this.cityBuildPrjService.findById(cityBuildPrj.getId());
		// id不存在，新增记录
		if (!exist) {
			boolean inserted = this.cityBuildPrjService.insert(cityBuildPrj) > 0 ? true : false;
			if (inserted) { // 新增成功
				ret.setErrorCode(0);
				ret.setErrorMsg(String.format("新增城建计划项目总表成功！ID[%s]", cityBuildPrj.getId()));
				logger.info(String.format("新增城建计划项目总表成功！ID[%s]", cityBuildPrj));
				return ret;
			} else {
				ret.setErrorCode(-1);
				ret.setErrorMsg(String.format("新增城建计划项目总表失败！ID[%s]", cityBuildPrj.getId()));
				logger.info(String.format("新增城建计划项目总表失败！ID[%s]", cityBuildPrj.getId()));
				return ret;
			}
		} else { // id存在，依据id更新记录
			boolean updated = this.cityBuildPrjService.update(cityBuildPrj) > 0 ? true : false;
			if (updated) { // 更新成功
				ret.setErrorCode(0);
				ret.setErrorMsg(String.format("更新城建计划项目总表成功！ID[%s]", cityBuildPrj.getId()));
				logger.info(String.format("更新城建计划项目总表成功！ID[%s]", cityBuildPrj.getId()));
				return ret;
			} else {
				ret.setErrorCode(-1);
				ret.setErrorMsg(String.format("更新城建计划项目总表失败！ID[%s]", cityBuildPrj.getId()));
				logger.info(String.format("更新城建计划项目总表失败！ID[%s]", cityBuildPrj.getId()));
				return ret;
			}
		}
	}

}
