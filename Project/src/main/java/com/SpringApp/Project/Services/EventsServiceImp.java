package com.SpringApp.Project.Services;

import com.SpringApp.Project.Repos.EventsRepo;
import com.SpringApp.Project.entity.Events;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class EventsServiceImp implements EventsService{

    @Autowired
    EventsRepo eventsRepo;

    @Override
    public Events findbyid(int id) {
        return eventsRepo.findById(id).orElse(null);
    }
    @Override
    public Events createeEvent(Events test){
        return eventsRepo.save(test);
    }
    @Override
    public List<Events> findalla(){
        return eventsRepo.findAll();
    }
}
