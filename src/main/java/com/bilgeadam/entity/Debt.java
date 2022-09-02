package com.bilgeadam.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Debt {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@JoinColumn(name = "borrow_id", referencedColumnName = "id")
	private Borrow borrow;

	private boolean isPaid;
	@Temporal(TemporalType.DATE)
	private Date paidDate;

	private int delayTime;

	private double amount;

}