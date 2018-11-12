package com.nacre.pms.dto;

import java.io.Serializable;
import java.sql.Date;
/**
 * @author Chandu
 * @version 1.0.0 2018
 * @author Nacre Batch 50 Java
 * This class contains properties, getters and settres, toString method
 */
public class JobPostingDTO implements Serializable {

	private Integer jobPostId;
	private String description;
	private Date expectedDate;
	private Date postDate;
	private Integer vacancies;
	private ClientAddressDTO clientaddress;
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "JobPostingDTO [jobPostId=" + jobPostId + ", description=" + description + ", expectedDate="
				+ expectedDate + ", postDate=" + postDate + ", vacancies=" + vacancies + ", clientaddress="
				+ clientaddress + "]";
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
	 * @return the clientaddress
	 */
	public ClientAddressDTO getClientaddress() {
		return clientaddress;
	}
	/**
	 * @param clientaddress the clientaddress to set
	 */
	public void setClientaddress(ClientAddressDTO clientaddress) {
		this.clientaddress = clientaddress;
	}
	

	
}
