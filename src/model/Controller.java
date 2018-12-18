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
		//The three methods below are the same as for student above
		//1
		@FXML public void addCourse(ActionEvent event) {
			messagesArea.setText("");
			this.addLocations();
			String newName = courseNameText.getText();
			if(newName.length() < 2) {
				messagesArea.setText("The name is too short");
				return;
			}
			Course newCourse = new Course(newName, courseRegister);
			courseRegister.addCourse(newCourse);
			messagesArea.setText("The course " + newCourse.getName()+ " with course code " +  newCourse.getCourseCode() + " har skapats!");
			this.updateCourseList(courseRegister.getCourses());
			courseNameText.setText("");
		}
		//2
		@FXML public void updateCourse() {
			messagesArea.setText("");
			String course = (String) pickCourse.getValue();
			String newName = courseNameText.getText();
			if(newName.length() < 2) {
				messagesArea.setText("The name is too short");
				return;
			}
			if(course != null) {
				String courseId = course.substring(course.length() - 6, course.length());
				courseRegister.updateCourse(courseId, newName);
				this.updateCourseList(courseRegister.getCourses());
				messagesArea.setText("The course has changed name to " + newName);
				courseNameText.setText("");
			} else {
				messagesArea.setText("You have to select a course to update");
			}
		}
		//3
		@FXML public void removeCourse() {
			String course = (String) pickCourse.getValue();
			if(course != null) {
				String courseId = course.substring(course.length() - 6, course.length());			
				courseRegister.removeCourse(courseId);
				this.updateCourseList(courseRegister.getCourses());
				this.updateExamList();
				messagesArea.setText(course + " was removed from courses");
			} else {
				messagesArea.setText("You have to select a course to delete");
			}		
		}
		//Add an exam to a course
		@FXML public void addExam() {
			messagesArea.setText("");
			String course = (String) pickCourse.getValue();//Get value/course from the course list
			String location = (String) pickLocation.getValue();//Get value/location from the location list
			//If no course or location is selected in the list, the user gets a error message
			if(course == null || location == null) {
				messagesArea.setText("You have to pick a course and a location to add an exam");
				return;//terminate method
			}
			String courseId = course.substring(course.length() - 6, course.length());
			Course selectedCourse = courseRegister.findCourse(courseId);//Get the course the user selected
			WrittenExam newExam = new WrittenExam(location, selectedCourse);//Create exam
			selectedCourse.addExam(newExam);//Add exam to the course the user selected
			this.updateExamList();//Update the exam list to make it possible for the user to select it
			messagesArea.setText("Exam was added to the course"); //Exam added successfully message to the user
		}
		
		//Same principles like above
		@FXML public void removeExam() { 
			messagesArea.setText("");
			String course = (String) pickCourse.getValue();
			String exam = (String) pickExam.getValue();
			if(course == null || exam == null) {
				messagesArea.setText("You have to pick a course to remove an exam");
				return;
			}
			String courseId = course.substring(course.length() - 6, course.length());
			String examId = exam.substring(0, 6);
			Course selectedCourse = courseRegister.findCourse(courseId);
			selectedCourse.removeExam(examId);
			this.updateExamList();
			messagesArea.setText(examId + " was removed from " + courseId);
		}
		
		

	
}
