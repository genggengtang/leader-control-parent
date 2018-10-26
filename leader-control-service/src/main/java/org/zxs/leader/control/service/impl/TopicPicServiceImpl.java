package org.zxs.leader.control.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zxs.base.model.BussinessException;
import org.zxs.leader.control.dao.interf.IChatGroupUserMapper;
import org.zxs.leader.control.dao.interf.ITopicCommentMapper;
import org.zxs.leader.control.dao.interf.ITopicPicMapper;
import org.zxs.leader.control.dao.interf.ITopicUnreadMapper;
import org.zxs.leader.control.dao.model.TopicComment;
import org.zxs.leader.control.dao.model.TopicPic;
import org.zxs.leader.control.dao.model.TopicUnread;
import org.zxs.leader.control.dao.model.TopicUnreadExample;
import org.zxs.leader.control.dao.model.TopicUnreadExample.Criteria;
import org.zxs.leader.control.dao.model.vo.output.TopicCommentOut;
import org.zxs.leader.control.dao.model.vo.output.TopicDetailOut;
import org.zxs.leader.control.dao.model.vo.output.TopicPicOut;
import org.zxs.leader.control.dao.model.vo.output.rows.TopicPicRow;
import org.zxs.leader.control.service.interf.ITopicPicService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Service
public class TopicPicServiceImpl implements ITopicPicService {

	private static final Log log = LogFactory.getLog(ITopicPicService.class);
	
	@Resource
	private ITopicPicMapper topicPicMapper;
	
	@Resource
	private ITopicCommentMapper topicCommentMapper;
	
	@Resource
	private ITopicUnreadMapper topicUnreadMapper;
	
	@Resource
	private IChatGroupUserMapper cgUserMapper;

	@Override
	@Transactional
	public int saveTopicPic(TopicPic topicPic, List<Integer> userList) throws BussinessException{
		Date nowTime = new Date();
		topicPic.setCreateAt(nowTime);
		topicPic.setUpdateAt(nowTime);
		
		int insertRet = topicPicMapper.insert(topicPic);
		
		if(insertRet == 1) { // 插入成功
			Integer id = topicPic.getId();
			log.info("保存随手拍记录成功！" + id);
			// 添加未读消息记录
			
			int unreadSucc = 0;
			for(Integer userId : userList) {
				TopicUnread tUnread = new TopicUnread();
				tUnread.setTopicId(id);
				tUnread.setUserId(userId);
				tUnread.setReadStatus((byte) 0);
				tUnread.setPushStatus((byte) 0);
				tUnread.setCreateAt(nowTime);
				int unreadRet = topicUnreadMapper.insert(tUnread);
				if(unreadRet == 1) { // 新增未读消息记录成功
					unreadSucc++;
				}
			}
			
			if(unreadSucc == userList.size()) {
				log.info("保存随手拍未读消息记录成功！" + id);
			}else {
				log.info("保存随手拍未读消息记录失败！");
				throw new BussinessException("保存随手拍未读消息记录失败！");
			}
		}else {
			log.info("保存随手拍记录失败！");
		}
		
		return insertRet;
	}

	@Override
	public PageInfo<TopicPicOut> getMyTopicByPage(Integer pageNum, Integer pageSize, int userId) {
		PageHelper.startPage(pageNum, pageSize);
        List<TopicPicOut> topicPageList = topicPicMapper.selectTopicByUser(userId);
        return new PageInfo<>(topicPageList);
	}

	@Override
	public TopicDetailOut getTopicDetail(int id) {
		TopicDetailOut detailOut = topicPicMapper.selectDetailById(id);
		
		if(null != detailOut) {
			// 查询与该主题相关的评论
			List<TopicCommentOut> commentList = topicCommentMapper.selectByTopic(id);
			if(null != commentList)
				detailOut.setCommentList(commentList);
		}
		
		return detailOut;
	}

