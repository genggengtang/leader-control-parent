package org.zxs.leader.control.controller;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zxs.base.model.PageReturnBean;
import org.zxs.leader.control.dao.model.WorkInfo;
import org.zxs.leader.control.service.interf.IWorkInfoService;

import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags="工作信息接口")
public class WorkInfoController {
	
	@Resource
	private IWorkInfoService workInfoService;
	
	@RequestMapping(value = "work-info-page", method = RequestMethod.GET)
	@ApiOperation(httpMethod = "GET", value = "工作信息分页列表", produces = MediaType.APPLICATION_JSON_VALUE)
	public PageReturnBean<WorkInfo> getWorkInfoByPage(
			@RequestParam(required=false,value="pageNum", defaultValue="1") Integer pageNum,
			@RequestParam(required=false,value="pageSize", defaultValue="10") Integer pageSize,
			@RequestParam(required=false,value="draw", defaultValue="") String draw) {
		PageInfo<WorkInfo> pageInfo = workInfoService.getInfoByPage(pageNum, pageSize);
		PageReturnBean<WorkInfo> pageRet = new PageReturnBean<>();
		pageRet.setErrorCode(0);
		pageRet.setDraw(draw);
		pageRet.setData(pageInfo.getList());
		pageRet.setTotal(pageInfo.getTotal());
		return pageRet;
	}

}
