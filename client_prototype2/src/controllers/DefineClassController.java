package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import application.Main;
import interfaces.IController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import ui.UserWindow;

public class DefineClassController implements IController
{

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField MaximumPupilInClassTextField;

	@FXML
	private Label EnterClassNameLabel;

	@FXML
	private TextField ClassNameTextField;

	@FXML
	private Label EnterMAximumPupilLabel;

	@FXML
	private TextField ClassIdTextField;

	@FXML
	private Label EnterClassIDLabel1;

	@FXML
	private Button CheckAvailabilityButton2;

	@FXML
	private Button CheckAvailabilityButton1;

	@FXML
	private Button BackButton;

	@FXML
	private Label DefineClassLabel;

	@FXML
	private Label FillFormLabel;

	@FXML
	private Button DefineClassButton;

	private ArrayList<String> classID;
	private ArrayList<String> className;
	private String ClassID;
	private String ClassNAME;
	private String Capacity;
	private int ClassNameF;
	private int ClassIDF;

	@FXML
	void EnterMaxPupilForClass(ActionEvent event)
	{

	}

	@FXML
	void EnterClassName(ActionEvent event)
	{

	}

	@FXML
	void DefineClass(ActionEvent event)
	{

		if (MaximumPupilInClassTextField.getText().startsWith("-") || MaximumPupilInClassTextField.getText().equals("0")
				|| MaximumPupilInClassTextField.getText().isEmpty())
		{
			new Alert(AlertType.ERROR, "Wrong Capacity", ButtonType.OK).showAndWait();
			return;
		}
		else if ((ClassIDF == 1) && (ClassNameF == 1))
		{
			InsertNewClass();
		}
		else
			new Alert(AlertType.ERROR, "Missing Fields", ButtonType.OK).showAndWait();

	}

	void InsertNewClass()
	{
		ArrayList<String> data = new ArrayList<String>();
		data.add("Insert New Class");
		data.add("insert");
		data.add("class");
		data.add("classId");
		data.add("className");
		data.add("capacity");
		data.add("AssignedPupils");
		data.add("values");
		data.add(ClassID);
		data.add(ClassNAME);
		Capacity = MaximumPupilInClassTextField.getText();
		data.add(Capacity);
		data.add("0");
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
	void BackToMenu(ActionEvent event) //problem here !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	{
		ClassNameF = 0;
		ClassIDF = 0;
		UserWindow.closeUserWindow(getClass(), (Stage) EnterClassNameLabel.getScene().getWindow());
	}

	@FXML
	void CheckAvailability2(ActionEvent event)
	{

		ArrayList<String> data = new ArrayList<String>();
		data.add("Class Name");
		data.add("select");
		data.add("class");
		data.add("className");
		ClassNAME = ClassNameTextField.getText();
		data.add(ClassNAME);

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
	void EnterClassID(ActionEvent event)
	{

	}

	@FXML
	void CheckAvailability1(ActionEvent event)
	{

		ArrayList<String> data = new ArrayList<String>();
		data.add("Class ID");
		data.add("select");
		data.add("class");
		data.add("classId");
		ClassID = ClassIdTextField.getText();
		data.add(ClassID);

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
	void initialize()
	{
		assert MaximumPupilInClassTextField != null : "fx:id=\"MaximumPupilInClassTextField\" was not injected: check your FXML file 'SecretaryDefineClass.fxml'.";
		assert EnterClassNameLabel != null : "fx:id=\"EnterClassNameLabel\" was not injected: check your FXML file 'SecretaryDefineClass.fxml'.";
		assert ClassNameTextField != null : "fx:id=\"ClassNameTextField\" was not injected: check your FXML file 'SecretaryDefineClass.fxml'.";
		assert EnterMAximumPupilLabel != null : "fx:id=\"EnterMAximumPupilLabel\" was not injected: check your FXML file 'SecretaryDefineClass.fxml'.";
		assert ClassIdTextField != null : "fx:id=\"ClassIdTextField\" was not injected: check your FXML file 'SecretaryDefineClass.fxml'.";
		assert EnterClassIDLabel1 != null : "fx:id=\"EnterClassIDLabel1\" was not injected: check your FXML file 'SecretaryDefineClass.fxml'.";
		assert CheckAvailabilityButton2 != null : "fx:id=\"CheckAvailabilityButton2\" was not injected: check your FXML file 'SecretaryDefineClass.fxml'.";
		assert CheckAvailabilityButton1 != null : "fx:id=\"CheckAvailabilityButton1\" was not injected: check your FXML file 'SecretaryDefineClass.fxml'.";
		assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'SecretaryDefineClass.fxml'.";
		assert DefineClassLabel != null : "fx:id=\"DefineClassLabel\" was not injected: check your FXML file 'SecretaryDefineClass.fxml'.";
		assert FillFormLabel != null : "fx:id=\"FillFormLabel\" was not injected: check your FXML file 'SecretaryDefineClass.fxml'.";
		assert DefineClassButton != null : "fx:id=\"DefineClassButton\" was not injected: check your FXML file 'SecretaryDefineClass.fxml'.";

		Main.client.controller = this;
		classID = new ArrayList<String>();
		className = new ArrayList<String>();
		ClassNAME = "";
		ClassID = "";
		Capacity = "";
		ClassNameF = 0;
		ClassIDF = 0;

	}

	@Override
	public void handleAnswer(Object msg)
	{
		// TODO Auto-generated method stub

		if (msg == null)
		{
			// error
			new Alert(AlertType.ERROR, "Item has not found.", ButtonType.OK).showAndWait();
			return;
		}

		ArrayList<String> arr = (ArrayList<String>) msg;
		String type = arr.remove(0);
		if (type.equals("Class ID"))
		{
			for (String row : arr)
			{
				String[] cols = row.split(";");
				HashMap<String, String> map = new HashMap<>();
				for (String col : cols)
				{
					String[] field = col.split("=");
					map.put(field[0], field[1]);
				}
				classID.add(map.get("classId"));
			}
			if (!classID.contains(ClassID))
			{
				if (ClassID.length() == 4)
				{
					new Alert(AlertType.INFORMATION, "Class ID is correct and available.", ButtonType.OK).showAndWait();
					ClassIDF = 1;

				}
				else
				{
					new Alert(AlertType.ERROR, "Class ID should have 4 digits.", ButtonType.OK).showAndWait();
				}
			}

			else
			{
				new Alert(AlertType.ERROR, "This class ID already exists.", ButtonType.OK).showAndWait();
			}
		}
		if (type.equals("Class Name"))
		{
			for (String row : arr)
			{
				String[] cols = row.split(";");
				HashMap<String, String> map = new HashMap<>();
				for (String col : cols)
				{
					String[] field = col.split("=");
					map.put(field[0], field[1]);
				}
				className.add(map.get("classId"));
			}
			if (!className.contains(ClassNAME))
			{

				new Alert(AlertType.INFORMATION, "Class name is correct and available.", ButtonType.OK).showAndWait();
				ClassNameF = 1;

			}

			else
			{
				new Alert(AlertType.ERROR, "This class name already exists.", ButtonType.OK).showAndWait();
			}
		}

		if (type.equals("Insert New Class"))
		{
			if (arr.size() != 0)
			{
				new Alert(AlertType.INFORMATION, "Class Defined Succesfully!", ButtonType.OK).showAndWait();
				UserWindow.closeUserWindow(getClass(), (Stage) FillFormLabel.getScene().getWindow()); // problem here!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			}
		}

	}
}
