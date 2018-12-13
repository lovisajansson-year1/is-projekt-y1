package model;
import java.util.ArrayList;
public class Course {

	
	private String courseCode; // unique, begins with capital C followed by number between 1000 and 9999
	private String name;
	private double credits;
//	private ArrayList<WrittenExam> writtenExams = new ArrayList<WrittenExam> ();
	
	//getters & setters
	public String getCourseCode() {
		return courseCode;
	}
//	public ArrayList<WrittenExam> getWrittenExams() {
//		return writtenExams;
//	}
//	public void setWrittenExams(ArrayList<WrittenExam> writtenExams) {
//		this.writtenExams = writtenExams;
//	}
	public void setCourseCode(String courseCode) {
		
		if(courseCode.charAt(0)==('C')) {
			String courseCodeSubstring = courseCode.substring(1,5);
			try {
				int code = Integer.parseInt("courseCodeSubstring");
			} catch(Exception notnumbers) {
				System.out.println("Coursecode must be a C followed by 5 numbers");
			}
			this.courseCode = courseCode;
		}
			
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
