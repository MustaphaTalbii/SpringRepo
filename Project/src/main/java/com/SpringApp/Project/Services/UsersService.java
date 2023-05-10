package com.SpringApp.Project.Services;

import java.util.List;

import com.SpringApp.Project.entity.Events;
import com.SpringApp.Project.entity.Users;


public interface UsersService {
	public Users create_Users(Users student);
	public boolean checkid_User(String mail);
	public Users findUser();
	public boolean addEvent(Users user,Events event);
	public List<Events> events_Table(String email);
}
