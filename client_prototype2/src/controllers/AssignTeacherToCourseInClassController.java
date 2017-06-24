package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import interfaces.IController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AssignTeacherToCourseInClassController implements IController
{

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField CourseDTextField;

	@FXML
	private TextField ClassIDTextField;

	@FXML
	private Button BackButton;

	@FXML
	private Label ClassIDLable;

	@FXML
	private ComboBox<?> TeacherComboBox;

	@FXML
	private Button CheckCourseButton;

	@FXML
	private Button AssignTeacherButton;

	@FXML
	private TextField StudyUnitTextField;

	@FXML
	private Button CheckClassButton;

	@FXML
	private Label StudyUnitLabel;

	@FXML
	private Button CheckStudyUnitButton;

	@FXML
	private Label CourseIDLable;

	@FXML
	private Label AssignLabel;

	@FXML
	void CheckCourseID(ActionEvent event)
	{

	}

	@FXML
	void CheckClassID(ActionEvent event)
	{

	}

	@FXML
	void CheckStudyUnitID(ActionEvent event)
	{

	}

	@FXML
	void BackToMenu(ActionEvent event)
	{

	}

	@FXML
	void AssignTeacher(ActionEvent event)
	{

	}

	@FXML
	void TeacherList(ActionEvent event)
	{

	}

	@FXML
	void initialize()
	{
		assert CourseDTextField != null : "fx:id=\"CourseDTextField\" was not injected: check your FXML file 'SecretaryAssignTeacherToCourseInClass.fxml'.";
		assert ClassIDTextField != null : "fx:id=\"ClassIDTextField\" was not injected: check your FXML file 'SecretaryAssignTeacherToCourseInClass.fxml'.";
		assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'SecretaryAssignTeacherToCourseInClass.fxml'.";
		assert ClassIDLable != null : "fx:id=\"ClassIDLable\" was not injected: check your FXML file 'SecretaryAssignTeacherToCourseInClass.fxml'.";
		assert TeacherComboBox != null : "fx:id=\"TeacherComboBox\" was not injected: check your FXML file 'SecretaryAssignTeacherToCourseInClass.fxml'.";
		assert CheckCourseButton != null : "fx:id=\"CheckCourseButton\" was not injected: check your FXML file 'SecretaryAssignTeacherToCourseInClass.fxml'.";
		assert AssignTeacherButton != null : "fx:id=\"AssignTeacherButton\" was not injected: check your FXML file 'SecretaryAssignTeacherToCourseInClass.fxml'.";
		assert StudyUnitTextField != null : "fx:id=\"StudyUnitTextField\" was not injected: check your FXML file 'SecretaryAssignTeacherToCourseInClass.fxml'.";
		assert CheckClassButton != null : "fx:id=\"CheckClassButton\" was not injected: check your FXML file 'SecretaryAssignTeacherToCourseInClass.fxml'.";
		assert StudyUnitLabel != null : "fx:id=\"StudyUnitLabel\" was not injected: check your FXML file 'SecretaryAssignTeacherToCourseInClass.fxml'.";
		assert CheckStudyUnitButton != null : "fx:id=\"CheckStudyUnitButton\" was not injected: check your FXML file 'SecretaryAssignTeacherToCourseInClass.fxml'.";
		assert CourseIDLable != null : "fx:id=\"CourseIDLable\" was not injected: check your FXML file 'SecretaryAssignTeacherToCourseInClass.fxml'.";
		assert AssignLabel != null : "fx:id=\"AssignLabel\" was not injected: check your FXML file 'SecretaryAssignTeacherToCourseInClass.fxml'.";

	}

	@Override
	public void handleAnswer(Object msg)
	{
		// TODO Auto-generated method stub

	}
}
