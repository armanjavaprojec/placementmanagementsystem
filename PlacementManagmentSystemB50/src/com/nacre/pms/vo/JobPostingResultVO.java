package com.nacre.pms.vo;

import java.io.Serializable;

public class JobPostingResultVO implements Serializable{
	private String jobPostingId;
	private String clientName;
	private String location;
	private String cpName;
	private String cpMobile;
	private String cpEmail;
	private String description;
	private String expDate;
	private String postDate;
	private String noOfVacancies;
	private String clientAddressId;

	@Override
	public String toString() {
		return "JobPostingResultVO [jobPostingId=" + jobPostingId + ", clientName=" + clientName + ", location="
				+ location + ", cpName=" + cpName + ", cpMobile=" + cpMobile + ", cpEmail=" + cpEmail + ", description="
				+ description + ", expDate=" + expDate + ", postDate=" + postDate + ", noOfVacancies=" + noOfVacancies
				+ ", clientAddressId=" + clientAddressId + "]";
	}

	public String getJobPostingId() {
		return jobPostingId;
	}
	public void setJobPostingId(String jobPostingId) {
		this.jobPostingId = jobPostingId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCpName() {
		return cpName;
	}
	public void setCpName(String cpName) {
		this.cpName = cpName;
	}
	public String getCpMobile() {
		return cpMobile;
	}
	public void setCpMobile(String cpMobile) {
		this.cpMobile = cpMobile;
	}
	public String getCpEmail() {
		return cpEmail;
	}
	public void setCpEmail(String cpEmail) {
		this.cpEmail = cpEmail;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	public String getPostDate() {
		return postDate;
	}
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}
	public String getNoOfVacancies() {
		return noOfVacancies;
	}
	public void setNoOfVacancies(String noOfVacancies) {
		this.noOfVacancies = noOfVacancies;
	}
	public String getClientAddressId() {
		return clientAddressId;
	}
	public void setClientAddressId(String clientAddressId) {
		this.clientAddressId = clientAddressId;
	}
	
}
