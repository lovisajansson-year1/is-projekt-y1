package model;
import java.util.ArrayList;

public class StudentRegister{
  private String namn;
  private ArrayList<Student> students = new ArrayList<Student>();

  public String getNamn() {
	return namn;
}
public void setNamn(String namn) {
	this.namn = namn;
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

}
