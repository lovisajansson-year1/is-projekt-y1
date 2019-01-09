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
			Student marc = new Student("Marc", controller.getStudentRegister());
			Student lovisa = new Student("Lovisa", controller.getStudentRegister());
			controller.getStudentRegister().addStudent(marc);
			controller.getStudentRegister().addStudent(lovisa);
			controller.updateStudentList(controller.getStudentRegister().getStudents());
					
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