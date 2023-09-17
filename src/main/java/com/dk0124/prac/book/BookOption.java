package com.dk0124.prac.book;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "BOOK_OPTION")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BookOption {

	@Id
	@Column(name = "BOOK_OPTION_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "REQUIRED")
	private boolean required;

	@Column(name = "OPTION_NAME")
	private String optionName;

	@OneToMany( cascade = CascadeType.ALL)
	@JoinColumn(name = "BOOK_OPTION_ID")
	private List<BookOptionSpecification> specifications = new ArrayList<>();


	@Builder
	public BookOption(Long id, boolean required, String optionName, List<BookOptionSpecification>specifications) {
		this.id = id;
		this.required = required;
		this.optionName = optionName;
		this.specifications.addAll(specifications);
	}
}
