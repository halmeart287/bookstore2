package hh.swd20.bookstore2.webcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.bookstore2.domain.Student;

@Controller
public class StudentController {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String welcomeMsg(Model model) {

		model.addAttribute("firstName", new Student());
		List<Student> students = new ArrayList<Student>();

		students.add(new Student("Parvo", "Kontu"));
		students.add(new Student("Malark", "Greycastle"));
		students.add(new Student("Helia", "Veray"));
		model.addAttribute("students", students);

		return "studentlist";
	}
	
}
