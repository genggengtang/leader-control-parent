package org.zxs.leader.control.controller;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.zxs.base.model.CommonReturnBean;
import org.zxs.base.model.PageReturnBean;
import org.zxs.leader.control.dao.consts.IDicInfoConst;
import org.zxs.leader.control.dao.model.PrjMonthPlan;
import org.zxs.leader.control.dao.model.PrjYearPlan;
import org.zxs.leader.control.dao.model.vo.output.PrjMonthReportOut;
import org.zxs.leader.control.dao.model.vo.query.MonthReportQuery;
import org.zxs.leader.control.service.interf.IPrjMonthPlanService;
import org.zxs.leader.control.service.interf.IPrjYearPlanService;

import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Controller
@Api(tags = "月度进度录入接口")
public class MonthReportUploadController {
	private static final Log log = LogFactory.getLog(MonthReportUploadController.class);

	@Resource
	private FreeMarkerConfigurer fmConfig;

	@Resource
	private IPrjMonthPlanService monthService;
	
	@Resource
	private IPrjYearPlanService yearService;

//	@RequestMapping(value = "batch-deliver-month-progress", method = RequestMethod.POST, consumes="multipart/*", headers="Content-Type=multipart/form-data")
//	@ApiOperation(httpMethod = "POST", value = "批量上传月度进度数据", produces = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody
//	public CommonReturnBean<Map<String, String>> batchUploadMonthReport(@ApiParam(value = "上传的文件", required = true) MultipartFile multipartFile) {
//		CommonReturnBean<Map<String, String>> ret = new CommonReturnBean<>();
//
//		// 获得工作簿对象
//		Workbook workbook = null;
//		int total = 0;
//		int succ = 0;
//		Map<String, String> failMap = new LinkedHashMap<>();
//		try {
//			workbook = Workbook.getWorkbook(multipartFile.getInputStream());
//			// 获得所有工作表
//			Sheet[] sheets = workbook.getSheets();
//			if (sheets != null) {
//				for (Sheet sheet : sheets) {
//					// 获得行数
//					int rows = sheet.getRows();
//					if(rows > 1) {
//						total += rows - 1;
//						// 读取数据
//						loop:for (int row = 1; row < rows; row++) {
//							String monthIdStr = sheet.getCell(0, row).getContents();
//							String title = sheet.getCell(1, row).getContents();
//							String actualContent = sheet.getCell(2, row).getContents();
//							String picName = sheet.getCell(3, row).getContents();
//							String picUrl = sheet.getCell(4, row).getContents();
//							String issueContent = sheet.getCell(5, row).getContents();
//							String proposal = sheet.getCell(6, row).getContents();
//							
//							log.info("开始录入月进度！" + monthIdStr);
//							
//							if(null == monthIdStr || monthIdStr.isEmpty()
//									|| null == title || title.isEmpty()
//									|| null == actualContent || actualContent.isEmpty()) {
//								String errMsg = "月编号、标题或内容值不合法！";
//								log.info(errMsg + monthIdStr);
//								failMap.put(monthIdStr, errMsg);
//								continue loop;
//							}
//							
////							PrjMonthReportOut monthOut = new PrjMonthReportOut();
//							Integer monthId = Integer.parseInt(monthIdStr);
////							monthOut.setMonthId(monthId);
////							monthOut.setTitle(title);
////							monthOut.setActualContent(actualContent);
////							if(null != issueContent && !issueContent.isEmpty())
////								monthOut.setIssueContent(issueContent);
////							if(null != proposal && !proposal.isEmpty())
////								monthOut.setProposal(proposal);
//
//							if (picName != null && !picName.isEmpty() && picUrl != null && !picUrl.isEmpty()) {
//								String[] picNames = picName.split(",");
//								String[] picUrls = picUrl.split(",");
//								if (null != picNames && null != picUrls) {
//									if (picNames.length != picUrls.length) {
//										String errMsg = "录入的图片名和图片URL个数不相同！";
//										log.info(errMsg + monthIdStr);
//										failMap.put(monthIdStr, errMsg);
//										continue loop;
//									}
//									Map<String, String> picUrlMap = new LinkedHashMap<>();
//									for (int i = 0; i < picNames.length; i++) {
//										picUrlMap.put(picUrls[i], picNames[i]);
//									}
//
////									monthOut.setPicUrlMap(picUrlMap);
//								}
//							}
//
////							String fName = System.currentTimeMillis() + ".html";
////							String fileName = System.getProperty("user.dir") + File.separatorChar + fName;
////							String qiniuName = "html/" + fName;
//
//							try {
////								FreemarkerUtil.printToFile(fmConfig.getConfiguration().getTemplate("/month_progress.ftl"), fileName,
////										monthOut);
////
////								// 上传文件到七牛获取返回链接地址
////								String actualUrl = UploadQiniu.upload(fileName, qiniuName, true);
//
//								// 获取月度进展数据
//								PrjMonthPlan monthPlan = monthService.getMonthPlanById(monthId);
//								if (null == monthPlan) {
//									String errMsg = "该项目无年度记录，请先添加年度记录信息！";
//									log.info(errMsg + monthIdStr);
//									failMap.put(monthIdStr, errMsg);
//									continue loop;
//								}
//
////								monthPlan.setActualUrl(actualUrl);
//								if (null != picName)
//									monthPlan.setPicName(picName);
//								if (null != picUrl)
//									monthPlan.setPicUrl(picUrl);
//								monthPlan.setTitle(title);
//								monthPlan.setActualContent(actualContent);
//								if (null != issueContent)
//									monthPlan.setIssueContent(issueContent);
//								if (null != proposal)
//									monthPlan.setProposal(proposal);
//								monthPlan.setUpdateAt(new Date());
//								monthPlan.setStatus((short) 1); // 将进度状态改为1
//
//								// 保存月度进展数据
//								int updCnt = monthService.updateMonthPlan(monthPlan);
//								if (updCnt == 1) {
//									log.info("添加月度进展记录成功！" + monthId);
//									succ++;
//								} else {
//									String errMsg = "添加月度进展失败！";
//									log.info(errMsg + monthIdStr);
//									failMap.put(monthIdStr, errMsg);
//								}
//							/*} catch (TemplateException | IOException e) {
//								String errMsg = "添加月度进展失败！" + e.getMessage();
//								log.info(errMsg + monthIdStr);
//								failMap.put(monthIdStr, errMsg);*/
//							} catch (Exception e) {
//								String errMsg = "添加月度进展失败！" + e.getMessage();
//								log.info(errMsg + monthIdStr);
//								failMap.put(monthIdStr, errMsg);
//							} finally {
//								// 删除本地html文件
////								File htmlFile = new File(fileName);
////								htmlFile.deleteOnExit();
//							}
//							
//							log.info("录入月进度结束！" + monthIdStr);
//						}
//					}
//				}
//					
//			}
//		} catch (BiffException | IOException e) {
//			log.error(e.getMessage(), e);
//			ret.setErrorCode(-101);
//			ret.setErrorMsg("读取EXCEL文件出错！");
//		} finally {
//			if (null != workbook)
//				workbook.close();
//		}
//		
//		ret.setErrorCode(0);
//		ret.setErrorMsg(String.format("批量录入月进度结束！总数[%s]，成功[%s]", total, succ));
//		ret.setData(failMap);
//		return ret;
//	}

