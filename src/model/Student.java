package model;

import java.util.ArrayList;

public class Student {

	private String studentId; //Börjar med "S" sen 5 siffror ex. "S10032"
	private String name;
	private ArrayList<Result> results = new ArrayList<Result>();
	private StudentRegister register;
	

	public Student(String name, StudentRegister register) {
		this.name = name;
		this.register = register;
		this.studentId = this.generateStudentId(register);
		register.addStudent(this);
	}

	public String getStudentId() {
		return studentId;
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
	public void addResult(Result result) {
		this.results.add(result);
	}

	public StudentRegister getRegister() {
		return this.register;
	}

	public void setRegister(StudentRegister register) {
		this.register = register;
	}

	//Generate StudentId by comparing ids in the student register
	public String generateStudentId(StudentRegister register) {
		ArrayList<Student> studenter = register.getStudents();
		String newId;
		for(int i=10000+studenter.size(); i<100000; i++) {
			newId = "S" + Integer.toString(i);
			for(Student s: studenter) {
				if(s.getStudentId().equals(newId)) {
					newId = null;
					break;
				}
			}
			if(newId != null) {
				return this.studentId = newId;
			}
		}
		return null;
	}

	public String getName() {
		return name;
	}

}

