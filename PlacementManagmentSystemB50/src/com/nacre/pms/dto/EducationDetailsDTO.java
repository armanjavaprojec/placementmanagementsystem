package com.nacre.pms.dto;

import java.io.Serializable;
import java.sql.Date;
/**
 * @author Chandu
 * @version 1.0.0 2018
 * @author Nacre Batch 50 Java
 * This class contains properties, getters and settres, toString method
 */
import java.util.List;

/**
 * @author Chandu
 * @version 1.0.0 2018
 * @author Nacre Batch 50 Java
 * This class contains properties, getters and settres, toString method
 */
public class EducationDetailsDTO implements Serializable {

	private Integer graduDetailsId;
	private String percentGrade;
	private String yearOfPass;
	private UserDTO user;
	private EducationTypeDTO educationType;
	private SpecializationDTO objSpecializationDTO;
	public Integer getGraduDetailsId() {
		return graduDetailsId;
	}
	public void setGraduDetailsId(Integer graduDetailsId) {
		this.graduDetailsId = graduDetailsId;
	}
	public String getPercentGrade() {
		return percentGrade;
	}
	public void setPercentGrade(String percentGrade) {
		this.percentGrade = percentGrade;
	}
	
	private int educationalDetailsId;
	List<EducationalTypeDetailsDTO> educationalTypeDetailsDTOList;
	private UserDTO userDTO;


	/**
	 * @return the educationalDetailsId
	 */
	public int getEducationalDetailsId() {
		return educationalDetailsId;
	}

	/**
	 * @param educationalDetailsId the educationalDetailsId to set
	 */
	public void setEducationalDetailsId(int educationalDetailsId) {
		this.educationalDetailsId = educationalDetailsId;
	}

	/**
	 * @return the educationalTypeDetailsDTOList
	 */
	public List<EducationalTypeDetailsDTO> getEducationalTypeDetailsDTOList() {
		return educationalTypeDetailsDTOList;
	}

	/**
	 * @param educationalTypeDetailsDTOList the educationalTypeDetailsDTOList to set
	 */
	public void setEducationalTypeDetailsDTOList(List<EducationalTypeDetailsDTO> educationalTypeDetailsDTOList) {
		this.educationalTypeDetailsDTOList = educationalTypeDetailsDTOList;
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

	public static void main(String[] args) {

		EducationDetailsDTO educationDetailsDTO = new EducationDetailsDTO();
		List<EducationalTypeDetailsDTO> educationalTypeDetailsDTOList = educationDetailsDTO
				.getEducationalTypeDetailsDTOList();
		EducationalTypeDetailsDTO matric = educationalTypeDetailsDTOList.get(0);
		EducationalTypeDetailsDTO twelve = educationalTypeDetailsDTOList.get(1);
		EducationalTypeDetailsDTO gradution = educationalTypeDetailsDTOList.get(2);
		EducationalTypeDetailsDTO pg = educationalTypeDetailsDTOList.get(3);

		String str = matric.getEducationTypeDTO().getGraduationType();

		if (pg != null) {

		}

	}

	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
	}
	public EducationTypeDTO getEducationType() {
		return educationType;
	}
	public void setEducationType(EducationTypeDTO educationType) {
		this.educationType = educationType;
	}
	public SpecializationDTO getObjSpecializationDTO() {
		return objSpecializationDTO;
	}
	public void setObjSpecializationDTO(SpecializationDTO objSpecializationDTO) {
		this.objSpecializationDTO = objSpecializationDTO;
	}
	public String getYearOfPass() {
		return yearOfPass;
	}
	public void setYearOfPass(String yearOfPass) {
		this.yearOfPass = yearOfPass;
	}
	@Override
	public String toString() {
		return "EducationDetailsDTO [graduDetailsId=" + graduDetailsId + ", percentGrade=" + percentGrade
				+ ", yearOfPass=" + yearOfPass + ", user=" + user + ", educationType=" + educationType
				+ ", objSpecializationDTO=" + objSpecializationDTO + "]";
	}
	
	
}
