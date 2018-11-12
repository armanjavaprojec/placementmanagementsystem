package com.nacre.pms.vo;

public class TechnologyVO {
	
	private Integer technologyId;
	private String technology;
	private StatusVO status;
	
	public Integer getTechnologyId() {
		return technologyId;
	}
	public void setTechnologyId(Integer technologyId) {
		this.technologyId = technologyId;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public StatusVO getStatus() {
		return status;
	}
	public void setStatus(StatusVO status) {
		this.status = status;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TechnologyVO [technologyId=" + technologyId + ", technology=" + technology + ", status=" + status
				+ "]";
	}

}
