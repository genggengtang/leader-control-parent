package org.zxs.leader.control.service.admin.impl;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.text.WordUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.zxs.leader.control.dao.interf.IChatGroupInfoMapper;
import org.zxs.leader.control.dao.interf.IChatGroupUserMapper;
import org.zxs.leader.control.dao.interf.IDictHeaderMapper;
import org.zxs.leader.control.dao.interf.ILeaderGroupMapper;
import org.zxs.leader.control.dao.interf.IPrjPointMapper;
import org.zxs.leader.control.dao.interf.ITopicCommentMapper;
import org.zxs.leader.control.dao.interf.ITopicPicMapper;
import org.zxs.leader.control.dao.interf.IUserIssueMapper;
import org.zxs.leader.control.dao.interf.IWorkInfoMapper;
import org.zxs.leader.control.dao.model.BatchInsertRes;
import org.zxs.leader.control.dao.model.CbInvestSource;
import org.zxs.leader.control.dao.model.CbPlanPrj;
import org.zxs.leader.control.dao.model.ChatGroupInfo;
import org.zxs.leader.control.dao.model.ChatGroupUser;
import org.zxs.leader.control.dao.model.CityBuildPrj;
import org.zxs.leader.control.dao.model.CityPlanPrj;
import org.zxs.leader.control.dao.model.CpPrjOrg;
import org.zxs.leader.control.dao.model.DictHeader;
import org.zxs.leader.control.dao.model.LeaderGroup;
import org.zxs.leader.control.dao.model.MeetingNote;
import org.zxs.leader.control.dao.model.OrgUnit;
import org.zxs.leader.control.dao.model.OrgUser;
import org.zxs.leader.control.dao.model.PrjAttachment;
import org.zxs.leader.control.dao.model.PrjContact;
import org.zxs.leader.control.dao.model.PrjIssue;
import org.zxs.leader.control.dao.model.PrjMapLine;
import org.zxs.leader.control.dao.model.PrjMonthPlan;
import org.zxs.leader.control.dao.model.PrjPoint;
import org.zxs.leader.control.dao.model.PrjProve;
import org.zxs.leader.control.dao.model.PrjYearPlan;
import org.zxs.leader.control.service.admin.interf.ExcelImportService;
import org.zxs.leader.control.service.interf.ICbInvestSourceService;
import org.zxs.leader.control.service.interf.ICbPlanPrjService;
import org.zxs.leader.control.service.interf.ICityBuildPrjService;
import org.zxs.leader.control.service.interf.ICityPlanPrjService;
import org.zxs.leader.control.service.interf.ICpPrjOrgService;
import org.zxs.leader.control.service.interf.IMeetingNoteService;
import org.zxs.leader.control.service.interf.IOrgUnitService;
import org.zxs.leader.control.service.interf.IOrgUserService;
import org.zxs.leader.control.service.interf.IPrjAttachmentService;
import org.zxs.leader.control.service.interf.IPrjContactService;
import org.zxs.leader.control.service.interf.IPrjIssueService;
import org.zxs.leader.control.service.interf.IPrjMapLineService;
import org.zxs.leader.control.service.interf.IPrjMonthPlanService;
import org.zxs.leader.control.service.interf.IPrjPointService;
import org.zxs.leader.control.service.interf.IPrjProveService;
import org.zxs.leader.control.service.interf.IPrjYearPlanService;

@Service
public class ExcelImportServiceImplt implements ExcelImportService {

	private static final Log logger = LogFactory.getLog(ExcelImportServiceImplt.class);
	
	@Resource
	private IOrgUnitService orgUnitService;
	
	@Resource
	private IOrgUserService orgUserService;
	
	@Resource
	private IPrjYearPlanService prjYearPlanService;
	
	@Resource
	private IPrjMonthPlanService prjMonthPlanService;
	
	@Resource
	private ICbInvestSourceService cbInvestSourceService;
	
	@Resource
	private ICbPlanPrjService cbPlanPrjService;
	
	@Resource
	private IChatGroupInfoMapper chatGroupInfoMapper;
	
	@Resource
	private IChatGroupUserMapper chatGroupUserMapper;
	
	@Resource
	private ICityBuildPrjService cityBuildPrjService;
	
	@Resource
	private ICityPlanPrjService cityPlanPrjService;
	
	@Resource
	private ICpPrjOrgService cpPrjOrgService;
	
	@Resource
	private ILeaderGroupMapper leaderGroupMapper;
	
	@Resource
	private IMeetingNoteService meetingNoteService;
	
	@Resource
	private IPrjAttachmentService prjAttachmentService;
	
	@Resource
	private IPrjContactService prjContactService;
	
	@Resource
	private IPrjIssueService prjIssueService;
	
	@Resource
	private IPrjMapLineService prjMapLineService;
	
	@Resource
	private IPrjPointService prjPointService;
	
	@Resource
	private IPrjPointMapper prjPointMapper;
	
	@Resource
	private IPrjProveService prjProveService;
	
	@Resource
	private IWorkInfoMapper workInfoMapper;
	
