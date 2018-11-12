package com.nacre.pms.vo;

public class PlacedResultVO {
	private String fName;
	private String cName;
	private String location;
	private String jType;
	private String uEmail;
	private String mobile;
	private String joinDate;
	private String bond;
	private String pack;
	
	@Override
	public String toString() {
		return "PlacedResultVO [fName=" + fName + ", cName=" + cName + ", location=" + location + ", jType=" + jType
				+ ", uEmail=" + uEmail + ", mobile=" + mobile + ", joinDate=" + joinDate + ", bond=" + bond + ", pack="
				+ pack + "]";
	}

	
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getjType() {
		return jType;
	}
	public void setjType(String jType) {
		this.jType = jType;
	}
	public String getuEmail() {
		return uEmail;
	}
	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	public String getBond() {
		return bond;
	}
	public void setBond(String bond) {
		this.bond = bond;
	}
	public String getPack() {
		return pack;
	}
	public void setPack(String pack) {
		this.pack = pack;
	}
	
	}
