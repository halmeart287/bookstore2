package hh.swd20.bookstore2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.bookstore2.domain.Book;
import hh.swd20.bookstore2.domain.BookRepository;

@SpringBootApplication
public class Bookstore2Application {
	
	private static final Logger log = LoggerFactory.getLogger(Bookstore2Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Bookstore2Application.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepository) {
		return (args) -> {
			log.info("save a few books");
			bookRepository.save(new Book("Taru Sormusten Herrasta", "J.R.R. Tolkien", "123-123-123AB", 1982, 59.99));
			bookRepository.save(new Book("Mateki - The Magic Flute", "Yoshitaka Amano", "321-321-321BA", 1999, 79.49));
			
			log.info("fetch all books");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}
		};
	}

}
