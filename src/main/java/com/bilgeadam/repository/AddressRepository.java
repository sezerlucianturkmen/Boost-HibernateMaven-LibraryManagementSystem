package com.bilgeadam.repository;

import com.bilgeadam.entity.Address;
import com.bilgeadam.utility.MyFactoryRepository;

public class AddressRepository extends MyFactoryRepository<Address, Long> {

	public AddressRepository() {
		super(new Address());

	}

}