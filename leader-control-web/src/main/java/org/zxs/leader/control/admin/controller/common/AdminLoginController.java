package org.zxs.leader.control.admin.controller.common;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.util.WebUtils;
import org.zxs.base.model.CommonReturnBean;
import org.zxs.base.model.SessionUser;
import org.zxs.leader.control.dao.consts.IAppConst;
import org.zxs.leader.control.dao.model.vo.output.AdminUserOut;
import org.zxs.leader.control.service.interf.IAdminUserService;
import org.zxs.leader.control.service.interf.ITokenManager;
import org.zxs.utils.CommonUtil;

@Controller
@SessionAttributes({IAppConst.SESSION_ADMIN_NAME}) 
@RequestMapping("/admin")
public class AdminLoginController {
	
	private static final Log logger = LogFactory.getLog(AdminLoginController.class);
	
	@Resource
	private IAdminUserService adminUserService;
	
	@Resource
    private ITokenManager tokenManager;
	
	// 管理员登录
    @RequestMapping(value = "/admin-login", method = RequestMethod.POST)
    @ResponseBody
    public CommonReturnBean<AdminUserOut> adminLogin(
    		@RequestParam(required=true,value="username") String username,
			@RequestParam(required=true,value="password") String password, 
			HttpServletRequest request) {
    	CommonReturnBean<AdminUserOut> ret = new CommonReturnBean<>();
    	try {
    		AdminUserOut admin = adminUserService.getAdminByLoginNameAndPassword(username, password);
    		if(null == admin) {
    			String ipAddr = CommonUtil.getIpAddr(request);
    			String errMsg = String.format("[%s] - %s", ipAddr, "后台登录失败，用户名或密码错误！");
				logger.warn(errMsg);
    			ret.setErrorCode(-202);
    			ret.setErrorMsg("用户名或密码错误！");
                return ret;
    		}
    		
    		// 创建SessionUser
    		SessionUser sessionUser = new SessionUser();
    		sessionUser.setId(admin.getId());
    		sessionUser.setRole(admin.getRole().intValue());
    		sessionUser.setNickname(admin.getNickName());
    		sessionUser.setGroup(admin.getAdminGroup());
    		WebUtils.setSessionAttribute(request, IAppConst.SESSION_ADMIN_NAME, sessionUser);
    		
    		ret.setErrorCode(0);
    		ret.setErrorMsg("登录成功!");
    		ret.setData(admin);
            return ret;
            
    	} catch (Exception e) {
        	logger.error(e.getMessage(), e);
            // 身份验证失败
        	ret.setErrorCode(0);
    		ret.setErrorMsg("登录失败!");
            return ret;
        }

    }
    
    @RequestMapping(value="/auth/main", method=RequestMethod.GET)
	public String mainHome(@ModelAttribute(IAppConst.SESSION_ADMIN_NAME) SessionUser admin) {
		return "main";
	}
    
    @RequestMapping(value = "/auth/logout", method = RequestMethod.DELETE)
    public String logout(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "redirect:../admin/login.html";
    }
    
//    @RequestMapping(value = "/admin/update-password", method = RequestMethod.POST)
//    public CommonReturnBean<Integer> updatePassword(@RequestParam(required=true,value="pswdOld") String pswdOld,
//    		@RequestParam(required=true,value="pswdNew") String pswdNew, HttpSession session) {
//    	CommonReturnBean<Integer> result = new CommonReturnBean<>();
//    	LoginUserOut user = (LoginUserOut) session.getAttribute(IAppConst.SESSION_USER_NAME);
//    	if(null != user){
//    		LoginUserOut userOut = orgUserService.getLoginInfoById(user.getUserId(), pswdOld);
//    		if(null == userOut) {
//    			result.setErrorCode(-103);
//                result.setErrorMsg("原密码不正确！");
//                return result;
//    		}
//    		
//    		int userId = user.getUserId();
//			int updRet = orgUserService.updatePassword(userId, pswdNew);
//    		if(updRet != 1) {
//    			result.setErrorCode(-104);
//                result.setErrorMsg("修改密码失败！");
//                return result;
//    		}
//    		
//    		tokenManager.deleteToken(userId);
//    		result.setErrorCode(0);
//            result.setErrorMsg("修改密码成功！");
//    	}
//        
//        return result;
//    }
    
}