	@RequestMapping(value = "deliver-month-progress", method = RequestMethod.POST)
	@ApiOperation(httpMethod = "POST", value = "上传月度进度数据", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "monthId", value = "月度表编号", required = true, dataType = "integer", paramType = "form"),
			@ApiImplicitParam(name = "title", value = "标题", required = true, dataType = "string", paramType = "form"),
			@ApiImplicitParam(name = "actualContent", value = "进度内容", required = true, dataType = "string", paramType = "form"),
			@ApiImplicitParam(name = "picName", value = "图片名称，多个以逗号分隔", dataType = "string", paramType = "form"),
			@ApiImplicitParam(name = "picUrl", value = "图片URL地址，多个以逗号分隔，并与picName字段顺序一致", dataType = "string", paramType = "form"),
			@ApiImplicitParam(name = "issueContent", value = "存在问题", dataType = "string", paramType = "form"),
			@ApiImplicitParam(name = "proposal", value = "建议", dataType = "string", paramType = "form") })
	@ResponseBody
	public CommonReturnBean<String> uploadMonthReport(
			// @RequestParam(required=true,value="prjType") Integer prjType,
			// @RequestParam(required=true,value="prjId") Integer prjId,
			// @RequestParam(required=true,value="year") Integer year,
			// @RequestParam(required=true,value="month") Integer month,
			@RequestParam(required = true, value = "monthId") Integer monthId,
			@RequestParam(required = true, value = "title") String title,
			@RequestParam(required = true, value = "actualContent") String actualContent,
			@RequestParam(required = false, value = "picName") String picName,
			@RequestParam(required = false, value = "picUrl") String picUrl,
			@RequestParam(required = false, value = "issueContent") String issueContent,
			@RequestParam(required = false, value = "proposal") String proposal) {
		CommonReturnBean<String> ret = new CommonReturnBean<>();
//		PrjMonthReportOut monthOut = new PrjMonthReportOut();
//		monthOut.setTitle(title);
//		monthOut.setActualContent(actualContent);
//		monthOut.setIssueContent(issueContent);
//		monthOut.setProposal(proposal);

		if (picName != null && picUrl != null) {
			String[] picNames = picName.split(",");
			String[] picUrls = picUrl.split(",");
			if (null != picNames && null != picUrls) {
				if (picNames.length != picUrls.length) {
					log.info("录入的图片名和图片URL个数不相同！");
					ret.setErrorCode(-111);
					ret.setErrorMsg("录入的图片名个数和图片URL个数不相同！");
					return ret;
				}
				Map<String, String> picUrlMap = new LinkedHashMap<>();
				for (int i = 0; i < picNames.length; i++) {
					picUrlMap.put(picUrls[i], picNames[i]);
				}

//				monthOut.setPicUrlMap(picUrlMap);
			}
		}

//		String fName = System.currentTimeMillis() + ".html";
//		String fileName = System.getProperty("user.dir") + File.separatorChar + fName;
//		String qiniuName = "html/" + fName;

		try {
//			FreemarkerUtil.printToFile(fmConfig.getConfiguration().getTemplate("/month_progress.ftl"), fileName,
//					monthOut);

			// 上传文件到七牛获取返回链接地址
//			String actualUrl = UploadQiniu.upload(fileName, qiniuName, true);

			// 获取月度进展数据
			PrjMonthPlan monthPlan = monthService.getMonthPlanById(monthId);
			if (null == monthPlan) {
				log.info("该项目无年度记录，请先添加年度记录信息！");
				ret.setErrorCode(-110);
				ret.setErrorMsg("该项目无年度记录，请先添加年度记录信息！");
				return ret;
			}

//			monthPlan.setActualUrl(actualUrl);
			if (null != picName)
				monthPlan.setPicName(picName);
			if (null != picUrl)
				monthPlan.setPicUrl(picUrl);
			monthPlan.setTitle(title);
			monthPlan.setActualContent(actualContent);
			if (null != issueContent)
				monthPlan.setIssueContent(issueContent);
			if (null != proposal)
				monthPlan.setProposal(proposal);
			monthPlan.setUpdateAt(new Date());
			monthPlan.setStatus((short) 1); // 将进度状态改为1

			// 保存月度进展数据
			int updCnt = monthService.updateMonthPlan(monthPlan);
			if (updCnt == 1) {
				ret.setErrorCode(0);
				ret.setErrorMsg("添加月度进展成功！");
//				ret.setData(actualUrl);
			} else {
				ret.setErrorCode(-111);
				ret.setErrorMsg("添加月度进展失败！");
			}
		/*} catch (TemplateException | IOException e) {
			log.error(e.getMessage(), e);
			ret.setErrorCode(-102);
			ret.setErrorMsg(e.getMessage());
			return ret;*/
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			ret.setErrorCode(-102);
			ret.setErrorMsg(e.getMessage());
			return ret;
		} finally {
			// 删除本地html文件
//			File htmlFile = new File(fileName);
//			htmlFile.deleteOnExit();
		}
		// ModelAndView mv = new ModelAndView("month_progress");
		// mv.addObject(monthOut);
		// log.info(JSON.toJSONString(mv));

		return ret;
	}

	@RequestMapping(value = "month-report-page", method = RequestMethod.GET)
	@ApiOperation(httpMethod = "GET", value = "项目月表分页列表", produces = MediaType.APPLICATION_JSON_VALUE)
	// @ApiImplicitParams({
	// @ApiImplicitParam(name = "pageNum", value = "页码", required = false, dataType
	// = "integer", paramType = "form"),
	// @ApiImplicitParam(name = "pageSize", value = "每页数量", required = false,
	// dataType = "integer", paramType = "form"),
	// @ApiImplicitParam(name = "draw", value = "保留字段", required = false, dataType =
	// "string", paramType = "form"),
	// @ApiImplicitParam(name = "year", value = "年份", dataType = "integer",
	// paramType = "form"),
	// @ApiImplicitParam(name = "month", value = "月份", dataType = "integer",
	// paramType = "form"),
	// @ApiImplicitParam(name = "prjType", value = "项目类型，对应字典表214", dataType =
	// "integer", paramType = "form"),
	// @ApiImplicitParam(name = "prjId", value = "项目编号", dataType = "integer",
	// paramType = "form"),
	// @ApiImplicitParam(name = "monthId", value = "月记录编号", dataType = "integer",
	// paramType = "form")
	// })
	@ResponseBody
	public PageReturnBean<PrjMonthReportOut> getMonthRecordByPage(
			@ApiParam(value = "页码", required = true) @RequestParam(required = false, value = "pageNum", defaultValue = "1") Integer pageNum,
			@ApiParam(value = "每页数量", required = true) @RequestParam(required = false, value = "pageSize", defaultValue = "10") Integer pageSize,
			@ApiParam(value = "保留字段") @RequestParam(required = false, value = "draw", defaultValue = "") String draw,
			@ApiParam(value = "年份") @RequestParam(required = false, value = "year") Integer year,
			@ApiParam(value = "月份") @RequestParam(required = false, value = "month") Integer month,
			@ApiParam(value = "项目类型，对应字典表214", allowableValues = IDicInfoConst.PRJ_LEADER_CONTROL + ","
					+ IDicInfoConst.PRJ_CITY_PLAN + ","
					+ IDicInfoConst.PRJ_CITY_BUILD) @RequestParam(required = false, value = "prjType") Integer prjType,
			@ApiParam(value = "项目编号") @RequestParam(required = false, value = "prjId") Integer prjId,
			@ApiParam(value = "月记录编号") @RequestParam(required = false, value = "monthId") Integer monthId) {
		MonthReportQuery query = new MonthReportQuery();
		if (null != year)
			query.setYear(year);
		if (null != month)
			query.setMonth(month);
		if (null != prjType)
			query.setPrjType(prjType);
		if (null != prjId)
			query.setPrjId(prjId);
		if (null != monthId)
			query.setMonthId(monthId);

		PageInfo<PrjMonthReportOut> pageInfo = monthService.getMonthInfoByPage(pageNum, pageSize, query);
		PageReturnBean<PrjMonthReportOut> pageRet = new PageReturnBean<>();
		pageRet.setErrorCode(0);
		pageRet.setDraw(draw);
		pageRet.setData(pageInfo.getList());
		pageRet.setTotal(pageInfo.getTotal());
		return pageRet;
	}
	
	@RequestMapping(value = "get-month-report/{id:\\d+}", method = RequestMethod.GET)
	public ModelAndView getMonthReport(@PathVariable("id")Integer id){
		PrjMonthPlan monthPlan = monthService.getMonthPlanById(id);
		String picName = monthPlan.getPicName();
//		String picUrl = monthPlan.getPicUrl();
		String picUrl = monthPlan.getPicClearUrl();
		String issueContent = monthPlan.getIssueContent();
		String proposal = monthPlan.getProposal();
		
		PrjYearPlan yPlan = yearService.getYearInfoById(monthPlan.getYearId());
		
		ModelAndView mv = new ModelAndView("month_progress");
		mv.addObject("title", monthPlan.getTitle());
		mv.addObject("actualContent", monthPlan.getActualContent());
		
		Map<String, String> picUrlMap = new LinkedHashMap<>();
		if(null != picName && !picName.isEmpty()
				&& null != picUrl && !picUrl.isEmpty()) {
			String[] picNameArr = picName.split(",");
			String[] picUrlArr = picUrl.split(",");
			if (picNameArr.length == picUrlArr.length) {
				for (int i = 0; i < picNameArr.length; i++) {
					if(null != picUrlArr[i] && !picUrlArr[i].isEmpty()
							&& null != picNameArr[i] && !picNameArr[i].isEmpty())
						picUrlMap.put(picUrlArr[i], picNameArr[i]);
				}
			}
		}
		
		if(!picUrlMap.isEmpty())
			mv.addObject("picUrlMap", picUrlMap);
		if(null != issueContent && !issueContent.isEmpty())
			mv.addObject("issueContent", issueContent);
		if(null != proposal && !proposal.isEmpty())
			mv.addObject("proposal", proposal);
		mv.addObject("prjType", yPlan.getPrjType());
		return mv;
	}
			
	@RequestMapping(value = "pic-name-add", method = RequestMethod.GET)
	@ApiOperation(httpMethod = "GET", value = "批量添加月进度图片名", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public CommonReturnBean<Map<Integer, String>> addPicName() {
		CommonReturnBean<Map<Integer, String>> addPicNameRet = new CommonReturnBean<>();
		int succ = 0;
		Map<Integer, String> failMap = new LinkedHashMap<>();
		log.info("开始批量添加月进度图片名！");
		List<PrjMonthPlan> monthList = monthService.getPicNameList();
		if(!monthList.isEmpty()) {
			for(PrjMonthPlan monthOut : monthList) {
				int monthId = monthOut.getId();
				String actualUrl = monthOut.getActualUrl();
				if(null == actualUrl || actualUrl.isEmpty()) {
					failMap.put(monthId, "HTML页面地址为空！");
					continue;
				}
				String picUrl = monthOut.getPicUrl();
				String[] picArr = picUrl.split(",");
				if(picArr.length == 0) {
					failMap.put(monthId, "图片地址为空！");
					continue;
				}
				
				try {
					Document doc = Jsoup.connect(actualUrl).get();
					Elements spanElements = doc.select("span");
					int spanSize = spanElements.size();
					if(spanSize <= 3) {
						failMap.put(monthId, "HTML页面并无图片名称！");
						continue;
					}else if(picArr.length != spanSize - 3){
						failMap.put(monthId, "HTML页面图片名称数与图片URL数量不相等！");
						continue;
					}else{
						String picName = "";
						for(int i=1;i<picArr.length+1;i++) {
							if(i > 1)
								picName += ",";
							picName += spanElements.get(i).text();
						}
						if(!picName.isEmpty()) {
							monthOut.setPicName(picName);
							int updCnt = monthService.updateMonthPlan(monthOut);
							if(updCnt == 1) {
								log.info("更新月进度[" + monthId + "]图片名称成功！");
								succ++;
							}else {
								failMap.put(monthId, "更新月进度[" + monthId + "]图片名称失败！");
							}
						}
					}
					
				} catch (IOException e) {
					failMap.put(monthId, "访问HTML页面出错！");
					log.warn(e.getMessage(), e);
				}
			}
		}
		
		addPicNameRet.setErrorCode(0);
		addPicNameRet.setErrorMsg("批量添加月进度图片名结束！总数[" + monthList.size() + "]，成功数[" + succ + "]");
		if(!failMap.isEmpty())
			addPicNameRet.setData(failMap);
		log.info("批量添加月进度图片名结束！");
		return addPicNameRet;
	}
}
