package org.zxs.leader.control.service.interf;

import org.zxs.leader.control.dao.model.vo.output.AdminUserOut;

public interface IAdminUserService {
	
	/**
	 * 根据用户名、密码获取后台管理员信息
	 * @param loginName
	 * @param password
	 * @return
	 */
	AdminUserOut getAdminByLoginNameAndPassword(String loginName, String password);
	
}
