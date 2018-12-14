package model;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		
		CourseRegister register = new CourseRegister();
		Course c = new Course("Systemvetenskap", register, 44);
		StudentRegister studentregister = new StudentRegister();
		Student s = new Student("Lovisa", studentregister);
		Student s2 = new Student("Marc", studentregister);
		studentregister.printStudents();
		register.printCourses();
		register.removeCourse(c.getCourseCode());
		register.printCourses();

	}

}
