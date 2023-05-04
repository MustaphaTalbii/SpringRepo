package com.SpringApp.Project.Repos;

import com.SpringApp.Project.entity.Events;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EventsRepo extends JpaRepository<Events,Integer> {
    @Query("SELECT e FROM Events e JOIN e.participated_Users p WHERE p.Mail = :email")
    List<Events> findEventsByUserEmail(String email);
}
