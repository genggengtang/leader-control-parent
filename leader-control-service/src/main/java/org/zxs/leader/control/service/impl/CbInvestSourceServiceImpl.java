package org.zxs.leader.control.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.zxs.leader.control.dao.interf.ICbInvestSourceMapper;
import org.zxs.leader.control.dao.model.CbInvestSource;
import org.zxs.leader.control.dao.model.vo.output.rows.CbInvestSourceRow;
import org.zxs.leader.control.service.interf.ICbInvestSourceService;
import org.zxs.leader.control.service.util.ExceptionMessageTranslator;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class CbInvestSourceServiceImpl implements ICbInvestSourceService {
	
	private static final Log logger = LogFactory.getLog(CbInvestSourceServiceImpl.class);
	
	private static final String TABLE_NAME_ENG = "cb_invest_source";
	
	@Resource
	private ICbInvestSourceMapper cbInvestSourceMapper;

	@Override
	public PageInfo<CbInvestSourceRow> getCbInvestSourceOutsByPage(Integer pageNum, Integer pageSize, String keyword) {
		PageHelper.startPage(pageNum, pageSize);
		List<CbInvestSourceRow> rows = null;
		if (null == keyword) {
			rows = this.cbInvestSourceMapper.selectAllOuts();
		} else {
			rows = this.cbInvestSourceMapper.selectRowsByKeyword(keyword);
		}
		return new PageInfo<>(rows);
	}

	@Override
	public CbInvestSource findById(Integer id) {
		return this.cbInvestSourceMapper.selectByPrimaryKey(id);
	}

	@Override
	public int insert(CbInvestSource cbInvestSource) {
		return this.cbInvestSourceMapper.insert(cbInvestSource);
	}

	@Override
	public int update(CbInvestSource cbInvestSource) {
		return this.cbInvestSourceMapper.updateByPrimaryKey(cbInvestSource);
	}

	@Override
	public String insertIncrementalWithResult(CbInvestSource record) {
		Integer id = record.getId();
		boolean exist = null != this.cbInvestSourceMapper.selectByPrimaryKey(id);
		try {
			if (exist) {
				int change = this.cbInvestSourceMapper.updateByPrimaryKey(record);
				if (change > 0) {
					logger.info(String.format("更新成功！更改行数[%s] - 记录编号[%s] - 表[%s]。", change, id, TABLE_NAME_ENG));
				} else {
					logger.info(String.format("更新失败！更改行数[%s] - 记录编号[%s] - 表[%s]。", change, id, TABLE_NAME_ENG));
				}
			} else {
				int change = this.cbInvestSourceMapper.insert(record);
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
