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
import org.zxs.leader.control.dao.model.PrjProve;
import org.zxs.leader.control.dao.model.vo.output.EditOptionsOut;
import org.zxs.leader.control.dao.model.vo.output.OptionsOut;
import org.zxs.leader.control.dao.model.vo.output.rows.PrjProveRow;
import org.zxs.leader.control.service.interf.IDicInfoService;
import org.zxs.leader.control.service.interf.IHeaderService;
import org.zxs.leader.control.service.interf.IPrjInfoService;
import org.zxs.leader.control.service.interf.IPrjProveService;

import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;

@RequestMapping("/tables/prj-prove")
@RestController
@Api(tags="项目审批表")
public class TablePrjProveController {
	
	private static final Log logger = LogFactory.getLog(TablePrjProveController.class);
	
	private static final String tableName = "prj_prove";
	
	@Resource
	private IHeaderService headerService;
	
	@Resource
	private IDicInfoService dicInfoService;
	
	@Resource
	private IPrjProveService prjProveService;
	
	@Resource
	private IPrjInfoService prjInfoService;
	
	/**
	 * 
	* @Title: getPrjProveTableRows 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pageNum
	* @param @param pageSize
	* @param @return  参数说明 
	* @return DataTablesBean<PrjProveRow>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月19日 下午3:27:40
	 */
	@RequestMapping(value = "rows", method = {RequestMethod.GET, RequestMethod.POST})
	public DataTablesBean<PrjProveRow> getPrjProveTableRows(
			@RequestParam(required=false,value="pageNum", defaultValue="1") Integer pageNum, 
			@RequestParam(required=false,value="pageSize", defaultValue="10") Integer pageSize,
			@RequestParam(required = false, value = "keyword") String keyword) {
		PageInfo<PrjProveRow> pageInfo = this.prjProveService.getPrjProveOutsByPage(pageNum, pageSize, keyword);
		DataTablesBean<PrjProveRow> table = new DataTablesBean<>();
		table.setErrorCode(0);
		table.setData(pageInfo.getList());
		table.setRecordsTotal(pageInfo.getTotal());
		table.setRecordsFiltered(pageInfo.getTotal());
		return table;
	}
	
	/**
	 * 
	* @Title: getPrjProveTableCols 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return List<HashMap<String,Object>>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月19日 下午3:36:28
	 */
	@RequestMapping(value = "cols", method = {RequestMethod.GET, RequestMethod.POST})
	public List<HashMap<String, Object>> getPrjProveTableCols() {
		List<HashMap<String, Object>> headers = headerService.getHeadersByClassType(tableName, PrjProveRow.class);
		return headers;
	}
	
	/**
	 * 
	* @Title: getPrjProveTableOptions 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return EditOptionsOut    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月19日 下午3:37:22
	 */
	@RequestMapping(value = "edit-page", method = RequestMethod.GET)
	public EditOptionsOut getPrjProveTableOptions() {
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
		List<OptionsOut> typeTrans = this.dicInfoService.getOptionsByType(IDicInfoConst.TYPE_PROVE_TYPE);
		if (!typeTrans.isEmpty() || null != typeTrans) {
			options.getOptions().put("typeTrans", typeTrans);
		}
		return options;
	}
	
	/**
	 * 
	* @Title: prjProveTableUpdate 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param prjProve
	* @param @return  参数说明 
	* @return CommonReturnBean<Integer>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月3日 上午10:24:59
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST, consumes = "application/json")
	public CommonReturnBean<Integer> prjProveTableUpdate(@RequestBody PrjProve prjProve) {
		CommonReturnBean<Integer> ret = new CommonReturnBean<>();
		if (null == prjProve) {
			ret.setErrorCode(-1);
			ret.setErrorMsg("请求对象为空。");
			logger.info("请求对象为空。");
			return ret;
		}
		boolean exist = null != this.prjProveService.findById(prjProve.getId());
		// id不存在，新增记录
		if (!exist) {
			boolean inserted = this.prjProveService.insert(prjProve) > 0 ? true : false;
			if (inserted) { // 新增成功
				ret.setErrorCode(0);
				ret.setErrorMsg(String.format("新增项目审批表成功！ID[%s] - Name[%s]", prjProve.getId(), prjProve.getName()));
				logger.info(String.format("新增项目审批表成功！ID[%s] - Name[%s]", prjProve.getId(), prjProve.getName()));
				return ret;
			} else {
				ret.setErrorCode(-1);
				ret.setErrorMsg(String.format("新增项目审批表失败！ID[%s] - Name[%s]", prjProve.getId(), prjProve.getName()));
				logger.info(String.format("新增项目审批表失败！ID[%s] - Name[%s]", prjProve.getId(), prjProve.getName()));
				return ret;
			}
		} else { // id存在，根据id更新记录
			boolean updated = this.prjProveService.update(prjProve) > 0 ? true : false;
			if (updated) { // 更新成功
				ret.setErrorCode(0);
				ret.setErrorMsg(String.format("更新项目审批表成功！ID[%s] - Name[%s]", prjProve.getId(), prjProve.getName()));
				logger.info(String.format("更新项目审批表成功！ID[%s] - Name[%s]", prjProve.getId(), prjProve.getName()));
				return ret;
			} else {
				ret.setErrorCode(-1);
				ret.setErrorMsg(String.format("更新项目审批表失败！ID[%s] - Name[%s]", prjProve.getId(), prjProve.getName()));
				logger.info(String.format("更新项目审批表失败！ID[%s] - Name[%s]", prjProve.getId(), prjProve.getName()));
				return ret;
			}
		}
	}

}
