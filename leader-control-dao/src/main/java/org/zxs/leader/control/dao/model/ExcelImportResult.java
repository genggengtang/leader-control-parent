package org.zxs.leader.control.dao.model;

import java.util.ArrayList;
import java.util.List;

public class ExcelImportResult {
	
	// result types
	public final static String FULLY = "FULLY";
	
	public final static String PARTIALLY = "PARTIALLY";
	
	public final static String NONE = "NONE";
	
	private int totalRows;
	
	private int sucsessRowsNum;
	
	private int failureRowsNum;
	
	private List<Integer> errorRowIds;
	
	private List<String> exceptions;
	
	private List<Object> errorRows; // prjInfos that didn't get inserted correctly
	
	private String resultType;
	
	public ExcelImportResult() {
		this.exceptions = new ArrayList<>();
		this.errorRows = new ArrayList<>();
		this.errorRowIds = new ArrayList<>();
	}
	
	public void addErrorRow(Object row) {
		this.errorRows.add(row);
	}
	
	public void addException(String e) {
		this.exceptions.add(e);
	}
	
	public void addErrorRowId(Integer id) {
		this.errorRowIds.add(id);
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getSucsessRowsNum() {
		return sucsessRowsNum;
	}

	public void setSucsessRowsNum(int sucsessRowsNum) {
		this.sucsessRowsNum = sucsessRowsNum;
	}

	public int getFailureRowsNum() {
		return failureRowsNum;
	}

	public void setFailureRowsNum(int failureRowsNum) {
		this.failureRowsNum = failureRowsNum;
	}

	public List<Integer> getErrorRowIds() {
		return errorRowIds;
	}

	public void setErrorRowIds(List<Integer> errorRowIds) {
		this.errorRowIds = errorRowIds;
	}

	public List<String> getExceptions() {
		return exceptions;
	}

	public void setExceptions(List<String> exceptions) {
		this.exceptions = exceptions;
	}

	public List<Object> getErrorRows() {
		return errorRows;
	}

	public void setErrorRows(List<Object> errorRows) {
		this.errorRows = errorRows;
	}

	public String getResultType() {
		return resultType;
	}

	public void setResultType(String resultType) {
		this.resultType = resultType;
	}
	
}
