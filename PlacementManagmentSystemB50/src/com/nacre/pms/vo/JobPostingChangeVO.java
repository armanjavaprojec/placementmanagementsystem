package com.nacre.pms.vo;

import java.io.Serializable;
import java.sql.Date;

public class JobPostingChangeVO implements Serializable {

	private String jobPostId;
	private String description;
	private String expectedDate;
	private String postDate;
	private String noOfVacancies;
	private String clientAddressId;

	@Override
	public String toString() {
		return "JobPostingChangeVO [jobPostId=" + jobPostId + ", description=" + description + ", expectedDate="
				+ expectedDate + ", postDate=" + postDate + ", vacancies=" + noOfVacancies + ", clientAddressId="
				+ clientAddressId + "]";
	}

	public String getJobPostId() {
		return jobPostId;
	}

	public void setJobPostId(String jobPostId) {
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
