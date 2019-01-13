package model;


//Ha calculateGrade(); innanför constructorn?
//Kalla calculateGrade(); När setCredits(); blir kallad?

public class Result {

	private int points;
	private String grade;
	private Student student;
	private WrittenExam exam;
	
	//ber�kna betyg och dubbelkoppla till student och exam

	public Result(Student student, WrittenExam exam, int points) {
		this.student = student;
		this.exam = exam;
		this.points = points;
		this.grade = this.calculateGrade(points);
		student.addResult(this);
	}
	public Result() {}
	
		

	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	
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
		return this.exam;
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
		} else if(credits <= 100) {
			return "A";
		}
		return "F";
	}	
	
	
	
}
