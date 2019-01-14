package model;



public class Result {

	private int points;
	private char grade;
	private Student student;
	private WrittenExam exam;
	
	//ber�kna betyg och dubbelkoppla till student och exam

	public Result(Student student, WrittenExam exam, int points) {
		this.student = student;
		this.exam = exam;
		this.points = points;
		this.grade = this.calculateGrade(points);
		student.addResult(this);
		this.exam.addResult(this);
	}
	public Result() {}

	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	
	}
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
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
	public char calculateGrade(int points) {
		if(points < 50) {
			return 'F';
		} else if(points < 55) {
			return 'G';
		} else if(points < 65) {
			return 'D';
		} else if(points < 75) {
			return 'C';
		} else if(points < 85) {
			return 'B';
		} else if(points <= 100) {
			return 'A';
		}
		return 'F';
	}	
	
	
	
}
