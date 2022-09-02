package com.bilgeadam.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

@Entity
public class Student extends User {

	@Enumerated(EnumType.STRING)
	private UserType userType = UserType.STUDENT;

	@OneToMany(mappedBy = "student")

	List<Borrow> borrows = new ArrayList<>();

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String username, String password, UserInformation userInformation) {
		super(username, password, userInformation);
		// TODO Auto-generated constructor stub
	}

	public Student(String username, String password) {
		super(username, password);
		// TODO Auto-generated constructor stub
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public List<Borrow> getBorrows() {
		return borrows;
	}

	public void setBorrows(List<Borrow> borrows) {
		this.borrows = borrows;
	}

	@Override
	public String toString() {
		return "Student [getId()=" + getId() + ", getUsername()=" + getUsername() + ", getPassword()=" + getPassword()
				+ "]";
	}

}