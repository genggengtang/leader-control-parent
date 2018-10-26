package org.zxs.leader.control.dao.interf;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zxs.leader.control.dao.model.CbStatics;
import org.zxs.leader.control.dao.model.DicInfo;

import tk.mybatis.mapper.common.Mapper;

public interface ICbStaticsMapper extends Mapper<CbStatics> {
	/**
	 * 获取城建项目分类列表
	 * @param planNo
	 * @return
	 */
	List<DicInfo> selectTypeListByPlan(@Param("planNo")int planNo);
	
	/**
	 * 获取城建项目重点分类列表
	 * @param planNo
	 * @return
	 */
	List<DicInfo> selectLabelListByPlan(@Param("planNo")int planNo);
}