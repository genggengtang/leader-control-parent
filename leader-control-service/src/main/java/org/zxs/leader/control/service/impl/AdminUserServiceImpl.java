package org.zxs.leader.control.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.zxs.leader.control.dao.interf.IAdminUserMapper;
import org.zxs.leader.control.dao.model.vo.output.AdminUserOut;
import org.zxs.leader.control.service.interf.IAdminUserService;


@Service
public class AdminUserServiceImpl implements IAdminUserService {

	@Resource
	private IAdminUserMapper adminUserMapper;

	@Override
	public AdminUserOut getAdminByLoginNameAndPassword(String loginName, String password) {
		return adminUserMapper.selectByLoginNameAndPassword(loginName, password);
	}

}
