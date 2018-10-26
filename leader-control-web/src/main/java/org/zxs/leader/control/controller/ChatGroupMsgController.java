package org.zxs.leader.control.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
import org.zxs.leader.control.dao.consts.IAppConst;
import org.zxs.leader.control.dao.model.vo.output.ChatMsgOut;
import org.zxs.leader.control.dao.model.vo.output.LoginUserOut;
import org.zxs.leader.control.dao.model.vo.output.UnreadMsgOut;
import org.zxs.leader.control.dao.model.vo.query.MsgHisQuery;
import org.zxs.leader.control.service.interf.IChatGroupMsgService;
import org.zxs.leader.control.service.interf.IMsgStatusService;
import org.zxs.utils.UploadQiniu;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags="群聊消息接口")
public class ChatGroupMsgController {
	private static final Log log = LogFactory.getLog(ChatGroupMsgController.class);
	
	@Resource
	private IChatGroupMsgService cgMsgService;
	
	@Resource
	private IMsgStatusService msgStatusService;
	
	@Resource
	private AckChatLaunch ecLaunch;
	
	
	@RequestMapping(value = "my-chat-msg/{id}", method = RequestMethod.GET)
	@Authorization
	@ApiOperation(httpMethod = "GET", value = "查询群聊历史记录", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({
        @ApiImplicitParam(name = IAppConst.AUTHORIZATION, value = IAppConst.AUTHORIZATION, required = true, dataType = "string", paramType = "header"),
    })
	public List<ChatMsgOut> getMyChatMsg(@PathVariable("id")Integer id, 
			@RequestParam(required=false,value="msgId") Integer msgId,
			@RequestParam(required=false,value="msgNum", defaultValue="15") Integer msgNum, HttpSession session) {
		log.info("开始获取群聊组[" + id + "]历史聊天记录!");
		
		LoginUserOut user = (LoginUserOut) session.getAttribute(IAppConst.SESSION_USER_NAME);
		if(null == user) {
			return null;
		}
		
		int userId = user.getUserId();
		MsgHisQuery query = new MsgHisQuery();
		query.setCgId(id);
		query.setNum(msgNum);
		query.setUserId(userId);
		if(null != msgId)
			query.setMsgId(msgId);
		
		List<ChatMsgOut> msgList = cgMsgService.getLatestMsgHisById(query);
		
//		if(!msgList.isEmpty())
//			Collections.reverse(msgList);
		
		log.info(String.format("更新已读消息状态！cgId[%s],userId[%s]", id, userId));
		int updStatusCnt = msgStatusService.updateMsgReadStatusByUserIdAndCgId(userId, id);
		if(updStatusCnt > 0) {
			log.info(String.format("成功更新[%s]条消息已读状态！", updStatusCnt));
		}
		log.info("获取群聊组[" + id + "]历史聊天记录结束!");
		
		return msgList;
	}
	
	@RequestMapping(value = "my-latest-msg", method = RequestMethod.GET)
	@Authorization
	@ApiOperation(httpMethod = "GET", value = "查询最近聊天历史记录", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({
        @ApiImplicitParam(name = IAppConst.AUTHORIZATION, value = IAppConst.AUTHORIZATION, required = true, dataType = "string", paramType = "header"),
    })
	public UnreadMsgOut getMyLatestMsg(HttpSession session) {
		
		LoginUserOut user = (LoginUserOut) session.getAttribute(IAppConst.SESSION_USER_NAME);
		if(null == user) {
			return null;
		}
		
		return msgStatusService.getUnreadMsgCnt(user.getUserId());
	}
	
	/**
	 * 上传文件
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "upload-file", method = RequestMethod.POST)
	public CommonReturnBean<String> uploadChatFile(HttpServletRequest request) {
		CommonReturnBean<String> ret = new CommonReturnBean<>();
		String formData = request.getParameter("fileData");
		log.info(formData);
		if(null == formData || formData.isEmpty()) {
			ret.setErrorCode(-121);
			ret.setErrorMsg("没有文件上传！");
			return ret;
		}
		
		if(!formData.contains(",")) {
			ret.setErrorCode(-122);
			ret.setErrorMsg("文件上传参数出错！");
			return ret;
		}
		
		String fileName = request.getParameter("fileName");
		Decoder decoder = Base64.getDecoder();
		byte[] imgData = decoder.decode(formData.substring(formData.indexOf(",")+1));
		
		InputStream is = new ByteArrayInputStream(imgData);
		try {
			String url = UploadQiniu.uploadImgQiniu(is, System.currentTimeMillis() + "/" + fileName);
			ret.setErrorCode(0);
			ret.setData(url);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			ret.setErrorCode(-123);
			ret.setErrorMsg("文件上传服务器失败！");
		}
		
		/*String imgFilePath = "e://" + fileName;//新生成的图片  
        OutputStream outStream = null;      
        try {
        	outStream = new FileOutputStream(imgFilePath);
        	outStream.write(imgData);
        	outStream.flush();  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(null != outStream)
				try {
					outStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}*/
		
		return ret;
	}
	
	/**
	 * 发送系统通知
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "send-sys-push", method = RequestMethod.POST)
	@ApiOperation(httpMethod = "POST", value = "发送系统推送通知", produces = MediaType.APPLICATION_JSON_VALUE)
	public CommonReturnBean<Integer> sendSysPush(@RequestParam(required=true,value="sysMsg") String sysMsg) {
		CommonReturnBean<Integer> ret = new CommonReturnBean<>();
		int saveRet = cgMsgService.saveSYSMsg(sysMsg);
		if(saveRet != 1) {
			log.info("保存系统推送通知失败！");
			ret.setErrorCode(-109);
			ret.setErrorMsg("保存系统推送通知失败！");
			return ret;
		}
		
		log.info("保存系统推送通知成功。");
		ecLaunch.sendPushMsg(0, false);
		ret.setErrorCode(0);
		ret.setErrorMsg("发送系统推送通知成功。");
		return ret;
	}
}
