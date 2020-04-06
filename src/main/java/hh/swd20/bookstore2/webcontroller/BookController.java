package hh.swd20.bookstore2.webcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.bookstore2.domain.Book;
import hh.swd20.bookstore2.domain.BookRepository;
import hh.swd20.bookstore2.domain.CategoryRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String getBookstoreIndex(Model model) {
		return "index";
	}
	
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public String getBooks(Model model) {
		List<Book> books = (List<Book>) bookRepository.findAll();
		model.addAttribute("books", books);
		return "books";
	}
	
	@RequestMapping(value = "/addbook", method = RequestMethod.GET)
	public String getBookForm(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", categoryRepository.findAll());
		return "addbook";
	}

	@RequestMapping(value = "/savebook", method = RequestMethod.POST)
	public String saveBook(Book book) {
		bookRepository.save(book);
		return "redirect:/books";
	}
	
	@RequestMapping(value = "/deletebook/{bookId}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("bookId") Long bookId) {
		bookRepository.deleteById(bookId);
		return "redirect:../books";
	}
	
	@RequestMapping(value = "/editbook/{bookId}", method = RequestMethod.GET)
	public String editBook(@PathVariable("bookId") Long bookId, Model model) {
		model.addAttribute("book", bookRepository.findById(bookId));
		model.addAttribute("categories", categoryRepository.findAll());
		return "editbook";
	}
	
}
