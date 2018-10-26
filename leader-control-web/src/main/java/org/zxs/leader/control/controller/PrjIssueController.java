package org.zxs.leader.control.controller;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zxs.leader.control.dao.model.vo.output.PrjIssueOut;
import org.zxs.leader.control.service.interf.IPrjIssueService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags="项目沟通接口")
public class PrjIssueController {
	
	@Resource
	private IPrjIssueService issueService;
	
	@RequestMapping(value = "prj-issue-detail/{id}", method = RequestMethod.GET)
	@ApiOperation(httpMethod = "GET", value = "项目沟通详情", produces = MediaType.APPLICATION_JSON_VALUE)
	public PrjIssueOut getPrjIssueDetail(@PathVariable("id")Integer id) {
		return issueService.getIssueById(id);
	}
	
}