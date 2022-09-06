package com.bilgeadam.service;

import java.util.Optional;

import com.bilgeadam.entity.Author;
import com.bilgeadam.repository.AuthorRepository;
import com.bilgeadam.utility.MyFactoryRepository;
import com.bilgeadam.utility.MyFactoryService;

public class AuthorService extends MyFactoryService<MyFactoryRepository, Author, Long> {

	private final static AuthorRepository repository = new AuthorRepository();

	public AuthorService() {
		super(new AuthorRepository());
	}

	public Optional<Author> findbyFirstNameAndLastName(String fName, String lName) {

		Optional<Author> author = repository.findbyFirstNameAndLastName(fName, lName);
		if (author.isPresent()) {

			System.out.println("User has been found");

		} else {

			System.out.println("User has not been found");
		}
		return author;

	}

}
