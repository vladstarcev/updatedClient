package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Main;
import interfaces.IController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

public class ViewAllDataController implements IController
{

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private MenuItem DisplayExeptionalRequests;

	@FXML
	private MenuItem DisplayAcademicActivities;

	@FXML
	private MenuButton MenuButton;

	@FXML
	private MenuItem DisplayAssignments;

	@FXML
	private MenuItem DisplaySecretary;

	@FXML
	private Button BackButton;

	@FXML
	private MenuItem DisplayTeachers;

	@FXML
	private MenuItem DisplaySemesters;

	@FXML
	private MenuItem DisplaySystemManager;

	@FXML
	private MenuItem DisplayParents;

	@FXML
	private ComboBox<?> DataComboBox;

	@FXML
	private MenuItem DisplayClasses;

	@FXML
	private MenuItem DisplayPupils;

	@FXML
	private Label ViewLabel;

	@FXML
	private Label ChooseLabel;

	private String DATA;

	@FXML
	void ViewAllOptions(ActionEvent event)
	{

	}

	@FXML
	void DisplayAllPupil(ActionEvent event)
	{
		ArrayList<String> data = new ArrayList<String>();
		data.add("Pupil Data");
		data.add("select");
		data.add("user");
		data.add("permission");
		data.add("6");

		try
		{
			Main.client.sendToServer(data);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	@FXML
	void DisplayAllParents(ActionEvent event)
	{
		ArrayList<String> data = new ArrayList<String>();
		data.add("Parent Data");
		data.add("select");
		data.add("user");
		data.add("permission");
		data.add("5");

		try
		{
			Main.client.sendToServer(data);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	@FXML
	void DisplayAllTeachers(ActionEvent event)
	{
		ArrayList<String> data = new ArrayList<String>();
		data.add("Teacher Data");
		data.add("select");
		data.add("user");
		data.add("permission");
		data.add("4");

		try
		{
			Main.client.sendToServer(data);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	@FXML
	void DisplayAllClasses(ActionEvent event)
	{
		ArrayList<String> data = new ArrayList<String>();
		data.add("Class Data");
		data.add("select");
		data.add("class");
		try
		{
			Main.client.sendToServer(data);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	@FXML
	void DisplayAllAcademicActivities(ActionEvent event)
	{
		ArrayList<String> data = new ArrayList<String>();
		data.add("Academic Activities Data");
		data.add("select");
		data.add("academic_activities");
		try
		{
			Main.client.sendToServer(data);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	@FXML
	void DisplayAllSemester(ActionEvent event)
	{
		ArrayList<String> data = new ArrayList<String>();
		data.add("Semester Data");
		data.add("select");
		data.add("semester");
		try
		{
			Main.client.sendToServer(data);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	@FXML
	void DisplayAllExeptionalRequests(ActionEvent event)
	{
		ArrayList<String> data = new ArrayList<String>();
		data.add("Exeptional Requests Data");
		data.add("select");
		data.add("exceptional_request");
		try
		{
			Main.client.sendToServer(data);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	@FXML
	void DisplayAllAssignments(ActionEvent event)
	{
		ArrayList<String> data = new ArrayList<String>();
		data.add("Assignments Data");
		data.add("select");
		data.add("assignment");
		try
		{
			Main.client.sendToServer(data);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	@FXML
	void DisplaySecretaryData(ActionEvent event)
	{
		ArrayList<String> data = new ArrayList<String>();
		data.add("Secretary Data");
		data.add("select");
		data.add("user");
		data.add("permission");
		data.add("3");

		try
		{
			Main.client.sendToServer(data);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	@FXML
	void DisplaySystemManagerData(ActionEvent event)
	{
		ArrayList<String> data = new ArrayList<String>();
		data.add("System Manager Data");
		data.add("select");
		data.add("user");
		data.add("permission");
		data.add("1");

		try
		{
			Main.client.sendToServer(data);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
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
		assert DisplayExeptionalRequests != null : "fx:id=\"DisplayExeptionalRequests\" was not injected: check your FXML file 'SchoolManagerViewAllData.fxml'.";
		assert DisplayAcademicActivities != null : "fx:id=\"DisplayAcademicActivities\" was not injected: check your FXML file 'SchoolManagerViewAllData.fxml'.";
		assert MenuButton != null : "fx:id=\"MenuButton\" was not injected: check your FXML file 'SchoolManagerViewAllData.fxml'.";
		assert DisplayAssignments != null : "fx:id=\"DisplayAssignments\" was not injected: check your FXML file 'SchoolManagerViewAllData.fxml'.";
		assert DisplaySecretary != null : "fx:id=\"DisplaySecretary\" was not injected: check your FXML file 'SchoolManagerViewAllData.fxml'.";
		assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'SchoolManagerViewAllData.fxml'.";
		assert DisplayTeachers != null : "fx:id=\"DisplayTeachers\" was not injected: check your FXML file 'SchoolManagerViewAllData.fxml'.";
		assert DisplaySemesters != null : "fx:id=\"DisplaySemesters\" was not injected: check your FXML file 'SchoolManagerViewAllData.fxml'.";
		assert DisplaySystemManager != null : "fx:id=\"DisplaySystemManager\" was not injected: check your FXML file 'SchoolManagerViewAllData.fxml'.";
		assert DisplayParents != null : "fx:id=\"DisplayParents\" was not injected: check your FXML file 'SchoolManagerViewAllData.fxml'.";
		assert DataComboBox != null : "fx:id=\"DataComboBox\" was not injected: check your FXML file 'SchoolManagerViewAllData.fxml'.";
		assert DisplayClasses != null : "fx:id=\"DisplayClasses\" was not injected: check your FXML file 'SchoolManagerViewAllData.fxml'.";
		assert DisplayPupils != null : "fx:id=\"DisplayPupils\" was not injected: check your FXML file 'SchoolManagerViewAllData.fxml'.";
		assert ViewLabel != null : "fx:id=\"ViewLabel\" was not injected: check your FXML file 'SchoolManagerViewAllData.fxml'.";
		assert ChooseLabel != null : "fx:id=\"ChooseLabel\" was not injected: check your FXML file 'SchoolManagerViewAllData.fxml'.";

		Main.client.controller = this;

		DATA = "";
	}

	@Override
	public void handleAnswer(Object msg)
	{
		// TODO Auto-generated method stub

	}
}
