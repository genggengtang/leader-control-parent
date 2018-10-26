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
import org.zxs.leader.control.dao.model.WorkInfo;
import org.zxs.leader.control.dao.model.vo.output.EditOptionsOut;
import org.zxs.leader.control.service.interf.IDicInfoService;
import org.zxs.leader.control.service.interf.IHeaderService;
import org.zxs.leader.control.service.interf.IWorkInfoService;

import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;

@RequestMapping("/tables/work-info/")
@RestController
@Api(tags="工作信息接口")
public class TableWorkInfoController {
	
	private static final Log logger = LogFactory.getLog(TableWorkInfoController.class);
	
	private static final String tableName = "work_info";
	
	@Resource
	private IWorkInfoService workInfoService;
	
	@Resource
	private IHeaderService headerService;
	
	@Resource
	private IDicInfoService dicInfoService;
	
	/**
	 * 
	* @Title: getWorkInfoTableRows 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pageNum
	* @param @param pageSize
	* @param @return  参数说明 
	* @return DataTablesBean<WorkInfo>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月19日 下午3:51:02
	 */
	@RequestMapping(value = "rows", method = {RequestMethod.GET, RequestMethod.POST})
	public DataTablesBean<WorkInfo> getWorkInfoTableRows(
			@RequestParam(required=false,value="pageNum", defaultValue="1") Integer pageNum, 
			@RequestParam(required=false,value="pageSize", defaultValue="10") Integer pageSize,
			@RequestParam(required=false, value="keyword") String keyword) {
		PageInfo<WorkInfo> pageInfo = this.workInfoService.getAllWorkInfoByPage(pageNum, pageSize, keyword);
		DataTablesBean<WorkInfo> table = new DataTablesBean<>();
		table.setErrorCode(0);
		table.setData(pageInfo.getList());
		table.setRecordsTotal(pageInfo.getTotal());
		table.setRecordsFiltered(pageInfo.getTotal());
		return table;
	}
	
	/**
	 * 
	* @Title: getWorkInfoTableCols 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<HashMap<String,Object>>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月19日 下午3:53:39
	 */
	@RequestMapping(value = "cols", method = {RequestMethod.GET, RequestMethod.POST})
	public List<HashMap<String, Object>> getWorkInfoTableCols() {
		List<HashMap<String, Object>> headers = headerService.getHeadersByClassType(tableName, WorkInfo.class);
		return headers;
	}
	
	/**
	 * 
	* @Title: getWorkInfoTableOptions 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return EditOptionsOut    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月19日 下午3:54:12
	 */
	@RequestMapping(value = "edit-page", method = RequestMethod.GET)
	public EditOptionsOut getWorkInfoTableOptions() {
		EditOptionsOut options = new EditOptionsOut();
		List<DictHeader> headers = this.headerService.getWebHeadersByTableName(tableName);
		if (!headers.isEmpty() || null != headers) {
			options.setHeaders(headers);
		}
		return options;
	}
	
	/**
	 * 
	* @Title: workInfoTableUpdate 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param workInfo
	* @param @return  参数说明 
	* @return CommonReturnBean<Integer>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月3日 上午11:51:38
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST, consumes = "application/json")
	public CommonReturnBean<Integer> workInfoTableUpdate(@RequestBody WorkInfo workInfo) {
		CommonReturnBean<Integer> ret = new CommonReturnBean<>();
		if (null == workInfo) {
			ret.setErrorCode(-1);
			ret.setErrorMsg("请求对象为空。");
			logger.info("请求对象为空。");
			return ret;
		}
		boolean exist = null != this.workInfoService.findById(workInfo.getId());
		// id不存在，新增记录
		if (!exist) {
			boolean inserted = this.workInfoService.insert(workInfo) > 0 ? true : false;
			if (inserted) { // 新增成功
				ret.setErrorCode(0);
				ret.setErrorMsg(String.format("新增工作资讯成功！ID:%s", workInfo.getId()));
				logger.info(String.format("新增工作资讯成功！ID:%s", workInfo.getId()));
				return ret;
			} else {
				ret.setErrorCode(-1);
				ret.setErrorMsg(String.format("新增工作资讯失败！ID:%s", workInfo.getId()));
				logger.info(String.format("新增工作资讯失败！ID:%s", workInfo.getId()));
				return ret;
			}
		} else { // id存在，根据id更新记录
			boolean updated = this.workInfoService.update(workInfo) > 0 ? true : false;
			if (updated) { // 更新成功
				ret.setErrorCode(0);
				ret.setErrorMsg(String.format("更新工作资讯成功！ID:%s", workInfo.getId()));
				logger.info(String.format("更新工作资讯成功！ID:%s", workInfo.getId()));
				return ret;
			} else {
				ret.setErrorCode(-1);
				ret.setErrorMsg(String.format("更新工作资讯失败！ID:%s", workInfo.getId()));
				logger.info(String.format("更新工作资讯失败！ID:%s", workInfo.getId()));
				return ret;
			}
		}
	}

}
