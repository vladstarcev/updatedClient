package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import interfaces.IController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class ReportBetweenClassesController implements IController
{

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private BarChart<?, ?> ReportBarChart;

	@FXML
	private CategoryAxis SpecificTeacherAxis;

	@FXML
	private Button BackButton;

	@FXML
	private ComboBox<?> ChooseComboBox;

	@FXML
	private Label ReportLabel1;

	@FXML
	private Label ChooseLabel;

	@FXML
	private Label ReportLable2;

	@FXML
	private NumberAxis DifferentClassesAxis;

	@FXML
	void BackToMenu(ActionEvent event)
	{

	}

	@FXML
	void ChooseTeacher(ActionEvent event)
	{

	}

	@FXML
	void initialize()
	{
		assert ReportBarChart != null : "fx:id=\"ReportBarChart\" was not injected: check your FXML file 'ReportBetweenClassesOfSpecificTeacher.fxml'.";
		assert SpecificTeacherAxis != null : "fx:id=\"SpecificTeacherAxis\" was not injected: check your FXML file 'ReportBetweenClassesOfSpecificTeacher.fxml'.";
		assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'ReportBetweenClassesOfSpecificTeacher.fxml'.";
		assert ChooseComboBox != null : "fx:id=\"ChooseComboBox\" was not injected: check your FXML file 'ReportBetweenClassesOfSpecificTeacher.fxml'.";
		assert ReportLabel1 != null : "fx:id=\"ReportLabel1\" was not injected: check your FXML file 'ReportBetweenClassesOfSpecificTeacher.fxml'.";
		assert ChooseLabel != null : "fx:id=\"ChooseLabel\" was not injected: check your FXML file 'ReportBetweenClassesOfSpecificTeacher.fxml'.";
		assert ReportLable2 != null : "fx:id=\"ReportLable2\" was not injected: check your FXML file 'ReportBetweenClassesOfSpecificTeacher.fxml'.";
		assert DifferentClassesAxis != null : "fx:id=\"DifferentClassesAxis\" was not injected: check your FXML file 'ReportBetweenClassesOfSpecificTeacher.fxml'.";

	}

	@Override
	public void handleAnswer(Object msg)
	{
		// TODO Auto-generated method stub

	}
}
