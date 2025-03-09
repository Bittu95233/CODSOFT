package com.codsoft;

import java.util.ArrayList;
import java.util.List;

public class Course {
	private String courseCode;
	private String title;
	private String description;
	private int capacity;
	private int enrolledStudents;
	private String schedule;
	private List<Student> registeredStudents;
	
	
	public Course(String courseCode, String title, String description, int capacity, String schedule) {
		super();
		this.courseCode = courseCode;
		this.title = title;
		this.description = description;
		this.capacity = capacity;
		this.enrolledStudents = 0;
		this.schedule = schedule;
		this.registeredStudents = new ArrayList<>();
	}
	
	public String getCourseCode() {
		return courseCode;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public int getAvailableSlots() {
		return capacity - enrolledStudents;
	}
	public String getSchedule() {
		return schedule;
	}
	
	public boolean registerStudent(Student student) {
		if (enrolledStudents < capacity) {
			registeredStudents.add(student);
			enrolledStudents++;
			return true;
		}
		return false;
	}
	public boolean removeStudent(Student student) {
		if(registeredStudents.remove(student)) {
			enrolledStudents--;
			return true;
		}
		return false;
	}
	public void displayCourseDetails() {
		System.out.println("Course code		 : "+courseCode);
		System.out.println("Title	   		 : "+title);
		System.out.println("Description		 : "+description);
		System.out.println("Capacity   		 : "+capacity);
		System.out.println("Enrolled Students: "+enrolledStudents);
		System.out.println("Available Slots	 : "+getAvailableSlots());
		System.out.println("Schedule   		 : "+schedule);
		System.out.println("---------------------------------");
	}
	
	
}
