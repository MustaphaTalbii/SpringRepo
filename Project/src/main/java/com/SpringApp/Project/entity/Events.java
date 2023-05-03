package com.SpringApp.Project.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Events {

	@Id
	private int id_Event;
	private String Event_Name;
	private String Registration_due;
	private String Description;
	private int Current_Participants_Number;
	private int Max_Members;
	private boolean Status;

	@JsonIgnoreProperties(value = "eventsParticipated")
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER , mappedBy = "eventsParticipated")
	private List<Student> participatedStudents;

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
	public String getRegistration_due() {
		return Registration_due;
	}
	public void setRegistration_due(String registration_due) {
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
	public boolean isStatus() {
		return Status;
	}
	public void setStatus(boolean status) {
		Status = status;
	}
	public Events(int id_Event, String event_Name, String registration_due, String description,
			int current_Participants_Number, int max_Members, boolean status) {
		this.id_Event = id_Event;
		Event_Name = event_Name;
		Registration_due = registration_due;
		Description = description;
		Current_Participants_Number = current_Participants_Number;
		Max_Members = max_Members;
		Status = status;
	}

	public Events() {
		super();
	}
	@Override
	public String toString() {
		return "Events [id_Event=" + id_Event + ", Event_Name=" + Event_Name + ", Registration_due=" + Registration_due
				+ ", Description=" + Description + ", Current_Participants_Number=" + Current_Participants_Number
				+ ", Max_Members=" + Max_Members + ", Status=" + Status + "]";
	}
	
}
