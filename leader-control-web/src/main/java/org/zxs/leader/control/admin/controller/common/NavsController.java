package org.zxs.leader.control.admin.controller.common;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zxs.base.model.SessionUser;
import org.zxs.leader.control.dao.consts.IAppConst;

import io.swagger.annotations.Api;

@Controller
@RequestMapping("/admin")
@Api(tags="后台菜单接口")
public class NavsController {
	
	private static final Log logger = LogFactory.getLog(NavsController.class);
	
	@RequestMapping(value = "/navs", method = {RequestMethod.GET, RequestMethod.POST})
	public String getNavsJson(HttpSession session) {
		SessionUser sessionUser = (SessionUser) session.getAttribute(IAppConst.SESSION_ADMIN_NAME);
		if (null == sessionUser) {
			logger.info("会话用户为空！");
			return "redirect:../navs/navs-empty.json"; // 无菜单
		}
		// 根据管理员分组显示左侧导航菜单
		String group = sessionUser.getGroup();
		if (group.equalsIgnoreCase("ADMIN")) {
			logger.info(String.format("获取菜单数据...... 用户ID[%s], 分组[%s]", sessionUser.getId(), group));
			return "redirect:../navs/navs-admin.json"; // 管理员组
		} else if (group.equalsIgnoreCase("PROGRESS")) {
			logger.info(String.format("获取菜单数据...... 用户ID[%s], 分组[%s]", sessionUser.getId(), group));
			return "redirect:../navs/navs-prgs.json"; // 进度组
		} else if (group.equalsIgnoreCase("DATA")) {
			logger.info(String.format("获取菜单数据...... 用户ID[%s], 分组[%s]", sessionUser.getId(), group));
			return "redirect:../navs/navs-data.json"; // 数据组
		} else {
			logger.info(String.format("找不到该用户ID[%s]的分组[%s]对应的导航菜单数据！", sessionUser.getId(), group));
			return "redirect:../navs/navs-empty.json"; // 无菜单
		}
	}

}
