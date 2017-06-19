package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import interfaces.IController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class OpenCourseController implements IController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button SendButton2;

    @FXML
    private ComboBox<?> ChooseCourseComboBox;

    @FXML
    private Label StudyUnitLable;

    @FXML
    private TextField ClassIDTextField;

    @FXML
    private Label OpenCourseLable;

    @FXML
    private TextField StudyUnitTextField;

    @FXML
    private Button OpenButton;

    @FXML
    private Button BackButton;

    @FXML
    private Button SendButton1;

    @FXML
    void EnterStudyUnit(ActionEvent event) {

    }

    @FXML
    void EnterClassID(ActionEvent event) {

    }

    @FXML
    void SendClassID(ActionEvent event) {

    }

    @FXML
    void SendStudyUnit(ActionEvent event) {

    }

    @FXML
    void BackToMenu(ActionEvent event) {

    }

    @FXML
    void CourseList(ActionEvent event) {

    }

    @FXML
    void OpenCourseInClass(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert SendButton2 != null : "fx:id=\"SendButton2\" was not injected: check your FXML file 'SecretaryOpenCourse.fxml'.";
        assert ChooseCourseComboBox != null : "fx:id=\"ChooseCourseComboBox\" was not injected: check your FXML file 'SecretaryOpenCourse.fxml'.";
        assert StudyUnitLable != null : "fx:id=\"StudyUnitLable\" was not injected: check your FXML file 'SecretaryOpenCourse.fxml'.";
        assert ClassIDTextField != null : "fx:id=\"ClassIDTextField\" was not injected: check your FXML file 'SecretaryOpenCourse.fxml'.";
        assert OpenCourseLable != null : "fx:id=\"OpenCourseLable\" was not injected: check your FXML file 'SecretaryOpenCourse.fxml'.";
        assert StudyUnitTextField != null : "fx:id=\"StudyUnitTextField\" was not injected: check your FXML file 'SecretaryOpenCourse.fxml'.";
        assert OpenButton != null : "fx:id=\"OpenButton\" was not injected: check your FXML file 'SecretaryOpenCourse.fxml'.";
        assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'SecretaryOpenCourse.fxml'.";
        assert SendButton1 != null : "fx:id=\"SendButton1\" was not injected: check your FXML file 'SecretaryOpenCourse.fxml'.";

        Main.client.controller=this;
    }

	@Override
	public void handleAnswer(Object msg) {
		// TODO Auto-generated method stub
		
	}
}
