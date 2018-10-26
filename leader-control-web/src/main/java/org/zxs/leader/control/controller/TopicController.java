package org.zxs.leader.control.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Base64.Decoder;

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
import org.zxs.base.model.BussinessException;
import org.zxs.base.model.CommonReturnBean;
import org.zxs.base.model.PageReturnBean;
import org.zxs.leader.control.controller.annotation.Authorization;
import org.zxs.leader.control.controller.annotation.Trace;
import org.zxs.leader.control.dao.consts.IAppConst;
import org.zxs.leader.control.dao.consts.IDicInfoConst;
import org.zxs.leader.control.dao.model.ChatGroupInfo;
import org.zxs.leader.control.dao.model.ChatGroupMsg;
import org.zxs.leader.control.dao.model.TopicPic;
import org.zxs.leader.control.dao.model.vo.output.ChatMsgOut;
import org.zxs.leader.control.dao.model.vo.output.LoginUserOut;
import org.zxs.leader.control.dao.model.vo.output.TopicDetailOut;
import org.zxs.leader.control.dao.model.vo.output.TopicPicOut;
import org.zxs.leader.control.service.interf.IChatGroupInfoService;
import org.zxs.leader.control.service.interf.IChatGroupMsgService;
import org.zxs.leader.control.service.interf.IChatGroupUserService;
import org.zxs.leader.control.service.interf.ITopicPicService;
import org.zxs.leader.control.service.interf.ITopicUnreadService;
import org.zxs.utils.UploadQiniu;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags="随手拍接口")
public class TopicController {
	private static final Log log = LogFactory.getLog(TopicController.class);
	
	@Resource
	private ITopicPicService topicPicService;
	
	@Resource
	private IChatGroupInfoService cgInfoService;
	
	@Resource
	private IChatGroupMsgService cgMsgService;
	
	@Resource
	private IChatGroupUserService cgUserService;
	
	@Resource
	private ITopicUnreadService topicUnreadService;
	
