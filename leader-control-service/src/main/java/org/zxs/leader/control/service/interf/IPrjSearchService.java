package org.zxs.leader.control.service.interf;

import java.util.List;

import org.zxs.leader.control.dao.model.vo.output.PrcSearchOut;

public interface IPrjSearchService {

	/**
	 * 根据市领导关键字，查询市领导联系项目相关负责领导
	 * @param nameLike
	 * @return
	 */
	List<PrcSearchOut> getLeaderByNameLike(String nameLike);
	
	/**
	 * 根据市领导关键字，查询城建计划项目相关负责领导
	 * @param nameLike
	 * @return
	 */
	List<PrcSearchOut> getCbLeaderByNameLike(String nameLike);
}
