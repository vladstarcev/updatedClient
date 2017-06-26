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

public class SchoolManagerMainWindowController implements IController
{

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private MenuItem HandlingExeptionalRequestMenuItem;

	@FXML
	private Button LogOutButton;

	@FXML
	private MenuButton MenuButton;

	@FXML
	private MenuItem ReportGenarationMenuItem;

	@FXML
	private Label SchoolManagerMenuLabel;

	@FXML
	private MenuItem BlockUserMenuItem;

	@FXML
	private MenuItem ViewSystemData;

	@FXML
	private Label ChooseOperationLabel;

	@FXML
	void SchoolManagerMenu(ActionEvent event)
	{

	}

	@FXML
	void BlockUser(ActionEvent event)
	{

	}

	@FXML
	void BlockWindowOperation(ActionEvent event)
	{

	}

	@FXML
	void ReportGeneration(ActionEvent event)
	{
		UserWindow.createUserWindow((Stage) SchoolManagerMenuLabel.getScene().getWindow(),
				"SchoolManagerReportGeneration", getClass());

	}

	@FXML
	void ReportGenerationOperation(ActionEvent event)
	{

	}

	@FXML
	void HandlingExeptionalRequest(ActionEvent event)
	{

	}

	@FXML
	void HandlingExeptionalRequestOperation(ActionEvent event)
	{

	}

	@FXML
	void ViewAllData(ActionEvent event)
	{

	}

	@FXML
	void SchoolManagerLogOut(ActionEvent event)
	{

	}

	@FXML
	void initialize()
	{
		assert HandlingExeptionalRequestMenuItem != null : "fx:id=\"HandlingExeptionalRequestMenuItem\" was not injected: check your FXML file 'SchoolManagerMainWindow.fxml'.";
		assert LogOutButton != null : "fx:id=\"LogOutButton\" was not injected: check your FXML file 'SchoolManagerMainWindow.fxml'.";
		assert MenuButton != null : "fx:id=\"MenuButton\" was not injected: check your FXML file 'SchoolManagerMainWindow.fxml'.";
		assert ReportGenarationMenuItem != null : "fx:id=\"ReportGenarationMenuItem\" was not injected: check your FXML file 'SchoolManagerMainWindow.fxml'.";
		assert SchoolManagerMenuLabel != null : "fx:id=\"SchoolManagerMenuLabel\" was not injected: check your FXML file 'SchoolManagerMainWindow.fxml'.";
		assert BlockUserMenuItem != null : "fx:id=\"BlockUserMenuItem\" was not injected: check your FXML file 'SchoolManagerMainWindow.fxml'.";
		assert ViewSystemData != null : "fx:id=\"ViewSystemData\" was not injected: check your FXML file 'SchoolManagerMainWindow.fxml'.";
		assert ChooseOperationLabel != null : "fx:id=\"ChooseOperationLabel\" was not injected: check your FXML file 'SchoolManagerMainWindow.fxml'.";

		Main.client.controller = this;
	}

	@Override
	public void handleAnswer(Object msg)
	{
		// TODO Auto-generated method stub

	}
}
