package org.zxs.leader.control.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;
import org.zxs.base.model.CommonReturnBean;
import org.zxs.leader.control.controller.annotation.Authorization;
import org.zxs.leader.control.controller.annotation.Trace;
import org.zxs.leader.control.dao.consts.IAppConst;
import org.zxs.leader.control.dao.consts.IDicInfoConst;
import org.zxs.leader.control.dao.model.DeviceInfo;
import org.zxs.leader.control.dao.model.OptInfo;
import org.zxs.leader.control.dao.model.vo.output.LoginUserOut;
import org.zxs.leader.control.service.interf.IDeviceInfoService;
import org.zxs.leader.control.service.interf.IMsgStatusService;
import org.zxs.leader.control.service.interf.IOptInfoService;
import org.zxs.leader.control.service.interf.IOrgUserService;
import org.zxs.leader.control.service.interf.ITokenManager;
import org.zxs.leader.control.util.UserAgentUtil;
import org.zxs.utils.CommonUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags="用户登录接口")
public class LoginController {
	
	private static final Log log = LogFactory.getLog(LoginController.class);
	
	@Resource
	private IOrgUserService orgUserService;
	
	@Resource
    private ITokenManager tokenManager;
	
	@Resource
	private IMsgStatusService msgStatusService;
	
	@Resource
	private IDeviceInfoService deviceService;
	
	@Resource
    private IOptInfoService optService;

	@RequestMapping(value = "is-username-exist", method = RequestMethod.GET)
	@ApiOperation(httpMethod = "GET", value = "用户是否存在", produces = MediaType.APPLICATION_JSON_VALUE)
	public CommonReturnBean<Integer> isUsernameExist(@RequestParam(required=true,value="username") String username) {
		CommonReturnBean<Integer> ret = new CommonReturnBean<>();
		Pattern p = Pattern.compile("[a-zA-Z]{1}[a-zA-Z0-9_]{1,20}");
	    Matcher m = p.matcher(username);
	    if(!m.matches()) {
	    	ret.setErrorCode(-101);
	    	ret.setErrorMsg("存在非法字符，请检查您输入的字符!");
	    	return ret;
	    }
	    
	    if(!orgUserService.isUserExist(username)) {
	    	ret.setErrorCode(-201);
	    	ret.setErrorMsg("该用户名不存在!");
	    	return ret;
	    }
	    
	    ret.setErrorCode(0);
    	ret.setErrorMsg("该用户名通过验证!");
    	return ret;
	}
	
