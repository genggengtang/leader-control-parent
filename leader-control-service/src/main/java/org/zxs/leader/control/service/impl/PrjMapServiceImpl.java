package org.zxs.leader.control.service.impl;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.zxs.leader.control.dao.interf.IPrjMapLineMapper;
import org.zxs.leader.control.dao.interf.IPrjPointMapper;
import org.zxs.leader.control.dao.model.PrjMapLine;
import org.zxs.leader.control.dao.model.PrjPoint;
import org.zxs.leader.control.dao.model.vo.output.PrjMapLineOut;
import org.zxs.leader.control.service.interf.IPrjMapService;


@Service
public class PrjMapServiceImpl implements IPrjMapService {

	@Resource
	private IPrjMapLineMapper mapLineMapper;
	
	@Resource
	private IPrjPointMapper pointMapper;

	@Override
	public List<PrjMapLineOut> getLineByPrjId(int prjId, int prjType) {
		List<PrjMapLineOut> linesRet = new ArrayList<>();
		PrjMapLine lineCond = new PrjMapLine();
		lineCond.setPrjId(prjId);
		lineCond.setPrjType(prjType);
		List<PrjMapLine> lineList = mapLineMapper.select(lineCond);
		if(null == lineList || lineList.isEmpty())
			return linesRet;
		
		for(PrjMapLine pLine : lineList) {
			PrjPoint pointCond = new PrjPoint();
			pointCond.setPrjLineId(pLine.getId());
			List<PrjPoint> pointList = pointMapper.select(pointCond);
			PrjMapLineOut eachLine = new PrjMapLineOut();
			eachLine.setLineId(pLine.getId());
			eachLine.setPointList(pointList);
			linesRet.add(eachLine);
		}
		return linesRet;
	}


}
