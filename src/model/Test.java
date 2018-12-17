package model;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		CourseRegister kursregister = new CourseRegister();
		Course c = new Course("Systemvetenskap", kursregister);
		StudentRegister studentregister = new StudentRegister();
		Student s = new Student("Lovisa", studentregister);
		Student s2 = new Student("Marc", studentregister);
		WrittenExam w = new WrittenExam();
		c.addWrittenExam(w);
		studentregister.printStudents();
		kursregister.printCourses();
		kursregister.removeCourse(c.getCourseCode());
		kursregister.printCourses();
		Result tmp = new Result(s,w,22);
		tmp = new Result(s2,w,100);
		for(Result r: w.getResults()) {
			System.out.println(r.getGrade());
		}
		
	}

}
