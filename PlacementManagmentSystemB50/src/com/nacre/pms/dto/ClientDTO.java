package com.nacre.pms.dto;

import java.io.Serializable;
/**
 * @author Chandu
 * @version 1.0.0 2018
 * @author Nacre Batch 50 Java
 * This class contains properties, getters and settres, toString method
 */
public class ClientDTO implements Serializable {

	private Integer clientId;
	private String  clientName;
	private String  clientImage;
	private String clientDescription;
	private LevelDTO companyLevel;
	
	/**
	 * @return the clientId
	 */
	public Integer getClientId() {
		return clientId;
	}
	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}
	/**
	 * @return the clientName
	 */
	public String getClientName() {
		return clientName;
	}
	/**
	 * @param clientName the clientName to set
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	/**
	 * @return the clientImage
	 */
	public String getClientImage() {
		return clientImage;
	}
	/**
	 * @param clientImage the clientImage to set
	 */
	public void setClientImage(String clientImage) {
		this.clientImage = clientImage;
	}
	/**
	 * @return the clientDescription
	 */
	public String getClientDescription() {
		return clientDescription;
	}
	/**
	 * @param clientDescription the clientDescription to set
	 */
	public void setClientDescription(String clientDescription) {
		this.clientDescription = clientDescription;
	}
	/**
	 * @return the companyLevel
	 */
	public LevelDTO getCompanyLevel() {
		return companyLevel;
	}
	/**
	 * @param companyLevel the companyLevel to set
	 */
	public void setCompanyLevel(LevelDTO companyLevel) {
		this.companyLevel = companyLevel;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ClientDTO [clientId=" + clientId + ", clientName=" + clientName
				+ ", clientImage=" + clientImage + ", clientDescription="
				+ clientDescription + ", companyLevel=" + companyLevel + "]";
	}
	
}
