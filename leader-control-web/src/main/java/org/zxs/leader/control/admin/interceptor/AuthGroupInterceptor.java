package org.zxs.leader.control.admin.interceptor;

import java.lang.reflect.Method;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.zxs.base.model.SessionUser;
import org.zxs.leader.control.admin.annotation.AuthGroup;
import org.zxs.leader.control.dao.consts.IAppConst;

@Component
public class AuthGroupInterceptor implements HandlerInterceptor {
	
	private static Log logger = LogFactory.getLog(AuthGroupInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// skip if path is not mapped to a method
		if (!(handler instanceof HandlerMethod)) {
			logger.info("拦截器跳过静态资源！");
            return true;
        }
		// handle method annotated by AuthGroup annotation
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method method = handlerMethod.getMethod();
        AuthGroup authGroup = method.getAnnotation(AuthGroup.class);
        // skip if not annotated by AuthGroup annotation
        if (authGroup == null) {
        	logger.info("该方法没有被AuthoGroup注解修饰！URI：" + request.getRequestURI());
        	return true;
        }
    	SessionUser sessionUser = (SessionUser) request.getSession().getAttribute(IAppConst.SESSION_ADMIN_NAME);
    	if (null == sessionUser) {
    		logger.info("正在访问 >>> " + request.getRequestURI() + "，Session中没有登录用户信息，自动跳转到登录页面！");
    		response.sendRedirect("../../admin/login.html");
    		return false;
    	}
    	return isAuthorizedUser(sessionUser, authGroup, request, response);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
	
	/*
	 * 检查该会话用户是否有权限访问该URI
	 */
	private boolean isAuthorizedUser(SessionUser user, AuthGroup annotation, HttpServletRequest request, HttpServletResponse response) {
		Integer userId = user.getId();
		String userGroup = user.getGroup();
    	String userRole = user.getRole().toString();
    	logger.info(String.format("登录用户ID[%s]权限 - 分组：%s - 级别：%s", userId, userGroup, userRole));
    	logger.info(String.format("该接口所需的用户权限 - %s", Arrays.toString(annotation.permits())));
		// 解析分组(Group)和权限级别(Role)信息
    	String[] permits = annotation.permits();
    	for (String permit : permits) {
    		String[] halves = permit.split("-");
    		if (halves.length != 1 && !halves[0].equalsIgnoreCase("")) {
    			String rawRoles  = halves[1].replaceAll("[\\[\\]]", "");
    			String groupName = halves[0];
    			String[] roles = rawRoles.split(",");
    			if (roles.length == 1 && roles[0].equalsIgnoreCase("")) { // 没有配置用户等级
    				logger.info("没用配置用户等级！仅仅判断用户分组...");
    				if (userGroup.equalsIgnoreCase(groupName)) {
    					logger.info(String.format("判断用户分组通过！登录用户分组[%s]，所需分组权限[%s]！", userGroup, userGroup));
    					return true;
    				}
    			} else { // 已配置用户等级
    				for (String role : roles) {
    					if (userGroup.equalsIgnoreCase(groupName) 
    							&& role.equalsIgnoreCase(userRole)) {
    						return true;
    					}
    				}
    			}
    		} else {
    			// 判断permit是否等于所需管理员权限分组
    			logger.info("没用配置用户等级！仅仅判断用户分组...");
    			if (userGroup.equalsIgnoreCase(permit)) {
    				logger.info(String.format("判断用户分组通过！登录用户分组[%s]，所需分组权限[%s]！", userGroup, userGroup));
					return true;
				}
    		}
    		
    	}
    	logger.info(String.format("登录用户ID[%s]没有访问权限！URI：%s", userId, request.getRequestURI()));
		return false;
	}

}
