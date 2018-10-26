package org.zxs.leader.control.dao.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;

@Table(name="area_nn")
public class AreaNn {

	@Id
	@JSONField(ordinal=1)
    private Short id;

	@JSONField(ordinal=2)
	@Column(name="name")
    private String name;
	
	@JSONField(ordinal=3)
	@Column(name="short_name")
    private String shortName;

	@JSONField(ordinal=4)
	@Column(name="level")
    private Byte level;

	@JSONField(ordinal=5)
	@Column(name="nation_code")
    private String nationCode;

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public String getNationCode() {
        return nationCode;
    }

    public void setNationCode(String nationCode) {
        this.nationCode = nationCode == null ? null : nationCode.trim();
    }

}