package org.zxs.leader.control.dao.model.vo.output;

import java.io.Serializable;

public class VAqiRealtimeCity implements Serializable{
	private static final long serialVersionUID = 8352414161180635932L;

	private Integer errorCode;
	private String errorMsg;
    private String displayName;
    private String apiDate;
    private Integer areaId;
    private Integer epNum;
    private String epName;
    private Double so21h;
    private Double so224h;
    private Double no21h;
    private Double no224h;
    private Double co1h;
    private Double co24h;
    private Double o31h;
    private Double o3124h;
    private Double o38h;
    private Double o3824h;
    private Double pm101h;
    private Double pm1024h;
    private Double pm251h;
    private Double pm2524h;
    private Integer aqi;
    private String quality;
    
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getApiDate() {
		return apiDate;
	}
	public void setApiDate(String apiDate) {
		this.apiDate = apiDate;
	}
	public Integer getAreaId() {
		return areaId;
	}
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	public Integer getEpNum() {
		return epNum;
	}
	public void setEpNum(Integer epNum) {
		this.epNum = epNum;
	}
	public String getEpName() {
		return epName;
	}
	public void setEpName(String epName) {
		this.epName = epName;
	}
	public Double getSo21h() {
		return so21h;
	}
	public void setSo21h(Double so21h) {
		this.so21h = so21h;
	}
	public Double getSo224h() {
		return so224h;
	}
	public void setSo224h(Double so224h) {
		this.so224h = so224h;
	}
	public Double getNo21h() {
		return no21h;
	}
	public void setNo21h(Double no21h) {
		this.no21h = no21h;
	}
	public Double getNo224h() {
		return no224h;
	}
	public void setNo224h(Double no224h) {
		this.no224h = no224h;
	}
	public Double getCo1h() {
		return co1h;
	}
	public void setCo1h(Double co1h) {
		this.co1h = co1h;
	}
	public Double getCo24h() {
		return co24h;
	}
	public void setCo24h(Double co24h) {
		this.co24h = co24h;
	}
	public Double getO31h() {
		return o31h;
	}
	public void setO31h(Double o31h) {
		this.o31h = o31h;
	}
	public Double getO3124h() {
		return o3124h;
	}
	public void setO3124h(Double o3124h) {
		this.o3124h = o3124h;
	}
	public Double getO38h() {
		return o38h;
	}
	public void setO38h(Double o38h) {
		this.o38h = o38h;
	}
	public Double getO3824h() {
		return o3824h;
	}
	public void setO3824h(Double o3824h) {
		this.o3824h = o3824h;
	}
	public Double getPm101h() {
		return pm101h;
	}
	public void setPm101h(Double pm101h) {
		this.pm101h = pm101h;
	}
	public Double getPm1024h() {
		return pm1024h;
	}
	public void setPm1024h(Double pm1024h) {
		this.pm1024h = pm1024h;
	}
	public Double getPm251h() {
		return pm251h;
	}
	public void setPm251h(Double pm251h) {
		this.pm251h = pm251h;
	}
	public Double getPm2524h() {
		return pm2524h;
	}
	public void setPm2524h(Double pm2524h) {
		this.pm2524h = pm2524h;
	}
	public Integer getAqi() {
		return aqi;
	}
	public void setAqi(Integer aqi) {
		this.aqi = aqi;
	}
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	public Integer getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public VAqiRealtimeCity() {
		super();
	}
	public VAqiRealtimeCity(String displayName, String apiDate, Integer areaId, Integer epNum, String epName,
			Double so21h, Double so224h, Double no21h, Double no224h, Double co1h, Double co24h, Double o31h,
			Double o3124h, Double o38h, Double o3824h, Double pm101h, Double pm1024h, Double pm251h, Double pm2524h,
			Integer aqi, String quality) {
		super();
		this.displayName = displayName;
		this.apiDate = apiDate;
		this.areaId = areaId;
		this.epNum = epNum;
		this.epName = epName;
		this.so21h = so21h;
		this.so224h = so224h;
		this.no21h = no21h;
		this.no224h = no224h;
		this.co1h = co1h;
		this.co24h = co24h;
		this.o31h = o31h;
		this.o3124h = o3124h;
		this.o38h = o38h;
		this.o3824h = o3824h;
		this.pm101h = pm101h;
		this.pm1024h = pm1024h;
		this.pm251h = pm251h;
		this.pm2524h = pm2524h;
		this.aqi = aqi;
		this.quality = quality;
	}
    
}
