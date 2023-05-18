package com.SpringApp.Project.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.SpringApp.Project.Repos.EventsRepo;
import com.SpringApp.Project.Repos.UsersRepo;
import com.SpringApp.Project.Services.EventsService.EventsService;
import com.SpringApp.Project.Services.UsersService.UsersService;
import com.SpringApp.Project.entity.Events;
import com.SpringApp.Project.entity.Users;

@Controller
public class EventController {

    @Autowired
    EventsRepo eventsRepo;
    @Autowired
    EventsService eventsService;
    @Autowired
    UsersService usersService;
    @Autowired
    UsersRepo usersRepo;

    @GetMapping ("/Event/Home")
public String home(HttpSession session,Model model){
    Users user = (Users)session.getAttribute("user");
    Events event = (Events) session.getAttribute("eventt");
    model.addAttribute("user", user);
    model.addAttribute("eventt", event);
    return "Events/eventHome";   
}

    @PostMapping("/Event/{eventid}")
    public String EventPage(@PathVariable int eventid,Model model,HttpSession session) {
    Events event = eventsRepo.findById(eventid).orElse(null);
        session.setAttribute("eventt", event);
        Users user = (Users)session.getAttribute("user");
        model.addAttribute("user", user);
        model.addAttribute("eventt", event);
    return "Events/eventHome";
}

    @PostMapping("/addEvent")
    public String deletEvent(@RequestParam String mail,@RequestParam int event ,Model model,HttpSession session) {
        Users user = usersRepo.findById(mail).orElse(null);
        Events events = eventsRepo.findById(event).orElse(null);
        usersService.addEvent(user, events);
        session.setAttribute("user", user);
    return "redirect:/events";
}
}
