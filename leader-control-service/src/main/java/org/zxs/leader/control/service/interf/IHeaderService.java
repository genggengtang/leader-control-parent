package org.zxs.leader.control.service.interf;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;

import org.zxs.leader.control.dao.model.DictHeader;

public interface IHeaderService {
	
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
	List<Field> getInheritedPrivateFields(Class<?> type);
	
	/**
	 * 
	* @Title: getWebTableHeaders
	* @Description: 返回Web端表头JSON
	* @param @param type
	* @param @return  参数说明 
	* @return List<HashMap<String,Object>>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月5日 下午3:33:40
	 */
	List<HashMap<String, Object>> getHeadersByClassType(String prefix, Class<?> type);
	
	/**
	 * 
	* @Title: getExcelHeadersByTableName 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param tableName
	* @param @return  参数说明 
	* @return List<DictHeader>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月9日 下午6:03:58
	 */
	List<DictHeader> getExcelHeadersByTableName(String tableName);
	
	/**
	 * 
	* @Title: getWebHeadersByTableName 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param tableName
	* @param @return  参数说明 
	* @return List<DictHeader>    返回类型 
	* @throws 
	* @author weiqingwen
	* @date 2018年7月9日 下午6:04:16
	 */
	List<DictHeader> getWebHeadersByTableName(String tableName);
	
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
	void sortHeadersByExcelOrder(List<DictHeader> list);

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
	void sortHeadersByWebOrder(List<DictHeader> list);

}
