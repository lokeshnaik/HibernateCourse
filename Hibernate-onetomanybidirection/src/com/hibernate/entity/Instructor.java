package com.hibernate.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.engine.jdbc.env.spi.IdentifierCaseStrategy;
//annotate the class as an entity and map to database
@Entity
@Table(name="instructor")
public class Instructor {

	//defining fields and annotated the fields with databases column
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="firstName")
	private String firstName;

	@Column(name="lastName")
	private String lastName;

	@Column(name="email")
	private String email;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="instructordetail_id")
	private InstructorDetail instructordetail;
	
	@OneToMany(mappedBy = "instructor", cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private List<Course> courses;


	//create default constructor
	public Instructor() {

	}

	  //create parameterized constructor 
	    public Instructor(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	    }


	//generate setters and getters
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public InstructorDetail getInstructordetail() {
		return instructordetail;
	}

	public void setInstructordetail(InstructorDetail instructordetail) {
		this.instructordetail = instructordetail;
	}
	
	  public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	//add convenience methods for bi-directional relationship
	public void add(Course tempcourse)
	{
		if(courses==null)
		{
			courses=new ArrayList<>();
		}
		
		courses.add(tempcourse);
		
		tempcourse.setInstructor(this);
		
	}
	

	//generate toString() method for debugging purpose
	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", instructordetail=" + instructordetail + "]";
	}


}
