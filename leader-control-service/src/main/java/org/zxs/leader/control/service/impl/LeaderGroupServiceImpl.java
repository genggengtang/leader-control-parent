package org.zxs.leader.control.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zxs.leader.control.dao.interf.ILeaderGroupMapper;
import org.zxs.leader.control.dao.model.LeaderGroup;
import org.zxs.leader.control.dao.model.vo.output.rows.LeaderGroupRow;
import org.zxs.leader.control.service.interf.ILeaderGroupService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class LeaderGroupServiceImpl implements ILeaderGroupService {
	
	@Resource
	private ILeaderGroupMapper leaderGroupMapper;

	@Override
	public PageInfo<LeaderGroupRow> getLeaderGroupRowsByPage(Integer pageNum, Integer pageSize, String keyword) {
		PageHelper.startPage(pageNum, pageSize);
		List<LeaderGroupRow> rows = this.leaderGroupMapper.selectAllOuts();
		if (null == keyword) {
			rows = this.leaderGroupMapper.selectAllOuts();
		} else {
			rows = this.leaderGroupMapper.selectRowsByKeyword(keyword);
		}
		return new PageInfo<>(rows);
	}

	@Override
	public LeaderGroup findById(Integer id) {
		return this.leaderGroupMapper.selectByPrimaryKey(id);
	}

	@Override
	public int insert(LeaderGroup leaderGroup) {
		return this.leaderGroupMapper.insert(leaderGroup);
	}

	@Override
	@Transactional
	public int update(LeaderGroup leaderGroup) {
		return this.leaderGroupMapper.updateByPrimaryKey(leaderGroup);
	}

}
