package com.nacre.pms.dto;

import java.io.Serializable;
/**
 * @author Chandu
 * @version 1.0.0 2018
 * @author Nacre Batch 50 Java
 * This class contains properties, getters and settres, toString method
 */
public class FeedbackTypeDTO implements Serializable {

	private Integer feedbackTypeId;
	private String feedbackType;
	/**
	 * @return the feedbackTypeId
	 */
	public Integer getFeedbackTypeId() {
		return feedbackTypeId;
	}
	/**
	 * @param feedbackTypeId the feedbackTypeId to set
	 */
	public void setFeedbackTypeId(Integer feedbackTypeId) {
		this.feedbackTypeId = feedbackTypeId;
	}
	/**
	 * @return the feedbackType
	 */
	public String getFeedbackType() {
		return feedbackType;
	}
	/**
	 * @param feedbackType the feedbackType to set
	 */
	public void setFeedbackType(String feedbackType) {
		this.feedbackType = feedbackType;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FeedbackTypeDTO [feedbackTypeId=" + feedbackTypeId
				+ ", feedbackType=" + feedbackType + "]";
	}
	
}
