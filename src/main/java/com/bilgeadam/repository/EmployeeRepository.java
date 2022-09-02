package com.bilgeadam.repository;

import com.bilgeadam.entity.Employee;
import com.bilgeadam.utility.MyFactoryRepository;

public class EmployeeRepository extends MyFactoryRepository<Employee, Long> {

	public EmployeeRepository() {
		super(new Employee());

	}

}