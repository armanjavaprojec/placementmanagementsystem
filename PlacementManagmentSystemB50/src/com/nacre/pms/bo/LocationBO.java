package com.nacre.pms.bo;

public class LocationBO {
	private int addressId;
	private String address;
	private int pinCode;
	private String city;
	private String state;
	private String country;
	private int clientAddressId;

	@Override
	public String toString() {
		return "LocationBO [addressId=" + addressId + ", address=" + address + ", pinCode=" + pinCode + ", city=" + city
				+ ", state=" + state + ", country=" + country + ", clientAddressId=" + clientAddressId + "]";
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
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

	public int getClientAddressId() {
		return clientAddressId;
	}

	public void setClientAddressId(int clientAddressId) {
		this.clientAddressId = clientAddressId;
	}

		
}