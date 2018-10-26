package org.zxs.leader.control.service.interf;

import org.zxs.leader.control.dao.model.AppVersion;

public interface IAppVersionService {
	/**
	 * 根据操作系统、版本号获取APP最新版本信息
	 * @param os
	 * @param versionCode
	 * @return
	 */
	AppVersion getLatestVersion(byte os, String versionCode);
}
