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
			controller.getStudentRegister().addStudent(marc);
			Student lovisa = new Student("Lovisa", controller.getStudentRegister());
			controller.getStudentRegister().addStudent(lovisa);
			Student klara = new Student("Klara", controller.getStudentRegister());
			controller.getStudentRegister().addStudent(klara);
			Student erik = new Student("Erik", controller.getStudentRegister());
			controller.getStudentRegister().addStudent(erik);
			
			//Create and add courses
			Course course1 = new Course("Course 1", controller.getCourseRegister());
			controller.getCourseRegister().addCourse(course1);
			Course course2 = new Course("Course 2", controller.getCourseRegister());
			controller.getCourseRegister().addCourse(course2);
			
			//Create  and add WrittenExams
			WrittenExam exam1 = new WrittenExam("Room A123", course1);
			course1.addWrittenExam(exam1);
			WrittenExam exam2 = new WrittenExam("Room A167", course2);
			course2.addWrittenExam(exam2);
			
			//Create results 
			Result resultMarc = new Result(marc, exam1, 99, "A");
			Result marc2 = new Result(marc, exam2, 70, "B");
			
			//Add results to students
			marc.addResult(resultMarc);
			marc.addResult(marc2);
			
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