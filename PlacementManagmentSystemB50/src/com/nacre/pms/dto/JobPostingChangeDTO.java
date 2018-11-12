package com.nacre.pms.dto;

import java.io.Serializable;
import java.util.Date;

public class JobPostingChangeDTO implements Serializable {

	private int jobPostId;
	private String description;
	private String expectedDate;
	private String postDate;
	private int noOfVacancies;
	private int clientAddressId;
	
	@Override
	public String toString() {
		return "JobPostingChangeDTO [jobPostId=" + jobPostId + ", description=" + description + ", expectedDate="
				+ expectedDate + ", postDate=" + postDate + ", noOfVacancies=" + noOfVacancies + ", clientAddressId="
				+ clientAddressId + "]";
	}
	
	public int getJobPostId() {
		return jobPostId;
	}
	public void setJobPostId(int jobPostId) {
		this.jobPostId = jobPostId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getExpectedDate() {
		return expectedDate;
	}
	public void setExpectedDate(String expectedDate) {
		this.expectedDate = expectedDate;
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
