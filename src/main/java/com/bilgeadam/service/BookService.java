package com.bilgeadam.service;

import com.bilgeadam.entity.Book;
import com.bilgeadam.repository.BookRepository;
import com.bilgeadam.utility.MyFactoryRepository;
import com.bilgeadam.utility.MyFactoryService;

public class BookService extends MyFactoryService<MyFactoryRepository, Book, Long> {

	public BookService() {
		super(new BookRepository());
	}

}