    @RequestMapping(value = "normal-login", method = RequestMethod.POST)
    @ApiOperation(httpMethod = "POST", value = "首次登录", produces = MediaType.APPLICATION_JSON_VALUE, notes="密码需经过md5加密")
    public CommonReturnBean<LoginUserOut> loginWithToken(@RequestParam(required=true,value="username") String username,
			@RequestParam(required=true,value="password") String password, 
			@RequestParam(required=false,value="uuid") String uuid, 
			@RequestParam(required=false,value="userId") Integer userId, HttpServletRequest request, HttpSession session) {
    	CommonReturnBean<LoginUserOut> result = new CommonReturnBean<>();
    	try {
    		if(userId == null) { // 未传用户编号
        		List<LoginUserOut> userOutList = orgUserService.getLoginInfo(username, null);
                if (userOutList == null || userOutList.isEmpty()) {  //密码错误
               	 result.setErrorCode(-201);
               	 result.setErrorMsg("用户不存在!");
                    return result;
                }
                
                int size = userOutList.size();
                if(size == 1) {
    				LoginUserOut userOut = orgUserService.getLoginInfoById(userOutList.get(0).getUserId(), password);
                	
                	if(userOut == null) {
                		result.setErrorCode(-202);
                        result.setErrorMsg("密码不正确！");
                        return result;
                	}
                	
                	log.info("登录验证通过，uuid为：" + uuid);
                	
                	// 保存设备信息
                	if(null != uuid && !uuid.isEmpty()) {
                		String ua = UserAgentUtil.getUaInfo(request);
                		String os = UserAgentUtil.getMobileOS(ua);
                		byte iOs = IAppConst.OS_ANDROID;
                		if(os.equals("iphone") || os.equals("ipad")) {
                			iOs = IAppConst.OS_IOS;
                		}else if(os.equals("other")) {
                			iOs = IAppConst.OS_OTHER;
                		}
                		
                		DeviceInfo dvInfo = new DeviceInfo();
                		dvInfo.setUuid(uuid);
                		dvInfo.setUa(ua);
                		dvInfo.setOs(iOs);
                		dvInfo.setModel(UserAgentUtil.getPhoneModel(ua));
                		dvInfo.setIp(CommonUtil.getIpAddr(request));
                		
                		deviceService.saveOrUpdateDevice(dvInfo);
                		Integer deviceId = dvInfo.getId();
                		
    					// 添加操作日志
                		OptInfo opt = new OptInfo();
                    	opt.setDeviceId(deviceId);
        				opt.setOptType(IDicInfoConst.OPT_LOGIN);
        				opt.setUserId(userOut.getUserId());
        				opt.setOptAt(new Date());
    					opt.setOptRet((byte) 1);
    					opt.setOptMsg("操作正常");
    					
    					int addRet = optService.addOptInfo(opt);
    					if(addRet == 1) {
    						log.info("添加操作日志成功！操作类型为：" + IDicInfoConst.OPT_LOGIN);
    					}else {
    						log.info("添加操作日志失败！操作类型为：" + IDicInfoConst.OPT_LOGIN);
    					}
    					
    					userOut.setDeviceId(deviceId);
                	}else {
                		log.warn("客户端没有传UUID!");
                	}
                	
                	//生成一个token，保存用户登录状态
                	String token = tokenManager.createToken(userOut);
                    userOut.setToken(token);
                    
                    result.setErrorCode(0);
                    result.setData(userOut);
                    
                    session.setAttribute(IAppConst.SESSION_USER_NAME, userOut);
                    
                    log.info("用户" + userOut.getLoginName() + "登录成功!");
                    
                    return result;
                }else if(size > 1) {
               	 LoginUserOut userOut = new LoginUserOut();
               	 Map<Integer, String> loginMap = new HashMap<>();
               	 for(LoginUserOut luo : userOutList) {
               		 String orgName = luo.getOrgName();
               		 if(null != orgName && !orgName.isEmpty()) {
               			loginMap.put(luo.getUserId(), luo.getUsername() + "-" + orgName);
               		 }else {
               			loginMap.put(luo.getUserId(), luo.getUsername());
               		 }
               		 
               	 }
               	 	userOut.setLoginMap(loginMap);
               	 	result.setErrorCode(1);
               	 	result.setErrorMsg("该用户名对应多个用户!");
                    result.setData(userOut);
                }
                return result;
        	}else {
        		LoginUserOut userOut = orgUserService.getLoginInfoById(userId, password);
        		if(null == userOut) {
        			result.setErrorCode(-202);
                    result.setErrorMsg("密码不正确！");
                    return result;
        		}
        		
        		log.info("登录验证通过，uuid为：" + uuid);
        		
        		// 保存设备信息
            	if(null != uuid && !uuid.isEmpty()) {
            		String ua = UserAgentUtil.getUaInfo(request);
            		String os = UserAgentUtil.getMobileOS(ua);
            		byte iOs = IAppConst.OS_ANDROID;
            		if(os.equals("iphone") || os.equals("ipad")) {
            			iOs = IAppConst.OS_IOS;
            		}else if(os.equals("other")) {
            			iOs = IAppConst.OS_OTHER;
            		}
            		
            		DeviceInfo dvInfo = new DeviceInfo();
            		dvInfo.setUuid(uuid);
            		dvInfo.setUa(ua);
            		dvInfo.setOs(iOs);
            		dvInfo.setModel(UserAgentUtil.getPhoneModel(ua));
            		dvInfo.setIp(CommonUtil.getIpAddr(request));
            		
            		deviceService.saveOrUpdateDevice(dvInfo);
            		Integer deviceId = dvInfo.getId();
            		
            		// 添加操作日志
            		OptInfo opt = new OptInfo();
                	opt.setDeviceId(deviceId);
    				opt.setOptType(IDicInfoConst.OPT_LOGIN);
    				opt.setUserId(userId);
    				opt.setOptAt(new Date());
    				
    				opt.setOptRet((byte) 1);
    				opt.setOptMsg("操作正常");
    				
    				int addRet = optService.addOptInfo(opt);
    				if(addRet == 1) {
    					log.info("添加操作日志成功！操作类型为：" + IDicInfoConst.OPT_LOGIN);
    				}else {
    					log.info("添加操作日志失败！操作类型为：" + IDicInfoConst.OPT_LOGIN);
    				}
    				
    				userOut.setDeviceId(deviceId);
            	}
            	
            	//生成一个token，保存用户登录状态
                String token = tokenManager.createToken(userOut);
                userOut.setToken(token);
                
                result.setErrorCode(0);
                result.setData(userOut);
                
                session.setAttribute(IAppConst.SESSION_USER_NAME, userOut);
                
                log.info("用户" + userOut.getLoginName() + "登录成功!");
                return result;
        	}
    	}catch(Exception e) {
    		log.error(e.getMessage(), e);
    		result.setErrorCode(-102);
            result.setErrorMsg("登录失败！");
            return result;
    	}
    	
    }
    
    
    @Authorization
    @ApiOperation(httpMethod = "POST", value = "授权登录", produces = MediaType.APPLICATION_JSON_VALUE, notes="请在头部添加授权信息！")
    @ApiImplicitParams({
        @ApiImplicitParam(name = IAppConst.AUTHORIZATION, value = IAppConst.AUTHORIZATION, required = true, dataType = "string", paramType = "header"),
    })
    @Trace(type=IDicInfoConst.OPT_LOGIN)
    @RequestMapping(value = "auth-login", method = RequestMethod.POST)
    public CommonReturnBean<LoginUserOut> authLogin(HttpSession session) {
    	log.info("开始授权登录！");
    	CommonReturnBean<LoginUserOut> result = new CommonReturnBean<>();
    	try {
    		LoginUserOut user = (LoginUserOut) session.getAttribute(IAppConst.SESSION_USER_NAME);
        	
    		result.setErrorCode(0);
    		result.setErrorMsg("授权登录成功！");
    		result.setData(user);
    		log.info("授权登录成功！登录用户为:" + user.getUsername());
    		return result;
    	}catch(Exception e) {
    		log.error(e.getMessage(), e);
    		result.setErrorCode(-102);
    		result.setErrorMsg("免密码登录失败！");
    		return result;
    	}
    }
    
