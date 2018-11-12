package com.nacre.pms.dto;
/**
 * @author Rama
 * @version 1.0.0 2018
 * @author Nacre Batch 50 Java
 * This class contains properties, getters and settres, toString method
 */

public class EducationalTypeDetailsDTO {

	private int educationalTypeDetailsId;
	private float percentage;
	private int yop;
	private EducationTypeDTO educationTypeDTO;
	private UserDTO userDTO;
	private SpecializationDTO specializationDTO;
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EducationalTypeDetailsDTO [educationalTypeDetailsId=" + educationalTypeDetailsId + ", percentage="
				+ percentage + ", yop=" + yop + ", educationTypeDTO=" + educationTypeDTO + ", userDTO=" + userDTO
				+ ", specializationDTO=" + specializationDTO + "]";
	}

	/**
	 * @return the specializationDTO
	 */
	public SpecializationDTO getSpecializationDTO() {
		return specializationDTO;
	}

	/**
	 * @param specializationDTO the specializationDTO to set
	 */
	public void setSpecializationDTO(SpecializationDTO specializationDTO) {
		this.specializationDTO = specializationDTO;
	}
	/**
	 * @return the educationalTypeDetailsId
	 */
	public int getEducationalTypeDetailsId() {
		return educationalTypeDetailsId;
	}

	/**
	 * @param educationalTypeDetailsId the educationalTypeDetailsId to set
	 */
	public void setEducationalTypeDetailsId(int educationalTypeDetailsId) {
		this.educationalTypeDetailsId = educationalTypeDetailsId;
	}
	/**
	 * @return the percentage
	 */
	public float getPercentage() {
		return percentage;
	}

	/**
	 * @param percentage the percentage to set
	 */
	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

	/**
	 * @return the EducationType
	 */
	public EducationTypeDTO getEducationTypeDTO() {
		return educationTypeDTO;
	}

	/**
	 * @param educationTypeDTO the educationTypeDTO to set
	 */
	public void setEducationTypeDTO(EducationTypeDTO educationTypeDTO) {
		this.educationTypeDTO = educationTypeDTO;
	}
	/**
	 * @return the userDTO
	 */
	public UserDTO getUserDTO() {
		return userDTO;
	}

	/**
	 * @param userDTO the userDTO to set
	 */
	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}
	
	/**
	 * @return the yop
	 */
	public int getYop() {
		return yop;
	}

	/**
	 * @param yop the yop to set
	 */
	public void setYop(int yop) {
		this.yop = yop;
	}

	
}
