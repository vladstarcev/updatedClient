package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Main;
import interfaces.IController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import ui.UserWindow;

public class HandlingExeptionalRequestController implements IController {
	  @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private ComboBox<String> chooseTypeCB;

	    @FXML
	    private MenuItem DenyMenuItem;

	    @FXML
	    private Label CommentsLabel;

	    @FXML
	    private ComboBox<String> ExeptionalRequstBox;

	    @FXML
	    private Label HandleExeptionalRequestLabel;

	    @FXML
	    private Button BackButton;

	    @FXML
	    private MenuItem ConformMenuItem;

	    @FXML
	    private TextArea CommentsAreaText;

	    @FXML
	    private MenuButton DecisionMenu;

	    @FXML
	    private Button SendAnswarButton;

	    
	    void loadAllExeptionalRequest()
	    {
			ArrayList<String> data = new ArrayList<String>();
			data.add("load all exeptional request");
			data.add("select");
			data.add("exceptional_request");

			try
			{
				Main.client.sendToServer(data);
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
	    }
	    
	    void loadAllTypes()
	    {
	    	ArrayList<String> data = new ArrayList<String>();
			data.add("load all type requests");
			data.add("select");
			data.add("exceptional_request");
			data.add("type");
			data.add("select");


	    }
	    
	    @FXML
	    void ChooseExeptionalRequst(ActionEvent event) {

	    }

	    @FXML
	    void ChooseDecision(ActionEvent event) {

	    }

	    @FXML
	    void ConformExeptionalRequest(ActionEvent event) {

	    }

	    @FXML
	    void Confirm(ActionEvent event) {

	    }

	    @FXML
	    void DenyExeptionalRequest(ActionEvent event) {

	    }

	    @FXML
	    void Deny(ActionEvent event) {

	    }

	    @FXML
	    void SendAnswar(ActionEvent event) {

	    }

	    @FXML
	    void BackToMenu(ActionEvent event) {
	    	
			UserWindow.closeUserWindow(getClass(), (Stage) BackButton.getScene().getWindow());
	    }

	    @FXML
	    void chooseType(ActionEvent event) {

	    }

    @FXML
    void initialize() {
        assert chooseTypeCB != null : "fx:id=\"chooseTypeCB\" was not injected: check your FXML file 'SchoolManagerHandlingExeptionalRequest.fxml'.";
        assert DenyMenuItem != null : "fx:id=\"DenyMenuItem\" was not injected: check your FXML file 'SchoolManagerHandlingExeptionalRequest.fxml'.";
        assert CommentsLabel != null : "fx:id=\"CommentsLabel\" was not injected: check your FXML file 'SchoolManagerHandlingExeptionalRequest.fxml'.";
        assert ExeptionalRequstBox != null : "fx:id=\"ExeptionalRequstBox\" was not injected: check your FXML file 'SchoolManagerHandlingExeptionalRequest.fxml'.";
        assert HandleExeptionalRequestLabel != null : "fx:id=\"HandleExeptionalRequestLabel\" was not injected: check your FXML file 'SchoolManagerHandlingExeptionalRequest.fxml'.";
        assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'SchoolManagerHandlingExeptionalRequest.fxml'.";
        assert ConformMenuItem != null : "fx:id=\"ConformMenuItem\" was not injected: check your FXML file 'SchoolManagerHandlingExeptionalRequest.fxml'.";
        assert CommentsAreaText != null : "fx:id=\"CommentsAreaText\" was not injected: check your FXML file 'SchoolManagerHandlingExeptionalRequest.fxml'.";
        assert DecisionMenu != null : "fx:id=\"DecisionMenu\" was not injected: check your FXML file 'SchoolManagerHandlingExeptionalRequest.fxml'.";
        assert SendAnswarButton != null : "fx:id=\"SendAnswarButton\" was not injected: check your FXML file 'SchoolManagerHandlingExeptionalRequest.fxml'.";

        Main.client.controller=this;
        loadAllExeptionalRequest();
    }

	@Override
	public void handleAnswer(Object msg) {
		// TODO Auto-generated method stub
		
	}
}