	@Resource
	private AckChatLaunch ecLaunch;
	
//	@RequestMapping(value = "create-topic", method = RequestMethod.POST)
//	@ApiOperation(httpMethod = "POST", value = "发送随手拍", produces = MediaType.APPLICATION_JSON_VALUE)
//	@Authorization
//	@ApiImplicitParams({
//        @ApiImplicitParam(name = IAppConst.AUTHORIZATION, value = IAppConst.AUTHORIZATION, required = true, dataType = "string", paramType = "header"),
//    })
//	public CommonReturnBean<Integer> createTopic(
//			@RequestParam(required=false,value="cgId") Integer cgId,
//			@RequestParam(required=false,value="userArray") String userArray,
//			@RequestParam(required=true,value="content") String content,
//			@RequestParam(required=true,value="picName") String picName,
//			@ApiParam(value = "选择的照片文件", required = true) MultipartFile picFile, HttpSession session) {
//		CommonReturnBean<Integer> ret = new CommonReturnBean<>();
//		
//		LoginUserOut user = (LoginUserOut) session.getAttribute(IAppConst.SESSION_USER_NAME);
//		if(null == user) {
//			ret.setErrorCode(401);
//			ret.setErrorMsg("系统缓存出错！");
//	    	return ret;
//		}
//		
//		String username = user.getUsername();
//		log.info("用户[" + username + "]开始发送随手拍！");
//		
//		if(cgId == null && (userArray == null || userArray.isEmpty())) {
//			ret.setErrorCode(-103);
//			ret.setErrorMsg("参数不正确，群聊组或通讯录成员必须传一项！");
//			return ret;
//		}
//		
//		Integer receiveCgId = 0;
//		
//		if(cgId != null)
//			receiveCgId = cgId;
//			
//		int userId = user.getUserId();
//		List<Integer> userList = null;
//		if(null != userArray && !userArray.isEmpty()) {
//			userList = JSON.parseArray(userArray, Integer.class);
//			if(null == userList || userList.isEmpty()) {
//				ret.setErrorCode(-103);
//				ret.setErrorMsg("参数不正确，选择的用户为空！");
//				return ret;
//			}
//			
//			// 创建聊天室
//			log.info("开始创建聊天室，成员为" + userArray);
//			ChatGroupInfo cgInfo = new ChatGroupInfo();
//    		cgInfo.setIntroduce("");
//    		
//			cgInfo.setType(ChatGroupInfo.TYPE_MIME);
//    		
//    		cgInfo.setEnableRemove((short) 1);
//    		cgInfo.setCreateAt(new Date());
//			Integer roomId = cgInfoService.createChatRoom(cgInfo, userId, userList);
//    		if(null == roomId) {
//    			ret.setErrorCode(-302);
//    			ret.setErrorMsg("创建群聊失败！");
//    			return ret;
//    		}
//    		
//    		receiveCgId = roomId;
//		}else {
//			// 根据群聊组编号，获取所有组员
//			userList = cgUserService.getUserByCgId(cgId, userId);
//		} 
//		
//		try {
//			// 发送图片文件到七牛
//			String picUrl = UploadQiniu.uploadImgQiniu(picFile.getInputStream(), "pic/" + System.currentTimeMillis() + "/" + picName);
//			
//			TopicPic tp = new TopicPic();
//			tp.setReceiveCgId(receiveCgId);
//			tp.setSendUserId(userId);
//			tp.setContent(content);
//			tp.setPicUrl(picUrl);
//			
//			int saveRet = topicPicService.saveTopicPic(tp, userList);
//			if(saveRet == 1) {
//				log.info("用户[" + username + "]提交随手拍成功，系统将发通知消息给目标群聊组！");
//				
//				ChatMsgOut chatMsg = new ChatMsgOut();
//				chatMsg.setFileUrl(tp.getPicUrl());
//				chatMsg.setShMsgType(ChatGroupMsg.TYPE_TOPIC);
//				chatMsg.setMsgContent(tp.getContent());
//				chatMsg.setUserName(username);
//				chatMsg.setTopicId(tp.getId());
//				chatMsg.setUserId(userId);
//				
//				ChatMsgOut saveMsgOut = cgMsgService.saveChatMsg(chatMsg, receiveCgId);
//				
//				if(null != saveMsgOut) {
//					log.info("聊天记录保存成功!" + JSON.toJSONString(chatMsg));
//					ecLaunch.notifyAllRoomClients(receiveCgId, saveMsgOut);
//					log.info("用户[" + username + "]发送随手拍完成！");
//					
//					ret.setErrorCode(0);
//					ret.setErrorMsg("随手拍发送成功！");
//				}else {
//					ret.setErrorCode(-105);
//					ret.setErrorMsg("发送随手拍聊天消息失败！");
//				}
//				
//				return ret;
//			}else {
//				ret.setErrorCode(-321);
//				ret.setErrorMsg("用户[" + username + "]发送随手拍失败！");
//				return ret;
//			}
//		} catch (IOException e) {
//			log.error(e.getMessage(), e);
//			ret.setErrorCode(-104);
//			ret.setErrorMsg("随手拍上传图片失败！");
//			return ret;
//		} catch (BussinessException e) {
//			log.error(e.getMessage(), e);
//			ret.setErrorCode(-104);
//			ret.setErrorMsg(e.getMessage());
//			return ret;
//		}
//	}
	
