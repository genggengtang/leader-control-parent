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
import org.zxs.leader.control.dao.model.ChatGroupUser;
import org.zxs.leader.control.dao.model.DictHeader;
import org.zxs.leader.control.dao.model.vo.output.EditOptionsOut;
import org.zxs.leader.control.dao.model.vo.output.OptionsOut;
import org.zxs.leader.control.dao.model.vo.output.rows.ChatGroupUserRow;
import org.zxs.leader.control.service.interf.IChatGroupInfoService;
import org.zxs.leader.control.service.interf.IChatGroupUserService;
import org.zxs.leader.control.service.interf.IDicInfoService;
import org.zxs.leader.control.service.interf.IHeaderService;

import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/tables/chat-group-user")
@Api(tags="群聊用户表")
public class TableChatGroupUserController {
	
	private static final Log logger = LogFactory.getLog(TableChatGroupUserController.class);
	
	private static final String tableName = "chat_group_user";
	
	@Resource
	private IChatGroupUserService chatGroupUserService;
	
	@Resource
	private IChatGroupInfoService chatGroupInfoService;
	
	@Resource
	private IHeaderService headerService;
	
	@Resource
	private IDicInfoService dicInfoService;
	
	/**
	 * 
	* @Title: getChatGroupUserTableRows 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pageNum
	* @param @param pageSize
	* @param @param keyword
	* @param @return  参数说明 
	* @return DataTablesBean<ChatGroupUserRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月16日 下午12:09:34
	 */
	@RequestMapping(value = "rows", method = {RequestMethod.GET, RequestMethod.POST})
	public DataTablesBean<ChatGroupUserRow> getChatGroupUserTableRows(
			@RequestParam(required=false,value="pageNum", defaultValue="1") Integer pageNum, 
			@RequestParam(required=false,value="pageSize", defaultValue="10") Integer pageSize,
			@RequestParam(required=false, value="keyword") String keyword) {
		PageInfo<ChatGroupUserRow> pageInfo = this.chatGroupUserService.getChatGroupUserOutsByPage(pageNum, pageSize, keyword);
		DataTablesBean<ChatGroupUserRow> table = new DataTablesBean<>();
		table.setErrorCode(0);
		table.setData(pageInfo.getList());
		table.setRecordsTotal(pageInfo.getTotal());
		table.setRecordsFiltered(pageInfo.getTotal());
		return table;
	}
	
	/**
	 * 
	* @Title: getChatGroupUserTableCols 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<HashMap<String,Object>>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月16日 下午12:09:57
	 */
	@RequestMapping(value = "cols", method = {RequestMethod.GET, RequestMethod.POST})
	public List<HashMap<String, Object>> getChatGroupUserTableCols() {
		List<HashMap<String, Object>> headers = headerService.getHeadersByClassType(tableName, ChatGroupUserRow.class);
		return headers;
	}
	
	/**
	 * 
	* @Title: getChatGroupUserTableOptions 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return EditOptionsOut    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月16日 下午2:53:23
	 */
	@RequestMapping(value = "edit-page", method = RequestMethod.GET)
	public EditOptionsOut getChatGroupUserTableOptions() {
		EditOptionsOut options = new EditOptionsOut();
		List<DictHeader> headers = this.headerService.getWebHeadersByTableName(tableName);
		if (!headers.isEmpty() || null != headers) {
			options.setHeaders(headers);
		}
		List<OptionsOut> chatGroupIdTrans = this.chatGroupInfoService.getAllchatGroupInfoOptions();
		if (!chatGroupIdTrans.isEmpty() || null != chatGroupIdTrans) {
			options.getOptions().put("chatGroupIdTrans", chatGroupIdTrans);
		}
		return options;
	}
	
	/**
	 * 
	* @Title: chatGroupUserTableUpdate 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param chatGroupUser
	* @param @return  参数说明 
	* @return CommonReturnBean<Integer>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月31日 上午8:50:32
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST, consumes = "application/json")
	public CommonReturnBean<Integer> chatGroupUserTableUpdate(@RequestBody ChatGroupUser chatGroupUser) {
		CommonReturnBean<Integer> ret = new CommonReturnBean<>();
		if (null == chatGroupUser) {
			ret.setErrorCode(-1);
			ret.setErrorMsg("请求对象为空。");
			logger.info("请求对象为空。");
			return ret;
		}
		boolean exist = null != this.chatGroupUserService.findById(chatGroupUser.getId());
		// id存在，依据id更新记录
		if (exist) {
			boolean updated = this.chatGroupUserService.update(chatGroupUser) > 0 ? true : false;
			if (updated) { // 更新成功
				ret.setErrorCode(0);
				ret.setErrorMsg(String.format("更新群聊用户表成功！ID:%s", chatGroupUser.getId()));
				logger.info(String.format("更新群聊用户表成功！[%s]", chatGroupUser));
				return ret;
			} else {
				ret.setErrorCode(-1);
				ret.setErrorMsg(String.format("更新群聊用户表失败！ID:%s", chatGroupUser.getId()));
				logger.info(String.format("更新群聊用户表失败！[%s]", chatGroupUser));
				return ret;
			}
		}
		ret.setErrorCode(-1);
		ret.setErrorMsg(String.format("更新群聊用户表失败！ID:%s", chatGroupUser.getId()));
		logger.info(String.format("更新群聊用户表失败！[%s]", chatGroupUser));
		return ret;
	}

}
