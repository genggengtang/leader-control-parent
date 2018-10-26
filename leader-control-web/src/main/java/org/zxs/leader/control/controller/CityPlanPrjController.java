package org.zxs.leader.control.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zxs.base.model.CommonReturnBean;
import org.zxs.base.model.PageReturnBean;
import org.zxs.leader.control.controller.annotation.Authorization;
import org.zxs.leader.control.controller.annotation.Trace;
import org.zxs.leader.control.controller.bean.CommonConfig;
import org.zxs.leader.control.controller.bean.PrjDbInfo;
import org.zxs.leader.control.dao.consts.IAppConst;
import org.zxs.leader.control.dao.consts.IDicInfoConst;
import org.zxs.leader.control.dao.model.CityPlanPrj;
import org.zxs.leader.control.dao.model.PrjMonthPlan;
import org.zxs.leader.control.dao.model.vo.output.CpPrjDetailOut;
import org.zxs.leader.control.dao.model.vo.output.CpPrjPageOut;
import org.zxs.leader.control.dao.model.vo.output.LoginUserOut;
import org.zxs.leader.control.dao.model.vo.output.PrjYearPrgOut;
import org.zxs.leader.control.dao.model.vo.query.CpPrjPageQuery;
import org.zxs.leader.control.service.interf.IAreaNnService;
import org.zxs.leader.control.service.interf.ICityPlanPrjService;
import org.zxs.leader.control.service.interf.IDicInfoService;
import org.zxs.leader.control.service.interf.IHeaderService;
import org.zxs.leader.control.service.interf.IMeetingNoteService;
import org.zxs.leader.control.service.interf.IPrjInfoService;
import org.zxs.leader.control.service.interf.IPrjMonthPlanService;
import org.zxs.leader.control.service.interf.IPrjProveService;
import org.zxs.leader.control.service.interf.IPrjYearPlanService;
import org.zxs.utils.HttpUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags="市统筹项目查询接口")
public class CityPlanPrjController {
	
	private static final Log log = LogFactory.getLog(CityPlanPrjController.class);
	
	private static final String PRJ_DB_BASE_URL = "http://202.103.199.210:8070/nnxmgl/foreignrest/nnForeignService/";
	
	@Resource
	private IPrjInfoService prjInfoService;
	
	@Resource
	private ICityPlanPrjService cityPlanPrjService;
	
	@Resource
	private IPrjProveService prjProveSerivce;
	
	@Resource
	private IMeetingNoteService mNoteService;
	
	@Resource
	private IPrjYearPlanService yearSerivce;
	
	@Resource
	private IPrjMonthPlanService monthService;
	
	@Resource
	private IHeaderService headerService;
	
	@Resource
	private IDicInfoService dicInfoService;
	
	@Resource
	private IAreaNnService areaNnService;
	
	@Resource
	private CommonConfig config;
	
	@RequestMapping(value = "cp-prj-page", method = RequestMethod.GET)
	@ApiOperation(httpMethod = "GET", value = "市统筹项目分页列表", produces = MediaType.APPLICATION_JSON_VALUE)
	@Authorization
	@ApiImplicitParams({
        @ApiImplicitParam(name = IAppConst.AUTHORIZATION, value = IAppConst.AUTHORIZATION, required = true, dataType = "string", paramType = "header"),
    })
	@Trace(type=IDicInfoConst.OPT_LIST_PRJ, prjType=IDicInfoConst.PRJ_CITY_PLAN)
	public PageReturnBean<CpPrjPageOut> getCityPlanByPage(
			@RequestParam(required=false,value="pageNum", defaultValue="1") Integer pageNum,
			@RequestParam(required=false,value="pageSize", defaultValue="10") Integer pageSize,
			@RequestParam(required=false,value="draw", defaultValue="") String draw,
			@RequestParam(required=false,value="planStatus") Integer planStatus,
			@RequestParam(required=false,value="industry") Integer industry,
			@RequestParam(required=false,value="labels") String labels,
			@RequestParam(required=false,value="areaAdmin") Integer areaAdmin,
			@RequestParam(required=false,value="nameLike") String nameLike, HttpSession session) {
		PageReturnBean<CpPrjPageOut> pageRet = new PageReturnBean<>();
		LoginUserOut user = (LoginUserOut) session.getAttribute(IAppConst.SESSION_USER_NAME);
		if(null == user) {
			pageRet.setErrorCode(401);
			return pageRet;
		}
		
		CpPrjPageQuery query = new CpPrjPageQuery();
		if(null != planStatus)
			query.setPlanStatus(planStatus);
		if(null != industry)
			query.setIndustry(industry);
		if(null != labels)
			query.setLabels(JSON.parseArray(labels, Integer.class));
		if(null != nameLike)
			query.setNameLike(nameLike);
		if(null != areaAdmin)
			query.setAreaAdmin(areaAdmin);
//		query.setPrjType(IDicInfoConst.PRJ_CITY_PLAN); // 市统筹项目
		int userId = user.getUserId();
		int level = user.getLevel();
		if(level == 6) { // 6级用户只能查自己想关的项目
			query.setOwnerUserId(userId);
		}
		
		PageInfo<CpPrjPageOut> pageInfo = cityPlanPrjService.getInfoByPage(pageNum, pageSize, query);
		pageRet.setErrorCode(0);
		pageRet.setDraw(draw);
		pageRet.setData(pageInfo.getList());
		pageRet.setTotal(pageInfo.getTotal());
		return pageRet;
	}
	
