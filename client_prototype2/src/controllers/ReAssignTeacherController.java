package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import interfaces.IController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ReAssignTeacherController implements IController
{

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField ClassIDTextField;

	@FXML
	private Button CheckRequestButton;

	@FXML
	private Button BackButton;

	@FXML
	private Label TeacherIdLabel;

	@FXML
	private Label ClassIDLable;

	@FXML
	private Label ReAssignLable;

	@FXML
	private TextField TecherIDTextField1;

	@FXML
	private Button CheckTeacherButton;

	@FXML
	private Button CheckCourseButton;

	@FXML
	private TextField TecherIDTextField;

	@FXML
	private TextField TeacherIdTextFieald;

	@FXML
	private Label RequestIdLabel;

	@FXML
	private Button CheckClassButton;

	@FXML
	private Button ReAssignTeacherButton;

	@FXML
	private Label CourseIDLable;

	@FXML
	void CheckRequestID(ActionEvent event)
	{

	}

	@FXML
	void CheckCourseID(ActionEvent event)
	{

	}

	@FXML
	void BackToMenu(ActionEvent event)
	{

	}

	@FXML
	void ReAssignTeacher(ActionEvent event)
	{

	}

	@FXML
	void CheckClassID(ActionEvent event)
	{

	}

	@FXML
	void CheckTeacherID(ActionEvent event)
	{

	}

	@FXML
	void initialize()
	{
		assert ClassIDTextField != null : "fx:id=\"ClassIDTextField\" was not injected: check your FXML file 'SecretaryReAssignTeacher.fxml'.";
		assert CheckRequestButton != null : "fx:id=\"CheckRequestButton\" was not injected: check your FXML file 'SecretaryReAssignTeacher.fxml'.";
		assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'SecretaryReAssignTeacher.fxml'.";
		assert TeacherIdLabel != null : "fx:id=\"TeacherIdLabel\" was not injected: check your FXML file 'SecretaryReAssignTeacher.fxml'.";
		assert ClassIDLable != null : "fx:id=\"ClassIDLable\" was not injected: check your FXML file 'SecretaryReAssignTeacher.fxml'.";
		assert ReAssignLable != null : "fx:id=\"ReAssignLable\" was not injected: check your FXML file 'SecretaryReAssignTeacher.fxml'.";
		assert TecherIDTextField1 != null : "fx:id=\"TecherIDTextField1\" was not injected: check your FXML file 'SecretaryReAssignTeacher.fxml'.";
		assert CheckTeacherButton != null : "fx:id=\"CheckTeacherButton\" was not injected: check your FXML file 'SecretaryReAssignTeacher.fxml'.";
		assert CheckCourseButton != null : "fx:id=\"CheckCourseButton\" was not injected: check your FXML file 'SecretaryReAssignTeacher.fxml'.";
		assert TecherIDTextField != null : "fx:id=\"TecherIDTextField\" was not injected: check your FXML file 'SecretaryReAssignTeacher.fxml'.";
		assert TeacherIdTextFieald != null : "fx:id=\"TeacherIdTextFieald\" was not injected: check your FXML file 'SecretaryReAssignTeacher.fxml'.";
		assert RequestIdLabel != null : "fx:id=\"RequestIdLabel\" was not injected: check your FXML file 'SecretaryReAssignTeacher.fxml'.";
		assert CheckClassButton != null : "fx:id=\"CheckClassButton\" was not injected: check your FXML file 'SecretaryReAssignTeacher.fxml'.";
		assert ReAssignTeacherButton != null : "fx:id=\"ReAssignTeacherButton\" was not injected: check your FXML file 'SecretaryReAssignTeacher.fxml'.";
		assert CourseIDLable != null : "fx:id=\"CourseIDLable\" was not injected: check your FXML file 'SecretaryReAssignTeacher.fxml'.";

	}

	@Override
	public void handleAnswer(Object msg)
	{
		// TODO Auto-generated method stub

	}
}
