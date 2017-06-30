package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import application.Main;
import application.UserController;
import interfaces.IController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import ui.UserWindow;

public class TeacherCheckAssignmentController implements IController{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button BackToMenuButton;

    @FXML
    private Hyperlink UploadAssHyperLink;

    @FXML
    private Hyperlink DownLoadHYPERlINK;

    @FXML
    private ComboBox<String> ChooseAssCB;

    @FXML
    private ComboBox<String> ChoosePupilCB;

    @FXML
    private ComboBox<String> ChooseCourseCB;
    
    private String UserID;
    
    private String CBchoice;
    
    private String AssName;

    @FXML
    void ChooseCourse(ActionEvent event) {

    	CBchoice=ChooseCourseCB.getSelectionModel().getSelectedItem();
    	loadCourseAss();
    }

    @FXML
    void ChooseAss(ActionEvent event) {

    	AssName=ChooseAssCB.getSelectionModel().getSelectedItem();
    }

    @FXML
    void ChoosePupil(ActionEvent event) {

    	//CheckPupilClass();
    	//CheckTeacherClasses();
    }

    @FXML
    void BackToMenu(ActionEvent event) {

    	UserWindow.exitToMenu(getClass(), (Stage) ChooseCourseCB.getScene().getWindow());
    }

    @FXML
    void DownSoulotion(ActionEvent event) {

    }

    @FXML
    void UploadAss(ActionEvent event) {

    }
    
    void loadCourseList()
    {
		ArrayList<String> data = new ArrayList<String>();
		data.add("Load Courses");
		data.add("select");
		data.add("course_in_class");
		data.add("teacherId");
		data.add(UserID);

		try
		{
			Main.client.sendToServer(data);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
    }
    
    void loadPupilList()
    {
		ArrayList<String> data = new ArrayList<String>();
		data.add("Load Pupils");
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
    
    void loadCourseAss()
    {
		ArrayList<String> data = new ArrayList<String>();
		data.add("Load Assignments");
		data.add("select");
		data.add("assignmest");
		data.add("courseId");
		data.add(CBchoice);

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
        assert BackToMenuButton != null : "fx:id=\"BackToMenuButton\" was not injected: check your FXML file 'CheckAssignment.fxml'.";
        assert UploadAssHyperLink != null : "fx:id=\"UploadAssHyperLink\" was not injected: check your FXML file 'CheckAssignment.fxml'.";
        assert DownLoadHYPERlINK != null : "fx:id=\"DownLoadHYPERlINK\" was not injected: check your FXML file 'CheckAssignment.fxml'.";
        assert ChooseAssCB != null : "fx:id=\"ChooseAssCB\" was not injected: check your FXML file 'CheckAssignment.fxml'.";
        assert ChoosePupilCB != null : "fx:id=\"ChoosePupilCB\" was not injected: check your FXML file 'CheckAssignment.fxml'.";
        assert ChooseCourseCB != null : "fx:id=\"ChooseCourseCB\" was not injected: check your FXML file 'CheckAssignment.fxml'.";

        Main.client.controller=this;
        UserID=UserController.CurrentUserID;
 		Main.stack.push("CheckAssignment");
 		
 		AssName="";
 		loadCourseList();
 		loadPupilList();
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
		
		if(type.equals("Load Courses"))
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

				String CourseID = map.get("courseId");
				ChooseCourseCB.getItems().add(CourseID);
			}
		}
		
		if(type.equals("Load Pupils"))
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

				String userID = map.get("userId");
				String UserName=map.get("userFirstName");
				String UserLName=map.get("userLastName");
				ChoosePupilCB.getItems().add(userID + ": " + UserName + " " + UserLName);
			}
		}
		
		if(type.equals("Load Assignments"))
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

				String AssName= map.get("assignmentName");
				ChooseAssCB.getItems().add(AssName);
			}
		}
	}
}
