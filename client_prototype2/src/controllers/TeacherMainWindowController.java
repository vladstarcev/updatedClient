package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.UserController;
import interfaces.IController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import ui.UserWindow;

public class TeacherMainWindowController implements IController  {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuItem DefineAssignment;

    @FXML
    private MenuButton TeacherMenuButton;

    @FXML
    private MenuItem EvaluationForm;

    @FXML
    private MenuItem checkAssMenuItem;

    @FXML
    private Label TeacherChooseLable;

    @FXML
    private Button LogOutButton;

    @FXML
    private Label TeacherMainLable;
    
    private  String UserID;

    @FXML
    void TeacherChooseOperation(ActionEvent event) {

    }

    @FXML
    void DefineAssignmentWindow(ActionEvent event) {
    	UserWindow.createUserWindow((Stage) LogOutButton.getScene().getWindow(), "TeacherDefineAssignment", getClass());
    }

    @FXML
    void Define(ActionEvent event) {

    }

    @FXML
    void EvaluationFormWindow(ActionEvent event) {
    	UserWindow.createUserWindow((Stage) TeacherMenuButton.getScene().getWindow(), "TeacherCreateEvaluationForm", getClass());
    }

    @FXML
    void GradeAndComments(ActionEvent event) {

    }

    @FXML
    void checkAss(ActionEvent event) {
    	UserWindow.createUserWindow((Stage) TeacherMenuButton.getScene().getWindow(), "CheckAssignment", getClass());
    }

    @FXML
    void LogOutTeacher(ActionEvent event) {
    	UserWindow.exitToMenu(getClass(), (Stage) TeacherMenuButton.getScene().getWindow());
    }

    @FXML
    void initialize() {
        assert DefineAssignment != null : "fx:id=\"DefineAssignment\" was not injected: check your FXML file 'TeacherMainWindow.fxml'.";
        assert TeacherMenuButton != null : "fx:id=\"TeacherMenuButton\" was not injected: check your FXML file 'TeacherMainWindow.fxml'.";
        assert EvaluationForm != null : "fx:id=\"EvaluationForm\" was not injected: check your FXML file 'TeacherMainWindow.fxml'.";
        assert checkAssMenuItem != null : "fx:id=\"checkAssMenuItem\" was not injected: check your FXML file 'TeacherMainWindow.fxml'.";
        assert TeacherChooseLable != null : "fx:id=\"TeacherChooseLable\" was not injected: check your FXML file 'TeacherMainWindow.fxml'.";
        assert LogOutButton != null : "fx:id=\"LogOutButton\" was not injected: check your FXML file 'TeacherMainWindow.fxml'.";
        assert TeacherMainLable != null : "fx:id=\"TeacherMainLable\" was not injected: check your FXML file 'TeacherMainWindow.fxml'.";

        Main.client.controller=this;
        UserID=UserID=UserController.CurrentUserID;
        Main.stack.push("TeacherMainWindow");

    }

	@Override
	public void handleAnswer(Object msg) {
		// TODO Auto-generated method stub
	}
}
