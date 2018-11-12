package com.nacre.pms.bo;

public class ChangeBean {
	
	private String email;
	private String oldPassword;
	private String newPassword;
	private String conPassword;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getConPassword() {
		return conPassword;
	}
	public void setConPassword(String conPassword) {
		this.conPassword = conPassword;
	}
	@Override
	public String toString() {
		return "ChangeBean [email=" + email + ", oldPassword=" + oldPassword + ", newPassword=" + newPassword
				+ ", conPassword=" + conPassword + "]";
	}
	

}
