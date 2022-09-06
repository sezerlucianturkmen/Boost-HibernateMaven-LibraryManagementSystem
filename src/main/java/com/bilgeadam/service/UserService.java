package com.bilgeadam.service;

import java.util.Optional;

import com.bilgeadam.entity.User;
import com.bilgeadam.repository.UserRepository;
import com.bilgeadam.utility.MyFactoryRepository;
import com.bilgeadam.utility.MyFactoryService;

public class UserService extends MyFactoryService<MyFactoryRepository, User, Long> {

	private final static UserRepository repository = new UserRepository();

	public UserService() {

		super(repository);

	}

	public Optional<User> findbyUsernameAndPassword(String username, String password) {

		Optional<User> user = repository.findbyUsernameAndPassword(username, password);
		if (user.isPresent()) {

			System.out.println("User has been found");

		} else {

			System.out.println("User has not been found");
		}
		return user;
	}

}