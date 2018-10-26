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
import org.zxs.leader.control.dao.model.vo.output.rows.TopicCommentRow;
import org.zxs.leader.control.service.interf.IDicInfoService;
import org.zxs.leader.control.service.interf.IHeaderService;
import org.zxs.leader.control.service.interf.IOrgUserService;
import org.zxs.leader.control.service.interf.ITopicCommentService;

import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;

@RequestMapping("/tables/topic-comment")
@RestController
@Api(tags="随手拍评论表")
public class TableTopicCommentController {
	
	private static final Log logger = LogFactory.getLog(TableTopicCommentController.class);
	
	private static final String tableName = "topic_comment";
	
	@Resource
	private IHeaderService headerService;
	
	@Resource
	private IDicInfoService dicInfoService;
	
	@Resource
	private ITopicCommentService topicCommentService;
	
	@Resource
	private IOrgUserService orgUserService;
	
	/**
	 * 
	* @Title: getTopicCommentTableRows 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pageNum
	* @param @param pageSize
	* @param @param keyword
	* @param @return  参数说明 
	* @return DataTablesBean<TopicCommentRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月19日 下午5:01:19
	 */
	@RequestMapping(value = "rows", method = {RequestMethod.GET, RequestMethod.POST})
	public DataTablesBean<TopicCommentRow> getTopicCommentTableRows(
			@RequestParam(required=false,value="pageNum", defaultValue="1") Integer pageNum, 
			@RequestParam(required=false,value="pageSize", defaultValue="10") Integer pageSize,
			@RequestParam(required=false, value="keyword") String keyword) {
		PageInfo<TopicCommentRow> pageInfo = this.topicCommentService.getTopicCommentVosByPage(pageNum, pageSize, keyword);
		DataTablesBean<TopicCommentRow> table = new DataTablesBean<>();
		table.setErrorCode(0);
		table.setData(pageInfo.getList());
		table.setRecordsTotal(pageInfo.getTotal());
		table.setRecordsFiltered(pageInfo.getTotal());
		return table;
	}
	
	/**
	 * 
	* @Title: getTopicCommentTableCols 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<HashMap<String,Object>>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月19日 下午5:06:06
	 */
	@RequestMapping(value = "cols", method = {RequestMethod.GET, RequestMethod.POST})
	public List<HashMap<String, Object>> getTopicCommentTableCols() {
		List<HashMap<String, Object>> headers = headerService.getHeadersByClassType(tableName, TopicCommentRow.class);
		return headers;
	}
	
	/**
	 * 
	* @Title: getTopicCommentTableOptions 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return EditOptionsOut    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月19日 下午5:07:08
	 */
	@RequestMapping(value = "edit-page", method = RequestMethod.GET)
	public EditOptionsOut getTopicCommentTableOptions() {
		EditOptionsOut options = new EditOptionsOut();
		List<DictHeader> headers = this.headerService.getWebHeadersByTableName(tableName);
		if (!headers.isEmpty() || null != headers) {
			options.setHeaders(headers);
		}
		List<OptionsOut> commentUserIdTrans = this.orgUserService.getAllUserIdOpts();
		if (!commentUserIdTrans.isEmpty() || null != commentUserIdTrans) {
			options.getOptions().put("commentUserIdTrans", commentUserIdTrans);
		}
		return options;
	}

}
