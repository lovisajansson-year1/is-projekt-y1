package model;

import java.util.ArrayList;

public class CourseRegister {


	private ArrayList<Course> courses = new ArrayList<Course>();
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}
	public void addCourse(Course course) {
		this.courses.add(course); //Course added.
	}

	public Course findCourse(String courseCode) {
		for(Course tmp: this.courses) {
			if(tmp.getCourseCode().equals(courseCode)) {
				return tmp;
			}
		}
		return null;

	}
	public WrittenExam findWrittenExam(String examId) {
		for(Course course: this.courses) {
			for(WrittenExam exam: course.getWrittenExams() ) {
				if(exam.getExamID().equals(examId)) {
					return exam;
				}
			}
		}
		return null;
	}
	
	public Course removeCourse(String courseCode) {
		Course tmp = this.findCourse(courseCode);
			if(tmp!=null){
				this.courses.remove(tmp);
			}
			return tmp;
		}
	
	public void updateCourse(String courseCode, String newName) {
		Course c = this.findCourse(courseCode);
		c.setName(newName);
  	}
	
	public void printCourse(Course course) {
		 
		if(this.findCourse(course.getCourseCode())!=null) {
				try {
					System.out.println("Course name: " + course.getName());
					
				} catch (NullPointerException ingetNamn) {
					System.out.println(" Course doesn't have a name!");
				}
				try {
					System.out.println("Course code: " + course.getCourseCode());
				} catch(NullPointerException ingetId) {
					System.out.println(" Course doesn't have a code ");
				}
	 		}
	 	else {
	 		System.out.println("Course doesn't exist in the course register");
	 	}
	 }	


	}
