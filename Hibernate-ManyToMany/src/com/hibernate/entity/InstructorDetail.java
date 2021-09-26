package com.hibernate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//annotate the class as an entity and map to database
@Entity
@Table(name="instructordetail")
public class InstructorDetail 
{
	//defining fields and annotated the fields with databases column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="youtubechannel")
	private String youtubechannel;

	@Column(name="hobby")
	private String hobby;

	//add new filed for instructor
	@OneToOne(fetch =FetchType.LAZY,mappedBy="instructordetail", cascade= CascadeType.ALL)
	private Instructor instructor;


	//create default constructor
	public InstructorDetail() {

	}

	//create parameterized constructor 
	public InstructorDetail(String youtubechannel, String hobby) {
		super();
		this.youtubechannel = youtubechannel;
		this.hobby = hobby;
	}


	//generate setters and getters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYoutubechannel() {
		return youtubechannel;
	}

	public void setYoutubechannel(String youtubechannel) {
		this.youtubechannel = youtubechannel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	//generate toString() method for debugging purpose
	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youtubechannel=" + youtubechannel + ", hobby=" + hobby + "]";
	}

}
