package com.bilgeadam.service;

import com.bilgeadam.entity.Student;
import com.bilgeadam.repository.StudentRepository;
import com.bilgeadam.utility.MyFactoryRepository;
import com.bilgeadam.utility.MyFactoryService;

public class StudentService extends MyFactoryService<MyFactoryRepository, Student, Long> {

	public StudentService() {
		super(new StudentRepository());
	}

}
