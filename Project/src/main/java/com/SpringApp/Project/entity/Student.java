package com.SpringApp.Project.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class Student {
	@Id
	private int id_Etudiant;
	private String Etu_Name;
	private String Etu_LastName;
	private String Etu_Classe;

	@JsonIgnoreProperties (value = "participatedStudents")
	@ManyToMany (cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Events> eventsParticipated;
	@JoinTable(name = "Student_Event",joinColumns = {@JoinColumn(name="Id",referencedColumnName = "id_Etudiant"),},
	inverseJoinColumns = {
		@JoinColumn(name="EventId",referencedColumnName = "Id"),
	}
	)

	public int getId_Etudiant() {
		return id_Etudiant;
	}
	public void setId_Etudiant(int id_Etudiant) {
		this.id_Etudiant = id_Etudiant;
	}
	public String getEtu_Name() {
		return Etu_Name;
	}
	public void setEtu_Name(String etu_Name) {
		Etu_Name = etu_Name;
	}
	public String getEtu_LastName() {
		return Etu_LastName;
	}
	public void setEtu_LastName(String etu_LastName) {
		Etu_LastName = etu_LastName;
	}
	public String getEtu_Classe() {
		return Etu_Classe;
	}
	public void setEtu_Classe(String etu_Classe) {
		Etu_Classe = etu_Classe;
	}
	
	public Student(int id_Etudiant, String etu_Name, String etu_LastName, String etu_Classe) {
		super();
		this.id_Etudiant = id_Etudiant;
		Etu_Name = etu_Name;
		Etu_LastName = etu_LastName;
		Etu_Classe = etu_Classe;
		
	}
	public Student() {
		super();
	}
	
}
