package controllers;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import interfaces.IController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
    private ComboBox<?> chooseCourseCB;

    @FXML
    private Label AssignmentTextField;

    @FXML
    private Button UploadButton;

    @FXML
    private Button BackButton;

    @FXML
    private Hyperlink FileHyperLink;

    @FXML
    private ComboBox<?> chooseAssCB;

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
    void chooseCourse(ActionEvent event) {

    }

    @FXML
    void chooseAss(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert UploadTextField != null : "fx:id=\"UploadTextField\" was not injected: check your FXML file 'PupilAssignment.fxml'.";
        assert chooseCourseCB != null : "fx:id=\"chooseCourseCB\" was not injected: check your FXML file 'PupilAssignment.fxml'.";
        assert AssignmentTextField != null : "fx:id=\"AssignmentTextField\" was not injected: check your FXML file 'PupilAssignment.fxml'.";
        assert UploadButton != null : "fx:id=\"UploadButton\" was not injected: check your FXML file 'PupilAssignment.fxml'.";
        assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'PupilAssignment.fxml'.";
        assert FileHyperLink != null : "fx:id=\"FileHyperLink\" was not injected: check your FXML file 'PupilAssignment.fxml'.";
        assert chooseAssCB != null : "fx:id=\"chooseAssCB\" was not injected: check your FXML file 'PupilAssignment.fxml'.";
        assert ProgressUpload != null : "fx:id=\"ProgressUpload\" was not injected: check your FXML file 'PupilAssignment.fxml'.";
        assert CourseTextField != null : "fx:id=\"CourseTextField\" was not injected: check your FXML file 'PupilAssignment.fxml'.";

        Main.client.controller=this;
    }

	@Override
	public void handleAnswer(Object msg) {
		// TODO Auto-generated method stub
		
	}
}

