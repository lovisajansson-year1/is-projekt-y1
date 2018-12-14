package model;


//Ha calculateGrade(); innanför constructorn?
//Kalla calculateGrade(); När setCredits(); blir kallad?

public class Result {

	private int credits;
	private String grade;
	private Student student;
	private WrittenExam exam;
	
	public Result(Student student, WrittenExam exam, int credits) {
		this.student = student;
		this.exam = exam;
		this.credits = credits;
		this.calculateGrade(credits);
		this.exam.addResult(this);
		this.student.addResult(this);
	}
	
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
		this.calculateGrade(credits);
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
	public WrittenExam getExam() {
		return exam;
	}
	public void setExam(WrittenExam exam) {
		this.exam = exam;
	}
	
	public String calculateGrade(int credits) {
		if(credits < 50) {
			return "F";
		} else if(credits < 55) {
			return "G";
		} else if(credits < 65) {
			return "D";
		} else if(credits < 75) {
			return "C";
		} else if(credits < 85) {
			return "B";
		} else if(credits < 100) {
			return "A";
		}
		return "F";
	}
	
	
}
