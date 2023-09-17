package com.dk0124.prac.book;

import java.util.ArrayList;
import java.util.List;

import com.dk0124.prac.shop.Shop;

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
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "BOOK")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BOOK_ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "PRICE")
	private Long price;

	@ManyToOne
	@JoinColumn(name = "SHOP_ID")
	private Shop shop;


	@OneToMany( cascade = CascadeType.ALL)
	@JoinColumn(name = "BOOK_ID")
	private List<BookOption> options = new ArrayList<>();

	public void changeShop(Shop shop){
		this.shop = shop;
	}

	@Builder
	public Book(Long id, String name, Long price, List<BookOption> options) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.options.addAll(options);
	}
}
