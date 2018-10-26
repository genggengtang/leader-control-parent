package org.zxs.leader.control.dao.interf;

import java.util.List;

import org.zxs.leader.control.dao.model.WorkInfo;

import tk.mybatis.mapper.common.Mapper;

public interface IWorkInfoMapper extends Mapper<WorkInfo> {
	
	/**
	 * 
	* @Title: selectRowsByKeyword 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param keyword
	* @param @return  参数说明 
	* @return List<WorkInfo>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月23日 上午11:22:32
	 */
	List<WorkInfo> selectRowsByKeyword(String keyword);
	
}