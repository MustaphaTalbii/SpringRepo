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
    boolean idtest = usersService.checkid_User(user.getMail());
    if (idtest){
        Events test = eventsService.findbyid(1);
        boolean testadd = usersService.addEvent(user, test);
        if (!testadd){
            session.setAttribute("msg", "You Allready Have This Event ! ");
        }
    }
    else 
    {   
        user.setRole(Role.USER);
        usersService.create_Users(user);
        session.setAttribute("msg", " " + user.getName()+ " welcome to event hub  !!");
    }
    return "StudentsSignUp"; 
}
}