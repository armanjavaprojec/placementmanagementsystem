package com.nacre.pms.bo;

import com.nacre.pms.dto.AddressDTO;
import com.nacre.pms.dto.ClientDTO;

public class ClientAddressBO {

	private Integer clientAddressId;
	private ClientBO client;
	private AddressBO addrs;
	private String contactPresonName;
	private String contactPresonMobileNO;
	private String contactPresonNameEmail;

	public Integer getClientAddressId() {
		return clientAddressId;
	}

	public void setClientAddressId(Integer clientAddressId) {
		this.clientAddressId = clientAddressId;
	}

	public ClientBO getClient() {
		return client;
	}

	public void setClient(ClientBO client) {
		this.client = client;
	}

	public AddressBO getAddrs() {
		return addrs;
	}

	public void setAddrs(AddressBO addrs) {
		this.addrs = addrs;
	}

	public String getContactPresonName() {
		return contactPresonName;
	}

	public void setContactPresonName(String contactPresonName) {
		this.contactPresonName = contactPresonName;
	}

	public String getContactPresonMobileNO() {
		return contactPresonMobileNO;
	}

	public void setContactPresonMobileNO(String contactPresonMobileNO) {
		this.contactPresonMobileNO = contactPresonMobileNO;
	}

	public String getContactPresonNameEmail() {
		return contactPresonNameEmail;
	}

	public void setContactPresonNameEmail(String contactPresonNameEmail) {
		this.contactPresonNameEmail = contactPresonNameEmail;
	}

	@Override
	public String toString() {
		return "ClientAddressBO [clientAddressId=" + clientAddressId + ", client=" + client + ", addrs=" + addrs
				+ ", contactPresonName=" + contactPresonName + ", contactPresonMobileNO=" + contactPresonMobileNO
				+ ", contactPresonNameEmail=" + contactPresonNameEmail + "]";
	}

}
