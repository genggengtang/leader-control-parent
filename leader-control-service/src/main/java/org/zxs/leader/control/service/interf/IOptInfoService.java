package org.zxs.leader.control.service.interf;

import org.zxs.leader.control.dao.model.OptInfo;

public interface IOptInfoService {
	/**
	 * 添加操作日志
	 * @param opt
	 */
	int addOptInfo(OptInfo opt);
}
