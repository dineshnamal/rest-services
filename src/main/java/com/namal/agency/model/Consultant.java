package com.namal.agency.model;

import java.time.LocalDate;

public class Consultant {
	private Integer id;
	private String userName;
	private String password;
	private String email;
	private LocalDate dateOfBirth;
	
	

	public Consultant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Consultant(Integer id, String userName, String password, String email, LocalDate dateOfBirth) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.id = id;
	}

	@Override
	public String toString() {
		return "Consultant [id=" + id + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", dateOfBirth=" + dateOfBirth + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	
	

}