    @Authorization
    @ApiOperation(httpMethod = "POST", value = "退出登录", produces = MediaType.APPLICATION_JSON_VALUE, notes="请在头部添加授权信息！")
    @ApiImplicitParams({
        @ApiImplicitParam(name = IAppConst.AUTHORIZATION, value = IAppConst.AUTHORIZATION, required = true, dataType = "string", paramType = "header"),
    })
    @Trace(type=IDicInfoConst.OPT_LOGOUT)
    @RequestMapping(value = "logout", method = {RequestMethod.POST,RequestMethod.DELETE})
    public CommonReturnBean<Integer> logout(HttpSession session, SessionStatus sessionStatus) {
    	CommonReturnBean<Integer> result = new CommonReturnBean<>();
    	LoginUserOut user = (LoginUserOut) session.getAttribute(IAppConst.SESSION_USER_NAME);
    	if(null != user)
    		tokenManager.deleteToken(user.getUserId());
        sessionStatus.setComplete();
        result.setErrorCode(0);
        result.setErrorMsg("退出登录成功！");
        return result;
    }
    
    @Authorization
    @ApiOperation(httpMethod = "POST", value = "修改密码", produces = MediaType.APPLICATION_JSON_VALUE, notes="请在头部添加授权信息,同时,密码需经过md5加密")
    @ApiImplicitParams({
        @ApiImplicitParam(name = IAppConst.AUTHORIZATION, value = IAppConst.AUTHORIZATION, required = true, dataType = "string", paramType = "header"),
    })
    @Trace(type=IDicInfoConst.OPT_PSW_MDF)
    @RequestMapping(value = "update-password", method = RequestMethod.POST)
    public CommonReturnBean<Integer> updatePassword(@RequestParam(required=true,value="pswdOld") String pswdOld,
    		@RequestParam(required=true,value="pswdNew") String pswdNew, HttpSession session) {
    	CommonReturnBean<Integer> result = new CommonReturnBean<>();
    	LoginUserOut user = (LoginUserOut) session.getAttribute(IAppConst.SESSION_USER_NAME);
    	if(null != user){
    		LoginUserOut userOut = orgUserService.getLoginInfoById(user.getUserId(), pswdOld);
    		if(null == userOut) {
    			result.setErrorCode(-103);
                result.setErrorMsg("原密码不正确！");
                return result;
    		}
    		
    		int userId = user.getUserId();
			int updRet = orgUserService.updatePassword(userId, pswdNew);
    		if(updRet != 1) {
    			result.setErrorCode(-104);
                result.setErrorMsg("修改密码失败！");
                return result;
    		}
    		
    		tokenManager.deleteToken(userId);
    		result.setErrorCode(0);
            result.setErrorMsg("修改密码成功！");
    	}
        
        return result;
    }
    
    @RequestMapping(value = "total-unread-count", method = RequestMethod.GET)
	@ApiOperation(httpMethod = "GET", value = "用户未读消息总数", produces = MediaType.APPLICATION_JSON_VALUE)
	public Integer getTotalUnreadCount(HttpSession session) {
    	LoginUserOut user = (LoginUserOut) session.getAttribute(IAppConst.SESSION_USER_NAME);
    	if(null != user){
    		return msgStatusService.getTotalUnreadMsgCnt(user.getUserId());
    	}
		return null;
	}
    
}
