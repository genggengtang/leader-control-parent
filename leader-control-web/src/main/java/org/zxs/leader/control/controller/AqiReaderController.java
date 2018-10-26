package org.zxs.leader.control.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zxs.leader.control.controller.annotation.Authorization;
import org.zxs.leader.control.dao.consts.IAppConst;
import org.zxs.leader.control.dao.model.vo.output.VAqiRealtimeCity;
import org.zxs.utils.CommonUtil;

import com.alibaba.fastjson.JSON;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags="环保空气质量数据接口")
public class AqiReaderController {
	private static final Log log = LogFactory.getLog(AqiReaderController.class);
	
	// 环保数据接口地址
	private static final String NN_AQI_URL = "http://172.16.124.192:7081/get-aqi-info";
//	private static final String NN_AQI_URL = "http://www.nnhb.gov.cn/aqi/AQIDataService.ashx?action=GetAvgHourData&random=";
	
	@RequestMapping(value = "get-valid-aqi-nn", method = RequestMethod.GET)
	@ApiOperation(httpMethod = "GET", value = "APP获取南宁市空气质量指数", produces = MediaType.APPLICATION_JSON_VALUE)
	@Authorization
	@ApiImplicitParams({
        @ApiImplicitParam(name = IAppConst.AUTHORIZATION, value = IAppConst.AUTHORIZATION, required = true, dataType = "string", paramType = "header"),
    })
	public VAqiRealtimeCity getNnAqi(HttpServletRequest request) {
		log.info("开始请求环保空气质量接口数据！" + CommonUtil.getIpAddr(request));
		
		String nnAqiStr = "";
		try {
			nnAqiStr = CommonUtil.doGetUrl(NN_AQI_URL, 30000);
			if(null != nnAqiStr && !nnAqiStr.isEmpty()) {
				log.info("请求环保空气质量接口数据成功！返回值为：" + nnAqiStr);
				return JSON.parseObject(nnAqiStr, VAqiRealtimeCity.class);
			}
			log.warn("请求环保空气质量接口数据返回空！");
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		} 
		return null;
	}
	
	@RequestMapping(value = "get-aqi-nn", method = RequestMethod.GET)
	@ApiOperation(httpMethod = "GET", value = "获取南宁市空气质量指数", produces = MediaType.APPLICATION_JSON_VALUE)
	public VAqiRealtimeCity getNnAqi(HttpServletRequest request, @RequestParam(required=true,value="t") Long t,
			@RequestParam(required=true,value="k") String k) {
		log.info("开始请求环保空气质量接口数据！" + CommonUtil.getIpAddr(request));
		VAqiRealtimeCity ret = new VAqiRealtimeCity();
		// 验证签名
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		String nowDate = sdf.format(new Date());
		
		String nnAqiStr = "";
		try {
			
			String md5Key = CommonUtil.md5(nowDate + t.longValue());
			if(!md5Key.equals(k)) {
				log.error("请求环保接口签名验证失败！");
				
				ret.setErrorCode(-901);
				ret.setErrorMsg("签名不合法！");
				return ret;
			}
			nnAqiStr = CommonUtil.doGetUrl(NN_AQI_URL, 30000);
			if(null != nnAqiStr && !nnAqiStr.isEmpty()) {
				log.info("请求环保空气质量接口数据成功！返回值为：" + nnAqiStr);
				
				ret = JSON.parseObject(nnAqiStr, VAqiRealtimeCity.class);
				ret.setErrorCode(0);
				ret.setErrorMsg("成功");
				return ret;
			}
			log.warn("请求环保空气质量接口数据返回空！");
			ret.setErrorCode(-902);
			ret.setErrorMsg("源数据返回空！");
			return ret;
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			ret.setErrorCode(-903);
			ret.setErrorMsg("发生IO异常！");
			return ret;
		} catch (NoSuchAlgorithmException e) {
			log.error("请求环保接口验证签名出错！" + e.getMessage(), e);
			ret.setErrorCode(-904);
			ret.setErrorMsg("加密算法出错！");
			return ret;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			ret.setErrorCode(-905);
			ret.setErrorMsg("系统错误！");
			return ret;
		}
		
	}
	
}
