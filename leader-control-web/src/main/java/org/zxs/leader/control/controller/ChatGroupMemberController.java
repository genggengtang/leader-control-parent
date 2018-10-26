package org.zxs.leader.control.controller;

import java.util.List;

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
import org.zxs.leader.control.controller.annotation.Authorization;
import org.zxs.leader.control.controller.annotation.Trace;
import org.zxs.leader.control.dao.consts.IAppConst;
import org.zxs.leader.control.dao.consts.IDicInfoConst;
import org.zxs.leader.control.dao.model.ChatGroupMsg;
import org.zxs.leader.control.dao.model.vo.output.ChatGroupSimpleOut;
import org.zxs.leader.control.dao.model.vo.output.ChatMemberOut;
import org.zxs.leader.control.dao.model.vo.output.ChatMsgOut;
import org.zxs.leader.control.dao.model.vo.output.LoginUserOut;
import org.zxs.leader.control.service.interf.IChatGroupInfoService;
import org.zxs.leader.control.service.interf.IChatGroupUserService;
import org.zxs.leader.control.service.interf.IOrgUserService;
import org.zxs.leader.control.service.interf.IPrjInfoService;

import com.alibaba.fastjson.JSON;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags="群聊用户增减接口")
public class ChatGroupMemberController {
	private static final Log log = LogFactory.getLog(ChatGroupMemberController.class);

	@Resource
	private IChatGroupInfoService cgInfoService;
	
	@Resource
	private IOrgUserService orgUserService;
	
	@Resource
	private IChatGroupUserService cgUserService;
	
	@Resource
	private IPrjInfoService prjInfoService;
	
	@Resource
	private AckChatLaunch ecLaunch;
	
