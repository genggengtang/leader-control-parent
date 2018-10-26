package org.zxs.leader.control.admin.util;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.zxs.leader.control.dao.model.PrjInfo;

public class ProjectInfoExcelUtil {
	
	private static final Log logger = LogFactory.getLog(ProjectInfoExcelUtil.class);
	
	// HSSFWorkbook 2003
	// XSSFWorkbook 2007
	
	private static String[] columnNames = {
			"编号",
			"关联的最新年记录编号",
			"项目全称",
			"项目简称",
			"经度",
			"纬度",
			"责任领导编号",
			"联系领导编号",
			"牵头单位联系人",
			"服务类别",
			"项目内容",
			"总投资额",
			"实际总投资额",
			"填报单位编号",
			"行业编号",
			"建设阶段",
			"实际建设阶段",
			"区域编号",
			"计划开工时间",
			"实际开工时间",
			"计划竣工日期",
			"实际竣工日期",
			"是否60周年公益项目",
			"是否区统筹",
			"业主单位名",
			"备注",
			"需要展示的备注",
			"创建时间",
			"最后更新时间"
			};
	
	private static String sheetName = "市领导联系项目";
	
	/**
	 *  helper method
	 *  convert project information list to list table
	 * @param prjInfoOutList
	 * @return
	 */
	private static List<List<String>> convertToTable(List<PrjInfo> prjInfoList) {
		List<List<String>> table = new ArrayList<>();
		for (PrjInfo prjInfo : prjInfoList) {
			List<String> row = new ArrayList<>();
			row.add(nullToStr(prjInfo.getId()));
			row.add(nullToStr(prjInfo.getLatestYearId()));
			row.add(nullToStr(prjInfo.getFullName()));
			row.add(nullToStr(prjInfo.getShortName()));
			row.add(nullToStr(prjInfo.getLng()));
			row.add(nullToStr(prjInfo.getLat()));
			row.add(nullToStr(prjInfo.getRspLeaderId()));
			row.add(nullToStr(prjInfo.getContactLeaderId()));
			row.add(nullToStr(prjInfo.getContactId()));
			row.add(nullToStr(prjInfo.getType()));
			row.add(nullToStr(prjInfo.getContent()));
			row.add(nullToStr(prjInfo.getTotalInvest()));
			row.add(nullToStr(prjInfo.getActualInvest()));
			row.add(nullToStr(prjInfo.getSubmitOrgId()));
			row.add(nullToStr(prjInfo.getIndustry()));
			row.add(nullToStr(prjInfo.getPlanStatus()));
			row.add(nullToStr(prjInfo.getActualStatus()));
			row.add(nullToStr(prjInfo.getAreaId()));
			row.add(dateFormat(prjInfo.getPlanStartDt()));
			row.add(dateFormat(prjInfo.getActualStartDt()));
			row.add(dateFormat(prjInfo.getPlanEndDt()));
			row.add(dateFormat(prjInfo.getActualEndDt()));
			row.add(nullToStr(prjInfo.getIs60thWelfare()));
			row.add(nullToStr(prjInfo.getIsPrvcPlan()));
			row.add(nullToStr(prjInfo.getOwnerOrgName()));
			row.add(nullToStr(prjInfo.getRemark()));
			row.add(nullToStr(prjInfo.getRemarkDisplay()));
			row.add(dateFormat(prjInfo.getCreateAt()));
			row.add(dateFormat(prjInfo.getUpdateAt()));
			table.add(row);
		}
		return table;
	}
	
	// convert null to empty string
	private static String nullToStr(Object object) {
		return null == object ? "" : object + "";
	}
	
	private static String dateFormat(Date date) {
		if (null == date) {
			return "";
		}
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String dateStr = simpleDateFormat.format(new Date());
		return dateStr;
	}

