package model;
import java.util.ArrayList;
public class Course {


	private String courseCode; // unique, begins with capital C followed by number between 1000 and 9999
	private String name;
	private double credits;
	private ArrayList<WrittenExam> writtenExams = new ArrayList<WrittenExam> ();
	private CourseRegister courseRegister;

	
	//Constructor som tilldelar namn samt dubbelkopplar till studentregister samt genererar kurskod
	public Course(String name, CourseRegister courseRegister, double credits) {
		this.name = name;
		this.courseRegister = courseRegister;
		this.courseCode = this.generateCourseCode(courseRegister);
		courseRegister.addCourse(this);
		this.credits = credits;
	}

	
	//getters & setters
	public String getCourseCode() {
		return courseCode;
	}
	public ArrayList<WrittenExam> getWrittenExams() {
		return writtenExams;
	}
	public void setWrittenExams(ArrayList<WrittenExam> writtenExams) {
		this.writtenExams = writtenExams;
	}
	// genererar kursid och checkar så att det inte redan finns
	public String generateCourseCode(CourseRegister courseRegister) {
		ArrayList<Course> course = courseRegister.getCourseRegister();
		String newCode;
		for(int i=10000+course.size(); i<100000; i++) {
			newCode = "C" + Integer.toString(i);
			for(Course tmp: course) {
				if(tmp.getCourseCode().equals(newCode)) {
					newCode = null;
					break;
				}
			}
			if(newCode != null) {
				return this.courseCode = newCode;
			}
		}
		return null;
	}



	public CourseRegister getCourseRegister() {
		return courseRegister;
	}
	public void setCourseRegister(CourseRegister courseRegister) {
		this.courseRegister = courseRegister;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getCredits() {
		return credits;
	}
	public void setCredits(double credits) {
		this.credits = credits;
	}


}
