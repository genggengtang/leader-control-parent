package org.zxs.leader.control.dao.model;

import java.util.ArrayList;
import java.util.List;

public class BatchInsertRes {
	
	private int successRowNum;
	
	private int failureRowNum;
	
	private int totalRowNum;
	
	private String message;
	
	private List<String> failureCauses;

	public BatchInsertRes() {
		failureCauses = new ArrayList<>();
	}
	
	public void increaseTotalRowNum() {
		totalRowNum ++;
	}
	
	public int getSuccessRowNum() {
		return successRowNum;
	}

	public void setSuccessRowNum(int successRowNum) {
		this.successRowNum = successRowNum;
	}

	public int getFailureRowNum() {
		failureRowNum = failureCauses.size();
		return failureRowNum;
	}

	public void setFailureRowNum(int failureRowNum) {
		this.failureRowNum = failureRowNum;
	}

	public int getTotalRowNum() {
		return totalRowNum;
	}

	public void setTotalRowNum(int totalRowNum) {
		this.totalRowNum = totalRowNum;
	}

	public List<String> getFailureCauses() {
		return failureCauses;
	}

	public void setFailureCauses(List<String> failureCauses) {
		this.failureCauses = failureCauses;
	}
	
	public void addFailureCause(String cause) {
		if (null != failureCauses) {
			failureCauses.add(cause);
		}
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void refresh() {
		successRowNum = totalRowNum - failureCauses.size(); 
		failureRowNum = failureCauses.size();
	}

	@Override
	public String toString() {
		return "BatchInsertRes [successRowNum=" + successRowNum + ", failureRowNum=" + failureRowNum + ", totalRowNum="
				+ totalRowNum + ", failureCauses=" + failureCauses + "]";
	}

}
