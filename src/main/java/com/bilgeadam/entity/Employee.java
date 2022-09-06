package com.bilgeadam.entity;

import javax.persistence.Entity;

@Entity
public class Employee extends User {

	public Employee() {
		super();
		setUserType(UserType.EMPLOYEE);
	}

	public Employee(String username, String password, UserInformation userInformation) {
		super(username, password, userInformation);
		setUserType(UserType.EMPLOYEE);
	}

	public Employee(String username, String password) {
		super(username, password);
		setUserType(UserType.EMPLOYEE);
	}

	@Override
	public String toString() {
		return "Employee [getId()=" + getId() + ", getUsername()=" + getUsername() + ", getPassword()=" + getPassword()
				+ ", getUserInformation()=" + getUserInformation() + ", getUserType()=" + getUserType()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}

}
