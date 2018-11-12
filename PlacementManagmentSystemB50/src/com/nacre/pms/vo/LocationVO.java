package com.nacre.pms.vo;

public class LocationVO {
	private String addressId;
	private String address;
	private String pinCode;
	private String city;
	private String state;
	private String country;
	private String clientAddressId;
	
	@Override
	public String toString() {
		return "LocationVO [addressId=" + addressId + ", address=" + address + ", pinCode=" + pinCode + ", city=" + city
				+ ", state=" + state + ", country=" + country + ", clientAddressId=" + clientAddressId + "]";
	}
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getClientAddressId() {
		return clientAddressId;
	}
	public void setClientAddressId(String clientAddressId) {
		this.clientAddressId = clientAddressId;
	}
				
}