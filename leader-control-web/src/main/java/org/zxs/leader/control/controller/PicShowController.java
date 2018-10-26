package org.zxs.leader.control.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zxs.leader.control.controller.annotation.Authorization;
import org.zxs.leader.control.dao.consts.IAppConst;
import org.zxs.leader.control.dao.consts.IDicInfoConst;
import org.zxs.leader.control.dao.model.PicShow;
import org.zxs.leader.control.dao.model.vo.output.LoginUserOut;
import org.zxs.leader.control.dao.model.vo.output.PicShowOut;
import org.zxs.leader.control.service.interf.ICbPlanPrjService;
import org.zxs.leader.control.service.interf.IPicShowService;
import org.zxs.leader.control.service.interf.IPrjContactService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags="轮播图")
public class PicShowController {
	private static final Log log = LogFactory.getLog(PicShowController.class);
	
	@Resource
	private IPicShowService picShowService;
	
	@Resource
	private IPrjContactService prjContactService;
	
	@Resource
	private ICbPlanPrjService cbPrjService;
	
	@RequestMapping(value = "pic-show-list", method = RequestMethod.GET)
	@ApiOperation(httpMethod = "GET", value = "获取轮播图列表1.0", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PicShow> getPicShowList() {
		return picShowService.getActivePicList();
	}
	
	@RequestMapping(value = "pic-show", method = RequestMethod.GET)
	@ApiOperation(httpMethod = "GET", value = "获取轮播图列表2.0", produces = MediaType.APPLICATION_JSON_VALUE)
	@Authorization
	@ApiImplicitParams({
        @ApiImplicitParam(name = IAppConst.AUTHORIZATION, value = IAppConst.AUTHORIZATION, required = true, dataType = "string", paramType = "header"),
    })
	public List<PicShowOut> getPicShow(HttpSession session) {
		LoginUserOut user = (LoginUserOut) session.getAttribute(IAppConst.SESSION_USER_NAME);
		if(null == user) {
			log.warn("获取轮播图时无用户信息！");
			return Collections.emptyList();
		}
		
		int userId = user.getUserId();
		int userLevel = user.getLevel();
		
		List<PicShowOut> psOutList = new ArrayList<>();
		List<PicShow> psList = picShowService.getActivePicList();
		if(null != psList) {
			for(PicShow pShow : psList) {
				PicShowOut psOut = new PicShowOut(pShow);
				int prjType = pShow.getPrjType();
				int prjId = pShow.getPrjId();
				if(userLevel > 5) { // 6级用户检查
					switch(prjType) {
						case IDicInfoConst.PRJ_LEADER_CONTROL:
							psOut.setReadable(prjContactService.isUserRelateLdprj(userId, prjId));
							break;
						case IDicInfoConst.PRJ_CITY_BUILD:
							psOut.setReadable(cbPrjService.isUserRelateCbprj(userId, prjId));
							break;
						default:
					}
				}
				psOutList.add(psOut);
			}
		}
		return psOutList;
	}
	
}
