package com.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * SysplDistrict entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class SysplDistrict implements java.io.Serializable {

	private static final long serialVersionUID = 1000000L;
	// Fields

	private Long districtId;
	private SysplDistrict sysplDistrict;
	private String districtName;
	private String districtCode;
	private String districtPostal;
	private String districtTelcode;
	private String districtLevel;
	private String memo;
	private String status;
	private String creator;
	private Date createDate;
	private String wqlb;
	private String zslb;
	private String jtlb;
	private String zflb;
	private String qnlb;
	private String sxh;
	private String currency;
	private String rank;
//	private Set sysplDistricts = new HashSet(0);
	
	private Long upDistrictId;
	private String upDistrictName;
	// Constructors
	
	/** default constructor */
	public SysplDistrict() {
	}

	/** minimal constructor */
	public SysplDistrict(Long districtId, String status) {
		this.districtId = districtId;
		this.status = status;
	}
	/** full constructor */
	public SysplDistrict(Long districtId, SysplDistrict sysplDistrict,
			String districtName, String districtCode, String districtPostal,
			String districtTelcode, String districtLevel, String memo,
			String status, String creator, Date createDate, String wqlb,
			String zslb, String jtlb, String zflb, String qnlb, String sxh,
			String currency, Set sysplDistricts, Long upDistrictId,
			String upDistrictName,String rank) {
		super();
		this.districtId = districtId;
		this.sysplDistrict = sysplDistrict;
		this.districtName = districtName;
		this.districtCode = districtCode;
		this.districtPostal = districtPostal;
		this.districtTelcode = districtTelcode;
		this.districtLevel = districtLevel;
		this.memo = memo;
		this.status = status;
		this.creator = creator;
		this.createDate = createDate;
		this.wqlb = wqlb;
		this.zslb = zslb;
		this.jtlb = jtlb;
		this.zflb = zflb;
		this.qnlb = qnlb;
		this.sxh = sxh;
		this.currency = currency;
//		this.sysplDistricts = sysplDistricts;
		this.upDistrictId = upDistrictId;
		this.upDistrictName = upDistrictName;
		this.rank = rank;
	}
	
	// Property accessors
	
	
	
	public Long getDistrictId() {
		return this.districtId;
	}

	public String getRank()
    {
        return rank;
    }

    public void setRank(String rank)
    {
        this.rank = rank;
    }

    public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}

	public SysplDistrict getSysplDistrict() {
		return this.sysplDistrict;
	}

	public void setSysplDistrict(SysplDistrict sysplDistrict) {
		this.sysplDistrict = sysplDistrict;
	}

	public String getDistrictName() {
		return this.districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getDistrictCode() {
		return this.districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public String getDistrictPostal() {
		return this.districtPostal;
	}

	public void setDistrictPostal(String districtPostal) {
		this.districtPostal = districtPostal;
	}

	public String getDistrictTelcode() {
		return this.districtTelcode;
	}

	public void setDistrictTelcode(String districtTelcode) {
		this.districtTelcode = districtTelcode;
	}

	public String getDistrictLevel() {
		return this.districtLevel;
	}

	public void setDistrictLevel(String districtLevel) {
		this.districtLevel = districtLevel;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreator() {
		return this.creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

//	public Set getSysplDistricts() {
//		return this.sysplDistricts;
//	}
//
//	public void setSysplDistricts(Set sysplDistricts) {
//		this.sysplDistricts = sysplDistricts;
//	}

	public Long getUpDistrictId() {
		return upDistrictId;
	}

	public void setUpDistrictId(Long upDistrictId) {
		this.upDistrictId = upDistrictId;
	}

	public String getUpDistrictName() {
		return upDistrictName;
	}

	public void setUpDistrictName(String upDistrictName) {
		this.upDistrictName = upDistrictName;
	}
	
	public boolean equals(Object obj){
		if(this.getClass() != obj.getClass())return false;
		SysplDistrict sysplDistrict = (SysplDistrict)obj;
		if(sysplDistrict.getDistrictId().longValue() ==
			this.getDistrictId().longValue()){
			return true;
		}else{
			return false;
		}
	}

	public String getWqlb() {
		return wqlb;
	}

	public void setWqlb(String wqlb) {
		this.wqlb = wqlb;
	}

	public String getZslb() {
		return zslb;
	}

	public void setZslb(String zslb) {
		this.zslb = zslb;
	}

	public String getJtlb() {
		return jtlb;
	}

	public void setJtlb(String jtlb) {
		this.jtlb = jtlb;
	}

	public String getZflb() {
		return zflb;
	}

	public void setZflb(String zflb) {
		this.zflb = zflb;
	}

	public String getQnlb() {
		return qnlb;
	}

	public void setQnlb(String qnlb) {
		this.qnlb = qnlb;
	}

	public String getSxh() {
		return sxh;
	}

	public void setSxh(String sxh) {
		this.sxh = sxh;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	private String districtNameEN;

	public String getDistrictNameEN() {
		return districtNameEN;
	}

	public void setDistrictNameEN(String districtNameEN) {
		this.districtNameEN = districtNameEN;
	}
}