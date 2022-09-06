package com.bilgeadam.controller;

import java.util.Scanner;

import com.bilgeadam.entity.Employee;
import com.bilgeadam.entity.UserInformation;
import com.bilgeadam.service.EmployeeService;

public class EmployeeController {

	EmployeeService employeeService;
	Scanner scanner = new Scanner(System.in);
	UserInformationController userInformationController;

	public EmployeeController() {
		// TODO Auto-generated constructor stub
		this.userInformationController = new UserInformationController();
		this.employeeService = new EmployeeService();
	}

	public Employee createEmployee() {
		System.out.println("Enter your username");
		String userName = scanner.nextLine();
		System.out.println("Enter your password");
		String password = scanner.nextLine();
		Employee user = new Employee(userName, password);
		UserInformation userInformation = userInformationController.createUserInformation();
		user.setUserInformation(userInformation);
		userInformation.setUser(user);
		return employeeService.save(user);

	}

}
