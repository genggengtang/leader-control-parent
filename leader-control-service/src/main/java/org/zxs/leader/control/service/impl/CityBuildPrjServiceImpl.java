package org.zxs.leader.control.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.zxs.leader.control.dao.interf.ICityBuildPrjMapper;
import org.zxs.leader.control.dao.model.CityBuildPrj;
import org.zxs.leader.control.dao.model.vo.output.rows.CityBuildPrjRow;
import org.zxs.leader.control.service.interf.ICityBuildPrjService;
import org.zxs.leader.control.service.util.ExceptionMessageTranslator;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class CityBuildPrjServiceImpl implements ICityBuildPrjService{

	private static final Log logger = LogFactory.getLog(CityBuildPrjServiceImpl.class);
	
	private static final String TABLE_NAME_ENG = "city_build_prj";
	
	@Resource
	private ICityBuildPrjMapper cityBuildPrjMapper;
	
	@Override
	public PageInfo<CityBuildPrjRow> getCityBuildPrjRowsByPage(Integer pageNum, Integer pageSize, String keyword) {
		PageHelper.startPage(pageNum, pageSize);
		List<CityBuildPrjRow> rows = null;
		if (null == keyword) {
			rows = this.cityBuildPrjMapper.selectAllOuts();
		} else {
			rows = this.cityBuildPrjMapper.selectRowsByKeyword(keyword);
		}
		return new PageInfo<>(rows);
	}

	@Override
	public CityBuildPrj findById(Integer id) {
		return this.cityBuildPrjMapper.selectByPrimaryKey(id);
	}

	@Override
	public int insert(CityBuildPrj cityBuildPrj) {
		return this.cityBuildPrjMapper.insert(cityBuildPrj);
	}

	@Override
	public int update(CityBuildPrj cityBuildPrj) {
		return this.cityBuildPrjMapper.updateByPrimaryKey(cityBuildPrj);
	}

	@Override
	public String insertIncrementalWithResult(CityBuildPrj record) {
		Integer id = record.getId();
		boolean exist = null != this.cityBuildPrjMapper.selectByPrimaryKey(id);
		try {
			if (exist) {
				int change = this.cityBuildPrjMapper.updateByPrimaryKey(record);
				if (change > 0) {
					logger.info(String.format("更新成功！更改行数[%s] - 记录编号[%s] - 表[%s]。", change, id, TABLE_NAME_ENG));
				} else {
					logger.info(String.format("更新失败！更改行数[%s] - 记录编号[%s] - 表[%s]。", change, id, TABLE_NAME_ENG));
				}
			} else {
				int change = this.cityBuildPrjMapper.insert(record);
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
