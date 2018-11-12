package com.nacre.pms.bo;

import java.io.Serializable;
import java.time.LocalDate;

public class EducationalTypeDetailsBO implements Serializable {

	private int educationalTypeDetailsId;
	private float percentage;
	private int yop;
	private EducationTypeBO educationTypeBO;
	private UserBO userBO;
	private SpecializationBO specializationBO;

	public int getEducationalTypeDetailsId() {
		return educationalTypeDetailsId;
	}

	public void setEducationalTypeDetailsId(int educationalTypeDetailsId) {
		this.educationalTypeDetailsId = educationalTypeDetailsId;
	}

	public float getPercentage() {
		return percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

	public int getYop() {
		return yop;
	}

	public void setYop(int yop) {
		this.yop = yop;
	}

	public EducationTypeBO getEducationTypeBO() {
		return educationTypeBO;
	}

	public void setEducationTypeBO(EducationTypeBO educationTypeBO) {
		this.educationTypeBO = educationTypeBO;
	}
	
	public SpecializationBO getSpecializationBO() {
		return specializationBO;
	}

	public void setSpecializationBO(SpecializationBO specializationBO) {
		this.specializationBO = specializationBO;
	}

	public UserBO getUserBO() {
		return userBO;
	}

	public void setUserBO(UserBO userBO) {
		this.userBO = userBO;
	}

	@Override
	public String toString() {
		return "EducationalTypeDetailsBO [educationalTypeDetailsId=" + educationalTypeDetailsId + ", percentage="
				+ percentage + ", yop=" + yop + ", educationTypeBO=" + educationTypeBO + ", userBO=" + userBO
				+ ", specializationBO=" + specializationBO + "]";
	}

}
