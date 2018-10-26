package org.zxs.leader.control.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.zxs.leader.control.dao.interf.IDictHeaderMapper;
import org.zxs.leader.control.dao.interf.IPrjPointMapper;
import org.zxs.leader.control.dao.model.PrjPoint;
import org.zxs.leader.control.dao.model.vo.output.rows.PrjPointRow;
import org.zxs.leader.control.service.interf.IPrjPointService;
import org.zxs.leader.control.service.util.ExceptionMessageTranslator;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class PrjPointServiceImpl implements IPrjPointService {
	
	private static final Log logger = LogFactory.getLog(PrjPointServiceImpl.class);
	
	private static final String TABLE_NAME_ENG = "prj_point";
	
	@Resource
	private IPrjPointMapper prjPointMapper;
	
	@Resource
	private IDictHeaderMapper dictHeaderMapper;
	
	@Override
	public PageInfo<PrjPointRow> getPrjPointOutsByPage(Integer pageNum, Integer pageSize, String keyword) {
		PageHelper.startPage(pageNum, pageSize);
		List<PrjPointRow> rows = null; 
		if (null == keyword) {
			rows = this.prjPointMapper.selectAllRows();
		} else {
			rows = this.prjPointMapper.selectRowsByKeyword(keyword);
		}
		return new PageInfo<>(rows);
	}

	@Override
	public PrjPoint findById(Long id) {
		return this.prjPointMapper.selectByPrimaryKey(id);
	}

	@Override
	public int insert(PrjPoint prjPoint) {
		return this.prjPointMapper.insert(prjPoint);
	}

	@Override
	public int update(PrjPoint prjPoint) {
		return this.prjPointMapper.updateByPrimaryKey(prjPoint);
	}

	@Override
	public String insertWithResult(PrjPoint record) {
		Long recordId = record.getId();
		try {
			int change = this.prjPointMapper.insert(record);
			if (change > 0) {
				logger.info(String.format("新增成功！更改行数[%s]，记录Id[%s]，表[%s]。", change, recordId, TABLE_NAME_ENG));
			} else {
				logger.info(String.format("新增失败！更改行数[%s]，记录Id[%s]，表[%s]。", change, recordId, TABLE_NAME_ENG));
			}
		} catch (DuplicateKeyException e) {
			logger.info(String.format("新增失败！ID为[%s]在[%s]中已经存在。", recordId, TABLE_NAME_ENG));
			return String.format("新增失败！ID为[%s]的记录在[%s]中已经存在。", recordId, TABLE_NAME_ENG);
		} catch (DataIntegrityViolationException e) {
			String message = e.getRootCause().getMessage();
			String transMsg = ExceptionMessageTranslator.translate(message);
			logger.info(String.format("新增失败！ID为[%s]在[%s]表违反了数据库完整性：%s。", recordId, TABLE_NAME_ENG, transMsg));
			return String.format("新增失败！ID为[%s]的记录在插入时违反完整性：%s，请检查该字段的数据类型！", recordId, transMsg);
		}
		return null;
	}

}
