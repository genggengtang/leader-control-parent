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
import org.zxs.leader.control.dao.model.ChatGroupInfo;
import org.zxs.leader.control.dao.model.DictHeader;
import org.zxs.leader.control.dao.model.vo.output.EditOptionsOut;
import org.zxs.leader.control.dao.model.vo.output.OptionsOut;
import org.zxs.leader.control.dao.model.vo.output.rows.ChatGroupInfoRow;
import org.zxs.leader.control.service.interf.IChatGroupInfoService;
import org.zxs.leader.control.service.interf.IDicInfoService;
import org.zxs.leader.control.service.interf.IHeaderService;
import org.zxs.leader.control.service.interf.IPrjInfoService;

import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;

@RequestMapping("/tables/chat-group-info")
@RestController
@Api(tags="聊天群表")
public class TableChatGroupInfoController {
	
	private static final Log logger = LogFactory.getLog(TableChatGroupInfoController.class);
	
	private static final String tableName = "chat_group_info";
	
	@Resource
	private IChatGroupInfoService chatGroupInfoService;
	
	@Resource
	private IPrjInfoService prjInfoService;
	
	@Resource
	private IHeaderService headerService;
	
	@Resource
	private IDicInfoService dicInfoService;
	
	/**
	 * 
	* @Title: getChatGroupInfoTableRows 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pageNum
	* @param @param pageSize
	* @param @return  参数说明 
	* @return DataTablesBean<ChatGroupInfoRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月16日 上午11:01:03
	 */
	@RequestMapping(value = "rows", method = {RequestMethod.GET, RequestMethod.POST})
	public DataTablesBean<ChatGroupInfoRow> getChatGroupInfoTableRows(
			@RequestParam(required=false,value="pageNum", defaultValue="1") Integer pageNum, 
			@RequestParam(required=false,value="pageSize", defaultValue="10") Integer pageSize,
			@RequestParam(required=false, value="keyword") String keyword) {
		PageInfo<ChatGroupInfoRow> pageInfo = this.chatGroupInfoService.getChatGroupInfoOutsByPage(pageNum, pageSize, keyword);
		DataTablesBean<ChatGroupInfoRow> table = new DataTablesBean<>();
		table.setErrorCode(0);
		table.setData(pageInfo.getList());
		table.setRecordsTotal(pageInfo.getTotal());
		table.setRecordsFiltered(pageInfo.getTotal());
		return table;
	}
	
	/**
	 * 
	* @Title: getChatGroupInfoTableCols 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<HashMap<String,Object>>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月16日 上午11:28:24
	 */
	@RequestMapping(value = "cols", method = {RequestMethod.GET, RequestMethod.POST})
	public List<HashMap<String, Object>> getChatGroupInfoTableCols() {
		List<HashMap<String, Object>> headers = headerService.getHeadersByClassType(tableName, ChatGroupInfoRow.class);
		return headers;
	}
	
	/**
	 * 
	* @Title: getChatGroupInfoTableOptions 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return EditOptionsOut    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月16日 上午11:29:06
	 */
	@RequestMapping(value = "edit-page", method = RequestMethod.GET)
	public EditOptionsOut getChatGroupInfoTableOptions() {
		EditOptionsOut options = new EditOptionsOut();
		List<DictHeader> headers = this.headerService.getWebHeadersByTableName(tableName);
		if (!headers.isEmpty() || null != headers) {
			options.setHeaders(headers);
		}
		List<OptionsOut> prjTypeTrans = this.dicInfoService.getOptionsByType(214); // prj_type
		if (!prjTypeTrans.isEmpty() || null != prjTypeTrans) {
			options.getOptions().put("prjTypeTrans", prjTypeTrans);
		}
		List<OptionsOut> prjIdTrans = this.prjInfoService.getAllPrjInfoOptions();
		if (!prjIdTrans.isEmpty() || null != prjIdTrans) {
			options.getOptions().put("prjIdTrans", prjIdTrans);
		}
		return options;
	}
	
	/**
	 * 
	* @Title: chatGroupInfoTableUpdate 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param chatGroupInfo
	* @param @return  参数说明 
	* @return CommonReturnBean<Integer>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月31日 上午8:50:42
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST, consumes = "application/json")
	public CommonReturnBean<Integer> chatGroupInfoTableUpdate(@RequestBody ChatGroupInfo chatGroupInfo) {
		CommonReturnBean<Integer> ret = new CommonReturnBean<>();
		if (null == chatGroupInfo) {
			ret.setErrorCode(-1);
			ret.setErrorMsg("请求对象为空。");
			logger.info("请求对象为空。");
			return ret;
		}
		boolean exist = null != this.chatGroupInfoService.findById(chatGroupInfo.getId());
		
		// id存在，依据id更新记录
		if (exist) {
			boolean updated = this.chatGroupInfoService.update(chatGroupInfo) > 0 ? true : false;
			if (updated) { // 更新成功
				ret.setErrorCode(0);
				ret.setErrorMsg(String.format("更新对象成功！ID:%s", chatGroupInfo.getId()));
				logger.info(String.format("更新对象成功！ID:%s", chatGroupInfo.getId()));
				return ret;
			} else {
				ret.setErrorCode(-1);
				ret.setErrorMsg(String.format("更新对象失败！ID:%s", chatGroupInfo.getId()));
				logger.info(String.format("更新对象失败！ID:%s", chatGroupInfo.getId()));
				return ret;
			}
		}
		ret.setErrorCode(-1);
		ret.setErrorMsg(String.format("更新对象失败！ID:%s", chatGroupInfo.getId()));
		logger.info(String.format("更新对象失败！ID:%s", chatGroupInfo.getId()));
		return ret;
	}

}
