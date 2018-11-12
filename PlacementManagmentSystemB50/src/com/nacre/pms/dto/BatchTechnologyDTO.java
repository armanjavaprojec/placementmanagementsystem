package com.nacre.pms.dto;
/**
 * @author Chandu
 * @version 1.0.0 2018
 * @author Nacre Batch 50 Java
 * This class contains properties, getters and settres, toString method
 */
public class BatchTechnologyDTO {

	private int batchTechnologyId;
	private BatchDTO batch;
	private TechnologyDTO technology;
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BatchTechnologyDTO [batchTechnologyId=" + batchTechnologyId + ", batch=" + batch + "]";
	}
	/**
	 * @return the batchTechnologyId
	 */
	public int getBatchTechnologyId() {
		return batchTechnologyId;
	}
	/**
	 * @param batchTechnologyId the batchTechnologyId to set
	 */
	public void setBatchTechnologyId(int batchTechnologyId) {
		this.batchTechnologyId = batchTechnologyId;
	}
	/**
	 * @return the batch
	 */
	public BatchDTO getBatch() {
		return batch;
	}
	/**
	 * @param batch the batch to set
	 */
	public void setBatch(BatchDTO batch) {
		this.batch = batch;
	}
	/**
	 * @return the technology
	 */
	public TechnologyDTO getTechnology() {
		return technology;
	}
	/**
	 * @param technology the technology to set
	 */
	public void setTechnology(TechnologyDTO technology) {
		this.technology = technology;
	}
	
	
}
