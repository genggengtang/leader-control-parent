package org.zxs.leader.control.service;

import org.springframework.beans.factory.annotation.Autowired;

import tk.mybatis.mapper.common.Mapper;

public abstract class BaseService<M extends Mapper<C>, C> {
	
	@Autowired
	protected M mapper;

}