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
import org.zxs.leader.control.dao.consts.IDicInfoConst;
import org.zxs.leader.control.dao.model.DictHeader;
import org.zxs.leader.control.dao.model.PrjMapLine;
import org.zxs.leader.control.dao.model.vo.output.EditOptionsOut;
import org.zxs.leader.control.dao.model.vo.output.OptionsOut;
import org.zxs.leader.control.dao.model.vo.output.rows.PrjMapLineRow;
import org.zxs.leader.control.service.interf.IDicInfoService;
import org.zxs.leader.control.service.interf.IHeaderService;
import org.zxs.leader.control.service.interf.IPrjInfoService;
import org.zxs.leader.control.service.interf.IPrjMapLineService;

import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/tables/prj-map-line")
@Api(tags="项目地图线表")
public class TablePrjMapLineController {
	
	private static final Log logger = LogFactory.getLog(TablePrjMapLineController.class);
	
	private static final String tableName = "prj_map_line";
	
	@Resource
	private IHeaderService headerService;
	
	@Resource
	private IDicInfoService dicInfoService;
	
	@Resource
	private IPrjMapLineService prjMapLineService;
	
	@Resource
	private IPrjInfoService prjInfoService;
	
	/**
	 * 
	* @Title: getPrjMapLineTableRows 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pageNum
	* @param @param pageSize
	* @param @return  参数说明 
	* @return DataTablesBean<PrjMapLineRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月19日 上午11:21:44
	 */
	@RequestMapping(value = "rows", method = {RequestMethod.GET, RequestMethod.POST})
	public DataTablesBean<PrjMapLineRow> getPrjMapLineTableRows(
			@RequestParam(required=false,value="pageNum", defaultValue="1") Integer pageNum, 
			@RequestParam(required=false,value="pageSize", defaultValue="10") Integer pageSize,
			@RequestParam(required = false, value = "keyword") String keyword) {
		PageInfo<PrjMapLineRow> pageInfo = this.prjMapLineService.getPrjMapLineOutsByPage(pageNum, pageSize, keyword);
		DataTablesBean<PrjMapLineRow> table = new DataTablesBean<>();
		table.setErrorCode(0);
		table.setData(pageInfo.getList());
		table.setRecordsTotal(pageInfo.getTotal());
		table.setRecordsFiltered(pageInfo.getTotal());
		return table;
	}
	
	/**
	 * 
	* @Title: getPrjMapLineTableCols 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<HashMap<String,Object>>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月19日 上午11:29:09
	 */
	@RequestMapping(value = "cols", method = {RequestMethod.GET, RequestMethod.POST})
	public List<HashMap<String, Object>> getPrjMapLineTableCols() {
		List<HashMap<String, Object>> headers = headerService.getHeadersByClassType(tableName, PrjMapLineRow.class);
		return headers;
	}
	
	/**
	 * 
	* @Title: getPrjMapLineTableOptions 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return EditOptionsOut    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月19日 上午11:33:02
	 */
	@RequestMapping(value = "edit-page", method = RequestMethod.GET)
	public EditOptionsOut getPrjMapLineTableOptions() {
		EditOptionsOut options = new EditOptionsOut();
		List<DictHeader> headers = this.headerService.getWebHeadersByTableName(tableName);
		if (!headers.isEmpty() || null != headers) {
			options.setHeaders(headers);
		}
		List<OptionsOut> prjTypeTrans = this.dicInfoService.getOptionsByType(IDicInfoConst.TYPE_PRJ_TYPE);
		if (!prjTypeTrans.isEmpty() || null != prjTypeTrans) {
			options.getOptions().put("prjTypeTrans", prjTypeTrans);
		}
		List<OptionsOut> prjIdTrans = this.prjInfoService.getAllPrjInfoOptions();
		if (!prjIdTrans.isEmpty() || null != prjIdTrans) {
			options.getOptions().put("prjIdTrans", prjIdTrans);
		}
		return options;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST, consumes = "application/json")
	public CommonReturnBean<Integer> prjMapLineTableUpdate(@RequestBody PrjMapLine prjMapLine) {
		CommonReturnBean<Integer> ret = new CommonReturnBean<>();
		if (null == prjMapLine) {
			ret.setErrorCode(-1);
			ret.setErrorMsg("请求对象为空。");
			logger.info("请求对象为空。");
			return ret;
		}
		boolean exist = null != this.prjMapLineService.findById(prjMapLine.getId());
		// id不存在，新增记录
		if (!exist) {
			boolean inserted = this.prjMapLineService.insert(prjMapLine) > 0 ? true : false;
			if (inserted) { // 新增成功
				ret.setErrorCode(0);
				ret.setErrorMsg(String.format("新增项目地图线成功！ID[%s]", prjMapLine.getId()));
				logger.info(String.format("新增项目地图线成功！ID[%s]", prjMapLine.getId()));
				return ret;
			} else {
				ret.setErrorCode(-1);
				ret.setErrorMsg(String.format("新增项目地图线失败！ID[%s]", prjMapLine.getId()));
				logger.info(String.format("新增项目地图线失败！ID[%s]", prjMapLine.getId()));
				return ret;
			}
		} else { // id存在，根据id更新记录
			boolean updated = this.prjMapLineService.update(prjMapLine) > 0 ? true : false;
			if (updated) { // 更新成功
				ret.setErrorCode(0);
				ret.setErrorMsg(String.format("更新项目地图线成功！ID[%s]", prjMapLine.getId()));
				logger.info(String.format("更新项目地图线成功！ID[%s]", prjMapLine.getId()));
				return ret;
			} else {
				ret.setErrorCode(-1);
				ret.setErrorMsg(String.format("更新项目地图线失败！ID[%s]", prjMapLine.getId()));
				logger.info(String.format("更新项目地图线失败！ID[%s]", prjMapLine.getId()));
				return ret;
			}
		}
	}

}
