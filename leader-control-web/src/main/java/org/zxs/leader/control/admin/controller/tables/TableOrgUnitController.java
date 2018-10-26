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
import org.zxs.leader.control.dao.model.DictHeader;
import org.zxs.leader.control.dao.model.OrgUnit;
import org.zxs.leader.control.dao.model.vo.output.EditOptionsOut;
import org.zxs.leader.control.dao.model.vo.output.OptionsOut;
import org.zxs.leader.control.dao.model.vo.output.rows.OrgUnitRow;
import org.zxs.leader.control.service.interf.IAreaNnService;
import org.zxs.leader.control.service.interf.IDicInfoService;
import org.zxs.leader.control.service.interf.IHeaderService;
import org.zxs.leader.control.service.interf.IOrgUnitService;

import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;

@RequestMapping("/tables/org-unit/")
@RestController
@Api(tags="机构企业单位表")
public class TableOrgUnitController {
	
	private static final Log logger = LogFactory.getLog(TableOrgUnitController.class);
	
	private final String tableName = "org_unit";
	
	@Resource
	private IOrgUnitService orgUnitService;
	
	@Resource
	private IAreaNnService areaService;
	
	@Resource
	private IDicInfoService dicInfoService;
	
	@Resource
	private IHeaderService headerService;
	
	/**
	 * 
	* @Title: getOrgUnitByPage 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pageNum
	* @param @param pageSize
	* @param @return  参数说明 
	* @return DataTablesBean<OrgUnitRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月9日 下午5:03:48
	 */	
	@AuthGroup(permits={"ADMIN","PROGRESS","DATA"})
	@RequestMapping(value = "rows", method = RequestMethod.GET)
	public DataTablesBean<OrgUnitRow> getOrgUnitByPage(
			@RequestParam(required=false,value="pageNum", defaultValue="1") Integer pageNum, 
			@RequestParam(required=false,value="pageSize", defaultValue="10") Integer pageSize,
			@RequestParam(required = false, value = "keyword") String keyword) {
		PageInfo<OrgUnitRow> pageInfo = orgUnitService.getOrgUnitOutsByPage(pageNum, pageSize, keyword);
		DataTablesBean<OrgUnitRow> table = new DataTablesBean<>();
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
	* @date 2018年7月9日 下午5:03:44
	 */
	@AuthGroup(permits={"ADMIN","PROGRESS","DATA"})
	@RequestMapping(value = "cols", method = RequestMethod.GET)
	public List<HashMap<String, Object>> getOrgUnitTableHeader() {
		List<HashMap<String, Object>> headers = headerService.getHeadersByClassType(tableName, OrgUnitRow.class);
		return headers;
	}
	
	/**
	 * 
	* @Title: getOrgUnitTableOptions 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return EditOptionsOut    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月9日 下午5:03:35
	 */
	@AuthGroup(permits={"ADMIN","PROGRESS","DATA"})
	@RequestMapping(value = "edit-page", method = RequestMethod.GET)
	public EditOptionsOut getOrgUnitTableOptions() {
		EditOptionsOut options = new EditOptionsOut();
		List<DictHeader> headers = this.headerService.getWebHeadersByTableName(tableName);
		if (!headers.isEmpty() || null != headers) {
			options.setHeaders(headers);
		}
		List<OptionsOut> orgAreaList = this.areaService.getAllListWithoutProv();
		if (!orgAreaList.isEmpty() || null != orgAreaList) {
			options.getOptions().put("areaIdTrans", orgAreaList);
		}
		List<OptionsOut> orgTypeList = this.dicInfoService.getAllOrgTypeOptions();
		if (!orgTypeList.isEmpty() || null != orgTypeList) {
			options.getOptions().put("typeTrans", orgTypeList);
		}
		return options;
	}
	
	/**
	 * 
	* @Title: createUpdateOrgUnit 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param orgUnit
	* @param @return  参数说明 
	* @return CommonReturnBean<Integer>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月11日 下午4:53:22
	 */
	@AuthGroup(permits={"ADMIN","PROGRESS","DATA"})
	@RequestMapping(value = "update", method = RequestMethod.POST, consumes = "application/json")
	public CommonReturnBean<Integer> createUpdateOrgUnit(@RequestBody OrgUnit orgUnit) {
		CommonReturnBean<Integer> ret = new CommonReturnBean<>();
		String errorMsg = "";
		if (null == orgUnit) {
			errorMsg = "机构为空，表单提交失败。";
			ret.setErrorCode(-2);
			ret.setErrorMsg(errorMsg);
			logger.info(errorMsg);
		}
		boolean exist = null != this.orgUnitService.findById(orgUnit.getId());
		if (!exist) { // create new record
			int res = this.orgUnitService.insertOrgUnit(orgUnit);
			if (res > 0) {
				errorMsg = "新机构创建成功！ id:" + orgUnit.getId() + " fullName:" + orgUnit.getFullName();
				ret.setErrorCode(0);
				ret.setErrorMsg(errorMsg);
				logger.info(errorMsg);
				return ret;
			} else {
				errorMsg = "机构创建失败！id:" + orgUnit.getId() + " fullName:" + orgUnit.getFullName();
				ret.setErrorCode(-1);
				ret.setErrorMsg(errorMsg);
				logger.info(errorMsg);
				return ret;
			}
		} else { // update existing record
			int res = this.orgUnitService.updateOrgUnit(orgUnit);
			if (res > 0) {
				errorMsg = "机构更新成功！ id:" + orgUnit.getId() + " fullName:" + orgUnit.getFullName();
				ret.setErrorCode(0);
				ret.setErrorMsg(errorMsg);
				logger.info(errorMsg);
				return ret;
			} else {
				errorMsg = "机构更新失败！id:" + orgUnit.getId() + " fullName:" + orgUnit.getFullName();
				ret.setErrorCode(-1);
				ret.setErrorMsg(errorMsg);
				logger.info(errorMsg);
				return ret;
			}
		}
	}

}
