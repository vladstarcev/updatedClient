package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import interfaces.IController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import ui.UserWindow;

public class SystemManagerMainWindowController implements IController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addCourseBtn;

    @FXML
    private Button deleteCourseBtn;

    @FXML
    private Button LogOutButton;

    @FXML
    void addCourse(ActionEvent event) {

    	UserWindow.createUserWindow((Stage)addCourseBtn.getScene().getWindow(), "SystemManagerAddCourse", getClass());
    	Main.stack.push("SystemManagerDeleteCourse");
    }

    @FXML
    void deleteCourse(ActionEvent event) {

    	UserWindow.createUserWindow((Stage)deleteCourseBtn.getScene().getWindow(), "SystemManagerDeleteCourse", getClass());
    	Main.stack.push("SystemManagerDeleteCourse");
    }

    @FXML
    void LogOutSystemManager(ActionEvent event) {
    	
    	UserWindow.closeUserWindow(getClass(), (Stage) deleteCourseBtn.getScene().getWindow());
    }

    @FXML
    void initialize() {
        assert addCourseBtn != null : "fx:id=\"addCourseBtn\" was not injected: check your FXML file 'SystemManagerMainWindow.fxml'.";
        assert deleteCourseBtn != null : "fx:id=\"deleteCourseBtn\" was not injected: check your FXML file 'SystemManagerMainWindow.fxml'.";
        assert LogOutButton != null : "fx:id=\"LogOutButton\" was not injected: check your FXML file 'SystemManagerMainWindow.fxml'.";

        Main.client.controller=this;
        
        
    }

	@Override
	public void handleAnswer(Object msg) {
		// TODO Auto-generated method stub
		
	}
}
