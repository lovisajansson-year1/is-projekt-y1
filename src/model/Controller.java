package model;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import copy.Course;
import copy.ObservableList;
import copy.Student;
import copy.WrittenExam;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

	@FXML private TextField studentNameText; //Holds the value the user has written in the student name box
	@FXML private TextField courseNameText; //Same for course
	@FXML private TextField resultText; //Same for result (0-100)
	@FXML private ComboBox pickStudent; //Currently selected student
	@FXML private ComboBox pickCourse; //Currently selected course
	@FXML private ComboBox pickExam;//Currently selected exam
	@FXML private ComboBox pickLocation;//Currently selected location
	@FXML private TextArea messagesArea;//Shows error messages and responses to the user interaction with the interface

	StudentRegister studentRegister = new StudentRegister();
	CourseRegister courseRegister = new CourseRegister();
	
	//Updates the list of students whenever a student is added, removed or updated
		public void updateStudentList(ArrayList<Student> students) {
			ObservableList<String> studentList = FXCollections
					.observableArrayList(this.studentsToStrings(students));
			pickStudent.setItems(studentList);
		}
		//Same for course
		public void updateCourseList(ArrayList<Course> courses) {
			ObservableList<String> courseList = FXCollections
					.observableArrayList(this.coursesToStrings(courses));
			pickCourse.setItems(courseList);
		}
		//Gets all the exams from all the courses, then updates the list of exams in the dropdown
		public void updateExamList() {
			ArrayList<WrittenExam> exams = new ArrayList<WrittenExam>();
			for(Course c: this.courseRegister.getCourses()) {
				for(WrittenExam w: c.getWrittenExams()) {
					exams.add(w);
				}
			}
			ObservableList<String> examList = FXCollections
					.observableArrayList(this.examsToStrings(exams));
			pickExam.setItems(examList);
		}
		//Adds the default locations to the locations dropdown, similar to methods above
		public void addLocations() {
			ObservableList<String> locations = FXCollections
					.observableArrayList("Room A123", "Room A167", "Room B198", "Room B067");
			pickLocation.setItems(locations);		
		}
		
		@FXML public void addStudent(ActionEvent event) {
			messagesArea.setText("");//Empties the text area in the bottom to prepare for new text
			String newName = studentNameText.getText();//Get name from text field for student name
			//If the user writes a name shorter than 2 characters the user gets a error message 
			if(newName.length() < 2) {
				messagesArea.setText("The name is too short");//Error message
				return;// Terminate method so the student isn't added to the "database" 
			}
			Student newStudent = new Student(studentNameText.getText(), studentRegister);//Create new student to add to the DB
			studentRegister.addStudent(newStudent);//Add to DB, method in class StudentRegister
			//Message the user that the user was created successfully (line below)
			messagesArea.setText("The student " + newStudent.getName()+ " with course code " +  newStudent.getStudentId() + " har skapats!");
			this.updateStudentList(studentRegister.getStudents());//Update the list of students, with the new student added
			studentNameText.setText("");//Remove the name the user wrote from the textfield
		}
		//Select student in list, write new name and click update student
		@FXML public void updateStudent() {
			messagesArea.setText("");
			String student = (String) pickStudent.getValue();//Get the student from the list (value that is shown in the box)
			String newName = studentNameText.getText();//Get the new name from the text field
			if(newName.length() < 2) {
				messagesArea.setText("The name is too short");
				return;
			}
			if(student != null) {
				String studentId = student.substring(student.length() - 6, student.length()); //Get the last 6 letters from the String student from the list
				studentRegister.updateStudent(studentId, studentNameText.getText());//Update the user in the db/register
				this.updateStudentList(studentRegister.getStudents());//Update the list of students
				messagesArea.setText("The student has changed name to " + studentNameText.getText());
				studentNameText.setText("");	
			} else {
				messagesArea.setText("You have to select a student to update");//Error message to the user
			}
		}

		@FXML public void removeStudent() {
			messagesArea.setText("");
			String student = (String) pickStudent.getValue();//The selected value/student in the student list
			if(student != null) {
				String studentId = student.substring(student.length() - 6, student.length());			
				studentRegister.removeStudent(studentId); //Remove student from DB
				this.updateStudentList(studentRegister.getStudents());
				messagesArea.setText(student + " was removed from students");
			} else {
				messagesArea.setText("You have to select a student to delete");
			}		
		}
	
	
}
