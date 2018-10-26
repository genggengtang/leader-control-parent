package org.zxs.leader.control.dao.interf;

import java.util.List;

import org.zxs.leader.control.dao.model.DictHeader;

import tk.mybatis.mapper.common.Mapper;

public interface IDictHeaderMapper extends Mapper<DictHeader> {
	
	List<DictHeader> getWebHeadersByTableName(String tableName);
	
	List<DictHeader> getExcelHeadersByTableName(String tableName);
	
	DictHeader getHeaderByTableNameAndEngName(String tableName, String engName);
	
}
