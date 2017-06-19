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

public class DefineClassController implements IController{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField MaximumPupilInClassTextField;

    @FXML
    private Label EnterClassNameLabel;

    @FXML
    private TextField ClassNameTextField;

    @FXML
    private Label EnterMAximumPupilLabel;

    @FXML
    private Button BackButton;

    @FXML
    private Label DefineClassLabel;

    @FXML
    private Label FillFormLabel;

    @FXML
    private Button DefineClassButton;

    @FXML
    void EnterMaxPupilForClass(ActionEvent event) {

    }

    @FXML
    void EnterClassName(ActionEvent event) {

    }

    @FXML
    void DefineClass(ActionEvent event) {

    }

    @FXML
    void BackToMenu(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert MaximumPupilInClassTextField != null : "fx:id=\"MaximumPupilInClassTextField\" was not injected: check your FXML file 'SecretaryDefineClass.fxml'.";
        assert EnterClassNameLabel != null : "fx:id=\"EnterClassNameLabel\" was not injected: check your FXML file 'SecretaryDefineClass.fxml'.";
        assert ClassNameTextField != null : "fx:id=\"ClassNameTextField\" was not injected: check your FXML file 'SecretaryDefineClass.fxml'.";
        assert EnterMAximumPupilLabel != null : "fx:id=\"EnterMAximumPupilLabel\" was not injected: check your FXML file 'SecretaryDefineClass.fxml'.";
        assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'SecretaryDefineClass.fxml'.";
        assert DefineClassLabel != null : "fx:id=\"DefineClassLabel\" was not injected: check your FXML file 'SecretaryDefineClass.fxml'.";
        assert FillFormLabel != null : "fx:id=\"FillFormLabel\" was not injected: check your FXML file 'SecretaryDefineClass.fxml'.";
        assert DefineClassButton != null : "fx:id=\"DefineClassButton\" was not injected: check your FXML file 'SecretaryDefineClass.fxml'.";

        Main.client.controller=this;
    }

	@Override
	public void handleAnswer(Object msg) {
		// TODO Auto-generated method stub
		
	}
}
