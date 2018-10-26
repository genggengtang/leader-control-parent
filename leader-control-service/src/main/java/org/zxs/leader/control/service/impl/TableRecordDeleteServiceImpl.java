package org.zxs.leader.control.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.zxs.leader.control.dao.interf.ICbInvestSourceMapper;
import org.zxs.leader.control.dao.interf.ICbPlanPrjMapper;
import org.zxs.leader.control.dao.interf.IChatGroupInfoMapper;
import org.zxs.leader.control.dao.interf.IChatGroupUserMapper;
import org.zxs.leader.control.dao.interf.ICityBuildPrjMapper;
import org.zxs.leader.control.dao.interf.ICityPlanPrjMapper;
import org.zxs.leader.control.dao.interf.ICpPrjOrgMapper;
import org.zxs.leader.control.dao.interf.ILeaderGroupMapper;
import org.zxs.leader.control.dao.interf.IMeetingNoteMapper;
import org.zxs.leader.control.dao.interf.IOrgUnitMapper;
import org.zxs.leader.control.dao.interf.IOrgUserMapper;
import org.zxs.leader.control.dao.interf.IPrjAttachmentMapper;
import org.zxs.leader.control.dao.interf.IPrjContactMapper;
import org.zxs.leader.control.dao.interf.IPrjIssueMapper;
import org.zxs.leader.control.dao.interf.IPrjMapLineMapper;
import org.zxs.leader.control.dao.interf.IPrjMonthPlanMapper;
import org.zxs.leader.control.dao.interf.IPrjPointMapper;
import org.zxs.leader.control.dao.interf.IPrjProveMapper;
import org.zxs.leader.control.dao.interf.IPrjYearPlanMapper;
import org.zxs.leader.control.dao.interf.ITopicCommentMapper;
import org.zxs.leader.control.dao.interf.ITopicPicMapper;
import org.zxs.leader.control.dao.interf.IUserIssueMapper;
import org.zxs.leader.control.dao.interf.IWorkInfoMapper;
import org.zxs.leader.control.dao.model.CbPlanPrj;
import org.zxs.leader.control.dao.model.ChatGroupInfo;
import org.zxs.leader.control.dao.model.CityBuildPrj;
import org.zxs.leader.control.dao.model.CityPlanPrj;
import org.zxs.leader.control.dao.model.LeaderGroup;
import org.zxs.leader.control.dao.model.OrgUnit;
import org.zxs.leader.control.dao.model.OrgUser;
import org.zxs.leader.control.dao.model.PrjMonthPlan;
import org.zxs.leader.control.dao.model.PrjYearPlan;
import org.zxs.leader.control.dao.model.TopicComment;
import org.zxs.leader.control.dao.model.TopicPic;
import org.zxs.leader.control.dao.model.UserIssue;
import org.zxs.leader.control.service.interf.ITableRecordDeleteService;

@Service
public class TableRecordDeleteServiceImpl implements ITableRecordDeleteService {

	@Resource
	private IOrgUnitMapper orgUnitMapper;
	
	@Resource
	private IOrgUserMapper orgUserMapper;
	
	@Resource
	private IPrjYearPlanMapper prjYearPlanMapper;
	
	@Resource
	private IPrjMonthPlanMapper prjMonthPlanMapper;
	
	@Resource
	private ICbInvestSourceMapper cbInvestSourceMapper;
	
	@Resource
	private ICbPlanPrjMapper cbPlanPrjMapper;
	
	@Resource
	private IChatGroupInfoMapper chatGroupInfoMapper;
	
	@Resource
	private IChatGroupUserMapper chatGroupUserMapper;
	
	@Resource
	private ICityBuildPrjMapper cityBuildPrjMapper;
	
	@Resource
	private ICityPlanPrjMapper cityPlanPrjMapper;
	
	@Resource
	private ICpPrjOrgMapper cpPrjOrgMapper;
	
	@Resource
	private ILeaderGroupMapper leaderGroupMapper;
	
	@Resource
	private IMeetingNoteMapper meetingNoteMapper;
	
	@Resource
	private IPrjAttachmentMapper prjAttachmentMapper;
	
	@Resource
	private IPrjContactMapper prjContactMapper;
	
	@Resource
	private IPrjIssueMapper prjIssueMapper;
	
	@Resource
	private IPrjMapLineMapper prjMapLineMapper;
	
	@Resource
	private IPrjPointMapper prjPointMapper;
	
	@Resource
	private IPrjProveMapper prjProveMapper;
	
	@Resource
	private IWorkInfoMapper workInfoMapper;
	
