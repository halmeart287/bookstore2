package hh.swd20.bookstore2.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bookId;
	private String title, author, isbn;
	private Integer year;
	private Double price;
	
	@ManyToOne
	@JoinColumn(name = "categoryId")
	private Category category;

	public Book() {
		super();
		this.bookId = null;
		this.title = null;
		this.author = null;
		this.isbn = null;
		this.year = 0;
		this.price = 0.00;
		this.category = null;
	}

	public Book(String title, String author, String isbn, Integer year, Double price, Category category) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.year = year;
		this.price = price;
		this.category = category;
	}

	public Book(long bookId, String title, String author, String isbn, Integer year, Double price, Category category) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.year = year;
		this.price = price;
		this.category = category;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		if (this.category != null)
			return "Book [bookId=" + bookId + ", title=" + title + ", author=" + author + ", isbn=" + isbn + ", year=" + year
				+ ", price=" + price + ", category=" + category + "]";
		else
			return "Book [bookId=" + bookId + ", title=" + title + ", author=" + author + ", isbn=" + isbn + ", year=" + year
					+ ", price=" + price + "]";
	}

}
