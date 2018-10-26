package org.zxs.leader.control.dao.model.vo.query;

/**
 * 项目详情查询对象
 * @author Administrator
 *
 */
public class PrjDetailQuery{
	
	private int id;
	private int userId;
	private int level;
	private Integer season;
	private Integer year;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public Integer getSeason() {
		return season;
	}
	public void setSeason(Integer season) {
		this.season = season;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	
}