	@Override
	@Transactional
	public int sendComment(int topicId, int userId, String comment) {
		TopicComment tc = new TopicComment();
		tc.setTopicId(topicId);
		tc.setCommentUserId(userId);
		tc.setContent(comment);
		
		Date nowTime = new Date();
		tc.setCreateAt(nowTime);
		int saveCnt = topicCommentMapper.insert(tc);
		log.info("为主题[" + topicId + "]添加评论记录完成，结果为:" + saveCnt);
		
		if(saveCnt == 1) {
			
			// 查询主题基本信息
			TopicPic topicPic = topicPicMapper.selectByPrimaryKey(topicId);
			topicPic.setUpdateAt(nowTime);
			
			if(topicPic.getSendUserId() != userId) { // 评论者非主题作者时，更新主题为已回复状态
				log.info("开始更新主题[" + topicId + "]回复状态！");
				TopicUnreadExample example = new TopicUnreadExample();
				Criteria criteria = example.createCriteria();
				criteria.andTopicIdEqualTo(topicId);
				criteria.andCommentIdIsNull();
				criteria.andReadStatusEqualTo((byte) 0);
				
				TopicUnread updRecord = new TopicUnread();
				updRecord.setReadStatus((byte) 1);
				int updCnt = topicUnreadMapper.updateByExampleSelective(updRecord, example);
				log.info("更新主题[" + topicId + "]回复状态结束，更新数为：" + updCnt);
				
				if(topicPic.getReplyStatus() == 0) {// 将主题回复状态改为已回复
					log.info("将主题[" + topicId + "]回复状态改为已回复!");
					topicPic.setReplyStatus((byte) 1); 
				}
			}
			
			int topicCnt = topicPicMapper.updateByPrimaryKey(topicPic);
			log.info("更新主题[" + topicId + "]信息完成，结果为：" + topicCnt);
			
			log.info("为主题相关人员添加未读消息记录！");
			List<Integer> receiveList = cgUserMapper.selectUserIdByCgId(topicPic.getReceiveCgId(), userId);
			for(Integer iUserId : receiveList) {
				TopicUnread tUnread = new TopicUnread();
				tUnread.setTopicId(topicId);
				tUnread.setUserId(iUserId);
				tUnread.setReadStatus((byte) 0);
				tUnread.setPushStatus((byte) 0);
				tUnread.setCommentId(tc.getId());
				tUnread.setCreateAt(nowTime);
				int insertRet = topicUnreadMapper.insert(tUnread);
				if(insertRet != 1) { // TODO 插入未读消息失败
					log.warn("添加用户[" + iUserId + "]未读消息记录失败！");
				}
			}
			
			log.info("添加未读消息结束，总记录数为[" + receiveList.size() + "]！");
		}
		
		return saveCnt;
	}

	@Override
	public TopicPic getBaseTopic(int id) {
		return topicPicMapper.selectByPrimaryKey(id);
	}

	@Override
	@Transactional
	public int deleteTopic(TopicPic tp) {
		int delCnt = topicPicMapper.updateByPrimaryKey(tp);
		// 更新改主题下所有未读、未推送记录
		TopicUnreadExample tUnreadExample = new TopicUnreadExample();
		Criteria criteria = tUnreadExample.createCriteria();
		criteria.andTopicIdEqualTo(tp.getId());
		
		TopicUnread tUnread = new TopicUnread();
		tUnread.setReadStatus((byte) 1);
		tUnread.setPushStatus((byte) 1);
		tUnread.setUpdateAt(new Date());
		
		topicUnreadMapper.updateByExampleSelective(tUnread, tUnreadExample);
		return delCnt;
	}

	@Override
	public PageInfo<TopicPicRow> getTopicPicOutsByPage(Integer pageNum, Integer pageSize, String keyword) {
		PageHelper.startPage(pageNum, pageSize);
		List<TopicPicRow> rows = null;
		if (null == keyword) {
			rows = this.topicPicMapper.selectAllOuts();
		} else {
			rows = this.topicPicMapper.selectRowsByKeyword(keyword);
		}
		return new PageInfo<>(rows);
	}

}
