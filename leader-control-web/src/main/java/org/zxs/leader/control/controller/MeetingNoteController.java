package org.zxs.leader.control.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import org.zxs.leader.control.dao.consts.IAppConst;
import org.zxs.leader.control.dao.consts.IDicInfoConst;
import org.zxs.leader.control.dao.model.FavoriteNote;
import org.zxs.leader.control.dao.model.vo.output.LoginUserOut;
import org.zxs.leader.control.dao.model.vo.output.MyMeetingNoteOut;
import org.zxs.leader.control.dao.model.vo.query.MeetingNoteQuery;
import org.zxs.leader.control.service.interf.IDicInfoService;
import org.zxs.leader.control.service.interf.IHeaderService;
import org.zxs.leader.control.service.interf.IMeetingNoteFavoriteService;
import org.zxs.leader.control.service.interf.IMeetingNoteService;

import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags="会议纪要接口")
public class MeetingNoteController {
	
	private static final Log log = LogFactory.getLog(MeetingNoteController.class);
	
	@Resource
	private IMeetingNoteService meetingNoteService;
	
	@Resource
	private IMeetingNoteFavoriteService meetingNoteFavoriteService;
	
	@Resource
	private IHeaderService headerService;
	
	@Resource
	private IDicInfoService dicInfoService;
	
	@RequestMapping(value = "meeting-note-page", method = RequestMethod.GET)
	@Authorization
	@ApiOperation(httpMethod = "GET", value = "会议纪要分页列表", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({
        @ApiImplicitParam(name = IAppConst.AUTHORIZATION, value = IAppConst.AUTHORIZATION, required = true, dataType = "string", paramType = "header"),
    })
	@Trace(type=IDicInfoConst.OPT_INFO_NOTE)
	public PageReturnBean<MyMeetingNoteOut> getMeetingNoteByPage(
			@RequestParam(required=false,value="pageNum", defaultValue="1") Integer pageNum,
			@RequestParam(required=false,value="pageSize", defaultValue="10") Integer pageSize,
			@RequestParam(required=false,value="draw", defaultValue="") String draw,
			@RequestParam(required=false,value="prjType",defaultValue=""+IDicInfoConst.PRJ_LEADER_CONTROL) Integer prjType,
			@RequestParam(required=false,value="type") String type,
			@RequestParam(required=false,value="isFavorite") Integer isFavorite,
			@RequestParam(required=false,value="keyword") String keyword,
			@RequestParam(required=false,value="startDate") String startDate,
			@RequestParam(required=false,value="endDate") String endDate,
			@RequestParam(required=false,value="isInspectIn",defaultValue="0") Integer isInspectIn,
			HttpSession session) {
		PageReturnBean<MyMeetingNoteOut> pageRet = new PageReturnBean<>();
		LoginUserOut user = (LoginUserOut) session.getAttribute(IAppConst.SESSION_USER_NAME);
		if(null == user) {
			pageRet.setErrorCode(401);
			pageRet.setErrorMsg("系统缓存失效！");
			return pageRet;
		}
		
		MeetingNoteQuery query = new MeetingNoteQuery();
		query.setUserId(user.getUserId());
		query.setPrjType(prjType);
		query.setIsInspectIn(isInspectIn);
		if(type != null && !type.isEmpty()) {
			query.setType(type);
		}
		if(isFavorite != null)
			query.setIsFavorite(isFavorite);
		if(keyword != null)
			query.setKeyword(keyword);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		if(null != startDate && !startDate.isEmpty()) {
			try {
				query.setStartAt(dateFormat.parse(startDate.trim() + " 00:00:00"));
			} catch (ParseException e) {
				log.warn("startDate参数时间格式不对！");
			}
		}
		
		if(null != endDate && !endDate.isEmpty()) {
			try {
				query.setEndAt(dateFormat.parse(endDate + " 23:59:59"));
			} catch (ParseException e) {
				log.warn("endDate参数时间格式不对！");
			}
		}
		
		PageInfo<MyMeetingNoteOut> pageInfo = meetingNoteService.getMeetingNoteByPage(pageNum, pageSize, query);
		
		pageRet.setErrorCode(0);
		pageRet.setDraw(draw);
		pageRet.setData(pageInfo.getList());
		pageRet.setTotal(pageInfo.getTotal());
		return pageRet;
	}
	
	
	@RequestMapping(value = "add-note-favorite/{id}", method = RequestMethod.POST)
	@Authorization
    @ApiOperation(httpMethod = "POST", value = "收藏会议纪要", produces = MediaType.APPLICATION_JSON_VALUE, notes="请在头部添加授权信息！")
    @ApiImplicitParams({
        @ApiImplicitParam(name = IAppConst.AUTHORIZATION, value = IAppConst.AUTHORIZATION, required = true, dataType = "string", paramType = "header"),
    })
	@Trace(type=IDicInfoConst.OPT_DOC_FAVOR)
	public CommonReturnBean<Integer> addNoteFavorite(@PathVariable("id") Integer id, HttpSession session) {
		CommonReturnBean<Integer> ret = new CommonReturnBean<>();
		if(!meetingNoteService.isMeetingNoteExist(id)){
			ret.setErrorCode(-401);
			ret.setErrorMsg("您查询的会议纪要编号不存在！");
			return ret;
		}
		
		LoginUserOut user = (LoginUserOut) session.getAttribute(IAppConst.SESSION_USER_NAME);
		if(null == user) {
			ret.setErrorCode(401);
			ret.setErrorMsg("系统缓存失效！");
			return ret;
		}
		
		int userId = user.getUserId();
		
		if(meetingNoteFavoriteService.isFavoriteMeetingNote(id, userId)) {
			ret.setErrorCode(-402);
			ret.setErrorMsg("您已关注该会议纪要，不能重复关注！");
			return ret;
		}
		
		FavoriteNote favor = new FavoriteNote();
		favor.setUserId(userId);
		favor.setNoteId(id);
		favor.setCreateAt(new Date());
		int iInsertRet = meetingNoteFavoriteService.addFavorite(favor);
		if(iInsertRet == 0) {
			ret.setErrorCode(-403);
			ret.setErrorMsg("收藏会议纪要失败！");
			return ret;
		}
		
		ret.setErrorCode(0);
		ret.setErrorMsg("收藏会议纪要成功！");
		ret.setData(iInsertRet);
		return ret;
	}

	@RequestMapping(value = "remove-note-favorite/{id}", method = RequestMethod.POST)
    @ApiOperation(httpMethod = "POST", value = "取消会议纪要收藏", produces = MediaType.APPLICATION_JSON_VALUE)
	@Trace(type=IDicInfoConst.OPT_DOC_NOTFAVOR)
	public CommonReturnBean<Integer> removeNoteFavorite(@PathVariable("id")Integer id) {
		CommonReturnBean<Integer> ret = new CommonReturnBean<>();
		
		if(!meetingNoteFavoriteService.isFavoriteExist(id)){
			ret.setErrorCode(-404);
			ret.setErrorMsg("您查询的会议纪要未关注！");
			return ret;
		}
		
		int iDelRet = meetingNoteFavoriteService.removeFavorite(id);
		if(iDelRet == 0) {
			ret.setErrorCode(-405);
			ret.setErrorMsg("会议纪要取消关注失败！");
			return ret;
		}
		
		ret.setErrorCode(0);
		ret.setErrorMsg("会议纪要取消关注成功！");
		return ret;
	}
	
}
