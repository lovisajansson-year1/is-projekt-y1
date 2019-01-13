package model;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StudentRegister studentRegister = new StudentRegister();
		CourseRegister courseRegister = new CourseRegister();
		
		Student marc = new Student("marc", studentRegister);
		studentRegister.addStudent(marc);
		studentRegister.printStudent(marc);
		studentRegister.updateStudent(marc.getStudentId(), "lovisa");
		studentRegister.printStudent(marc);
		
		Course sysa = new Course("Systemvetenskap", courseRegister);
		courseRegister.addCourse(sysa);
		courseRegister.printCourse(sysa);
		courseRegister.updateCourse(sysa.getCourseCode(), "sysa2");
		courseRegister.printCourse(sysa);
		
		WrittenExam exam = new WrittenExam("Room 1", sysa);
		sysa.addWrittenExam(exam);
		sysa.printExams();
		sysa.removeExam(exam.getExamID());
		sysa.printExams();

		Result result = new Result(marc,exam,55);
		System.out.println(marc.getResults().size());
		
	}

}
