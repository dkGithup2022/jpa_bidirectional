package com.dk0124.prac.shop;

import java.util.ArrayList;
import java.util.List;

import com.dk0124.prac.book.Book;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SHOP")
@NoArgsConstructor
@Getter
public class Shop {

	/**
	 * 양방향 안좋아 하는데 연습용으로 ....
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SHOP_ID")
	private Long id ;

	@Column(name = "name")
	private String name;

	@Column(name = "MINIMUM_ORDER_AMOUNT")
	private Long minimumOrderAmount;

	@OneToMany(mappedBy = "shop")
	private List<Book> books = new ArrayList<>();


	public void addBook(Book book){
		book.changeShop(this);
		this.books.add(book);
	}

	@Builder
	public Shop(Long id, String name, Long minimumOrderAmount, List<Book> books) {
		this.id = id;
		this.name = name;
		this.minimumOrderAmount = minimumOrderAmount;
		this.books = books;
	}
}
