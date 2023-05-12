package com.SpringApp.Project.Controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.SpringApp.Project.Role;
import com.SpringApp.Project.Repos.UsersRepo;
import com.SpringApp.Project.Services.EventsService;
import com.SpringApp.Project.Services.UsersService;
import com.SpringApp.Project.entity.Events;
import com.SpringApp.Project.entity.Users;



@Controller
public class UsersController {

    @Autowired 
    private UsersService usersService;

    @Autowired
    private UsersRepo usersRepo;

    @Autowired
    private EventsService eventsService;
    

    @PostMapping("/createuser")
    public String createuser(@ModelAttribute Users user,Model model) {
    boolean idtest = usersService.checkid_User(user.getMail());
    if (idtest){
        model.addAttribute("LogMsg", "Email Allready Exists ! Try Logging Up");
    }
    else 
    {   
        user.setRole(Role.USER);
        usersService.create_Users(user);
        model.addAttribute("LogMsg", "Registration Successefful ! You Can Sing In Now");
    }
    return "Users/UserSignup"; 
}

@GetMapping("/UserDashboard")
public String dashboard(){
    return "dashboard";
}




@PostMapping("/login")
public String login(@ModelAttribute Users user, Model model) {
    Users loginUser = usersRepo.findById(user.getMail()).orElse(null);

    if (loginUser != null && loginUser.getPassword().equals(user.getPassword())) {
        model.addAttribute("user", loginUser);
        return "dashboard";
    } else {
        model.addAttribute("msg", "Email Dosent Exist");
        return "Users/UserLogin";
    }
}

}