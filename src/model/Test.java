package model;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StudentRegister studentRegister = new StudentRegister();
		CourseRegister courseRegister = new CourseRegister();
		
		Student marc = new Student("marc", studentRegister);
		studentRegister.printStudent(marc);
		studentRegister.updateStudent(marc.getStudentId(), "lovisa");
		studentRegister.printStudent(marc);
		studentRegister.removeStudent(marc.getStudentId());
		System.out.println("number of students in register: " + studentRegister.getStudents().size());
		
		Course sysa = new Course("Systemvetenskap", courseRegister);
		courseRegister.printCourse(sysa);
		courseRegister.updateCourse(sysa.getCourseCode(), "sysa2");
		courseRegister.printCourse(sysa);
		courseRegister.removeCourse(sysa.getCourseCode());
		System.out.println("number of courses in register: " + courseRegister.getCourses().size());
		
		WrittenExam exam = new WrittenExam("Room 1", sysa);
		System.out.println("number of exams for course: " + sysa.getWrittenExams().size());
		sysa.removeExam(exam.getExamID());
		System.out.println("number of exams for course: " + sysa.getWrittenExams().size());

		Result result = new Result(marc,exam,55);
		System.out.println("number of results for " + marc.getName() + ": " + marc.getResults().size());
		
	}

}
