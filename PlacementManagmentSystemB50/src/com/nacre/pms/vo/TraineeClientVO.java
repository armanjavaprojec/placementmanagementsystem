package com.nacre.pms.vo;

import com.nacre.pms.dto.ClientAddressDTO;
import com.nacre.pms.dto.ClientDTO;

public class TraineeClientVO {
	
		private String expectedDate;
		private String vacancies;
		private Integer jobPostId;
		public Integer getJobPostId() {
			return jobPostId;
		}


		public void setJobPostId(Integer jobPostId) {
			this.jobPostId = jobPostId;
		}


		private String  clientName;
		private String clientDescription;
		
		
		private String contactPresonName ;
		private String contactPresonMobileNO ;
		private String contactPresonNameEmail ;
		
		private String firstname;
		private String lastname;
		
		private Integer pincode ;
		private String location ;
		//private CityDTO city ;
		private String city;
		private String description;
		private String state;
		private int countryid;
		public int getCountryid() {
			return countryid;
		}


		public void setCountryid(int countryid) {
			this.countryid = countryid;
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


		private String country;
		
		
		

		private ClientDTO client;
		private ClientAddressDTO clientAddress;

		
		
		public ClientDTO getClient() {
			return client;
		}


		public void setClient(ClientDTO client) {
			this.client = client;
		}


		public ClientAddressDTO getClientAddress() {
			return clientAddress;
		}


		public void setClientAddress(ClientAddressDTO clientAddress) {
			this.clientAddress = clientAddress;
		}



		
		
		
		
		public String getExpectedDate() {
			return expectedDate;
		}


		public void setExpectedDate(String expectedDate) {
			this.expectedDate = expectedDate;
		}


		public String getVacancies() {
			return vacancies;
		}


		public void setVacancies(String vacancies) {
			this.vacancies = vacancies;
		}


		public String getClientName() {
			return clientName;
		}


		public void setClientName(String clientName) {
			this.clientName = clientName;
		}


		public String getClientDescription() {
			return clientDescription;
		}


		public void setClientDescription(String clientDescription) {
			this.clientDescription = clientDescription;
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


		public String getFirstname() {
			return firstname;
		}


		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}


		public String getLastname() {
			return lastname;
		}


		public void setLastname(String lastname) {
			this.lastname = lastname;
		}


		public Integer getPincode() {
			return pincode;
		}


		public void setPincode(Integer integer) {
			this.pincode = integer;
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


		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
		}


		@Override
		public String toString() {
			return "TraineeVO [expectedDate=" + expectedDate + ", vacancies=" + vacancies + ", clientName=" + clientName
					+ ", clientDescription=" + clientDescription + ", contactPresonName=" + contactPresonName
					+ ", contactPresonMobileNO=" + contactPresonMobileNO + ", contactPresonNameEmail="
					+ contactPresonNameEmail + ", firstname=" + firstname + ", lastname=" + lastname + ", pincode="
					+ pincode + ", location=" + location + ", city=" + city + ", description=" + description + "]";
		}
		
		
	}



