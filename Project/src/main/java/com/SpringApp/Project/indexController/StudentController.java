package com.SpringApp.Project.indexController;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.SpringApp.Project.Services.EventsService;
import com.SpringApp.Project.Services.StudentService;
import com.SpringApp.Project.entity.Events;
import com.SpringApp.Project.entity.Student;



@Controller
public class StudentController {

    @Autowired 
    private StudentService studentService;
    @Autowired
    private EventsService eventsService;

    
    @GetMapping("/StudentsSignUp")
    public String EtudRegister(){
        return "StudentsSignUp";
    }

    @PostMapping("/createuser")
    public String createuser(@ModelAttribute Student user,HttpSession session) {
    boolean idtest = studentService.checkid_student(user.getId_Etudiant());
    if (idtest){
        session.setAttribute("msg", "User Exists !!");
        
    }
    else 
    {
        studentService.createStudent(user);
        session.setAttribute("msg", " " + user.getId_Etudiant()+ " Welcome To Event Hub  !!");
    }
    return "StudentsSignUp"; 
}
}