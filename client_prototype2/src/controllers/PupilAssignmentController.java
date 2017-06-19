package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import interfaces.IController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;

public class PupilAssignmentController implements IController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label UploadTextField;

    @FXML
    private ChoiceBox<?> DisplayAssignmentList;

    @FXML
    private Label AssignmentTextField;

    @FXML
    private Button UploadButton;

    @FXML
    private Button BackButton;

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

    @FXML
    void BackToPupilMenu(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert UploadTextField != null : "fx:id=\"UploadTextField\" was not injected: check your FXML file 'Pupil.fxml'.";
        assert DisplayAssignmentList != null : "fx:id=\"DisplayAssignmentList\" was not injected: check your FXML file 'Pupil.fxml'.";
        assert AssignmentTextField != null : "fx:id=\"AssignmentTextField\" was not injected: check your FXML file 'Pupil.fxml'.";
        assert UploadButton != null : "fx:id=\"UploadButton\" was not injected: check your FXML file 'Pupil.fxml'.";
        assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'Pupil.fxml'.";
        assert DisplayCourseList != null : "fx:id=\"DisplayCourseList\" was not injected: check your FXML file 'Pupil.fxml'.";
        assert FileHyperLink != null : "fx:id=\"FileHyperLink\" was not injected: check your FXML file 'Pupil.fxml'.";
        assert ProgressUpload != null : "fx:id=\"ProgressUpload\" was not injected: check your FXML file 'Pupil.fxml'.";
        assert CourseTextField != null : "fx:id=\"CourseTextField\" was not injected: check your FXML file 'Pupil.fxml'.";

        Main.client.controller=this;
    }

	@Override
	public void handleAnswer(Object msg) {
		// TODO Auto-generated method stub
		
	}
}

