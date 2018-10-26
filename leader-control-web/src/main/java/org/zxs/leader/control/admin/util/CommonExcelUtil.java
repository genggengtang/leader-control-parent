package org.zxs.leader.control.admin.util;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.text.WordUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.zxs.leader.control.dao.model.DictHeader;

public class CommonExcelUtil {
	
	/**
	 * 
	* @Title: convertOutputStream 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param sheetName
	* @param @param list
	* @param @param headers
	* @param @return  参数说明 
	* @return ByteArrayOutputStream    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月6日 上午8:55:39
	 */
	public ByteArrayOutputStream convertOutputStream(List<Object> list, List<DictHeader> headers) {
		XSSFWorkbook book = new XSSFWorkbook();
		List<List<String>> table = convertTable(list, headers);
		ByteArrayOutputStream out = null;
		int totalNumRow = list.size();
		XSSFSheet sheet = book.createSheet(); // sheet name
		for (int row = 0; row < totalNumRow + 1; row ++) { // first row is for column names, so totalNumRow + 1
			XSSFRow cellRow = sheet.createRow(row);
			for (int col = 0; col < headers.size(); col ++) {  
	      		XSSFCell cell = cellRow.createCell(col);
	      		if (row == 0) {
	      			// set first row as column names
	      			cell.setCellValue(headers.get(col).getChnColName());
	      		} else {
	      			// set rest of rows data
	      			cell.setCellValue(table.get(row - 1).get(col));
	      		}
			}
		}
		// set columns' width to fit content
		int numOfCols = sheet.getRow(0).getLastCellNum();
		for (int i = 0; i < numOfCols; i++) {
			sheet.autoSizeColumn(i);
		}
		try {
			out = new ByteArrayOutputStream();
			book.write(out);
			out.flush();
			out.close();
			book.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}  
		return out;
	}
	
	/**
	 * 
	* @Title: fireDownloadTask 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param response
	* @param @param out  参数说明 
	* @return void    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月6日 上午8:59:38
	 */
	public void fireDownloadTask(HttpServletResponse response, ByteArrayOutputStream out) {
		if (null == out) {
			return;
		}
		try {
			// excel file settings
			String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			response.setContentType("application/xlsx");
			response.setHeader("Content-Disposition", "attachment; filename=\"" + timestamp + ".xlsx\""); 
			response.getOutputStream().write(out.toByteArray());
			response.flushBuffer();
			out.close();
		} catch (IOException ex) {
			throw new RuntimeException("IOError writing file to output stream");
		}
	}
	
	/**
	 * 
	* @Title: convertTable 
	* @Description: 工具方法
	* @param @param oList
	* @param @return  参数说明 
	* @return List<List<String>>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月5日 上午9:49:27
	 */
	private List<List<String>> convertTable(List<Object> list, List<DictHeader> headers) {
		List<List<String>> table = new ArrayList<>(); // 2D array as table
		for (Object object : list) {
			// new row to insert
			List<String> row = new ArrayList<>();
			HashMap<String, Method> methodMap = (HashMap<String, Method>) getGetters(object);
			for (DictHeader header : headers) {
				String methodKey = "get" + WordUtils.capitalize(header.getEngColName());
				Method method = methodMap.get(methodKey);
				if (null == method) {
					row.add("");
					continue;
				}
				try {
					final Object invokedResult = method.invoke(object);
					row.add(format(invokedResult));
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
			table.add(row);
		}
		return table;
	}
	
	/**
	 * 
	* @Title: getGetters 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param object
	* @param @return  参数说明 
	* @return Map<String,Method>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年8月7日 下午3:29:29
	 */
	private Map<String, Method> getGetters(final Object object) {
		Map<String, Method> getterMap = new HashMap<>();
		for (Method method : object.getClass().getMethods()) {
			if (method.getName().startsWith("get") 
					&& method.getParameterTypes().length == 0
					&& !method.getName().equalsIgnoreCase("getclass")) {
				getterMap.put(method.getName(), method);
			}
		}
		return getterMap;
	}
	
	/**
	 * 
	* @Title: format 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param o
	* @param @return  参数说明 
	* @return String    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月6日 下午3:21:13
	 */
	private String format(Object o) {
		if (null == o) {
			return null;
		} else if (o instanceof Date) {
			String pattern = "yyyy-MM-dd HH:mm:ss";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			String dateStr = simpleDateFormat.format(new Date());
			return dateStr;
		}
		return o + "";
	}

}
