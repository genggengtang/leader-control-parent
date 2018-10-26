package org.zxs.leader.control.dao.model.vo.output;

import org.zxs.leader.control.dao.model.PrjChart;

/**
 * 项目内容或进度图返回对象
 * @author Administrator
 *
 */
public class PrjChartOut extends PrjChart{
	
	private String years;
	private String[] yearArray;
	
	public String getYears() {
		return years;
	}
	public void setYears(String years) {
		this.years = years;
		if(null != years && !years.isEmpty()) {
			this.yearArray = years.split(",");
		}
	}
	public String[] getYearArray() {
		return yearArray;
	}
	public void setYearArray(String[] yearArray) {
		this.yearArray = yearArray;
	}
	
}
