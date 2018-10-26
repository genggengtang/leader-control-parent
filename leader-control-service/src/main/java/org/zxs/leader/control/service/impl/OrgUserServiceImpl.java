package org.zxs.leader.control.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zxs.leader.control.dao.consts.IDicInfoConst;
import org.zxs.leader.control.dao.interf.IDicInfoMapper;
import org.zxs.leader.control.dao.interf.ILeaderGroupMapper;
import org.zxs.leader.control.dao.interf.IOrgUserMapper;
import org.zxs.leader.control.dao.model.DicInfo;
import org.zxs.leader.control.dao.model.LeaderGroup;
import org.zxs.leader.control.dao.model.OrgUser;
import org.zxs.leader.control.dao.model.vo.output.LoginUserOut;
import org.zxs.leader.control.dao.model.vo.output.OptionsOut;
import org.zxs.leader.control.dao.model.vo.output.PhoneListOut;
import org.zxs.leader.control.dao.model.vo.output.SimpleUserOut;
import org.zxs.leader.control.dao.model.vo.output.rows.OrgUserRow;
import org.zxs.leader.control.dao.model.vo.query.OrgUserQuery;
import org.zxs.leader.control.dao.model.vo.query.PhoneListQuery;
import org.zxs.leader.control.service.BaseService;
import org.zxs.leader.control.service.interf.IOrgUserService;
import org.zxs.leader.control.service.util.ExceptionMessageTranslator;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class OrgUserServiceImpl extends BaseService<IOrgUserMapper, OrgUser> implements IOrgUserService {

	private static final Log logger = LogFactory.getLog(OrgUserServiceImpl.class);
	
	private static final String TABLE_NAME_ENG = "org_user";
	
	@Resource
	private IOrgUserMapper orgUserMapper;
	
	@Resource
	private ILeaderGroupMapper groupMapper;
	
	@Resource
	private IDicInfoMapper dicMapper;

	@Override
	public boolean isUserExist(String username) {
		OrgUser record = new OrgUser();
		record.setLoginName(username);
		return orgUserMapper.selectCount(record) == 1;
	}

	@Override
	public List<LoginUserOut> getLoginInfo(String username, String password) {
		OrgUserQuery query = new OrgUserQuery();
		query.setLoginName(username);
		if(null != password)
			query.setInputPsw(password);
		return orgUserMapper.selectLoginInfoByLoginNameAndPsw(query);
	}

	@Override
	public boolean isGroupLeader(int userId) {
		LeaderGroup record = new LeaderGroup();
		record.setUserId(userId);
		return groupMapper.selectCount(record) == 1;
	}

	@Override
	public boolean isUserExist(int id) {
		OrgUser record = new OrgUser();
		record.setId(id);
		return orgUserMapper.selectCount(record) == 1;
	}

	@Override
	public List<OrgUser> getByUserName(String username) {
		OrgUser record = new OrgUser();
		record.setLoginName(username);
		return orgUserMapper.select(record);
	}

	@Override
	public LoginUserOut getLoginInfoById(int id, String password) {
		return orgUserMapper.selectLoginInfoById(id, password);
	}

	/* (non-Javadoc)
	 * @see org.zxs.leader.control.service.interf.IOrgUserService#getPhoneList(org.zxs.leader.control.dao.model.vo.query.PhoneListQuery)
	 */
	@Override
	public List<PhoneListOut> getPhoneList(PhoneListQuery query) {
		List<PhoneListOut> pList = new ArrayList<>();
		DicInfo dInfo = new DicInfo();
		Integer prjType = query.getPrjType();
		if(null != prjType && prjType == IDicInfoConst.PRJ_LEADER_CONTROL)
			dInfo.setType((short) 208);
		else
			dInfo.setType((short) 210);
		List<DicInfo> dicList = dicMapper.select(dInfo);
		for(DicInfo gType : dicList) {
			PhoneListOut plOut = new PhoneListOut();
			List<SimpleUserOut> phoneList = orgUserMapper.selectPhoneListByType(query, gType.getId());
			if(!phoneList.isEmpty()) {
				plOut.setGroupName(gType.getValueRemark());
				plOut.setGroupMembers(phoneList);
				pList.add(plOut);
			}
		}
		return pList;
	}

	@Override
	@Transactional
	public int updatePassword(int userId, String pswdNew) {
		return orgUserMapper.updatePassword(userId, pswdNew);
	}

	@Override
	public List<OrgUser> getAllOrgUser() {
		return this.orgUserMapper.selectAll();
	}

	@Override
	public PageInfo<OrgUserRow> getRowsByPage(Integer pageNum, Integer pageSize, String keyword) {
		PageHelper.startPage(pageNum, pageSize);
		List<OrgUserRow> rows = null;
		if (null == keyword) {
			rows = this.orgUserMapper.selectAllRows();
		} else {
			rows = this.orgUserMapper.selectRowsByKeyword(keyword);
		}
		return new PageInfo<>(rows);
	}

	@Override
	public OrgUser findById(Integer id) {
		return this.mapper.selectByPrimaryKey(id);
	}

	@Override
	public int insert(OrgUser orgUser) {
		return this.mapper.insert(orgUser);
	}

	@Override
	public int update(OrgUser orgUser) {
		return this.mapper.updateByPrimaryKey(orgUser);
	}

	@Override
	public List<OptionsOut> getAllUserIdOpts() {
		return this.orgUserMapper.selectAllUserIdOpts();
	}

	@Override
	public String insertWithResult(OrgUser record) {
		Integer id = record.getId();
		try {
			int change = this.orgUserMapper.insert(record);
			if (change > 0) {
				logger.info(String.format("新增成功！更改行数[%s] - 记录编号[%s] - 表[%s]。", change, id, TABLE_NAME_ENG));
			} else {
				logger.info(String.format("新增失败！更改行数[%s] - 记录编号[%s] - 表[%s]。", change, id, TABLE_NAME_ENG));
			}
		} catch (DuplicateKeyException e) {
			String message = e.getRootCause().getMessage();
			String transMsg = ExceptionMessageTranslator.translate(message);
			String duplExcepMsg = String.format("新增失败！编号为[%s]在[%s]表中已经存在。%s。", id, TABLE_NAME_ENG, transMsg);
			logger.info(duplExcepMsg);
			return duplExcepMsg;
		} catch (DataIntegrityViolationException e) {
			String message = e.getRootCause().getMessage();
			String transMsg = ExceptionMessageTranslator.translate(message);
			String integrityExcepMsg = String.format("新增失败！编号为[%s]的记录在新增时违反数据完整性：%s，请检查该字段的数据类型！", id, transMsg);;
			logger.info(integrityExcepMsg);
			return integrityExcepMsg;
		}
		return null;
	}
	
}
