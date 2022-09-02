package com.bilgeadam.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class UserInformation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;
	private String surName;
	private String email;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "u_information_id")
	private List<PhoneNumber> phoneNumbers = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "u_information_id")
	private List<Address> address = new ArrayList<>();

	@OneToOne()
	@JoinColumn(name = "user_id", referencedColumnName = "id", unique = true)
	private User user;

	public UserInformation(String name, String surName, String email, List<PhoneNumber> phoneNumbers,
			List<Address> address) {
		super();
		this.name = name;
		this.surName = surName;
		this.email = email;
		this.phoneNumbers = phoneNumbers;
		this.address = address;

	}

	public UserInformation(String name, String surName, String email, User user) {
		super();
		this.name = name;
		this.surName = surName;
		this.email = email;
		this.user = user;
	}

	public UserInformation() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserInformation [id=" + id + ", name=" + name + ", surName=" + surName + ", email=" + email
				+ ", phoneNumbers=" + phoneNumbers + ", address=" + address + ", user=" + user + "]";
	}

}