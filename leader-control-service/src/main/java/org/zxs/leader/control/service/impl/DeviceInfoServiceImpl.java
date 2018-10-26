package org.zxs.leader.control.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zxs.leader.control.dao.interf.IDeviceInfoMapper;
import org.zxs.leader.control.dao.model.DeviceInfo;
import org.zxs.leader.control.service.interf.IDeviceInfoService;

@Service
public class DeviceInfoServiceImpl implements IDeviceInfoService {
	private static final Log log = LogFactory.getLog(IDeviceInfoService.class);
	
	@Resource
	private IDeviceInfoMapper deviceInfoMapper;

	@Override
	@Transactional
	public int saveOrUpdateDevice(DeviceInfo device) {
		DeviceInfo cond = new DeviceInfo();
		cond.setUuid(device.getUuid());
		cond.setIp(device.getIp());
		int existCnt = deviceInfoMapper.selectCount(cond);
		Date nowTime = new Date();
		if(existCnt == 0) {
			device.setCreateAt(nowTime);
			device.setUpdateAt(nowTime);
			log.info("新增终端:" + device.getUuid() + ",IP:" + device.getIp());
			return deviceInfoMapper.insert(device);
		}else if(existCnt == 1) {
			DeviceInfo updDevice = deviceInfoMapper.selectOne(cond);
			device.setUpdateAt(nowTime);
			device.setId(updDevice.getId());
			return deviceInfoMapper.updateByPrimaryKeySelective(device);
		}
		
		return -1;
	}



}
