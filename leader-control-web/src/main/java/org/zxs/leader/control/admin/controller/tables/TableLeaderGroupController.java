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
import org.zxs.leader.control.dao.model.LeaderGroup;
import org.zxs.leader.control.dao.model.vo.output.EditOptionsOut;
import org.zxs.leader.control.dao.model.vo.output.OptionsOut;
import org.zxs.leader.control.dao.model.vo.output.rows.LeaderGroupRow;
import org.zxs.leader.control.service.interf.IChatGroupInfoService;
import org.zxs.leader.control.service.interf.IDicInfoService;
import org.zxs.leader.control.service.interf.IHeaderService;
import org.zxs.leader.control.service.interf.ILeaderGroupService;
import org.zxs.leader.control.service.interf.IOrgUserService;

import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/tables/leader-group")
@Api(tags="服务队表")
public class TableLeaderGroupController {
	
	private static final Log logger = LogFactory.getLog(TableLeaderGroupController.class);
	
	private static final String tableName = "leader_group";
	
	@Resource
	private ILeaderGroupService leaderGroupService;
	
	@Resource
	private IChatGroupInfoService chatGroupInfoService;
	
	@Resource
	private IOrgUserService orgUserService;
	
	@Resource
	private IHeaderService headerService;
	
	@Resource
	private IDicInfoService dicInfoService;
	
	/**
	 * 
	* @Title: getLeaderGroupTableRows 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pageNum
	* @param @param pageSize
	* @param @return  参数说明 
	* @return DataTablesBean<LeaderGroupRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月16日 下午5:35:08
	 */
	@RequestMapping(value = "rows", method = {RequestMethod.GET, RequestMethod.POST})
	public DataTablesBean<LeaderGroupRow> getLeaderGroupTableRows(
			@RequestParam(required=false,value="pageNum", defaultValue="1") Integer pageNum, 
			@RequestParam(required=false,value="pageSize", defaultValue="10") Integer pageSize,
			@RequestParam(required=false, value="keyword") String keyword) {
		PageInfo<LeaderGroupRow> pageInfo = this.leaderGroupService.getLeaderGroupRowsByPage(pageNum, pageSize, keyword);
		DataTablesBean<LeaderGroupRow> table = new DataTablesBean<>();
		table.setErrorCode(0);
		table.setData(pageInfo.getList());
		table.setRecordsTotal(pageInfo.getTotal());
		table.setRecordsFiltered(pageInfo.getTotal());
		return table;
	}
	
	/**
	 * 
	* @Title: getLeaderGroupTableCols 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<HashMap<String,Object>>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月16日 下午5:44:32
	 */
	@RequestMapping(value = "cols", method = {RequestMethod.GET, RequestMethod.POST})
	public List<HashMap<String, Object>> getLeaderGroupTableCols() {
		List<HashMap<String, Object>> headers = headerService.getHeadersByClassType(tableName, LeaderGroupRow.class);
		return headers;
	}
	
	/**
	 * 
	* @Title: getLeaderGroupTableOptions 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return EditOptionsOut    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月16日 下午5:45:06
	 */
	@RequestMapping(value = "edit-page", method = RequestMethod.GET)
	public EditOptionsOut getLeaderGroupTableOptions() {
		EditOptionsOut options = new EditOptionsOut();
		List<DictHeader> headers = this.headerService.getWebHeadersByTableName(tableName);
		if (!headers.isEmpty() || null != headers) {
			options.setHeaders(headers);
		}
		List<OptionsOut> cgIdTrans = this.chatGroupInfoService.getAllchatGroupInfoOptions();
		if (!cgIdTrans.isEmpty() || null != cgIdTrans) {
			options.getOptions().put("cgIdTrans", cgIdTrans);
		}
		List<OptionsOut> userIdTrans = this.orgUserService.getAllUserIdOpts();
		if (!userIdTrans.isEmpty() || null != userIdTrans) {
			options.getOptions().put("userIdTrans", userIdTrans);
		}
		return options;
	}
	
	/**
	 * 
	* @Title: leaderGroupTableUpdate 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param leaderGroup
	* @param @return  参数说明 
	* @return CommonReturnBean<Integer>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月31日 下午5:45:22
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST, consumes = "application/json")
	public CommonReturnBean<Integer> leaderGroupTableUpdate(@RequestBody LeaderGroup leaderGroup) {
		CommonReturnBean<Integer> ret = new CommonReturnBean<>();
		if (null == leaderGroup) {
			ret.setErrorCode(-1);
			ret.setErrorMsg("请求对象为空。");
			logger.info("请求对象为空。");
			return ret;
		}
		boolean exist = null != this.leaderGroupService.findById(leaderGroup.getId());
		// id不存在，新增记录
		if (!exist) {
			boolean inserted = this.leaderGroupService.insert(leaderGroup) > 0 ? true : false;
			if (inserted) { // 新增成功
				ret.setErrorCode(0);
				ret.setErrorMsg(String.format("新增成功！ID[%s] - 名称[%s]", leaderGroup.getId(), leaderGroup.getName()));
				logger.info(String.format("新增成功！ID[%s] - 名称[%s]", leaderGroup.getId()));
				return ret;
			} else {
				ret.setErrorCode(-1);
				ret.setErrorMsg(String.format("新增失败！ID[%s] - 名称[%s]", leaderGroup.getId(), leaderGroup.getName()));
				logger.info(String.format("新增失败！ID[%s] - 名称[%s]", leaderGroup.getId(), leaderGroup.getName()));
				return ret;
			}
		} else { // id存在，根据id更新记录
			boolean updated = this.leaderGroupService.update(leaderGroup) > 0 ? true : false;
			if (updated) { // 更新成功
				ret.setErrorCode(0);
				ret.setErrorMsg(String.format("更新成功！ID[%s] - 名称[%s]", leaderGroup.getId(), leaderGroup.getName()));
				logger.info(String.format("更新成功！ID[%s] - 名称[%s]", leaderGroup.getId(), leaderGroup.getName()));
				return ret;
			} else {
				ret.setErrorCode(-1);
				ret.setErrorMsg(String.format("更新失败！ID[%s] - 名称[%s]", leaderGroup.getId(), leaderGroup.getName()));
				logger.info(String.format("更新失败！ID[%s] - 名称[%s]", leaderGroup.getId(), leaderGroup.getName()));
				return ret;
			}
		}
	}

}
