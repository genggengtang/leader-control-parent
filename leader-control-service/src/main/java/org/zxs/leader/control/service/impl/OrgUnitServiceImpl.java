package org.zxs.leader.control.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.zxs.leader.control.dao.interf.IOrgUnitMapper;
import org.zxs.leader.control.dao.model.OrgUnit;
import org.zxs.leader.control.dao.model.vo.output.OptionsOut;
import org.zxs.leader.control.dao.model.vo.output.rows.OrgUnitRow;
import org.zxs.leader.control.service.interf.IOrgUnitService;
import org.zxs.leader.control.service.util.ExceptionMessageTranslator;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class OrgUnitServiceImpl implements IOrgUnitService {
	
	@Resource
	private IOrgUnitMapper orgUnitMapper;
	
	private static final Log logger = LogFactory.getLog(OrgUnitServiceImpl.class);
	
	private static final String TABLE_NAME_ENG = "org_unit";
	
	@Override
	public PageInfo<OrgUnit> getOrgUnitsByPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<OrgUnit> orgUnitList = this.orgUnitMapper.selectAll();
		return new PageInfo<>(orgUnitList);
	}
	
	@Override
	public PageInfo<OrgUnitRow> getOrgUnitOutsByPage(int pageNum, int pageSize, String keyword) {
		PageHelper.startPage(pageNum, pageSize);
		List<OrgUnitRow> rows = null;
		if (null == keyword) {
			rows = this.orgUnitMapper.selectAllRows();
		} else {
			rows = this.orgUnitMapper.selectRowsByKeyword(keyword);
		}
		return new PageInfo<>(rows);
	}
	
	@Override
	public List<OrgUnit> getAllOrgUnit() {
		return orgUnitMapper.selectAll();
	}

	@Override
	public int insertOrgUnit(OrgUnit orgUnit) {
		return this.orgUnitMapper.insert(orgUnit);
	}

	@Override
	public int updateOrgUnit(OrgUnit orgUnit) {
		return this.orgUnitMapper.updateByPrimaryKey(orgUnit);
	}

	@Override
	public OrgUnit findById(Integer id) {
		return this.orgUnitMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<OptionsOut> getAllOrgIdOptions() {
		return this.orgUnitMapper.getAllOrgIdOptions();
	}

	@Override
	public String insertWithResult(OrgUnit record) {
		Integer id = record.getId();
		try {
			int change = this.orgUnitMapper.insert(record);
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