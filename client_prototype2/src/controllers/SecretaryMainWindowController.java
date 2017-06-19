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

public class SecretaryMainWindowController implements IController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuButton ChooseMenuButton;

    @FXML
    private MenuItem AssignPupil;

    @FXML
    private MenuItem OpenCourse;

    @FXML
    private MenuItem AssignPupilToClass;

    @FXML
    private Label SecretaryMenuLable;

    @FXML
    private MenuItem AssignTeacherCourseInClass;

    @FXML
    private Label ChooseOperationalMenu;

    @FXML
    private Button LogOutButton;

    @FXML
    private MenuItem DeletePupil;

    @FXML
    private MenuItem OpenExeptionalRequest;

    @FXML
    private MenuItem OpenSemester;

    @FXML
    private MenuItem DefineClass;

    @FXML
    void ChooseOperation(ActionEvent event) {

    }

    @FXML
    void DeletePupilWindow(ActionEvent event) {

    }

    @FXML
    void Delete(ActionEvent event) {

    }

    @FXML
    void AssignPupilWindow(ActionEvent event) {

    }

    @FXML
    void AssignToCourse(ActionEvent event) {

    }

    @FXML
    void AssignPupilToClassWindow(ActionEvent event) {

    }

    @FXML
    void AssignPupil(ActionEvent event) {

    }

    @FXML
    void AssignTeacherWindow(ActionEvent event) {

    }

    @FXML
    void AssignTeacher(ActionEvent event) {

    }

    @FXML
    void OpenCourseWindow(ActionEvent event) {

    }

    @FXML
    void OpenC(ActionEvent event) {

    }

    @FXML
    void OpenSemesterWindow(ActionEvent event) {

    }

    @FXML
    void OpenS(ActionEvent event) {

    }

    @FXML
    void DefineClassWindow(ActionEvent event) {

    }

    @FXML
    void Define(ActionEvent event) {

    }

    @FXML
    void OpenExeptionalRequestWindow(ActionEvent event) {

    }

    @FXML
    void OpenR(ActionEvent event) {

    }

    @FXML
    void SecretaryLogOut(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert ChooseMenuButton != null : "fx:id=\"ChooseMenuButton\" was not injected: check your FXML file 'SecretaryMainWindow.fxml'.";
        assert AssignPupil != null : "fx:id=\"AssignPupil\" was not injected: check your FXML file 'SecretaryMainWindow.fxml'.";
        assert OpenCourse != null : "fx:id=\"OpenCourse\" was not injected: check your FXML file 'SecretaryMainWindow.fxml'.";
        assert AssignPupilToClass != null : "fx:id=\"AssignPupilToClass\" was not injected: check your FXML file 'SecretaryMainWindow.fxml'.";
        assert SecretaryMenuLable != null : "fx:id=\"SecretaryMenuLable\" was not injected: check your FXML file 'SecretaryMainWindow.fxml'.";
        assert AssignTeacherCourseInClass != null : "fx:id=\"AssignTeacherCourseInClass\" was not injected: check your FXML file 'SecretaryMainWindow.fxml'.";
        assert ChooseOperationalMenu != null : "fx:id=\"ChooseOperationalMenu\" was not injected: check your FXML file 'SecretaryMainWindow.fxml'.";
        assert LogOutButton != null : "fx:id=\"LogOutButton\" was not injected: check your FXML file 'SecretaryMainWindow.fxml'.";
        assert DeletePupil != null : "fx:id=\"DeletePupil\" was not injected: check your FXML file 'SecretaryMainWindow.fxml'.";
        assert OpenExeptionalRequest != null : "fx:id=\"OpenExeptionalRequest\" was not injected: check your FXML file 'SecretaryMainWindow.fxml'.";
        assert OpenSemester != null : "fx:id=\"OpenSemester\" was not injected: check your FXML file 'SecretaryMainWindow.fxml'.";
        assert DefineClass != null : "fx:id=\"DefineClass\" was not injected: check your FXML file 'SecretaryMainWindow.fxml'.";

       Main.client.controller=this;
    }

	@Override
	public void handleAnswer(Object msg) {
		// TODO Auto-generated method stub
		
	}
}