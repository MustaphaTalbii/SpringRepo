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
	public Users createStudent(Users student) {
	
		return 	usersRepo.save(student);
	}



	@Override
	public boolean checkid_student(String mail) {
		return usersRepo.existsById(mail);
	}
	
	@Override
	public Users findstudents(){
		return usersRepo.findById("Mustapha.talbi@admintest.com").orElse(null);}



	@Override
	public void addEvent(Users user,Events event) {
		user.getParticipated_Events().add(event);
		usersRepo.save(user);
	}

}
