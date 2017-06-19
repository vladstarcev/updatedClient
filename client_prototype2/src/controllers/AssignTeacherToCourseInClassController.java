package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import interfaces.IController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AssignTeacherToCourseInClassController implements IController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button SendButton2;

    @FXML
    private Button SendButton3;

    @FXML
    private Label StudyUnitLable;

    @FXML
    private TextField ClassIDTextField;

    @FXML
    private ChoiceBox<?> StudyUnitChoiseBox;

    @FXML
    private Label TeacherIDLable;

    @FXML
    private TextField CourseIDTextField;

    @FXML
    private Button BackButton;

    @FXML
    private Label ClassIDLable;

    @FXML
    private Button SendButton1;

    @FXML
    private Button AssignTeacherButton;

    @FXML
    private TextField TecherIDTextField;

    @FXML
    private Label AssignTeacherLable1;

    @FXML
    private Label AssignTeacherLable2;

    @FXML
    private Label CourseIDLable;

    @FXML
    void EnterTeacherID(ActionEvent event) {

    }

    @FXML
    void EnterCourseID(ActionEvent event) {

    }

    @FXML
    void EnterClassID(ActionEvent event) {

    }

    @FXML
    void SendTeacherID(ActionEvent event) {

    }

    @FXML
    void SendCourseID(ActionEvent event) {

    }

    @FXML
    void SendClassID(ActionEvent event) {

    }

    @FXML
    void BackToMenu(ActionEvent event) {

    }

    @FXML
    void AssignTeacher(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert SendButton2 != null : "fx:id=\"SendButton2\" was not injected: check your FXML file 'SecretaryAssignTeacher.fxml'.";
        assert SendButton3 != null : "fx:id=\"SendButton3\" was not injected: check your FXML file 'SecretaryAssignTeacher.fxml'.";
        assert StudyUnitLable != null : "fx:id=\"StudyUnitLable\" was not injected: check your FXML file 'SecretaryAssignTeacher.fxml'.";
        assert ClassIDTextField != null : "fx:id=\"ClassIDTextField\" was not injected: check your FXML file 'SecretaryAssignTeacher.fxml'.";
        assert StudyUnitChoiseBox != null : "fx:id=\"StudyUnitChoiseBox\" was not injected: check your FXML file 'SecretaryAssignTeacher.fxml'.";
        assert TeacherIDLable != null : "fx:id=\"TeacherIDLable\" was not injected: check your FXML file 'SecretaryAssignTeacher.fxml'.";
        assert CourseIDTextField != null : "fx:id=\"CourseIDTextField\" was not injected: check your FXML file 'SecretaryAssignTeacher.fxml'.";
        assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'SecretaryAssignTeacher.fxml'.";
        assert ClassIDLable != null : "fx:id=\"ClassIDLable\" was not injected: check your FXML file 'SecretaryAssignTeacher.fxml'.";
        assert SendButton1 != null : "fx:id=\"SendButton1\" was not injected: check your FXML file 'SecretaryAssignTeacher.fxml'.";
        assert AssignTeacherButton != null : "fx:id=\"AssignTeacherButton\" was not injected: check your FXML file 'SecretaryAssignTeacher.fxml'.";
        assert TecherIDTextField != null : "fx:id=\"TecherIDTextField\" was not injected: check your FXML file 'SecretaryAssignTeacher.fxml'.";
        assert AssignTeacherLable1 != null : "fx:id=\"AssignTeacherLable1\" was not injected: check your FXML file 'SecretaryAssignTeacher.fxml'.";
        assert AssignTeacherLable2 != null : "fx:id=\"AssignTeacherLable2\" was not injected: check your FXML file 'SecretaryAssignTeacher.fxml'.";
        assert CourseIDLable != null : "fx:id=\"CourseIDLable\" was not injected: check your FXML file 'SecretaryAssignTeacher.fxml'.";

        Main.client.controller=this;
    }

	@Override
	public void handleAnswer(Object msg) {
		// TODO Auto-generated method stub
		
	}
}
