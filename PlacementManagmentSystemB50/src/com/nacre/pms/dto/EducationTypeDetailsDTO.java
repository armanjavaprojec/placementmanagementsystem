package com.nacre.pms.dto;

public class EducationTypeDetailsDTO {
	private Integer educationTypeDetailsId;
	private Integer educationTypeId;
	private String educationTypeName;
	@Override
	public String toString() {
		return "EducationTypeDetailsDTO [educationTypeDetailsId=" + educationTypeDetailsId + ", educationTypeId="
				+ educationTypeId + ", educationTypeName=" + educationTypeName + "]";
	}
	public Integer getEducationTypeDetailsId() {
		return educationTypeDetailsId;
	}
	public void setEducationTypeDetailsId(Integer educationTypeDetailsId) {
		this.educationTypeDetailsId = educationTypeDetailsId;
	}
	public Integer getEducationTypeId() {
		return educationTypeId;
	}
	public void setEducationTypeId(Integer educationTypeId) {
		this.educationTypeId = educationTypeId;
	}
	public String getEducationTypeName() {
		return educationTypeName;
	}
	public void setEducationTypeName(String educationTypeName) {
		this.educationTypeName = educationTypeName;
	}

}
