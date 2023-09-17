package com.dk0124.prac;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.dk0124.prac.book.Book;
import com.dk0124.prac.book.BookOption;
import com.dk0124.prac.book.BookOptionSpecification;
import com.dk0124.prac.book.BookRepository;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Transactional
@Slf4j
class BookDomainTest {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private EntityManager entityManager;

	@Test
	public void buildEntity() {
		assertNotNull(buildSampleBook());
	}

	@Test
	public void saveBook(){
		bookRepository.save(buildSampleBook());
	}

	@Test
	public void lazyLoading(){
		// 저장하고 캐시 비우기
		Long id  = bookRepository.save(buildSampleBook()).getId();
		entityManager.flush(); // 동기화
		entityManager.clear(); // 캐시 삭제

		log.info("\n*******************************READ BEGIN *****************************\n ");
		Book book = bookRepository.findById(id).orElseThrow(()-> new  NoSuchElementException("데이터 못찾음"));

		List<BookOption> options = book.getOptions();
		log.info("*************************************************** ");

		List<BookOptionSpecification> specs = options.get(0).getSpecifications();

		log.info("*************************************************** ");

		log.info(specs.get(0).getName());

	}


	private Book buildSampleBook(){
		return 	Book.builder()
			.name("오브젝트")
			.price(10000L)
			.options(
				List.of(
					BookOption.builder()
						.optionName("버전")
						.required(true)
						.specifications(
							List.of(
								BookOptionSpecification.builder()
									.name("3")
									.priceChangeAmount(0L)
									.build(),
								BookOptionSpecification.builder()
									.name("2")
									.priceChangeAmount(0L)
									.build(),
								BookOptionSpecification.builder()
									.name("1")
									.priceChangeAmount(0L)
									.build()
							)
						)
						.build(),

					BookOption.builder()
						.optionName("분철")
						.required(true)
						.specifications(
							List.of(
								BookOptionSpecification.builder()
									.name("2개로 분철")
									.priceChangeAmount(2000L)
									.build(),
								BookOptionSpecification.builder()
									.name("분철없음")
									.priceChangeAmount(0L)
									.build()
							)
						)
						.build()
				)
			)
			.build();
	}
}