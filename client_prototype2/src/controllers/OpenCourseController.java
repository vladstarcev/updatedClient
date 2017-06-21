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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ui.UserWindow;

public class OpenCourseController implements IController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> ChooseCourseComboBox;

    @FXML
    private ComboBox<String> ChooseClassComboBox;

    @FXML
    private Label OpenCourseLable;

    @FXML
    private Button OpenButton;

    @FXML
    private Button BackButton;

    @FXML
    private ComboBox<String> ChooseTeacherComboBox;
    
    private String StudyUnit;

    @FXML
    void BackToMenu(ActionEvent event) {

    	 StudyUnit="";
    	 UserWindow.closeUserWindow(getClass(), (Stage) OpenCourseLable.getScene().getWindow());
    }

    @FXML
    void CourseList(ActionEvent event) {
    	
    }

    @FXML
    void OpenCourseInClass(ActionEvent event) {

    }

    @FXML
    void ChooseTeacher(ActionEvent event) {

    }

    @FXML
    void ChooseClass(ActionEvent event) {

    }
    
    void loadCourses()
    {
		ArrayList<String> data = new ArrayList<String>();
		data.add("Course List");
		data.add("select");
		data.add("courses");

		try
		{
			Main.client.sendToServer(data);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
    }
    
    void loadAllClass()
    {
		ArrayList<String> data = new ArrayList<String>();
		data.add("Class List");
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
    
    void loadteacher(String studyUnit)
    {
		ArrayList<String> data = new ArrayList<String>();
		data.add("Teacher List");
		data.add("select");
		data.add("teacher_in_studyunit");
		data.add("studyUnitID");
		data.add("01");

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
		data.add(ChooseCourseComboBox.getSelectionModel().getSelectedItem());

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
        assert ChooseCourseComboBox != null : "fx:id=\"ChooseCourseComboBox\" was not injected: check your FXML file 'SecretaryOpenCourse.fxml'.";
        assert ChooseClassComboBox != null : "fx:id=\"ChooseClassComboBox\" was not injected: check your FXML file 'SecretaryOpenCourse.fxml'.";
        assert OpenCourseLable != null : "fx:id=\"OpenCourseLable\" was not injected: check your FXML file 'SecretaryOpenCourse.fxml'.";
        assert OpenButton != null : "fx:id=\"OpenButton\" was not injected: check your FXML file 'SecretaryOpenCourse.fxml'.";
        assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'SecretaryOpenCourse.fxml'.";
        assert ChooseTeacherComboBox != null : "fx:id=\"ChooseTeacherComboBox\" was not injected: check your FXML file 'SecretaryOpenCourse.fxml'.";

        Main.client.controller=this;
        StudyUnit="";
        
    	loadCourses();
        
        
    }

	@Override
	public void handleAnswer(Object msg) {
		// TODO Auto-generated method stub
		
		if (msg == null)
		{
			// error
			new Alert(AlertType.ERROR, "Item has not found.", ButtonType.OK).showAndWait();
			return;
		}

		ArrayList<String> arr = (ArrayList<String>) msg;
		String type = arr.remove(0);
		
		if(type.equals("Course List"))
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

				String coursename = map.get("courseName");
				ChooseCourseComboBox.getItems().add(coursename);
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
			}
			loadAllClass();
		}
		
		if(type.equals("Class List"))
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
				ChooseClassComboBox.getItems().add(classname);
			}
			
			loadteacher(StudyUnit);
		}
		
		if(type.equals("Teacher List"))
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

				String username = map.get("userName");
				String userID=map.get("userId");
				ChooseTeacherComboBox.getItems().add(username + ": " + userID);
			}
		}
	}
}