	@RequestMapping(value = "create-topic", method = RequestMethod.POST)
	@ApiOperation(httpMethod = "POST", value = "发送随手拍", produces = MediaType.APPLICATION_JSON_VALUE)
	@Authorization
	@ApiImplicitParams({
        @ApiImplicitParam(name = IAppConst.AUTHORIZATION, value = IAppConst.AUTHORIZATION, required = true, dataType = "string", paramType = "header"),
    })
	@Trace(type=IDicInfoConst.OPT_TOPIC_SEND)
	public CommonReturnBean<Integer> createTopic(
			@RequestParam(required=false,value="cgId") Integer cgId,
			@RequestParam(required=false,value="userArray") String userArray,
			@RequestParam(required=true,value="content") String content,
			@RequestParam(required=true,value="picName") String picName,
			@RequestParam(required=true,value="picFile") String picFile, HttpSession session) {
		CommonReturnBean<Integer> ret = new CommonReturnBean<>();
		
		LoginUserOut user = (LoginUserOut) session.getAttribute(IAppConst.SESSION_USER_NAME);
		if(null == user) {
			ret.setErrorCode(401);
			ret.setErrorMsg("系统缓存出错！");
	    	return ret;
		}
		
		if(content.length() > 500) {
			ret.setErrorCode(-123);
			ret.setErrorMsg("描述内容不能超过500字！");
			return ret;
		}
		
		if(!picFile.contains(",")) {
			ret.setErrorCode(-122);
			ret.setErrorMsg("图片内容上传参数出错！");
			return ret;
		}
		
		String username = user.getUsername();
		log.info("用户[" + username + "]开始发送随手拍！");
		
		if(cgId == null && (userArray == null || userArray.isEmpty())) {
			ret.setErrorCode(-103);
			ret.setErrorMsg("参数不正确，群聊组或通讯录成员必须传一项！");
			return ret;
		}
		
		Integer receiveCgId = 0;
		
		TopicPic tp = new TopicPic();
		if(cgId != null) {
			receiveCgId = cgId;
			tp.setIsNewGroup((byte) 0);
		}
			
		int userId = user.getUserId();
		try {
			List<Integer> userList = null;
			if(null != userArray && !userArray.isEmpty()) {
				userList = JSON.parseArray(userArray, Integer.class);
				if(null == userList || userList.isEmpty()) {
					ret.setErrorCode(-103);
					ret.setErrorMsg("参数不正确，选择的用户为空！");
					return ret;
				}
				
				// 创建聊天室
				log.info("开始创建聊天室，成员为" + userArray);
				ChatGroupInfo cgInfo = new ChatGroupInfo();
	    		cgInfo.setIntroduce("");
	    		
				cgInfo.setType(ChatGroupInfo.TYPE_OTHER);
	    		
	    		cgInfo.setEnableRemove((short) 1);
	    		cgInfo.setCreateAt(new Date());
				Integer roomId = cgInfoService.createChatRoom(cgInfo, userId, userList);
	    		if(null == roomId) {
	    			ret.setErrorCode(-302);
	    			ret.setErrorMsg("创建群聊失败！");
	    			return ret;
	    		}
	    		
	    		receiveCgId = roomId;
	    		
	    		tp.setIsNewGroup((byte) 1);
			}else {
				// 根据群聊组编号，获取所有组员
				userList = cgUserService.getUserByCgId(cgId, userId);
			} 
		
			// 发送图片文件到七牛
			Decoder decoder = Base64.getDecoder();
			byte[] imgData = decoder.decode(picFile.substring(picFile.indexOf(",")+1));
			
			String picUrl = UploadQiniu.uploadImgQiniu(new ByteArrayInputStream(imgData), "pic/" + System.currentTimeMillis() + "/" + picName);
			
			tp.setReceiveCgId(receiveCgId);
			tp.setSendUserId(userId);
			tp.setContent(content);
			tp.setPicUrl(picUrl);
			tp.setActiveStatus((byte) 1);
			tp.setReplyStatus((byte) 0);
			
			int saveRet = topicPicService.saveTopicPic(tp, userList);
			if(saveRet == 1) {
				if(cgId != null) { // 目标为群组
					log.info("用户[" + username + "]提交随手拍成功，系统将发通知消息给目标群聊组！");
					ChatMsgOut chatMsg = new ChatMsgOut();
					chatMsg.setFileUrl(tp.getPicUrl());
					chatMsg.setShMsgType(ChatGroupMsg.TYPE_TOPIC);
					chatMsg.setMsgContent(tp.getContent());
					chatMsg.setUserName(username);
					chatMsg.setTopicId(tp.getId());
					chatMsg.setUserId(userId);
					
					ChatMsgOut saveMsgOut = cgMsgService.saveChatMsg(chatMsg, receiveCgId);
					
					if(null != saveMsgOut) {
						// ecLaunch.notifyAllRoomClients(receiveCgId, saveMsgOut);
						log.info("系统发送群聊消息成功，聊天室为[" + receiveCgId + "],用户[" + username + "]发送随手拍完成！");
					}
				}
				
				// 发出推送
				ecLaunch.sendPushMsg(userId, true);
				ret.setErrorCode(0);
				ret.setErrorMsg("随手拍发送成功！");
				return ret;
			}
			
			ret.setErrorCode(-321);
			ret.setErrorMsg("用户[" + username + "]发送随手拍失败！");
			return ret;
			
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			ret.setErrorCode(-104);
			ret.setErrorMsg("随手拍上传图片失败！");
			return ret;
		} catch (BussinessException e) {
			log.error(e.getMessage(), e);
			ret.setErrorCode(-104);
			ret.setErrorMsg(e.getMessage());
			return ret;
		}
	}
	
