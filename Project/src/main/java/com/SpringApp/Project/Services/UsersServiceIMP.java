package com.SpringApp.Project.Services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringApp.Project.Repos.EventsRepo;
import com.SpringApp.Project.Repos.UsersRepo;
import com.SpringApp.Project.entity.Events;
import com.SpringApp.Project.entity.Users;




@Service
public class UsersServiceIMP implements UsersService {

	@Autowired
	private UsersRepo usersRepo;

	@Autowired
	private EventsRepo eventsRepo;
	
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
    List<Events> events = user.getParticipated_Events();
	if (events.contains(event)){
		return true;
	}
		events.add(event);
    user.setParticipated_Events(events);
    usersRepo.save(user);
	return false;
	
}

	@Override
	public List<Events> events_Table(String email){
		return eventsRepo.findEventsByUserEmail(email);
	}
}
