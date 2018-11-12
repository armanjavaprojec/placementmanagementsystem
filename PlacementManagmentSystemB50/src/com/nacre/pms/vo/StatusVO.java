package com.nacre.pms.vo;
import java.io.Serializable;

public class StatusVO {

	private Integer statusId;
	private String status;
	
	public Integer getStatusId() {
		return statusId;
	}
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	
	public String toString() {
		return "StatusVO [statusId=" + statusId + ", status=" + status + "]";
	}

}
