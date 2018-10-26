package org.zxs.leader.control.dao.model.vo.output;

/**
 * 模糊查询信息
 * @author Administrator
 */
public class PrcSearchOut {
	
	private Integer type; // 搜索类型，1为按项目名，2为按领导名，3为按业主名
	
	private Integer id;
	
	private String value;

	private String typeDis;

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getTypeDis() {
		return typeDis;
	}

	public void setTypeDis(String typeDis) {
		this.typeDis = typeDis;
	}
	
}
