package com.nacre.pms.dto;

import java.sql.Date;
/**
 * @author Chandu
 * @version 1.0.0 2018
 * @author Nacre Batch 50 Java This class contains properties, getters and
 *         settres, toString method
 */
public class PlacementDTO {

	
	private Integer placementId;
	private Date selectedDate;
	private Date joiningDate;
	private Float Package;
	private String bond;
	private ClientAddressDTO clientAddress;
	private JobTypeDTO jobType;
	private UserDTO user;
	/**
	 * @return the placementId
	 */
	public Integer getPlacementId() {
		return placementId;
	}
	/**
	 * @param placementId the placementId to set
	 */
	public void setPlacementId(Integer placementId) {
		this.placementId = placementId;
	}
	/**
	 * @return the selectedDate
	 */
	public Date getSelectedDate() {
		return selectedDate;
	}
	/**
	 * @param selectedDate the selectedDate to set
	 */
	public void setSelectedDate(Date selectedDate) {
		this.selectedDate = selectedDate;
	}
	/**
	 * @return the joiningDate
	 */
	public Date getJoiningDate() {
		return joiningDate;
	}
	/**
	 * @param joiningDate the joiningDate to set
	 */
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	/**
	 * @return the package
	 */
	public Float getPackage() {
		return Package;
	}
	/**
	 * @param package1 the package to set
	 */
	public void setPackage(Float package1) {
		Package = package1;
	}
	/**
	 * @return the bond
	 */
	public String getBond() {
		return bond;
	}
	/**
	 * @param bond the bond to set
	 */
	public void setBond(String bond) {
		this.bond = bond;
	}
	/**
	 * @return the clientAddress
	 */
	public ClientAddressDTO getClientAddress() {
		return clientAddress;
	}
	/**
	 * @param clientAddress the clientAddress to set
	 */
	public void setClientAddress(ClientAddressDTO clientAddress) {
		this.clientAddress = clientAddress;
	}
	/**
	 * @return the jobType
	 */
	public JobTypeDTO getJobType() {
		return jobType;
	}
	/**
	 * @param jobType the jobType to set
	 */
	public void setJobType(JobTypeDTO jobType) {
		this.jobType = jobType;
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
		return "PlacementDTO [placementId=" + placementId + ", selectedDate=" + selectedDate + ", joiningDate="
				+ joiningDate + ", Package=" + Package + ", bond=" + bond + ", clientAddress=" + clientAddress
				+ ", jobType=" + jobType + ", user=" + user + "]";
	}
	
	
	
	
	
}
