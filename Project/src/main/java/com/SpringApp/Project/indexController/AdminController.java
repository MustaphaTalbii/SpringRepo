package com.SpringApp.Project.indexController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    
    @GetMapping("/admin/login")
	public String viewAdminLoginPage(){
		return "Admin/admin_login";
	}

@GetMapping("/admin/home")
public String viewAdminHome(){
    return "Admin/admin_home";
}


}
