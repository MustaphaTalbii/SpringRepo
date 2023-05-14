package com.SpringApp.Project.entity;



import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;





@Entity
public class Events {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_Event;
	@Column(nullable = false)
	private String Event_Name;
	@Column(nullable = false)
	private LocalDate Registration_due;
	@Column(nullable = false)
	private String Description;
	@Column(nullable = false)
	private int Current_Participants_Number;
	private int Max_Members;

	@ManyToOne(cascade = CascadeType.ALL)
	private Events events;

	public Events getEvents() {
		return events;
	}

	public void setEvents(Events events) {
		this.events = events;
	}

	public int getId_Event() {
		return id_Event;
	}
	public void setId_Event(int id_Event) {
		this.id_Event = id_Event;
	}
	public String getEvent_Name() {
		return Event_Name;
	}
	public void setEvent_Name(String event_Name) {
		Event_Name = event_Name;
	}
	public LocalDate getRegistration_due() {
		return Registration_due;
	}
	public void setRegistration_due(LocalDate registration_due) {
		Registration_due = registration_due;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public int getCurrent_Participants_Number() {
		return Current_Participants_Number;
	}
	public void setCurrent_Participants_Number(int current_Participants_Number) {
		Current_Participants_Number = current_Participants_Number;
	}
	public int getMax_Members() {
		return Max_Members;
	}
	public void setMax_Members(int max_Members) {
		Max_Members = max_Members;
	}
	public Events( String event_Name, LocalDate registration_due, String description,
				   int current_Participants_Number, int max_Members, boolean status) {
		Event_Name = event_Name;
		Registration_due = registration_due;
		Description = description;
		Current_Participants_Number = current_Participants_Number;
		Max_Members = max_Members;
	}

	public Events() {
		super();
	}
	@Override
	public String toString() {
		return "Events [id_Event=" + id_Event + ", Event_Name=" + Event_Name + ", Registration_due=" + Registration_due
				+ ", Description=" + Description + ", Current_Participants_Number=" + Current_Participants_Number
				+ ", Max_Members=" + Max_Members +"]";
	}

}






