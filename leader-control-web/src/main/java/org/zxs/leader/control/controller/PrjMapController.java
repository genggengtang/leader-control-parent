package org.zxs.leader.control.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zxs.leader.control.dao.consts.IDicInfoConst;
import org.zxs.leader.control.dao.model.vo.output.PrjMapLineOut;
import org.zxs.leader.control.dao.model.vo.output.PrjMapOut;
import org.zxs.leader.control.service.interf.ICbPlanPrjService;
import org.zxs.leader.control.service.interf.IPrjInfoService;
import org.zxs.leader.control.service.interf.IPrjMapService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags="项目地图点线接口")
public class PrjMapController {
	
	@Resource
	private IPrjMapService mapLineService;
	
	@Resource
	private IPrjInfoService prjService;
	
	@Resource
	private ICbPlanPrjService cbPrjService;
	
	@RequestMapping(value = "prj-map-lines/{id:\\d+}", method = RequestMethod.GET)
	@ApiOperation(httpMethod = "GET", value = "项目地图线列表", produces = MediaType.APPLICATION_JSON_VALUE)
	public PrjMapOut getMapLine(@PathVariable("id")Integer id,
			@RequestParam(required=false,value="prjType",defaultValue=IDicInfoConst.PRJ_LEADER_CONTROL+"") Integer prjType) {
		PrjMapOut pmOut = null; 
		switch(prjType) {
			case IDicInfoConst.PRJ_CITY_BUILD:
				pmOut = cbPrjService.getMapInfoById(id);
				break;
			case IDicInfoConst.PRJ_CITY_PLAN:
				break;
			default:
				pmOut = prjService.getMapInfoById(id);
		}
		List<PrjMapLineOut> lineList = mapLineService.getLineByPrjId(id, prjType);
		if(lineList != null && !lineList.isEmpty()) {
			pmOut.setLineList(lineList);
			return pmOut;
		}
    	return null;
	}
	
//	@RequestMapping(value = "prj-map-lines/{id:\\d+}", method = RequestMethod.GET)
//	@ApiOperation(httpMethod = "GET", value = "项目地图线列表", produces = MediaType.APPLICATION_JSON_VALUE)
//	public CommonReturnBean<List<PrjMapLineOut>> getMapLine(@PathVariable("id")Integer id,
//			@RequestParam(required=false,value="prjType",defaultValue=IDicInfoConst.PRJ_LEADER_CONTROL+"") Integer prjType) {
//		CommonReturnBean<List<PrjMapLineOut>> ret = new CommonReturnBean<>();
//		List<PrjMapLineOut> lineList = mapLineService.getLineByPrjId(id, prjType);
//		ret.setErrorCode(0);
//		ret.setData(lineList);
//    	return ret;
//	}
}
