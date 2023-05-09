package com.SpringApp.Project.indexController;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.SpringApp.Project.Role;
import com.SpringApp.Project.Services.EventsService;
import com.SpringApp.Project.Services.UsersService;
import com.SpringApp.Project.entity.Users;



@Controller
public class UsersController {

    @Autowired 
    private UsersService usersService;

    
    @GetMapping("/Users/Login")
	private String Signup_Student() {
		return "User/UsersLogin";
	}
    @GetMapping("/Users/test")
    public String EtudRegister(){
        return "User/UsersSignUp";
    }
    @GetMapping("/Users/HomePage")
    private String HomePage(){
        return ("User/Users_HomePage");
    }
    @PostMapping("/createuser")
    public String createuser(@ModelAttribute Users user,HttpSession session) {
        user.setRole(Role.USER);
        usersService.create_Users(user);
        session.setAttribute("msg", " " + user.getName()+ " welcome to event hub  !!");
    return "/Users/test"; 
}
}


