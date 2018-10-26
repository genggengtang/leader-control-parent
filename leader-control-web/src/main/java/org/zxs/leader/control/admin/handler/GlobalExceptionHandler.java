package org.zxs.leader.control.admin.handler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.zxs.base.model.CommonReturnBean;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	private static final Log logger = LogFactory.getLog(GlobalExceptionHandler.class);
	
	/**
	 * 
	* @Title: handleException 
	* @Description: 全局controller入参异常处理
	* @param @param ex
	* @param @return  参数说明 
	* @return CommonReturnBean<Integer>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月27日 下午3:57:34
	 */
	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	CommonReturnBean<Integer> handleException(HttpMessageNotReadableException ex) {
		final Throwable cause = ex.getCause();
		String unknownProperties = null;
		
		// 字段不对应
		if (cause instanceof UnrecognizedPropertyException) {
			unknownProperties = ((UnrecognizedPropertyException) cause).getPropertyName();
			String knownIds = ((UnrecognizedPropertyException) cause).getKnownPropertyIds().toString();
			CommonReturnBean<Integer> ret = new CommonReturnBean<>();
		    ret.setErrorCode(-1);
			ret.setErrorMsg(String.format("HTTP请求消息读取异常，无法识别传入字段[%s]。", unknownProperties));
			logger.info(String.format("HTTP请求消息读取异常，无法识别传入字段[%s]。请参考传入JSON对象结构%s。", unknownProperties, knownIds.replace(", isDeleted", "")));
			return ret;
		}
		
		// 格式异常
		if (cause instanceof com.fasterxml.jackson.databind.exc.InvalidFormatException) {
			String value = ((InvalidFormatException) cause).getValue().toString();
			String type = ((InvalidFormatException) cause).getTargetType().getName();
			String field = ((InvalidFormatException) cause).getPathReference();
			CommonReturnBean<Integer> ret = new CommonReturnBean<>();
		    ret.setErrorCode(-1);
			ret.setErrorMsg(String.format("%s中的值[%s]类型不匹配。", field, value));
			logger.info(String.format("无法将%s中的值[%s]转为[%s]类型。", field, value, type));
			return ret;
		}
		
		// 默认异常处理
		ex.printStackTrace();
	    CommonReturnBean<Integer> ret = new CommonReturnBean<>();
	    ret.setErrorCode(-1);
		ret.setErrorMsg("HTTP请求消息读取异常！");
		logger.info("HTTP请求消息读取异常！");
	    return ret;
	}

}
