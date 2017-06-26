package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import interfaces.IController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;

public class ViewAllDataController implements IController
{

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Label ViewLabel;

	@FXML
	private MenuButton MenuButton;

	@FXML
	private Button BackButton;

	@FXML
	private Label ChooseLabel;

	@FXML
	private ComboBox<String> DataComboBox;

	@FXML
	void ViewAllOptions(ActionEvent event)
	{

	}

	@FXML
	void BackToMenu(ActionEvent event)
	{

	}

	@FXML
	void ViewChosenData(ActionEvent event)
	{

	}

	@FXML
	void initialize()
	{
		assert ViewLabel != null : "fx:id=\"ViewLabel\" was not injected: check your FXML file 'SchoolManagerViewAllData.fxml'.";
		assert MenuButton != null : "fx:id=\"MenuButton\" was not injected: check your FXML file 'SchoolManagerViewAllData.fxml'.";
		assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'SchoolManagerViewAllData.fxml'.";
		assert ChooseLabel != null : "fx:id=\"ChooseLabel\" was not injected: check your FXML file 'SchoolManagerViewAllData.fxml'.";
		assert DataComboBox != null : "fx:id=\"DataComboBox\" was not injected: check your FXML file 'SchoolManagerViewAllData.fxml'.";

		Main.client.controller = this;
	}

	@Override
	public void handleAnswer(Object msg)
	{
		// TODO Auto-generated method stub

	}
}
