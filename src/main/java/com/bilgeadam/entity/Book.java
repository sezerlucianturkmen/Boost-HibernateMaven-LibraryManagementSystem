package com.bilgeadam.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	String title;

	@ManyToOne
	Author author;

	@OneToMany(mappedBy = "book")
	List<Borrow> borrows;

	boolean isBorrowed;

	public Book(String title, Author author, List<Borrow> borrows, boolean isBorrowed) {
		super();
		this.title = title;
		this.author = author;
		this.borrows = borrows;
		this.isBorrowed = isBorrowed;
	}

	public Book() {
		super();
		this.isBorrowed = false;
	}

	public Book(String title, Author author) {
		super();
		this.title = title;
		this.author = author;
		this.isBorrowed = false;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public List<Borrow> getBorrows() {
		return borrows;
	}

	public void setBorrows(List<Borrow> borrows) {
		this.borrows = borrows;
	}

	public boolean isBorrowed() {
		return isBorrowed;
	}

	public void setBorrowed(boolean isBorrowed) {
		this.isBorrowed = isBorrowed;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", borrows=" + borrows + ", isBorrowed="
				+ isBorrowed + "]";
	}

}