	@RequestMapping(value = "my-topic-page", method = RequestMethod.GET)
	@ApiOperation(httpMethod = "GET", value = "我的随手拍列表", produces = MediaType.APPLICATION_JSON_VALUE)
	@Authorization
	@ApiImplicitParams({
        @ApiImplicitParam(name = IAppConst.AUTHORIZATION, value = IAppConst.AUTHORIZATION, required = true, dataType = "string", paramType = "header"),
    })
	@Trace(type=IDicInfoConst.OPT_TOPIC_PAGE)
	public PageReturnBean<TopicPicOut> getMyTopicByPage(
			@RequestParam(required=false,value="pageNum", defaultValue="1") Integer pageNum,
			@RequestParam(required=false,value="pageSize", defaultValue="10") Integer pageSize,
			@RequestParam(required=false,value="draw", defaultValue="") String draw, HttpSession session) {
		PageReturnBean<TopicPicOut> pageRet = new PageReturnBean<>();
		LoginUserOut user = (LoginUserOut) session.getAttribute(IAppConst.SESSION_USER_NAME);
		if(null == user) {
			pageRet.setErrorCode(401);
			pageRet.setErrorMsg("系统缓存出错！");
	    	return pageRet;
		}
		
		PageInfo<TopicPicOut> pageInfo = topicPicService.getMyTopicByPage(pageNum, pageSize, user.getUserId());
		
		pageRet.setErrorCode(0);
		pageRet.setDraw(draw);
		pageRet.setData(pageInfo.getList());
		pageRet.setTotal(pageInfo.getTotal());
		return pageRet;
	}
	
	@RequestMapping(value = "topic-detail/{id:\\d+}", method = RequestMethod.GET)
	@ApiOperation(httpMethod = "GET", value = "随手拍详情", produces = MediaType.APPLICATION_JSON_VALUE)
	@Authorization
	@ApiImplicitParams({
        @ApiImplicitParam(name = IAppConst.AUTHORIZATION, value = IAppConst.AUTHORIZATION, required = true, dataType = "string", paramType = "header"),
    })
	@Trace(type=IDicInfoConst.OPT_TOPIC_DETAIL)
	public CommonReturnBean<TopicDetailOut> getTopicDetail(@PathVariable("id")Integer id, HttpSession session) {
		CommonReturnBean<TopicDetailOut> ret = new CommonReturnBean<>();
		LoginUserOut user = (LoginUserOut) session.getAttribute(IAppConst.SESSION_USER_NAME);
		if(null == user) {
			ret.setErrorCode(401);
			ret.setErrorMsg("系统缓存出错！");
	    	return ret;
		}
		
		// 更新未读消息状态
		int userId = user.getUserId();
		int updCnt = topicUnreadService.updateUnreadCommentStatus(id, userId);
		log.info(String.format("用户[%s]更新了[%s]条未读评论消息数！", user.getUsername(), updCnt));
		
		TopicDetailOut detail = topicPicService.getTopicDetail(id);
		if(null == detail) {
			ret.setErrorCode(-323);
			ret.setErrorMsg("随手拍主题不存在或已被作者删除！");
	    	return ret;
		}
		
		if(userId == detail.getSendUserId()) {
			detail.setIsAuthor(1);
		}else {
			detail.setIsAuthor(0);
		}
		
		// 通知新未读消息数
		ecLaunch.sendUnreadMsg(userId);
		
		ret.setErrorCode(0);
		ret.setErrorMsg("获取随手拍主题详情成功！");
		ret.setData(detail);
		return ret;
	}
	
