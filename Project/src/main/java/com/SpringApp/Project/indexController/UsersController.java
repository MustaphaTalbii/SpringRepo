package com.SpringApp.Project.indexController;

import java.time.LocalDate;

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
        
    }
    else 
    {
        LocalDate test = LocalDate.now();
        Events event = new Events("testEvent",test,"Test Event",0,15,true);
        eventsService.createeEvent(event);
        user.setRole(Role.USER);
        usersService.addEvent(user, event);
        session.setAttribute("msg", " " + user.getName()+ " Welcome To Event Hub  !!");
    }
    return "StudentsSignUp"; 
}
}