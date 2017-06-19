package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import interfaces.IController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DefineAssignmentController implements IController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private DatePicker DueDatePicker;

    @FXML
    private Label EnterDueDateLabel;

    @FXML
    private Label DefineAssignmentLabel;

    @FXML
    private Button BackButton;

    @FXML
    private TextField EnterClassIDTextField;

    @FXML
    private Hyperlink UploadFileHyperLink;

    @FXML
    private Button DefineAssignmentButton;

    @FXML
    private Label EnterClassIdLabel;

    @FXML
    void EnterClassID(ActionEvent event) {

    }

    @FXML
    void EnterDueDate(ActionEvent event) {

    }

    @FXML
    void DefineAssignment(ActionEvent event) {

    }

    @FXML
    void BackToMenu(ActionEvent event) {

    }

    @FXML
    void ChooseFileToUpload(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert DueDatePicker != null : "fx:id=\"DueDatePicker\" was not injected: check your FXML file 'TeacherDefineAssignment.fxml'.";
        assert EnterDueDateLabel != null : "fx:id=\"EnterDueDateLabel\" was not injected: check your FXML file 'TeacherDefineAssignment.fxml'.";
        assert DefineAssignmentLabel != null : "fx:id=\"DefineAssignmentLabel\" was not injected: check your FXML file 'TeacherDefineAssignment.fxml'.";
        assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'TeacherDefineAssignment.fxml'.";
        assert EnterClassIDTextField != null : "fx:id=\"EnterClassIDTextField\" was not injected: check your FXML file 'TeacherDefineAssignment.fxml'.";
        assert UploadFileHyperLink != null : "fx:id=\"UploadFileHyperLink\" was not injected: check your FXML file 'TeacherDefineAssignment.fxml'.";
        assert DefineAssignmentButton != null : "fx:id=\"DefineAssignmentButton\" was not injected: check your FXML file 'TeacherDefineAssignment.fxml'.";
        assert EnterClassIdLabel != null : "fx:id=\"EnterClassIdLabel\" was not injected: check your FXML file 'TeacherDefineAssignment.fxml'.";

        Main.client.controller=this;
    }

	@Override
	public void handleAnswer(Object msg) {
		// TODO Auto-generated method stub
		
	}
}
