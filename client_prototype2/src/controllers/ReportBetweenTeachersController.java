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

public class ReportBetweenTeachersController implements IController
{

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private BarChart<?, ?> ReportBarChart;

	@FXML
	private CategoryAxis SpecificClassAxos;

	@FXML
	private Button BackButton;

	@FXML
	private ComboBox<?> ChooseComboBox;

	@FXML
	private Label ReportLabel1;

	@FXML
	private NumberAxis DifferentTeachersAxis;

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
		assert ReportBarChart != null : "fx:id=\"ReportBarChart\" was not injected: check your FXML file 'ReportBetweenTeachersOfSpecificClass.fxml'.";
		assert SpecificClassAxos != null : "fx:id=\"SpecificClassAxos\" was not injected: check your FXML file 'ReportBetweenTeachersOfSpecificClass.fxml'.";
		assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'ReportBetweenTeachersOfSpecificClass.fxml'.";
		assert ChooseComboBox != null : "fx:id=\"ChooseComboBox\" was not injected: check your FXML file 'ReportBetweenTeachersOfSpecificClass.fxml'.";
		assert ReportLabel1 != null : "fx:id=\"ReportLabel1\" was not injected: check your FXML file 'ReportBetweenTeachersOfSpecificClass.fxml'.";
		assert DifferentTeachersAxis != null : "fx:id=\"DifferentTeachersAxis\" was not injected: check your FXML file 'ReportBetweenTeachersOfSpecificClass.fxml'.";
		assert ReportLabel2 != null : "fx:id=\"ReportLabel2\" was not injected: check your FXML file 'ReportBetweenTeachersOfSpecificClass.fxml'.";

	}

	@Override
	public void handleAnswer(Object msg)
	{
		// TODO Auto-generated method stub
		
	}
}
