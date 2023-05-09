package com.SpringApp.Project.entity;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.SpringApp.Project.Role;




@Entity
public class Users {
	@Id
	private String Mail;
	private String Name;
	private String Last_Name;
	@Column(nullable = false)
	private String password;
	private String classroom;
	@Enumerated(EnumType.STRING)
	private Role role ;

	@ManyToMany(mappedBy = "users",cascade = CascadeType.REFRESH)
    private List<Events> events = new ArrayList<Events>();

	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getLast_Name() {
		return Last_Name;
	}
	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}
	public String getMail() {
		return Mail;
	}
	public void setMail(String mail) {
		Mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getClassroom() {
		return classroom;
	}
	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Users(String mail, String name, String last_Name, String password, String classroom) {
		Name = name;
		Last_Name = last_Name;
		Mail = mail;
		this.password = password;
		this.classroom = classroom;
	}
	public Users() {
	}
	@Override
	public String toString() {
		return "Users [Name=" + Name + ", Last_Name=" + Last_Name + ", classroom=" + classroom
				+ ", participated_Events=" + "]";
	}
	public List<Events> getEvents() {
		return events;
	}
	public void setEvents(List<Events> events) {
		this.events = events;
	}
	public Users(String mail, String password) {
		Mail = mail;
		this.password = password;
	}
	
}

