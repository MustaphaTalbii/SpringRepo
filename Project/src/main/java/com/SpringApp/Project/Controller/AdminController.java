package com.SpringApp.Project.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    
    @GetMapping("/Admin")
    public String AdminLogin(){
        return "Admins/AdminLogin";
    }
}
