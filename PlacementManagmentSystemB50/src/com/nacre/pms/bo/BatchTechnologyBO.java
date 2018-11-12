package com.nacre.pms.bo;
/**
 * @author Chandu
 * @version 1.0.0 2018
 * @author Nacre Batch 50 Java
 * This class contains properties, getters and settres, toString method
 */
public class BatchTechnologyBO {

	private int batchTechnologyId;
	private BatchBO batch;
	private TechnologyBO technology;
	@Override
	public String toString() {
		return "BatchTechnologyBO [batchTechnologyId=" + batchTechnologyId + ", batch=" + batch + ", technology="
				+ technology + "]";
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
	public BatchBO getBatch() {
		return batch;
	}
	/**
	 * @param batch the batch to set
	 */
	public void setBatch(BatchBO batch) {
		this.batch = batch;
	}
	/**
	 * @return the technology
	 */
	public TechnologyBO getTechnology() {
		return technology;
	}
	/**
	 * @param technology the technology to set
	 */
	public void setTechnology(TechnologyBO technology) {
		this.technology = technology;
	}
	
	
}
