package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import interfaces.IController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class TeacherExeptionalRequestController implements IController
{

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private ComboBox<?> ListTeacherComboBox;

	@FXML
	private TextField RequestIdTextField;

	@FXML
	private Label OperationLabel;

	@FXML
	private Button CheckIdButton;

	@FXML
	private Button BackButton;

	@FXML
	private ComboBox<?> ListCurseComboBox;

	@FXML
	private Label TeacherExeptionalLabel;

	@FXML
	private Label TeacherLabel;

	@FXML
	private MenuItem ReAssignLabel;

	@FXML
	private Label RequestIdLabel;

	@FXML
	private Label CourseLabel;

	@FXML
	private MenuButton OperationMenuButton;

	@FXML
	private Button SendButton;

	@FXML
	void ChooseCourse(ActionEvent event)
	{

	}

	@FXML
	void ChooseTeacher(ActionEvent event)
	{

	}

	@FXML
	void ChooseOperation(ActionEvent event)
	{

	}

	@FXML
	void ReAssignTeacher(ActionEvent event)
	{

	}

	@FXML
	void ReAssignMenu(ActionEvent event)
	{

	}

	@FXML
	void SendToSchoolManager(ActionEvent event)
	{

	}

	@FXML
	void BackToMenu(ActionEvent event)
	{

	}

	@FXML
	void CeckIdAvailability(ActionEvent event)
	{

	}

	@FXML
	void initialize()
	{
		assert ListTeacherComboBox != null : "fx:id=\"ListTeacherComboBox\" was not injected: check your FXML file 'ExeptionalRequestForTeacher.fxml'.";
		assert RequestIdTextField != null : "fx:id=\"RequestIdTextField\" was not injected: check your FXML file 'ExeptionalRequestForTeacher.fxml'.";
		assert OperationLabel != null : "fx:id=\"OperationLabel\" was not injected: check your FXML file 'ExeptionalRequestForTeacher.fxml'.";
		assert CheckIdButton != null : "fx:id=\"CheckIdButton\" was not injected: check your FXML file 'ExeptionalRequestForTeacher.fxml'.";
		assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'ExeptionalRequestForTeacher.fxml'.";
		assert ListCurseComboBox != null : "fx:id=\"ListCurseComboBox\" was not injected: check your FXML file 'ExeptionalRequestForTeacher.fxml'.";
		assert TeacherExeptionalLabel != null : "fx:id=\"TeacherExeptionalLabel\" was not injected: check your FXML file 'ExeptionalRequestForTeacher.fxml'.";
		assert TeacherLabel != null : "fx:id=\"TeacherLabel\" was not injected: check your FXML file 'ExeptionalRequestForTeacher.fxml'.";
		assert ReAssignLabel != null : "fx:id=\"ReAssignLabel\" was not injected: check your FXML file 'ExeptionalRequestForTeacher.fxml'.";
		assert RequestIdLabel != null : "fx:id=\"RequestIdLabel\" was not injected: check your FXML file 'ExeptionalRequestForTeacher.fxml'.";
		assert CourseLabel != null : "fx:id=\"CourseLabel\" was not injected: check your FXML file 'ExeptionalRequestForTeacher.fxml'.";
		assert OperationMenuButton != null : "fx:id=\"OperationMenuButton\" was not injected: check your FXML file 'ExeptionalRequestForTeacher.fxml'.";
		assert SendButton != null : "fx:id=\"SendButton\" was not injected: check your FXML file 'ExeptionalRequestForTeacher.fxml'.";

	}

	@Override
	public void handleAnswer(Object msg)
	{
		// TODO Auto-generated method stub

	}
}
