package com.SpringApp.Project.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.SpringApp.Project.Repos.UsersRepo;
import com.SpringApp.Project.entity.Events;
import com.SpringApp.Project.entity.Users;




@Service
public class UsersServiceIMP implements UsersService {

	@Autowired
	private UsersRepo usersRepo;

	
	@Override
	public Users create_Users(Users student) {
		return 	usersRepo.save(student);
	}



	@Override
	public boolean checkid_User(String mail) {
		return usersRepo.existsById(mail);
	}
	
	@Override
	public Users findUser(){
		return usersRepo.findById("Mustapha.talbi@admintest.com").orElse(null);}



	
	@Override
public boolean addEvent(Users user, Events event) {
	user.getEvents().add(event);
	usersRepo.save(user);
	return true;
}
	
}
