package org.zxs.leader.control.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.zxs.leader.control.dao.interf.IPrjMapLineMapper;
import org.zxs.leader.control.dao.model.PrjMapLine;
import org.zxs.leader.control.dao.model.vo.output.OptionsOut;
import org.zxs.leader.control.dao.model.vo.output.rows.PrjMapLineRow;
import org.zxs.leader.control.service.interf.IPrjMapLineService;
import org.zxs.leader.control.service.util.ExceptionMessageTranslator;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class PrjMapLineServiceImpl implements IPrjMapLineService{
	
	private static final Log logger = LogFactory.getLog(PrjMapLineServiceImpl.class);
	
	private static final String TABLE_NAME_ENG = "prj_map_line";
	
	@Resource
	private IPrjMapLineMapper prjMapLineMapper;

	@Override
	public PageInfo<PrjMapLineRow> getPrjMapLineOutsByPage(Integer pageNum, Integer pageSize, String keyword) {
		PageHelper.startPage(pageNum, pageSize);
		List<PrjMapLineRow> rows = null;
		if (null == keyword) {
			rows = this.prjMapLineMapper.selectAllOuts();
		} else {
			rows = this.prjMapLineMapper.selectRowsByKeyword(keyword);
		}
		return new PageInfo<>(rows);
	}

	@Override
	public PrjMapLine findById(Integer id) {
		return this.prjMapLineMapper.selectByPrimaryKey(id);
	}

	@Override
	public int insert(PrjMapLine prjMapLine) {
		return this.prjMapLineMapper.insert(prjMapLine);
	}

	@Override
	public int update(PrjMapLine prjMapLine) {
		return this.prjMapLineMapper.updateByPrimaryKey(prjMapLine);
	}

	@Override
	public List<OptionsOut> getOptions() {
		return this.prjMapLineMapper.selectOptions();
	}

	@Override
	public String insertWithResult(PrjMapLine record) {
		Integer id = record.getId();
		try {
			int change = this.prjMapLineMapper.insert(record);
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
