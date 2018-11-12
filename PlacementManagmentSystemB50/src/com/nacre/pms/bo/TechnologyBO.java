package com.nacre.pms.bo;

import java.io.Serializable;

/**
 * @author Chandu
 * @version 1.0.0 2018
 * @author Nacre Batch 50 Java This class contains properties, getters and
 *         settres, toString method
 */
public class TechnologyBO implements Serializable {

	private Integer technologyId;
	private String technology;
	private StatusBO status;

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
