package hh.swd20.bookstore2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.bookstore2.domain.Book;
import hh.swd20.bookstore2.domain.BookRepository;
import hh.swd20.bookstore2.domain.Category;
import hh.swd20.bookstore2.domain.CategoryRepository;

@SpringBootApplication
public class Bookstore2Application {

	private static final Logger log = LoggerFactory.getLogger(Bookstore2Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Bookstore2Application.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (args) -> {
			log.info("save a few books and categories");
			
			categoryRepository.save(new Category("Sci-Fi"));
			categoryRepository.save(new Category("Fantasy"));
			categoryRepository.save(new Category("Artistic"));
			
			bookRepository.save(new Book("Taru Sormusten Herrasta", "J.R.R. Tolkien", "123-123-123AB", 1982, 59.99, categoryRepository.findByName("Fantasy").get(0)));
			bookRepository.save(new Book("Mateki - The Magic Flute", "Yoshitaka Amano", "321-321-321BA", 1999, 79.49, categoryRepository.findByName("Artistic").get(0)));

			log.info("fetch all books");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}
			
			log.info("fetch all categories");
			for (Category category : categoryRepository.findAll()) {
				log.info(category.toString());
			}
		};
	}

	/*@Bean
	*public CommandLineRunner categoryDemo(CategoryRepository categoryRepository) {
	*	return (args) -> {
	*		log.info("save some categories");
	*		categoryRepository.save(new Category("Sci-Fi"));
	*		categoryRepository.save(new Category("Fantasy"));
	*		categoryRepository.save(new Category("Artistic"));
	*
	*		log.info("fetch all categories");
	*		for (Category category : categoryRepository.findAll()) {
	*			log.info(category.toString());
	*		}
	*	};
	*
	*}
	*/
}