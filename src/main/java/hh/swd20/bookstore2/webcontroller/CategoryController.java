package hh.swd20.bookstore2.webcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.bookstore2.domain.Book;
import hh.swd20.bookstore2.domain.Category;
import hh.swd20.bookstore2.domain.CategoryRepository;

@Controller
public class CategoryController {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	public String getCategoryList(Model model) {
		List<Category> categories = (List<Category>) categoryRepository.findAll();
		model.addAttribute("categories", categories);
		return "categories";
	}
	
	@RequestMapping(value = "/addcategory", method = RequestMethod.GET)
	public String getCategoryForm(Model model) {
		 model.addAttribute("category", new Category());
		 return "addcategory";
	}
	
	@RequestMapping(value = "/savecategory", method = RequestMethod.POST)
	public String saveCategory(Category category) {
		categoryRepository.save(category);
		return "redirect:/categories";
	}

}
