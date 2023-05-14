package com.SpringApp.Project.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.SpringApp.Project.Role;
import com.SpringApp.Project.Repos.EventsRepo;
import com.SpringApp.Project.Repos.UsersRepo;
import com.SpringApp.Project.Services.UsersService.UsersService;
import com.SpringApp.Project.entity.Users;



@Controller
public class UsersController {

    @Autowired
    EventsRepo eventsRepo;

    @Autowired 
    private UsersService usersService;
    @Autowired
    private UsersRepo usersRepo;
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
@GetMapping("/UserHomeView")
public String dashboard(){
    return "dashboard";
}
@PostMapping("/HomeView")
public String login(@ModelAttribute Users user, Model model) {
    Users loginUser = usersRepo.findById(user.getMail()).orElse(null);

    if (loginUser == null) {
        model.addAttribute("msg", "Email Dosent Exist");
        return "Users/UserLogin";
    } else if (!loginUser.getPassword().equals(user.getPassword())) {
        model.addAttribute("msg", "Password is incorrect");
        return "Users/UserLogin";
    } else {
        usersService.addEvent(loginUser, eventsRepo.findById(6).orElse(null));
        model.addAttribute("user", loginUser);
        return "Users/HomeView";
    }
} 
@PostMapping("/deleteEvent/{eventid}")
public String deletEvent(@PathVariable int eventid, @RequestParam String mail, Model model) {
    Users user = usersRepo.findById(mail).orElse(null);
        user.getParticipated_Events().remove(eventsRepo.findById(eventid).orElse(null));
        usersRepo.save(user);
    model.addAttribute("user", user);
    return "Users/HomeView";
}


}