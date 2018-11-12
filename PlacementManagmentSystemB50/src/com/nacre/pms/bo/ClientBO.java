package com.nacre.pms.bo;

public class ClientBO {
	private int clientId;
	private String clientName;
	private String clientImage;
	private String clientDescription;
	private String personName;
	private long personMobile;
	private String personEmail;
	private String location;
	private int pincode;
	private String country;
	private String state;
	private String city;
	private String level;
	private LevelBO companyLevel;
	private String status;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getClientName() {
		return clientName;
	}
	public LevelBO getCompanyLevel() {
		return companyLevel;
	}
	public void setCompanyLevel(LevelBO companyLevel) {
		this.companyLevel = companyLevel;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientImage() {
		return clientImage;
	}
	public void setClientImage(String clientImage) {
		this.clientImage = clientImage;
	}
	public String getClientDescription() {
		return clientDescription;
	}
	public void setClientDescription(String clientDescription) {
		this.clientDescription = clientDescription;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getPersonEmail() {
		return personEmail;
	}
	public void setPersonEmail(String personEmail) {
		this.personEmail = personEmail;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
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
	public long getPersonMobile() {
		return personMobile;
	}
	public void setPersonMobile(long personMobile) {
		this.personMobile = personMobile;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	@Override
	public String toString() {
		return "ClientBO [clientId=" + clientId + ", clientName=" + clientName + ", clientImage=" + clientImage
				+ ", clientDescription=" + clientDescription + ", personName=" + personName + ", personMobile="
				+ personMobile + ", personEmail=" + personEmail + ", location=" + location + ", pincode=" + pincode
				+ ", country=" + country + ", state=" + state + ", city=" + city + ", level=" + level + ", status="
				+ status + "]";
	}
}