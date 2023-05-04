package com.SpringApp.Project.Services;




import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringApp.Project.Repos.EventsRepo;
import com.SpringApp.Project.Repos.UsersRepo;
import com.SpringApp.Project.entity.Events;
import com.SpringApp.Project.entity.Users;

import antlr.debug.Event;


@Service
public class UsersServiceIMP implements UsersService {

	@Autowired
	private UsersRepo usersRepo;

	@Autowired
	private EventsRepo eventsRepo;
	
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
public void addEvent(Users user, Events event) {
    List<Events> events = eventsRepo.findEventsByUserEmail(user.getMail());
    events.add(event);
    user.setParticipated_Events(events);
    usersRepo.save(user);
}

	@Override
	public List<Events> gettable(String email){
		return eventsRepo.findEventsByUserEmail(email);
	}
}
