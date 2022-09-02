package com.bilgeadam.repository;

import com.bilgeadam.entity.PhoneNumber;
import com.bilgeadam.utility.MyFactoryRepository;

public class PhoneNumberRepository extends MyFactoryRepository<PhoneNumber, Long> {

	public PhoneNumberRepository() {
		super(new PhoneNumber());
	}
}
