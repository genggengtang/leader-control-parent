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
import org.zxs.leader.control.dao.model.PrjContact;
import org.zxs.leader.control.dao.model.vo.output.EditOptionsOut;
import org.zxs.leader.control.dao.model.vo.output.OptionsOut;
import org.zxs.leader.control.dao.model.vo.output.rows.PrjContactRow;
import org.zxs.leader.control.service.interf.IDicInfoService;
import org.zxs.leader.control.service.interf.IHeaderService;
import org.zxs.leader.control.service.interf.IOrgUnitService;
import org.zxs.leader.control.service.interf.IOrgUserService;
import org.zxs.leader.control.service.interf.IPrjContactService;
import org.zxs.leader.control.service.interf.IPrjInfoService;

import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;

@RequestMapping("/tables/prj-contact")
@RestController
@Api(tags="项目联系人关联表")
public class TablePrjContactController {
	
	private static final Log logger = LogFactory.getLog(TablePrjContactController.class);
	
	private static final String tableName = "prj_contact";
	
	@Resource
	private IPrjContactService prjContactService;
	
	@Resource
	private IPrjInfoService prjInfoService;
	
	@Resource
	private IOrgUnitService orgUnitService;
	
	@Resource
	private IOrgUserService orgUserService;
	
	@Resource
	private IHeaderService headerService;
	
	@Resource
	private IDicInfoService dicInfoService;
	
	/**
	 * 
	* @Title: getPrjContactTableRows 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pageNum
	* @param @param pageSize
	* @param @return  参数说明 
	* @return DataTablesBean<PrjContactOut>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月18日 上午10:11:08
	 */
	@RequestMapping(value = "rows", method = {RequestMethod.GET, RequestMethod.POST})
	public DataTablesBean<PrjContactRow> getPrjContactTableRows(
			@RequestParam(required=false,value="pageNum", defaultValue="1") Integer pageNum, 
			@RequestParam(required=false,value="pageSize", defaultValue="10") Integer pageSize,
			@RequestParam(required=false, value="keyword") String keyword) {
		PageInfo<PrjContactRow> pageInfo = this.prjContactService.getPrjContactOutsByPage(pageNum, pageSize, keyword);
		DataTablesBean<PrjContactRow> table = new DataTablesBean<>();
		table.setErrorCode(0);
		table.setData(pageInfo.getList());
		table.setRecordsTotal(pageInfo.getTotal());
		table.setRecordsFiltered(pageInfo.getTotal());
		return table;
	}
	
	/**
	 * 
	* @Title: getPrjContactTableCols 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<HashMap<String,Object>>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月18日 上午10:11:47
	 */
	@RequestMapping(value = "cols", method = {RequestMethod.GET, RequestMethod.POST})
	public List<HashMap<String, Object>> getPrjContactTableCols() {
		List<HashMap<String, Object>> headers = headerService.getHeadersByClassType(tableName, PrjContactRow.class);
		return headers;
	}
	
	/**
	 * 
	* @Title: getPrjContactTableOptions 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return EditOptionsOut    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月18日 上午10:13:12
	 */
	@RequestMapping(value = "edit-page", method = RequestMethod.GET)
	public EditOptionsOut getPrjContactTableOptions() {
		EditOptionsOut options = new EditOptionsOut();
		List<DictHeader> headers = this.headerService.getWebHeadersByTableName(tableName);
		if (!headers.isEmpty() || null != headers) {
			options.setHeaders(headers);
		}
		List<OptionsOut> prjIdTrans = this.prjInfoService.getAllPrjInfoOptions();
		if (!prjIdTrans.isEmpty() || null != prjIdTrans) {
			options.getOptions().put("prjIdTrans", prjIdTrans);
		}
		List<OptionsOut> typeTrans = this.dicInfoService.getOptionsByType(208); // type
		if (!typeTrans.isEmpty() || null != typeTrans) {
			options.getOptions().put("typeTrans", typeTrans);
		}
		List<OptionsOut> orgIdTrans = this.orgUnitService.getAllOrgIdOptions();
		if (!orgIdTrans.isEmpty() || null != orgIdTrans) {
			options.getOptions().put("orgIdTrans", orgIdTrans);
		}
		List<OptionsOut> userIdTrans = this.orgUserService.getAllUserIdOpts();
		if (!userIdTrans.isEmpty() || null != userIdTrans) {
			options.getOptions().put("userIdTrans", userIdTrans);
		}
		return options;
	}
	
	/**
	 * 
	* @Title: prjContactTableUpdate 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param prjContact
	* @param @return  参数说明 
	* @return CommonReturnBean<Integer>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月1日 上午9:23:08
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST, consumes = "application/json")
	public CommonReturnBean<Integer> prjContactTableUpdate(@RequestBody PrjContact prjContact) {
		CommonReturnBean<Integer> ret = new CommonReturnBean<>();
		if (null == prjContact) {
			ret.setErrorCode(-1);
			ret.setErrorMsg("请求对象为空。");
			logger.info("请求对象为空。");
			return ret;
		}
		boolean exist = null != this.prjContactService.findById(prjContact.getId());
		// id不存在，新增记录
		if (!exist) {
			boolean inserted = this.prjContactService.insert(prjContact) > 0 ? true : false;
			if (inserted) { // 新增成功
				ret.setErrorCode(0);
				ret.setErrorMsg(String.format("新增项目联系人关联成功！ID[%s]", prjContact.getId()));
				logger.info(String.format("新增项目联系人关联成功！ID[%s]", prjContact.getId()));
				return ret;
			} else {
				ret.setErrorCode(-1);
				ret.setErrorMsg(String.format("新增项目联系人关联失败！ID[%s]", prjContact.getId()));
				logger.info(String.format("新增项目联系人关联失败！ID[%s]", prjContact.getId()));
				return ret;
			}
		} else { // id存在，根据id更新记录
			boolean updated = this.prjContactService.update(prjContact) > 0 ? true : false;
			if (updated) { // 更新成功
				ret.setErrorCode(0);
				ret.setErrorMsg(String.format("更新项目联系人关联成功！ID[%s]", prjContact.getId()));
				logger.info(String.format("更新项目联系人关联成功！ID[%s]", prjContact.getId()));
				return ret;
			} else {
				ret.setErrorCode(-1);
				ret.setErrorMsg(String.format("更新项目附件失败！ID[%s]", prjContact.getId()));
				logger.info(String.format("更新项目附件失败！ID[%s]", prjContact.getId()));
				return ret;
			}
		}
	}
	
}
