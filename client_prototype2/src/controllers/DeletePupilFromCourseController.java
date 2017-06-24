package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import interfaces.IController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DeletePupilFromCourseController implements IController
{

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button CheckPupilButton;

	@FXML
	private Button CheckCourseButton;

	@FXML
	private TextField RequestIdTextField;

	@FXML
	private Button CheckRequestButton;

	@FXML
	private Label PupilIDLable;

	@FXML
	private TextField PupilIDTextField;

	@FXML
	private Button DeleteButton;

	@FXML
	private TextField CourseIDTextField;

	@FXML
	private Label RequestIdLabel;

	@FXML
	private Button BackButton;

	@FXML
	private Label DeleteLable;

	@FXML
	private Label CourseIDLable;

	@FXML
	void CheckPupilID(ActionEvent event)
	{

	}

	@FXML
	void CheckCourseID(ActionEvent event)
	{

	}

	@FXML
	void DeletePupilCourse(ActionEvent event)
	{

	}

	@FXML
	void CheckRequestID(ActionEvent event)
	{

	}

	@FXML
	void BackToMenu(ActionEvent event)
	{

	}

	@FXML
	void initialize()
	{
		assert CheckPupilButton != null : "fx:id=\"CheckPupilButton\" was not injected: check your FXML file 'SecretaryDeletePupilFromCourse.fxml'.";
		assert CheckCourseButton != null : "fx:id=\"CheckCourseButton\" was not injected: check your FXML file 'SecretaryDeletePupilFromCourse.fxml'.";
		assert RequestIdTextField != null : "fx:id=\"RequestIdTextField\" was not injected: check your FXML file 'SecretaryDeletePupilFromCourse.fxml'.";
		assert CheckRequestButton != null : "fx:id=\"CheckRequestButton\" was not injected: check your FXML file 'SecretaryDeletePupilFromCourse.fxml'.";
		assert PupilIDLable != null : "fx:id=\"PupilIDLable\" was not injected: check your FXML file 'SecretaryDeletePupilFromCourse.fxml'.";
		assert PupilIDTextField != null : "fx:id=\"PupilIDTextField\" was not injected: check your FXML file 'SecretaryDeletePupilFromCourse.fxml'.";
		assert DeleteButton != null : "fx:id=\"DeleteButton\" was not injected: check your FXML file 'SecretaryDeletePupilFromCourse.fxml'.";
		assert CourseIDTextField != null : "fx:id=\"CourseIDTextField\" was not injected: check your FXML file 'SecretaryDeletePupilFromCourse.fxml'.";
		assert RequestIdLabel != null : "fx:id=\"RequestIdLabel\" was not injected: check your FXML file 'SecretaryDeletePupilFromCourse.fxml'.";
		assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'SecretaryDeletePupilFromCourse.fxml'.";
		assert DeleteLable != null : "fx:id=\"DeleteLable\" was not injected: check your FXML file 'SecretaryDeletePupilFromCourse.fxml'.";
		assert CourseIDLable != null : "fx:id=\"CourseIDLable\" was not injected: check your FXML file 'SecretaryDeletePupilFromCourse.fxml'.";

	}

	@Override
	public void handleAnswer(Object msg)
	{
		// TODO Auto-generated method stub

	}
}
