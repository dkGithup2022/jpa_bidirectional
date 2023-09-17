package com.dk0124.prac.order;

import com.dk0124.prac.book.Book;
import com.dk0124.prac.book.BookOption;

public interface ValidateOrder {

	boolean validate(Book book, Order order);

	boolean haveRequiredOption(BookOption bookOption, OrderLine orderLine);

}
