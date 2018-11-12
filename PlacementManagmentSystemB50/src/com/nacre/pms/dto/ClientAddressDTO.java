package com.nacre.pms.dto;

import java.io.Serializable;
public class ClientAddressDTO implements Serializable {

	private Integer clientAddressId;
	private ClientDTO client;
	private AddressDTO Address;
	private String contactPresonName ;
	private String contactPresonMobileNO ;
	private String contactPresonNameEmail ;
	/**
	 * @return the clientAddressId
	 */
	public Integer getClientAddressId() {
		return clientAddressId;
	}
	/**
	 * @param clientAddressId the clientAddressId to set
	 */
	public void setClientAddressId(Integer clientAddressId) {
		this.clientAddressId = clientAddressId;
	}
	/**
	 * @return the client
	 */
	public ClientDTO getClient() {
		return client;
	}
	/**
	 * @param client the client to set
	 */
	public void setClient(ClientDTO client) {
		this.client = client;
	}
	/**
	 * @return the address
	 */
	public AddressDTO getAddress() {
		return Address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(AddressDTO address) {
		Address = address;
	}
	/**
	 * @return the contactPresonName
	 */
	public String getContactPresonName() {
		return contactPresonName;
	}
	/**
	 * @param contactPresonName the contactPresonName to set
	 */
	public void setContactPresonName(String contactPresonName) {
		this.contactPresonName = contactPresonName;
	}
	/**
	 * @return the contactPresonMobileNO
	 */
	public String getContactPresonMobileNO() {
		return contactPresonMobileNO;
	}
	/**
	 * @param string the contactPresonMobileNO to set
	 */
	public void setContactPresonMobileNO(String string) {
		this.contactPresonMobileNO = string;
	}
	/**
	 * @return the contactPresonNameEmail
	 */
	public String getContactPresonNameEmail() {
		return contactPresonNameEmail;
	}
	/**
	 * @param contactPresonNameEmail the contactPresonNameEmail to set
	 */
	public void setContactPresonNameEmail(String contactPresonNameEmail) {
		this.contactPresonNameEmail = contactPresonNameEmail;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ClientAddressDTO [clientAddressId=" + clientAddressId
				+ ", client=" + client + ", Address=" + Address
				+ ", contactPresonName=" + contactPresonName
				+ ", contactPresonMobileNO=" + contactPresonMobileNO
				+ ", contactPresonNameEmail=" + contactPresonNameEmail + "]";
	}

	

}
