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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ORDER_LINE_OPTION")
public class OrderLineOption {


	@Id
	@Column(name = "ORDER_LINE_OPTION_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;




	@Column(name = "NAME")
	private String name;

	//@OneToMany(cascade = CascadeType.ALL )
	//@JoinColumn(name = "ORDER_LINE_OPTION_ID")
	//private List<OrderLineOptionSpecification> orderLineOptionSpecifications = new ArrayList();

}
