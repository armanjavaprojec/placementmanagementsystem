package com.nacre.pms.vo;

import java.sql.Date;

import com.nacre.pms.dto.ClientAddressDTO;
import com.nacre.pms.dto.FeedbackTypeDTO;
import com.nacre.pms.dto.UserDTO;

public class TraineeFeedbackVo {
	// u.first_name,u.mobileno,u.email,
	// f.feedback_description,f.feedback_date,ft.feedback_type,c.client_name
	// ,ct.city,a.location

	private String feedbackId;
	private String feedbackMSG;
	private String date;
	private String clientaddress;
	private String location;
	private String city;
	private String email;
	private String name;
	private String mobno;
	private String clientName;
	private String feedbacktype;
	private String user;
	private String sno;

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(String feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getFeedbackMSG() {
		return feedbackMSG;
	}

	public void setFeedbackMSG(String feedbackMSG) {
		this.feedbackMSG = feedbackMSG;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getClientaddress() {
		return clientaddress;
	}

	public void setClientaddress(String clientaddress) {
		this.clientaddress = clientaddress;
	}

	public String getFeedbacktype() {
		return feedbacktype;
	}

	public void setFeedbacktype(String feedbacktype) {
		this.feedbacktype = feedbacktype;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobno() {
		return mobno;
	}

	public void setMobno(String mobno) {
		this.mobno = mobno;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	@Override
	public String toString() {
		return "TraineeFeedbackVo [feedbackId=" + feedbackId + ", feedbackMSG=" + feedbackMSG + ", date=" + date
				+ ", clientaddress=" + clientaddress + ", location=" + location + ", city=" + city + ", email=" + email
				+ ", name=" + name + ", mobno=" + mobno + ", clientName=" + clientName + ", feedbacktype="
				+ feedbacktype + ", user=" + user + "]";
	}

}
