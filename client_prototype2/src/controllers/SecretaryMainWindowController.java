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

public class SecretaryMainWindowController implements IController
{

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
	private Label ChooseOperationalMenu;

	@FXML
	private Button LogOutButton;

	@FXML
	private MenuItem ReAssign;

	@FXML
	private MenuItem AssignTeacher;

	@FXML
	private MenuItem OpenExeptionalRequstMenu;

	@FXML
	private MenuItem DeletePupil;

	@FXML
	private MenuItem OpenSemester;

	@FXML
	private MenuItem DefineClass;

	@FXML
	void ChooseOperation(ActionEvent event)
	{

	}

	@FXML
	void OpenExeptionalRequstWindow(ActionEvent event)
	{

		UserWindow.createUserWindow((Stage) ChooseOperationalMenu.getScene().getWindow(),
				"SecretaryOpenExeptionalRequest", getClass());
	}

	@FXML
	void AssignPupilToClassWindow(ActionEvent event)
	{

		UserWindow.createUserWindow((Stage) ChooseOperationalMenu.getScene().getWindow(), "SecretaryAssignPupilToClass",
				getClass());
	}

	@FXML
	void OpenCourseWindow(ActionEvent event)
	{

		UserWindow.createUserWindow((Stage) ChooseOperationalMenu.getScene().getWindow(), "SecretaryOpenCourse",
				getClass());
	}

	@FXML
	void OpenSemesterWindow(ActionEvent event)
	{

		UserWindow.createUserWindow((Stage) ChooseOperationalMenu.getScene().getWindow(), "SecretaryOpenSemester",
				getClass());
	}

	@FXML
	void DefineClassWindow(ActionEvent event)
	{

		UserWindow.createUserWindow((Stage) ChooseOperationalMenu.getScene().getWindow(), "SecretaryDefineClass",
				getClass());
	}

	@FXML
	void AssignTeacherToCourse(ActionEvent event)
	{
		UserWindow.createUserWindow((Stage) ChooseOperationalMenu.getScene().getWindow(), "SecretaryAssignTeacherToCourseInClass",
				getClass());

	}

	@FXML
	void AssignPupilToCourse(ActionEvent event)
	{

		UserWindow.createUserWindow((Stage) ChooseOperationalMenu.getScene().getWindow(),
				"SecretaryAssignPupilToCourse", getClass());
	}

	@FXML
	void DeletePupilFromCourse(ActionEvent event)
	{

		UserWindow.createUserWindow((Stage) ChooseOperationalMenu.getScene().getWindow(),
				"SecretaryDeletePupilFromCourse", getClass());
	}

	@FXML
	void ReAssignTeacher(ActionEvent event)
	{

		UserWindow.createUserWindow((Stage) ChooseOperationalMenu.getScene().getWindow(), "SecretaryReAssignTeacher",
				getClass());
	}

	@FXML
	void SecretaryLogOut(ActionEvent event)
	{

		UserWindow.closeUserWindow(getClass(), (Stage) SecretaryMenuLable.getScene().getWindow());

	}

	@FXML
	void initialize()
	{
		assert ChooseMenuButton != null : "fx:id=\"ChooseMenuButton\" was not injected: check your FXML file 'SecretaryMainWindow.fxml'.";
		assert AssignPupil != null : "fx:id=\"AssignPupil\" was not injected: check your FXML file 'SecretaryMainWindow.fxml'.";
		assert OpenCourse != null : "fx:id=\"OpenCourse\" was not injected: check your FXML file 'SecretaryMainWindow.fxml'.";
		assert AssignPupilToClass != null : "fx:id=\"AssignPupilToClass\" was not injected: check your FXML file 'SecretaryMainWindow.fxml'.";
		assert SecretaryMenuLable != null : "fx:id=\"SecretaryMenuLable\" was not injected: check your FXML file 'SecretaryMainWindow.fxml'.";
		assert ChooseOperationalMenu != null : "fx:id=\"ChooseOperationalMenu\" was not injected: check your FXML file 'SecretaryMainWindow.fxml'.";
		assert LogOutButton != null : "fx:id=\"LogOutButton\" was not injected: check your FXML file 'SecretaryMainWindow.fxml'.";
		assert ReAssign != null : "fx:id=\"ReAssign\" was not injected: check your FXML file 'SecretaryMainWindow.fxml'.";
		assert AssignTeacher != null : "fx:id=\"AssignTeacher\" was not injected: check your FXML file 'SecretaryMainWindow.fxml'.";
		assert OpenExeptionalRequstMenu != null : "fx:id=\"OpenExeptionalRequstMenu\" was not injected: check your FXML file 'SecretaryMainWindow.fxml'.";
		assert DeletePupil != null : "fx:id=\"DeletePupil\" was not injected: check your FXML file 'SecretaryMainWindow.fxml'.";
		assert OpenSemester != null : "fx:id=\"OpenSemester\" was not injected: check your FXML file 'SecretaryMainWindow.fxml'.";
		assert DefineClass != null : "fx:id=\"DefineClass\" was not injected: check your FXML file 'SecretaryMainWindow.fxml'.";

		Main.client.controller = this;
	}

	@Override
	public void handleAnswer(Object msg)
	{
		// TODO Auto-generated method stub

	}
}
