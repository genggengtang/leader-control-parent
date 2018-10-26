package org.zxs.leader.control.controller.interceptor;

import java.lang.reflect.Method;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.zxs.leader.control.controller.annotation.Authorization;
import org.zxs.leader.control.dao.consts.IAppConst;
import org.zxs.leader.control.service.interf.ITokenManager;

/**
 * 自定义拦截器，判断此次请求是否有权限
 * @see com.scienjus.authorization.annotation.Authorization
 * @author ScienJus
 * @date 2015/7/30.
 */
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {
	
	private static Log log = LogFactory.getLog(AuthorizationInterceptor.class);
	
    @Resource
    private ITokenManager tokenManager;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    	
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        
        // 如果方法注明了Authorization
        if (method.getAnnotation(Authorization.class) != null) {
        	
        	// 从header中得到token
            String authorization = request.getHeader(IAppConst.AUTHORIZATION);
            
            if(null != authorization && !authorization.isEmpty() && authorization.split(";").length == 2) {
            	String userIdStr = authorization.split(";")[0];
                String token = authorization.split(";")[1];
                
                // 验证token
                if (!tokenManager.checkToken(userIdStr, token)) {
                	response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                	log.warn("授权验证失败！验证串为[" + authorization + "], 当前token为[" + tokenManager.getTokenObject(userIdStr).getToken() + "]");
                    return false;
                } else {
                	// 如果token验证成功，将token对应的用户id存在session中，便于之后注入
                    request.getSession().setAttribute(IAppConst.SESSION_USER_NAME, tokenManager.getTokenObject(userIdStr));
                    log.info("授权验证成功！验证串为：" + authorization);
                }
            } else {
            	log.warn("授权验证失败！验证串[" + authorization + "]不合法!");
            	response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return false;
            }
        }
        return true;
    }
}
