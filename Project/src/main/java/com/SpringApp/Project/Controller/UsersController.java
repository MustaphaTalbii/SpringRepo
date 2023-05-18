package com.SpringApp.Project.Controller;



import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
import com.SpringApp.Project.Security.CustomUserDtls;
import com.SpringApp.Project.Services.CustomUserDtlsService;
import com.SpringApp.Project.Services.EventsService.EventsService;
import com.SpringApp.Project.Services.UsersService.UsersService;
import com.SpringApp.Project.entity.Events;
import com.SpringApp.Project.entity.Users;



@Controller
public class UsersController {

    @Autowired
    private BCryptPasswordEncoder bp;

    @Autowired
    EventsRepo eventsRepo;

    @Autowired 
    private UsersService usersService;

    @Autowired
    private UsersRepo usersRepo;

    @GetMapping("/events")
    public String browseevents(Model model,HttpSession session){
        Users user = (Users) session.getAttribute("user");
        model.addAttribute("user", user);
        List events = eventsRepo.findAll();
        model.addAttribute("events", events);
        return "Users/BrowseEvents";
    }

    @GetMapping("/Users/Home")
    public String homeuser(HttpSession session,Model model){
        Users user = (Users) session.getAttribute("user");
        model.addAttribute("user", user);
        session.setAttribute("user", user);
        return "Users/HomeView";
    }

    @PostMapping("/update")
    public String updateuser(@RequestParam String email,HttpSession session){
       Users a =  usersRepo.findById(email).orElse(null);
       a.setName("mustapha");
       usersRepo.save(a);
       session.setAttribute("user", a);
        return "redirect:/events";
    }

    @PostMapping("/Users/HomeView")
public String login(@RequestParam String email, @RequestParam String password, HttpSession session,Model model) {
    Users user = usersRepo.findById(email).orElse(null);
    if (user != null && bp.matches(password, user.getPassword())) {
        user.getParticipated_Events().add(eventsRepo.findById(1).orElse(null));
        usersRepo.save(user);
        session.setAttribute("user", user);
        model.addAttribute("user", user);
        return "Users/HomeView";
    } else {
        model.addAttribute("msg", "Email Or Password Incorrect");
        return "/";
    }
}

    @PostMapping("/createuser")
    public String createuser(@ModelAttribute Users user,HttpSession session) {
    boolean idtest = usersService.checkid_User(user.getMail());
    if (idtest){
        session.setAttribute("LogMsg", "Email Allready Exists ! Try Logging Up");
    }
    else 
    {   
        user.setPassword(bp.encode(user.getPassword()));
        usersService.create_Users(user);
        session.setAttribute("LogMsg", "Registration Successefful ! You Can Sing In Now");
    }
    return "Users/UserSignup"; 
}

    @PostMapping("/deleteEvent/{eventid}")
    public String deletEvent(@PathVariable int eventid, @RequestParam String mail, Model model,HttpSession session) {
    usersService.deleteEvent(mail, eventid);
    Users user = usersRepo.findById(mail).orElse(null);
    session.setAttribute("user", user);
    return "redirect:/Users/Home";
}
}

