package org.zxs.leader.control.service.interf;

import org.zxs.leader.control.dao.model.DeviceInfo;

public interface IDeviceInfoService {
	/**
	 * 新增或更新设备信息,当数据库存在多个相同设备信息时，返回-1
	 * @param device
	 * @return
	 */
	int saveOrUpdateDevice(DeviceInfo device);
}
