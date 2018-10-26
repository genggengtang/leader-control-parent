package org.zxs.leader.control.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.zxs.leader.control.dao.interf.IWorkInfoMapper;
import org.zxs.leader.control.dao.model.WorkInfo;
import org.zxs.leader.control.dao.model.WorkInfoExample;
import org.zxs.leader.control.service.interf.IWorkInfoService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Service
public class WorkInfoServiceImpl implements IWorkInfoService {

	@Resource
	private IWorkInfoMapper workInfoMapper;

	@Override
	public PageInfo<WorkInfo> getInfoByPage(int pageNum, int pageSize) {
		WorkInfoExample example = new WorkInfoExample();
		example.setOrderByClause("create_at desc");
		PageHelper.startPage(pageNum, pageSize);
        List<WorkInfo> prgPageList = workInfoMapper.selectByExample(example);
        return new PageInfo<>(prgPageList);
	}

	@Override
	public PageInfo<WorkInfo> getAllWorkInfoByPage(Integer pageNum, Integer pageSize, String keyword) {
		PageHelper.startPage(pageNum, pageSize);
		List<WorkInfo> rows = null;
		if (null == keyword) {
			rows = this.workInfoMapper.selectAll();
		} else {
			rows = this.workInfoMapper.selectRowsByKeyword(keyword);
		}
		return new PageInfo<>(rows);
	}

	@Override
	public WorkInfo findById(Integer id) {
		return this.workInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public int insert(WorkInfo workInfo) {
		return this.workInfoMapper.insert(workInfo);
	}

	@Override
	public int update(WorkInfo workInfo) {
		return this.workInfoMapper.updateByPrimaryKey(workInfo);
	}

}
