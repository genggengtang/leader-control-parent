package org.zxs.leader.control.admin.controller.common;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zxs.base.model.CommonReturnBean;
import org.zxs.base.model.DataTablesBean;
import org.zxs.leader.control.admin.util.ProjectInfoExcelUtil;
import org.zxs.leader.control.controller.annotation.JsonParam;
import org.zxs.leader.control.dao.consts.IDicInfoConst;
import org.zxs.leader.control.dao.model.LdPrjView;
import org.zxs.leader.control.dao.model.PrjInfo;
import org.zxs.leader.control.dao.model.PrjInfoInsertResult;
import org.zxs.leader.control.dao.model.vo.output.LdPrjOptionOut;
import org.zxs.leader.control.dao.model.vo.output.OptionsOut;
import org.zxs.leader.control.dao.model.vo.output.PrjFullDetailOut;
import org.zxs.leader.control.dao.model.vo.query.PrjDetailQuery;
import org.zxs.leader.control.dao.model.vo.query.PrjViewQuery;
import org.zxs.leader.control.service.interf.IAreaNnService;
import org.zxs.leader.control.service.interf.IPrjContactService;
import org.zxs.leader.control.service.interf.IPrjInfoService;
import org.zxs.leader.control.service.interf.IPrjIssueService;
import org.zxs.leader.control.service.interf.IPrjProveService;

import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/admin")
@Api(tags="市领导联系项目后台查询")
public class LdPrjAdminController {
	
	private static final Log log = LogFactory.getLog(LdPrjAdminController.class);
	
	@Resource
	private IPrjInfoService prjInfoService;
	
	@Resource
	private IPrjContactService prjContactService;
	
	@Resource
	private IPrjProveService prjProveSerivce;
//	
	@Resource
	private IPrjIssueService issueService;
	
	@Resource
	private IAreaNnService areaService;
	
	@RequestMapping(value = "/ld-prj-page", method = {RequestMethod.GET, RequestMethod.POST})
	public DataTablesBean<LdPrjView> getLdPrjInfoByPage(
			@RequestParam(required=false,value="pageNum", defaultValue="1") Integer pageNum,
			@RequestParam(required=false,value="pageSize", defaultValue="10") Integer pageSize,
//			@RequestParam(required=false,value="iDisplayStart", defaultValue="0") Integer iDisplayStart,
//			@RequestParam(required=false,value="iDisplayLength", defaultValue="10") Integer pageSize,
			@RequestParam(required=false,value="draw", defaultValue="") String draw,
			@RequestParam(required=false,value="prjId") Integer prjId,
			@RequestParam(required=false,value="rspLeaderId") Integer rspLeaderId,
			@RequestParam(required=false,value="is60thWelfare") Integer is60thWelfare,
			@RequestParam(required=false,value="isPrvcPlan") Integer isPrvcPlan,
			@RequestParam(required=false,value="planStatus") Integer planStatus,
			@RequestParam(required=false,value="industry") Integer industry,
			@RequestParam(required=false,value="sSearch") String keyword,
			@RequestParam(required=false,value="iSortCol_0") Integer iSortCol,
			@RequestParam(required=false,value="sSortDir_0") String sSortDir,
			HttpServletRequest request) {
		PrjViewQuery query = new PrjViewQuery();
		
		// not deleted
		query.setIsDeleted(0);
		
		if(null != prjId)
			query.setPrjId(prjId);
		if(null != rspLeaderId)
			query.setRspLeaderId(rspLeaderId);
		if(null != is60thWelfare)
			query.setIs60thWelfare(is60thWelfare);
		if(null != isPrvcPlan)
			query.setIsPrvcPlan(isPrvcPlan);
		if(null != planStatus)
			query.setPlanStatus(planStatus);
		if(null != industry)
			query.setIndustry(industry);
		if(null != keyword)
			query.setKeyword(keyword);
		
		// 排序
		if(null != iSortCol) {
			String sortColumn = request.getParameter("mDataProp_" + iSortCol);
			if(null != sortColumn) {
				query.setOrderBy(sortColumn + " " + sSortDir);
			}
		}
		
//		int pageNum = iDisplayStart / pageSize + 1;
		PageInfo<LdPrjView> pageInfo = prjInfoService.getViewByPage(query, pageNum, pageSize);
		DataTablesBean<LdPrjView> pageRet = new DataTablesBean<>();
		pageRet.setErrorCode(0);
		pageRet.setDraw(draw);
		pageRet.setData(pageInfo.getList());
		pageRet.setRecordsTotal(pageInfo.getTotal());
		pageRet.setRecordsFiltered(pageInfo.getTotal());
		return pageRet;
	}

	
	@RequestMapping(value = "/ld-prj-detail/{id:\\d+}", method = {RequestMethod.GET, RequestMethod.POST})
	public PrjFullDetailOut getPrjFullDetail(@PathVariable("id")Integer id) {
		PrjDetailQuery query = new PrjDetailQuery();
		query.setId(id);
		// 查询基础详情信息
		PrjFullDetailOut detailOut = prjInfoService.getFullInfoById(query);
		
		// 审批信息表
		detailOut.setProveList(prjProveSerivce.getByPrjId(id, IDicInfoConst.PRJ_LEADER_CONTROL));
		
		// 沟通信息
		detailOut.setIssueList(issueService.getIssueByPrjIdAndType(id, IDicInfoConst.PRJ_LEADER_CONTROL));
		
		return detailOut;
	}
	
