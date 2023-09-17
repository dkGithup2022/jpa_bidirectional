package com.dk0124.prac.book;

import com.dk0124.prac.book.BookOption;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "BOOK_OPTION_SPECIFICATION")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BookOptionSpecification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BOOK_OPTION_SPECIFICATION_ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "PRICE_CHANGE_AMOUNT")
	private Long priceChangeAmount;

	@Builder
	public BookOptionSpecification(Long id, BookOption bookOption, String name, Long priceChangeAmount) {
		this.id = id;
		this.name = name;
		this.priceChangeAmount = priceChangeAmount;
	}


}
