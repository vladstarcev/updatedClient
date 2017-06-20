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

public class AssignPupilToCourseController implements IController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label PupilIDlabla;

    @FXML
    private Button CheckCourseButton;

    @FXML
    private TextField PupilIDtextField;

    @FXML
    private Button AssignButton;

    @FXML
    private Label AssignPupilCourseLable2;

    @FXML
    private Label AssignPupilCourseLable1;

    @FXML
    private TextField CourseIDtextField;

    @FXML
    private Button BackButton;

    @FXML
    private Button CheckPupilButton1;

    @FXML
    private Label CourseIDlable;
    
    private ArrayList<String> PreCoursesID;
    
    @FXML
    void EnterPupilID(ActionEvent event) {

    }

    @FXML
    void EnterCourseID(ActionEvent event) {

    }

    @FXML
    void CheckPupilID(ActionEvent event) {
    	
		ArrayList<String> data = new ArrayList<String>();
		data.add("Check Pupil");
		data.add("select");
		data.add("pupil");
		data.add("userID");
		data.add(PupilIDtextField.getText());
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
    void CheckCourseID(ActionEvent event) {

		ArrayList<String> data = new ArrayList<String>();
		data.add("Check Course");
		data.add("select");
		data.add("courses");
		data.add("courseId");
		data.add(CourseIDtextField.getText());

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
    void AssignPupilCourse(ActionEvent event) {
    	
		ArrayList<String> data = new ArrayList<String>();
		data.add("Check Pre Courses");
		data.add("select");
		data.add("pre_course");
		data.add("course_id");
		data.add(CourseIDtextField.getText());
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
    void BackToMenu(ActionEvent event) {

    	UserWindow.closeUserWindow(getClass(), (Stage) AssignPupilCourseLable2.getScene().getWindow());
    }

    @FXML
    void initialize() {
        assert PupilIDlabla != null : "fx:id=\"PupilIDlabla\" was not injected: check your FXML file 'SecretaryAssignPupilToCourse.fxml'.";
        assert CheckCourseButton != null : "fx:id=\"CheckCourseButton\" was not injected: check your FXML file 'SecretaryAssignPupilToCourse.fxml'.";
        assert PupilIDtextField != null : "fx:id=\"PupilIDtextField\" was not injected: check your FXML file 'SecretaryAssignPupilToCourse.fxml'.";
        assert AssignButton != null : "fx:id=\"AssignButton\" was not injected: check your FXML file 'SecretaryAssignPupilToCourse.fxml'.";
        assert AssignPupilCourseLable2 != null : "fx:id=\"AssignPupilCourseLable2\" was not injected: check your FXML file 'SecretaryAssignPupilToCourse.fxml'.";
        assert AssignPupilCourseLable1 != null : "fx:id=\"AssignPupilCourseLable1\" was not injected: check your FXML file 'SecretaryAssignPupilToCourse.fxml'.";
        assert CourseIDtextField != null : "fx:id=\"CourseIDtextField\" was not injected: check your FXML file 'SecretaryAssignPupilToCourse.fxml'.";
        assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'SecretaryAssignPupilToCourse.fxml'.";
        assert CheckPupilButton1 != null : "fx:id=\"CheckPupilButton1\" was not injected: check your FXML file 'SecretaryAssignPupilToCourse.fxml'.";
        assert CourseIDlable != null : "fx:id=\"CourseIDlable\" was not injected: check your FXML file 'SecretaryAssignPupilToCourse.fxml'.";

        Main.client.controller=this;
        
        PreCoursesID = new ArrayList<String>();
    }
    
	void loadCourses()
	{
		ArrayList<String> data = new ArrayList<String>();
		data.add("Check Course Of Pupil");
		data.add("select");
		data.add("pupil_in_course");
		data.add("userID");
		data.add(PupilIDtextField.getText());
		data.add("passed");
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
	
	void InsertPupilToCourse()
	{
		ArrayList<String> data = new ArrayList<String>();
		data.add("Assign Pupil To Course");
		data.add("insert");
		data.add("pupil_in_course");
		data.add("userID");
		data.add("courseID");
		data.add("passed");
		data.add("values");
		data.add(PupilIDtextField.getText());
		data.add(CourseIDtextField.getText());
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
		if (type.equals("Check Pupil"))
		{
			if(arr.size() == 0)
			{
				new Alert(AlertType.ERROR, "Pupil has not found.", ButtonType.OK).showAndWait();
			}
			else
			{
				new Alert(AlertType.INFORMATION, "Pupil has found.", ButtonType.OK).showAndWait();
			}
		}
		else if(type.equals( "Check Course"))
		{
			if(arr.size()==0)
			{
				new Alert(AlertType.ERROR, "Course has not found.", ButtonType.OK).showAndWait();
			}
				
			else 
			{
				new Alert(AlertType.INFORMATION, "Course has found.", ButtonType.OK).showAndWait();
			}		
		}
		else if(type.equals("Check Pre Courses"))
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
		else if(type.equals("Check Course Of Pupil"))
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
			for (int i = 0; i < PreCoursesID.size(); i++)
			{
				if (!PupilsCourses.contains(PreCoursesID.get(i)))
				{
					flag = 1;
					break;
				}
			}
			if (flag == 0)
			{
				InsertPupilToCourse();
				//new Alert(AlertType.INFORMATION, "Pupil has pre-courses for this class.", ButtonType.OK).showAndWait();
			}
			else
			{
				new Alert(AlertType.ERROR, "Pupil has not pre-courses for this course.", ButtonType.OK).showAndWait();
			}
		}
		else if (type.equals("Assign Pupil To Course"))
		{
			if (arr.size()!=0) 
				new Alert(AlertType.INFORMATION, "Pupil add succesfully to course.", ButtonType.OK).showAndWait();
				
		}
	}
}
	


