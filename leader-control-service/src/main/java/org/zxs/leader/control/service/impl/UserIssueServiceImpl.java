package org.zxs.leader.control.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zxs.leader.control.dao.interf.IUserIssueMapper;
import org.zxs.leader.control.dao.model.UserIssue;
import org.zxs.leader.control.dao.model.vo.output.UserIssueOut;
import org.zxs.leader.control.dao.model.vo.output.rows.UserIssueRow;
import org.zxs.leader.control.service.interf.IUserIssueService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Service
public class UserIssueServiceImpl implements IUserIssueService {

	@Resource
	private IUserIssueMapper uIssueMapper;

	@Override
	@Transactional
	public int saveUserIssue(UserIssue userIssue) {
		return uIssueMapper.insert(userIssue);
	}

	@Override
	public PageInfo<UserIssueOut> getIssueByPage(Integer pageNum, Integer pageSize, int userId) {
		PageHelper.startPage(pageNum, pageSize);
        List<UserIssueOut> issuePageList = uIssueMapper.selectIssueListByUser(userId);
        return new PageInfo<>(issuePageList);
	}

	@Override
	public PageInfo<UserIssueRow> getUserIssueOutsByPage(Integer pageNum, Integer pageSize, String keyword) {
		PageHelper.startPage(pageNum, pageSize);
		List<UserIssueRow> rows = null;
		if (null == keyword) {
			rows = this.uIssueMapper.selectAllOuts();
		} else {
			rows = this.uIssueMapper.selectRowsByKeyword(keyword);
		}
		return new PageInfo<>(rows);
	}


}
