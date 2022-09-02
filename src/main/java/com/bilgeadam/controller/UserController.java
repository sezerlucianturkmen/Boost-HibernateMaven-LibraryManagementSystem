package com.bilgeadam.controller;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.bilgeadam.entity.User;
import com.bilgeadam.entity.UserInformation;
import com.bilgeadam.service.UserService;

public class UserController {

	UserService userService;
	Scanner scanner = new Scanner(System.in);

	public UserController() {
		this.userService = new UserService();
	}

	public User createUser() {
		System.out.println("Please enter any username");
		String userName = scanner.nextLine();
		System.out.println("Please enter your password");
		String password = scanner.nextLine();

		return userService.save(new User(userName, password));
	}

	public boolean deleteUser() {
		System.out.println("Please enter any user ID that you would like to delete...");
		Long userID = Long.parseLong(scanner.nextLine());
		if (userService.findById(userID).isPresent()) {
			User tempUser = userService.findById(userID).get();
			userService.delete(tempUser);
			System.out.println(
					"The user with " + userID + "-" + tempUser.getUsername() + " ID has been deleted successfully");
			return true;
		} else {
			System.err.println(
					"The user with " + userID + " ID is not exist, please make sure that you enter correct ID");
			return false;
		}
	}

	public boolean updateUser() {
		String oldUsername = null;
		String newPassword1 = null;
		String newPassword2 = null;
		System.out.println("Please enter any user ID that you would like to update...");
		Long userID = Long.parseLong(scanner.nextLine());
		if (userService.findById(userID).isPresent()) {
			User tempUser = userService.findById(userID).get();
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
			userService.save(tempUser);
			System.out.println("The username with " + userID + "has been updated successfully as "
					+ tempUser.getUsername() + " from " + oldUsername);
			return true;
		} else {
			System.err.println(
					"The user with " + userID + " ID is not exist, please make sure that you enter correct ID");
			return false;
		}
	}

	public void showAll() {
		User tempUser = null;
		UserInformation tempUseriforInformation = null;
		List<User> userList = userService.findAll();

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
			System.err.println("You do not have any user in the database");
		}

	}

	public Optional<User> findbyUsernameAndPassword(String username, String password) {

		return userService.findbyUsernameAndPassword(username, password);

	}

}
