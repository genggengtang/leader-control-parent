package org.zxs.leader.control.controller.interceptor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.zxs.leader.control.controller.annotation.Authorization;
import org.zxs.leader.control.controller.annotation.JsonParam;
import org.zxs.leader.control.dao.consts.IAppConst;
import org.zxs.leader.control.service.interf.ITokenManager;

import com.alibaba.fastjson.JSON;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 自定义拦截器，判断此次请求是否有权限
 * @see com.scienjus.authorization.annotation.Authorization
 * @author ScienJus
 * @date 2015/7/30.
 */
@Component
public class JsonParamInterceptor extends HandlerInterceptorAdapter {
	private static Log log = LogFactory.getLog(JsonParamInterceptor.class);

    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        //如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        
        JsonParam jParam = method.getAnnotation(JsonParam.class);
        //如果方法注明了Authorization
        if (jParam != null) {
        	String jParamValue = request.getParameter(jParam.paramName());
        	
        	Object JParamObject = JSON.parseObject(jParamValue, jParam.paramClass());
        	request.setAttribute(IAppConst.JSON_PARAM_NAME, JParamObject);
        }
        return true;
    }
}
