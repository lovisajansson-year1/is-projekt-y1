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

	//skriver ut alla kursers namn
	public void printCourses() {
		for(Course tmp: courses) {
			System.out.println(tmp.getName());
		}
	}
	


	}
