package org.zxs.leader.control.service.interf;

import java.util.List;

import org.zxs.leader.control.dao.model.vo.output.PrjMapLineOut;

public interface IPrjMapService {

	/**
	 * 根据项目编号获取地图线信息
	 * @param prjId
	 * @param prjType
	 * @return
	 */
	List<PrjMapLineOut> getLineByPrjId(int prjId, int prjType);
}
