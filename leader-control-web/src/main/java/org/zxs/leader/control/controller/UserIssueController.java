package org.zxs.leader.control.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
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
import org.zxs.leader.control.dao.model.UserIssue;
import org.zxs.leader.control.dao.model.vo.output.LoginUserOut;
import org.zxs.leader.control.dao.model.vo.output.UserIssueOut;
import org.zxs.leader.control.service.interf.IUserIssueService;

import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags="用户意见")
public class UserIssueController {
	
	@Resource
	private IUserIssueService uIssueService;
	
	@RequestMapping(value = "user-issue", method = RequestMethod.POST)
	@ApiOperation(httpMethod = "POST", value = "用户提意见", produces = MediaType.APPLICATION_JSON_VALUE)
	@Authorization
    @ApiImplicitParams({
        @ApiImplicitParam(name = IAppConst.AUTHORIZATION, value = IAppConst.AUTHORIZATION, required = true, dataType = "string", paramType = "header"),
    })
	@Trace(type=IDicInfoConst.OPT_ISSUE_RAISE)
	public CommonReturnBean<Integer> saveUserIssue(
			@RequestParam(required=false,value="title") String title,
			@RequestParam(required=true,value="content") String content, HttpSession session) {
		CommonReturnBean<Integer> saveRet = new CommonReturnBean<>();
		LoginUserOut user = (LoginUserOut) session.getAttribute(IAppConst.SESSION_USER_NAME);
		if(null == user) {
			saveRet.setErrorCode(401);
			saveRet.setErrorMsg("系统缓存出错！");
	    	return saveRet;
		}
		
		UserIssue issue = new UserIssue();
		issue.setUserId(user.getUserId());
		issue.setContent(content);
		if(null != title)
			issue.setTitle(title);
		issue.setStatus((byte) 0); // 初始状态
		issue.setIssueAt(new Date());
		int saveCnt = uIssueService.saveUserIssue(issue);
		
		if(saveCnt != 1) {
			saveRet.setErrorCode(-130);
			saveRet.setErrorMsg("保存用户意见出错！");
	    	return saveRet;
		}
		
		saveRet.setErrorCode(0);
		saveRet.setErrorMsg("成功收到用户提出的意见！");
		saveRet.setData(issue.getId());
		return saveRet;
	}
	
	@RequestMapping(value = "my-issue-page", method = RequestMethod.GET)
	@ApiOperation(httpMethod = "GET", value = "我的意见列表", produces = MediaType.APPLICATION_JSON_VALUE)
	@Authorization
    @ApiImplicitParams({
        @ApiImplicitParam(name = IAppConst.AUTHORIZATION, value = IAppConst.AUTHORIZATION, required = true, dataType = "string", paramType = "header"),
    })
	public PageReturnBean<UserIssueOut> getMyIssueByPage(
			@RequestParam(required=false,value="pageNum", defaultValue="1") Integer pageNum,
			@RequestParam(required=false,value="pageSize", defaultValue="10") Integer pageSize,
			@RequestParam(required=false,value="draw", defaultValue="") String draw, HttpSession session) {
		PageReturnBean<UserIssueOut> pageRet = new PageReturnBean<>();
		LoginUserOut user = (LoginUserOut) session.getAttribute(IAppConst.SESSION_USER_NAME);
		if(null == user) {
			pageRet.setErrorCode(401);
			pageRet.setErrorMsg("系统缓存出错！");
	    	return pageRet;
		}
		
		PageInfo<UserIssueOut> pageInfo = uIssueService.getIssueByPage(pageNum, pageSize, user.getUserId());
		
		pageRet.setErrorCode(0);
		pageRet.setDraw(draw);
		pageRet.setData(pageInfo.getList());
		pageRet.setTotal(pageInfo.getTotal());
		return pageRet;
	}

}
