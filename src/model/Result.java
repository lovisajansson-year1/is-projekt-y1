package model;


//Ha calculateGrade(); innanför constructorn?
//Kalla calculateGrade(); När setCredits(); blir kallad?

public class Result {

	private int points;
	private String grade;
	private Student student;
	private WrittenExam exam;
	
	//ber�kna betyg och dubbelkoppla till student och exam
	public Result(Student student, WrittenExam exam, int points, String grade) {
		this.student = student;
		this.exam = exam;
		this.points = points;
		this.grade = grade;
	}
	
		

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
		return exam;
	}
	public void setExam(WrittenExam exam) {
		this.exam = exam;
	}
	
	
	
	
}
