package com.bilgeadam.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Employee extends User {

	@Enumerated(EnumType.STRING)
	private UserType userType = UserType.EMPLOYEE;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String username, String password, UserInformation userInformation) {
		super(username, password, userInformation);
		// TODO Auto-generated constructor stub
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "Employee [getId()=" + getId() + ", getUsername()=" + getUsername() + ", getPassword()=" + getPassword()
				+ "]";
	}

}
