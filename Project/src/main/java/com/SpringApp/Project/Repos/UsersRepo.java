package com.SpringApp.Project.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringApp.Project.entity.Users;

@Repository
public interface UsersRepo extends JpaRepository<Users,String>{
    
}

