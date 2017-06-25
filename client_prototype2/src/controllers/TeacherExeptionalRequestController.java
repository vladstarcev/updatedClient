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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class TeacherExeptionalRequestController implements IController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> ListTeacherComboBox;

    @FXML
    private TextField RequestIdTextField;

    @FXML
    private Label ClassLabel;

    @FXML
    private Label TeacherExeptionalLabel;

    @FXML
    private Label TeacherLabel;

    @FXML
    private Button CheckIdButton;

    @FXML
    private Label RequestIdLabel;

    @FXML
    private Button BackButton;

    @FXML
    private Label CourseLabel1;

    @FXML
    private Button SendButton;

    @FXML
    private ComboBox<String> ListCurseComboBox;

    @FXML
    private ComboBox<String> ListCLassComboBox;
    
    private int ExFlag;
    private String cbClass;
    private String ClassID;
    private String courseid;
    private String StudyUnit;
	private String CourseWeeklyHour;

    @FXML
    void ChooseClass(ActionEvent event) {
    	
    	cbClass=ListCLassComboBox.getSelectionModel().getSelectedItem();
    	String[] Temp=cbClass.split(":");
    	ClassID=Temp[0];
    	loadCoursesInClass(ClassID);
    }

    @FXML
    void ChooseTeacher(ActionEvent event) {

    }

    @FXML
    void SendToSchoolManager(ActionEvent event) {

    }

    @FXML
    void BackToMenu(ActionEvent event) {

    }

    @FXML
    void CeckIdAvailability(ActionEvent event) {

		ArrayList<String> data = new ArrayList<String>();
		data.add("Check Availbility Request ID");
		data.add("select");
		data.add("exceptional_request");
		data.add("exceptonalRequestID");
		data.add(RequestIdTextField.getText());

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
    void ChooseCourse(ActionEvent event) {

    }
    
    void loadClassIDAndName()
    {
		ArrayList<String> data = new ArrayList<String>();
		data.add("Load Class ID and Name");
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
    
    void loadCoursesInClass(String ClassiD)
    {
    	ArrayList<String> data = new ArrayList<String>();
		data.add("Load Course in class");
		data.add("select");
		data.add("course_in_class");
		data.add("classId");
		data.add(ClassiD);
		
		try
		{
			Main.client.sendToServer(data);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
    }
    
	void loadStudyUnit()
	{
		ArrayList<String> data = new ArrayList<String>();
		data.add("Load Study Unit");
		data.add("select");
		data.add("courses");
		data.add("courseId");
		data.add(courseid);

		try
		{
			Main.client.sendToServer(data);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	 void loadteacher()
	 {
			ArrayList<String> data = new ArrayList<String>();
			data.add("Teacher List");
			data.add("select");
			data.add("teacher_in_studyunit");
			data.add("studyUnitID");
			data.add(StudyUnit);

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
    void initialize() {
        assert ListTeacherComboBox != null : "fx:id=\"ListTeacherComboBox\" was not injected: check your FXML file 'ExeptionalRequestForTeacher.fxml'.";
        assert RequestIdTextField != null : "fx:id=\"RequestIdTextField\" was not injected: check your FXML file 'ExeptionalRequestForTeacher.fxml'.";
        assert ClassLabel != null : "fx:id=\"ClassLabel\" was not injected: check your FXML file 'ExeptionalRequestForTeacher.fxml'.";
        assert TeacherExeptionalLabel != null : "fx:id=\"TeacherExeptionalLabel\" was not injected: check your FXML file 'ExeptionalRequestForTeacher.fxml'.";
        assert TeacherLabel != null : "fx:id=\"TeacherLabel\" was not injected: check your FXML file 'ExeptionalRequestForTeacher.fxml'.";
        assert CheckIdButton != null : "fx:id=\"CheckIdButton\" was not injected: check your FXML file 'ExeptionalRequestForTeacher.fxml'.";
        assert RequestIdLabel != null : "fx:id=\"RequestIdLabel\" was not injected: check your FXML file 'ExeptionalRequestForTeacher.fxml'.";
        assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'ExeptionalRequestForTeacher.fxml'.";
        assert CourseLabel1 != null : "fx:id=\"CourseLabel1\" was not injected: check your FXML file 'ExeptionalRequestForTeacher.fxml'.";
        assert SendButton != null : "fx:id=\"SendButton\" was not injected: check your FXML file 'ExeptionalRequestForTeacher.fxml'.";
        assert ListCurseComboBox != null : "fx:id=\"ListCurseComboBox\" was not injected: check your FXML file 'ExeptionalRequestForTeacher.fxml'.";
        assert ListCLassComboBox != null : "fx:id=\"ListCLassComboBox\" was not injected: check your FXML file 'ExeptionalRequestForTeacher.fxml'.";

        Main.client.controller=this;
        ExFlag=0;
        cbClass="";
        ClassID="";
        courseid="";
        StudyUnit="";
    	CourseWeeklyHour="";
        loadClassIDAndName();
    }

	@Override
	public void handleAnswer(Object result) {
		// TODO Auto-generated method stub
		
		if (result == null)
		{
			// error
			new Alert(AlertType.ERROR, "Item has not found.", ButtonType.OK).showAndWait();
			return;
		}

		ArrayList<String> arr = (ArrayList<String>) result;
		String type = arr.remove(0);
		
		if(type.equals("Check Availbility Request ID"))
		{
			if(arr.size()==0)
			{
				ExFlag=1;
				new Alert(AlertType.INFORMATION, "Exceptional Request ID Availible.", ButtonType.OK).showAndWait();
			}
			else
			{
				new Alert(AlertType.ERROR, "Exceptional Request ID Already Exist.", ButtonType.OK).showAndWait();
			}
		}
		
		if(type.equals("Load Class ID and Name"))
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

					String classname = map.get("className");
					String classID= map.get("classId");
					ListCLassComboBox.getItems().add(classID + ": " + classname);
				}
		}
		
		if(type.equals("Load Course in class"))
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

				courseid= map.get("courseId");
				ListCurseComboBox.getItems().add(courseid);
			}
			loadStudyUnit();
		}
		
		if(type.equals("Load Study Unit"))
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

				StudyUnit = map.get("studyUnit");
				CourseWeeklyHour = map.get("weeklyStudyHours");
			}
			//loadAllClass();
			loadteacher();
		}
		
		if(type.equals("Teacher List"))
		{
			ListTeacherComboBox.getItems().clear();
			for (String row : arr)
			{
				String[] cols = row.split(";");
				HashMap<String, String> map = new HashMap<>();
				for (String col : cols)
				{
					String[] field = col.split("=");
					map.put(field[0], field[1]);
				}

				String username = map.get("userName");
				String userID = map.get("userId");
				ListTeacherComboBox.getItems().add(userID + ": " + username);
			}
		}
	}
}
