package com.nacre.pms.bo;

import java.io.Serializable;
/**
 * @author Chandu
 * @version 1.0.0 2018
 * @author Nacre Batch 50 Java
 * This class contains properties, getters and settres, toString method
 */
public class CityBO implements Serializable {

	private Integer cityId ;
	private String city ;
	private StateBO state ;


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
	public StateBO getState() {
		return state;
	}


	/**
	 * @param state the state to set
	 */
	public void setState(StateBO state) {
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
