package com.nacre.pms.bo;

import java.io.Serializable;
import java.util.Date;
/**
 * @author Chandu
 * @version 1.0.0 2018
 * @author Nacre Batch 50 Java
 * This class contains properties, getters and settres, toString method
 */
public class UserBO implements Serializable {
	private Integer userid;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private String mobileNo;
	private Integer gender;
	private String image;
	private Date date;
	private RoleBO role;
	private AddressBO address;
	private StatusBO status;
	private BatchTechnologyBO batchTechnology;
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserDTO [userid=" + userid + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", password=" + password + ", mobileNo=" + mobileNo + ", gender=" + gender + ", image=" + image
				+ ", date=" + date + ", role=" + role + ", address=" + address + ", status=" + status
				+ ", batchTechnology=" + batchTechnology + "]";
	}
	/**
	 * @return the userid
	 */
	public Integer getUserid() {
		return userid;
	}
	/**
	 * @param userid the userid to set
	 */
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}
	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the mobileNo
	 */
	public String getMobileNo() {
		return mobileNo;
	}
	/**
	 * @param string the mobileNo to set
	 */
	public void setMobileNo(String string) {
		this.mobileNo = string;
	}
	/**
	 * @return the gender
	 */
	public Integer getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
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
	 * @return the role
	 */
	public RoleBO getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(RoleBO role) {
		this.role = role;
	}
	/**
	 * @return the address
	 */
	public AddressBO getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(AddressBO address) {
		this.address = address;
	}
	/**
	 * @return the status
	 */
	public StatusBO getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(StatusBO status) {
		this.status = status;
	}
	/**
	 * @return the batchTechnology
	 */
	public BatchTechnologyBO getBatchTechnology() {
		return batchTechnology;
	}
	/**
	 * @param batchTechnology the batchTechnology to set
	 */
	public void setBatchTechnology(BatchTechnologyBO batchTechnology) {
		this.batchTechnology = batchTechnology;
	}
	
	

}
