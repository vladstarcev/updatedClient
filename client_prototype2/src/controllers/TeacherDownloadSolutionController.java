package controllers;

import interfaces.IController;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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
    
    
    @FXML
    void chooseCourse(ActionEvent event) {
       	CBchoice=ChooseCourseCB.getSelectionModel().getSelectedItem();
    }

    @FXML
    void ChooseCourse(ActionEvent event) {

    }

    @FXML
    void ChooseAssignment(ActionEvent event) {
    	//AssName=ChooseAssCB.getSelectionModel().getSelectedItem();
    }

    @FXML
    void DownloadSolution(ActionEvent event) {

    }

    @FXML
    void BackToMenu(ActionEvent event) {
   
    }

    @FXML
    void ChoosePupil(ActionEvent event) {

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
        Main.stack.push("TeacherCheckAssignment");
    }

	@Override
	public void handleAnswer(Object msg) {
		// TODO Auto-generated method stub
		
		/*if (msg == null)
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
	}*/
	}

}