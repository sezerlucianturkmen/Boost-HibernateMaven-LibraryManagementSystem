package com.bilgeadam.main;

import java.util.ArrayList;
import java.util.List;

import com.bilgeadam.entity.Address;
import com.bilgeadam.entity.Employee;
import com.bilgeadam.entity.PhoneNumber;
import com.bilgeadam.entity.UserInformation;
import com.bilgeadam.service.EmployeeService;
import com.bilgeadam.service.StudentService;
import com.bilgeadam.service.UserService;

public class Test {

	public static void main(String[] args) {
//USer oluþturmak için butun iþlemler user uzerinden yapýlacak cascade typelarý ona göre ayarladýk
		UserService userService = new UserService();
		StudentService studentService = new StudentService();
		EmployeeService employeeService = new EmployeeService();

		PhoneNumber phoneNumber = new PhoneNumber("555-555-555");
		PhoneNumber phoneNumber2 = new PhoneNumber("666-666-666");
		List<PhoneNumber> phonesList = new ArrayList<>();
		phonesList.add(phoneNumber2);
		phonesList.add(phoneNumber);

		Address address = new Address("Ankara");
		Address address2 = new Address("Bolu");
		List<Address> addresses = new ArrayList<>();
		addresses.add(address);
		addresses.add(address2);
		UserInformation userInformation = new UserInformation("Merve", "Öztürk", "merve@gmail.com", phonesList,
				addresses);

		// phonenumber ve adress gerekli
//		phoneNumber.setUserInformation(userInformation);// phonenumberlara user ýnformation setleme
//		phoneNumber2.setUserInformation(userInformation);
//
//		address.setUserInformation(userInformation);
//		address2.setUserInformation(userInformation);

		// PhoneNumber phoneNumber3 = new PhoneNumber("555-555-555");
		// PhoneNumber phoneNumber4 = new PhoneNumber("666-666-666");
		// Address address3 = new Address("Ýstanbul");
		// Address address4 = new Address("Ýzmir");
		// List<PhoneNumber> phonesList2 = new ArrayList<>();
		// List<Address> addresses2 = new ArrayList<>();
		// phonesList2.add(phoneNumber4);
		// phonesList2.add(phoneNumber3);
		// addresses2.add(address3);
		// addresses2.add(address4);
		//
		// UserInformation userInformation2 = new UserInformation("Mustafa", "Ozturk",
		// "mustafa@gmail", phonesList2,
		// addresses2);
		Employee user = new Employee("xxx", "123", userInformation);// user

		// Student student = new Student("yyy", "111", userInformation2);
		userInformation.setUser(user);
		// userInformation2.setUser(student);

		userService.save(user);

		// userService.save(student);

		System.out.println(userService.findAll().size());
		// System.out.println(studentService.findAll().size());

	}

}