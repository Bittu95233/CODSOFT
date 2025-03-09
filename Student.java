package com.codsoft;

import java.util.ArrayList;
import java.util.List;

public class Student {
	private String studentID;
	private String name;
	private List<Course> registeredCourse;
	
	public Student(String studentID, String name) {
		super();
		this.studentID = studentID;
		this.name = name;
		this.registeredCourse = new ArrayList<>();
	}
	
	public String getStudentID() {
		return studentID;
	}
	
	public String getName() {
		return name;
	}
	
	public List<Course> getRegisteredCourse() {
		return registeredCourse;
	}
	

	public boolean registerForCourse(Course course) {
		if (course.registerStudent(this)) {
			registeredCourse.add(course);
			return true;
		}
		return false;
	}
	public boolean dropCourse(Course course) {
		if (registeredCourse.remove(course)) {
			course.removeStudent(this);
			return true;			
		}
		return false;
	}

	public void displayRegisteredCourses() {
		System.out.println("Registerd Courses for "+ name+ ":");
		if(registeredCourse.isEmpty()) {
			System.out.println("No courses registered.");
		}
		else {
			for (Course course : registeredCourse) {
				System.out.println(course.getTitle()+ "( "+ course.getCourseCode()+")");
			}
		}
		System.out.println("---------------------------------------");
	}	
}
