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
    private Button deleteUserBtn;

    @FXML
    private Button addCourseBtn;

    @FXML
    private Button addUserBtn;

    @FXML
    private Button deleteCourseBtn;

    @FXML
    private Button LogOutButton;

    @FXML
    void addUser(ActionEvent event) {
    	
    	Stage stage = new Stage();
    	UserWindow.createUserWindow(stage, "SystemManagerAddUser", getClass());
		Main.stack.push("SystemManagerAddUser");
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
    void LogOutSystemManager(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert deleteUserBtn != null : "fx:id=\"deleteUserBtn\" was not injected: check your FXML file 'SystemManagerMainWindow.fxml'.";
        assert addCourseBtn != null : "fx:id=\"addCourseBtn\" was not injected: check your FXML file 'SystemManagerMainWindow.fxml'.";
        assert addUserBtn != null : "fx:id=\"addUserBtn\" was not injected: check your FXML file 'SystemManagerMainWindow.fxml'.";
        assert deleteCourseBtn != null : "fx:id=\"deleteCourseBtn\" was not injected: check your FXML file 'SystemManagerMainWindow.fxml'.";
        assert LogOutButton != null : "fx:id=\"LogOutButton\" was not injected: check your FXML file 'SystemManagerMainWindow.fxml'.";

        Main.client.controller=this;
    }

	@Override
	public void handleAnswer(Object msg) {
		// TODO Auto-generated method stub
		
	}
}
