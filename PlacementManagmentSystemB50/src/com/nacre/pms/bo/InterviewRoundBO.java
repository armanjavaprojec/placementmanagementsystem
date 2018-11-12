package com.nacre.pms.bo;

import java.sql.Date;

import com.nacre.pms.dto.AddressDTO;
import com.nacre.pms.dto.JobPostingDTO;
import com.nacre.pms.dto.StatusDTO;

public class InterviewRoundBO {

	private Integer roundId;
	private Integer roundNo;
	private String description;
	private Date date;
	private JobPostingBO jobPost;
	private StatusBO status;
	private AddressBO address;
	public Integer getRoundId() {
		return roundId;
	}
	public void setRoundId(Integer roundId) {
		this.roundId = roundId;
	}
	public Integer getRoundNo() {
		return roundNo;
	}
	public void setRoundNo(Integer roundNo) {
		this.roundNo = roundNo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public JobPostingBO getJobPost() {
		return jobPost;
	}
	public void setJobPost(JobPostingBO jobPost) {
		this.jobPost = jobPost;
	}
	public StatusBO getStatus() {
		return status;
	}
	public void setStatus(StatusBO status) {
		this.status = status;
	}
	public AddressBO getAddress() {
		return address;
	}
	public void setAddress(AddressBO address) {
		this.address = address;
	}
}
