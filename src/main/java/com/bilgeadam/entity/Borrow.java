package com.bilgeadam.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Borrow {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@Temporal(TemporalType.DATE)
	Date borrowDate;

	@ManyToOne
	Student student;

	@ManyToOne(cascade = CascadeType.MERGE)
	Book book;

	@Temporal(TemporalType.DATE)
	Date retunDate;

	@Enumerated(EnumType.STRING)
	DelayStatus delayStatus;

	public Borrow(Date borrowDate, Student student, Book book, Date retunDate) {
		super();
		this.borrowDate = borrowDate;
		this.student = student;
		this.book = book;
		this.retunDate = retunDate;
	}

	public Borrow(Date borrowDate, Student student, Book book, Date retunDate, DelayStatus delayStatus) {
		super();
		this.borrowDate = borrowDate;
		this.student = student;
		this.book = book;
		this.retunDate = retunDate;
		this.delayStatus = delayStatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Date getRetunDate() {
		return retunDate;
	}

	public void setRetunDate(Date retunDate) {
		this.retunDate = retunDate;
	}

	public DelayStatus getDelayStatus() {
		return delayStatus;
	}

	public void setDelayStatus(DelayStatus delayStatus) {
		this.delayStatus = delayStatus;
	}

	@Override
	public String toString() {
		return "Borrow [id=" + id + ", borrowDate=" + borrowDate + ", student=" + student + ", book=" + book
				+ ", retunDate=" + retunDate + "delayStatus" + delayStatus + "]";
	}

}