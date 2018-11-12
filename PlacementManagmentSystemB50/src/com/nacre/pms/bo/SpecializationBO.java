package com.nacre.pms.bo;

public class SpecializationBO {

	private int specializationId;
	private String specialization;
	private StreamBO streamBO;

	public int getSpecializationId() {
		return specializationId;
	}

	public void setSpecializationId(int specializationId) {
		this.specializationId = specializationId;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public StreamBO getStreamBO() {
		return streamBO;
	}

	public void setStreamBO(StreamBO streamBO) {
		this.streamBO = streamBO;
	}

	@Override
	public String toString() {
		return "SpecializationDTO [specializationId=" + specializationId + ", specialization=" + specialization
				+ ", streamDTO=" + streamBO + "]";
	}

}