	@RequestMapping(value = "/auth/ld-prj-update/{id:\\d+}", method = RequestMethod.POST)
	public CommonReturnBean<Integer> updateLdPrjByOne(@PathVariable("id")Integer id, 
			@RequestParam(required=false,value="fullName") String fullName,
			@RequestParam(required=false,value="rspLeaderId") Integer rspLeaderId,
			@RequestParam(required=false,value="type") Integer type,
			@RequestParam(required=false,value="content") String content,
			@RequestParam(required=false,value="totalInvest") Integer totalInvest,
			@RequestParam(required=false,value="actualInvest") Integer actualInvest,
			@RequestParam(required=false,value="industry") Integer industry,
			@RequestParam(required=false,value="planStatus") Integer planStatus,
			@RequestParam(required=false,value="actualStatus") Integer actualStatus,
			@RequestParam(required=false,value="areaId") String areaId,
			@RequestParam(required=false,value="planStartDt") String planStartDt,
			@RequestParam(required=false,value="planEndDt") String planEndDt,
			@RequestParam(required=false,value="actualStartDt") String actualStartDt,
			@RequestParam(required=false,value="actualEndDt") String actualEndDt,
			@RequestParam(required=false,value="is60thWelfare") Integer is60thWelfare,
			@RequestParam(required=false,value="isPrvcPlan") Integer isPrvcPlan,
			@RequestParam(required=false,value="remark") String remark,
			@RequestParam(required=false,value="createAt") String createAt) {
		CommonReturnBean<Integer> ret = new CommonReturnBean<>();
		PrjInfo updPrj = new PrjInfo();
		updPrj.setId(id);
		
		if(null != fullName) {
			updPrj.setFullName(fullName);
		}
		
		if(null != rspLeaderId) {
			updPrj.setRspLeaderId(rspLeaderId);
		}
		
		if(null != type) {
			updPrj.setType(type.shortValue());
		}
		
		if(null != content) {
			updPrj.setContent(content);
		}
		
		if(null != totalInvest) {
			updPrj.setTotalInvest(totalInvest);
		}
		
		if(null != actualInvest) {
			updPrj.setActualInvest(actualInvest);
		}
		
		if(null != industry) {
			updPrj.setIndustry(industry);
		}
		
		if(null != planStatus) {
			updPrj.setPlanStatus(planStatus);
		}
		
		if(null != actualStatus) {
			updPrj.setActualStatus(actualStatus);
		}
		
		if(null != areaId) {
			updPrj.setAreaId(areaId);
		}
		
		SimpleDateFormat dateFm = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			if(null != planStartDt) {
				updPrj.setPlanStartDt(dateFm.parse(planStartDt));
			}
			
			if(null != planEndDt) {
				updPrj.setPlanEndDt(dateFm.parse(planEndDt));
			}
			
			if(null != actualStartDt) {
				updPrj.setActualStartDt(dateFm.parse(actualStartDt));
			}
			
			if(null != actualEndDt) {
				updPrj.setActualEndDt(dateFm.parse(actualEndDt));
			}
			
			if(null != createAt) {
				updPrj.setCreateAt(timeFm.parse(createAt));
			}
			
		} catch (ParseException e) {
			log.error(e.getMessage(), e);
			ret.setErrorCode(-120);
			ret.setErrorMsg("日期格式不正确！");
			return ret;
		}
		
		if(null != is60thWelfare) {
			updPrj.setIs60thWelfare(is60thWelfare.shortValue());
		}
		
		if(null != isPrvcPlan) {
			updPrj.setIsPrvcPlan(isPrvcPlan.shortValue());
		}
		
		if(null != remark) {
			updPrj.setRemark(remark);
		}
		
		updPrj.setUpdateAt(new Date());
		
		int updCnt = prjInfoService.updatePrjById(updPrj);
		if(updCnt != 1) {
			ret.setErrorCode(-901);
			ret.setErrorMsg("更新项目信息失败！");
			return ret;
		}
		
