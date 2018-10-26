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
import org.zxs.leader.control.dao.model.PrjPoint;
import org.zxs.leader.control.dao.model.vo.output.EditOptionsOut;
import org.zxs.leader.control.dao.model.vo.output.OptionsOut;
import org.zxs.leader.control.dao.model.vo.output.rows.PrjPointRow;
import org.zxs.leader.control.service.interf.IDicInfoService;
import org.zxs.leader.control.service.interf.IHeaderService;
import org.zxs.leader.control.service.interf.IPrjMapLineService;
import org.zxs.leader.control.service.interf.IPrjPointService;

import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/tables/prj-point")
@Api(tags="项目地图点坐标表")
public class TablePrjPointController {

	private static final Log logger = LogFactory.getLog(TablePrjPointController.class);
	
	private static final String tableName = "prj_point";

	@Resource
	private IHeaderService headerService;
	
	@Resource
	private IDicInfoService dicInfoService;
	
	@Resource
	private IPrjPointService prjPointService;
	
	@Resource
	private IPrjMapLineService prjMapLineService;
	
	/**
	 * 
	* @Title: getPrjPointTableRows 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pageNum
	* @param @param pageSize
	* @param @return  参数说明 
	* @return DataTablesBean<PrjPointRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月19日 下午3:03:27
	 */
	@RequestMapping(value = "rows", method = {RequestMethod.GET, RequestMethod.POST})
	public DataTablesBean<PrjPointRow> getPrjPointTableRows(
			@RequestParam(required=false,value="pageNum", defaultValue="1") Integer pageNum, 
			@RequestParam(required=false,value="pageSize", defaultValue="10") Integer pageSize,
			@RequestParam(required = false, value = "keyword") String keyword) {
		PageInfo<PrjPointRow> pageInfo = this.prjPointService.getPrjPointOutsByPage(pageNum, pageSize, keyword);
		DataTablesBean<PrjPointRow> table = new DataTablesBean<>();
		table.setErrorCode(0);
		table.setData(pageInfo.getList());
		table.setRecordsTotal(pageInfo.getTotal());
		table.setRecordsFiltered(pageInfo.getTotal());
		return table;
	}
	
	/**
	 * 
	* @Title: getPrjPointTableCols 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<HashMap<String,Object>>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月19日 下午3:04:02
	 */
	@RequestMapping(value = "cols", method = {RequestMethod.GET, RequestMethod.POST})
	public List<HashMap<String, Object>> getPrjPointTableCols() {
		List<HashMap<String, Object>> headers = headerService.getHeadersByClassType(tableName, PrjPointRow.class);
		return headers;
	}
	
	/**
	 * 
	* @Title: getPrjPointTableOptions 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return EditOptionsOut    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月19日 下午3:07:53
	 */
	@RequestMapping(value = "edit-page", method = RequestMethod.GET)
	public EditOptionsOut getPrjPointTableOptions() {
		EditOptionsOut options = new EditOptionsOut();
		List<DictHeader> headers = this.headerService.getWebHeadersByTableName(tableName);
		if (!headers.isEmpty() || null != headers) {
			options.setHeaders(headers);
		}
		List<OptionsOut> prjLineIdTrans = this.prjMapLineService.getOptions();
		if (!prjLineIdTrans.isEmpty() || null != prjLineIdTrans) {
			options.getOptions().put("prjLineIdTrans", prjLineIdTrans);
		}
		return options;
	}
	
	/**
	 * 
	* @Title: prjPointTableUpdate 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param prjPoint
	* @param @return  参数说明 
	* @return CommonReturnBean<Integer>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月1日 上午11:07:23
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST, consumes = "application/json")
	public CommonReturnBean<Integer> prjPointTableUpdate(@RequestBody PrjPoint prjPoint) {
		CommonReturnBean<Integer> ret = new CommonReturnBean<>();
		if (null == prjPoint) {
			ret.setErrorCode(-1);
			ret.setErrorMsg("请求对象为空。");
			logger.info("请求对象为空。");
			return ret;
		}
		boolean exist = null != this.prjPointService.findById(prjPoint.getId());
		// id不存在，新增记录
		if (!exist) {
			boolean inserted = this.prjPointService.insert(prjPoint) > 0 ? true : false;
			if (inserted) { // 新增成功
				ret.setErrorCode(0);
				ret.setErrorMsg(String.format("新增地图点坐标成功！ID[%s]", prjPoint.getId()));
				logger.info(String.format("新增地图点坐标成功！ID[%s]", prjPoint.getId()));
				return ret;
			} else {
				ret.setErrorCode(-1);
				ret.setErrorMsg(String.format("新增地图点坐标失败！ID[%s]", prjPoint.getId()));
				logger.info(String.format("新增地图点坐标失败！ID[%s]", prjPoint.getId()));
				return ret;
			}
		} else { // id存在，根据id更新记录
			boolean updated = this.prjPointService.update(prjPoint) > 0 ? true : false;
			if (updated) { // 更新成功
				ret.setErrorCode(0);
				ret.setErrorMsg(String.format("更新地图点坐标成功！ID[%s]", prjPoint.getId()));
				logger.info(String.format("更新地图点坐标成功！ID[%s]", prjPoint.getId()));
				return ret;
			} else {
				ret.setErrorCode(-1);
				ret.setErrorMsg(String.format("更新地图点坐标失败！ID:%s", prjPoint.getId()));
				logger.info(String.format("更新地图点坐标失败！ID:%s", prjPoint.getId()));
				return ret;
			}
		}
	}
	
}
