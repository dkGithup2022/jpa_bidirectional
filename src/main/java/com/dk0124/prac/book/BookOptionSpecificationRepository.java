package com.dk0124.prac.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dk0124.prac.book.BookOptionSpecification;

@Repository
public interface BookOptionSpecificationRepository extends JpaRepository<BookOptionSpecification, Long> {
}
