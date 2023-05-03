package com.SpringApp.Project.Repos;

import com.SpringApp.Project.entity.Events;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventsRepo extends JpaRepository<Events,Integer> {

}
