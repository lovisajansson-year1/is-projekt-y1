package model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	static Controller controller;
@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			controller = (Controller) loader.getController();  
			
			
			//Test data
			//Create and add students
			Student marc = new Student("Marc", controller.getStudentRegister());
			Student lovisa = new Student("Lovisa", controller.getStudentRegister());
			Student klara = new Student("Klara", controller.getStudentRegister());
			Student erik = new Student("Erik", controller.getStudentRegister());
			
			//Create and add courses
			Course course1 = new Course("Course 1", controller.getCourseRegister());
			Course course2 = new Course("Course 2", controller.getCourseRegister());
			
			//Create  and add WrittenExams
			WrittenExam exam1 = new WrittenExam("Room A123", course1);
			WrittenExam exam2 = new WrittenExam("Room A167", course2);
			
			//Create results 
			Result resultMarc = new Result(marc, exam1, 99);
			Result marc2 = new Result(marc, exam2, 70);
			
						
			//Update interface
			controller.updateCourseList(controller.getCourseRegister().getCourses());			
			controller.updateStudentList(controller.getStudentRegister().getStudents());
			controller.addLocations();
			controller.updateExamList();
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	
			primaryStage.setScene(scene);
			primaryStage.setTitle("GUI-Lab");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}//End start
	public static void main(String[] args) {
		launch(args);
		
	}
	
}