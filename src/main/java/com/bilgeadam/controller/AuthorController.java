package com.bilgeadam.controller;

import java.util.Optional;
import java.util.Scanner;

import com.bilgeadam.entity.Author;
import com.bilgeadam.service.AuthorService;

public class AuthorController {

	AuthorService authorService = new AuthorService();
	Scanner scanner = new Scanner(System.in);

	public Author createAuthor() {

		System.out.println("Please enter the author name");
		String authorName = scanner.nextLine();
		System.out.println("Please enter the author surname");
		String authorSurname = scanner.nextLine();

		if (!findbyFirstNameAndLastName(authorName, authorSurname).isEmpty()) {
			System.out.println("Author is alreay exist in the Database");
			return findbyFirstNameAndLastName(authorName, authorSurname).get();
		} else {
			return authorService.save(new Author(authorName, authorSurname));
		}
	}

	public Optional<Author> findbyFirstNameAndLastName(String fName, String lName) {

		return authorService.findbyFirstNameAndLastName(fName, lName);

	}

}
