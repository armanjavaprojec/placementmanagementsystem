package com.nacre.pms.vo;

import java.io.Serializable;
import java.sql.Date;

import com.nacre.pms.dto.AddressDTO;
import com.nacre.pms.dto.ClientAddressDTO;
import com.nacre.pms.dto.ClientDTO;
import com.nacre.pms.dto.LevelDTO;

public class GetClientDataToHRNotificationVO implements Serializable{


	private Integer clientId;
	private String  clientName;
	private String  clientImage;
	private String clientDescription;
	private LevelDTO companyLevel;
	
	private Integer clientAddressId;
	private AddressDTO Address;
	private String contactPresonName ;
	private String contactPresonMobileNO ;
	private String contactPresonNameEmail ;
	

	private Integer jobPostId;
	private String description;
	private Date expectedDate;
	private Date postDate;
	private Integer vacancies;
	private String location ;
	private String city ;
	private String state;
	private String country ;
	private int countryid;
	
	public int getCountryid() {
		return countryid;
	}
	public void setCountryid(int countryid) {
		this.countryid = countryid;
	}
	/**
	 * @return the clientId
	 */
	public Integer getClientId() {
		return clientId;
	}
	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
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
	/**
	 * @return the clientImage
	 */
	public String getClientImage() {
		return clientImage;
	}
	/**
	 * @param clientImage the clientImage to set
	 */
	public void setClientImage(String clientImage) {
		this.clientImage = clientImage;
	}
	/**
	 * @return the clientDescription
	 */
	public String getClientDescription() {
		return clientDescription;
	}
	/**
	 * @param clientDescription the clientDescription to set
	 */
	public void setClientDescription(String clientDescription) {
		this.clientDescription = clientDescription;
	}
	/**
	 * @return the companyLevel
	 */
	public LevelDTO getCompanyLevel() {
		return companyLevel;
	}
	/**
	 * @param companyLevel the companyLevel to set
	 */
	public void setCompanyLevel(LevelDTO companyLevel) {
		this.companyLevel = companyLevel;
	}

	
	
	

	/**
	 * @return the clientAddressId
	 */
	public Integer getClientAddressId() {
		return clientAddressId;
	}
	/**
	 * @param clientAddressId the clientAddressId to set
	 */
	public void setClientAddressId(Integer clientAddressId) {
		this.clientAddressId = clientAddressId;
	}


	/**
	 * @return the address
	 */
	public AddressDTO getAddress() {
		return Address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(AddressDTO address) {
		Address = address;
	}
	/**
	 * @return the contactPresonName
	 */
	public String getContactPresonName() {
		return contactPresonName;
	}
	/**
	 * @param contactPresonName the contactPresonName to set
	 */
	public void setContactPresonName(String contactPresonName) {
		this.contactPresonName = contactPresonName;
	}
	/**
	 * @return the contactPresonMobileNO
	 */
	public String getContactPresonMobileNO() {
		return contactPresonMobileNO;
	}
	/**
	 * @param string the contactPresonMobileNO to set
	 */
	public void setContactPresonMobileNO(String string) {
		this.contactPresonMobileNO = string;
	}
	/**
	 * @return the contactPresonNameEmail
	 */
	public String getContactPresonNameEmail() {
		return contactPresonNameEmail;
	}
	/**
	 * @param contactPresonNameEmail the contactPresonNameEmail to set
	 */
	public void setContactPresonNameEmail(String contactPresonNameEmail) {
		this.contactPresonNameEmail = contactPresonNameEmail;
	}

	

	/**
	 * @return the jobPostId
	 */
	public Integer getJobPostId() {
		return jobPostId;
	}
	/**
	 * @param jobPostId the jobPostId to set
	 */
	public void setJobPostId(Integer jobPostId) {
		this.jobPostId = jobPostId;
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
	 * @return the expectedDate
	 */
	public Date getExpectedDate() {
		return expectedDate;
	}
	/**
	 * @param expectedDate the expectedDate to set
	 */
	public void setExpectedDate(Date expectedDate) {
		this.expectedDate = expectedDate;
	}
	/**
	 * @return the postDate
	 */
	public Date getPostDate() {
		return postDate;
	}
	/**
	 * @param postDate the postDate to set
	 */
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	/**
	 * @return the vacancies
	 */
	public Integer getVacancies() {
		return vacancies;
	}
	/**
	 * @param vacancies the vacancies to set
	 */
	public void setVacancies(Integer vacancies) {
		this.vacancies = vacancies;
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
	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GetClientDataToHRNotificationVO [clientId=" + clientId + ", clientName=" + clientName + ", clientImage="
				+ clientImage + ", clientDescription=" + clientDescription + ", companyLevel=" + companyLevel
				+ ", clientAddressId=" + clientAddressId + ", Address=" + Address + ", contactPresonName="
				+ contactPresonName + ", contactPresonMobileNO=" + contactPresonMobileNO + ", contactPresonNameEmail="
				+ contactPresonNameEmail + ", jobPostId=" + jobPostId + ", description=" + description
				+ ", expectedDate=" + expectedDate + ", postDate=" + postDate + ", vacancies=" + vacancies + "]";
	}

	
	
	
	
}
