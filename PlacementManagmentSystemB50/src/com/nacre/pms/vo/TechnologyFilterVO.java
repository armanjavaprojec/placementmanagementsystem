package com.nacre.pms.vo;

public class TechnologyFilterVO {
	private String techId;
	private String techName;
	
	public String getTechId() {
		return techId;
	}

	public void setTechId(String techId) {
		this.techId = techId;
	}

	public String getTechName() {
		return techName;
	}

	public void setTechName(String techName) {
		this.techName = techName;
	}

	@Override
	public String toString() {
		return "TechnologyFilterVO [techId=" + techId + ", techName=" + techName + "]";
	}
	

}
