package com.bilgeadam.service;

import com.bilgeadam.entity.Address;
import com.bilgeadam.repository.AddressRepository;
import com.bilgeadam.utility.MyFactoryRepository;
import com.bilgeadam.utility.MyFactoryService;

public class AddressService extends MyFactoryService<MyFactoryRepository, Address, Long> {

	public AddressService() {
		super(new AddressRepository());
	}

}
