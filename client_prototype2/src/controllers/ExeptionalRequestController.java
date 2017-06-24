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

public class ExeptionalRequestController implements IController
{

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;
	
    @FXML
    private Button TeacherButton;

	@FXML
	private Label ChooseExeptionalRequestLabel;
	
    @FXML
    private Label ExeptionalRequestLabel;

	@FXML
	private Button BackButton;

    @FXML
    private Button PupilButton;

	@FXML
	void DeleteOrAssignPupil(ActionEvent event)
	{

		UserWindow.createUserWindow((Stage) BackButton.getScene().getWindow(), "ExeptionalRequestForPupil", getClass());

	}

	@FXML
	void ReAssignTeacher(ActionEvent event)
	{

		UserWindow.createUserWindow((Stage) BackButton.getScene().getWindow(), "ExeptionalRequestForTeacher",
				getClass());
	}

	@FXML
	void BackToMenu(ActionEvent event)
	{

		UserWindow.closeUserWindow(getClass(), (Stage) ExeptionalRequestLabel.getScene().getWindow());
	}

	@FXML
	void initialize()
	{
		assert TeacherButton != null : "fx:id=\"TeacherButton\" was not injected: check your FXML file 'SecretaryOpenExeptionalRequest.fxml'.";
		assert ChooseExeptionalRequestLabel != null : "fx:id=\"ChooseExeptionalRequestLabel\" was not injected: check your FXML file 'SecretaryOpenExeptionalRequest.fxml'.";
		assert ExeptionalRequestLabel != null : "fx:id=\"ExeptionalRequestLabel\" was not injected: check your FXML file 'SecretaryOpenExeptionalRequest.fxml'.";
		assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'SecretaryOpenExeptionalRequest.fxml'.";
		assert PupilButton != null : "fx:id=\"PupilButton\" was not injected: check your FXML file 'SecretaryOpenExeptionalRequest.fxml'.";

		Main.client.controller = this;
	}

	@Override
	public void handleAnswer(Object msg)
	{
		// TODO Auto-generated method stub

	}
}
