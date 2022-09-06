package com.bilgeadam.main;

import com.bilgeadam.controller.EmployeeController;
import com.bilgeadam.controller.StudentController;
import com.bilgeadam.controller.UserController;

public class Test2 {

	public static void main(String[] args) {

		UserController userController = new UserController();
		StudentController studentController = new StudentController();
		EmployeeController employeeController = new EmployeeController();

		// studentController.createStudent();
		employeeController.createEmployee();

	}

}