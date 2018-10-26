package org.zxs.leader.control.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.zxs.leader.control.dao.interf.IPrjProveMapper;
import org.zxs.leader.control.dao.model.PrjProve;
import org.zxs.leader.control.dao.model.vo.output.PrjAttachmentOut;
import org.zxs.leader.control.dao.model.vo.output.PrjProveOut;
import org.zxs.leader.control.dao.model.vo.output.rows.PrjProveRow;
import org.zxs.leader.control.service.interf.IPrjProveService;
import org.zxs.leader.control.service.util.ExceptionMessageTranslator;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Service
public class PrjProveServiceImpl implements IPrjProveService {

	private static final Log logger = LogFactory.getLog(PrjProveServiceImpl.class);
	
	private static final String TABLE_NAME_ENG = "prj_prove";
	
	@Resource
	private IPrjProveMapper prjProveMapper;

	@Override
	public List<PrjProveOut> getByPrjId(int prjId, int prjType) {
		List<PrjProveOut> proveList = prjProveMapper.selectByPrjId(prjId, prjType);
		if(null != proveList && !proveList.isEmpty()) {
			for(PrjProveOut prvOut : proveList) {
				String ids = prvOut.getIds();
				if(null != ids && !ids.isEmpty()) { 
					List<PrjAttachmentOut> aList = prjProveMapper.selectAttamentMap(ids);
					prvOut.setAttamentList(aList);
				}
			}
		}
		return proveList;
	}

	@Override
	public PageInfo<PrjProveRow> getPrjProveOutsByPage(Integer pageNum, Integer pageSize, String keyword) {
		PageHelper.startPage(pageNum, pageSize);
		List<PrjProveRow> rows = null;
		if (null == keyword) {
			rows = this.prjProveMapper.selectAllOuts();
		} else {
			rows = this.prjProveMapper.selectRowsByKeyword(keyword);
		}
		return new PageInfo<>(rows);
	}

	@Override
	public PrjProve findById(Integer id) {
		return this.prjProveMapper.selectByPrimaryKey(id);
	}

	@Override
	public int insert(PrjProve prjProve) {
		return this.prjProveMapper.insert(prjProve);
	}

	@Override
	public int update(PrjProve prjProve) {
		return this.prjProveMapper.updateByPrimaryKey(prjProve);
	}

	@Override
	public String insertWithResult(PrjProve record) {
		Integer id = record.getId();
		try {
			int change = this.prjProveMapper.insert(record);
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
