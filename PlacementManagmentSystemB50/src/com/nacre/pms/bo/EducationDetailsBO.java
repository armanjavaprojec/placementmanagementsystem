package com.nacre.pms.bo;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
/**
 * @author Chandu
 * @version 1.0.0 2018
 * @author Nacre Batch 50 Java
 * This class contains properties, getters and settres, toString method
 */


public class EducationDetailsBO implements Serializable {

	private int educationalDetailsId;
	List<EducationalTypeDetailsBO> educationalTypeDetailsBOList;
	private UserBO userBO;

	@Override
	public String toString() {
		return "EducationDetailsDTO [educationalDetailsId=" + educationalDetailsId + ", educationalTypeDetailsDTOList="
				+ educationalTypeDetailsBOList + ", userBO=" + userBO + "]";
	}

	public int getEducationalDetailsId() {
		return educationalDetailsId;
	}

	public void setEducationalDetailsId(int educationalDetailsId) {
		this.educationalDetailsId = educationalDetailsId;
	}

	public List<EducationalTypeDetailsBO> getEducationalTypeDetailsBOList() {
		return educationalTypeDetailsBOList;
	}

	public void setEducationalTypeDetailsBOList(List<EducationalTypeDetailsBO> educationalTypeDetailsBOList) {
		this.educationalTypeDetailsBOList = educationalTypeDetailsBOList;
	}

	public UserBO getUserBO() {
		return userBO;
	}

	public void setUserBO(UserBO userBO) {
		this.userBO = userBO;
	}

	public static void main(String[] args) {

		EducationDetailsBO educationDetailsBO = new EducationDetailsBO();
		List<EducationalTypeDetailsBO> educationalTypeDetailsBOList = educationDetailsBO.getEducationalTypeDetailsBOList();
		EducationalTypeDetailsBO matric = educationalTypeDetailsBOList.get(0);
		EducationalTypeDetailsBO twelve = educationalTypeDetailsBOList.get(1);
		EducationalTypeDetailsBO gradution = educationalTypeDetailsBOList.get(2);
		EducationalTypeDetailsBO pg = educationalTypeDetailsBOList.get(3);

		String str = matric.getEducationTypeBO().getGraduationType();

		if (pg != null) {

		}

	}

}
