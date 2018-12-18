package model;


import java.net.URL;
import java.util.ResourceBundle;
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
	

	
	
}
