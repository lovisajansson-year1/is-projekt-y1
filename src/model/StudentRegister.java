package model;
import java.util.ArrayList;

public class StudentRegister{
  private String namn;
  private ArrayList<Student> studenter = new ArrayList<Student>();

  public ArrayList<Student> getStudenter() {
    return this.studenter;
  }
  public void setStudenter(ArrayList<Student> studenter) {
    this.studenter = studenter;
  }

  public Student findStudent(String studentId) {
    for(Student s: this.studenter) {
      if(s.getStudentId().equals(studentId)) {
        return s;
      }
    }
    return null;
  }

  public Student removeStudent(String studentId) {
    Student s = this.findStudent(studentId);
    if(s != null) {
      this.studenter.remove(s);
    }
    return s;
  }

}
