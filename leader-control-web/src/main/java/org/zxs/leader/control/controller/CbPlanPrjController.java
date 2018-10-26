package org.zxs.leader.control.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import org.zxs.leader.control.dao.consts.IAppConst;
import org.zxs.leader.control.dao.consts.IDicInfoConst;
import org.zxs.leader.control.dao.model.vo.output.CbClauseOut;
import org.zxs.leader.control.dao.model.vo.output.CbFullDetailOut;
import org.zxs.leader.control.dao.model.vo.output.CbPrjPageInfoOut;
import org.zxs.leader.control.dao.model.vo.output.CbSimpleDetailOut;
import org.zxs.leader.control.dao.model.vo.output.InvestSourceOut;
import org.zxs.leader.control.dao.model.vo.output.LoginUserOut;
import org.zxs.leader.control.dao.model.vo.output.PrcSearchOut;
import org.zxs.leader.control.dao.model.vo.output.PrjMonthSimpleOut;
import org.zxs.leader.control.dao.model.vo.output.PrjStaticsOut;
import org.zxs.leader.control.dao.model.vo.query.CbPrjPageQuery;
import org.zxs.leader.control.dao.model.vo.query.PrjDetailQuery;
import org.zxs.leader.control.service.interf.ICbPlanPrjService;
import org.zxs.leader.control.service.interf.IFavoritePrjService;
import org.zxs.leader.control.service.interf.IInvestSourceService;
import org.zxs.leader.control.service.interf.IMeetingNoteService;
import org.zxs.leader.control.service.interf.IPrjIssueService;
import org.zxs.leader.control.service.interf.IPrjMonthPlanService;
import org.zxs.leader.control.service.interf.IPrjProveService;
import org.zxs.leader.control.service.interf.IPrjSearchService;
import org.zxs.leader.control.service.interf.IPrjYearPlanService;

import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags="城建计划项目查询")
public class CbPlanPrjController {
	
	private static final Log log = LogFactory.getLog(CbPlanPrjController.class);
	
	@Resource
	private ICbPlanPrjService cbPlanPrjService;
	
	@Resource
	private IPrjSearchService fuzzySearchService;
	
	@Resource
	private IFavoritePrjService favoriteSerivce;
	
	@Resource
	private IInvestSourceService investSourceService;
	
	@Resource
	private IPrjProveService prjProveSerivce;
	
	@Resource
	private IPrjYearPlanService yearSerivce;
	
	@Resource
	private IPrjMonthPlanService monthReportSerivce;
	
	@Resource
	private IPrjIssueService issueService;
	
	@Resource
	private IMeetingNoteService mNoteService;
	
	@Resource
	private CommonConfig config;

