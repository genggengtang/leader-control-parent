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
import org.zxs.leader.control.dao.model.OrgUser;
import org.zxs.leader.control.dao.model.vo.output.EditOptionsOut;
import org.zxs.leader.control.dao.model.vo.output.OptionsOut;
import org.zxs.leader.control.dao.model.vo.output.rows.OrgUserRow;
import org.zxs.leader.control.service.interf.IDicInfoService;
import org.zxs.leader.control.service.interf.IHeaderService;
import org.zxs.leader.control.service.interf.IOrgUnitService;
import org.zxs.leader.control.service.interf.IOrgUserService;

import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;

@RequestMapping("/tables/org-user/")
@RestController
@Api(tags="机构用户表")
public class TableOrgUserController {

	private static final Log logger = LogFactory.getLog(TableOrgUserController.class);

	private final String tableName = "org_user";

	@Resource
	private IOrgUserService orgUserService;

	@Resource
	private IHeaderService headerService;

	@Resource
	private IDicInfoService dicInfoService;

	@Resource
	private IOrgUnitService orgUnitService;
	
	/**
	 * 
	* @Title: getOrgUserByPage 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pageNum
	* @param @param pageSize
	* @param @return  参数说明 
	* @return DataTablesBean<OrgUserRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月12日 下午12:07:11
	 */
	@RequestMapping(value = "rows", method = {RequestMethod.GET, RequestMethod.POST})
	public DataTablesBean<OrgUserRow> getOrgUserByPage(
			@RequestParam(required = false, value = "pageNum", defaultValue="1") Integer pageNum, 
			@RequestParam(required = false, value = "pageSize", defaultValue="10") Integer pageSize,
			@RequestParam(required = false, value = "keyword") String keyword) {
		PageInfo<OrgUserRow> pageInfo = orgUserService.getRowsByPage(pageNum, pageSize, keyword);
		DataTablesBean<OrgUserRow> table = new DataTablesBean<>();
		table.setErrorCode(0);
		table.setData(pageInfo.getList());
		table.setRecordsTotal(pageInfo.getTotal());
		table.setRecordsFiltered(pageInfo.getTotal());
		return table;
	}
	
	/**
	 * 
	* @Title: getOrgUserTableHeader 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<HashMap<String,Object>>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月12日 下午12:07:14
	 */
	@RequestMapping(value = "cols", method = {RequestMethod.GET, RequestMethod.POST})
	public List<HashMap<String, Object>> getOrgUserTableHeader() {
		List<HashMap<String, Object>> headers = headerService.getHeadersByClassType(tableName, OrgUserRow.class);
		return headers;
	}
	
	/**
	 * 
	* @Title: getOrgUserTableOptions 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return EditOptionsOut    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月12日 下午12:08:18
	 */
	@RequestMapping(value = "edit-page", method = RequestMethod.GET)
	public EditOptionsOut getOrgUserTableOptions() {
		EditOptionsOut options = new EditOptionsOut();
		List<DictHeader> headers = this.headerService.getWebHeadersByTableName(tableName);
		if (!headers.isEmpty() || null != headers) {
			options.setHeaders(headers);
		}
		List<OptionsOut> orgIdTrans = this.orgUnitService.getAllOrgIdOptions();
		if (!orgIdTrans.isEmpty() || null != orgIdTrans) {
			options.getOptions().put("orgIdTrans", orgIdTrans);
		}
		List<OptionsOut> phoneListTypeTrans = this.dicInfoService.getAllPhoneListTypeOptions();
		if (!phoneListTypeTrans.isEmpty() || null != phoneListTypeTrans) {
			options.getOptions().put("phoneListTypeTrans", phoneListTypeTrans);
		}
		return options;
	}

	/**
	 * 
	* @Title: createUpdateOrgUser 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param orgUser
	* @param @return  参数说明 
	* @return CommonReturnBean<Integer>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月12日 下午3:23:45
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST, consumes = "application/json")
	public CommonReturnBean<Integer> createUpdateOrgUser(@RequestBody OrgUser orgUser) {
		CommonReturnBean<Integer> ret = new CommonReturnBean<>();
		String errorMsg = "";
		if (null == orgUser) {
			errorMsg = "机构用户为空，表单提交失败。";
			ret.setErrorCode(-2);
			ret.setErrorMsg(errorMsg);
			logger.info(errorMsg);
		}
		boolean exist = null != this.orgUserService.findById(orgUser.getId());
		if (!exist) { // create new record
			int res = this.orgUserService.insert(orgUser);
			if (res > 0) {
				errorMsg = String.format("机构用户创建成功！用户ID[%s] - 用户真名[%s]", orgUser.getId(), orgUser.getRealName());
				ret.setErrorCode(0);
				ret.setErrorMsg(errorMsg);
				logger.info(errorMsg);
				return ret;
			} else {
				errorMsg = String.format("机构用户创建失败！用户ID[%s] - 用户真名[%s]", orgUser.getId(), orgUser.getRealName());
				ret.setErrorCode(-1);
				ret.setErrorMsg(errorMsg);
				logger.info(errorMsg);
				return ret;
			}
		} else { // update existing record
			int res = this.orgUserService.update(orgUser);
			if (res > 0) {
				errorMsg = String.format("机构用户更新成功！用户ID[%s] - 用户真名[%s]", orgUser.getId(), orgUser.getRealName());
				ret.setErrorCode(0);
				ret.setErrorMsg(errorMsg);
				logger.info(errorMsg);
				return ret;
			} else {
				errorMsg = String.format("机构用户更新失败！用户ID[%s] - 用户真名[%s]", orgUser.getId(), orgUser.getRealName());
				ret.setErrorCode(-1);
				ret.setErrorMsg(errorMsg);
				logger.info(errorMsg);
				return ret;
			}
		}
	}
	
	/**
	 * 
	* @Title: resetPassword 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param id
	* @param @return  参数说明 
	* @return CommonReturnBean<Integer>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月10日 上午11:54:45
	 */
	@RequestMapping(value = "reset-password", method = {RequestMethod.GET, RequestMethod.POST})
	public CommonReturnBean<Integer> resetPassword(@RequestParam(value = "id", required = true) Integer id) {
		CommonReturnBean<Integer> ret = new CommonReturnBean<Integer>();
		String originalPsw = "11111";
		int change = this.orgUserService.updatePassword(id, originalPsw);
		if (change > 0) {
			ret.setErrorCode(0);
			ret.setErrorMsg(String.format("用户密码重设成功！用户ID[%s]", id));
		} else {
			ret.setErrorCode(-1);
			ret.setErrorMsg(String.format("用户密码重设失败！用户ID[%s]", id));
		}
		return ret;
	}

}
