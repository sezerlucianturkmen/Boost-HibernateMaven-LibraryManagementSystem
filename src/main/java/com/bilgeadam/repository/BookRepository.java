package com.bilgeadam.repository;

import java.awt.print.Book;

import com.bilgeadam.utility.MyFactoryRepository;

public class BookRepository extends MyFactoryRepository<Book, Long> {

	public BookRepository() {
		super(new Book());

	}

}