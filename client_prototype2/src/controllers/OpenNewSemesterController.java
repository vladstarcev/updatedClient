package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import interfaces.IController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class OpenNewSemesterController implements IController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label OpenSemesterLable;

    @FXML
    private Label StatusLable;

    @FXML
    private TextField AcademicAcTextField;

    @FXML
    private Label SemesterIDLable;

    @FXML
    private Button BackButton;

    @FXML
    private MenuItem CurrentSEMMenu;

    @FXML
    private Label AcademicAcIDLable;

    @FXML
    private MenuItem SemesterB;

    @FXML
    private MenuItem SemesterA;

    @FXML
    private Label FillFormLable;

    @FXML
    private Button SendButton;

    @FXML
    private Label TypeLable;

    @FXML
    private TextField SemesterIdTextField;
    
    private String Type;
    private String Status;

    @FXML
    void EnterSemesterID(ActionEvent event) {

    }

    @FXML
    void EnterAcademicAcID(ActionEvent event) {

    }

    @FXML
    void SendSemesterForm(ActionEvent event) {

    }

    @FXML
    void BackToMenu(ActionEvent event) {

    	Type="";
    	Status="";
    }

    @FXML
    void SemA(ActionEvent event) {
    	
    	Type="A";
    }

    @FXML
    void SemB(ActionEvent event) {

    	Type="B";
    }

    @FXML
    void CurrentSEM(ActionEvent event) {

    	Status="Current";
    }

    @FXML
    void initialize() {
        assert OpenSemesterLable != null : "fx:id=\"OpenSemesterLable\" was not injected: check your FXML file 'SecretaryOpenSemester.fxml'.";
        assert StatusLable != null : "fx:id=\"StatusLable\" was not injected: check your FXML file 'SecretaryOpenSemester.fxml'.";
        assert AcademicAcTextField != null : "fx:id=\"AcademicAcTextField\" was not injected: check your FXML file 'SecretaryOpenSemester.fxml'.";
        assert SemesterIDLable != null : "fx:id=\"SemesterIDLable\" was not injected: check your FXML file 'SecretaryOpenSemester.fxml'.";
        assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'SecretaryOpenSemester.fxml'.";
        assert CurrentSEMMenu != null : "fx:id=\"CurrentSEMMenu\" was not injected: check your FXML file 'SecretaryOpenSemester.fxml'.";
        assert AcademicAcIDLable != null : "fx:id=\"AcademicAcIDLable\" was not injected: check your FXML file 'SecretaryOpenSemester.fxml'.";
        assert SemesterB != null : "fx:id=\"SemesterB\" was not injected: check your FXML file 'SecretaryOpenSemester.fxml'.";
        assert SemesterA != null : "fx:id=\"SemesterA\" was not injected: check your FXML file 'SecretaryOpenSemester.fxml'.";
        assert FillFormLable != null : "fx:id=\"FillFormLable\" was not injected: check your FXML file 'SecretaryOpenSemester.fxml'.";
        assert SendButton != null : "fx:id=\"SendButton\" was not injected: check your FXML file 'SecretaryOpenSemester.fxml'.";
        assert TypeLable != null : "fx:id=\"TypeLable\" was not injected: check your FXML file 'SecretaryOpenSemester.fxml'.";
        assert SemesterIdTextField != null : "fx:id=\"SemesterIdTextField\" was not injected: check your FXML file 'SecretaryOpenSemester.fxml'.";

        Main.client.controller=this;
        
          Type="";
          Status="";
    }

	@Override
	public void handleAnswer(Object msg) {
		// TODO Auto-generated method stub
		
	}
}
