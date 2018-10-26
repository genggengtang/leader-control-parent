package org.zxs.leader.control.admin.controller.tables;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zxs.base.model.DataTablesBean;
import org.zxs.leader.control.dao.model.DictHeader;
import org.zxs.leader.control.dao.model.vo.output.EditOptionsOut;
import org.zxs.leader.control.dao.model.vo.output.OptionsOut;
import org.zxs.leader.control.dao.model.vo.output.rows.TopicPicRow;
import org.zxs.leader.control.service.interf.IChatGroupInfoService;
import org.zxs.leader.control.service.interf.IDicInfoService;
import org.zxs.leader.control.service.interf.IHeaderService;
import org.zxs.leader.control.service.interf.IOrgUserService;
import org.zxs.leader.control.service.interf.ITopicPicService;

import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;

@RequestMapping("/tables/topic-pic")
@RestController
@Api(tags="随手拍主题表")
public class TableTopicPicController {

	private static final Log logger = LogFactory.getLog(TableTopicPicController.class);
	
	private static final String tableName = "topic_pic";
	
	@Resource
	private IHeaderService headerService;
	
	@Resource
	private IDicInfoService dicInfoService;
	
	@Resource
	private ITopicPicService topicPicService;
	
	@Resource
	private IOrgUserService orgUserService;
	
	@Resource
	private IChatGroupInfoService chatGroupInfoService;
	
	/**
	 * 
	* @Title: getTopicPicTableRows 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pageNum
	* @param @param pageSize
	* @param @return  参数说明 
	* @return DataTablesBean<TopicPicRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月19日 下午4:23:51
	 */
	@RequestMapping(value = "rows", method = {RequestMethod.GET, RequestMethod.POST})
	public DataTablesBean<TopicPicRow> getTopicPicTableRows(
			@RequestParam(required=false,value="pageNum", defaultValue="1") Integer pageNum, 
			@RequestParam(required=false,value="pageSize", defaultValue="10") Integer pageSize,
			@RequestParam(required=false, value="keyword") String keyword) {
		PageInfo<TopicPicRow> pageInfo = this.topicPicService.getTopicPicOutsByPage(pageNum, pageSize, keyword);
		DataTablesBean<TopicPicRow> table = new DataTablesBean<>();
		table.setErrorCode(0);
		table.setData(pageInfo.getList());
		table.setRecordsTotal(pageInfo.getTotal());
		table.setRecordsFiltered(pageInfo.getTotal());
		return table;
	}
	
	/**
	 * 
	* @Title: getTopicPicTableCols 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<HashMap<String,Object>>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月19日 下午4:31:53
	 */
	@RequestMapping(value = "cols", method = {RequestMethod.GET, RequestMethod.POST})
	public List<HashMap<String, Object>> getTopicPicTableCols() {
		List<HashMap<String, Object>> headers = headerService.getHeadersByClassType(tableName, TopicPicRow.class);
		return headers;
	}
	
	/**
	 * 
	* @Title: getTopicPicTableOptions 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return EditOptionsOut    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月19日 下午4:32:53
	 */
	@RequestMapping(value = "edit-page", method = RequestMethod.GET)
	public EditOptionsOut getTopicPicTableOptions() {
		EditOptionsOut options = new EditOptionsOut();
		List<DictHeader> headers = this.headerService.getWebHeadersByTableName(tableName);
		if (!headers.isEmpty() || null != headers) {
			options.setHeaders(headers);
		}
		List<OptionsOut> sendUserIdTrans = this.orgUserService.getAllUserIdOpts();
		if (!sendUserIdTrans.isEmpty() || null != sendUserIdTrans) {
			options.getOptions().put("sendUserIdTrans", sendUserIdTrans);
		}
		List<OptionsOut> receiveCgIdTrans = this.chatGroupInfoService.getAllchatGroupInfoOptions();
		if (!receiveCgIdTrans.isEmpty() || null != receiveCgIdTrans) {
			options.getOptions().put("receiveCgIdTrans", receiveCgIdTrans);
		}
		return options;
	}

}