	@Resource
	private IUserIssueMapper userIssueMapper;
	
	@Resource
	private ITopicPicMapper topicPicMapper;
	
	@Resource
	private ITopicCommentMapper topicCommentMapper;
	
	@Override
	public int delete(String table, Integer id) {
		switch (table) {
			case "org_unit":
				OrgUnit orgUnit = new OrgUnit();
				orgUnit.setId(id);
				orgUnit.setIsDeleted(true);
				return this.orgUnitMapper.updateByPrimaryKeySelective(orgUnit);
			case "org_user":
				OrgUser orgUser = new OrgUser();
				orgUser.setId(id);
				orgUser.setIsDeleted(true);
				return this.orgUserMapper.updateByPrimaryKeySelective(orgUser);
			case "prj_year_plan":
				PrjYearPlan prjYearPlan = new PrjYearPlan();
				prjYearPlan.setId(id);
				prjYearPlan.setIsDeleted(true);
				return this.prjYearPlanMapper.updateByPrimaryKeySelective(prjYearPlan);
			case "prj_month_plan":
				PrjMonthPlan prjMonthPlan = new PrjMonthPlan();
				prjMonthPlan.setId(id);
				prjMonthPlan.setIsDeleted(true);
				return this.prjMonthPlanMapper.updateByPrimaryKeySelective(prjMonthPlan);
			case "cb_invest_source":
				return this.cbInvestSourceMapper.deleteByPrimaryKey(id);
			case "cb_plan_prj":
				CbPlanPrj cbPlanPrj = new CbPlanPrj();
				cbPlanPrj.setId(id);
				cbPlanPrj.setIsDeleted(true);
				return this.cbPlanPrjMapper.updateByPrimaryKeySelective(cbPlanPrj);
			case "chat_group_info":
				ChatGroupInfo chatGroupInfo = new ChatGroupInfo();
				chatGroupInfo.setId(id);
				chatGroupInfo.setIsDeleted(true);
				return this.chatGroupInfoMapper.updateByPrimaryKeySelective(chatGroupInfo);
			case "chat_group_user":
				return this.chatGroupUserMapper.deleteByPrimaryKey(id);
			case "city_build_prj":
				CityBuildPrj cityBuildPrj = new CityBuildPrj();
				cityBuildPrj.setId(id);
				cityBuildPrj.setIsDeleted(true);
				return this.cityBuildPrjMapper.updateByPrimaryKeySelective(cityBuildPrj);
			case "city_plan_prj":
				CityPlanPrj cityPlanPrj = new CityPlanPrj();
				cityPlanPrj.setId(id);
				cityPlanPrj.setIsDeleted(true);
				return this.cityPlanPrjMapper.updateByPrimaryKeySelective(cityPlanPrj);
			case "cp_prj_org":
				return this.cpPrjOrgMapper.deleteByPrimaryKey(id);
			case "leader_group":
				LeaderGroup leaderGroup = new LeaderGroup();
				leaderGroup.setId(id);
				leaderGroup.setIsDeleted(true);
				return this.leaderGroupMapper.updateByPrimaryKeySelective(leaderGroup);
			case "meeting_note":
				return this.meetingNoteMapper.deleteByPrimaryKey(id);
			case "prj_attachment":
				return this.prjAttachmentMapper.deleteByPrimaryKey(id);
			case "prj_contact":
				return this.prjContactMapper.deleteByPrimaryKey(id);
			case "prj_issue":
				return this.prjIssueMapper.deleteByPrimaryKey(id);
			case "prj_map_line":
				return this.prjMapLineMapper.deleteByPrimaryKey(id);
			case "prj_point":
				return this.prjPointMapper.deleteByPrimaryKey((long)id);
			case "prj_prove":
				return this.prjProveMapper.deleteByPrimaryKey(id);
			case "work_info":
				return this.workInfoMapper.deleteByPrimaryKey(id);
			case "user_issue":
				UserIssue userIssue = new UserIssue();
				userIssue.setId(id);
				userIssue.setIsDeleted(true);
				return this.userIssueMapper.updateByPrimaryKeySelective(userIssue);
			case "topic_pic":
				TopicPic topicPic = new TopicPic();
				topicPic.setId(id);
				topicPic.setIsDeleted(true);
				return this.topicPicMapper.updateByPrimaryKeySelective(topicPic);
			case "topic_comment":
				TopicComment topicComment = new TopicComment();
				topicComment.setId(id);
				topicComment.setIsDeleted(true);
				return this.topicCommentMapper.updateByPrimaryKeySelective(topicComment);
			default:break;
		}
		return 0;
	}

}
