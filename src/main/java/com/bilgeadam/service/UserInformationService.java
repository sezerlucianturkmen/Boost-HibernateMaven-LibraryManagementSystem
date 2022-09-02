package com.bilgeadam.service;

import com.bilgeadam.entity.UserInformation;
import com.bilgeadam.repository.UserInformationRepository;
import com.bilgeadam.utility.MyFactoryRepository;
import com.bilgeadam.utility.MyFactoryService;

public class UserInformationService extends MyFactoryService<MyFactoryRepository, UserInformation, Long> {

	public UserInformationService() {
		super(new UserInformationRepository());
	}

}
