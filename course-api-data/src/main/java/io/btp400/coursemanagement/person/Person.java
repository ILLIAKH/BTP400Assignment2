package io.btp400.coursemanagement.person;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import io.btp400.coursemanagement.course.Course;

//test
@Entity
public class Person {
	
	@Id
	private String id;
	private String name;
	private String password;
	private String role;
	
	
	@ManyToOne
	private Course course;


	public Person()
	{
		
	}
	
	public Person(String id, String name, String role, String courseId, String topicId) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.course = new Course(courseId, "", "", topicId);
	}
	
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public Course getCourse() {
		return course;
	}


	public void setCourse(Course course) {
		this.course = course;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