	public static ByteArrayOutputStream convertToOutputStream(List<PrjInfo> prjInfoList) {
		XSSFWorkbook book = new XSSFWorkbook();
		XSSFSheet sheet = book.createSheet(sheetName);
		List<List<String>> table = convertToTable(prjInfoList);
		ByteArrayOutputStream out = null;
		
		int totalNumRow = prjInfoList.size();
		for (int row = 0; row < totalNumRow + 1; row ++) { // first row is for column names, so totalNumRow + 1
			XSSFRow cellRow = sheet.createRow(row);
			for (int col = 0; col < columnNames.length; col ++)  
	      	{  
	      		XSSFCell cell = cellRow.createCell(col);
	      		if (row == 0) {
	      			// first row as column names
	      			cell.setCellValue(columnNames[col]);
	      		} else {
	      			// set cell value string
	      			cell.setCellValue(table.get(row - 1).get(col));
	      		}
			}
		}
		
		try {
			// write this workbook to an output stream.  
			//FileOutputStream out = new FileOutputStream(fileName);
			out = new ByteArrayOutputStream();
			book.write(out);
			out.flush();
			out.close();
			book.close();
			logger.info("Converted excel workbook to ByteArrayOutputStream.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}  
		return out;
	}
	
	public static List<PrjInfo> readExcel(InputStream inputStream, String extension) {
		List<PrjInfo> table = new ArrayList<>();
		
		// xls for 2003 only
		// xlsx, xlsm, xlsb for 2007
		Workbook workbook = null;
		try {
			if (extension.equalsIgnoreCase(".xls")) {
				workbook = new HSSFWorkbook(inputStream);
			} else if (extension.equalsIgnoreCase(".xlsx") || extension.equalsIgnoreCase(".xlsm") 
					|| extension.equalsIgnoreCase(".xlsb")) {
				workbook = new XSSFWorkbook(inputStream);
			} else {
				return null;
			}
			Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = datatypeSheet.iterator();
            
            // skip the first row because the first row is of titles
            if (rowIterator.hasNext()) {
            	rowIterator.next();
            }
            
            SimpleDateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
            while (rowIterator.hasNext()) {
            	Row currentRow = rowIterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();
                PrjInfo prjInfo = new PrjInfo();
                while (cellIterator.hasNext()) {
                	Cell currentCell = cellIterator.next();
                	int columnIndex = currentCell.getColumnIndex();
                	String cellValStr = currentCell.getStringCellValue();
                	
                	if (null == cellValStr || cellValStr.equalsIgnoreCase("")) {
                		cellValStr = null;
                	}
                	
                	switch(columnIndex) {
                		case 0: 
                			// 编号
                			prjInfo.setId(null == cellValStr ? 0 : Integer.parseInt(cellValStr));
                			break;
                		case 1: 
                			// 关联的最新年记录编号
                			prjInfo.setLatestYearId(null == cellValStr ? null : Integer.parseInt(cellValStr));
                			break;
                		case 2: 
                			// 项目全称
                			prjInfo.setFullName(null == cellValStr ? "" : cellValStr);
                			break;
                		case 3: 
                			// 项目简称
                			prjInfo.setShortName(cellValStr);
                			break;
                		case 4: 
                			// 经度
                			prjInfo.setLng(null == cellValStr ? null : new BigDecimal(cellValStr));
                			break;
                		case 5: 
                			// 纬度
                			prjInfo.setLat(null == cellValStr ? null : new BigDecimal(cellValStr));
                			break;
                		case 6: 
                			// 责任领导编号
                			prjInfo.setRspLeaderId(null == cellValStr ? null : Integer.parseInt(cellValStr));
                			break;
                		case 7: 
                			// 联系领导编号
                			prjInfo.setContactLeaderId(null == cellValStr ? null : Integer.parseInt(cellValStr));
                			break;
                		case 8: 
                			// 牵头单位联系人
                			prjInfo.setContactId(null == cellValStr ? null : Integer.parseInt(cellValStr));
                			break;
                		case 9: 
                			// 服务类别，如2，3
                			prjInfo.setType(null == cellValStr ? null : Short.parseShort(cellValStr));
                			break;
                		case 10: 
                			// 项目内容
                			prjInfo.setContent(null == cellValStr ? "" : cellValStr);
                			break;
                		case 11: 
                			// 总投资额
                			prjInfo.setTotalInvest(null == cellValStr ? 0 : Integer.parseInt(cellValStr));
                			break;
                		case 12: 
                			// 实际总投资额，单位万元
                			prjInfo.setActualInvest(null == cellValStr ? null : Integer.parseInt(cellValStr));
                			break;
                		case 13: 
                			// 填报单位编号
                			prjInfo.setSubmitOrgId(null == cellValStr ? null : Integer.parseInt(cellValStr));
                			break;
                		case 14: 
                			// 行业，对应字典表203
                			prjInfo.setIndustry(null == cellValStr ? null : Integer.parseInt(cellValStr));
                			break;
                		case 15: 
                			// 建设阶段，对应字典表类目204
                			prjInfo.setPlanStatus(null == cellValStr ? null : Integer.parseInt(cellValStr));
                			break;
                		case 16: 
                			// 实际建设阶段，对应字典表类目204
                			prjInfo.setActualStatus(null == cellValStr ? null : Integer.parseInt(cellValStr));
                			break;
                		case 17: 
                			// 所属区域编号，多个区域以逗号分隔
                			prjInfo.setAreaId(cellValStr);
                			break;
                		case 18: 
                			// 计划开工时间
                			prjInfo.setPlanStartDt(null == cellValStr ? null : dateFormat.parse(currentCell.getStringCellValue()));
                			break;
                		case 19: 
                			// 实际开工时间
                			prjInfo.setActualStartDt(null == cellValStr ? null : dateFormat.parse(currentCell.getStringCellValue()));
                			break;
                		case 20: 
                			// 计划竣工日期
                			prjInfo.setPlanEndDt(null == cellValStr ? null : dateFormat.parse(currentCell.getStringCellValue()));
                			break;
                		case 21: 
                			// 实际竣工日期
                			prjInfo.setActualEndDt(null == cellValStr ? null : dateFormat.parse(currentCell.getStringCellValue()));
                			break;
                		case 22: 
                			// 是否60周年公益项目，0为否，1为是
                			prjInfo.setIs60thWelfare(null == cellValStr ? 0 : Short.parseShort(cellValStr));
                			break;
                		case 23: 
                			// 是否区统筹，0为否，1为是
                			prjInfo.setIsPrvcPlan(null == cellValStr ? 0 : Short.parseShort(cellValStr));
                			break;
                		case 24: 
                			// 业主单位名，多个以逗号分隔
                			prjInfo.setOwnerOrgName(cellValStr);
                			break;
                		case 25: 
                			// 备注
                			prjInfo.setRemark(cellValStr);
                			break;
                		case 26: 
                			// 需要展示的备注
                			prjInfo.setRemarkDisplay(cellValStr);
                			break;
                		case 27: 
                			// 创建时间
                			prjInfo.setCreateAt(null == cellValStr ? new Date() : dateFormat.parse(cellValStr));
                			break;
                		case 28: 
                			// 最后更新时间
                			prjInfo.setUpdateAt(null == cellValStr ? new Date() : dateFormat.parse(cellValStr));
                			break;
                	}
                }
                // line break
                table.add(prjInfo);
            }
            workbook.close();
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}

		return table;
	}
	
}
