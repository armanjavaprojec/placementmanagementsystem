package com.nacre.pms.bo;

import java.sql.Date;

public class TraineeBO {
	private int userId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private long mobno;
	private int gender;
	private String image;
	private Date dob;
	private String batchName;
	private String technology;
	private int sscYop;
	private float sscPercentage;
	private int hseYop;
	private float hsePercentage;
	private int graduationYop;
	private float graduationPercentage;
	private String graduationStream;
	private String graduationSpecialization;
	private int postGraduationYop;
	private float postGraduationPercentage;
	private String postGraduationStream;
	private String postGraduationSpecialization;
	private String location;
	private int pincode;
	private String city;
	private String state;
	private String country;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getMobno() {
		return mobno;
	}

	public void setMobno(long mobno) {
		this.mobno = mobno;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getSscYop() {
		return sscYop;
	}

	public void setSscYop(int sscYop) {
		this.sscYop = sscYop;
	}

	public float getSscPercentage() {
		return sscPercentage;
	}

	public void setSscPercentage(float sscPercentage) {
		this.sscPercentage = sscPercentage;
	}

	public String getGraduationSpecialization() {
		return graduationSpecialization;
	}

	public void setGraduationSpecialization(String graduationSpecialization) {
		this.graduationSpecialization = graduationSpecialization;
	}

	public String getPostGraduationSpecialization() {
		return postGraduationSpecialization;
	}

	public void setPostGraduationSpecialization(String postGraduationSpecialization) {
		this.postGraduationSpecialization = postGraduationSpecialization;
	}

	public int getHseYop() {
		return hseYop;
	}

	public void setHseYop(int hseYop) {
		this.hseYop = hseYop;
	}

	public float getHsePercentage() {
		return hsePercentage;
	}

	public void setHsePercentage(float hsePercentage) {
		this.hsePercentage = hsePercentage;
	}

	public int getGraduationYop() {
		return graduationYop;
	}

	public void setGraduationYop(int graduationYop) {
		this.graduationYop = graduationYop;
	}

	public float getGraduationPercentage() {
		return graduationPercentage;
	}

	public void setGraduationPercentage(float graduationPercentage) {
		this.graduationPercentage = graduationPercentage;
	}

	public String getGraduationStream() {
		return graduationStream;
	}

	public void setGraduationStream(String graduationStream) {
		this.graduationStream = graduationStream;
	}

	public int getPostGraduationYop() {
		return postGraduationYop;
	}

	public void setPostGraduationYop(int postGraduationYop) {
		this.postGraduationYop = postGraduationYop;
	}

	public float getPostGraduationPercentage() {
		return postGraduationPercentage;
	}

	public void setPostGraduationPercentage(float postGraduationPercentage) {
		this.postGraduationPercentage = postGraduationPercentage;
	}

	public String getPostGraduationStream() {
		return postGraduationStream;
	}

	public void setPostGraduationStream(String postGraduationStream) {
		this.postGraduationStream = postGraduationStream;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "TraineeBO [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", password=" + password + ", mobno=" + mobno + ", gender=" + gender + ", image=" + image
				+ ", dob=" + dob + ", batchName=" + batchName + ", technology=" + technology + ", sscYop=" + sscYop
				+ ", sscPercentage=" + sscPercentage + ", hseYop=" + hseYop + ", hsePercentage=" + hsePercentage
				+ ", graduationYop=" + graduationYop + ", graduationPercentage=" + graduationPercentage
				+ ", graduationStream=" + graduationStream + ", graduationSpecialization=" + graduationSpecialization
				+ ", postGraduationYop=" + postGraduationYop + ", postGraduationPercentage=" + postGraduationPercentage
				+ ", postGraduationStream=" + postGraduationStream + ", postGraduationSpecialization="
				+ postGraduationSpecialization + ", location=" + location + ", pincode=" + pincode + ", city=" + city
				+ ", state=" + state + ", country=" + country + "]";
	}

}
