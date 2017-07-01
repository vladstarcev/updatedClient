package controllers;

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
import javafx.scene.control.Hyperlink;

public class TeacherCheckAssignmentController implements IController {

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

    private String CBchoice;
    private String AssName;
    @FXML
    void ChooseCourse(ActionEvent event) {
    	CBchoice=ChooseCourseCB.getSelectionModel().getSelectedItem();
    }

    @FXML
    void ChooseAss(ActionEvent event) {
    	AssName=ChooseAssCB.getSelectionModel().getSelectedItem();
    }

    @FXML
    void ChoosePupil(ActionEvent event) {

    }

    @FXML
    void BackToMenu(ActionEvent event) {

    }

    @FXML
    void DownSoulotion(ActionEvent event) {

    }

    @FXML
    void UploadAss(ActionEvent event) {

    }
    @FXML
    void initialize() {
        assert BackToMenuButton != null : "fx:id=\"BackToMenuButton\" was not injected: check your FXML file 'TeacherCheckAssignment.fxml'.";
        assert UploadAssHyperLink != null : "fx:id=\"UploadAssHyperLink\" was not injected: check your FXML file 'TeacherCheckAssignment.fxml'.";
        assert DownLoadHYPERlINK != null : "fx:id=\"DownLoadHYPERlINK\" was not injected: check your FXML file 'TeacherCheckAssignment.fxml'.";
        assert ChooseAssCB != null : "fx:id=\"ChooseAssCB\" was not injected: check your FXML file 'TeacherCheckAssignment.fxml'.";
        assert ChoosePupilCB != null : "fx:id=\"ChoosePupilCB\" was not injected: check your FXML file 'TeacherCheckAssignment.fxml'.";
        assert ChooseCourseCB != null : "fx:id=\"ChooseCourseCB\" was not injected: check your FXML file 'TeacherCheckAssignment.fxml'.";

        Main.client.controller = this;
        Main.stack.push("TeacherCheckAssignment");

    }

	@Override
	public void handleAnswer(Object msg) {
		// TODO Auto-generated method stub
		
	/*	if (msg == null)
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
		}*/
	}
}
