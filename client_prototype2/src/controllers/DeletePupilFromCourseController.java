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

public class DeletePupilFromCourseController implements IController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button SendButton2;

    @FXML
    private Label PupilIDLable;

    @FXML
    private TextField PupilIDTextField;

    @FXML
    private Button DeleteButton;

    @FXML
    private TextField CourseIDTextField;

    @FXML
    private Label CourseIDLable;

    @FXML
    private Label DeleteLable2;

    @FXML
    private Label DeleteLable1;

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
    void DeletePupilCourse(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert SendButton2 != null : "fx:id=\"SendButton2\" was not injected: check your FXML file 'SecretaryDeletePupilFromCourse.fxml'.";
        assert PupilIDLable != null : "fx:id=\"PupilIDLable\" was not injected: check your FXML file 'SecretaryDeletePupilFromCourse.fxml'.";
        assert PupilIDTextField != null : "fx:id=\"PupilIDTextField\" was not injected: check your FXML file 'SecretaryDeletePupilFromCourse.fxml'.";
        assert DeleteButton != null : "fx:id=\"DeleteButton\" was not injected: check your FXML file 'SecretaryDeletePupilFromCourse.fxml'.";
        assert CourseIDTextField != null : "fx:id=\"CourseIDTextField\" was not injected: check your FXML file 'SecretaryDeletePupilFromCourse.fxml'.";
        assert CourseIDLable != null : "fx:id=\"CourseIDLable\" was not injected: check your FXML file 'SecretaryDeletePupilFromCourse.fxml'.";
        assert DeleteLable2 != null : "fx:id=\"DeleteLable2\" was not injected: check your FXML file 'SecretaryDeletePupilFromCourse.fxml'.";
        assert DeleteLable1 != null : "fx:id=\"DeleteLable1\" was not injected: check your FXML file 'SecretaryDeletePupilFromCourse.fxml'.";
        assert SendButton1 != null : "fx:id=\"SendButton1\" was not injected: check your FXML file 'SecretaryDeletePupilFromCourse.fxml'.";

        Main.client.controller=this;
    }

	@Override
	public void handleAnswer(Object msg) {
		// TODO Auto-generated method stub
		
	}
}
