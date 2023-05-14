package com.SpringApp.Project.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringApp.Project.entity.Admin;

@Repository
public interface AdminRepo  extends JpaRepository<Admin,String> {

}
