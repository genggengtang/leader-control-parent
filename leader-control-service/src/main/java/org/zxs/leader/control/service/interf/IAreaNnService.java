package org.zxs.leader.control.service.interf;

import java.util.List;

import org.zxs.leader.control.dao.model.vo.output.OptionsOut;

public interface IAreaNnService {
	/**
	 * 获取所有地区列表
	 * @return
	 */
	List<OptionsOut> getAllFullNameList();
	
	/**
	 * 获取所有地区列表，除了省级
	 * @return
	 */
	List<OptionsOut> getAllListWithoutProv();

	
	List<OptionsOut> getAllAreaNameOptions();
}
