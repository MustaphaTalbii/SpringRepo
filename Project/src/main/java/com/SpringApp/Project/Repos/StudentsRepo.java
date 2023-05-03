package com.SpringApp.Project.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringApp.Project.entity.Student;

@Repository
public interface StudentsRepo extends JpaRepository<Student,Integer>{

}
