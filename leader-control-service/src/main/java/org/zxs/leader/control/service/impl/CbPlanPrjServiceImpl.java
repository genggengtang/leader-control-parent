package org.zxs.leader.control.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.zxs.leader.control.dao.consts.IDicInfoConst;
import org.zxs.leader.control.dao.interf.ICbPlanPrjMapper;
import org.zxs.leader.control.dao.interf.ICbStaticsMapper;
import org.zxs.leader.control.dao.interf.ICpPrjOrgMapper;
import org.zxs.leader.control.dao.interf.IDicInfoMapper;
import org.zxs.leader.control.dao.model.CbPlanPrj;
import org.zxs.leader.control.dao.model.DicInfo;
import org.zxs.leader.control.dao.model.vo.output.CbClauseOut;
import org.zxs.leader.control.dao.model.vo.output.CbFullDetailOut;
import org.zxs.leader.control.dao.model.vo.output.CbPrjPageInfoOut;
import org.zxs.leader.control.dao.model.vo.output.CbSimpleDetailOut;
import org.zxs.leader.control.dao.model.vo.output.OptionsOut;
import org.zxs.leader.control.dao.model.vo.output.PrcSearchOut;
import org.zxs.leader.control.dao.model.vo.output.PrjContactOut;
import org.zxs.leader.control.dao.model.vo.output.PrjMapOut;
import org.zxs.leader.control.dao.model.vo.output.PrjStaticsOut;
import org.zxs.leader.control.dao.model.vo.output.rows.CbPlanPrjRow;
import org.zxs.leader.control.dao.model.vo.query.CbPrjPageQuery;
import org.zxs.leader.control.dao.model.vo.query.PrjDetailQuery;
import org.zxs.leader.control.service.interf.ICbPlanPrjService;
import org.zxs.leader.control.service.interf.IDicInfoService;
import org.zxs.leader.control.service.util.ExceptionMessageTranslator;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Service
public class CbPlanPrjServiceImpl implements ICbPlanPrjService {

	private static final Log logger = LogFactory.getLog(CbPlanPrjServiceImpl.class);
	
	private static final String TABLE_NAME_ENG = "cb_plan_prj";
	
	@Resource
	private ICbPlanPrjMapper cbPlanPrjMapper;
	
	@Resource
	private ICpPrjOrgMapper prjOrgMapper;
	
	@Resource
	private IDicInfoMapper dicInfoMapper;
	
	@Resource
	private ICbStaticsMapper cStaticsMapper;
	
	@Resource
	private IDicInfoService dicInfoService;

	@Override
	public List<CbPrjPageInfoOut> getCbPrjList(CbPrjPageQuery query) {
		return cbPlanPrjMapper.selectListInfo(query);
	}

	@Override
	public PageInfo<CbPrjPageInfoOut> getInfoByPage(CbPrjPageQuery query, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
        List<CbPrjPageInfoOut> prgPageList = cbPlanPrjMapper.selectListInfo(query);
        return new PageInfo<>(prgPageList);
	}

	@Override
	public List<PrcSearchOut> getCbPrjByNameLike(String nameLike, Integer planNo, Integer isKeyPrj) {
		return cbPlanPrjMapper.selectCbPrjbyNameLike(nameLike, planNo, isKeyPrj);
	}

	@Override
	public List<PrcSearchOut> getPrjOwnerByNameLike(String nameLike, Integer planNo, Integer isKeyPrj) {
		return prjOrgMapper.selectPrjOwnerByNameLike(nameLike, planNo, isKeyPrj);
	}

	@Override
	public CbSimpleDetailOut getSimpleDetailById(int id) {
		return cbPlanPrjMapper.selectSimpleInfoById(id);
	}
	
	@Override
	public CbFullDetailOut getFullDetail(PrjDetailQuery query) {
		return cbPlanPrjMapper.selectFullInfo(query);
	}

	@Override
	public List<PrjContactOut> getOwnerListById(int id) {
		return prjOrgMapper.selectOwnerListByIdAndPrjType(id, IDicInfoConst.PRJ_CITY_BUILD);
	}

	@Override
	public Map<String, Integer> getCbCount(int planNo, Integer label, Integer isKeyPrj) {
		DicInfo dicInfo = dicInfoMapper.selectByPrimaryKey(planNo);
		if(null != dicInfo) {
			String vRemark = dicInfo.getValueRemark();
			if(null != vRemark && !vRemark.isEmpty()) {
				int cnt = cbPlanPrjMapper.selectCbCount(planNo, label, isKeyPrj);
				Map<String, Integer> retMap = new HashMap<>();
				retMap.put(vRemark, cnt);
				return retMap;
			}
		}
		
		return Collections.emptyMap();
	}

