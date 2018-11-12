package com.nacre.pms.dto;

public class SpecializationDTO {
	private Integer specializationDetaisId;
	private Integer specializationId;
	private String specialization;
	private StreamDTO objStreamDTO;
	public Integer getSpecializationDetaisId() {
		return specializationDetaisId;
	}
	public void setSpecializationDetaisId(Integer specializationDetaisId) {
		this.specializationDetaisId = specializationDetaisId;
	}
	public Integer getSpecializationId() {
		return specializationId;
	}
	public void setSpecializationId(Integer specializationId) {
		this.specializationId = specializationId;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public StreamDTO getObjStreamDTO() {
		return objStreamDTO;
	}
	public void setObjStreamDTO(StreamDTO objStreamDTO) {
		this.objStreamDTO = objStreamDTO;
	}
	@Override
	public String toString() {
		return "SpecializationDTO [specializationDetaisId=" + specializationDetaisId + ", specializationId="
				+ specializationId + ", specialization=" + specialization + ", objStreamDTO=" + objStreamDTO + "]";
	}
	
	
}
