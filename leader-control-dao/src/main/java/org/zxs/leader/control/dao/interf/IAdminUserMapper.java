package org.zxs.leader.control.dao.interf;

import org.apache.ibatis.annotations.Param;
import org.zxs.leader.control.dao.model.AdminUser;
import org.zxs.leader.control.dao.model.vo.output.AdminUserOut;

import tk.mybatis.mapper.common.Mapper;

public interface IAdminUserMapper extends Mapper<AdminUser> {

	/**
	 * 根据用户名、密码获取后台用户信息
	 * @param loginName
	 * @param password
	 * @return
	 */
	AdminUserOut selectByLoginNameAndPassword(@Param("loginName")String loginName, @Param("password")String password);
	
}