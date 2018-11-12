package com.nacre.pms.bo;

import com.nacre.pms.dto.InterviewRoundDTO;
import com.nacre.pms.dto.StatusDTO;
import com.nacre.pms.dto.UserDTO;

public class EligibleStudentBO {

	private Integer eligibleStudId;
	private InterviewRoundBO round;
	private StatusBO status;
	private UserBO user;
	public Integer getEligibleStudId() {
		return eligibleStudId;
	}
	public void setEligibleStudId(Integer eligibleStudId) {
		this.eligibleStudId = eligibleStudId;
	}
	public InterviewRoundBO getRound() {
		return round;
	}
	public void setRound(InterviewRoundBO round) {
		this.round = round;
	}
	public StatusBO getStatus() {
		return status;
	}
	public void setStatus(StatusBO status) {
		this.status = status;
	}
	public UserBO getUser() {
		return user;
	}
	public void setUser(UserBO user) {
		this.user = user;
	}
	
}
