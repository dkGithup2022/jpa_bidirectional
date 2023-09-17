package com.dk0124.prac.order;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table(name = "ORDER_LINE_OPTION_SPECIFICATION")
public class OrderLineOptionSpecification {

	@Id
	@Column(name = "ORDER_LINE_OPTION_SPECIFICATION_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NAME")
	private String name;
}
