package com.nacre.pms.dto;

import java.io.Serializable;
/**
 * @author Chandu
 * @version 1.0.0 2018
 * @author Nacre Batch 50 Java
 * This class contains properties, getters and settres, toString method
 */
public class EligibleDTO implements Serializable {

	private Integer eligibleStudId;
	private InterviewRoundDTO round;
	private StatusDTO status;
	private UserDTO user;
	/**
	 * @return the eligibleStudId
	 */
	public Integer getEligibleStudId() {
		return eligibleStudId;
	}
	/**
	 * @param eligibleStudId the eligibleStudId to set
	 */
	public void setEligibleStudId(Integer eligibleStudId) {
		this.eligibleStudId = eligibleStudId;
	}
	/**
	 * @return the round
	 */
	public InterviewRoundDTO getRound() {
		return round;
	}
	/**
	 * @param round the round to set
	 */
	public void setRound(InterviewRoundDTO round) {
		this.round = round;
	}
	/**
	 * @return the status
	 */
	public StatusDTO getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(StatusDTO status) {
		this.status = status;
	}
	/**
	 * @return the user
	 */
	public UserDTO getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(UserDTO user) {
		this.user = user;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EligibleDTO [eligibleStudId=" + eligibleStudId + ", round="
				+ round + ", status=" + status + ", user=" + user + "]";
	}
	
}
