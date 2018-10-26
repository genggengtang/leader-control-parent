package org.zxs.leader.control.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.zxs.leader.control.dao.consts.IDicInfoConst;
import org.zxs.leader.control.dao.interf.IDicInfoMapper;
import org.zxs.leader.control.dao.interf.IPrjIssueMapper;
import org.zxs.leader.control.dao.model.PrjIssue;
import org.zxs.leader.control.dao.model.vo.output.OptionsOut;
import org.zxs.leader.control.dao.model.vo.output.PrjIssueOut;
import org.zxs.leader.control.dao.model.vo.output.PrjMonthIssueOut;
import org.zxs.leader.control.dao.model.vo.output.PrjYearIssueOut;
import org.zxs.leader.control.dao.model.vo.output.rows.PrjIssueRow;
import org.zxs.leader.control.service.interf.IPrjIssueService;
import org.zxs.leader.control.service.util.ExceptionMessageTranslator;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Service
public class PrjIssueServiceImpl implements IPrjIssueService {

	private static final Log logger = LogFactory.getLog(PrjIssueServiceImpl.class);
	
	private static final String TABLE_NAME_ENG = "prj_issue";
	
	@Resource
	private IPrjIssueMapper prjIssueMapper;
	
	@Resource
	private IDicInfoMapper dicInfoMapper;

	@Override
	public List<PrjYearIssueOut> getIssueByPrjIdAndType(int prjId, int prjType) {
		List<PrjYearIssueOut> retList = new ArrayList<>();
		
		List<Integer> yearList = prjIssueMapper.selectIssueYear(prjId, prjType);
		if(yearList.isEmpty())
			return retList;
		for(Integer year : yearList) {
			PrjYearIssueOut yearOut = new PrjYearIssueOut();
			yearOut.setYear(year);
			List<Integer> monthList = prjIssueMapper.selectIssueMonth(prjId, prjType, year);
			
			List<PrjMonthIssueOut> monthIssueOutList = new ArrayList<>();
			
			for(Integer month : monthList) {
				PrjMonthIssueOut monthIssueOut = new PrjMonthIssueOut();
				monthIssueOut.setMonth(month);
				monthIssueOut.setIssueMonthList(prjIssueMapper.selectByPrjId(prjId, prjType, year, month));
				monthIssueOutList.add(monthIssueOut);
			}
			yearOut.setIssueYearList(monthIssueOutList);
			retList.add(yearOut);
		}
		
		return retList;
	}

	@Override
	public PrjIssueOut getIssueById(int id) {
		return prjIssueMapper.selectIssueById(id);
	}

	@Override
	public PageInfo<PrjIssueRow> getPrjIssueOutsByPage(Integer pageNum, Integer pageSize, String keyword) {
		PageHelper.startPage(pageNum, pageSize);
		List<PrjIssueRow> rows = null;
		if (null == keyword) {
			rows = this.prjIssueMapper.selectAllOuts();
		} else {
			rows = this.prjIssueMapper.selectRowsByKeyword(keyword);
		}
		// dictionary
		List<OptionsOut> opts = this.dicInfoMapper.selectOptionsByType(IDicInfoConst.TYPE_QUESTION_TYPE); // 问题类型
		HashMap<String, String> issueTypeDict = new HashMap<>();
		for (OptionsOut opt : opts) {
			issueTypeDict.put(opt.getOptValue(), opt.getOptText());
		}
		// iteratively update list elements
		for (PrjIssueRow row : rows) {
			String[] types = null != row.getType() ? row.getType().split(",") : new String[0];
			StringBuilder trans = new StringBuilder();
			for (String type : types) {
				String typeName = issueTypeDict.get(type);
				if (null != typeName && !typeName.equalsIgnoreCase("")) {
					trans.append(typeName);
					trans.append(",");
				}
			}
			int actualLength = trans.length() > 0 ? trans.length() - 1 : trans.length();
			row.setTypeTrans(trans.substring(0, actualLength)); // remove last char
		}
		return new PageInfo<>(rows);
	}

	@Override
	public PrjIssue findById(Integer id) {
		return this.prjIssueMapper.selectByPrimaryKey(id);
	}

	@Override
	public int insert(PrjIssue prjIssue) {
		return this.prjIssueMapper.insert(prjIssue);
	}

	@Override
	public int update(PrjIssue prjIssue) {
		return this.prjIssueMapper.updateByPrimaryKey(prjIssue);
	}

	@Override
	public String insertWithResult(PrjIssue record) {
		Integer id = record.getId();
		try {
			int change = this.prjIssueMapper.insert(record);
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
