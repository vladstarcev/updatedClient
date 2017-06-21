package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import interfaces.IController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import ui.UserWindow;

public class ExeptionalRequestController implements IController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label ChooseExeptionalRequestLabel;

    @FXML
    private Button DeletePupilFromCourseButton;

    @FXML
    private Label ExeptionalRequestLabel;

    @FXML
    private Button ChangeAppointmentButton;

    @FXML
    private Button BackButton;

    @FXML
    private Button AssignPupilToCourseButton;

    @FXML
    void AssignPupil(ActionEvent event) {
    	
    	UserWindow.createUserWindow((Stage) BackButton.getScene().getWindow(), "SecretaryAssignPupilToCourse", getClass());

    }

    @FXML
    void DeletePupil(ActionEvent event) {

    	UserWindow.createUserWindow((Stage) BackButton.getScene().getWindow(), "SecretaryDeletePupilFromCourse", getClass());
    }

    @FXML
    void ChangeAppoinment(ActionEvent event) {
    	

    }

    @FXML
    void BackToMenu(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert ChooseExeptionalRequestLabel != null : "fx:id=\"ChooseExeptionalRequestLabel\" was not injected: check your FXML file 'SecretaryOpenExeptionalRequest.fxml'.";
        assert DeletePupilFromCourseButton != null : "fx:id=\"DeletePupilFromCourseButton\" was not injected: check your FXML file 'SecretaryOpenExeptionalRequest.fxml'.";
        assert ExeptionalRequestLabel != null : "fx:id=\"ExeptionalRequestLabel\" was not injected: check your FXML file 'SecretaryOpenExeptionalRequest.fxml'.";
        assert ChangeAppointmentButton != null : "fx:id=\"ChangeAppointmentButton\" was not injected: check your FXML file 'SecretaryOpenExeptionalRequest.fxml'.";
        assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'SecretaryOpenExeptionalRequest.fxml'.";
        assert AssignPupilToCourseButton != null : "fx:id=\"AssignPupilToCourseButton\" was not injected: check your FXML file 'SecretaryOpenExeptionalRequest.fxml'.";

        Main.client.controller=this;
    }

	@Override
	public void handleAnswer(Object msg) {
		// TODO Auto-generated method stub
		
	}
}
