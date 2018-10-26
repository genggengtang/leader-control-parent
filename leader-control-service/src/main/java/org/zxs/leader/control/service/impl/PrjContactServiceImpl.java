package org.zxs.leader.control.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.zxs.leader.control.dao.interf.IPrjContactMapper;
import org.zxs.leader.control.dao.model.PrjContact;
import org.zxs.leader.control.dao.model.vo.output.PrcSearchOut;
import org.zxs.leader.control.dao.model.vo.output.PrjContactOut;
import org.zxs.leader.control.dao.model.vo.output.rows.PrjContactRow;
import org.zxs.leader.control.service.interf.IPrjContactService;
import org.zxs.leader.control.service.util.ExceptionMessageTranslator;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Service
public class PrjContactServiceImpl implements IPrjContactService {

	private static final Log logger = LogFactory.getLog(PrjContactServiceImpl.class);
	
	private static final String TABLE_NAME_ENG = "prj_contact";
	
	@Resource
	private IPrjContactMapper prjContactMapper;

	@Override
	public List<PrjContactOut> getContactByPrjIdAndType(PrjContact prjContact, int userLevel) {
		return prjContactMapper.selectByPrjIdAndType(prjContact, userLevel);
	}

	@Override
	public List<PrcSearchOut> getPrjOwnerByNameLike(String nameLike) {
		return prjContactMapper.selectByNameLike(nameLike);
	}

	@Override
	public boolean isUserRelateLdprj(int userId, int prjId) {
		return prjContactMapper.selectCountByUser(userId, prjId) > 0;
	}

	@Override
	public PageInfo<PrjContactRow> getPrjContactOutsByPage(Integer pageNum, Integer pageSize, String keyword) {
		PageHelper.startPage(pageNum, pageSize);
		List<PrjContactRow> rows = null;
		if (null == keyword) {
			rows = this.prjContactMapper.selectAllOuts();
		} else {
			rows = this.prjContactMapper.selectRowsByKeyword(keyword);
		}
		return new PageInfo<>(rows);
	}

	@Override
	public PrjContact findById(Integer id) {
		return this.prjContactMapper.selectByPrimaryKey(id);
	}

	@Override
	public int insert(PrjContact prjContact) {
		return this.prjContactMapper.insert(prjContact);
	}

	@Override
	public int update(PrjContact prjContact) {
		return this.prjContactMapper.updateByPrimaryKey(prjContact);
	}

	@Override
	public String insertWithResult(PrjContact record) {
		Integer id = record.getId();
		try {
			int change = this.prjContactMapper.insert(record);
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
			String integrityExcepMsg = String.format("新增失败！编号为[%s]的记录在插入[%s]表时违反完整性：%s，请检查该字段的数据类型！", id, TABLE_NAME_ENG, transMsg);;
			logger.info(integrityExcepMsg);
			return integrityExcepMsg;
		}
		return null;
	}

}
