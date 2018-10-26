package org.zxs.leader.control.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zxs.base.model.CommonReturnBean;
import org.zxs.leader.control.controller.annotation.Authorization;
import org.zxs.leader.control.controller.annotation.Trace;
import org.zxs.leader.control.dao.consts.IAppConst;
import org.zxs.leader.control.dao.consts.IDicInfoConst;
import org.zxs.leader.control.dao.model.FavoritePrj;
import org.zxs.leader.control.dao.model.vo.output.LoginUserOut;
import org.zxs.leader.control.service.interf.IFavoritePrjService;
import org.zxs.leader.control.service.interf.IOrgUserService;
import org.zxs.leader.control.service.interf.IPrjInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags="用户收藏项目接口")
public class PrjFavoriteController {
	private static final Log log = LogFactory.getLog(PrjFavoriteController.class);
	
	@Resource
	private IPrjInfoService prjInfoService;
	
	@Resource
	private IFavoritePrjService favoriteSerivce;
	
	@Resource
	private IOrgUserService orgUserService;
	

	@RequestMapping(value = "prj-favorite-add", method = RequestMethod.POST)
	@Authorization
    @ApiOperation(httpMethod = "POST", value = "添加项目收藏", produces = MediaType.APPLICATION_JSON_VALUE, notes="请在头部添加授权信息！")
    @ApiImplicitParams({
        @ApiImplicitParam(name = IAppConst.AUTHORIZATION, value = IAppConst.AUTHORIZATION, required = true, dataType = "string", paramType = "header"),
    })
	@Trace(type=IDicInfoConst.OPT_PRJ_FAVOR)
	public CommonReturnBean<Integer> addPrjFavorite(@RequestParam(required=true,value="prjId") Integer prjId,
			@RequestParam(required=false,value="prjType",defaultValue=IDicInfoConst.PRJ_LEADER_CONTROL+"") Integer prjType, HttpSession session) {
		CommonReturnBean<Integer> ret = new CommonReturnBean<>();
		// TODO 判断项目编号是否存在
//		switch(prjType) {
//			case IDicInfoConst.PRJ_LEADER_CONTROL:
//			break;
//			default:
//			if(!prjInfoService.isPrjExist(prjId)){
//				ret.setErrorCode(-203);
//				ret.setErrorMsg("您查询的项目编号不存在！");
//				return ret;
//			}
//		}
		
		
		LoginUserOut user = (LoginUserOut) session.getAttribute(IAppConst.SESSION_USER_NAME);
		int userId = user.getUserId();
		
		if(favoriteSerivce.isFavoritePrj(prjId, prjType, userId)) {
			ret.setErrorCode(-205);
			ret.setErrorMsg("您已关注该项目，不能重复关注！");
			return ret;
		}
		
		FavoritePrj favor = new FavoritePrj();
		favor.setUserId(userId);
		favor.setPrjId(prjId);
		favor.setPrjType(prjType);
		favor.setCreateAt(new Date());
		int iInsertRet = favoriteSerivce.addFavorite(favor);
		if(iInsertRet == 0) {
			ret.setErrorCode(-206);
			ret.setErrorMsg("项目关注失败！");
			return ret;
		}
		
		ret.setErrorCode(0);
		ret.setErrorMsg("项目关注成功！");
		ret.setData(iInsertRet);
		return ret;
	}

	@RequestMapping(value = "prj-favorite-remove/{id}", method = RequestMethod.POST)
    @ApiOperation(httpMethod = "POST", value = "取消项目收藏", produces = MediaType.APPLICATION_JSON_VALUE, notes="请在头部添加授权信息！")
	@Trace(type=IDicInfoConst.OPT_PRJ_NOTFAVOR)
	public CommonReturnBean<Integer> removePrjFavorite(@PathVariable("id")Integer id) {
		CommonReturnBean<Integer> ret = new CommonReturnBean<>();
		
		if(favoriteSerivce.isFavoriteExist(id)) {
			ret.setErrorCode(-208);
			ret.setErrorMsg("您查询的关注编号不存在！");
			return ret;
		}
		
		int iDelRet = favoriteSerivce.removeFavorite(id);
		if(iDelRet == 0) {
			ret.setErrorCode(-209);
			ret.setErrorMsg("项目取消关注失败！");
			return ret;
		}
		
		ret.setErrorCode(0);
		ret.setErrorMsg("项目取消关注成功！");
		return ret;
	}
}
