package org.zxs.leader.control.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.zxs.leader.control.dao.interf.IDictHeaderMapper;
import org.zxs.leader.control.dao.model.DictHeader;
import org.zxs.leader.control.service.interf.IHeaderService;

@Service
public class HeaderServiceImpl implements IHeaderService{
	
	private static final Log log = LogFactory.getLog(HeaderServiceImpl.class);
	
	@Resource
	private IDictHeaderMapper dictTableNameMapper;
	
	/**
	 * 
	* @Title: getInheritedPrivateFields 
	* @Description: 获取本类以及父类中的私有字段
	* @param @param type
	* @param @return  参数说明 
	* @return List<Field>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月5日 下午3:23:03
	 */
	public List<Field> getInheritedPrivateFields(Class<?> type) {
	    List<Field> result = new ArrayList<Field>();
	    Class<?> i = type;
	    while (i != null && i != Object.class) {
	        Collections.addAll(result, i.getDeclaredFields());
	        i = i.getSuperclass();
	    }
	    return result;
	}
	
	/**
	 * 
	* @Title: getHeadersByClassType
	* @Description: 返回Web端表头JSON
	* @param @param type
	* @param @return  参数说明 
	* @return List<HashMap<String,Object>>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月5日 下午3:33:40
	 */
	public List<HashMap<String, Object>> getHeadersByClassType(String tableName, Class<?> type) {
		// return value
		List<HashMap<String, Object>> headers = new ArrayList<>();
		List<Field> objectProperties = this.getInheritedPrivateFields(type);
		List<DictHeader> tableHeader = new ArrayList<>();
		for (Field field : objectProperties) {
			// skip it if the field is static
			if(Modifier.isStatic(field.getModifiers())) {
				continue;
			}
			DictHeader header = dictTableNameMapper.getHeaderByTableNameAndEngName(tableName, field.getName());
			//System.out.println(field.getName() + " >>> " + header); // temp
			tableHeader.add(header);
		}
		// sort
		sortHeadersByWebOrder(tableHeader);
		for (DictHeader name : tableHeader) {
			
			if (null == name) {
				continue;
			}
			
			// only webDisplayed, 1 = yes
			if (name.getWebDisplayed() == 0) {
				continue;
			}
			HashMap<String, Object> header = new HashMap<>();
			header.put("table", name.getTableName());
			header.put("field", name.getEngColName());
			header.put("title", name.getChnColName());
			header.put("width", name.getMinWidth());
			header.put("align", name.getAlign());
			if ("id".equalsIgnoreCase(name.getEngColName())) {
				header.put("sort", (boolean) true);
			}
			headers.add(header);
		}
		log.info(String.format("[%s]表 - 根据[%s]VO类获取表头数据[%s]个。", tableName, type.getSimpleName(), headers.size()));
		return headers;
	}

	/**
	 * 
	* @Title: getExcelHeadersByPrefix 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param prefix
	* @param @return  参数说明 
	* @return List<DictHeader>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月6日 下午3:21:32
	 */
	public List<DictHeader> getExcelHeadersByTableName(String tableName) {
		return this.dictTableNameMapper.getExcelHeadersByTableName(tableName);
	}
	
	/**
	 * 
	* @Title: getWebHeadersByPrefix 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param prefix
	* @param @return  参数说明 
	* @return List<DictHeader>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月6日 下午3:21:35
	 */
	public List<DictHeader> getWebHeadersByTableName(String tableName) {
		return this.dictTableNameMapper.getWebHeadersByTableName(tableName);
	}
	
	/**
	 * 
	* @Title: sortHeadersByExcelOrder 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param list  参数说明 
	* @return void    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月6日 下午3:21:38
	 */
	public void sortHeadersByExcelOrder(List<DictHeader> list) {
		Collections.sort(list, new Comparator<DictHeader>() {
			@Override
			public int compare(final DictHeader header1, DictHeader header2) {
			      return header1.getExcelOrder() - header2.getExcelOrder();
			}}
		);
	}

	/**
	 * 
	* @Title: sortHeadersByWebOrder 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param list  参数说明 
	* @return void    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月6日 下午3:21:42
	 */
	public void sortHeadersByWebOrder(List<DictHeader> list) {
		Collections.sort(list, new Comparator<DictHeader>() {
			@Override
			public int compare(DictHeader header1, DictHeader header2) {
				if (null != header1 && null != header2) {
					return header1.getWebOrder() - header2.getWebOrder();
				} else {
					return 0;
				}
			}}
		);
	}
	
}
