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

public class PupilDownloadAssignmentController implements IController{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button BackToMenuButton;

    @FXML
    private Hyperlink DownloadAssignmentHyperlink;

    @FXML
    private ComboBox<String> ChooseAssignmentCB;

    @FXML
    private ComboBox<String> ChooseCourseCB;
    
    private String  UserID;
    
    private String CourseCoice;
    private String CourseAss;

    @FXML
    void ChooseCourseCB(ActionEvent event) {
    	
    	 CourseCoice=ChooseCourseCB.getSelectionModel().getSelectedItem();
 		ArrayList<String> data = new ArrayList<String>();
 		data.add("Load Assignment in course");
 		data.add("select");
 		data.add("assignment");
 		data.add("courseId");
 		data.add(CourseCoice);

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
    void ChooseAssignment(ActionEvent event) {

    	CourseAss=ChooseAssignmentCB.getSelectionModel().getSelectedItem();
    }

    @FXML
    void BackToMenu(ActionEvent event) {

    	UserWindow.closeUserWindow(getClass(), (Stage) ChooseAssignmentCB.getScene().getWindow());
    }

    @FXML
    void DownloadAssignment(ActionEvent event) {

    	if(CourseCoice.equals(""))
    	{
    		new Alert(AlertType.ERROR, "Choose Course From List First.", ButtonType.OK).showAndWait();
    	}
    	else if (CourseAss.equals(""))
    	{
    		new Alert(AlertType.ERROR, "Choose Assignment From List First.", ButtonType.OK).showAndWait();
    	}
    	else 
    	{

    	}
    }
    
    void loadCourseForPupil()
    {
		ArrayList<String> data = new ArrayList<String>();
		data.add("Load Course Of Pupil");
		data.add("select");
		data.add("pupil_in_course");
		data.add("userID");
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

    @FXML
    void initialize() {
        assert BackToMenuButton != null : "fx:id=\"BackToMenuButton\" was not injected: check your FXML file 'PupilDownloadAssignment.fxml'.";
        assert DownloadAssignmentHyperlink != null : "fx:id=\"DownloadAssignmentHyperlink\" was not injected: check your FXML file 'PupilDownloadAssignment.fxml'.";
        assert ChooseAssignmentCB != null : "fx:id=\"ChooseAssignmentCB\" was not injected: check your FXML file 'PupilDownloadAssignment.fxml'.";
        assert ChooseCourseCB != null : "fx:id=\"ChooseCourseCB\" was not injected: check your FXML file 'PupilDownloadAssignment.fxml'.";

        Main.client.controller=this;
        Main.stack.push("PupilDownloadAssignment");
        UserID = UserController.CurrentUserID;
        CourseCoice="";
        CourseAss="";
        
        loadCourseForPupil(); 
        
    }

	@Override
	public void handleAnswer(Object msg) {
		// TODO Auto-generated method stub
		

		ArrayList<String> arr = (ArrayList<String>) msg;
		String type = arr.remove(0);
		
		if (msg == null)
		{
			// error
			new Alert(AlertType.ERROR, "Item has not found.", ButtonType.OK).showAndWait();
			return;
		}
		
		if(type.equals("Load Course Of Pupil"))
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

				String coursID = map.get("courseID");
				ChooseCourseCB.getItems().add(coursID);
			}
		}
		
		if(type.equals("Load Assignment in course"))
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

				String assignmentName = map.get("assignmentName");
				ChooseAssignmentCB.getItems().add(assignmentName);
			}
		}
	}
}

