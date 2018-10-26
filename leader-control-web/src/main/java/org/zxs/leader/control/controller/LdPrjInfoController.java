package org.zxs.leader.control.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
import org.zxs.leader.control.dao.model.PrjContact;
import org.zxs.leader.control.dao.model.vo.output.LoginUserOut;
import org.zxs.leader.control.dao.model.vo.output.PrcSearchOut;
import org.zxs.leader.control.dao.model.vo.output.PrjFullDetailOut;
import org.zxs.leader.control.dao.model.vo.output.PrjListInfoOut;
import org.zxs.leader.control.dao.model.vo.output.PrjMonthSimpleOut;
import org.zxs.leader.control.dao.model.vo.output.PrjSimpleDetailOut;
import org.zxs.leader.control.dao.model.vo.output.PrjStaticsOut;
import org.zxs.leader.control.dao.model.vo.query.PrjCountQuery;
import org.zxs.leader.control.dao.model.vo.query.PrjDetailQuery;
import org.zxs.leader.control.dao.model.vo.query.PrjPageQuery;
import org.zxs.leader.control.service.interf.ICbPlanPrjService;
import org.zxs.leader.control.service.interf.IFavoritePrjService;
import org.zxs.leader.control.service.interf.IMeetingNoteService;
import org.zxs.leader.control.service.interf.IOrgUserService;
import org.zxs.leader.control.service.interf.IPrjContactService;
import org.zxs.leader.control.service.interf.IPrjInfoService;
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
@Api(tags="市领导联系项目查询")
public class LdPrjInfoController {
	private static final Log log = LogFactory.getLog(LdPrjInfoController.class);
	
	@Resource
	private IPrjInfoService prjInfoService;
	
	@Resource
	private IPrjContactService prjContactService;
	
	@Resource
	private IFavoritePrjService favoriteSerivce;
	
	@Resource
	private IPrjProveService prjProveSerivce;
	
	@Resource
	private IPrjYearPlanService yearSerivce;
	
	@Resource
	private IPrjMonthPlanService monthReportSerivce;
	
	@Resource
	private IPrjIssueService issueService;
	
	@Resource
	private IPrjSearchService fuzzySearchService;
	
	@Resource
	private IOrgUserService orgUserService;
	
	@Resource
	private ICbPlanPrjService cbPrjService;
	
	@Resource
	private IMeetingNoteService mNoteService;
	
	@Resource
	private CommonConfig config;

