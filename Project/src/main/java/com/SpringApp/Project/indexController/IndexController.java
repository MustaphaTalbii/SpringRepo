package com.SpringApp.Project.indexController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping("/")
	private String homeview() {
		return "index";
	}
	@GetMapping("Students/Login")
	private String Signup_Student() {
		return "StudentsLogin";
	}
}
