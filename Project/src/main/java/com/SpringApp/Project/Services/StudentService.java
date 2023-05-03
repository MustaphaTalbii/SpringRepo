package com.SpringApp.Project.Services;






import com.SpringApp.Project.entity.Events;
import com.SpringApp.Project.entity.Student;


public interface StudentService {
	public Student createStudent(Student student);
	public boolean checkid_student(int id);
	public Student findstudents();
	public void addevent(Student student,Events event);
}