	@RequestMapping(value = "cg-member-add/{id}", method = RequestMethod.POST)
	@Authorization
	@ApiOperation(httpMethod = "POST", value = "添加群组成员", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({
        @ApiImplicitParam(name = IAppConst.AUTHORIZATION, value = IAppConst.AUTHORIZATION, required = true, dataType = "string", paramType = "header"),
    })
	@Trace(type=IDicInfoConst.OPT_CHAT_MEMBER_ADD)
	public CommonReturnBean<ChatGroupSimpleOut> addCgMember(@PathVariable("id")Integer id, 
//			@RequestParam(required=true,value="userArray[]") Integer[] userArray,
			@RequestParam(required=true,value="userArray") String userArrayStr,
			HttpSession session) {
		log.info("开始添加群组用户，用户群为[" + userArrayStr + "]，群聊组为[" + id + "]");
		CommonReturnBean<ChatGroupSimpleOut> addRet = new CommonReturnBean<>();
		
		LoginUserOut user = (LoginUserOut) session.getAttribute(IAppConst.SESSION_USER_NAME);
		if(null == user) {
			addRet.setErrorCode(401);
			addRet.setErrorMsg("系统缓存失效，请重新登录!");
			return addRet;
		}
		
		// 判断是否默认群
//		ChatGroupSimpleOut cginfo = cgInfoService.getSimpleChatGroupInfoById(id);
//		if(cginfo.getEnableRemove() == 0) { // 默认群组
//			addRet.setErrorCode(-311);
//			addRet.setErrorMsg("默认工作群不能加人！");
//			return addRet;
//		}
		
		// 判断本人是否在群里，群外人员无权添加群成员
		int userId = user.getUserId();
		if(!cgUserService.isGroupAdmin(userId, id)) {
			addRet.setErrorCode(-303);
			addRet.setErrorMsg("您无权添加该群组员！");
			return addRet;
		}
		
		List<Integer> userList = JSON.parseArray(userArrayStr, Integer.class);
		
		CommonReturnBean<ChatMemberOut> addOut = cgUserService.addCgMember(id, userList);
		int addOutCode = addOut.getErrorCode();
		if(addOutCode != 0) {
			addRet.setErrorCode(addOutCode);
			addRet.setErrorMsg(addOut.getErrorMsg());
			return addRet;
		}
		
		ChatMemberOut addDataOut = addOut.getData();
		
		ChatMsgOut msgData = new ChatMsgOut();
		msgData.setShMsgType(ChatGroupMsg.TYPE_ADD_MEMBER);
		msgData.setsUserIds(addDataOut.getsIds());
		msgData.setsUserNames(addDataOut.getsNames());
		msgData.setShUserNum(addDataOut.getCount());
		
		ecLaunch.notifyAllRoomClients(id, msgData);
		
		ChatGroupSimpleOut simpleInfo = cgInfoService.getSimpleChatGroupInfoById(id);
		addRet.setErrorCode(0);
		addRet.setErrorMsg("添加群聊组成员成功！");
		addRet.setData(simpleInfo);
		log.info("添加群组用户成功，用户群为[" + userArrayStr + "]，群聊组为[" + id + "]");
		return addRet;
	}
	
	@RequestMapping(value = "cg-member-remove/{id}", method = RequestMethod.POST)
	@Authorization
	@ApiOperation(httpMethod = "POST", value = "移除群组成员", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({
        @ApiImplicitParam(name = IAppConst.AUTHORIZATION, value = IAppConst.AUTHORIZATION, required = true, dataType = "string", paramType = "header"),
    })
	@Trace(type=IDicInfoConst.OPT_CHAT_MEMBER_RM)
	public CommonReturnBean<ChatGroupSimpleOut> removeCgMember(@PathVariable("id")Integer id, 
//			@RequestParam(required=true,value="userArray[]") Integer[] userArray,
			@RequestParam(required=true,value="userArray") String userArrayStr,
			HttpSession session) {
		log.info("开始移除群组用户，用户群为[" + userArrayStr + "]，群聊组为[" + id + "]");
		CommonReturnBean<ChatGroupSimpleOut> addRet = new CommonReturnBean<>();
		
		LoginUserOut user = (LoginUserOut) session.getAttribute(IAppConst.SESSION_USER_NAME);
		if(null == user) {
			addRet.setErrorCode(401);
			addRet.setErrorMsg("系统缓存失效，请重新登录!");
			return addRet;
		}
		
		// 判断是否默认群
//		ChatGroupSimpleOut cginfo = cgInfoService.getSimpleChatGroupInfoById(id);
//		if(cginfo.getEnableRemove() == 0) { // 默认群组
//			addRet.setErrorCode(-311);
//			addRet.setErrorMsg("默认工作群不能减人！");
//			return addRet;
//		}
		
		// 判断本人是否在群主，非群主无权移除群成员
//		int userId = user.getUserId();
//		if(!cgUserService.isUserGroupOwner(userId, id)) {
//			addRet.setErrorCode(-303);
//			addRet.setErrorMsg("权限不足！");
//			return addRet;
//		}
		
		// 判断本人是否有权限
		int userId = user.getUserId();
		if(!cgUserService.isGroupAdmin(userId, id)) {
			addRet.setErrorCode(-303);
			addRet.setErrorMsg("您无权删除该群组员！");
			return addRet;
		}
		List<Integer> userList = JSON.parseArray(userArrayStr, Integer.class);
		
		CommonReturnBean<ChatMemberOut> rmOut = cgUserService.removeCgMember(id, userList);
		int rmOutCode = rmOut.getErrorCode();
		if(rmOutCode != 0) {
			addRet.setErrorCode(rmOutCode);
			addRet.setErrorMsg(rmOut.getErrorMsg());
			return addRet;
		}
		
		ChatMemberOut rmDataOut = rmOut.getData();
		
		ChatMsgOut msgData = new ChatMsgOut();
		msgData.setShMsgType(ChatGroupMsg.TYPE_REMOVE_MEMBER);
		msgData.setShUserNum(rmDataOut.getCount());
		msgData.setsUserIds(rmDataOut.getsIds());
		msgData.setsUserNames(rmDataOut.getsNames());
		
		ecLaunch.notifyAllRoomClients(id, msgData);
		
		ChatGroupSimpleOut simpleInfo = cgInfoService.getSimpleChatGroupInfoById(id);
		addRet.setErrorCode(0);
		addRet.setErrorMsg("移除群聊组成员成功！");
		addRet.setData(simpleInfo);
		log.info("移除群组用户成功，用户群为[" + userArrayStr + "]，群聊组为[" + id + "]");
		return addRet;
	}
}
