package controllers;

import java.io.IOException;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SystemManagerMainWindowController {

    @FXML
    private Button deleteUserBtn;

    @FXML
    private Button addCourseBtn;

    @FXML
    private Button exitBtn;

    @FXML
    private Button addUserBtn;

    @FXML
    private Button deleteCourseBtn;

    @FXML
    void addUser(ActionEvent event) {

    }
    
    public void start() throws IOException{
    	Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("/GUI/SystemManagerMainWindow.fxml").openStream());
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/GUI/SystemManagerMainWindow.css").toExternalForm());
		primaryStage.setScene(scene);		
		primaryStage.show();	
    }

    @FXML
    void addCourse(ActionEvent event) {

    }

    @FXML
    void deleteUser(ActionEvent event) {

    }

    @FXML
    void deleteCourse(ActionEvent event) {

    }

    @FXML
    void exitMenu(ActionEvent event) {

    }
    
	public void start(Stage primaryStage) throws Exception {	
		
	}

}
