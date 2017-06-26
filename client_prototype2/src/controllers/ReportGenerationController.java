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

public class ReportGenerationController implements IController
{

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private MenuButton ReportMenuButton;

	@FXML
	private Button BackButton;

	@FXML
	private MenuItem BetweenCourses;

	@FXML
	private MenuItem BetweenTeachers;

	@FXML
	private Label ReportWindowLabel;

	@FXML
	private MenuItem BetweenClasses;

	@FXML
	void BackToMenu(ActionEvent event)
	{

	}

	@FXML
	void ChooseReport(ActionEvent event)
	{

	}

	@FXML
	void ClassesOfTeacher(ActionEvent event)
	{

		UserWindow.createUserWindow((Stage) ReportWindowLabel.getScene().getWindow(),
				"ReportBetweenClassesOfSpecificTeacher", getClass());

	}

	@FXML
	void CoursesInClass(ActionEvent event)
	{

		UserWindow.createUserWindow((Stage) ReportWindowLabel.getScene().getWindow(), "ReportBetweenDiferentCoursesOfSpecificClass", getClass());
	}

	@FXML
	void TeachersInClass(ActionEvent event)
	{

		UserWindow.createUserWindow((Stage) ReportWindowLabel.getScene().getWindow(),
				"ReportBetweenTeachersOfSpecificClass", getClass());
	}

	@FXML
	void initialize()
	{
		assert ReportMenuButton != null : "fx:id=\"ReportMenuButton\" was not injected: check your FXML file 'SchoolManagerReportGeneration.fxml'.";
		assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'SchoolManagerReportGeneration.fxml'.";
		assert BetweenCourses != null : "fx:id=\"BetweenCourses\" was not injected: check your FXML file 'SchoolManagerReportGeneration.fxml'.";
		assert BetweenTeachers != null : "fx:id=\"BetweenTeachers\" was not injected: check your FXML file 'SchoolManagerReportGeneration.fxml'.";
		assert ReportWindowLabel != null : "fx:id=\"ReportWindowLabel\" was not injected: check your FXML file 'SchoolManagerReportGeneration.fxml'.";
		assert BetweenClasses != null : "fx:id=\"BetweenClasses\" was not injected: check your FXML file 'SchoolManagerReportGeneration.fxml'.";

		Main.client.controller = this;
	}

	@Override
	public void handleAnswer(Object msg)
	{
		// TODO Auto-generated method stub

	}
}
