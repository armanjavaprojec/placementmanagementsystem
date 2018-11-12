/**
 * 
 */
package com.nacre.pms.dto;

import java.io.Serializable;
import java.sql.Date;
/**
 * @author Chandu
 * @version 1.0.0 2018
 * @author Nacre Batch 50 Java
 * This class contains properties, getters and settres, toString method
 */
public class InterviewRoundDTO implements Serializable {	

	private Integer roundId;
	private Integer roundNo;
	private String description;
	private Date date;
	private JobPostingDTO jobPost;
	private StatusDTO status;
	private AddressDTO address;

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
	public JobPostingDTO getJobPost() {
		return jobPost;
	}
	public void setJobPost(JobPostingDTO jobPost) {
		this.jobPost = jobPost;
	}
	public StatusDTO getStatus() {
		return status;
	}
	public void setStatus(StatusDTO status) {
		this.status = status;
	}
	public AddressDTO getAddress() {
		return address;
	}
	public void setAddress(AddressDTO address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "InterviewRoundDTO [roundId=" + roundId + ", roundNo=" + roundNo + ", description=" + description
				+ ", date=" + date + ", jobPost=" + jobPost + ", status=" + status + ", address=" + address + "]";
	}


}