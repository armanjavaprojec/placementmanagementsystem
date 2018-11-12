package com.nacre.pms.bo;

import java.io.Serializable;
import java.util.Date;
/**
 * @author Chandu
 * @version 1.0.0 2018
 * @author Nacre Batch 50 Java
 * This class contains properties, getters and settres, toString method
 */
public class BatchBO implements Serializable {

	private Integer batchId ;
	private String batch ;
	private Date batch_start_date;
	private Date batch_end_date;
	private StatusBO status;
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BatchDTO [batchId=" + batchId + ", batch=" + batch + ", batch_start_date=" + batch_start_date
				+ ", batch_end_date=" + batch_end_date + ", status=" + status + "]";
	}
	/**
	 * @return the batchId
	 */
	public Integer getBatchId() {
		return batchId;
	}
	/**
	 * @param batchId the batchId to set
	 */
	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}
	/**
	 * @return the batch
	 */
	public String getBatch() {
		return batch;
	}
	/**
	 * @param batch the batch to set
	 */
	public void setBatch(String batch) {
		this.batch = batch;
	}
	/**
	 * @return the batch_start_date
	 */
	public Date getBatch_start_date() {
		return batch_start_date;
	}
	/**
	 * @param batch_start_date the batch_start_date to set
	 */
	public void setBatch_start_date(Date batch_start_date) {
		this.batch_start_date = batch_start_date;
	}
	/**
	 * @return the batch_end_date
	 */
	public Date getBatch_end_date() {
		return batch_end_date;
	}
	/**
	 * @param batch_end_date the batch_end_date to set
	 */
	public void setBatch_end_date(Date batch_end_date) {
		this.batch_end_date = batch_end_date;
	}
	/**
	 * @return the status
	 */
	public StatusBO getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(StatusBO status) {
		this.status = status;
	}
	

	
	
}
