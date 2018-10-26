package org.zxs.leader.control.service.admin.impl;

import java.util.ArrayList;
import java.util.List;

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
import org.zxs.leader.control.dao.model.OrgUnit;
import org.zxs.leader.control.dao.model.OrgUser;
import org.zxs.leader.control.dao.model.PrjMonthPlan;
import org.zxs.leader.control.dao.model.PrjYearPlan;
import org.zxs.leader.control.dao.model.TopicPic;
import org.zxs.leader.control.dao.model.UserIssue;
import org.zxs.leader.control.service.admin.interf.ExcelExportService;

import tk.mybatis.mapper.entity.Example;

@Service
public class ExcelExportServiceImplt implements ExcelExportService {
	
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
	public List<Object> getTableList(String table) {
		List<Object> oList = null;
		switch (table) {
			case "org_unit": // soft
				Example orgUnit = new Example(OrgUnit.class);
				orgUnit.createCriteria().andEqualTo("isDeleted", 0);
				oList = new ArrayList<Object>(this.orgUnitMapper.selectByExample(orgUnit));
				break;
			case "org_user": // soft
				Example orgUser = new Example(OrgUser.class);
				orgUser.createCriteria().andEqualTo("isDeleted", 0);
				oList = new ArrayList<Object>(this.orgUserMapper.selectByExample(orgUser));
				break;
			case "prj_year_plan": // soft
				Example prjYearPlan = new Example(PrjYearPlan.class);
				prjYearPlan.createCriteria().andEqualTo("isDeleted", 0);
				oList = new ArrayList<Object>(this.prjYearPlanMapper.selectByExample(prjYearPlan));
				break;
			case "prj_month_plan": // soft
				Example prjMonthPlan = new Example(PrjMonthPlan.class);
				prjMonthPlan.createCriteria().andEqualTo("isDeleted", 0);
				oList = new ArrayList<Object>(this.prjMonthPlanMapper.selectByExample(prjMonthPlan));
				break;
			case "cb_invest_source":
				oList = new ArrayList<Object>(this.cbInvestSourceMapper.selectAll());
				break;
			case "cb_plan_prj": // soft
				Example cbPlanPrj = new Example(CbPlanPrj.class);
				cbPlanPrj.createCriteria().andEqualTo("isDeleted", 0);
				oList = new ArrayList<Object>(this.cbPlanPrjMapper.selectByExample(cbPlanPrj));
				break;
			case "chat_group_info": // soft
				Example chatGroupInfo = new Example(ChatGroupInfo.class);
				chatGroupInfo.createCriteria().andEqualTo("isDeleted", 0);
				oList = new ArrayList<Object>(this.chatGroupInfoMapper.selectByExample(chatGroupInfo));
				break;
			case "city_build_prj": // soft
				Example cityBuildPrj = new Example(CityBuildPrj.class);
				cityBuildPrj.createCriteria().andEqualTo("isDeleted", 0);
				oList = new ArrayList<Object>(this.cityBuildPrjMapper.selectByExample(cityBuildPrj));
				break;
			case "city_plan_prj": // soft
				Example cityPlanPrj = new Example(CityPlanPrj.class);
				cityPlanPrj.createCriteria().andEqualTo("isDeleted", 0);
				oList = new ArrayList<Object>(this.cityPlanPrjMapper.selectByExample(cityPlanPrj));
				break;
			case "cp_prj_org":
				oList = new ArrayList<Object>(this.cpPrjOrgMapper.selectAll());
				break;
			case "meeting_note":
				oList = new ArrayList<Object>(this.meetingNoteMapper.selectAll());
				break;
			case "prj_attachment":
				oList = new ArrayList<Object>(this.prjAttachmentMapper.selectAll());
				break;
			case "prj_contact":
				oList = new ArrayList<Object>(this.prjContactMapper.selectAll());
				break;
			case "prj_issue":
				oList = new ArrayList<Object>(this.prjIssueMapper.selectAll());
				break;
			case "prj_map_line":
				oList = new ArrayList<Object>(this.prjMapLineMapper.selectAll());
				break;
			case "prj_point":
				oList = new ArrayList<Object>(this.prjPointMapper.selectAll());
				break;
			case "prj_prove":
				oList = new ArrayList<Object>(this.prjProveMapper.selectAll());
				break;
			case "work_info":
				oList = new ArrayList<Object>(this.workInfoMapper.selectAll());
				break;
			case "user_issue": // soft
				Example userIssue = new Example(UserIssue.class);
				userIssue.createCriteria().andEqualTo("isDeleted", 0);
				oList = new ArrayList<Object>(this.userIssueMapper.selectByExample(userIssue));
				break;
			case "topic_pic": // soft
				Example topicPic = new Example(TopicPic.class);
				topicPic.createCriteria().andEqualTo("isDeleted", 0);
				oList = new ArrayList<Object>(this.topicPicMapper.selectByExample(topicPic));
				break;
			default:break;
		}
		return oList;
	}

}
