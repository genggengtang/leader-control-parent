package org.zxs.leader.control.controller;

import java.util.ArrayList;
import java.util.Date;
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
import org.zxs.leader.control.dao.model.ChatGroupInfo;
import org.zxs.leader.control.dao.model.ChatGroupMsg;
import org.zxs.leader.control.dao.model.MsgStatus;
import org.zxs.leader.control.dao.model.vo.output.ChatGroupBaseOut;
import org.zxs.leader.control.dao.model.vo.output.ChatGroupListOut;
import org.zxs.leader.control.dao.model.vo.output.ChatGroupSimpleOut;
import org.zxs.leader.control.dao.model.vo.output.ChatMsgOut;
import org.zxs.leader.control.dao.model.vo.output.LoginUserOut;
import org.zxs.leader.control.dao.model.vo.output.PhoneListOut;
import org.zxs.leader.control.dao.model.vo.output.PrjPhoneListOut;
import org.zxs.leader.control.dao.model.vo.output.PrjSimpleDetailOut;
import org.zxs.leader.control.dao.model.vo.query.PhoneListQuery;
import org.zxs.leader.control.dao.model.vo.query.PrjDetailQuery;
import org.zxs.leader.control.service.interf.IChatGroupInfoService;
import org.zxs.leader.control.service.interf.IChatGroupUserService;
import org.zxs.leader.control.service.interf.IMsgStatusService;
import org.zxs.leader.control.service.interf.IOrgUserService;
import org.zxs.leader.control.service.interf.IPrjInfoService;
import org.zxs.utils.CommonUtil;

import com.alibaba.fastjson.JSON;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags="群聊接口")
public class ChatGroupController {
	private static final Log log = LogFactory.getLog(ChatGroupController.class);

	@Resource
	private IChatGroupInfoService cgInfoService;
	
	@Resource
	private IOrgUserService orgUserService;
	
	@Resource
	private IChatGroupUserService cgUserService;
	
	@Resource
	private IPrjInfoService prjInfoService;
	
	@Resource
	private IMsgStatusService msgStatusService;
	
	@Resource
	private AckChatLaunch ecLaunch;
	
