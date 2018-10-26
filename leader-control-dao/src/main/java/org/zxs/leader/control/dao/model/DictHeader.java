package org.zxs.leader.control.dao.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="dict_header")
public class DictHeader implements Comparable<DictHeader>{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name="table_name")
    private String tableName;
	
	@Column(name="eng_col_name")
    private String engColName;
	
	@Column(name="chn_col_name")
    private String chnColName;
	
	@Column(name="is_required")
    private Integer isRequired;
	
	@Column(name="field_type")
	private String fieldType;
	
	@Column(name="web_order")
    private Integer webOrder;
	
	@Column(name="web_displayed")
    private Integer webDisplayed;
	
	@Column(name="align")
	private String align;
	
	@Column(name="excel_order")
	private Integer excelOrder;
	
	@Column(name="excel_displayed")
    private Integer excelDisplayed;
	
	@Column(name="min_width")
	private Integer minWidth;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	public String getEngColName() {
		return engColName;
	}

	public void setEngColName(String engColName) {
		this.engColName = engColName;
	}

	public String getChnColName() {
		return chnColName;
	}

	public void setChnColName(String chnColName) {
		this.chnColName = chnColName;
	}

	public Integer getMinWidth() {
		return minWidth;
	}

	public void setMinWidth(Integer minWidth) {
		this.minWidth = minWidth;
	}

	public String getAlign() {
		return align;
	}

	public void setAlign(String align) {
		this.align = align;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public Integer getWebOrder() {
		return webOrder;
	}

	public void setWebOrder(Integer webOrder) {
		this.webOrder = webOrder;
	}

	public Integer getExcelOrder() {
		return excelOrder;
	}

	public void setExcelOrder(Integer excelOrder) {
		this.excelOrder = excelOrder;
	}

	public Integer getWebDisplayed() {
		return webDisplayed;
	}

	public void setWebDisplayed(Integer webDisplayed) {
		this.webDisplayed = webDisplayed;
	}

	public Integer getExcelDisplayed() {
		return excelDisplayed;
	}

	public void setExcelDisplayed(Integer excelDisplayed) {
		this.excelDisplayed = excelDisplayed;
	}

	public Integer getIsRequired() {
		return isRequired;
	}

	public void setIsRequired(Integer isRequired) {
		this.isRequired = isRequired;
	}

	@Override
	public int compareTo(DictHeader o) {
		if (this.getWebOrder() > o.getWebOrder()) {
			return 1;
		} else if (this.getWebOrder() == o.getWebOrder()) {
			return 0;
		} else {
			return -1;
		}
	}
	
	@Override
	public String toString() {
		return "DictHeader [id=" + id + ", tableName=" + tableName + ", engColName=" + engColName + ", chnColName="
				+ chnColName + ", minWidth=" + minWidth + ", align=" + align + ", fieldType=" + fieldType
				+ ", webOrder=" + webOrder + ", excelOrder=" + excelOrder + ", webDisplayed=" + webDisplayed
				+ ", excelDisplayed=" + excelDisplayed + ", isRequired=" + isRequired + "]";
	}

}
