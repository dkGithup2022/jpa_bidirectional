package com.dk0124.prac;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.dk0124.prac.book.Book;
import com.dk0124.prac.book.BookRepository;
import com.dk0124.prac.shop.Shop;
import com.dk0124.prac.shop.ShopRepository;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

@DataJpaTest
@ExtendWith(SpringExtension.class)
@Slf4j
class ShopTest {

	@Autowired
	ShopRepository shopRepository;

	@Autowired
	BookRepository bookRepository;

	@Autowired
	EntityManager entityManager;

	@Test
	public void 양방향_잇기() {

		// 1 엔티티 생성
		Shop shop = Shop.builder()
			.name("샵")
			.minimumOrderAmount(100L)
			.build();

		Book book = Book.builder()
			.name("책")
			.options(List.of())
			.price(100L)
			.build();

		Shop shop1 = shopRepository.save(shop);
		Book book1 = bookRepository.save(book);

		// 캐시 클리어 & 저장
		entityManager.flush();
		entityManager.clear();

		log.info("\n******** CACHE CLEARED  *******\n");

		// 2) 연관 잇기

		Shop shop2 = shopRepository.findById(shop1.getId()).get();
		Book book2 = bookRepository.findById(book1.getId()).get();

		shop2.addBook(book2);

		// 캐시 클리어 & 저장
		entityManager.flush();
		entityManager.clear();

		log.info("\n******** CACHE CLEARED  *******\n");

		Shop shop3 = shopRepository.findById(shop1.getId()).get();
		Book book3 = bookRepository.findById(book1.getId()).get();

		assertTrue(shop3.getBooks().get(0) == book3);

	}

}