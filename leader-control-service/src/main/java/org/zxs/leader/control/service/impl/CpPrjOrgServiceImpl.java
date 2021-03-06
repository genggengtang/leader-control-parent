package org.zxs.leader.control.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.zxs.leader.control.dao.interf.ICpPrjOrgMapper;
import org.zxs.leader.control.dao.model.CpPrjOrg;
import org.zxs.leader.control.dao.model.vo.output.rows.CpPrjOrgRow;
import org.zxs.leader.control.service.interf.ICpPrjOrgService;
import org.zxs.leader.control.service.util.ExceptionMessageTranslator;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class CpPrjOrgServiceImpl implements  ICpPrjOrgService {
	
	private static final Log logger = LogFactory.getLog(CpPrjOrgServiceImpl.class);
	
	private static final String TABLE_NAME_ENG = "cp_prj_org";
	
	@Resource
	private ICpPrjOrgMapper cpPrjOrgMapper;

	@Override
	public PageInfo<CpPrjOrgRow> getCpPrjOrgOutsByPage(Integer pageNum, Integer pageSize, String keyword) {
		PageHelper.startPage(pageNum, pageSize);
		List<CpPrjOrgRow> rows = null;
		if (null == keyword) {
			rows = this.cpPrjOrgMapper.selectAllOuts();
		} else {
			rows = this.cpPrjOrgMapper.selectRowsByKeyword(keyword);
		}
		return new PageInfo<>(rows);
	}

	@Override
	public CpPrjOrg findById(Integer id) {
		return this.cpPrjOrgMapper.selectByPrimaryKey(id);
	}

	@Override
	public int insert(CpPrjOrg cpPrjOrg) {
		return this.cpPrjOrgMapper.insert(cpPrjOrg);
	}

	@Override
	public int update(CpPrjOrg cpPrjOrg) {
		return this.cpPrjOrgMapper.updateByPrimaryKey(cpPrjOrg);
	}

	@Override
	public String insertIncrementalWithResult(CpPrjOrg record) {
		Integer id = record.getId();
		boolean exist = null != this.cpPrjOrgMapper.selectByPrimaryKey(id);
		try {
			if (exist) {
				int change = this.cpPrjOrgMapper.updateByPrimaryKey(record);
				if (change > 0) {
					logger.info(String.format("更新成功！更改行数[%s] - 记录编号[%s] - 表[%s]。", change, id, TABLE_NAME_ENG));
				} else {
					logger.info(String.format("更新失败！更改行数[%s] - 记录编号[%s] - 表[%s]。", change, id, TABLE_NAME_ENG));
				}
			} else {
				int change = this.cpPrjOrgMapper.insert(record);
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
