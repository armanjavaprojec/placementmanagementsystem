package com.nacre.pms.bo;
import java.io.Serializable;
/**
 * @author Chandu
 * @version 1.0.0 2018
 * @author Nacre Batch 50 Java
 * This class contains properties, getters and settres, toString method
 */
public class AddressBO implements Serializable {

	private Integer addressId ;
	private Integer pincode ;
	private String location ;
	private CityBO city ;
	
	
	@Override
	public String toString() {
		return "AddressDTO [addressId=" + addressId + ", pincode=" + pincode + ", location=" + location + ", city="
				+ city + "]";
	}
	/**
	 * @return the addressId
	 */
	public Integer getAddressId() {
		return addressId;
	}
	/**
	 * @param addressId the addressId to set
	 */
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	
	/**
	 * @return the city
	 */
	public CityBO getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(CityBO city) {
		this.city = city;
	}	
	/**
	 * @return the pincode
	 */
	public Integer getPincode() {
		return pincode;
	}
	/**
	 * @param integer the pincode to set
	 */
	public void setPincode(Integer integer) {
		this.pincode = integer;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
}
