package com.nacre.pms.dto;

import java.io.Serializable;

/**
 * @author Chandu
 * @version 1.0.0 2018
 * @author Nacre Batch 50 Java This class contains properties, getters and
 *         settres, toString method
 */
public class TechnologyDTO implements Serializable {

	private Integer technologyId;
	private String technology;
	private StatusDTO status;

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
	 * @return the technologyId
	 */
	public Integer getTechnologyId() {
		return technologyId;
	}

	/**
	 * @param technologyId the technologyId to set
	 */
	public void setTechnologyId(Integer technologyId) {
		this.technologyId = technologyId;
	}

	/**
	 * @return the technology
	 */
	public String getTechnology() {
		return technology;
	}

	/**
	 * @param technology the technology to set
	 */
	public void setTechnology(String technology) {
		this.technology = technology;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TechnologyDTO [technologyId=" + technologyId + ", technology=" + technology + ", status=" + status
				+ "]";
	}

}
