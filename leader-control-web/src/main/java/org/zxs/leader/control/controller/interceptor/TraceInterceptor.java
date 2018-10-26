package org.zxs.leader.control.controller.interceptor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.zxs.leader.control.controller.annotation.Trace;
import org.zxs.leader.control.dao.consts.IAppConst;
import org.zxs.leader.control.dao.model.OptInfo;
import org.zxs.leader.control.dao.model.vo.output.LoginUserOut;
import org.zxs.leader.control.service.interf.IOptInfoService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * 自定义拦截器，记录操作日志
 */
@Component
public class TraceInterceptor extends HandlerInterceptorAdapter {
	private static Log log = LogFactory.getLog(TraceInterceptor.class);
	
    @Resource
    private IOptInfoService optService;
    
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return;
        }
        
		HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        Trace aTrace = method.getAnnotation(Trace.class);
		if (aTrace != null) {
			OptInfo opt = new OptInfo();
			int prjType = aTrace.prjType();
			HttpSession session = request.getSession();
			LoginUserOut user = (LoginUserOut) session.getAttribute(IAppConst.SESSION_USER_NAME);
			if(null != user) {
				Integer deviceId = user.getDeviceId();
				int userId = user.getUserId();
				if(null != deviceId) {
					int type = aTrace.type();
					log.info("开始添加操作日志！" + type);
					opt.setDeviceId(deviceId);
					opt.setOptType(type);
					opt.setUserId(userId);
					opt.setOptAt(new Date());
					
					if(prjType == -1) { // 寻找请求参数中，是否有prjType
						String prjTypeStr = request.getParameter("prjType");
						if(null != prjTypeStr && !prjTypeStr.isEmpty()) {
							prjType = Integer.parseInt(prjTypeStr.trim());
							opt.setPrjType(prjType);
						}
					}else {
						opt.setPrjType(prjType);
					}
					
					opt.setOptRet((byte) 1);
					opt.setOptMsg("操作结束！");
					
					try {
						int addRet = optService.addOptInfo(opt);
						if(addRet == 1) {
							log.info("添加操作日志成功！操作类型为：" + type);
						}else {
							log.info("添加操作日志失败！操作类型为：" + type);
						}
					}catch(Exception e) {
						log.error(e.getMessage(), e);
					}
					
				}else {
					log.warn("当前用户[" + userId + "]缓存中无设备信息，无法记录日志！");
				}
			}
        }
	}

}
