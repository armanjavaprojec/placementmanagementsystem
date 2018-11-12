package com.nacre.pms.vo;

import java.sql.Date;

public class ShowRoundDataTOTraineeVO {
   
	private Integer roundNo;
	private String description;
	private Date date;
	private String pincode ;
	private String location ;
	private String city ;
	private String state;
	private String country ;
	private String  clientName;
	private int job_post_id;
	private int not_status_id;
	
	public int getNot_status_id() {
		return not_status_id;
	}
	public void setNot_status_id(int not_status_id) {
		this.not_status_id = not_status_id;
	}
	public int getJob_post_id() {
		return job_post_id;
	}
	public void setJob_post_id(int job_post_id) {
		this.job_post_id = job_post_id;
	}
	/**
	 * @return the roundNo
	 */
	public Integer getRoundNo() {
		return roundNo;
	}
	/**
	 * @param roundNo the roundNo to set
	 */
	public void setRoundNo(Integer roundNo) {
		this.roundNo = roundNo;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	
	/**
	 * @return the pincode
	 */
	public String getPincode() {
		return pincode;
	}
	/**
	 * @param pincode the pincode to set
	 */
	public void setPincode(String pincode) {
		this.pincode = pincode;
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
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the clientName
	 */
	public String getClientName() {
		return clientName;
	}
	/**
	 * @param clientName the clientName to set
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	@Override
	public String toString() {
		return "ShowRoundDataTOTraineeVO [roundNo=" + roundNo + ", description=" + description + ", date=" + date
				+ ", pincode=" + pincode + ", location=" + location + ", city=" + city + ", state=" + state
				+ ", country=" + country + ", clientName=" + clientName + ", job_post_id=" + job_post_id
				+ ", not_status_id=" + not_status_id + "]";
	}
	
	
}
