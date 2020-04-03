package hh.swd20.bookstore2.webcontroller;

import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@ResponseBody
public class MainController {

	@RequestMapping("/index")
	public String indexPage() {
		return "This is the main page.";
	}

	@RequestMapping("/contact")
	public String contactPage() {
		return "This is the contact page.";
	}

	/*@RequestMapping("/hello")
	 *public String welcomeTo(@RequestParam(name = "loc") String location,
	 *		@RequestParam(name = "fname") String firstName) {
	 *	return "Welcome to " + location + ", " + firstName + ".";
	 *}
	 */
	
	/*@RequestMapping("/hello")
	 *public String ageCheck(@RequestParam(value = "fname") String fname, @RequestParam(value = "age") String age, Model model) {
	 *
	 *	model.addAttribute("fname", fname);
	 *	model.addAttribute("age", age);
	 *	return "hello";
	 *}
	 */
}
