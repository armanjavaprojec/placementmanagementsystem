package com.nacre.pms.bo;

import java.sql.Date;

import com.nacre.pms.dto.ClientAddressDTO;

public class JobPostingBO {

	private Integer jobPostId;
	private String description;
	private Date expectedDate;
	private Date postDate;
	private Integer vacancies;
	private ClientAddressBO clientaddress;

	public Integer getJobPostId() {
		return jobPostId;
	}
	public void setJobPostId(Integer jobPostId) {
		this.jobPostId = jobPostId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getExpectedDate() {
		return expectedDate;
	}
	public void setExpectedDate(Date expectedDate) {
		this.expectedDate = expectedDate;
	}
	public Date getPostDate() {
		return postDate;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	public Integer getVacancies() {
		return vacancies;
	}
	public void setVacancies(Integer vacancies) {
		this.vacancies = vacancies;
	}
	public ClientAddressBO getClientaddress() {
		return clientaddress;
	}
	public void setClientaddress(ClientAddressBO clientaddress) {
		this.clientaddress = clientaddress;
	}
	@Override
	public String toString() {
		return "JobPostingBO [jobPostId=" + jobPostId + ", description=" + description + ", expectedDate="
				+ expectedDate + ", postDate=" + postDate + ", vacancies=" + vacancies + ", clientaddress="
				+ clientaddress + "]";
	}
	}
