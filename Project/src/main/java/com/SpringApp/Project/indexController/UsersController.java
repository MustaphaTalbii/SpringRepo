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
import com.SpringApp.Project.entity.Events;
import com.SpringApp.Project.entity.Users;



@Controller
public class UsersController {

    @Autowired 
    private UsersService usersService;

    @Autowired
    private EventsService eventsService;
    
    @GetMapping("/StudentsSignUp")
    public String EtudRegister(){
        return "StudentsSignUp";
    }

    @PostMapping("/createuser")
    public String createuser(@ModelAttribute Users user,HttpSession session) {
    boolean idtest = usersService.checkid_student(user.getMail());
    if (idtest){
        session.setAttribute("msg", "Email Allready Exists ! ");
        Events test = eventsService.findbyid(1);
        usersService.addEvent(user, test);
        System.out.println(usersService.gettable(user.getMail()));
        
    }
    else 
    {   
        Events test = eventsService.findbyid(1);
    
        user.setRole(Role.USER);
        usersService.createStudent(user);
        session.setAttribute("msg", " " + user.getName()+ " welcome to event hub  !!");
    }
    return "StudentsSignUp"; 
}
}