package com.nacre.pms.bo;

public class UserEducationDetailsBO {
	private Integer userId;
	private Integer eduTypeId;
	private String eduTypeName;
	private Integer streamId;
	private String streamName;
	private Integer specializationId;
	private String specializationName;
	private String percentage;
	private String yop;
	
	@Override
	public String toString() {
		return "UserEducationDetailsBO [userId=" + userId + ", eduTypeId=" + eduTypeId + ", eduTypeName=" + eduTypeName
				+ ", streamId=" + streamId + ", streamName=" + streamName + ", specializationId=" + specializationId
				+ ", specializationName=" + specializationName + ", percentage=" + percentage + ", yop=" + yop + "]";
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getEduTypeId() {
		return eduTypeId;
	}

	public void setEduTypeId(Integer eduTypeId) {
		this.eduTypeId = eduTypeId;
	}

	public String getEduTypeName() {
		return eduTypeName;
	}

	public void setEduTypeName(String eduTypeName) {
		this.eduTypeName = eduTypeName;
	}

	public Integer getStreamId() {
		return streamId;
	}

	public void setStreamId(Integer streamId) {
		this.streamId = streamId;
	}

	public String getStreamName() {
		return streamName;
	}

	public void setStreamName(String streamName) {
		this.streamName = streamName;
	}

	public Integer getSpecializationId() {
		return specializationId;
	}

	public void setSpecializationId(Integer specializationId) {
		this.specializationId = specializationId;
	}

	public String getSpecializationName() {
		return specializationName;
	}

	public void setSpecializationName(String specializationName) {
		this.specializationName = specializationName;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	public String getYop() {
		return yop;
	}

	public void setYop(String yop) {
		this.yop = yop;
	}

}
