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
import org.zxs.leader.control.dao.model.CpPrjOrg;
import org.zxs.leader.control.dao.model.DictHeader;
import org.zxs.leader.control.dao.model.vo.output.EditOptionsOut;
import org.zxs.leader.control.dao.model.vo.output.OptionsOut;
import org.zxs.leader.control.dao.model.vo.output.rows.CpPrjOrgRow;
import org.zxs.leader.control.service.interf.ICpPrjOrgService;
import org.zxs.leader.control.service.interf.IDicInfoService;
import org.zxs.leader.control.service.interf.IHeaderService;
import org.zxs.leader.control.service.interf.IOrgUnitService;
import org.zxs.leader.control.service.interf.IPrjInfoService;

import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/tables/cp-prj-org")
@Api(tags="市统筹项目与各单位关系表")
public class TableCpPrjOrgController {
	
	private static final Log logger = LogFactory.getLog(TableCpPrjOrgController.class);
	
	private static final String tableName = "cp_prj_org";
	
	@Resource
	private ICpPrjOrgService cpPrjOrgService;
	
	@Resource
	private IPrjInfoService prjInfoService;
	
	@Resource
	private IOrgUnitService orgUnitService;
	
	@Resource
	private IHeaderService headerService;
	
	@Resource
	private IDicInfoService dicInfoService;
	
	/**
	 * 
	* @Title: getCpPrjOrgTableRows 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pageNum
	* @param @param pageSize
	* @param @return  参数说明 
	* @return DataTablesBean<CpPrjOrgOut>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月16日 下午5:01:29
	 */
	@RequestMapping(value = "rows", method = {RequestMethod.GET, RequestMethod.POST})
	public DataTablesBean<CpPrjOrgRow> getCpPrjOrgTableRows(
			@RequestParam(required=false,value="pageNum", defaultValue="1") Integer pageNum, 
			@RequestParam(required=false,value="pageSize", defaultValue="10") Integer pageSize,
			@RequestParam(required=false, value="keyword") String keyword) {
		PageInfo<CpPrjOrgRow> pageInfo = this.cpPrjOrgService.getCpPrjOrgOutsByPage(pageNum, pageSize, keyword);
		DataTablesBean<CpPrjOrgRow> table = new DataTablesBean<>();
		table.setErrorCode(0);
		table.setErrorMsg("获取表列数据成功！");
		table.setData(pageInfo.getList());
		table.setRecordsTotal(pageInfo.getTotal());
		table.setRecordsFiltered(pageInfo.getTotal());
		return table;
	}
	
	/**
	 * 
	* @Title: getCpPrjOrgTableCols 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<HashMap<String,Object>>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月16日 下午5:15:24
	 */
	@RequestMapping(value = "cols", method = {RequestMethod.GET, RequestMethod.POST})
	public List<HashMap<String, Object>> getCpPrjOrgTableCols() {
		List<HashMap<String, Object>> headers = headerService.getHeadersByClassType(tableName, CpPrjOrgRow.class);
		return headers;
	}
	
	/**
	 * 
	* @Title: getCpPrjOrgTableOptions 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return EditOptionsOut    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月16日 下午5:16:45
	 */
	@RequestMapping(value = "edit-page", method = RequestMethod.GET)
	public EditOptionsOut getCpPrjOrgTableOptions() {
		EditOptionsOut options = new EditOptionsOut();
		List<DictHeader> headers = this.headerService.getWebHeadersByTableName(tableName);
		if (!headers.isEmpty() || null != headers) {
			options.setHeaders(headers);
		}
		List<OptionsOut> prjTypeTrans = this.dicInfoService.getOptionsByType(214); // prj_type
		if (!prjTypeTrans.isEmpty() || null != prjTypeTrans) {
			options.getOptions().put("prjTypeTrans", prjTypeTrans);
		}
		List<OptionsOut> cpPrjIdTrans = this.prjInfoService.getAllPrjInfoOptions();
		if (!cpPrjIdTrans.isEmpty() || null != cpPrjIdTrans) {
			options.getOptions().put("cpPrjIdTrans", cpPrjIdTrans);
		}
		List<OptionsOut> orgIdTrans = this.orgUnitService.getAllOrgIdOptions();
		if (!orgIdTrans.isEmpty() || null != orgIdTrans) {
			options.getOptions().put("orgIdTrans", orgIdTrans);
		}
		List<OptionsOut> relateTypeTrans = this.dicInfoService.getOptionsByType(212); // relate_type
		if (!relateTypeTrans.isEmpty() || null != relateTypeTrans) {
			options.getOptions().put("relateTypeTrans", relateTypeTrans);
		}
		return options;
	}
	
	/**
	 * 
	* @Title: cpPrjOrgTableUpdate 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param cpPrjOrg
	* @param @return  参数说明 
	* @return CommonReturnBean<Integer>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月31日 下午5:41:40
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST, consumes = "application/json")
	public CommonReturnBean<Integer> cpPrjOrgTableUpdate(@RequestBody CpPrjOrg cpPrjOrg) {
		CommonReturnBean<Integer> ret = new CommonReturnBean<>();
		if (null == cpPrjOrg) {
			ret.setErrorCode(-1);
			ret.setErrorMsg("请求对象为空。");
			logger.info("请求对象为空。");
			return ret;
		}
		boolean exist = null != this.cpPrjOrgService.findById(cpPrjOrg.getId());
		// id not exist, insert new record
		if (!exist) {
			boolean inserted = this.cpPrjOrgService.insert(cpPrjOrg) > 0 ? true : false;
			if (inserted) { // 新增成功
				ret.setErrorCode(0);
				ret.setErrorMsg(String.format("新增成功！ID[%s]", cpPrjOrg.getId()));
				logger.info(String.format("新增成功！ID[%s]", cpPrjOrg.getId()));
				return ret;
			} else {
				ret.setErrorCode(-1);
				ret.setErrorMsg(String.format("新增失败！ID[%s]", cpPrjOrg.getId()));
				logger.info(String.format("新增失败！ID[%s]", cpPrjOrg.getId()));
				return ret;
			}
		} else { // id exists, update record
			boolean updated = this.cpPrjOrgService.update(cpPrjOrg) > 0 ? true : false;
			if (updated) { // 更新成功
				ret.setErrorCode(0);
				ret.setErrorMsg(String.format("更新成功！ID[%s]", cpPrjOrg.getId()));
				logger.info(String.format("更新成功！ID[%s]", cpPrjOrg.getId()));
				return ret;
			} else {
				ret.setErrorCode(-1);
				ret.setErrorMsg(String.format("更新失败！ID[%s]", cpPrjOrg.getId()));
				logger.info(String.format("更新失败！ID[%s]", cpPrjOrg.getId()));
				return ret;
			}
		}
	}

}
