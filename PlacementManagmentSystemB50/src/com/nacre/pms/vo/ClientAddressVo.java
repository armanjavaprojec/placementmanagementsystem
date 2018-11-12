package com.nacre.pms.vo;
 

public class ClientAddressVo {
	private String cno;
	private String clientAddressId;
	private String contactPresonName;
	private String contactPresonMobileNO;
	private String contactPresonNameEmail;
	private String location;
	private String pincode;
	private String country;
	private String state;
	private String city;

	public String getClientAddressId() {
		return clientAddressId;
	}

	public void setClientAddressId(String clientAddressId) {
		this.clientAddressId = clientAddressId;
	}

	public String getContactPresonName() {
		return contactPresonName;
	}

	public void setContactPresonName(String contactPresonName) {
		this.contactPresonName = contactPresonName;
	}

	public String getContactPresonMobileNO() {
		return contactPresonMobileNO;
	}

	public void setContactPresonMobileNO(String contactPresonMobileNO) {
		this.contactPresonMobileNO = contactPresonMobileNO;
	}

	public String getContactPresonNameEmail() {
		return contactPresonNameEmail;
	}

	public void setContactPresonNameEmail(String contactPresonNameEmail) {
		this.contactPresonNameEmail = contactPresonNameEmail;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCno() {
		return cno;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}

	@Override
	public String toString() {
		return "ClientAddressVo [clientAddressId=" + clientAddressId + ", contactPresonName=" + contactPresonName
				+ ", contactPresonMobileNO=" + contactPresonMobileNO + ", contactPresonNameEmail="
				+ contactPresonNameEmail + ", location=" + location + ", pincode=" + pincode + ", country=" + country
				+ ", state=" + state + ", city=" + city + "]";
	}

}