	@RequestMapping(value = "send-comment/{id:\\d+}", method = RequestMethod.POST)
	@ApiOperation(httpMethod = "POST", value = "发送随手拍评论", produces = MediaType.APPLICATION_JSON_VALUE)
	@Authorization
	@ApiImplicitParams({
        @ApiImplicitParam(name = IAppConst.AUTHORIZATION, value = IAppConst.AUTHORIZATION, required = true, dataType = "string", paramType = "header"),
    })
	@Trace(type=IDicInfoConst.OPT_COMMENT_SEND)
	public CommonReturnBean<Integer> sendComment(@PathVariable("id")Integer id, 
			@RequestParam(required=true,value="content") String content, HttpSession session) {
		CommonReturnBean<Integer> ret = new CommonReturnBean<>();
		LoginUserOut user = (LoginUserOut) session.getAttribute(IAppConst.SESSION_USER_NAME);
		if(null == user) {
			ret.setErrorCode(401);
			ret.setErrorMsg("系统缓存出错！");
	    	return ret;
		}
		
		int userId = user.getUserId();
		int sendRet = topicPicService.sendComment(id, userId, content);
		if(sendRet != 1) {
			ret.setErrorCode(-322);
			ret.setErrorMsg("发送随手拍评论失败！");
			return ret;
		}
		
		// 发出推送
		ecLaunch.sendPushMsg(userId, true);
		
		ret.setErrorCode(0);
		ret.setErrorMsg("发送随手拍评论成功！");
		return ret;
	}
	
	@RequestMapping(value = "my-topic-unread", method = RequestMethod.GET)
	@ApiOperation(httpMethod = "GET", value = "我的随手拍未读消息数", produces = MediaType.APPLICATION_JSON_VALUE)
	@Authorization
	@ApiImplicitParams({
        @ApiImplicitParam(name = IAppConst.AUTHORIZATION, value = IAppConst.AUTHORIZATION, required = true, dataType = "string", paramType = "header"),
    })
	public CommonReturnBean<Integer> getMyTopicUnreadCount(HttpSession session) {
		CommonReturnBean<Integer> ret = new CommonReturnBean<>();
		LoginUserOut user = (LoginUserOut) session.getAttribute(IAppConst.SESSION_USER_NAME);
		if(null == user) {
			ret.setErrorCode(401);
			ret.setErrorMsg("系统缓存出错！");
	    	return ret;
		}
		
		// 更新未读消息状态
		int userId = user.getUserId();
		int unreadCnt = topicUnreadService.getMyUnreadNum(userId);
		
		ret.setErrorCode(0);
		ret.setErrorMsg("获取我的随手拍未读消息数成功！");
		ret.setData(unreadCnt);
		return ret;
	}
	
	@RequestMapping(value = "delete-topic-soft/{id:\\d+}", method = RequestMethod.DELETE)
	@ApiOperation(httpMethod = "DELETE", value = "删除随手拍主题", produces = MediaType.APPLICATION_JSON_VALUE)
	@Authorization
	@ApiImplicitParams({
        @ApiImplicitParam(name = IAppConst.AUTHORIZATION, value = IAppConst.AUTHORIZATION, required = true, dataType = "string", paramType = "header"),
    })
	@Trace(type=IDicInfoConst.OPT_TOPIC_DELETE)
	public CommonReturnBean<Integer> deleteTopic(@PathVariable("id")Integer id, HttpSession session) {
		CommonReturnBean<Integer> ret = new CommonReturnBean<>();
		LoginUserOut user = (LoginUserOut) session.getAttribute(IAppConst.SESSION_USER_NAME);
		if(null == user) {
			ret.setErrorCode(401);
			ret.setErrorMsg("系统缓存出错！");
	    	return ret;
		}
		
		int userId = user.getUserId();
		
		TopicPic tp = topicPicService.getBaseTopic(id);
		if(tp == null) {
			ret.setErrorCode(-324);
			ret.setErrorMsg("您删除的随手拍主题不存在！");
			return ret;
		}
		
		if(tp.getSendUserId() != userId) {
			ret.setErrorCode(-325);
			ret.setErrorMsg("您无权删除该随手拍主题！");
			return ret;
		}
		
		if(tp.getActiveStatus() == 0) {
			ret.setErrorCode(-326);
			ret.setErrorMsg("该随手拍主题已被删除，不能重复删除！");
			return ret;
		}
		
		tp.setActiveStatus((byte) 0);
		tp.setUpdateAt(new Date());
		int delCnt = topicPicService.deleteTopic(tp);
		if(delCnt != 1) {
			ret.setErrorCode(-327);
			ret.setErrorMsg("删除随手拍主题失败！");
			return ret;
		}
		
		ret.setErrorCode(0);
		ret.setErrorMsg("删除随手拍主题成功！");
		ret.setData(delCnt);
		
		return ret;
	}
}