	@Override
	public PrjStaticsOut getTotalStatics() {
		return cbPlanPrjMapper.selectTotalStatics();
	}

	@Override
	public List<PrjStaticsOut> getStaticsByLeaderId(Integer userId, Integer isSelf) {
		return cbPlanPrjMapper.selectLeaderStaticsByLeaderId(userId, isSelf);
	}

	@Override
	public List<PrjStaticsOut> getStaticsByFavorite(int userId) {
		return cbPlanPrjMapper.selectStaticsByFavorite(userId);
	}

	@Override
	public CbClauseOut getCbClauseList(int planNo) {
		CbClauseOut cClauseOut = new CbClauseOut();
		cClauseOut.setCbTypeList(cStaticsMapper.selectTypeListByPlan(planNo));
		cClauseOut.setCbLabelList(cStaticsMapper.selectLabelListByPlan(planNo));
		return cClauseOut;
	}

	@Override
	public PrjMapOut getMapInfoById(Integer id) {
		return cbPlanPrjMapper.selectMapInfoById(id);
	}

	@Override
	public boolean isUserRelateCbprj(int userId, Integer id) {
		return prjOrgMapper.selectCountByUserAndPrj(userId, id) > 0;
	}

	@Override
	public PageInfo<CbPlanPrjRow> getCbPlanPrjOutsByPage(Integer pageNum, Integer pageSize, String keyword) {
		PageHelper.startPage(pageNum, pageSize);
		List<CbPlanPrjRow> rows = null;
		if (null == keyword) {
			rows = this.cbPlanPrjMapper.selectAllOuts();
		} else {
			rows = this.cbPlanPrjMapper.selectRowsByKeyword(keyword);
		}
		// dictionary
		List<OptionsOut> extraCbTypeTrans = this.dicInfoService.getAllCityBuildTypeOptions();
		HashMap<String, String> cbTypeNameDict = new HashMap<>();
		for (OptionsOut opt : extraCbTypeTrans) {
			cbTypeNameDict.put(opt.getOptValue(), opt.getOptText());
		}
		// translate
		for(CbPlanPrjRow row : rows) {
			String[] areaIds = null != row.getExtraCbType() ? row.getExtraCbType().split(",") : new String[0];
			StringBuilder trans = new StringBuilder();
			for (String areaId : areaIds) {
				String areaName = cbTypeNameDict.get(areaId);
				if (null != areaName && !areaName.equalsIgnoreCase("")) {
					trans.append(areaName);
					trans.append(",");
				}
			}
			int actualLength = trans.length() > 0 ? trans.length() - 1 : trans.length();
			row.setExtraCbTypeTrans(trans.substring(0, actualLength)); // remove last char
		}
		return new PageInfo<>(rows);
	}

	@Override
	public List<OptionsOut> getPrjPlanIdNameOptions() {
		return this.cbPlanPrjMapper.selectPrjPlanIdNameOptions();
	}

	@Override
	public CbPlanPrj findById(Integer id) {
		return this.cbPlanPrjMapper.selectByPrimaryKey(id);
	}

	@Override
	public int insert(CbPlanPrj cbPlanPrj) {
		return this.cbPlanPrjMapper.insert(cbPlanPrj);
	}

	@Override
	public int update(CbPlanPrj cbPlanPrj) {
		return this.cbPlanPrjMapper.updateByPrimaryKey(cbPlanPrj);
	}

	@Override
	public String insertIncrementalWithResult(CbPlanPrj record) {
		Integer id = record.getId();
		boolean exist = null != this.cbPlanPrjMapper.selectByPrimaryKey(id);
		try {
			if (exist) {
				int change = this.cbPlanPrjMapper.updateByPrimaryKey(record);
				if (change > 0) {
					logger.info(String.format("更新成功！更改行数[%s] - 记录编号[%s] - 表[%s]。", change, id, TABLE_NAME_ENG));
				} else {
					logger.info(String.format("更新失败！更改行数[%s] - 记录编号[%s] - 表[%s]。", change, id, TABLE_NAME_ENG));
				}
			} else {
				int change = this.cbPlanPrjMapper.insert(record);
				if (change > 0) {
					logger.info(String.format("新增成功！更改行数[%s] - 记录编号[%s] - 表[%s]。", change, id, TABLE_NAME_ENG));
				} else {
					logger.info(String.format("新增失败！更改行数[%s] - 记录编号[%s] - 表[%s]。", change, id, TABLE_NAME_ENG));
				}
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
