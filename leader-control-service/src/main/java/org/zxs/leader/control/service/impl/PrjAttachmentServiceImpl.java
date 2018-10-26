package org.zxs.leader.control.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.zxs.leader.control.dao.interf.IPrjAttachmentMapper;
import org.zxs.leader.control.dao.model.PrjAttachment;
import org.zxs.leader.control.dao.model.vo.output.rows.PrjAttachmentRow;
import org.zxs.leader.control.service.interf.IPrjAttachmentService;
import org.zxs.leader.control.service.util.ExceptionMessageTranslator;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class PrjAttachmentServiceImpl implements IPrjAttachmentService {

	private static final Log logger = LogFactory.getLog(PrjAttachmentServiceImpl.class);
	
	private static final String TABLE_NAME_ENG = "prj_attachment";
	
	@Resource
	private IPrjAttachmentMapper prjAttachmentMapper;
	
	@Override
	public PageInfo<PrjAttachmentRow> getPrjAttachmentOutsByPage(Integer pageNum, Integer pageSize, String keyword) {
		PageHelper.startPage(pageNum, pageSize);
		List<PrjAttachmentRow> rows = null;
		if (null == keyword) {
			rows = this.prjAttachmentMapper.selectAllOuts();
		} else {
			rows = this.prjAttachmentMapper.selectRowsByKeyword(keyword);
		}
		return new PageInfo<>(rows);
	}

	@Override
	public PrjAttachment findById(Integer id) {
		return this.prjAttachmentMapper.selectByPrimaryKey(id);
	}

	@Override
	public int insert(PrjAttachment prjAttachment) {
		return this.prjAttachmentMapper.insert(prjAttachment);
	}

	@Override
	public int update(PrjAttachment prjAttachment) {
		return this.prjAttachmentMapper.updateByPrimaryKey(prjAttachment);
	}

	@Override
	public String insertWithResult(PrjAttachment record) {
		Integer id = record.getId();
		try {
			int change = this.prjAttachmentMapper.insert(record);
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
