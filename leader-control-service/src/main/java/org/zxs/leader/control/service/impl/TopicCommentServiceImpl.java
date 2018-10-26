package org.zxs.leader.control.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.zxs.leader.control.dao.interf.ITopicCommentMapper;
import org.zxs.leader.control.dao.model.vo.output.rows.TopicCommentRow;
import org.zxs.leader.control.service.interf.ITopicCommentService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class TopicCommentServiceImpl implements ITopicCommentService {
	
	@Resource
	private ITopicCommentMapper topicCommentMapper;
	
	@Override
	public PageInfo<TopicCommentRow> getTopicCommentVosByPage(Integer pageNum, Integer pageSize, String keyword) {
		PageHelper.startPage(pageNum, pageSize);
		List<TopicCommentRow> rows = null;
		if (null == keyword) {
			rows = this.topicCommentMapper.selectAllOuts();
		} else {
			rows = this.topicCommentMapper.selectRowsByKeyword(keyword);
		}
		return new PageInfo<>(rows);
	}

}
