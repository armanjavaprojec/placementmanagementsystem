package com.nacre.pms.bo;

import java.io.Serializable;
import java.util.Date;

public class JobPostingResultBO implements Serializable{
	private int jobPostingId;
	private String clientName;
	private String location;
	private String cpName;
	private long cpMobile;
	private String cpEmail;
	private String description;
	private String expDate;
	private String postDate;
	private int noOfVacancies;
	private int clientAddressId;

	@Override
	public String toString() {
		return "JobPostingResultBO [jobPostingId=" + jobPostingId + ", clientName=" + clientName + ", location="
				+ location + ", cpName=" + cpName + ", cpMobile=" + cpMobile + ", cpEmail=" + cpEmail + ", description="
				+ description + ", expDate=" + expDate + ", postDate=" + postDate + ", noOfVacancies=" + noOfVacancies
				+ ", clientAddressId=" + clientAddressId + "]";
	}
	public int getJobPostingId() {
		return jobPostingId;
	}
	public void setJobPostingId(int jobPostingId) {
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
	public long getCpMobile() {
		return cpMobile;
	}
	public void setCpMobile(long cpMobile) {
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
	public int getNoOfVacancies() {
		return noOfVacancies;
	}
	public void setNoOfVacancies(int noOfVacancies) {
		this.noOfVacancies = noOfVacancies;
	}
	public int getClientAddressId() {
		return clientAddressId;
	}
	public void setClientAddressId(int clientAddressId) {
		this.clientAddressId = clientAddressId;
	}
	
	
}
