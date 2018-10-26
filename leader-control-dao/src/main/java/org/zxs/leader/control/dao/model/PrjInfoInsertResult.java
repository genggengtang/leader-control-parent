package org.zxs.leader.control.dao.model;

import java.util.ArrayList;
import java.util.List;

public class PrjInfoInsertResult {
	
	// result types
	public final static String FULLY = "FULLY";
	
	public final static String PARTIALLY = "PARTIALLY";
	
	public final static String NONE = "NONE";
	
	private int totalNumRows;
	
	private int rowAffected;
	
	private int errorRows;
	
	private List<Integer> errorRowNums;
	
	private List<String> exceptionList;
	
	private List<PrjInfo> errorPrjInfoList; // prjInfos that didn't get inserted correctly
	
	private String resultType;
	
	public PrjInfoInsertResult() {
		this.exceptionList = new ArrayList<>();
		this.errorPrjInfoList = new ArrayList<>();
		this.errorRowNums = new ArrayList<>();
	}
	
	public void addErrorPrjInfo(PrjInfo prjInfo) {
		this.errorPrjInfoList.add(prjInfo);
	}
	
	public void addException(String e) {
		this.exceptionList.add(e);
	}
	
	public void addErrorRowNums(Integer errorRowNum) {
		this.errorRowNums.add(errorRowNum);
	}
	
	public int getRowAffected() {
		return rowAffected;
	}

	public void setRowAffected(int rowAffected) {
		this.rowAffected = rowAffected;
	}

	public int getErrorRows() {
		return errorRows;
	}

	public void setErrorRows(int errorRows) {
		this.errorRows = errorRows;
	}

	public List<String> getExceptionList() {
		return exceptionList;
	}

	public void setExceptionList(List<String> exceptionList) {
		this.exceptionList = exceptionList;
	}

	public List<PrjInfo> getErrorPrjInfoList() {
		return errorPrjInfoList;
	}

	public void setErrorPrjInfoList(List<PrjInfo> errorPrjInfoList) {
		this.errorPrjInfoList = errorPrjInfoList;
	}

	public String getResultType() {
		return resultType;
	}

	public void setResultType(String resultType) {
		this.resultType = resultType;
	}

	public int getTotalNumRows() {
		return totalNumRows;
	}

	public void setTotalNumRows(int totalNumRows) {
		this.totalNumRows = totalNumRows;
	}

	public List<Integer> getErrorRowNums() {
		return errorRowNums;
	}

	public void setErrorRowNums(List<Integer> errorRowNums) {
		this.errorRowNums = errorRowNums;
	}

	@Override
	public String toString() {
		return "PrjInfoInsertResult [totalNumRows=" + totalNumRows + ", rowAffected=" + rowAffected + ", errorRows="
				+ errorRows + ", errorRowNums=" + errorRowNums + ", exceptionList=" + exceptionList
				+ ", errorPrjInfoList=" + errorPrjInfoList + ", resultType=" + resultType + "]";
	}
	
}
