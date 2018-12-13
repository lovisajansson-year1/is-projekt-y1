package model;

import java.util.ArrayList;

public class Student {
	
	private String studentId; //Börjar med "S" sen 5 siffror ex. "S10032"
	private String name;
	//private ArrayList<WrittenExam> exams = new ArrayList<WrittenExam>();  BEhövs inte?
	private ArrayList<Result> results = new ArrayList<Result>();
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Result> getResults() {
		return results;
	}
	public void setResults(ArrayList<Result> results) {
		this.results = results;
	}
}