	@RequestMapping(value = "cb/prj-list", method = RequestMethod.GET)
	@Authorization
	@ApiOperation(httpMethod = "GET", value = "项目列表", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({
        @ApiImplicitParam(name = IAppConst.AUTHORIZATION, value = IAppConst.AUTHORIZATION, required = true, dataType = "string", paramType = "header"),
    })
	public List<CbPrjPageInfoOut> getCbPrjList(
			@RequestParam(required=false,value="prjId") Integer prjId,
			@RequestParam(required=false,value="rspLeaderId") Integer rspLeaderId,
			@RequestParam(required=false,value="orgId") Integer orgId,
			@RequestParam(required=false,value="areaId") Integer areaId,
			@RequestParam(required=false,value="planNo", defaultValue=IDicInfoConst.CB_LATEST_PLAN+"") Integer planNo,
			@RequestParam(required=false,value="cbFeture") Integer cbFeture,
			@RequestParam(required=false,value="cbType") Integer cbType,
			@RequestParam(required=false,value="label") Integer label,
			@RequestParam(required=false,value="isKeyPrj") Integer isKeyPrj,
			@RequestParam(required=false,value="isLngAndLatNotNull", defaultValue="1") Integer isLngAndLatNotNull,
			@RequestParam(required=false,value="isAreaCross") Integer isAreaCross,
			@RequestParam(required=false,value="keyword") String keyword,
			@RequestParam(required=false,value="completeStatus") Integer completeStatus,
			@RequestParam(required=false,value="nameLike") String nameLike,
			@RequestParam(required=false,value="month") String month,
			@RequestParam(required=false,value="isFavorite") Integer isFavorite,
			@RequestParam(required=false,value="isSelf") Integer isSelf,
			@RequestParam(required=false,value="isLeaderContact") Integer isLeaderContact,
			@RequestParam(required=false,value="orderBy") String orderBy, HttpSession session) {
		CbPrjPageQuery query = new CbPrjPageQuery();
		query.setPlanNo(planNo);
		query.setIsLngAndLatNotNull(isLngAndLatNotNull);
		if(null != rspLeaderId)
			query.setRspLeaderId(rspLeaderId);
		if(null != orgId)
			query.setOrgId(orgId);
		if(null != prjId)
			query.setPrjId(prjId);
		if(null != areaId)
			query.setAreaId(areaId);
		if(null != cbFeture)
			query.setCbFeture(cbFeture);
		if(null != cbType)
			query.setCbType(cbType);
		if(null != label)
			query.setLabel(label);
		if(null != isAreaCross)
			query.setIsAreaCross(isAreaCross);
		if(null != isKeyPrj)
			query.setIsKeyPrj(isKeyPrj);
		if(null != keyword)
			query.setKeyword(keyword);
		if(null != completeStatus)
			query.setCompleteStatus(completeStatus);
		if(null != nameLike)
			query.setNameLike(nameLike);
		if(null != isLeaderContact)
			query.setIsLeaderContact(isLeaderContact);
		if(null != month && !month.isEmpty())
			query.setMonth(month + "-01");
		if(null != orderBy)
			query.setOrderBy(orderBy);
		
		LoginUserOut user = (LoginUserOut) session.getAttribute(IAppConst.SESSION_USER_NAME);
		if(null != user) {
			int userId = user.getUserId();
			if(null != isFavorite) {
				query.setIsFavorite(isFavorite);
				query.setFavorUserId(userId);
			}
				
			int level = user.getLevel();
			if(level == 2 && null != isSelf) { // 副市长
				query.setRspLeaderId(userId);
				query.setIsSelf(isSelf);
			}else if(level == 6) { // 业主
				query.setOwnerId(userId);
				query.setUserLevel(level);
			}
		}
		return cbPlanPrjService.getCbPrjList(query);
	}
	
	@RequestMapping(value = "cb/prj-page", method = RequestMethod.GET)
	@Authorization
    @ApiOperation(httpMethod = "GET", value = "分页查询", produces = MediaType.APPLICATION_JSON_VALUE, notes="请在头部添加授权信息！")
    @ApiImplicitParams({
        @ApiImplicitParam(name = IAppConst.AUTHORIZATION, value = IAppConst.AUTHORIZATION, required = true, dataType = "string", paramType = "header"),
    })
	@Trace(type=IDicInfoConst.OPT_LIST_PRJ, prjType=IDicInfoConst.PRJ_CITY_BUILD)
	public PageReturnBean<CbPrjPageInfoOut> getMyCbPrjByPage(
			@RequestParam(required=false,value="pageNum", defaultValue="1") Integer pageNum,
			@RequestParam(required=false,value="pageSize", defaultValue="10") Integer pageSize,
			@RequestParam(required=false,value="draw", defaultValue="") String draw,
			@RequestParam(required=false,value="prjId") Integer prjId,
			@RequestParam(required=false,value="rspLeaderId") Integer rspLeaderId,
			@RequestParam(required=false,value="orgId") Integer orgId,
			@RequestParam(required=false,value="areaId") Integer areaId,
			@RequestParam(required=false,value="planNo",defaultValue=""+IDicInfoConst.CB_LATEST_PLAN) Integer planNo,
			@RequestParam(required=false,value="cbFeture") Integer cbFeture,
			@RequestParam(required=false,value="cbType") Integer cbType,
			@RequestParam(required=false,value="label") Integer label,
			@RequestParam(required=false,value="isKeyPrj") Integer isKeyPrj,
			@RequestParam(required=false,value="isLngAndLatNotNull") Integer isLngAndLatNotNull,
			@RequestParam(required=false,value="isAreaCross") Integer isAreaCross,
			@RequestParam(required=false,value="keyword") String keyword,
			@RequestParam(required=false,value="completeStatus") Integer completeStatus,
			@RequestParam(required=false,value="nameLike") String nameLike,
			@RequestParam(required=false,value="month") String month,
			@RequestParam(required=false,value="isFavorite") Integer isFavorite,
			@RequestParam(required=false,value="isSelf") Integer isSelf,
			@RequestParam(required=false,value="isLeaderContact") Integer isLeaderContact,
			@RequestParam(required=false,value="orderBy") String orderBy, HttpSession session) {
		CbPrjPageQuery query = new CbPrjPageQuery();
		query.setPlanNo(planNo);
		if(null != rspLeaderId)
			query.setRspLeaderId(rspLeaderId);
		if(null != orgId)
			query.setOrgId(orgId);
		if(null != prjId)
			query.setPrjId(prjId);
		if(null != areaId)
			query.setAreaId(areaId);
		if(null != cbFeture)
			query.setCbFeture(cbFeture);
		if(null != cbType)
			query.setCbType(cbType);
		if(null != label)
			query.setLabel(label);
		if(null != isAreaCross)
			query.setIsAreaCross(isAreaCross);
		if(null != isKeyPrj)
			query.setIsKeyPrj(isKeyPrj);
		if(null != isLngAndLatNotNull)
			query.setIsLngAndLatNotNull(isLngAndLatNotNull);
		if(null != keyword)
			query.setKeyword(keyword);
		if(null != nameLike)
			query.setNameLike(nameLike);
		if(null != completeStatus)
			query.setCompleteStatus(completeStatus);
		if(null != isLeaderContact)
			query.setIsLeaderContact(isLeaderContact);
		if(null != month && !month.isEmpty())
			query.setMonth(month + "-01");
		
		if(null != orderBy)
			query.setOrderBy(orderBy);
		
		LoginUserOut user = (LoginUserOut) session.getAttribute(IAppConst.SESSION_USER_NAME);
		if(null != user) {
			int userId = user.getUserId();
			if(null != isFavorite) {
				query.setIsFavorite(isFavorite);
				query.setFavorUserId(userId);
			}
				
			int level = user.getLevel();
			if(level == 2 && null != isSelf) { // 副市长
				query.setRspLeaderId(userId);
				query.setIsSelf(isSelf);
			}else if(level == 6) { // 业主
				query.setOwnerId(userId);
				query.setUserLevel(level);
			}
		}
		
		PageInfo<CbPrjPageInfoOut> pageInfo = cbPlanPrjService.getInfoByPage(query, pageNum, pageSize);
		PageReturnBean<CbPrjPageInfoOut> pageRet = new PageReturnBean<>();
		pageRet.setErrorCode(0);
		pageRet.setDraw(draw);
		pageRet.setData(pageInfo.getList());
		pageRet.setTotal(pageInfo.getTotal());
		return pageRet;
	}
	
	@RequestMapping(value = "cb/fuzzy-search", method = RequestMethod.GET)
	public List<PrcSearchOut> fuzzySearchCbPrj(@RequestParam(required=true,value="keyword") String keyword,
			@RequestParam(required=false,value="planNo") Integer planNo,
			@RequestParam(required=false,value="isKeyPrj") Integer isKeyPrj) {
		List<PrcSearchOut> retList = fuzzySearchService.getCbLeaderByNameLike(keyword);
		
		List<PrcSearchOut> prjList = cbPlanPrjService.getCbPrjByNameLike(keyword, planNo, isKeyPrj);
		if(prjList != null && !prjList.isEmpty()) {
			PrcSearchOut prjOut = new PrcSearchOut();
			prjOut.setValue(keyword);
			prjOut.setType(1);
			prjOut.setTypeDis("按项目名");
			retList.add(prjOut);
		}
		
		retList.addAll(cbPlanPrjService.getPrjOwnerByNameLike(keyword, planNo, isKeyPrj));
		return retList;
	}
	
	@RequestMapping(value = "cb/simple-detail/{id:\\d+}", method = RequestMethod.GET)
	@Authorization
    @ApiOperation(httpMethod = "GET", value = "简要详情查询", produces = MediaType.APPLICATION_JSON_VALUE, notes="请在头部添加授权信息！")
    @ApiImplicitParams({
        @ApiImplicitParam(name = IAppConst.AUTHORIZATION, value = IAppConst.AUTHORIZATION, required = true, dataType = "string", paramType = "header"),
    })
	@Trace(type=IDicInfoConst.OPT_DETAIL_PRJ, prjType=IDicInfoConst.PRJ_CITY_BUILD)
	public CommonReturnBean<CbSimpleDetailOut> getSimpleDetail(@PathVariable("id")Integer id, HttpSession session) {
		CommonReturnBean<CbSimpleDetailOut> detailRet = new CommonReturnBean<>();
		
		LoginUserOut user = (LoginUserOut) session.getAttribute(IAppConst.SESSION_USER_NAME);
		if(null == user) {
			detailRet.setErrorCode(401);
			detailRet.setErrorMsg("系统缓存出错！");
	    	return detailRet;
		}
		
		CbSimpleDetailOut detailOut = cbPlanPrjService.getSimpleDetailById(id);
		if(null == detailOut) {
			detailRet.setErrorCode(-203);
			detailRet.setErrorMsg("您查询的项目编号不存在！");
			return detailRet;
		}
		
		int userId = user.getUserId();
		
		// 查询用户是否关注此项目
		detailOut.setFavoriteId(favoriteSerivce.getFavoriteIdByUserAndPrj(userId, IDicInfoConst.PRJ_CITY_BUILD, id));
		
		// 查询项目业主联系人信息
		detailOut.setOwnerList(cbPlanPrjService.getOwnerListById(id));
		
		// 查询资金来源信息
		List<InvestSourceOut> investSourceList = investSourceService.getInvestSourceListByPrj(id);
		if(null != investSourceList && !investSourceList.isEmpty())
			detailOut.setSourceFundList(investSourceList);
		
		detailRet.setErrorCode(0);
		detailRet.setErrorMsg("查询城建项目基本详情成功!");
		detailRet.setData(detailOut);
		return detailRet;
	}
	
	@RequestMapping(value = "cb/full-detail/{id:\\d+}", method = RequestMethod.GET)
	@Authorization
    @ApiOperation(httpMethod = "GET", value = "全部详情查询", produces = MediaType.APPLICATION_JSON_VALUE, notes="请在头部添加授权信息！")
    @ApiImplicitParams({
        @ApiImplicitParam(name = IAppConst.AUTHORIZATION, value = IAppConst.AUTHORIZATION, required = true, dataType = "string", paramType = "header"),
    })
	@Trace(type=IDicInfoConst.OPT_DETAIL_PRJ, prjType=IDicInfoConst.PRJ_CITY_BUILD)
	public CommonReturnBean<CbFullDetailOut> getFullDetail(@PathVariable("id")Integer id,
			@RequestParam(required=false,value="year") Integer year, HttpSession session) {
		CommonReturnBean<CbFullDetailOut> detailRet = new CommonReturnBean<>();
		
		LoginUserOut user = (LoginUserOut) session.getAttribute(IAppConst.SESSION_USER_NAME);
		if(null == user) {
			detailRet.setErrorCode(401);
			detailRet.setErrorMsg("系统缓存出错！");
	    	return detailRet;
		}
		
//		if(null == year) {
//			Calendar date = Calendar.getInstance();
//	        year = date.get(Calendar.YEAR);
//		}
		
		int userId = user.getUserId();
		int userLevel = user.getLevel();
		
		if(userLevel > 5 && !cbPlanPrjService.isUserRelateCbprj(userId, id)) {
			log.info("当前用户[" + userId + "]与所查看项目[" + id + "]无关联");
			detailRet.setErrorCode(-241);
			detailRet.setErrorMsg("对不起，您无权查看此项目！");
			return detailRet;
		}
		
		PrjDetailQuery query = new PrjDetailQuery();
		query.setId(id);
		query.setUserId(userId);
		query.setLevel(userLevel);
		if(null != year)
			query.setYear(year);
		// 查询基础详情信息
		CbFullDetailOut detailOut = cbPlanPrjService.getFullDetail(query);
		
		if(null == detailOut) {
			detailRet.setErrorCode(-203);
			detailRet.setErrorMsg("您查询的项目编号不存在！");
			return detailRet;
		}
		
		// 查询用户是否关注此项目
		detailOut.setFavoriteId(favoriteSerivce.getFavoriteIdByUserAndPrj(userId, IDicInfoConst.PRJ_CITY_BUILD, id));
		
		// 查询项目业主联系人信息
		detailOut.setOwnerList(cbPlanPrjService.getOwnerListById(id));
		
		Integer latestYear = null;
		if(null != year) {
			latestYear = year;
		}else {
			String[] yearArray = detailOut.getYearArray();
			if(null != yearArray && yearArray.length > 0) {
				latestYear = Integer.parseInt(yearArray[0]);
			}
		}
		
		// 审批信息表
		detailOut.setProveList(prjProveSerivce.getByPrjId(id, IDicInfoConst.PRJ_CITY_BUILD));
		
		// 月报信息
		List<PrjMonthSimpleOut> monthList = monthReportSerivce.getMonthReportByPrjIdAndYear(id, IDicInfoConst.PRJ_CITY_BUILD, latestYear);
		if(null != monthList)
			detailOut.setMonthReportList(monthList);
		
		// 沟通信息
		detailOut.setIssueList(issueService.getIssueByPrjIdAndType(id, IDicInfoConst.PRJ_CITY_BUILD));
		
		// 附件
//		detailOut.setAttachmentList(prjInfoService.getPrjAttachments(id, userId));
		detailOut.setAttachmentList(mNoteService.getPrjAttachments(id, IDicInfoConst.PRJ_CITY_BUILD, userId));
		
		// 建设进度
		detailOut.setYearPrgList(yearSerivce.getYearInfoByPrjId(id, IDicInfoConst.PRJ_CITY_BUILD, config.getServerPre()));
		
		detailRet.setErrorCode(0);
		detailRet.setErrorMsg("查询城建项目全部详情成功!");
		detailRet.setData(detailOut);
		return detailRet;
	}
	
	@RequestMapping(value = "cb/prj-count", method = RequestMethod.GET)
	@ApiOperation(httpMethod = "GET", value = "项目计数", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Integer> cbCount(@RequestParam(required=false,value="planNo", defaultValue=IDicInfoConst.CB_LATEST_PLAN+"") Integer planNo,
			@RequestParam(required=false,value="label") Integer label,
			@RequestParam(required=false,value="isKeyPrj") Integer isKeyPrj) {
		return cbPlanPrjService.getCbCount(planNo, label, isKeyPrj);
	}
	
	@RequestMapping(value = "cb/prj-statics", method = RequestMethod.GET)
	@Authorization
    @ApiOperation(httpMethod = "GET", value = "项目统计信息", produces = MediaType.APPLICATION_JSON_VALUE, notes="请在头部添加授权信息！")
    @ApiImplicitParams({
        @ApiImplicitParam(name = IAppConst.AUTHORIZATION, value = IAppConst.AUTHORIZATION, required = true, dataType = "string", paramType = "header"),
    })
	@Trace(type=IDicInfoConst.OPT_TRAIN_PRJ, prjType=IDicInfoConst.PRJ_CITY_BUILD)
	public List<PrjStaticsOut> getCbStatics(@RequestParam(required=false,value="type", defaultValue="1") Integer type, HttpSession session) {
		List<PrjStaticsOut> retList = new ArrayList<>();
		LoginUserOut user = (LoginUserOut) session.getAttribute(IAppConst.SESSION_USER_NAME);
		if(null != user) {
			int userId = user.getUserId();
			int level = user.getLevel();
			switch(type) {
				case 1:{ // 自己负责
					if(level == 1) {
						retList.add(cbPlanPrjService.getTotalStatics());
					}else if(level == 2) {
						retList = cbPlanPrjService.getStaticsByLeaderId(userId, 1);
					}
					break;
				}
				case 2:{ // 他人负责
					if(level == 2) {
						retList = cbPlanPrjService.getStaticsByLeaderId(userId, 0);
					}else {
						retList = cbPlanPrjService.getStaticsByLeaderId(null, null);
					}
					break;
				}
				case 3:
					retList = cbPlanPrjService.getStaticsByFavorite(userId);
			}
			
		}
		return retList;
	}
	
	@RequestMapping(value = "cb/prj-clause", method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "项目分类条件列表", produces = MediaType.APPLICATION_JSON_VALUE, notes="请在头部添加授权信息！")
	public CbClauseOut getCbCaluses(@RequestParam(required=false,value="planNo",defaultValue=""+IDicInfoConst.CB_LATEST_PLAN) Integer planNo) {
		return cbPlanPrjService.getCbClauseList(planNo);
	}

}
