package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import interfaces.IController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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

    @FXML
    void ChooseCourse(ActionEvent event) {

    }

    @FXML
    void ChooseAss(ActionEvent event) {

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
		
	}
}
