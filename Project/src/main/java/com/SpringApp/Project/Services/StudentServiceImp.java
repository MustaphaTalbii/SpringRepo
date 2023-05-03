package com.SpringApp.Project.Services;



import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringApp.Project.Repos.StudentsRepo;
import com.SpringApp.Project.entity.Events;
import com.SpringApp.Project.entity.Student;


@Service
public class StudentServiceImp implements StudentService {

	@Autowired
	private StudentsRepo studentrepo;
	
	@Override
	public Student createStudent(Student student) {
	
		return 	studentrepo.save(student);
	}



	@Override
	public boolean checkid_student(int id) {
		return studentrepo.existsById(id);
	}
	
	@Override
	public Student findstudents(){
		return studentrepo.findById(11448061).orElseThrow();
	}
	
	public void addevent(Student student,Events events){
		student.setEtu_Name("test");
		ArrayList<Events> test = new ArrayList<Events>();
		test.add(0, events);
		studentrepo.save(student);
	}
}
