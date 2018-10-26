package org.zxs.leader.control.service.interf;

import java.util.List;

import org.zxs.leader.control.dao.model.PicShow;

public interface IPicShowService {

	/**
	 * 查询工作资讯分页列表
	 * @param query
	 * @return
	 */
	List<PicShow> getActivePicList();
}
