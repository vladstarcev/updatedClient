package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.stage.Stage;

public class PupilAssignmentController {

    @FXML
    private Label UploadTextField;

    @FXML
    private ChoiceBox<?> DisplayAssignmentList;

    @FXML
    private Label AssignmentTextField;

    @FXML
    private Button UploadButton;

    @FXML
    private ChoiceBox<?> DisplayCourseList;

    @FXML
    private Hyperlink FileHyperLink;

    @FXML
    private ProgressIndicator ProgressUpload;

    @FXML
    private Label CourseTextField;

    @FXML
    void UploadSolutionFile(ActionEvent event) {

    }

    @FXML
    void ChooseSolutionFile(ActionEvent event) {

    }
    
	public void start(Stage primaryStage) throws Exception {	
		
	}

}
