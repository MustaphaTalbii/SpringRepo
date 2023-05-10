package com.SpringApp.Project.Services;

import java.util.List;

import com.SpringApp.Project.entity.Events;



public interface EventsService {
    public Events findbyid(int id);
    public Events createeEvent(Events test);
    public List<Events> findalla();
}