	@RequestMapping(value = "prj-list", method = RequestMethod.GET)
	@Authorization
	@ApiOperation(httpMethod = "GET", value = "项目列表", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({
        @ApiImplicitParam(name = IAppConst.AUTHORIZATION, value = IAppConst.AUTHORIZATION, required = true, dataType = "string", paramType = "header"),
    })
	public List<PrjListInfoOut> getPrjList(
			@RequestParam(required=false,value="prjName") String prjName,
			@RequestParam(required=false,value="prjId") Integer prjId,
//			@RequestParam(required=false,value="leaderId") Integer leaderId,
			@RequestParam(required=false,value="rspLeaderId") Integer rspLeaderId,
			@RequestParam(required=false,value="prjUser") Integer prjUser, // 与项目相关人员
			@RequestParam(required=false,value="orgId") Integer orgId,
			@RequestParam(required=false,value="is60thWelfare") Integer is60thWelfare,
			@RequestParam(required=false,value="isPrvcPlan") Integer isPrvcPlan,
			@RequestParam(required=false,value="group") Integer group,
			@RequestParam(required=false,value="areaId") Integer areaId,
			@RequestParam(required=false,value="planStatus") Integer planStatus,
			@RequestParam(required=false,value="industry") Integer industry,
			@RequestParam(required=false,value="isAreaCross") Integer isAreaCross,
			@RequestParam(required=false,value="keyword") String keyword,
			@RequestParam(required=false,value="completeStatus") Integer completeStatus,
			@RequestParam(required=false,value="isFavorite") Integer isFavorite,
			@RequestParam(required=false,value="isSelf") Integer isSelf,
			@RequestParam(required=false,value="month") String month,
			@RequestParam(required=false,value="nameLike") String nameLike,
			@RequestParam(required=false,value="ownerLike") String ownerLike,
			@RequestParam(required=false,value="orderBy") String orderBy, HttpSession session) {
		PrjPageQuery query = new PrjPageQuery();
		if(null != prjName)
			query.setPrjName(prjName);
		if(null != prjId)
			query.setPrjId(prjId);
		if(null != rspLeaderId)
			query.setRspLeaderId(rspLeaderId);
		if(null != orgId)
			query.setOrgId(orgId);
		if(null != is60thWelfare)
			query.setIs60thWelfare(is60thWelfare);
		if(null != isPrvcPlan)
			query.setIsPrvcPlan(isPrvcPlan);
		if(null != group)
			query.setGroup(group);
		if(null != areaId)
			query.setAreaId(areaId);
		if(null != planStatus)
			query.setPlanStatus(planStatus);
		if(null != industry)
			query.setIndustry(industry);
		if(null != isAreaCross)
			query.setIsAreaCross(isAreaCross);
		if(null != keyword)
			query.setKeyword(keyword);
		if(null != completeStatus)
			query.setCompleteStatus(completeStatus);
		if(null != month && !month.isEmpty())
			query.setMonth(month + "-01");
		if(null != nameLike)
			query.setNameLike(nameLike);
		if(null != ownerLike)
			query.setOwnerLike(ownerLike);
		if(null != orderBy)
			query.setOrderBy(orderBy);
		if(null != prjUser)
			query.setPrjUser(prjUser);
		
		LoginUserOut user = (LoginUserOut) session.getAttribute(IAppConst.SESSION_USER_NAME);
		if(null != user) {
			int userId = user.getUserId();
			int level = user.getLevel();
			if(level == 2) { // 副市长
				query.setLeaderId(userId);
				
				if(null != isSelf)
					query.setIsSelf(isSelf);
			}else if(level == 6) { // 业主
				query.setLeaderId(userId);
				query.setUserLevel(level);
			}
			
			if(null != isFavorite) {
				query.setLeaderId(userId);
				query.setIsFavorite(isFavorite);
			}
		}
		
		query.setIsLngAndLatNotNull(1); // 只查询经纬度非空的项目
		return prjInfoService.getAllInfo(query);
	}
	
	@RequestMapping(value = "prj-page", method = RequestMethod.GET)
	@Authorization
    @ApiOperation(httpMethod = "GET", value = "本人负责项目的分页查询", produces = MediaType.APPLICATION_JSON_VALUE, notes="请在头部添加授权信息！")
    @ApiImplicitParams({
        @ApiImplicitParam(name = IAppConst.AUTHORIZATION, value = IAppConst.AUTHORIZATION, required = true, dataType = "string", paramType = "header"),
    })
	@Trace(type=IDicInfoConst.OPT_LIST_PRJ, prjType=IDicInfoConst.PRJ_LEADER_CONTROL)
	public PageReturnBean<PrjListInfoOut> getMyPrjInfoByPage(
			@RequestParam(required=false,value="pageNum", defaultValue="1") Integer pageNum,
			@RequestParam(required=false,value="pageSize", defaultValue="10") Integer pageSize,
			@RequestParam(required=false,value="draw", defaultValue="") String draw,
			@RequestParam(required=false,value="prjName") String prjName,
			@RequestParam(required=false,value="prjId") Integer prjId,
			@RequestParam(required=false,value="rspLeaderId") Integer rspLeaderId,
			@RequestParam(required=false,value="prjUser") Integer prjUser, // 与项目相关人员
			@RequestParam(required=false,value="orgId") Integer orgId,
			@RequestParam(required=false,value="is60thWelfare") Integer is60thWelfare,
			@RequestParam(required=false,value="isPrvcPlan") Integer isPrvcPlan,
			@RequestParam(required=false,value="group") Integer group,
			@RequestParam(required=false,value="areaId") Integer areaId,
			@RequestParam(required=false,value="planStatus") Integer planStatus,
			@RequestParam(required=false,value="industry") Integer industry,
			@RequestParam(required=false,value="isAreaCross") Integer isAreaCross,
			@RequestParam(required=false,value="completeStatus") Integer completeStatus,
			@RequestParam(required=false,value="isFavorite") Integer isFavorite,
			@RequestParam(required=false,value="isSelf") Integer isSelf,
			@RequestParam(required=false,value="keyword") String keyword,
			@RequestParam(required=false,value="nameLike") String nameLike,
			@RequestParam(required=false,value="ownerLike") String ownerLike,
			@RequestParam(required=false,value="month") String month,
			@RequestParam(required=false,value="orderBy") String orderBy, HttpSession session) {
		PrjPageQuery query = new PrjPageQuery();
		
		if(null != prjName)
			query.setPrjName(prjName);
		if(null != prjId)
			query.setPrjId(prjId);
		if(null != rspLeaderId)
			query.setRspLeaderId(rspLeaderId);
		if(null != orgId)
			query.setOrgId(orgId);
		if(null != is60thWelfare)
			query.setIs60thWelfare(is60thWelfare);
		if(null != isPrvcPlan)
			query.setIsPrvcPlan(isPrvcPlan);
		if(null != group)
			query.setGroup(group);
		if(null != areaId)
			query.setAreaId(areaId);
		if(null != planStatus)
			query.setPlanStatus(planStatus);
		if(null != industry)
			query.setIndustry(industry);
		if(null != isAreaCross)
			query.setIsAreaCross(isAreaCross);
		if(null != completeStatus)
			query.setCompleteStatus(completeStatus);
		if(null != keyword)
			query.setKeyword(keyword);
		if(null != nameLike)
			query.setNameLike(nameLike);
		if(null != ownerLike)
			query.setOwnerLike(ownerLike);
		if(null != month && !month.isEmpty())
			query.setMonth(month + "-01");
		if(null != orderBy)
			query.setOrderBy(orderBy);
		if(null != prjUser)
			query.setPrjUser(prjUser);
		
		LoginUserOut user = (LoginUserOut) session.getAttribute(IAppConst.SESSION_USER_NAME);
		if(null != user) {
			int userId = user.getUserId();
			if(null != isFavorite) {
				query.setLeaderId(userId);
				query.setIsFavorite(isFavorite);
			}
			
			int level = user.getLevel();
			if(level > 1 && level < 6) { // 有项目关联的领导
				query.setLeaderId(userId);
				
				if(null != isSelf)
					query.setIsSelf(isSelf);
			}else if(level == 6) { // 业主
				query.setLeaderId(userId);
				query.setUserLevel(level);
			}
		}
		
		PageInfo<PrjListInfoOut> pageInfo = prjInfoService.getInfoByPage(query, pageNum, pageSize);
		PageReturnBean<PrjListInfoOut> pageRet = new PageReturnBean<>();
		pageRet.setErrorCode(0);
		pageRet.setDraw(draw);
		pageRet.setData(pageInfo.getList());
		pageRet.setTotal(pageInfo.getTotal());
		return pageRet;
	}
	
	@RequestMapping(value = "ld-prj-page", method = RequestMethod.GET)
	@Authorization
    @ApiOperation(httpMethod = "GET", value = "市领导联系项目分页查询", produces = MediaType.APPLICATION_JSON_VALUE, notes="请在头部添加授权信息！")
    @ApiImplicitParams({
        @ApiImplicitParam(name = IAppConst.AUTHORIZATION, value = IAppConst.AUTHORIZATION, required = true, dataType = "string", paramType = "header"),
    })
	@Trace(type=IDicInfoConst.OPT_LIST_PRJ, prjType=IDicInfoConst.PRJ_LEADER_CONTROL)
	public PageReturnBean<PrjListInfoOut> getMyLdPrjInfoByPage(
			@RequestParam(required=false,value="pageNum", defaultValue="1") Integer pageNum,
			@RequestParam(required=false,value="pageSize", defaultValue="10") Integer pageSize,
			@RequestParam(required=false,value="draw", defaultValue="") String draw,
			@RequestBody PrjPageQuery query, HttpSession session) {
		
		LoginUserOut user = (LoginUserOut) session.getAttribute(IAppConst.SESSION_USER_NAME);
		if(null != user) {
			int userId = user.getUserId();
			Integer isFavorite = query.getIsFavorite();
			if(null != isFavorite) {
				query.setLeaderId(userId);
			}
			
			int level = user.getLevel();
			if(level > 1 && level < 6) { // 有项目关联的领导
				query.setLeaderId(userId);
			}else if(level == 6) { // 业主
				query.setLeaderId(userId);
				query.setUserLevel(level);
			}
		}
		
		PageInfo<PrjListInfoOut> pageInfo = prjInfoService.getInfoByPage(query, pageNum, pageSize);
		PageReturnBean<PrjListInfoOut> pageRet = new PageReturnBean<>();
		pageRet.setErrorCode(0);
		pageRet.setDraw(draw);
		pageRet.setData(pageInfo.getList());
		pageRet.setTotal(pageInfo.getTotal());
		return pageRet;
	}
	
	@RequestMapping(value = "prj-simple-detail/{id:\\d+}", method = RequestMethod.GET)
	@Authorization
    @ApiOperation(httpMethod = "GET", value = "项目简要信息", produces = MediaType.APPLICATION_JSON_VALUE, notes="请在头部添加授权信息！")
    @ApiImplicitParams({
        @ApiImplicitParam(name = IAppConst.AUTHORIZATION, value = IAppConst.AUTHORIZATION, required = true, dataType = "string", paramType = "header"),
    })
	@Trace(type=IDicInfoConst.OPT_DETAIL_PRJ, prjType=IDicInfoConst.PRJ_LEADER_CONTROL)
	public CommonReturnBean<PrjSimpleDetailOut> getPrjSimpleDetail(@PathVariable("id")Integer id, HttpSession session) {
		CommonReturnBean<PrjSimpleDetailOut> detailRet = new CommonReturnBean<>();
		
		LoginUserOut user = (LoginUserOut) session.getAttribute(IAppConst.SESSION_USER_NAME);
		
		if(null == user) {
			detailRet.setErrorCode(401);
			detailRet.setErrorMsg("系统缓存出错！");
	    	return detailRet;
		}
		
		int userId = user.getUserId();
		int userLevel = user.getLevel();
		
		PrjDetailQuery query = new PrjDetailQuery();
		query.setId(id);
		query.setUserId(userId);
		query.setLevel(userLevel);
			
		// 查询基础详情信息
		PrjSimpleDetailOut detailOut = prjInfoService.getInfoById(query);
		if(null == detailOut) {
			detailRet.setErrorCode(-203);
			detailRet.setErrorMsg("您查询的项目编号不存在！");
			return detailRet;
		}
		
		// 查询业主联系人信息
		PrjContact ownerContact = new PrjContact();
		ownerContact.setPrjId(id);
		ownerContact.setType(IDicInfoConst.PRJ_CONTACT_OWNER);
		ownerContact.setUserId(userId);
		detailOut.setOwnerList(prjContactService.getContactByPrjIdAndType(ownerContact, userLevel)); 
		detailOut.setIsOwner(prjInfoService.isPrjRspLeader(id, userId));
		detailOut.setFavoriteId(favoriteSerivce.getFavoriteIdByUserAndPrj(userId, IDicInfoConst.PRJ_LEADER_CONTROL, id));
		
		// 查询责任单位联系人信息
		PrjContact rspContact = new PrjContact();
		rspContact.setPrjId(id);
		rspContact.setType(IDicInfoConst.PRJ_CONTACT_RSP);
		rspContact.setUserId(userId);
		detailOut.setRspContactList(prjContactService.getContactByPrjIdAndType(rspContact, userLevel));
		
		// 查询现场联系人信息
		PrjContact directContact = new PrjContact();
		directContact.setPrjId(id);
		directContact.setType(IDicInfoConst.PRJ_CONTACT_DIRECT);
		directContact.setUserId(userId);
		detailOut.setDirectList(prjContactService.getContactByPrjIdAndType(directContact, userLevel));
		
		detailRet.setErrorCode(0);
		detailRet.setData(detailOut);
		return detailRet;
	}
	
	@RequestMapping(value = "prj-full-detail/{id:\\d+}", method = RequestMethod.GET)
	@Authorization
    @ApiOperation(httpMethod = "GET", value = "项目详细信息", produces = MediaType.APPLICATION_JSON_VALUE, notes="请在头部添加授权信息！")
    @ApiImplicitParams({
        @ApiImplicitParam(name = IAppConst.AUTHORIZATION, value = IAppConst.AUTHORIZATION, required = true, dataType = "string", paramType = "header"),
    })
	@Trace(type=IDicInfoConst.OPT_DETAIL_PRJ, prjType=IDicInfoConst.PRJ_LEADER_CONTROL)
	public CommonReturnBean<PrjFullDetailOut> getPrjFullDetail(@PathVariable("id")Integer id,
			@RequestParam(required=false,value="year") Integer year, HttpSession session) {
		CommonReturnBean<PrjFullDetailOut> detailRet = new CommonReturnBean<>();
		
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
		
		// 6级用户需要判断是否跟项目相关
		if(userLevel > 5 && !prjContactService.isUserRelateLdprj(userId, id)) {
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
		PrjFullDetailOut detailOut = prjInfoService.getFullInfoById(query);
		if(null == detailOut) {
			detailRet.setErrorCode(-203);
			detailRet.setErrorMsg("您查询的项目编号不存在！");
			return detailRet;
		}
		
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
		detailOut.setProveList(prjProveSerivce.getByPrjId(id, IDicInfoConst.PRJ_LEADER_CONTROL));
		
		// 月报信息
		List<PrjMonthSimpleOut> monthList = monthReportSerivce.getMonthReportByPrjIdAndYear(id, IDicInfoConst.PRJ_LEADER_CONTROL, latestYear);
		if(null != monthList)
			detailOut.setMonthReportList(monthList);
		
		// 沟通信息
		detailOut.setIssueList(issueService.getIssueByPrjIdAndType(id, IDicInfoConst.PRJ_LEADER_CONTROL));
		
		// 附件
//		detailOut.setAttachmentList(prjInfoService.getPrjAttachments(id, userId));
		detailOut.setAttachmentList(mNoteService.getPrjAttachments(id, IDicInfoConst.PRJ_LEADER_CONTROL, userId));
		
		// 建设进度
		detailOut.setYearPrgList(yearSerivce.getYearInfoByPrjId(id, IDicInfoConst.PRJ_LEADER_CONTROL, config.getServerPre()));
		
		detailOut.setIsOwner(prjInfoService.isPrjRspLeader(id, userId));
		detailOut.setFavoriteId(favoriteSerivce.getFavoriteIdByUserAndPrj(userId, IDicInfoConst.PRJ_LEADER_CONTROL, id));
		
		// 查询业主联系人信息
		PrjContact ownerContact = new PrjContact();
		ownerContact.setPrjId(id);
		ownerContact.setType(IDicInfoConst.PRJ_CONTACT_OWNER);
		ownerContact.setUserId(userId);
		detailOut.setOwnerList(prjContactService.getContactByPrjIdAndType(ownerContact, userLevel)); 
		detailOut.setIsOwner(prjInfoService.isPrjRspLeader(id, userId));
		detailOut.setFavoriteId(favoriteSerivce.getFavoriteIdByUserAndPrj(userId, IDicInfoConst.PRJ_LEADER_CONTROL, id));
		
		// 查询责任单位联系人信息
		PrjContact rspContact = new PrjContact();
		rspContact.setPrjId(id);
		rspContact.setType(IDicInfoConst.PRJ_CONTACT_RSP);
		rspContact.setUserId(userId);
		detailOut.setRspContactList(prjContactService.getContactByPrjIdAndType(rspContact, userLevel));
		
		// 查询现场联系人信息
		PrjContact directContact = new PrjContact();
		directContact.setPrjId(id);
		directContact.setType(IDicInfoConst.PRJ_CONTACT_DIRECT);
		directContact.setUserId(userId);
		detailOut.setDirectList(prjContactService.getContactByPrjIdAndType(directContact, userLevel));
		
		detailRet.setErrorCode(0);
		detailRet.setData(detailOut);
		return detailRet;
	}
	
	@RequestMapping(value = "fuzzy-search", method = RequestMethod.GET)
	public List<PrcSearchOut> fuzzySearch(@RequestParam(required=true,value="keyword") String keyword) {
		List<PrcSearchOut> retList =  fuzzySearchService.getLeaderByNameLike(keyword);
		
		List<PrcSearchOut> prjList = prjInfoService.getPrjByNameLike(keyword);
		if(prjList != null && !prjList.isEmpty()) {
			PrcSearchOut prjOut = new PrcSearchOut();
			prjOut.setValue(keyword);
			prjOut.setType(1);
			prjOut.setTypeDis("按项目名");
			retList.add(prjOut);
		}
		
		List<PrcSearchOut> ownerList = prjContactService.getPrjOwnerByNameLike(keyword);
		if(null != ownerList && !ownerList.isEmpty())
			retList.addAll(ownerList);
		return retList;
	}
	
	@RequestMapping(value = "prj-statics", method = RequestMethod.GET)
	@Authorization
    @ApiOperation(httpMethod = "GET", value = "项目统计信息", produces = MediaType.APPLICATION_JSON_VALUE, notes="请在头部添加授权信息！")
    @ApiImplicitParams({
        @ApiImplicitParam(name = IAppConst.AUTHORIZATION, value = IAppConst.AUTHORIZATION, required = true, dataType = "string", paramType = "header"),
    })
	@Trace(type=IDicInfoConst.OPT_TRAIN_PRJ, prjType=IDicInfoConst.PRJ_LEADER_CONTROL)
	public List<PrjStaticsOut> getPrjStatics(@RequestParam(required=false,value="type", defaultValue="1") Integer type, HttpSession session) {
		List<PrjStaticsOut> retList = new ArrayList<>();
		LoginUserOut user = (LoginUserOut) session.getAttribute(IAppConst.SESSION_USER_NAME);
		if(null != user) {
			int userId = user.getUserId();
			int level = user.getLevel();
			
			switch(type) {
				case 1:{ // 自己负责
					if(level == 1) {
						retList.add(prjInfoService.getTotalStatics());
					}else if(level > 1) {
						retList = prjInfoService.getStaticsByLeaderId(userId);
					}
					break;
				}
				case 2:{ // 他人负责
//					if(level > 1) {
//						retList = prjInfoService.getStaticsByLeaderId(userId, 0);
//					}else {
//						retList = prjInfoService.getStaticsByLeaderId(null, null);
//					}
					retList = prjInfoService.getStaticsByLeaderId(null);
					break;
				}
				case 3:
					retList = prjInfoService.getStaticsByFavorite(userId);
			}
			
		}
		
		return retList;
	}
	
	@RequestMapping(value = "prj-count", method = RequestMethod.GET)
	@ApiOperation(httpMethod = "GET", value = "项目计数", produces = MediaType.APPLICATION_JSON_VALUE)
	public Integer prjCount(@RequestParam(required=false,value="groupId") Integer groupId,
			@RequestParam(required=false,value="is60thWelfare") Integer is60thWelfare,
			@RequestParam(required=false,value="isPrvcPlan") Integer isPrvcPlan) {
		PrjCountQuery query = new PrjCountQuery();
		if(null != groupId)
			query.setGroupId(groupId);
		if(null != is60thWelfare)
			query.setIs60thWelfare(is60thWelfare);
		if(null != isPrvcPlan)
			query.setIsPrvcPlan(isPrvcPlan);
		return prjInfoService.getPrjCount(query);
	}
}
