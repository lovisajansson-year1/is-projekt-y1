package model;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		
		Course c = new Course();
		CourseRegister register = new CourseRegister();
		StudentRegister studentregister = new StudentRegister();
		Student s = new Student("Lovisa", studentregister);
		Student s2 = new Student("Marc", studentregister);
		studentregister.printStudents();
	}

}
