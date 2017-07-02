package controllers;

import interfaces.IController;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import application.Main;
import application.UserController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import ui.UserWindow;

public class TeacherDownloadSolutionController implements IController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button BackToMenuButton;

    @FXML
    private AnchorPane chooseCourseCB;

    @FXML
    private Label CheckPupilAssignment;

    @FXML
    private ComboBox<String> ChooseAssignmentCB;

    @FXML
    private ComboBox<String> ChoosePupilCB;

    @FXML
    private ComboBox<String> ChooseCourseCB;

    @FXML
    private Button DownloadButton;

    
    private String CBchoice;
    private String AssName;
    private String pupilChoice;
    
    
    @FXML
    void chooseCourse(ActionEvent event) {
       	
    }

    @FXML
    void ChooseCourse(ActionEvent event) {
    	CBchoice=ChooseCourseCB.getSelectionModel().getSelectedItem();
    	ArrayList<String> data = new ArrayList<String>();
 		data.add("Load Assignment in course");
 		data.add("select");
 		data.add("assignment");
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
    void ChooseAssignment(ActionEvent event) {
    	AssName=ChooseAssignmentCB.getSelectionModel().getSelectedItem();
    }
    
    public void loadCourses(){
    	ArrayList<String> data = new ArrayList<String>();
		data.add("Load Courses for Teacher");
		data.add("select");
		data.add("course_in_class");
		data.add("teacherId");
		data.add(UserController.CurrentUserID);

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
    void DownloadSolution(ActionEvent event) {
    	if(CBchoice.equals(""))
    	{
    		new Alert(AlertType.ERROR, "Choose Course From List First.", ButtonType.OK).showAndWait();
    	}
    	else if (AssName.equals(""))
    	{
    		new Alert(AlertType.ERROR, "Choose Assignment From List First.", ButtonType.OK).showAndWait();
    	}
    }

    @FXML
    void BackToMenu(ActionEvent event) {
    	UserWindow.closeUserWindow(getClass(), (Stage) BackToMenuButton.getScene().getWindow());
    }

    @FXML
    void ChoosePupil(ActionEvent event) {
    	pupilChoice=ChoosePupilCB.getSelectionModel().getSelectedItem();
    }


    @FXML
    void initialize() {
        assert BackToMenuButton != null : "fx:id=\"BackToMenuButton\" was not injected: check your FXML file 'CheckAssignment.fxml'.";
        assert chooseCourseCB != null : "fx:id=\"chooseCourseCB\" was not injected: check your FXML file 'CheckAssignment.fxml'.";
        assert CheckPupilAssignment != null : "fx:id=\"CheckPupilAssignment\" was not injected: check your FXML file 'CheckAssignment.fxml'.";
        assert ChooseAssignmentCB != null : "fx:id=\"ChooseAssignmentCB\" was not injected: check your FXML file 'CheckAssignment.fxml'.";
        assert ChoosePupilCB != null : "fx:id=\"ChoosePupilCB\" was not injected: check your FXML file 'CheckAssignment.fxml'.";
        assert ChooseCourseCB != null : "fx:id=\"ChooseCourseCB\" was not injected: check your FXML file 'CheckAssignment.fxml'.";
        assert DownloadButton != null : "fx:id=\"DownloadButton\" was not injected: check your FXML file 'CheckAssignment.fxml'.";

        Main.client.controller = this;
        //Main.stack.push("TeacherCheckAssignment");
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
		
		if(type.equals("Load Courses for Teacher"))
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