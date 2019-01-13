package model;
import java.util.ArrayList;

public class StudentRegister{
  private String name;
  private ArrayList<Student> students = new ArrayList<Student>();

  public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public void setStudents(ArrayList<Student> students) {
	this.students = students;
}
public ArrayList<Student> getStudents() {
    return this.students;
  }

  public Student findStudent(String studentId) {
    for(Student s: this.students) {
      if(s.getStudentId().equals(studentId)) {
        return s;
      }
    }
    return null;
  }

  public Student removeStudent(String studentId) {
    Student s = this.findStudent(studentId);
    if(s != null) {
      this.students.remove(s);
    }
    return s;
  }

  public void updateStudent(String studentId, String newName) {
	  Student s = this.findStudent(studentId);
	  s.setName(newName);
  }
 public void addStudent(Student student) {
	 this.students.add(student);
 }
 public void printStudent(Student student) {
	 
	if(this.findStudent(student.getStudentId())!=null) {
			try {
				System.out.println("Name: " + student.getName());
				
			} catch (NullPointerException ingetNamn) {
				System.out.println("Student has no name");
			}
			try {
				System.out.println("StudentId: " + student.getStudentId());
			} catch(NullPointerException ingetId) {
				System.out.println("Student has not ID! ");
			}
 		}
 	else {
 		System.out.println("Student doesn't exist in the student register");
 	}
 }
}		
	
 

