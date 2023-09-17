package com.dk0124.prac.order;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ORDER_LINE")
public class OrderLine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORDER_LINE_ID")
	private Long id;


	@Column(name = "AMOUNT")
	private int amount;

	@Column(name = "BOOK_NAME")
	private String bookName;

	@OneToMany(cascade =  CascadeType.ALL)
	@JoinColumn(name = "ORDER_LINE_ID")
	private List<OrderLineOption> options = new ArrayList();

}
