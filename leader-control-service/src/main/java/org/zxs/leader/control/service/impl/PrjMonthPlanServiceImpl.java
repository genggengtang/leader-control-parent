package org.zxs.leader.control.service.impl;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zxs.leader.control.dao.interf.IPrjMonthPlanMapper;
import org.zxs.leader.control.dao.interf.IPrjYearPlanMapper;
import org.zxs.leader.control.dao.model.PrjMonthPlan;
import org.zxs.leader.control.dao.model.PrjYearPlan;
import org.zxs.leader.control.dao.model.vo.output.OptionsOut;
import org.zxs.leader.control.dao.model.vo.output.PrjMonthReportOut;
import org.zxs.leader.control.dao.model.vo.output.PrjMonthSimpleOut;
import org.zxs.leader.control.dao.model.vo.output.rows.PrjMonthPlanRow;
import org.zxs.leader.control.dao.model.vo.query.MonthReportQuery;
import org.zxs.leader.control.service.interf.IPrjMonthPlanService;
import org.zxs.leader.control.service.util.ExceptionMessageTranslator;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Service
public class PrjMonthPlanServiceImpl implements IPrjMonthPlanService {

	private static final Log logger = LogFactory.getLog(PrjMonthPlanServiceImpl.class);
	
	private static final String TABLE_NAME_ENG = "prj_month_plan";
	
	@Resource
	private IPrjMonthPlanMapper prjMonthPlanMapper;
	
	@Resource
	private IPrjYearPlanMapper prjYearPlanMapper;

	@Override
	public List<PrjMonthSimpleOut> getMonthReportByPrjIdAndYear(int prjId, int prjType, Integer year) {
		return prjMonthPlanMapper.selectByPrjIdAndYear(prjId, prjType, year);
	}

	@Override
	public Map<Integer, List<PrjMonthSimpleOut>> getMonthReportByPrjId(int prjId, int prjType) {
		Map<Integer, List<PrjMonthSimpleOut>> retMap = new TreeMap<>();
		PrjYearPlan yearPlan = new PrjYearPlan();
		yearPlan.setPrjType(prjType);
		yearPlan.setPrjId(prjId);
		List<PrjYearPlan> yearList = prjYearPlanMapper.select(yearPlan);
		if(yearList.isEmpty())
			return retMap;
		for(PrjYearPlan yPlan : yearList) {
			int year = yPlan.getYear();
			int yearId = yPlan.getId();
			List<PrjMonthSimpleOut> monthList = prjMonthPlanMapper.selectSimpleByYearId(yearId);
			retMap.put(year, monthList);
		}
		return retMap;
	}

	@Override
	public PrjMonthPlan getMonthPlan(int prjType, int prjId, int year, int month) {
		PrjYearPlan yearPlan = new PrjYearPlan();
		yearPlan.setPrjType(prjType);
		yearPlan.setPrjId(prjId);
		yearPlan.setYear((short) year);
		PrjYearPlan yPlan = prjYearPlanMapper.selectOne(yearPlan);
		if(null != yPlan) {
			PrjMonthPlan mPlan = new PrjMonthPlan();
			mPlan.setMonth((byte) month);
			mPlan.setYearId(yPlan.getId());
			return prjMonthPlanMapper.selectOne(mPlan);
		}
		return null;
	}

	@Override
	@Transactional
	public int updateMonthPlan(PrjMonthPlan monthPlan) {
		return prjMonthPlanMapper.updateByPrimaryKeySelective(monthPlan);
	}

	@Override
	public PrjMonthPlan getMonthPlanById(int id) {
		return prjMonthPlanMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<PrjMonthReportOut> getMonthInfoByPage(Integer pageNum, Integer pageSize, MonthReportQuery query) {
		PageHelper.startPage(pageNum, pageSize);
		List<PrjMonthReportOut> monthPageList = prjMonthPlanMapper.selectListInfo(query);
		return new PageInfo<>(monthPageList);
	}

	@Override
	@Transactional
	public int saveMonthPlan(PrjMonthPlan monthPlan) {
		return prjMonthPlanMapper.insertSelective(monthPlan);
	}

	@Override
	public List<PrjMonthPlan> getPicNameList() {
		return prjMonthPlanMapper.selectPicNameList();
	}

	@Override
	public PageInfo<PrjMonthPlanRow> getPrjMonthPlanOutsByPage(Integer pageNum, Integer pageSize, String keyword) {
		PageHelper.startPage(pageNum, pageSize);
		List<PrjMonthPlanRow> rows = null;
		if (null == keyword) {
			rows = this.prjMonthPlanMapper.selectAllSoft();
		} else {
			rows = this.prjMonthPlanMapper.selectRowsByKeyword(keyword);
		}
		return new PageInfo<>(rows);
	}

	@Override
	public List<OptionsOut> getYearIdOptions() {
		return this.prjMonthPlanMapper.selectYearIdOptions();
	}

	@Override
	public PrjMonthPlan findById(Integer id) {
		return this.prjMonthPlanMapper.selectByPrimaryKey(id);
	}

	@Override
	public int insert(PrjMonthPlan prjMonthPlan) {
		return this.prjMonthPlanMapper.insert(prjMonthPlan);
	}

	@Override
	public int update(PrjMonthPlan prjMonthPlan) {
		return this.prjMonthPlanMapper.updateByPrimaryKey(prjMonthPlan);
	}

	@Override
	public String insertIncrementalWithResult(PrjMonthPlan record) {
		Integer id = record.getId();
		boolean exist = null != this.prjMonthPlanMapper.selectByPrimaryKey(id);
		try {
			if (exist) {
				int change = this.prjMonthPlanMapper.updateByPrimaryKey(record);
				if (change > 0) {
					logger.info(String.format("更新成功！更改行数[%s] - 记录编号[%s] - 表[%s]。", change, id, TABLE_NAME_ENG));
				} else {
					logger.info(String.format("更新失败！更改行数[%s] - 记录编号[%s] - 表[%s]。", change, id, TABLE_NAME_ENG));
				}
			} else {
				int change = this.prjMonthPlanMapper.insert(record);
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