	@Resource
	private IUserIssueMapper userIssueMapper;
	
	@Resource
	private ITopicPicMapper topicPicMapper;
	
	@Resource
	private ITopicCommentMapper topicCommentMapper;
	
	@Resource
	private IDictHeaderMapper dictHeaderMapper;
	
	@Override
	public BatchInsertRes batchImport(InputStream is, String fileName, String table) {
		int doIdx = fileName.lastIndexOf(".");
		String extension = fileName.substring(doIdx, fileName.length());
		logger.info(String.format("批量导入 - 正在读取文件...... 文件名[%s] - 当前表[%s]。", fileName, table));
		Workbook workbook = null;
		try {
			switch(extension) {
				case ".xls": // 2003
					workbook = new HSSFWorkbook(is);
					break;
				case ".xlsx": // 2007
					workbook = new XSSFWorkbook(is);
					break;
				case ".xlsm": // 2007
					workbook = new XSSFWorkbook(is);
					break;
				case ".xlsb": // 2007
					workbook = new XSSFWorkbook(is);
					break;
				default:
					break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		HashMap<String, String> dict = this.getHeaderDict(table);
		BatchInsertRes res = packTableModel(workbook, table, dict);
		return res;
	}
	
	/**
	 * 
	* @Title: packTableModel 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param workbook
	* @param @param table
	* @param @param dict
	* @param @return  参数说明 
	* @return BatchInsertRes    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月7日 下午5:46:56
	 */
	private BatchInsertRes packTableModel(Workbook workbook, String table, HashMap<String, String> dict) {
		BatchInsertRes insertRes = new BatchInsertRes();
		Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowItr = sheet.iterator();
        Row headers = rowItr.next();
        int totalCellNum = headers.getLastCellNum(); // 根据表头cell的数量来确定行cell的数量（空cell也计算）
        // get headers with correct order
        List<String> sortedHeaders = new ArrayList<>();
        for (Cell cell : headers) {
        	String chnHeader = cell.toString();
        	if (null == dict.get(chnHeader)) {
        		String message = String.format("批量导入失败！找不到与[%s]相对应的英文表头名称 - 当前表[%s]。", chnHeader, table);
        		logger.info(message);
        		insertRes.setMessage(message);
        		return insertRes;
        	}
        	sortedHeaders.add(dict.get(cell.toString()));
        }
        while (rowItr.hasNext()) {
        	Row row = rowItr.next();
        	Object model = this.getTableModel(table);
    		HashMap<String, Method> getters = getSetters(model.getClass().cast(model));
    		for (int cellNum = 0; cellNum < totalCellNum; cellNum ++) {
    			Cell cell = row.getCell(cellNum, MissingCellPolicy.CREATE_NULL_AS_BLANK);
        		String header = sortedHeaders.get(cellNum);
        		String cellVal = cell.toString();
        		String key = "set" + WordUtils.capitalize(header); // e.g setName
        		Method method = getters.get(key);
        		if (null == method) {
        			String message = String.format("批量导入失败！找不到方法[%s] - 当前表[%s]。", key, table);
					insertRes.setMessage(message);
					logger.info(message);
					return insertRes;
				}
        		try {
        			// set excel cell values into model properties
        			Class<?> argType = method.getParameterTypes()[0];
        			String argName = argType.getSimpleName();
        			switch(argName) {
        				case "Integer":
        					Double doubleToInteger = Double.parseDouble(cellVal.trim());
        					int intVal = doubleToInteger.intValue();
        					method.invoke(model.getClass().cast(model), intVal);
        					break;
        				case "Short":
        					method.invoke(model.getClass().cast(model), Short.parseShort(cellVal.trim()));
        					break;
        				case "Double":
        					method.invoke(model.getClass().cast(model), Double.parseDouble(cellVal.trim()));
        					break;
        				case "Long":
        					Double doubleToLong = Double.parseDouble(cellVal.trim());
        					Long longVal = doubleToLong.longValue();
        					method.invoke(model.getClass().cast(model), longVal);
        					break;
        				case "Date":
        					DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        					Date date = null;
        					try {
        						date = (Date) format.parse(cellVal);
        					} catch(ParseException e) {
        						Date emptyDate = null;
    							method.invoke(model.getClass().cast(model), emptyDate);
    							continue;
        					}
        					method.invoke(model.getClass().cast(model), date);
        					break;
        				case "Byte":
        					method.invoke(model.getClass().cast(model), new Byte(cellVal));
        					break;
        				case "BigDecimal":
        					method.invoke(model.getClass().cast(model), new BigDecimal(cellVal));
        					break;
        				default: // String
        					method.invoke(model.getClass().cast(model), cellVal);
        					break;
        			}
				} catch (IllegalAccessException | InvocationTargetException e) {
					e.printStackTrace();
				} catch (NumberFormatException e) {
					e.getMessage();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				}
        	}
        	// add failure cause if exist
    		logger.info("model >>>" + model);
        	String cause = insertToTable(model, table);
        	insertRes.increaseTotalRowNum();
        	if (null != cause && !cause.equalsIgnoreCase("")) {
        		insertRes.addFailureCause(cause);
        	}
        }
        insertRes.refresh();
        int failNum = insertRes.getFailureRowNum();
        int succNum = insertRes.getSuccessRowNum();
        int totalNum = insertRes.getTotalRowNum();
        String resultMessage = String.format("失败：[%s] 成功：[%s] 全部：[%s]", failNum, succNum, totalNum);
        insertRes.setMessage(resultMessage);
        return insertRes;
	}
	
	/**
	 * 
	* @Title: insertToTable 
	* @Description: 根据表名新增记录
	* @param @param record
	* @param @param table
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月7日 下午5:58:03
	 */
	public String insertToTable(Object record, String table) {
		switch(table) {
			case "org_unit":
				return this.orgUnitService.insertWithResult((OrgUnit) record);
			case "org_user":
				return this.orgUserService.insertWithResult((OrgUser) record);
			case "prj_year_plan":
				return this.prjYearPlanService.insertIncrementalWithResult((PrjYearPlan) record);
			case "prj_month_plan":
				return this.prjMonthPlanService.insertIncrementalWithResult((PrjMonthPlan) record);
			case "cb_invest_source":
				return this.cbInvestSourceService.insertIncrementalWithResult((CbInvestSource) record);
			case "cb_plan_prj":
				return this.cbPlanPrjService.insertIncrementalWithResult((CbPlanPrj) record);
			case "city_build_prj":
				return this.cityBuildPrjService.insertIncrementalWithResult((CityBuildPrj) record);
			case "city_plan_prj":
				return this.cityPlanPrjService.insertIncrementalWithResult((CityPlanPrj) record);
			case "cp_prj_org":
				return this.cpPrjOrgService.insertIncrementalWithResult((CpPrjOrg) record);
			case "meeting_note":
				return this.meetingNoteService.insertWithResult((MeetingNote) record);
			case "prj_attachment":
				return this.prjAttachmentService.insertWithResult((PrjAttachment) record);
			case "prj_contact":
				return this.prjContactService.insertWithResult((PrjContact) record);
			case "prj_issue":
				return this.prjIssueService.insertWithResult((PrjIssue) record);
			case "prj_map_line":
				return this.prjMapLineService.insertWithResult((PrjMapLine) record);
			case "prj_point":
				return this.prjPointService.insertWithResult((PrjPoint) record);
			case "prj_prove": 
				return this.prjProveService.insertWithResult((PrjProve) record);
			default: return null;
		}
	}
	
	/**
	 * 
	* @Title: getTableModel 
	* @Description: 根据表名获取一个新的model对象
	* @param @param table
	* @param @return  参数说明 
	* @return Object    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月7日 下午5:47:02
	 */
	private Object getTableModel(String table) {
		switch(table) {
			case "org_unit": return new OrgUnit();
			case "org_user": return new OrgUser();
			case "prj_year_plan": return new PrjYearPlan();
			case "prj_month_plan": return new PrjMonthPlan();
			case "cb_invest_source": return new CbInvestSource();
			case "cb_plan_prj": return new CbPlanPrj();
			case "chat_group_info": return new ChatGroupInfo();
			case "chat_group_user": return new ChatGroupUser();
			case "city_build_prj": return new CityBuildPrj();
			case "city_plan_prj": return new CityPlanPrj();
			case "cp_prj_org": return new CpPrjOrg();
			case "leader_group": return new LeaderGroup();
			case "meeting_note": return new MeetingNote();
			case "prj_attachment": return new PrjAttachment();
			case "prj_contact": return new PrjContact();
			case "prj_issue": return new PrjIssue();
			case "prj_map_line": return new PrjMapLine();
			case "prj_point": return new PrjPoint();
			case "prj_prove": return new PrjProve();
			default: return null;
		}
	}
	
	/**
	 * 
	* @Title: getHeaderDict 
	* @Description: 根据表名获取表头数据 
	* @param @param tableName
	* @param @return  参数说明 
	* @return HashMap<String,String>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月7日 下午3:28:43
	 */
	private HashMap<String, String> getHeaderDict(String tableName) {
		List<DictHeader> headers = this.dictHeaderMapper.getExcelHeadersByTableName(tableName);
		HashMap<String, String> dict = new HashMap<>();
		for (DictHeader header : headers) {
			dict.put(header.getChnColName(), header.getEngColName());
		}
		return dict;
	}
	
	/**
	 * 
	* @Title: getSetters 
	* @Description: 获取该对象中所有的setter方法
	* @param @param object
	* @param @return  参数说明 
	* @return HashMap<String,Method>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月7日 下午3:32:33
	 */
	private HashMap<String, Method> getSetters(final Object object) {
		HashMap<String, Method> getterMap = new HashMap<>();
		for (Method method : object.getClass().getMethods()) {
			if (method.getName().startsWith("set") 
					&& method.getParameterTypes().length == 1
					&& !method.getName().equalsIgnoreCase("getclass")) {
				getterMap.put(method.getName(), method);
			}
		}
		return getterMap;
	}

}
