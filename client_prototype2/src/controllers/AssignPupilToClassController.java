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

public class AssignPupilToClassController implements IController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button SendButton2;

    @FXML
    private TextField PupilIdTextFiield;

    @FXML
    private Label AssignPupilClassLable2;

    @FXML
    private TextField ClassIDTextField;

    @FXML
    private Label AssignPupilClassLable1;

    @FXML
    private Button AssignButton;

    @FXML
    private Label ClassIdLable;

    @FXML
    private Button BackButton;

    @FXML
    private Label PupilIdLable;

    @FXML
    private Button SendButton1;

    @FXML
    void EnterPupilID(ActionEvent event) {

    }

    @FXML
    void EnterClassID(ActionEvent event) {

    }

    @FXML
    void SendPupilID(ActionEvent event) {

    }

    @FXML
    void SendClassID(ActionEvent event) {

    }

    @FXML
    void BackToMenu(ActionEvent event) {

    }

    @FXML
    void AssignPupilToClass(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert SendButton2 != null : "fx:id=\"SendButton2\" was not injected: check your FXML file 'SecretaryAssignPupilToClass.fxml'.";
        assert PupilIdTextFiield != null : "fx:id=\"PupilIdTextFiield\" was not injected: check your FXML file 'SecretaryAssignPupilToClass.fxml'.";
        assert AssignPupilClassLable2 != null : "fx:id=\"AssignPupilClassLable2\" was not injected: check your FXML file 'SecretaryAssignPupilToClass.fxml'.";
        assert ClassIDTextField != null : "fx:id=\"ClassIDTextField\" was not injected: check your FXML file 'SecretaryAssignPupilToClass.fxml'.";
        assert AssignPupilClassLable1 != null : "fx:id=\"AssignPupilClassLable1\" was not injected: check your FXML file 'SecretaryAssignPupilToClass.fxml'.";
        assert AssignButton != null : "fx:id=\"AssignButton\" was not injected: check your FXML file 'SecretaryAssignPupilToClass.fxml'.";
        assert ClassIdLable != null : "fx:id=\"ClassIdLable\" was not injected: check your FXML file 'SecretaryAssignPupilToClass.fxml'.";
        assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'SecretaryAssignPupilToClass.fxml'.";
        assert PupilIdLable != null : "fx:id=\"PupilIdLable\" was not injected: check your FXML file 'SecretaryAssignPupilToClass.fxml'.";
        assert SendButton1 != null : "fx:id=\"SendButton1\" was not injected: check your FXML file 'SecretaryAssignPupilToClass.fxml'.";

        Main.client.controller=this; 
    }

	@Override
	public void handleAnswer(Object msg) {
		// TODO Auto-generated method stub
		
	}
}
