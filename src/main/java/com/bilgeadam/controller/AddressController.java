package com.bilgeadam.controller;

import java.util.Scanner;

import com.bilgeadam.entity.Address;
import com.bilgeadam.service.AddressService;

public class AddressController {

	AddressService addressService;
	Scanner scanner = new Scanner(System.in);

	public AddressController() {
		this.addressService = new AddressService();
	}

	public Address createAddress() {

		System.out.println("Please enter your address");
		String address = scanner.nextLine();
		return addressService.save(new Address(address));
	}

}