package com.hibernate.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Student")
public class Student {
	
	//declare the fields
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="StudentId")
	private int StudentId;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@ManyToMany(fetch= FetchType.LAZY, cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH} )
	@JoinTable(name="Course_Student", joinColumns=@JoinColumn(name="Student_id"),
	           inverseJoinColumns=@JoinColumn(name="Course_id"))
	private List<Course> courses;
	
	//Add convenience method for Course field
	public void add(Course tempcourses)
	{
		if(courses==null)
		{
			courses=new ArrayList<>();
		}
		
		courses.add(tempcourses);
	}
	
	//create the default constructor
	public Student()
	{
		
	}
    
	//create parameterized constructor
	public Student(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	

	//create  getter and setters for the fields
	public int getStudentId() {
		return StudentId;
	}

	public void setStudentId(int studentId) {
		StudentId = studentId;
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

	//create getters and setters methods for Course field

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	//create the ToString for debugging purpose
	@Override
	public String toString() {
		return "Student [StudentId=" + StudentId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + "]";
	}


	
}
