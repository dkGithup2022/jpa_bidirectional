package com.dk0124.prac.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookOptionRepository extends JpaRepository<BookOption, Long> {
}
