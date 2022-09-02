package com.bilgeadam.controller;

import java.util.List;
import java.util.Scanner;

import com.bilgeadam.entity.Student;
import com.bilgeadam.entity.User;
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
		System.out.println("Please enter the username");
		String userName = scanner.nextLine();
		System.out.println("Please enter the password");
		String password = scanner.nextLine();
		Student user = new Student(userName, password);
		UserInformation userInformation = userInformationController.createUserInformation();
		user.setUserInformation(userInformation);
		userInformation.setUser(user);
		return studentService.save(user);

	}

	public boolean deleteUser() {
		System.out.println("Please enter any student ID that you would like to delete...");
		Long userID = Long.parseLong(scanner.nextLine());
		if (studentService.findById(userID).isPresent()) {
			Student tempUser = studentService.findById(userID).get();
			studentService.delete(tempUser);
			System.out.println(
					"The student with " + userID + "-" + tempUser.getUsername() + " ID has been deleted successfully");
			return true;
		} else {
			System.err.println(
					"The student with " + userID + " ID is not exist, please make sure that you enter correct ID");
			return false;
		}
	}

	public boolean updateUser() {
		String oldUsername = null;
		String newPassword1 = null;
		String newPassword2 = null;
		System.out.println("Please enter any student ID that you would like to update...");
		Long userID = Long.parseLong(scanner.nextLine());
		if (studentService.findById(userID).isPresent()) {
			Student tempUser = studentService.findById(userID).get();
			oldUsername = tempUser.getUsername();
			System.out.println("Please enter new username..");
			tempUser.setUsername(scanner.nextLine());

			do {
				System.out.println("Please enter new password..");
				newPassword1 = scanner.nextLine();
				System.out.println("Please enter the password again..");
				newPassword2 = scanner.nextLine();
			} while (newPassword1 != newPassword2);

			tempUser.setPassword(newPassword1);
			studentService.save(tempUser);
			System.out.println("The username with " + userID + "has been updated successfully as "
					+ tempUser.getUsername() + " from " + oldUsername);
			return true;
		} else {
			System.err.println(
					"The student with " + userID + " ID is not exist, please make sure that you enter correct ID");
			return false;
		}
	}

	public void showAll() {
		User tempUser = null;
		UserInformation tempUseriforInformation = null;
		List<Student> userList = studentService.findAll();

		if (!userList.isEmpty()) {
			for (int i = 0; i < userList.size(); i++) {
				tempUser = userList.get(i);
				tempUseriforInformation = tempUser.getUserInformation();
				System.out.println("-------------" + "USER " + (i + 1) + "-------------");
				System.out.println("ID..................:" + tempUser.getId());
				System.out.println("USERNAME............:" + tempUser.getUsername());
				System.out.println("NAME SURNAME........:" + tempUseriforInformation.getName() + " "
						+ tempUseriforInformation.getSurName());
				System.out.println("EMAIL...............:" + tempUseriforInformation.getEmail());
				System.out.println("PHONENUMBERS..........:");
				tempUseriforInformation.getPhoneNumbers().stream().forEach(System.out::println);
				System.out.println("ADDRESSES...........:");
				tempUseriforInformation.getAddress().stream().forEach(System.out::println);
				System.out.println("--------------------------------");
			}
		} else {
			System.err.println("You do not have any student in the database");
		}

	}

}