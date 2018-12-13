package model;

public class Result {

	private int credits;
	private String grade;
	private Student student;
	private WrittenExam exam;
	
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Exam getExam() {
		return exam;
	}
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	
	public void calculateGrade() {
		if(this.credits < 50) {
			this.grade = "F";
		} else if(this.credits < 55) {
			this.grade = "G";
		} else if(this.credits < 65) {
			this.grade = "D";
		} else if(this.credits < 75) {
			this.grade = "C";
		} else if(this.credits < 85) {
			this.grade = "B";
		} else if(this.credits < 100) {
			this.grade = "A";
		}
	}
	
	
}
