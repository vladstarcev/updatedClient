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

public class ReportBetweenCoursesController implements IController
{

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private NumberAxis DifferentCoursesAxis;

	@FXML
	private Button BackButton;

	@FXML
	private ComboBox<?> ChooseComboBox;

	@FXML
	private Label ReportLabel1;

	@FXML
	private Label ChooseLabel;

	@FXML
	private BarChart<?, ?> ReportChart;

	@FXML
	private CategoryAxis SpecificClassAxis;

	@FXML
	private Label ReportLabel2;

	@FXML
	void BackToMenu(ActionEvent event)
	{

	}

	@FXML
	void ChooseClass(ActionEvent event)
	{

	}

	@FXML
	void initialize()
	{
		assert DifferentCoursesAxis != null : "fx:id=\"DifferentCoursesAxis\" was not injected: check your FXML file 'ReportBetweenDiferentCoursesOfSpecificClass.fxml'.";
		assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'ReportBetweenDiferentCoursesOfSpecificClass.fxml'.";
		assert ChooseComboBox != null : "fx:id=\"ChooseComboBox\" was not injected: check your FXML file 'ReportBetweenDiferentCoursesOfSpecificClass.fxml'.";
		assert ReportLabel1 != null : "fx:id=\"ReportLabel1\" was not injected: check your FXML file 'ReportBetweenDiferentCoursesOfSpecificClass.fxml'.";
		assert ChooseLabel != null : "fx:id=\"ChooseLabel\" was not injected: check your FXML file 'ReportBetweenDiferentCoursesOfSpecificClass.fxml'.";
		assert ReportChart != null : "fx:id=\"ReportChart\" was not injected: check your FXML file 'ReportBetweenDiferentCoursesOfSpecificClass.fxml'.";
		assert SpecificClassAxis != null : "fx:id=\"SpecificClassAxis\" was not injected: check your FXML file 'ReportBetweenDiferentCoursesOfSpecificClass.fxml'.";
		assert ReportLabel2 != null : "fx:id=\"ReportLabel2\" was not injected: check your FXML file 'ReportBetweenDiferentCoursesOfSpecificClass.fxml'.";

	}

	@Override
	public void handleAnswer(Object msg)
	{
		// TODO Auto-generated method stub

	}
}
