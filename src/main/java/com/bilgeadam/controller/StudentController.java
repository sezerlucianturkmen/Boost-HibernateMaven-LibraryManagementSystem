package com.bilgeadam.controller;

import java.util.Scanner;

import com.bilgeadam.entity.Student;
import com.bilgeadam.entity.UserInformation;
import com.bilgeadam.service.StudentService;

public class StudentController {

	StudentService studentService;
	Scanner scanner = new Scanner(System.in);
	UserInformationController userInformationController;

	public StudentController() {
		// TODO Auto-generated constructor stub
		this.userInformationController = new UserInformationController();
		this.studentService = new StudentService();

	}

	public Student createStudent() {
		System.out.println("Lütfen kullanýcý isminizi giriniz");
		String userName = scanner.nextLine();
		System.out.println("Lütfen þifrenizi giriniz");
		String password = scanner.nextLine();
		Student user = new Student(userName, password);
		UserInformation userInformation = userInformationController.createUserInformation();
		user.setUserInformation(userInformation);
		userInformation.setUser(user);
		return studentService.save(user);

	}

}