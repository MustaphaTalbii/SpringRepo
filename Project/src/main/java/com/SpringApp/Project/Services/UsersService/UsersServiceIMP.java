package com.SpringApp.Project.Services.UsersService;


import java.util.List;
import java.util.Set;
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
	EventsRepo eventsRepo;
	
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
	if (user.getParticipated_Events().contains(event)){
		return true;
	}
		user.getParticipated_Events().add(event);
		event.setCurrent_Participants_Number(event.getCurrent_Participants_Number()+1);
		event.getUsers().add(user);
		eventsRepo.save(event);
		usersRepo.save(user);
	return false;
}
public void deleteEvent(String userid,int eventid){
	Users user = usersRepo.findById(userid).orElse(null);
	Events event = eventsRepo.findById(eventid).orElse(null);
	user.getParticipated_Events().remove(event);
	event.setCurrent_Participants_Number(event.getCurrent_Participants_Number()-1);
	event.getUsers().remove(user);
	usersRepo.save(user);
	eventsRepo.save(event);
}
public void deleteUser(Users user) { 
	Set<Events> events = user.getParticipated_Events();
	for (Events event : events) {
		event.getUsers().remove(user);
		eventsRepo.save(event);
	}
	usersRepo.delete(user);
}
}