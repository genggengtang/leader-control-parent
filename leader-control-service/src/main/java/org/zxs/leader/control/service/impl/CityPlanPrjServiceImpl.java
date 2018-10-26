package org.zxs.leader.control.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zxs.leader.control.dao.interf.IAreaNnMapper;
import org.zxs.leader.control.dao.interf.ICityPlanPrjMapper;
import org.zxs.leader.control.dao.model.CityPlanPrj;
import org.zxs.leader.control.dao.model.vo.output.CpPrjDetailOut;
import org.zxs.leader.control.dao.model.vo.output.CpPrjPageOut;
import org.zxs.leader.control.dao.model.vo.output.OptionsOut;
import org.zxs.leader.control.dao.model.vo.output.rows.CityPlanPrjRow;
import org.zxs.leader.control.dao.model.vo.query.CpPrjPageQuery;
import org.zxs.leader.control.service.interf.ICityPlanPrjService;
import org.zxs.leader.control.service.util.ExceptionMessageTranslator;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Service
public class CityPlanPrjServiceImpl implements ICityPlanPrjService {

	private static final Log logger = LogFactory.getLog(CityPlanPrjServiceImpl.class);
	
	private static final String TABLE_NAME_ENG = "city_plan_prj";
	
	@Resource
	private ICityPlanPrjMapper cityPlanPrjMapper;
	
	@Resource
	private IAreaNnMapper areaNnMapper;

	@Override
	public PageInfo<CpPrjPageOut> getInfoByPage(Integer pageNum, Integer pageSize, CpPrjPageQuery query) {
		PageHelper.startPage(pageNum, pageSize);
        List<CpPrjPageOut> prgPageList = cityPlanPrjMapper.selectListInfo(query);
        return new PageInfo<>(prgPageList);
	}

	@Override
	public CpPrjDetailOut getDetailById(int id) {
		return cityPlanPrjMapper.selectDetailById(id);
	}

	@Override
	public List<CityPlanPrj> getAllByPrjDb() {
		CityPlanPrj cpPrj = new CityPlanPrj();
		cpPrj.setIsPrjDb((byte) 1);
		return cityPlanPrjMapper.select(cpPrj);
	}

	@Override
	@Transactional
	public int updateCityPlanPrj(CityPlanPrj cpPrj) {
		return cityPlanPrjMapper.updateByPrimaryKeySelective(cpPrj);
	}

	@Override
	public PageInfo<CityPlanPrjRow> getCityPlanPrjRowsByPage(Integer pageNum, Integer pageSize, String keyword) {
		PageHelper.startPage(pageNum, pageSize);
		List<CityPlanPrjRow> rows = null;
		if (null == keyword) {
			rows = this.cityPlanPrjMapper.selectAllOuts();
		} else {
			rows = this.cityPlanPrjMapper.selectRowsByKeyword(keyword);
		}
		// dictionary
		List<OptionsOut> opts = this.areaNnMapper.selectAllAreaNameOptions();
		HashMap<String, String> areaIdNameDict = new HashMap<>();
		for (OptionsOut opt : opts) {
			areaIdNameDict.put(opt.getOptValue(), opt.getOptText());
		}
		// iteratively update list elements
		for (CityPlanPrjRow row : rows) {
			String[] areaIds = null != row.getArea() ? row.getArea().split(",") : new String[0];
			StringBuilder trans = new StringBuilder();
			for (String areaId : areaIds) {
				String areaName = areaIdNameDict.get(areaId);
				if (null != areaName && !areaName.equalsIgnoreCase("")) {
					trans.append(areaName);
					trans.append(",");
				}
			}
			int actualLength = trans.length() > 0 ? trans.length() - 1 : trans.length();
			row.setAreaTrans(trans.substring(0, actualLength)); // remove last char
		}
		return new PageInfo<>(rows);
	}

	@Override
	public CityPlanPrj findById(Integer id) {
		return this.cityPlanPrjMapper.selectByPrimaryKey(id);
	}

	@Override
	public int insert(CityPlanPrj cityPlanPrj) {
		return this.cityPlanPrjMapper.insert(cityPlanPrj);
	}

	@Override
	@Transactional
	public int update(CityPlanPrj cityPlanPrj) {
		return this.cityPlanPrjMapper.updateByPrimaryKey(cityPlanPrj);
	}

	@Override
	public String insertIncrementalWithResult(CityPlanPrj record) {
		Integer id = record.getId();
		boolean exist = null != this.cityPlanPrjMapper.selectByPrimaryKey(id);
		try {
			if (exist) {
				int change = this.cityPlanPrjMapper.updateByPrimaryKey(record);
				if (change > 0) {
					logger.info(String.format("更新成功！更改行数[%s] - 记录编号[%s] - 表[%s]。", change, id, TABLE_NAME_ENG));
				} else {
					logger.info(String.format("更新失败！更改行数[%s] - 记录编号[%s] - 表[%s]。", change, id, TABLE_NAME_ENG));
				}
			} else {
				int change = this.cityPlanPrjMapper.insert(record);
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
