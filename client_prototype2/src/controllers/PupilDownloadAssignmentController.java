package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import interfaces.IController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;

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
    private ComboBox<?> ChooseAssignmentCB;

    @FXML
    private ComboBox<?> ChooseCourseCB;

    @FXML
    void ChooseCourseCB(ActionEvent event) {

    }

    @FXML
    void ChooseAssignment(ActionEvent event) {

    }

    @FXML
    void BackToMenu(ActionEvent event) {

    }

    @FXML
    void DownloadAssignment(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert BackToMenuButton != null : "fx:id=\"BackToMenuButton\" was not injected: check your FXML file 'PupilDownloadAssignment.fxml'.";
        assert DownloadAssignmentHyperlink != null : "fx:id=\"DownloadAssignmentHyperlink\" was not injected: check your FXML file 'PupilDownloadAssignment.fxml'.";
        assert ChooseAssignmentCB != null : "fx:id=\"ChooseAssignmentCB\" was not injected: check your FXML file 'PupilDownloadAssignment.fxml'.";
        assert ChooseCourseCB != null : "fx:id=\"ChooseCourseCB\" was not injected: check your FXML file 'PupilDownloadAssignment.fxml'.";

    }

	@Override
	public void handleAnswer(Object msg) {
		// TODO Auto-generated method stub
		
	}
}

