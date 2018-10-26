package org.zxs.leader.control.dao.model.vo.output;

import java.util.List;

import org.zxs.leader.control.dao.model.MeetingNote;

/**
 * 市统筹项目详情信息
 * @author Administrator
 *
 */
public class CpPrjDetailOut extends CpPrjPageOut{
	
	private String areaName; // 所属区域名称，多个区域以逗号分隔
	private String areaAdminName; // 项目管理行政区域名称
	private String industryName; // 行业类型释义
	private String preContent; // 前一年进度
	private String yearContent; // 当年进度目标
	private String rspName; // 责任单位名称，多个以逗号分隔
	private String[] rspArray; // 责任单位数组
	private Integer year; // 计划年份
	private List<PrjProveOut> proveList; // 审批信息
	private List<MeetingNote> attachmentList; // 相关附件信息
	
	private Integer accmActualInvest;  // 当年累计投资
	private Integer completeRateByYear; // 当年投资完成率
	private List<PrjYearPrgOut> yearPrgList; // 建设进度
	
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getAreaAdminName() {
		return areaAdminName;
	}
	public void setAreaAdminName(String areaAdminName) {
		this.areaAdminName = areaAdminName;
	}
	public String getIndustryName() {
		return industryName;
	}
	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}
	public String getPreContent() {
		return preContent;
	}
	public void setPreContent(String preContent) {
		this.preContent = preContent;
	}
	public String getYearContent() {
		return yearContent;
	}
	public void setYearContent(String yearContent) {
		this.yearContent = yearContent;
	}
	public String getRspName() {
		return rspName;
	}
	public void setRspName(String rspName) {
		this.rspName = rspName;
		if(null != rspName && !rspName.isEmpty()) {
			this.rspArray = rspName.split(",");
		}
	}
	public String[] getRspArray() {
		return rspArray;
	}
	public void setRspArray(String[] rspArray) {
		this.rspArray = rspArray;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public List<PrjProveOut> getProveList() {
		return proveList;
	}
	public void setProveList(List<PrjProveOut> proveList) {
		this.proveList = proveList;
	}
	public List<MeetingNote> getAttachmentList() {
		return attachmentList;
	}
	public void setAttachmentList(List<MeetingNote> attachmentList) {
		this.attachmentList = attachmentList;
	}
	public Integer getAccmActualInvest() {
		return accmActualInvest;
	}
	public void setAccmActualInvest(Integer accmActualInvest) {
		this.accmActualInvest = accmActualInvest;
	}
	public Integer getCompleteRateByYear() {
		return completeRateByYear;
	}
	public void setCompleteRateByYear(Integer completeRateByYear) {
		this.completeRateByYear = completeRateByYear;
	}
	public List<PrjYearPrgOut> getYearPrgList() {
		return yearPrgList;
	}
	public void setYearPrgList(List<PrjYearPrgOut> yearPrgList) {
		this.yearPrgList = yearPrgList;
	}
}
