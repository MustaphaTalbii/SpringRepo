package com.SpringApp.Project.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping("/")
	private String homeview() {
		return "index";
	}
	@GetMapping("/UserSignUp")
    public String UserSignup(){
        return "Users/UserSignup";
    }

    @GetMapping("/UserLogin")
    public String UserLonin(){
        return "Users/UserLogin";
    }
    @GetMapping("/home")
    public String Home(){
        return "index";
    }
}
