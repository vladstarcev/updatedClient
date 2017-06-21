package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import interfaces.IController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import ui.UserWindow;

public class SecretaryMainWindowController implements IController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuButton ChooseMenuButton;

    @FXML
    private MenuItem OpenCourse;

    @FXML
    private MenuItem AssignPupilToClass;

    @FXML
    private Label SecretaryMenuLable;

    @FXML
    private MenuItem OpenExeptionalRequstMenu;

    @FXML
    private Label ChooseOperationalMenu;

    @FXML
    private Button LogOutButton;

    @FXML
    private MenuItem OpenSemester;

    @FXML
    private MenuItem DefineClass;

    @FXML
    void ChooseOperation(ActionEvent event) {

    }

    @FXML
    void OpenExeptionalRequstWindow(ActionEvent event) {

    	UserWindow.createUserWindow((Stage) ChooseOperationalMenu.getScene().getWindow(), "SecretaryOpenExeptionalRequest", getClass());
    }

    @FXML // Dont delete!
    void Delete(ActionEvent event) {
    	
    }

    @FXML
    void AssignPupilToClassWindow(ActionEvent event) {

    	UserWindow.createUserWindow((Stage) ChooseOperationalMenu.getScene().getWindow(), "SecretaryAssignPupilToClass", getClass());
    }

    @FXML // Dont delete!
    void AssignPupil(ActionEvent event) {

    }

    @FXML
    void OpenCourseWindow(ActionEvent event) {
    	
    	UserWindow.createUserWindow((Stage) ChooseOperationalMenu.getScene().getWindow(), "SecretaryOpenCourse", getClass());
    }

    @FXML // Dont delete!
    void OpenC(ActionEvent event) {

    }

    @FXML
    void OpenSemesterWindow(ActionEvent event) {

    	UserWindow.createUserWindow((Stage) ChooseOperationalMenu.getScene().getWindow(), "SecretaryOpenSemester", getClass());
    }

    @FXML // Dont delete!
    void OpenS(ActionEvent event) {

    }

    @FXML
    void DefineClassWindow(ActionEvent event) {

    	UserWindow.createUserWindow((Stage) ChooseOperationalMenu.getScene().getWindow(), "SecretaryDefineClass", getClass());
    }

    @FXML // Dont delete!
    void Define(ActionEvent event) {

    }

    @FXML
    void SecretaryLogOut(ActionEvent event) {
    	
    	UserWindow.closeUserWindow(getClass(), (Stage) SecretaryMenuLable.getScene().getWindow());

    }

    @FXML
    void initialize() {
        assert ChooseMenuButton != null : "fx:id=\"ChooseMenuButton\" was not injected: check your FXML file 'SecretaryMainWindow.fxml'.";
        assert OpenCourse != null : "fx:id=\"OpenCourse\" was not injected: check your FXML file 'SecretaryMainWindow.fxml'.";
        assert AssignPupilToClass != null : "fx:id=\"AssignPupilToClass\" was not injected: check your FXML file 'SecretaryMainWindow.fxml'.";
        assert SecretaryMenuLable != null : "fx:id=\"SecretaryMenuLable\" was not injected: check your FXML file 'SecretaryMainWindow.fxml'.";
        assert OpenExeptionalRequstMenu != null : "fx:id=\"OpenExeptionalRequstMenu\" was not injected: check your FXML file 'SecretaryMainWindow.fxml'.";
        assert ChooseOperationalMenu != null : "fx:id=\"ChooseOperationalMenu\" was not injected: check your FXML file 'SecretaryMainWindow.fxml'.";
        assert LogOutButton != null : "fx:id=\"LogOutButton\" was not injected: check your FXML file 'SecretaryMainWindow.fxml'.";
        assert OpenSemester != null : "fx:id=\"OpenSemester\" was not injected: check your FXML file 'SecretaryMainWindow.fxml'.";
        assert DefineClass != null : "fx:id=\"DefineClass\" was not injected: check your FXML file 'SecretaryMainWindow.fxml'.";

        Main.client.controller=this;
    }

	@Override
	public void handleAnswer(Object msg) {
		// TODO Auto-generated method stub
		
	}
}
