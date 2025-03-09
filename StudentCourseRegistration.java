package com.codsoft;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentCourseRegistration {
	
	private static List<Course> courses = new ArrayList<>();
	private static List<Student> students = new ArrayList<>();
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		courses.add(new Course("301","OOPs with C++","Adavanced C++",5,"Mon-Tues 9:00 AM"));
		courses.add(new Course("302","OOPs With Java","Basic of java programming",6,"Wed-Thur 10:00 AM"));
		courses.add(new Course("303","Computer Organization & architecture","Architectore in computer",3,"Frid 12:00 AM"));
		courses.add(new Course("304","DBMS","Introduction to SQL and DBMS",4,"Sat 1:00 PM"));
		courses.add(new Course("305","Computer Graphics","Build in computer graphics",8,"Sun 10:00 AM"));
		
		students.add(new Student("S101","Akash"));
		students.add(new Student("S102","Gulshan"));
		students.add(new Student("S103","Monu"));
		students.add(new Student("S104","Abhinandan"));
		students.add(new Student("S105","Golu"));
		students.add(new Student("S106","Gulshan"));
		
		
		int choice;
		do {
			System.out.println("\nStudent Course Registration System");
			System.out.println("1. List available courses");
			System.out.println("2. Register for a course");
			System.out.println("3. Drop a courses");
			System.out.println("4. View Registered course");
			System.out.println("5. Exit");
			
			System.out.print("Enter your choice:");
			choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
				case 1:
					displayCourse();
					break;
				case 2:
					registeredForCourse();
					break;
				case 3:
					dropCourse();
					break;
				case 4:
					viewRegisteredCourse();
					break;
				case 5:
					System.out.println("Exiting the system");
					break;
				default:
					System.out.println("Invalid choice....!Please choose valid number");
			}
		}while(choice!=5);
		sc.close();
		
		}
	//Display course
	private static void displayCourse() {
			System.out.println("\nAvailable Course");
			for (Course course : courses) {
				course.displayCourseDetails();
			}		
	}
	//Student registration course
	private static void registeredForCourse() {
		Student student = findStudent();
		if (student == null) return; 
		
		System.out.println("Enter the course code to register");
		String coursecode = sc.nextLine();
		Course course = findCourse(coursecode);
		
		if (course != null) {
			if (student.registerForCourse(course)) {
				System.out.println("successfully registered for "+ course.getTitle());
			}else {
				System.out.println("Registration failed.");
			}
		}
		else {
			System.out.println("Course not found");
		}		
	}
	//Dropping a course
	private static void dropCourse() {
		Student student = findStudent();
			if (student == null) return; 
			
			System.out.println("Enter the course code to register");
			String coursecode = sc.nextLine();
			Course course = findCourse(coursecode);
			
			if (course != null) {
				if (student.dropCourse(course)) {
					System.out.println("Successfully dropped for "+ course.getTitle());
				}else {
					System.out.println("Registration failed.");
				}
			}
			else {
				System.out.println("Course not found");
			}			
	}
	
	//Viewing registered courses
	private static void viewRegisteredCourse() {
		Student student = findStudent();
		if (student != null) {
			student.displayRegisteredCourses();
		}
	}
	//Finding a student by ID
	private static Student findStudent() {
		System.out.print("Enter student ID:");
		String studentID = sc.nextLine();
		for (Student student : students) {
			if(student.getStudentID().equalsIgnoreCase(studentID)) {
				return student;
			}
		}
		System.out.println("Student not found in the list..");
		return null;
	}
	
	//find course by code
	private static Course findCourse(String courseCode) {
		for (Course course : courses) {
			if (course.getCourseCode().equalsIgnoreCase(courseCode)) {
				return course;
			}
		}
		return null;
	}
}
