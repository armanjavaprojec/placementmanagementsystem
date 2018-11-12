package com.nacre.pms.dto;

import java.io.Serializable;
import java.sql.Date;
/**
 * @author Chandu
 * @version 1.0.0 2018
 * @author Nacre Batch 50 Java
 * This class contains properties, getters and settres, toString method
 */
public class FeedbackDTO implements Serializable {

	private Integer feedbackId;
	private String feedbackMSG;
	private Date date;
	private ClientAddressDTO clientaddress;
	private FeedbackTypeDTO feedbacktype;
	private UserDTO user;
	/**
	 * @return the feedbackId
	 */
	public Integer getFeedbackId() {
		return feedbackId;
	}
	/**
	 * @param feedbackId the feedbackId to set
	 */
	public void setFeedbackId(Integer feedbackId) {
		this.feedbackId = feedbackId;
	}
	/**
	 * @return the feedbackMSG
	 */
	public String getFeedbackMSG() {
		return feedbackMSG;
	}
	/**
	 * @param feedbackMSG the feedbackMSG to set
	 */
	public void setFeedbackMSG(String feedbackMSG) {
		this.feedbackMSG = feedbackMSG;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the clientaddress
	 */
	public ClientAddressDTO getClientaddress() {
		return clientaddress;
	}
	/**
	 * @param clientaddress the clientaddress to set
	 */
	public void setClientaddress(ClientAddressDTO clientaddress) {
		this.clientaddress = clientaddress;
	}
	/**
	 * @return the feedbacktype
	 */
	public FeedbackTypeDTO getFeedbacktype() {
		return feedbacktype;
	}
	/**
	 * @param feedbacktype the feedbacktype to set
	 */
	public void setFeedbacktype(FeedbackTypeDTO feedbacktype) {
		this.feedbacktype = feedbacktype;
	}
	/**
	 * @return the user
	 */
	public UserDTO getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(UserDTO user) {
		this.user = user;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FeedbackDTO [feedbackId=" + feedbackId + ", feedbackMSG="
				+ feedbackMSG + ", date=" + date + ", clientaddress="
				+ clientaddress + ", feedbacktype=" + feedbacktype + ", user="
				+ user + "]";
	}
	
}
