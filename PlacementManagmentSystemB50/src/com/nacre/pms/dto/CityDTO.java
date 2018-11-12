package com.nacre.pms.dto;

import java.io.Serializable;
/**
 * @author Chandu
 * @version 1.0.0 2018
 * @author Nacre Batch 50 Java
 * This class contains properties, getters and settres, toString method
 */
public class CityDTO implements Serializable {

	private Integer cityId ;
	private String city ;
	private StateDTO state ;


	/**
	 * @return the cityId
	 */
	public Integer getCityId() {
		return cityId;
	}

	/**
	 * @param cityId the cityId to set
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}


	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}


	/**
	 * @return the state
	 */
	public StateDTO getState() {
		return state;
	}


	/**
	 * @param state the state to set
	 */
	public void setState(StateDTO state) {
		this.state = state;
	}	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CityDTO [cityId=" + cityId + ", city=" + city + ", state=" + state + "]";
	}

}
