package com.bilgeadam.controller;

import java.util.Scanner;

import com.bilgeadam.entity.Author;
import com.bilgeadam.entity.Book;
import com.bilgeadam.service.BookService;

public class BookController {

	Scanner scanner = new Scanner(System.in);
	AuthorController authorController = new AuthorController();
	BookService bookService = new BookService();

	public Book createBook() {

		System.out.println("Please enter the title");
		String userName = scanner.nextLine();
		Author bookAuthor = authorController.createAuthor();
		Book book = new Book(userName, bookAuthor);
		return bookService.save(book);
	}

}
