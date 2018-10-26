package org.zxs.leader.control.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zxs.leader.control.dao.consts.IAppConst;
import org.zxs.leader.control.dao.model.AppVersion;
import org.zxs.leader.control.service.interf.IAppVersionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags="APP版本接口")
public class AppVersionController {
	private static final Log log = LogFactory.getLog(AppVersionController.class);
	
	@Resource
	private IAppVersionService appVersionService;
	
	@RequestMapping(value = "get-app-version", method = RequestMethod.GET)
	@ApiOperation(httpMethod = "GET", value = "获取最新APP版本信息", produces = MediaType.APPLICATION_JSON_VALUE)
	public AppVersion getLatestAPPVersion(HttpServletRequest request, @RequestParam(required=true,value="version") String version) {
		String agent = request.getHeader("user-agent").toLowerCase();
		byte os = IAppConst.OS_ANDROID;
    	if(agent.contains("iphone")||agent.contains("ipod")||agent.contains("ipad")) {
    		os = IAppConst.OS_IOS;
    	}
		return appVersionService.getLatestVersion(os, version);
	}
	
	@RequestMapping(value = "get-qr-code", method = RequestMethod.GET)
	@ApiOperation(httpMethod = "GET", value = "获取二维码地址", produces = MediaType.APPLICATION_JSON_VALUE)
	public void getQrCode(HttpServletRequest request, HttpServletResponse response) {
    	String agent = request.getHeader("user-agent").toLowerCase();
    	log.info("获取到的user-agent为：" + agent);
    	byte os = IAppConst.OS_ANDROID;
    	if(agent.contains("iphone")||agent.contains("ipod")||agent.contains("ipad")) {
    		os = IAppConst.OS_IOS;
    	}
    	
    	AppVersion aVersion = appVersionService.getLatestVersion(os, "");
    	if(null != aVersion) {
    		try {
    			response.sendRedirect(aVersion.getUrl());
    		} catch (IOException e) {
    			log.error(e.getMessage(), e);
    		} 
    	}else {
    		log.error("获取APP的版本信息出错！");
    	}
    		
//    	try {
//	    	if(agent.contains("iphone")||agent.contains("ipod")||agent.contains("ipad")) {
//				response.sendRedirect("https://itunes.apple.com/cn/app/%E5%8D%97%E5%AE%81%E5%B8%82%E6%8A%95%E8%B5%84%E9%A1%B9%E7%9B%AE%E7%B2%BE%E7%BB%86%E5%8C%96%E7%AE%A1%E7%90%86%E7%B3%BB%E7%BB%9F/id1373665641?mt=8");
//	    	}else{
//	    		response.sendRedirect("http://116.10.194.123:8809/media/nn.invprojmgr.neco.apk");
//	    	}
//    	} catch (IOException e) {
//			log.error(e.getMessage(), e);
//		} 
	}
	
}
