package org.zxs.leader.control.service.interf;

import java.util.List;

import org.zxs.leader.control.dao.model.vo.output.InvestSourceOut;

public interface IInvestSourceService {

	/**
	 * 根据项目编号及项目类型获取资金来源列表
	 * @param prjId
	 * @param prjType
	 * @return
	 */
	List<InvestSourceOut> getInvestSourceListByPrj(int prjId);
}
