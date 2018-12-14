package model;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		
		Course c = new Course();
		CourseRegister register = new CourseRegister();
		StudentRegister studentregister = new StudentRegister();
		Student s = new Student("Lovisa", studentregister);
		s.generateStudentId(studentregister);
		studentregister.addStudent(s);
		System.out.println(s.getName()+s.getStudentId()+studentregister.findStudent("S10000").getName());
		
	}

}
