package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import interfaces.IController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AssignPupilToCourseController implements IController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button SendButton2;

    @FXML
    private Label PupilIDlabla;

    @FXML
    private TextField PupilIDtextField;

    @FXML
    private Button AssignButton;

    @FXML
    private Label AssignPupilCourseLable2;

    @FXML
    private Label AssignPupilCourseLable1;

    @FXML
    private TextField CourseIDtextField;

    @FXML
    private Button BackButton;

    @FXML
    private Label CourseIDlable;

    @FXML
    private Button SendButton1;

    @FXML
    void EnterPupilID(ActionEvent event) {

    }

    @FXML
    void EnterCourseID(ActionEvent event) {

    }

    @FXML
    void SendPupilID(ActionEvent event) {

    }

    @FXML
    void SendCourseID(ActionEvent event) {

    }

    @FXML
    void AssignPupilCourse(ActionEvent event) {

    }

    @FXML
    void BackToMenu(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert SendButton2 != null : "fx:id=\"SendButton2\" was not injected: check your FXML file 'SecretaryAssignPupilToCourse.fxml'.";
        assert PupilIDlabla != null : "fx:id=\"PupilIDlabla\" was not injected: check your FXML file 'SecretaryAssignPupilToCourse.fxml'.";
        assert PupilIDtextField != null : "fx:id=\"PupilIDtextField\" was not injected: check your FXML file 'SecretaryAssignPupilToCourse.fxml'.";
        assert AssignButton != null : "fx:id=\"AssignButton\" was not injected: check your FXML file 'SecretaryAssignPupilToCourse.fxml'.";
        assert AssignPupilCourseLable2 != null : "fx:id=\"AssignPupilCourseLable2\" was not injected: check your FXML file 'SecretaryAssignPupilToCourse.fxml'.";
        assert AssignPupilCourseLable1 != null : "fx:id=\"AssignPupilCourseLable1\" was not injected: check your FXML file 'SecretaryAssignPupilToCourse.fxml'.";
        assert CourseIDtextField != null : "fx:id=\"CourseIDtextField\" was not injected: check your FXML file 'SecretaryAssignPupilToCourse.fxml'.";
        assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'SecretaryAssignPupilToCourse.fxml'.";
        assert CourseIDlable != null : "fx:id=\"CourseIDlable\" was not injected: check your FXML file 'SecretaryAssignPupilToCourse.fxml'.";
        assert SendButton1 != null : "fx:id=\"SendButton1\" was not injected: check your FXML file 'SecretaryAssignPupilToCourse.fxml'.";

        Main.client.controller=this;
    }

	@Override
	public void handleAnswer(Object msg) {
		// TODO Auto-generated method stub
		
	}
}