	@RequestMapping(value = "cp-prj-detail/{id:\\d+}", method = RequestMethod.GET)
	@ApiOperation(httpMethod = "GET", value = "市统筹项目详情", produces = MediaType.APPLICATION_JSON_VALUE)
	@Trace(type=IDicInfoConst.OPT_DETAIL_PRJ, prjType=IDicInfoConst.PRJ_CITY_PLAN)
	public CpPrjDetailOut getCityPlanDetail(@PathVariable("id")Integer id) {
		CpPrjDetailOut detailOut = cityPlanPrjService.getDetailById(id);
		if(null != detailOut) {
			// 获取审批文件
			detailOut.setProveList(prjProveSerivce.getByPrjId(id, IDicInfoConst.PRJ_CITY_PLAN));
			
			// 获取相关附件
			detailOut.setAttachmentList(mNoteService.getPrjAttachments(id, IDicInfoConst.PRJ_CITY_PLAN));
			
			// 建设进度
			detailOut.setYearPrgList(yearSerivce.getYearInfoByPrjId(id, IDicInfoConst.PRJ_CITY_PLAN, config.getServerPre()));
		}
		return detailOut;
	}
	
	@RequestMapping(value = "update-db-id", method = RequestMethod.POST)
	@ApiOperation(httpMethod = "POST", value = "更新项目库编号", produces = MediaType.APPLICATION_JSON_VALUE)
	public CommonReturnBean<Integer> updatePrjDbId() {
		CommonReturnBean<Integer> ret = new CommonReturnBean<>();
		// 获取市统筹项目项目库信息
		List<CityPlanPrj> cpPrjList = cityPlanPrjService.getAllByPrjDb();
		String url = PRJ_DB_BASE_URL + "getProjs";
		int succ = 0;
		if(null != cpPrjList) {
			log.info("开始更新市统筹项目的项目库id！");
			for(CityPlanPrj cpPrj : cpPrjList) {
				JSONObject query = new JSONObject();
				String prjDbNo = cpPrj.getPrjDbNo();
				query.put("projno", prjDbNo);
				try {
					String resultBean = HttpUtils.doPost(query, url);
					if(null != resultBean) {
						JSONObject retJson = JSON.parseObject(resultBean);
						JSONObject userArea = retJson.getJSONObject("UserArea");
						if(null != userArea) {
//							JSONArray resultListArray = userArea.getJSONArray("resultlist");
							String resultListStr = userArea.getString("resultlist");
//							log.info("请求项目[" + prjDbNo + "]返回结果为：" + resultListStr);
							if(null != resultListStr && !resultListStr.isEmpty()) {
								List<PrjDbInfo> prjDbList = JSON.parseArray(resultListStr, PrjDbInfo.class);
								if(null != prjDbList && prjDbList.size() == 1) {
									PrjDbInfo prjDbInfo = prjDbList.get(0);
									String projid = prjDbInfo.getProjid();
									if(null != projid && !projid.isEmpty()) {
										cpPrj.setPrjDbId(projid);
										// 更新项目库编号
										int updCnt = cityPlanPrjService.updateCityPlanPrj(cpPrj);
										if(updCnt == 1) { // 更新成功
											log.info(String.format("更新[%s]项目库编号[%s]成功！项目库代码为[%s]", cpPrj.getId(), projid, prjDbNo));
											succ ++;
											continue;
										}
									}else {
										log.warn("获取的项目编号为空！项目库代码为：" + prjDbNo);
									}
								}else {
									log.warn("项目库返回resultlist数据结构不符合要求！项目库代码为：" + prjDbNo);
								}
							} else {
								log.warn("项目库返回resultlist结果为空！项目库代码为：" + prjDbNo);
							}
						}else {
							log.warn("项目库返回resultlist结果为空！项目库代码为：" + prjDbNo);
						}
					}
					
//					log.error("请求项目库信息返回结果出错！");
//					ret.setErrorCode(-111);
//					ret.setErrorMsg("更新项目库编号失败！请求项目库信息返回结果出错！");
//					return ret;
					
				} catch (IOException e) {
					log.error(e.getMessage(), e);
					ret.setErrorCode(-110);
					ret.setErrorMsg("更新项目库编号失败，系统返回IO异常！");
					return ret;
				}
			}

			log.info("更新市统筹项目的项目库id结束！项目总数为：" + cpPrjList.size() + "，成功处理数为：" + succ);
			ret.setErrorCode(0);
			ret.setErrorMsg("更新项目库编号成功！项目总数为：" + cpPrjList.size() + "，成功处理数为：" + succ);
			return ret;
		}
		
		ret.setErrorCode(-112);
		ret.setErrorMsg("更新项目库编号失败！本地数据库无记录！");
		return ret;
	}
	