		ret.setErrorCode(0);
		ret.setErrorMsg("更新项目信息成功！");
		return ret;
	}
	
	/**
	 * 
	* @Title: updateLdPrjWhole 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param prjInfo
	* @param @return  参数说明 
	* @return CommonReturnBean<Integer>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年6月28日 下午2:50:09
	 */
	@RequestMapping(value = "/ld-prj-update-whole", method = RequestMethod.POST)
	@JsonParam(paramName="ldPrj", paramClass=PrjInfo.class)
	public CommonReturnBean<Integer> updateLdPrjWhole(@RequestBody PrjInfo prjInfo) {
		CommonReturnBean<Integer> ret = new CommonReturnBean<>();
		Integer id = prjInfo.getId();
		if(null == id) {
			String errorMsg = "传入的参数必须包含ID字段！";
			ret.setErrorCode(-902);
			ret.setErrorMsg(errorMsg);
			log.info(errorMsg);
			return ret;
		}
		prjInfo.setUpdateAt(new Date());
		try {
			int updCnt = prjInfoService.updatePrjById(prjInfo);
			if(updCnt != 1) {
				String errorMsg = "更新项目信息失败！";
				ret.setErrorCode(-901);
				ret.setErrorMsg(errorMsg);
				log.info(errorMsg);
				return ret;
			}
		}catch(Exception e) {
			String errorMsg = "更新项目信息失败！";
			log.error(e.getMessage(), e);
			ret.setErrorCode(-903);
			ret.setErrorMsg(errorMsg);
			return ret;
		}
		
		ret.setErrorCode(0);
		ret.setErrorMsg("更新项目信息成功！已更新项目ID：" + id);
		log.info("更新项目信息成功！已更新项目ID:" + id);
		return ret;
	}
	
	/**
	 * 
	* @Title: createProjectInfo 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param projectInfo
	* @param @return  参数说明 
	* @return CommonReturnBean<Integer>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年6月25日 上午11:12:17
	 */
	@RequestMapping(value = "/ld-create-prj-info", method = RequestMethod.POST, consumes = "application/json")
	@ApiOperation(httpMethod = "POST", value = "添加新项目", produces = MediaType.APPLICATION_JSON_VALUE)
	public CommonReturnBean<Integer> createProjectInfo(@RequestBody PrjInfo projectInfo) {
		CommonReturnBean<Integer> ret = new CommonReturnBean<>();
		ret.setErrorCode(-1);
		ret.setErrorMsg("创建项目信息失败！");
		if (null == projectInfo) {
			log.info("创建项目信息失败！");
			return ret;
		}
		// set default prjInfo properties
		projectInfo.setCreateAt(new Date());
		projectInfo.setUpdateAt(new Date());
		projectInfo.setIsDeleted((short) 0);
		
		int createCount = this.prjInfoService.createPrjInfo(projectInfo);
		if (createCount > 0) {
			ret.setErrorCode(0);
			ret.setErrorMsg("创建项目信息成功！");
			log.info("创建项目信息成功！");
			return ret;
		}
		return ret;
	}
	
	/**
	 * 
	* @Title: exportProjectInfoTableAsExcel 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param response  参数说明 
	* @return void    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年6月25日 上午11:12:08
	 */
	@RequestMapping(value = "/ld-export-prj-info-excel", method = RequestMethod.GET)
	public void exportProjectInfoTableAsExcel(HttpServletResponse response) {
		List<PrjInfo> prjInfoList = this.prjInfoService.getAllPrjInfoSoft();
		if (null == prjInfoList) {
			log.info("prjInfoList为空！");
			return;
		}
		
		ByteArrayOutputStream out = ProjectInfoExcelUtil.convertToOutputStream(prjInfoList);
//		CommonExcelUtil excelUtil = new CommonExcelUtil();
//		ByteArrayOutputStream out = excelUtil.convertOutputStream("市领导联系项目", 
//				new ArrayList<Object>(prjInfoList));
		if (null == out) {
			log.info("ByteArrayOutputStream为空！");
			return;
		}
		// response excel file settings
		try {
			String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			response.setContentType("application/xlsx");
			response.setHeader("Content-Disposition", "attachment; filename=\"" + timestamp + ".xlsx\""); 
			response.getOutputStream().write(out.toByteArray());
			response.flushBuffer();
			out.close();
			log.info("开始下载Excel文件...");
		} catch (IOException ex) {
			throw new RuntimeException("IOError writing file to output stream");
		}

	}
	
	/**
	 * 
	* @Title: handleImportExcel 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param file
	* @param @param redirectAttributes
	* @param @return  参数说明 
	* @return CommonReturnBean<PrjInfoInsertResult>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年6月25日 上午11:11:52
	 */
	@RequestMapping(value = "/ld-import-prj-info-excel", method = RequestMethod.POST)
	public CommonReturnBean<PrjInfoInsertResult> handleImportExcel(@RequestParam("file") MultipartFile file,
            RedirectAttributes redirectAttributes) {
		CommonReturnBean<PrjInfoInsertResult> ret = new CommonReturnBean<>();
		if (null == file) {
			ret.setErrorCode(-1);
			ret.setErrorMsg("上传文件为空！");
			return ret;
		}
		// get file extension
		String fileName = file.getOriginalFilename();
		int index = fileName.lastIndexOf(".");
		String extension = fileName.substring(index, fileName.length());
		
		InputStream inputStream = null;
		try {
			inputStream = file.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
			ret.setErrorCode(-1);
			ret.setErrorMsg("上传文件流为空！");
			return ret;
		}
		// table for batch insertion
		List<PrjInfo> table = ProjectInfoExcelUtil.readExcel(inputStream, extension);
		// insert table
		PrjInfoInsertResult insertResult = this.prjInfoService.insertBatchIncremental(table);
		ret.setErrorCode(0);
		ret.setErrorMsg("Excel文件导入结果：" + insertResult.getResultType());
		ret.setData(insertResult);
		log.info("Excel记录导入成功条数: "  + (insertResult.getTotalNumRows() - insertResult.getErrorRows()) + "/" + insertResult.getTotalNumRows());
		return ret;
	}
	
	/**
	 * 
	* @Title: deleteProjectInfoById 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param prjViewQuery
	* @param @return  参数说明 
	* @return CommonReturnBean<Integer>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年6月28日 上午11:42:02
	 */
	@RequestMapping(value = "/ld-prj-delete-by-id", method = RequestMethod.POST)
	public CommonReturnBean<Integer> deleteProjectInfoById(@RequestParam("projectInfoId") Integer projectInfoId) {
		CommonReturnBean<Integer> ret = new  CommonReturnBean<Integer>();
		ret.setErrorCode(-1);
		if (null == projectInfoId) {
			String errorStr = "删除项目信息失败，项目ID为空！";
			ret.setErrorMsg(errorStr);
			log.info(errorStr);
			return ret;
		}
		int retCode= this.prjInfoService.deleteById(projectInfoId);
		if (retCode <= 0) {
			String errorStr = "删除项目信息失败，数据库记录未改动！";
			ret.setErrorMsg(errorStr);
			log.info(errorStr);
			return ret;
		}
		String errorStr = "删除项目信息成功！已经删除项目ID：" + projectInfoId;
		ret.setErrorCode(0);
		ret.setData(projectInfoId);
		ret.setErrorMsg(errorStr);
		log.info(errorStr);
		return ret;
	}
	
	/**
	 * 
	* @Title: deleteMultipleProjectInfosByIds 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param prjViewQueryList
	* @param @return  参数说明 
	* @return CommonReturnBean<Integer>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年6月28日 上午11:51:44
	 */
	@RequestMapping(value = "/ld-prj-multiple-delete-by-ids", method = RequestMethod.POST)
	public CommonReturnBean<Integer> deleteMultipleProjectInfosByIds(@RequestBody List<Integer> prjIdList) {
		CommonReturnBean<Integer> ret = new CommonReturnBean<Integer>();
		
		System.out.println(prjIdList);
		
		if (null == prjIdList || prjIdList.size() == 0) {
			String errorStr = "批量删除项目信息失败！项目ID列表为空！";
			ret.setErrorMsg(errorStr);
			log.info(errorStr);
			return ret;
		}
		int retCode= this.prjInfoService.deleteByIdList(prjIdList);
		if (retCode < 0) {
			String errorStr = "批量删除项目信息失败！";
			ret.setErrorMsg(errorStr);
			log.info(errorStr);
			return ret;
		}
		String errorStr = "批量删除项目信息成功！已删除项目信息ID列表：" + prjIdList;
		ret.setErrorMsg(errorStr);
		log.info(errorStr);
		return ret;
	}
	
	@RequestMapping(value = "/ld-prj-options", method = RequestMethod.GET)
	public LdPrjOptionOut getPrjOptions() {
		LdPrjOptionOut opts = new LdPrjOptionOut();
		List<OptionsOut> lgList = prjInfoService.getAllLeaderList();
		if(!lgList.isEmpty()) {
			opts.setLeaderList(lgList);
		}
		
		List<OptionsOut> bStatusList = prjInfoService.getAllBuildStatusList();
		if(!bStatusList.isEmpty()) {
			opts.setBuildStatusList(bStatusList);
		}
		
		List<OptionsOut> industryList = prjInfoService.getAllIndustryList();
		if(!bStatusList.isEmpty()) {
			opts.setIndustryList(industryList);
		}
		
		List<OptionsOut> areaList = areaService.getAllListWithoutProv();
		if(!areaList.isEmpty()) {
			opts.setAreaList(areaList);
		}
		return opts;
	}

}
