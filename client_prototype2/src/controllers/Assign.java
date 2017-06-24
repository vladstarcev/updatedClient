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

public class Assign implements IController
{

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button SendButton2;

	@FXML
	private Label AssignPupilClassLable2;

	@FXML
	private TextField PupilIdTextField;

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

	private ArrayList<String> AllPupils;
	private ArrayList<String> AllClasses;
	private ArrayList<String> CoursesID;
	private ArrayList<String> PreCoursesID;
	private ArrayList<String> ForCourseID;
	private ArrayList<String> PreCourseOfPupil;
	private String pupilID;
	private String classID;
	private int pupilFlag;
	private int classFlag;

	@FXML
	void SendPupilID(ActionEvent event)
	{
		ArrayList<String> data = new ArrayList<String>();
		data.add("Check Pupil ID");
		data.add("select field");
		data.add("userID");
		data.add("pupil");
		pupilID = PupilIdTextField.getText();

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
		data.add("Check Class ID");
		data.add("select field");
		data.add("classId");
		data.add("class");
		classID = ClassIDTextField.getText();
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
	void AssignPupilToClass(ActionEvent event)
	{
		ArrayList<String> data = new ArrayList<String>();
		data.add("Select All Courses");
		data.add("select field");
		data.add("courseId");
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
		data.add("Select Pre Courses");
		data.add("select");
		data.add("pre_course");

		try
		{
			Main.client.sendToServer(data);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	void loadPupilsCourses()
	{
		ArrayList<String> data = new ArrayList<String>();
		data.add("Select Pupils Courses");
		data.add("select field");
		data.add("courseID");
		data.add("pupil_in_course");
		data.add("userID");
		data.add(pupilID);
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
		assert SendButton2 != null : "fx:id=\"SendButton2\" was not injected: check your FXML file 'SecretaryAssignPupilToClass.fxml'.";
		assert AssignPupilClassLable2 != null : "fx:id=\"AssignPupilClassLable2\" was not injected: check your FXML file 'SecretaryAssignPupilToClass.fxml'.";
		assert PupilIdTextField != null : "fx:id=\"PupilIdTextField\" was not injected: check your FXML file 'SecretaryAssignPupilToClass.fxml'.";
		assert ClassIDTextField != null : "fx:id=\"ClassIDTextField\" was not injected: check your FXML file 'SecretaryAssignPupilToClass.fxml'.";
		assert AssignPupilClassLable1 != null : "fx:id=\"AssignPupilClassLable1\" was not injected: check your FXML file 'SecretaryAssignPupilToClass.fxml'.";
		assert AssignButton != null : "fx:id=\"AssignButton\" was not injected: check your FXML file 'SecretaryAssignPupilToClass.fxml'.";
		assert ClassIdLable != null : "fx:id=\"ClassIdLable\" was not injected: check your FXML file 'SecretaryAssignPupilToClass.fxml'.";
		assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'SecretaryAssignPupilToClass.fxml'.";
		assert PupilIdLable != null : "fx:id=\"PupilIdLable\" was not injected: check your FXML file 'SecretaryAssignPupilToClass.fxml'.";
		assert SendButton1 != null : "fx:id=\"SendButton1\" was not injected: check your FXML file 'SecretaryAssignPupilToClass.fxml'.";

		Main.client.controller = this;
		Main.stack.push("SecretaryAssignPupilToClass");

		AllPupils = new ArrayList<String>();
		AllClasses = new ArrayList<String>();
		PreCoursesID = new ArrayList<String>();
		CoursesID = new ArrayList<String>();
		PreCourseOfPupil = new ArrayList<String>();
		ForCourseID = new ArrayList<String>();
		pupilID = "";
		classID = "";
		pupilFlag = 0;
		classFlag = 0;

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

		if (type.equals("Check Pupil ID"))
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
				AllPupils.add(map.get("userID"));
			}
			if (AllPupils.contains(pupilID))
			{
				pupilFlag = 1;
				new Alert(AlertType.INFORMATION, "Pupil ID was found.", ButtonType.OK).showAndWait();
			}
			else
			{
				if (pupilID.length() == 9)
				{
					new Alert(AlertType.ERROR, "This pupil ID does not exist", ButtonType.OK).showAndWait();
				}
				else
				{
					new Alert(AlertType.ERROR, "Pupil ID should have 9 digits.", ButtonType.OK).showAndWait();
				}
			}
		}
		if (type.equals("Check Class ID"))
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
				AllClasses.add(map.get("classId"));
			}
			if (AllClasses.contains(classID))
			{
				classFlag = 1;
				new Alert(AlertType.INFORMATION, "Class ID was found", ButtonType.OK).showAndWait();
			}
			else
			{
				if (classID.length() == 4)
				{
					new Alert(AlertType.ERROR, "This class ID does not exist", ButtonType.OK).showAndWait();
				}
				else
				{
					new Alert(AlertType.ERROR, "Class ID should have 4 digits.", ButtonType.OK).showAndWait();
				}
			}
		}

		if (type.equals("Select All Courses"))
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
				CoursesID.add(map.get("classId"));
			}
			loadPreCourses();
		}

		if (type.equals("Select Pre Courses"))
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
				ForCourseID.add(map.get("course_id"));
			}
			int i = 0;
			for (i = 0; i < CoursesID.size(); i++)
			{
				if (CoursesID.contains(ForCourseID))
				{
					PreCourseOfPupil.add(PreCourseOfPupil.get(i));
				}
			}
			loadPupilsCourses();
		}
		if (type.equals("Select Pupils Courses"))
		{
			int i = 0;
			for (String row : arr)
			{
				String[] cols = row.split(";");
				HashMap<String, String> map = new HashMap<>();
				for (String col : cols)
				{
					String[] field = col.split("=");
					map.put(field[0], field[1]);
				}
				String str = map.get("courseID");
				String grade = map.get("gradeInCourse");
				if (!PreCourseOfPupil.contains(str) || grade.equals("0"))
				{
					new Alert(AlertType.ERROR, "This pupil missing pre course: " + str, ButtonType.OK).showAndWait();
				}
				else
				{
					if (PreCourseOfPupil.contains(str) && !grade.equals("0"))
					{
						i++;
					}
				}
			}
			if (i == PreCourseOfPupil.size())
			{
				new Alert(AlertType.INFORMATION, "This pupil have all needed pre courses", ButtonType.OK).showAndWait();
			}

			//loadPupilsCourses();
		}
	}
}