	@RequestMapping(value = "create-chat-room", method = RequestMethod.POST)
	@Authorization
	@ApiOperation(httpMethod = "POST", value = "创建聊天室", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({
        @ApiImplicitParam(name = IAppConst.AUTHORIZATION, value = IAppConst.AUTHORIZATION, required = true, dataType = "string", paramType = "header"),
    })
	@Trace(type=IDicInfoConst.OPT_CHAT_CREATE)
	public CommonReturnBean<ChatGroupSimpleOut> createChatRoom(
			@RequestParam(required=false,value="groupName") String groupName,
			@RequestParam(required=false,value="prjType",defaultValue="" + IDicInfoConst.PRJ_LEADER_CONTROL) Integer prjType,
			@RequestParam(required=false,value="prjId") Integer prjId,
			@RequestParam(required=false,value="introduce") String introduce,
//			@RequestParam(required=false,value="userArray[]") Integer[] userArray, 
			@RequestParam(required=false,value="userArray") String userArrayStr, HttpSession session) {
		CommonReturnBean<ChatGroupSimpleOut> createRet = new CommonReturnBean<>();
		log.info("开始创建聊天室，用户群为：" + userArrayStr);
		LoginUserOut user = (LoginUserOut) session.getAttribute(IAppConst.SESSION_USER_NAME);
    	if(null != user) {
    		ChatGroupInfo cgInfo = new ChatGroupInfo();
    		cgInfo.setGroupName(groupName);
    		cgInfo.setIntroduce(introduce);
    		
    		if(null == prjId) {
    			cgInfo.setType(ChatGroupInfo.TYPE_MIME);
    		} else {
    			cgInfo.setType(ChatGroupInfo.TYPE_WORK);
    			cgInfo.setPrjId(prjId);
    			cgInfo.setPrjType(prjType);
    		}
    		
    		cgInfo.setEnableRemove((short) 1);
    		cgInfo.setCreateAt(new Date());
    		
    		List<Integer> userList = JSON.parseArray(userArrayStr, Integer.class);
    		
    		try {
    			Integer roomId = cgInfoService.createChatRoom(cgInfo, user.getUserId(), userList);
        		if(null == roomId) {
        			createRet.setErrorCode(-302);
        			createRet.setErrorMsg("创建群聊失败！");
        			return createRet;
        		}
        		
        		
        		ChatGroupSimpleOut cgSimple = new ChatGroupSimpleOut();
        		cgSimple.setId(roomId);
        		cgSimple.setGroupName(cgInfo.getGroupName());
        		cgSimple.setGroupNum(userList.size() + 1);
        		cgSimple.setCreateAt(CommonUtil.formMysqlDate(cgInfo.getCreateAt()));
        		if(null != prjId) {
        			PrjDetailQuery query = new PrjDetailQuery();
        			query.setId(prjId);
        			query.setUserId(user.getUserId());
        			query.setLevel(user.getLevel());
        			
        			PrjSimpleDetailOut prjInfo = prjInfoService.getInfoById(query);
        			cgSimple.setPrjName(prjInfo.getFullName());
        		}
        		
        		ecLaunch.addMsgEventListener(cgInfo);
        		createRet.setErrorCode(0);
    			createRet.setErrorMsg("创建群聊成功！");
    			createRet.setData(cgSimple);
    			log.info("创建群聊成功！用户群为：" + userArrayStr);
    			return createRet;
    		}catch(Exception e) {
    			log.error(e.getMessage(), e);
    		}
    		
    	}
    	createRet.setErrorCode(401);
    	createRet.setErrorMsg("系统缓存出错！");
		return createRet;
	}
	
	@RequestMapping(value = "my-phone-list", method = RequestMethod.GET)
	@Authorization
	@ApiOperation(httpMethod = "GET", value = "我的通讯录", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({
        @ApiImplicitParam(name = IAppConst.AUTHORIZATION, value = IAppConst.AUTHORIZATION, required = true, dataType = "string", paramType = "header"),
    })
	public List<PhoneListOut> getMyPhoneList(
			@RequestParam(required=false,value="cgId") Integer cgId,
			@RequestParam(required=false,value="prjType") Integer prjType,
			@RequestParam(required=false,value="prjId") Integer prjId,
			@RequestParam(required=false,value="isUserIn") Integer isUserIn, 
			@RequestParam(required=false,value="nameLike") String nameLike,
			@RequestParam(required=false,value="userSelected") String userSelected, HttpSession session) {
		List<PhoneListOut> phoneList = new ArrayList<>();
		LoginUserOut user = (LoginUserOut) session.getAttribute(IAppConst.SESSION_USER_NAME);
		if(null == user) {
			return phoneList;
		}
		
		PhoneListQuery query = new PhoneListQuery();
		query.setUserId(user.getUserId());
		query.setUserLevel(user.getLevel());
		if(null != cgId) {
			query.setCgId(cgId);
			ChatGroupBaseOut baseInfo = cgInfoService.getFullChatGroupInfoById(cgId);
			Integer pId = baseInfo.getPrjId();
			Integer pType = baseInfo.getPrjType();
			if(null != pId)
				query.setPrjId(pId);
			if(null != pType)
				query.setPrjType(pType);
		}else {
			if(null != prjId && null != prjType) {
				query.setPrjId(prjId);
				query.setPrjType(prjType);
			}
		}
			
		if(null != isUserIn)
			query.setIsUserIn(isUserIn);
		if(null != nameLike)
			query.setNameLike(nameLike);
		if(null != userSelected)
			query.setUserSelected(JSON.parseArray(userSelected, Integer.class));
		else
			query.setUserSelected(new ArrayList<>());
		phoneList = orgUserService.getPhoneList(query);
    	
		return phoneList;
	}
	
	@RequestMapping(value = "my-cg-list", method = RequestMethod.GET)
	@Authorization
	@ApiOperation(httpMethod = "GET", value = "我的群组列表", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({
        @ApiImplicitParam(name = IAppConst.AUTHORIZATION, value = IAppConst.AUTHORIZATION, required = true, dataType = "string", paramType = "header"),
    })
	@Trace(type=IDicInfoConst.OPT_LETTER)
	public ChatGroupListOut getMyChatGroupList(HttpSession session, @RequestParam(required=false,value="nameLike") String nameLike) {
		LoginUserOut user = (LoginUserOut) session.getAttribute(IAppConst.SESSION_USER_NAME);
		if(null == user) {
			return null;
		}
		int userId = user.getUserId();
		return cgInfoService.getChatGroupFullInfoWithNameLike(userId, nameLike);
	}
	
	@RequestMapping(value = "cg-info/{id}", method = RequestMethod.GET)
	@ApiOperation(httpMethod = "GET", value = "群组详情", produces = MediaType.APPLICATION_JSON_VALUE)
	public ChatGroupBaseOut getChatGroupInfo(@PathVariable("id")Integer id) {
		return cgInfoService.getFullChatGroupInfoById(id);
	}
	
	@RequestMapping(value = "my-cg-info/{id}", method = RequestMethod.GET)
	@ApiOperation(httpMethod = "GET", value = "我的群组", produces = MediaType.APPLICATION_JSON_VALUE)
	@Authorization
	@ApiImplicitParams({
        @ApiImplicitParam(name = IAppConst.AUTHORIZATION, value = IAppConst.AUTHORIZATION, required = true, dataType = "string", paramType = "header"),
    })
	public ChatGroupBaseOut getMyChatGroupInfo(@PathVariable("id")Integer id, HttpSession session) {
		LoginUserOut user = (LoginUserOut) session.getAttribute(IAppConst.SESSION_USER_NAME);
		if(null == user) {
			return null;
		}
		ChatGroupBaseOut baseOut = cgInfoService.getFullChatGroupInfoById(id);
		int userId = user.getUserId();
		Boolean isAdmin = cgUserService.isGroupAdmin(userId, id);
		if(null != isAdmin)
			baseOut.setIsGroupAdmin(isAdmin);
		return baseOut;
	}
	
	@RequestMapping(value = "prj-phone-list/{id}", method = RequestMethod.GET)
	@Authorization
	@ApiOperation(httpMethod = "GET", value = "我的通讯录", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({
        @ApiImplicitParam(name = IAppConst.AUTHORIZATION, value = IAppConst.AUTHORIZATION, required = true, dataType = "string", paramType = "header"),
    })
	public PrjPhoneListOut getPrjPhoneList(@PathVariable("id") Integer id,
			@RequestParam(required=false,value="prjType",defaultValue=""+IDicInfoConst.PRJ_LEADER_CONTROL) Integer prjType,
			@RequestParam(required=false,value="nameLike") String nameLike, HttpSession session) {
		PrjPhoneListOut prjPhoneList = new PrjPhoneListOut();
		LoginUserOut user = (LoginUserOut) session.getAttribute(IAppConst.SESSION_USER_NAME);
		if(null == user) {
			return prjPhoneList;
		}
		
		PhoneListQuery query = new PhoneListQuery();
		int userId = user.getUserId();
		query.setUserId(userId);
		query.setUserLevel(user.getLevel());
		query.setPrjId(id);
		query.setPrjType(prjType);
		if(null != nameLike)
			query.setNameLike(nameLike);
		prjPhoneList.setBookList(orgUserService.getPhoneList(query));
		
		prjPhoneList.setCgList(cgInfoService.getPrjChatGroupInfoByPrjId(prjType, id, userId));
		return prjPhoneList;
	}
	
	@RequestMapping(value = "my-cg-remove/{id}", method = RequestMethod.DELETE)
	@Authorization
	@ApiOperation(httpMethod = "DELETE", value = "解散聊天群组", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({
        @ApiImplicitParam(name = IAppConst.AUTHORIZATION, value = IAppConst.AUTHORIZATION, required = true, dataType = "string", paramType = "header"),
    })
	@Trace(type=IDicInfoConst.OPT_CHAT_RM)
	public CommonReturnBean<Integer> removeChatRoom(@PathVariable("id") Integer id, HttpSession session) {
		CommonReturnBean<Integer> rmRet = new CommonReturnBean<>();
		log.info("开始解散聊天群组：" + id);
		LoginUserOut user = (LoginUserOut) session.getAttribute(IAppConst.SESSION_USER_NAME);
    	if(null != user) {
    		boolean isOwner = cgUserService.isUserGroupOwner(user.getUserId(), id);
    		if(!isOwner) {
    			rmRet.setErrorCode(-303);
    			rmRet.setErrorMsg("权限不足！");
    			return rmRet;
    		}
    		
    		// 判断群聊组是否存在
    		ChatGroupSimpleOut cgOut = cgInfoService.getSimpleChatGroupInfoById(id);
    		if(null == cgOut) {
    			rmRet.setErrorCode(-304);
    			rmRet.setErrorMsg("该聊天群组可能已解散！");
    			return rmRet;
    		}
    		
    		if(cgOut.getEnableRemove() == 0) { // 不能解散
    			rmRet.setErrorCode(-311);
    			rmRet.setErrorMsg("该聊天群组不能解散！");
    			return rmRet;
    		}
    		
    		log.info("删除所有未读信息及群组信息!");
    		MsgStatus msgStatus = new MsgStatus();
    		msgStatus.setReadStatus(MsgStatus.STATUS_UNREAD);
    		msgStatus.setPushStatus(MsgStatus.STATUS_UNPUSH);
    		msgStatus.setChatGroupId(id);
    		msgStatusService.delete(msgStatus);
    		
    		log.info("通知所有在线客户端群组已解散！");
    		ChatMsgOut rmMsg = new ChatMsgOut();
    		rmMsg.setMsgAt(CommonUtil.formMysqlDate(new Date()));
    		rmMsg.setShMsgType(ChatGroupMsg.TYPE_DISSOLUTION);
    		ecLaunch.notifyAllRoomClients(id, rmMsg);
    		
    		cgInfoService.deleteChatGroupById(id);
    		
    		rmRet.setErrorCode(0);
			rmRet.setErrorMsg("解散群聊组成功！");
			log.info("解散群聊组[" + id + "]结束！");
			return rmRet;
    	}
    	rmRet.setErrorCode(401);
    	rmRet.setErrorMsg("系统缓存出错！");
		return rmRet;
	}
	
	@RequestMapping(value = "update-cg-name/{id}", method = RequestMethod.POST)
	@Authorization
	@ApiOperation(httpMethod = "POST", value = "修改群聊组名", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({
        @ApiImplicitParam(name = IAppConst.AUTHORIZATION, value = IAppConst.AUTHORIZATION, required = true, dataType = "string", paramType = "header"),
    })
	@Trace(type=IDicInfoConst.OPT_CHAT_NAME_MDF)
	public CommonReturnBean<String> updateCgName(@PathVariable("id") Integer id,
			@RequestParam(required=true,value="name") String name, HttpSession session) {
		CommonReturnBean<String> updNameRet = new CommonReturnBean<>();
		log.info("开始修改聊天群组[" + id + "]名称！");
		if(name.length() > 100) {
			updNameRet.setErrorCode(-313);
			updNameRet.setErrorMsg("修改的名字不能超过100字！");
			return updNameRet;
		}
		LoginUserOut user = (LoginUserOut) session.getAttribute(IAppConst.SESSION_USER_NAME);
    	if(null != user) {
    		boolean isOwner = cgUserService.isUserGroupOwner(user.getUserId(), id);
    		if(!isOwner) {
    			updNameRet.setErrorCode(-303);
    			updNameRet.setErrorMsg("权限不足！");
    			return updNameRet;
    		}
    		
    		// 判断群聊组是否存在
    		ChatGroupSimpleOut cgOut = cgInfoService.getSimpleChatGroupInfoById(id);
    		if(null == cgOut) {
    			updNameRet.setErrorCode(-304);
    			updNameRet.setErrorMsg("该聊天群组可能已解散！");
    			return updNameRet;
    		}
    		
    		Integer enableNameUpdate = cgOut.getEnableRemove();
    		if(null == enableNameUpdate || enableNameUpdate == 0) {
    			updNameRet.setErrorCode(-315);
    			updNameRet.setErrorMsg("该群不能改名！");
    			return updNameRet;
    		}
    		
    		int updCnt = cgInfoService.updateCgName(id, name);
    		if(updCnt == 0) {
    			updNameRet.setErrorCode(-314);
    			updNameRet.setErrorMsg("更改聊天群组名称失败！");
    			return updNameRet;
    		}
    		
    		updNameRet.setErrorCode(0);
			updNameRet.setErrorMsg("修改群聊组名字成功！");
			updNameRet.setData(name);
			log.info("修改群聊组[" + id + "]名字结束！");
			return updNameRet;
    	}
    	updNameRet.setErrorCode(401);
    	updNameRet.setErrorMsg("系统缓存出错！");
		return updNameRet;
	}
	
}
