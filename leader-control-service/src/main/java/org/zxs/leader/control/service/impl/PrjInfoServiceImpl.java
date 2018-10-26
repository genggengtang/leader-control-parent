package org.zxs.leader.control.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zxs.leader.control.dao.consts.IDicInfoConst;
import org.zxs.leader.control.dao.interf.IDicInfoMapper;
import org.zxs.leader.control.dao.interf.IDictHeaderMapper;
import org.zxs.leader.control.dao.interf.ILeaderGroupMapper;
import org.zxs.leader.control.dao.interf.IPrjAttachmentMapper;
import org.zxs.leader.control.dao.interf.IPrjInfoMapper;
import org.zxs.leader.control.dao.model.DicInfo;
import org.zxs.leader.control.dao.model.LdPrjView;
import org.zxs.leader.control.dao.model.PrjInfo;
import org.zxs.leader.control.dao.model.PrjInfoInsertResult;
import org.zxs.leader.control.dao.model.vo.output.OptionsOut;
import org.zxs.leader.control.dao.model.vo.output.PrcSearchOut;
import org.zxs.leader.control.dao.model.vo.output.PrjFullDetailOut;
import org.zxs.leader.control.dao.model.vo.output.PrjListInfoOut;
import org.zxs.leader.control.dao.model.vo.output.PrjMapOut;
import org.zxs.leader.control.dao.model.vo.output.PrjSimpleDetailOut;
import org.zxs.leader.control.dao.model.vo.output.PrjStaticsOut;
import org.zxs.leader.control.dao.model.vo.query.PrjCountQuery;
import org.zxs.leader.control.dao.model.vo.query.PrjDetailQuery;
import org.zxs.leader.control.dao.model.vo.query.PrjPageQuery;
import org.zxs.leader.control.dao.model.vo.query.PrjViewQuery;
import org.zxs.leader.control.service.interf.IPrjInfoService;
import org.zxs.leader.control.service.util.ExceptionMsgLocalizer;
import org.zxs.utils.CommonUtil;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class PrjInfoServiceImpl implements IPrjInfoService {

	@Resource
	private IPrjInfoMapper prjInfoMapper;
	
	@Resource
	private IPrjAttachmentMapper prjAttachmentMapper;
	
	@Resource
	private ILeaderGroupMapper lgMapper;
	
	@Resource
	private IDicInfoMapper dicMapper;
	
	@Resource
	private IDictHeaderMapper dictTableNameMapper;

	@Override
	public List<PrjListInfoOut> getAllInfo(PrjPageQuery query) {
		return prjInfoMapper.selectAllInfo(query);
	}

	@Override
	public PageInfo<PrjListInfoOut> getInfoByPage(PrjPageQuery query, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
        List<PrjListInfoOut> prgPageList = prjInfoMapper.selectAllInfo(query);
        return new PageInfo<>(prgPageList);
	}

	@Override
	public boolean isPrjRspLeader(int id, int userId) {
		PrjInfo pInfo = new PrjInfo();
		pInfo.setId(id);
		pInfo.setRspLeaderId(userId);
		return prjInfoMapper.selectCount(pInfo) == 1;
	}

	@Override
	public PrjFullDetailOut getFullInfoById(PrjDetailQuery query) {
		int season = CommonUtil.getSeason(new Date());
		query.setSeason(season);
		return prjInfoMapper.selectFullInfoById(query);
	}

	@Override
	public List<PrcSearchOut> getPrjByNameLike(String nameLike) {
		return prjInfoMapper.selectByNameLike(nameLike);
	}

	@Override
	public List<PrjStaticsOut> getStaticsByLeaderId(Integer leaderId) {
		if(null == leaderId)
			return prjInfoMapper.selectGroupStaticsByLeaderId(null);
		return prjInfoMapper.selectStaticsBySelf(leaderId);
	}

	@Override
	public List<PrjStaticsOut> getStaticsByFavorite(int userId) {
		return prjInfoMapper.selectStaticsByFavorite(userId);
	}

	@Override
	public boolean isPrjExist(int id) {
		PrjInfo pInfo = new PrjInfo();
		pInfo.setId(id);
		return prjInfoMapper.selectCount(pInfo) == 1;
	}

	@Override
	public int getPrjCount(PrjCountQuery query) {
		return prjInfoMapper.selectByPrjCount(query);
	}

	@Override
	public PrjStaticsOut getTotalStatics() {
		return prjInfoMapper.selectTotalStatics();
	}

	@Override
	public PrjSimpleDetailOut getInfoById(PrjDetailQuery query) {
		return prjInfoMapper.selectBaseInfoById(query);
	}

	@Override
	public PrjMapOut getMapInfoById(int id) {
		return prjInfoMapper.selectMapInfoById(id);
	}

	@Override
	public PageInfo<LdPrjView> getViewByPage(PrjViewQuery query, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
        List<LdPrjView> prgPageList = prjInfoMapper.selectPrjView(query);
		return new PageInfo<>(prgPageList);
	}

	@Override
	public PrjInfo getPrjById(int prjId) {
		return prjInfoMapper.selectByPrimaryKey(prjId);
	}

	@Override
	@Transactional
	public int updatePrjById(PrjInfo prj) {
		return prjInfoMapper.updateByPrimaryKeySelective(prj);
	}

	@Override
	public List<OptionsOut> getAllLeaderList() {
		return lgMapper.selectLeaderList();
	}

	@Override
	public List<OptionsOut> getAllIndustryList() {
		List<OptionsOut> optList = new ArrayList<>();
		DicInfo di = new DicInfo();
		di.setType(IDicInfoConst.TYPE_LD_INDUSTRY);
		List<DicInfo> dList = dicMapper.select(di);
		if(!dList.isEmpty()) {
			for(DicInfo d : dList) {
				OptionsOut opt = new OptionsOut();
				opt.setOptText(d.getValueRemark());
				opt.setOptValue(d.getId()+"");
				optList.add(opt);
			}
		}
		
		return optList;
	}

	@Override
	public List<OptionsOut> getAllBuildStatusList() {
		List<OptionsOut> optList = new ArrayList<>();
		DicInfo di = new DicInfo();
		di.setType(IDicInfoConst.TYPE_LD_BUILD_STATUS);
		List<DicInfo> dList = dicMapper.select(di);
		if(!dList.isEmpty()) {
			for(DicInfo d : dList) {
				OptionsOut opt = new OptionsOut();
				opt.setOptText(d.getValueRemark());
				opt.setOptValue(d.getId()+"");
				optList.add(opt);
			}
		}
		return optList;
	}

	@Override
	@Transactional
	public int createPrjInfo(PrjInfo prjInfo) {
		return prjInfoMapper.insert(prjInfo);
	}
	
	@Override
	public List<PrjInfo> getAllPrjInfo() {
		return prjInfoMapper.selectAll();
	}
	
	@Override
	public List<PrjInfo> getAllPrjInfoSoft() {
		return prjInfoMapper.selectAllSoft();
	}

	@Override
	@Transactional
	public PrjInfoInsertResult insertBatchIncremental(List<PrjInfo> table) {
		PrjInfoInsertResult result = new PrjInfoInsertResult();
		result.setTotalNumRows(table.size());
		int rowAffected = 0;
		int currRow = 0;
		for (PrjInfo prjInfo : table) {
			currRow ++;
			try {
				if (this.prjInfoMapper.insertIncremental(prjInfo) != 0) {
					rowAffected ++;
				}
			} catch (DataIntegrityViolationException e) {
				String localizedMsg = ExceptionMsgLocalizer.translate(e.getCause().getMessage());
				result.addException(localizedMsg); // exception
				result.addErrorPrjInfo(prjInfo); // prjInfo not inserted
				result.addErrorRowNums(currRow); // line number
			}
		}
		result.setRowAffected(rowAffected / 2);
		result.setErrorRows(result.getErrorPrjInfoList().size());
		if (result.getErrorPrjInfoList().size() == 0) {
			result.setResultType(PrjInfoInsertResult.FULLY);
		} else if (result.getErrorPrjInfoList().size() == table.size()) {
			result.setResultType(PrjInfoInsertResult.NONE);
		} else {
			result.setResultType(PrjInfoInsertResult.PARTIALLY);
		}
		return result;
	}

	@Override
	@Transactional
	public int insertIncremental(PrjInfo prjInfo) {
		return this.prjInfoMapper.insertIncremental(prjInfo);
	}

	@Override
	public int deleteById(int id) {
		// soft delete
		return this.prjInfoMapper.deleteByIdSoft(id);
	}

	@Override
	public int deleteByIdList(List<Integer> idList) {
		// batch soft delete
		return this.prjInfoMapper.deleteByIdListSoft(idList);
	}

	@Override
	public List<OptionsOut> getAllPrjInfoOptions() {
		return this.prjInfoMapper.selectAllPrjInfoOptions();
	}
	
}
