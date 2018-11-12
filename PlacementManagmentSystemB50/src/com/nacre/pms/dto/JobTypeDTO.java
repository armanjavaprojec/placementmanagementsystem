/**
 * 
 */
package com.nacre.pms.dto;

/**
 * @author Chandu
 * @version 1.0.0 2018
 * @author Nacre Batch 50 Java This class contains properties, getters and
 *         settres, toString method
 */
public class JobTypeDTO {

	public JobTypeDTO() {
		// TODO Auto-generated constructor stub
	}
	private Integer jobTypeId;
	private String jobType;
	/**
	 * @return the jobTypeId
	 */
	public Integer getJobTypeId() {
		return jobTypeId;
	}
	/**
	 * @param jobTypeId the jobTypeId to set
	 */
	public void setJobTypeId(Integer jobTypeId) {
		this.jobTypeId = jobTypeId;
	}
	/**
	 * @return the jobType
	 */
	public String getJobType() {
		return jobType;
	}
	/**
	 * @param jobType the jobType to set
	 */
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "JobTypeDTO [jobTypeId=" + jobTypeId + ", jobType=" + jobType
				+ "]";
	}
	
}
