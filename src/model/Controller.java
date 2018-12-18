package model;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
			selectedCourse.addWrittenExam(newExam);//Add exam to the course the user selected
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
		
		
		
		@FXML public void addResult() {
			messagesArea.setText("");
			int credits = 0;
			String examString = (String) this.pickExam.getValue();
			String studentString = (String) this.pickStudent.getValue();
			if(examString == null || studentString == null) {
				messagesArea.setText("You have to select a student and an exam to add result");
				return;
			}
			//Check if the user input is able to be turned in to a in. No letters allowed as input
			try {
				credits = Integer.parseInt(resultText.getText());
			} catch(Error err) {
				messagesArea.setText("The result must be a number between 0 and 100");//Errormessage 
			}
			if(credits >= 0 && credits <= 100) {
				messagesArea.setText("Grade: " + this.calculateGrade(credits) + "  Credits: " + credits);
			} else {
				messagesArea.setText("Write a number between 0 and 100");
			}
			String studentId = studentString.substring(studentString.length() - 6, studentString.length());
			String examId = examString.substring(0, 6);
			Student student = studentRegister.findStudent(studentId);
			WrittenExam exam = courseRegister.findWrittenExam(examId);
			Result result = new Result(student, exam, credits);//l�gger till resultat till student och exam och dubbelkopplar genom constructor.
			messagesArea.setText("Grade " + result.getGrade() + " (" + result.getPoints() + " points) was registered for " + student.getName() + " on exam " + examId);
			resultText.setText("");
		}
		
		//Shows all results for student, even on removed exams
		@FXML public void showResults() {
			messagesArea.setText("");
			String studentString = (String) pickStudent.getValue();//Selected student
			if(studentString == null) {
				messagesArea.setText("You have to pick a student to show results for");
				return;
			}
			String studentId = studentString.substring(studentString.length() - 6, studentString.length());
			Student student = studentRegister.findStudent(studentId);
			if(student != null) {
				messagesArea.setText("Results for student " + student.getName() + "\n");//Headline
				//For every exam the student has taken show grade, course, exam, points
				for(Result result: student.getResults()) {
					messagesArea.setText(messagesArea.getText() + "\n Exam: " + result.getExam().getExamID() + "  Course: " + result.getExam().getCourse().getName() + "  Grade: " + result.getGrade() + "  Points: " + result.getPoints());
				}
			}
		}
		//Turn points into grade
		public String calculateGrade(int credits) {
			if(credits < 50) {
				return "F";
			} else if(credits < 55) {
				return "G";
			} else if(credits < 65) {
				return "D";
			} else if(credits < 75) {
				return "C";
			} else if(credits < 85) {
				return "B";
			} else if(credits < 100) {
				return "A";
			}
			return "F";
		}	
		
		//To be able to show the list of students 
		//we have to turn the array list of type Student to an array list of type String
		public ArrayList<String> studentsToStrings(ArrayList<Student> students) {
			ArrayList<String> stringStudents = new ArrayList<String>();//Array list to be displayed in the list
			//Make the string to be displayed in the list and add it to the list for every student in the db/register
			for(Student s: students) {
				String studentString = "Name: " + s.getName() + ", Id: " + s.getStudentId();
				stringStudents.add(studentString);
			}
			return stringStudents;
		}
		//Same for courses
		public ArrayList<String> coursesToStrings(ArrayList<Course> courses) {
			ArrayList<String> stringCourses = new ArrayList<String>();
			for(Course c: courses) {
				String courseString = "Name: " + c.getName() + ", Id: " + c.getCourseCode();
				stringCourses.add(courseString);
			}
			return stringCourses;
		}
		//Same for Exams
		public ArrayList<String> examsToStrings(ArrayList<WrittenExam> exams) {
			ArrayList<String> stringExams = new ArrayList<String>();
			for(WrittenExam e: exams) {
				String examString = e.getExamID() + ", Location: " + e.getLocation() + " course: " + e.getCourse().getCourseCode();
				stringExams.add(examString);
			}
			return stringExams;
		}
	
}
