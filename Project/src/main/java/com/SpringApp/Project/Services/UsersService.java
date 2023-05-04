package com.SpringApp.Project.Services;


import java.util.ArrayList;
import java.util.List;

import com.SpringApp.Project.entity.Events;
import com.SpringApp.Project.entity.Users;


public interface UsersService {
	public Users createStudent(Users student);
	public boolean checkid_student(String mail);
	public Users findstudents();
	public void addEvent(Users user,Events event);
	public List<Events> gettable(String email);
}
