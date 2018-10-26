package org.zxs.leader.control.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.zxs.leader.control.dao.interf.IPrjMonthPlanMapper;
import org.zxs.leader.control.dao.interf.IPrjYearPlanMapper;
import org.zxs.leader.control.dao.model.PrjYearPlan;
import org.zxs.leader.control.dao.model.vo.output.PrjYearPrgOut;
import org.zxs.leader.control.dao.model.vo.output.rows.PrjYearPlanRow;
import org.zxs.leader.control.service.interf.IPrjYearPlanService;
import org.zxs.leader.control.service.util.ExceptionMessageTranslator;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Service
public class PrjYearPlanServiceImpl implements IPrjYearPlanService {

	private static final Log logger = LogFactory.getLog(PrjYearPlanServiceImpl.class);
	
	private static final String TABLE_NAME_ENG = "prj_year_plan";
	
	@Resource
	private IPrjYearPlanMapper prjYearPlanMapper;
	
	@Resource
	private IPrjMonthPlanMapper prjMonthPlanMapper;

	@Override
	public List<PrjYearPrgOut> getYearInfoByPrjId(int prjId, int prjType, String baseUrl) {
		List<PrjYearPrgOut> retList = new ArrayList<>();
		List<PrjYearPlan> yearList = prjYearPlanMapper.selectYearListByPrj(prjId, prjType);
		if(yearList.isEmpty())
			return retList;
		for(PrjYearPlan yPlan : yearList) {
			PrjYearPrgOut yearOut = new PrjYearPrgOut();
			yearOut.setYearId(yPlan.getId());
			yearOut.setYear(yPlan.getYear().intValue());
			yearOut.setMonthList(prjMonthPlanMapper.selectByYearId(yPlan.getId(), baseUrl));
			retList.add(yearOut);
		}
		return retList;
	}

	@Override
	public PrjYearPlan getYearInfoById(int id) {
		return prjYearPlanMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<PrjYearPlanRow> getPrjYearPlanRowsByPageAndKeyword(Integer pageNum, Integer pageSize, String keyword) {
		PageHelper.startPage(pageNum, pageSize);
		List<PrjYearPlanRow> rows = null;
		if (null == keyword) {
			rows = this.prjYearPlanMapper.selectAllSoft();
		} else {
			rows = this.prjYearPlanMapper.selectRowsByKeyword(keyword);
		}
		return new PageInfo<>(rows);
	}

	@Override
	public PrjYearPlan findById(Integer id) {
		return this.prjYearPlanMapper.selectByPrimaryKey(id);
	}

	@Override
	public int insert(PrjYearPlan prjYearPlan) {
		return this.prjYearPlanMapper.insert(prjYearPlan);
	}

	@Override
	public int update(PrjYearPlan prjYearPlan) {
		return this.prjYearPlanMapper.updateByPrimaryKey(prjYearPlan);
	}

	@Override
	public String insertIncrementalWithResult(PrjYearPlan record) {
		Integer id = record.getId();
		boolean exist = null != this.prjYearPlanMapper.selectByPrimaryKey(id);
		try {
			if (exist) {
				int change = this.prjYearPlanMapper.updateByPrimaryKey(record);
				if (change > 0) {
					logger.info(String.format("更新成功！更改行数[%s] - 记录编号[%s] - 表[%s]。", change, id, TABLE_NAME_ENG));
				} else {
					logger.info(String.format("更新失败！更改行数[%s] - 记录编号[%s] - 表[%s]。", change, id, TABLE_NAME_ENG));
				}
			} else {
				int change = this.prjYearPlanMapper.insert(record);
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