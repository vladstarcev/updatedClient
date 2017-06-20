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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ui.UserWindow;

public class AssignPupilToClassController implements IController
{
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button SendButton2;

	@FXML
	private TextField PupilIdTextField;

	@FXML
	private Label AssignPupilClassLable2;

	@FXML
	private TextField ClassIDTextField;

	@FXML
	private Label AssignPupilClassLable1;

	@FXML
	private Button AssignButton;

	@FXML
	private Label ClassIdLable;

	@FXML
	private Button BackButton;

	@FXML
	private Label PupilIdLable;

	@FXML
	private Button SendButton1;

	private HashMap<String, HashMap<String, String>> allCoursesInClass;

	private ArrayList<String> PreCoursesID = new ArrayList<String>();

	private String classID;

	@FXML
	void SendPupilID(ActionEvent event)
	{
		ArrayList<String> data = new ArrayList<String>();
		data.add("Check Pupil");
		data.add("select");
		data.add("pupil");
		data.add("userID");
		data.add(PupilIdTextField.getText());
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
	void SendClassID(ActionEvent event)
	{
		ArrayList<String> data = new ArrayList<String>();
		data.add("Check Class");
		data.add("select");
		data.add("class");
		data.add("classId");
		classID = ClassIDTextField.getText();
		data.add(classID);

		try
		{
			Main.client.sendToServer(data);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	void loadCourseInClass()
	{
		ArrayList<String> data = new ArrayList<String>();
		data.add("Check Course In Class");
		data.add("select");
		data.add("course_in_class");
		data.add("classId");
		data.add(classID);

		try
		{
			Main.client.sendToServer(data);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	void loadPreCourses()
	{
		ArrayList<String> data = new ArrayList<String>();
		data.add("Check Pre Courses");
		data.add("select");
		data.add("pre_course");
		for (int i = 0; i < allCoursesInClass.size(); i++)
		{
			data.add("course_id");
			data.add("" + allCoursesInClass.get(i));

		}
		try
		{
			Main.client.sendToServer(data);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	void loadCourses()
	{
		ArrayList<String> data = new ArrayList<String>();
		data.add("Check Course Of Pupil");
		data.add("select");
		data.add("pupil_in_course");
		data.add("userID");
		data.add(PupilIdTextField.getText());
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
		UserWindow.closeUserWindow(getClass(), (Stage) AssignPupilClassLable2.getScene().getWindow());
	}

	@FXML
	void AssignPupilToClass(ActionEvent event)
	{

	}

	@FXML
	void initialize()
	{
		assert SendButton2 != null : "fx:id=\"SendButton2\" was not injected: check your FXML file 'SecretaryAssignPupilToClass.fxml'.";
		assert PupilIdTextField != null : "fx:id=\"PupilIdTextField\" was not injected: check your FXML file 'SecretaryAssignPupilToClass.fxml'.";
		assert AssignPupilClassLable2 != null : "fx:id=\"AssignPupilClassLable2\" was not injected: check your FXML file 'SecretaryAssignPupilToClass.fxml'.";
		assert ClassIDTextField != null : "fx:id=\"ClassIDTextField\" was not injected: check your FXML file 'SecretaryAssignPupilToClass.fxml'.";
		assert AssignPupilClassLable1 != null : "fx:id=\"AssignPupilClassLable1\" was not injected: check your FXML file 'SecretaryAssignPupilToClass.fxml'.";
		assert AssignButton != null : "fx:id=\"AssignButton\" was not injected: check your FXML file 'SecretaryAssignPupilToClass.fxml'.";
		assert ClassIdLable != null : "fx:id=\"ClassIdLable\" was not injected: check your FXML file 'SecretaryAssignPupilToClass.fxml'.";
		assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'SecretaryAssignPupilToClass.fxml'.";
		assert PupilIdLable != null : "fx:id=\"PupilIdLable\" was not injected: check your FXML file 'SecretaryAssignPupilToClass.fxml'.";
		assert SendButton1 != null : "fx:id=\"SendButton1\" was not injected: check your FXML file 'SecretaryAssignPupilToClass.fxml'.";

		Main.client.controller = this;
		Main.stack.push("SecretaryAssignPupilToClass");

	}

	@Override
	public void handleAnswer(Object result)
	{
		if (result == null)
		{
			// error
			new Alert(AlertType.ERROR, "Item has not found.", ButtonType.OK).showAndWait();
			return;
		}
		ArrayList<String> arr = (ArrayList<String>) result;
		String type = arr.remove(0);
		if (type.equals("Check Pupil"))
		{
			if (arr.size() == 0)
			{
				new Alert(AlertType.ERROR, "Pupil has not found.", ButtonType.OK).showAndWait();
			}
			else
			{				
				new Alert(AlertType.INFORMATION, "Pupil has found.", ButtonType.OK).showAndWait();
			}
		}
		loadCourseInClass();
		if (type.equals("Check Class"))
		{
			if (arr.size() == 0)
			{
				new Alert(AlertType.ERROR, "Class has not found.", ButtonType.OK).showAndWait();
			}
			else
			{
				if (type.equals("Check Course In Class"))
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
						allCoursesInClass.put(map.get("userId"), map);
					}
					loadPreCourses();
				}
				else if (type.equals("Check Pre Courses"))
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
						PreCoursesID.add(map.get("pre_course_id"));
					}
					loadCourses();
				}
				else if (type.equals("Check Course Of Pupil"))
				{
					int flag = 0;
					ArrayList<String> PupilsCourses = new ArrayList<String>();
					for (String row : arr)
					{
						String[] cols = row.split(";");
						HashMap<String, String> map = new HashMap<>();
						for (String col : cols)
						{
							String[] field = col.split("=");
							map.put(field[0], field[1]);
						}
						PupilsCourses.add(map.get("courseID"));
					}
					if (PupilsCourses.equals(PreCoursesID))
					{
						flag = 1;
					}
					if (flag == 1)
					{
						new Alert(AlertType.INFORMATION, "Pupil has pre-courses for this class.", ButtonType.OK)
								.showAndWait();
					}
					else
					{
						new Alert(AlertType.ERROR, "Pupil has not pre-courses for this class.", ButtonType.OK)
								.showAndWait();
					}
				}
			}
		}	
	}
}