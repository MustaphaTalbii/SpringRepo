package com.SpringApp.Project.Services.UsersService;

import com.SpringApp.Project.entity.Events;
import com.SpringApp.Project.entity.Users;


public interface UsersService {
	public Users create_Users(Users student);
	public boolean checkid_User(String mail);
	public Users findUser();
	public boolean addEvent(Users user,Events event);
	
}
