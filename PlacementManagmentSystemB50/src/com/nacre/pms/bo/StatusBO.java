package com.nacre.pms.bo;

import java.io.Serializable;

/**
 * @author Chandu
 * @version 1.0.0 2018
 * @author Nacre Batch 50 Java This class contains properties, getters and
 *         settres, toString method
 */
public class StatusBO implements Serializable {

	private Integer statusId;
	private String status;
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StatusDTO [statusId=" + statusId + ", status=" + status + "]";
	}

	/**
	 * @return the statusId
	 */
	public Integer getStatusId() {
		return statusId;
	}

	/**
	 * @param statusId the statusId to set
	 */
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	

}
