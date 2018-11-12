package com.nacre.pms.dto;

import java.io.Serializable;
/**
 * @author Chandu
 * @version 1.0.0 2018
 * @author Nacre Batch 50 Java
 * This class contains properties, getters and settres, toString method
 */
public class EducationTypeDTO implements Serializable {

	private Integer graduDetailsId;
	private String graduationType;
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EducationTypeDTO [graduDetailsId=" + graduDetailsId + ", graduationType=" + graduationType + "]";
	}
	/**
	 * @return the graduDetailsId
	 */
	public Integer getGraduDetailsId() {
		return graduDetailsId;
	}
	/**
	 * @param graduDetailsId the graduDetailsId to set
	 */
	public void setGraduDetailsId(Integer graduDetailsId) {
		this.graduDetailsId = graduDetailsId;
	}
	/**
	 * @return the graduationType
	 */
	public String getGraduationType() {
		return graduationType;
	}
	/**
	 * @param graduationType the graduationType to set
	 */
	public void setGraduationType(String graduationType) {
		this.graduationType = graduationType;
	}
	
}