	@RequestMapping(value = "update-month-progress", method = RequestMethod.POST)
	@ApiOperation(httpMethod = "POST", value = "更新项目库月进度", produces = MediaType.APPLICATION_JSON_VALUE)
	public CommonReturnBean<Integer> updatePrjProgress() {
		CommonReturnBean<Integer> ret = new CommonReturnBean<>();
		String url = PRJ_DB_BASE_URL + "getProgressCjList";
		// 获取市统筹项目项目库信息
		List<CityPlanPrj> cpPrjList = cityPlanPrjService.getAllByPrjDb();
		int total = 0;
		int succ = 0;
		SimpleDateFormat monthFmt = new SimpleDateFormat("yyyy-MM");
		Calendar c = Calendar.getInstance();
		Date nowTime = new Date();
		if(null != cpPrjList) {
			log.info("开始更新市统筹项目的月度进展！");
			for(CityPlanPrj cpPrj : cpPrjList) {
				JSONObject query = new JSONObject();
				String prjDbId = cpPrj.getPrjDbId();
				Integer prjId = cpPrj.getId();
				// 获取年记录
				List<PrjYearPrgOut> yearList = yearSerivce.getYearInfoByPrjId(prjId, IDicInfoConst.PRJ_CITY_PLAN, config.getServerPre());
				if(null == yearList || yearList.isEmpty()) {
					log.warn(String.format("市统筹项目[%s]没有年记录，请检查年记录表!", prjId));
					continue;
				}
				
				log.info(String.format("开始更新市统筹项目[%s]形象进度!", prjId));
				
				Map<Integer,Integer> yearMap = new HashMap<>();
				for(PrjYearPrgOut prjYear : yearList) {
					yearMap.put(prjYear.getYear(), prjYear.getYearId());
				}
				
				if(null != prjDbId && !prjDbId.isEmpty()) {
					query.put("projid", prjDbId);
					query.put("startzq", "2018-01");
					try {
						String resultBean = HttpUtils.doPost(query, url);
						JSONObject prgrBean = JSON.parseObject(resultBean);
						if(null != prgrBean) {
							JSONObject userAreaBean = prgrBean.getJSONObject("UserArea");
							if(null != userAreaBean) {
								JSONArray prcList = userAreaBean.getJSONArray("processlist");
								if(null != prcList && !prcList.isEmpty()) {
									Map<String, JSONObject> rerankMap = new TreeMap<>();
									for(int i=0;i<prcList.size();i++) {
										JSONObject prcsBean = prcList.getJSONObject(i);
										String tbzq = prcsBean.getString("tbzq");
										Date monthDate = monthFmt.parse(tbzq);
										c.setTime(monthDate);
										Integer y = c.get(Calendar.YEAR);
										if(y == 2018) {
											rerankMap.put(tbzq, prcsBean);
										}
									}
									total += rerankMap.size();
									
									for(Map.Entry<String, JSONObject> entry : rerankMap.entrySet()) {
										String key = entry.getKey();
										JSONObject value = entry.getValue();
										
										String actualContent = value.getString("qqxxjd");
										String issueContent = value.getString("wtyzcs");
										String proposal = value.getString("processinfo");
										String picUrl = "";
										JSONArray xxjdwcglist = value.getJSONArray("xxjdwcglist");
										if(null != xxjdwcglist && !xxjdwcglist.isEmpty()) {
											for(int j=0;j<xxjdwcglist.size();j++) {
												JSONArray filelist = xxjdwcglist.getJSONObject(j).getJSONArray("filelist");
												if(filelist != null && !filelist.isEmpty()) {
													for(int k=0;k<filelist.size();k++) {
														JSONObject fileBean = filelist.getJSONObject(k);
														String viewurl = fileBean.getString("viewurl");
														if(null != viewurl && !viewurl.isEmpty()) {
															if(!picUrl.isEmpty())
																picUrl += ",";
															picUrl += viewurl;
														}
													}
												}
											}
										}
										
										Date monthDate = monthFmt.parse(key);
										c.setTime(monthDate);
										Integer y = c.get(Calendar.YEAR);
										Integer m = c.get(Calendar.MONTH)+1;
										
										
										// 查找月份记录
										PrjMonthPlan monthPlan = monthService.getMonthPlan(IDicInfoConst.PRJ_CITY_PLAN, prjId, y, m);
										if(null != monthPlan) { // 已存在月记录
											monthPlan.setActualContent(actualContent);
											monthPlan.setIssueContent(issueContent);
											monthPlan.setProposal(proposal);
											if(!picUrl.isEmpty())
												monthPlan.setPicUrl(picUrl);
											monthPlan.setUpdateAt(nowTime);
											int updCnt = monthService.updateMonthPlan(monthPlan);
											if(updCnt == 1) {
												succ++;
												log.info(String.format("更新市统筹项目[%s]月度形象进度[%s]成功!", prjId, key));
											}
										}else {
											Integer yId = yearMap.get(y);
											if(null == yId) {
												log.warn(String.format("市统筹项目[%s]没有[%s]年记录，请检查年记录表!", prjId, y));
												continue;
											}
											monthPlan = new PrjMonthPlan();
											monthPlan.setMonth(m.byteValue());
											monthPlan.setYearId(yId);
											monthPlan.setPlanInvest(0);
											monthPlan.setActualContent(actualContent);
											monthPlan.setIssueContent(issueContent);
											monthPlan.setProposal(proposal);
											if(!picUrl.isEmpty())
												monthPlan.setPicUrl(picUrl);
											monthPlan.setUpdateAt(nowTime);
											monthPlan.setCreateAt(nowTime);
											
											int saveCnt = monthService.saveMonthPlan(monthPlan);
											if(saveCnt == 1) {
												succ++;
												log.info(String.format("更新市统筹项目[%s]月度形象进度[%s]成功!", prjId, key));
											}
										}
									}
								}else {
									log.warn("processlist返回结果为空!");
								}
							}else {
								log.warn("UserArea返回结果为空！");
							}
						}else {
							log.warn("项目库接口返回结果为空！");
						}
						log.info(String.format("更新市统筹项目[%s]形象进度结束!", prjId));
						
					} catch (IOException e) {
						log.error(e.getMessage(), e);
					} catch (ParseException e) {
						log.error(e.getMessage(), e);
					}
				}
				
			}
			String msg = String.format("更新市统筹项目形象进度结束!月进度总数[%s],成功[%s]", total, succ);
			log.info(msg);
			ret.setErrorCode(0);
			ret.setErrorMsg(msg);
			return ret;
		}
		
		ret.setErrorCode(-160);
		ret.setErrorMsg("当前数据库没有市统筹项目！");
		return ret;
	}

}
