package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import application.Main;
import entities.*;
import interfaces.IController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import ui.UserWindow;

public class ParentController implements IController
{

	@FXML
	private Label ParentLabel;

	@FXML
	private Button BackButton;

	@FXML
	private ComboBox<String> ChooseChildComboBox;

	private HashMap<String, HashMap<String, String>> allPupils;

	@FXML
	void initialize()
	{
		assert ParentLabel != null : "fx:id=\"ParentLabel\" was not injected: check your FXML file 'Parent.fxml'.";
		assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'Parent.fxml'.";
		assert ChooseChildComboBox != null : "fx:id=\"ChooseChildComboBox\" was not injected: check your FXML file 'Parent.fxml'.";

		//Main.stack.push("Parent");

		Main.client.controller = this;
		allPupils = new HashMap<>();
		loadAllPupils();
	}

	void loadAllPupils()
	{
		ArrayList<String> data = new ArrayList<String>();
		data.add("Client User");
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

	void loadPupilsParent()
	{
		ArrayList<String> data = new ArrayList<String>();
		data.add("Client Pupil");
		data.add("select");
		data.add("pupil");
		data.add("parentID");
		data.add(Main.userId);

		try
		{
			Main.client.sendToServer(data);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void handleAnswer(Object result)
	{
		if (result == null)
		{
			// error

			return;
		}

		ArrayList<String> arr = (ArrayList<String>) result;
		String type = arr.remove(0);
		if (type.equals("Client User"))
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
				allPupils.put(map.get("userId"), map);
			}
			loadPupilsParent();
		}
		else if (type.equals("Client Pupil"))
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

				String userId = map.get("userID");
				ChooseChildComboBox.getItems().add(userId + ": " + allPupils.get(userId).get("userFirstName") + " "
						+ allPupils.get(userId).get("userLastName"));
			}
		}
	}

	@FXML
	void BackToMenu(ActionEvent event) // change to logout
	{
		UserWindow.closeUserWindow(getClass(), (Stage) BackButton.getScene().getWindow());
	}

	@FXML
	void ChooseChild(ActionEvent event)
	{
		String selectedChild = ChooseChildComboBox.getSelectionModel().getSelectedItem();
		if (selectedChild == null)
			return;

		UserWindow.createUserWindow((Stage) ChooseChildComboBox.getScene().getWindow(), "PupilFile", getClass());
	}

}
