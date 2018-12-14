package model;

import java.util.ArrayList;

public class CourseRegister {


	private ArrayList<Course> courseRegister = new ArrayList<Course>();
	private String name;



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Course> getCourseRegister() {
		return courseRegister;
	}

	public void setCourseRegister(ArrayList<Course> courseRegister) {
		this.courseRegister = courseRegister;
	}
	public void addCourse(Course course) {
		this.courseRegister.add(course); //Course added.
	}

	//returns ArrayList with all WrittenExams
	public ArrayList<WrittenExam> getExams() {
		ArrayList<WrittenExam> exams = new ArrayList<WrittenExam>();
		for(Course tmp: this.courseRegister ) {
			for(WrittenExam exam : tmp.getWrittenExams()) {
				exams.add(exam);
			}
		}
		return exams;
	}

	//returns ArrayList with all WrittenExam ID's
	public ArrayList<String> getExamIds() {
		ArrayList<String> examIds = new ArrayList<String>();
		for(Course tmp: this.courseRegister ) {
			for(WrittenExam exam : tmp.getWrittenExams()) {
				examIds.add(exam.getExamID());
			}
		}
		return examIds;
	}


	public Course findCourse(String courseCode) {
		for(Course tmp: this.courseRegister) {
			if(tmp.getCourseCode().equals(courseCode)) {
				return tmp;
			}
		}
		return null;

	}
	public Course removeCourse(String courseCode) {
		Course tmp = this.findCourse(courseCode);
			if(tmp!=null){
				this.courseRegister.remove(tmp);
			}
			return tmp;
		}


	public void printCourses() {
		for(Course tmp: courseRegister) {
			System.out.println(tmp.getName());
		}
	}

	}
