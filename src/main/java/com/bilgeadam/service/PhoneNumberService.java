package com.bilgeadam.service;

import com.bilgeadam.entity.PhoneNumber;
import com.bilgeadam.repository.PhoneNumberRepository;
import com.bilgeadam.utility.MyFactoryRepository;
import com.bilgeadam.utility.MyFactoryService;

public class PhoneNumberService extends MyFactoryService<MyFactoryRepository, PhoneNumber, Long> {

	public PhoneNumberService() {
		super(new PhoneNumberRepository());
	}

}
