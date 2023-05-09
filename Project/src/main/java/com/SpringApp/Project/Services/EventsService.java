package com.SpringApp.Project.Services;

import java.util.List;

import com.SpringApp.Project.entity.Events;
import com.SpringApp.Project.entity.Users;



public interface EventsService {
    public Events findbyid(int id);
    public Events createeEvent(Events test);
    public List<Events> findalla();
    public boolean deleteevent(Events event);
    public boolean adduser (Users user,Events event);
}
