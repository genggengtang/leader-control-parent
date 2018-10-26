package org.zxs.leader.control.dao.model.vo.output;
/**
 * 资金来源对象
 * @author Administrator
 *
 */
public class InvestSourceOut {
	private String sourceName;
	private String sourceTypeName;
	private Integer planInvest;
	private Integer actualInvest;
	private Integer restInvest;
	
	public String getSourceName() {
		return sourceName;
	}
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
	public String getSourceTypeName() {
		return sourceTypeName;
	}
	public void setSourceTypeName(String sourceTypeName) {
		this.sourceTypeName = sourceTypeName;
	}
	public Integer getPlanInvest() {
		return planInvest;
	}
	public void setPlanInvest(Integer planInvest) {
		this.planInvest = planInvest;
	}
	public Integer getActualInvest() {
		return actualInvest;
	}
	public void setActualInvest(Integer actualInvest) {
		this.actualInvest = actualInvest;
	}
	public Integer getRestInvest() {
		return restInvest;
	}
	public void setRestInvest(Integer restInvest) {
		this.restInvest = restInvest;
	}
	
}
