package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import application.Main;
import interfaces.IController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ui.UserWindow;

public class HandlingExeptionalRequestController implements IController{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField commentTF;

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
    private MenuButton DecisionMenu;

    @FXML
    private Button SendAnswarButton;

    private HashMap<String, HashMap<String, String>> allExeptionalRequests;
    private String com;
    private String des;
    private String req;
    @FXML
    void ChooseExeptionalRequst(ActionEvent event) {
    	req = ExeptionalRequstBox.getSelectionModel().getSelectedItem();
    }

    @FXML
    void ChooseDecision(ActionEvent event) {

    }

    @FXML
    void ConformExeptionalRequest(ActionEvent event) {
    	DecisionMenu.setText(ConformMenuItem.getText());
    	des= DecisionMenu.getText();
    }

    @FXML
    void Confirm(ActionEvent event) {

    }

    @FXML
    void DenyExeptionalRequest(ActionEvent event) {
    	DecisionMenu.setText(DenyMenuItem.getText());
    	des= DecisionMenu.getText();

    }

    @FXML
    void Deny(ActionEvent event) {

    }

    @FXML
    void SendAnswar(ActionEvent event) {
    	if(req==null) 	new Alert(AlertType.ERROR, "No request selected!", ButtonType.OK).showAndWait();
    	else if(des==null) 	new Alert(AlertType.ERROR, "No descition excepted!", ButtonType.OK).showAndWait();
    	else{
	    	updateDescision(des);
	    	updateComment(com);
			new Alert(AlertType.INFORMATION, "Your descision sent successfully!", ButtonType.OK).showAndWait();
    	}
    }

    @FXML
    void BackToMenu(ActionEvent event) {
    	UserWindow.closeUserWindow(getClass(), (Stage) BackButton.getScene().getWindow());
    }

    @FXML
    void commentTextField(ActionEvent event) {
      	com = commentTF.getText();
    }

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
    
    void updateDescision(String descision)
    {
		String selectedDes = ExeptionalRequstBox.getSelectionModel().getSelectedItem();
		if (selectedDes == null)
			return;
    	ArrayList<String> data = new ArrayList<String>();
    	data.add("update descision");
    	data.add("update");
    	data.add("exceptional_request");
		data.add("decision");
		data.add(descision);
		data.add("conditions");
		data.add("decision");
		data.add(null);

    	try
    	{
    		Main.client.sendToServer(data);
    	}
    	catch (IOException e)
    	{
    		e.printStackTrace();
    	}
    }
    
    void updateComment(String comment)
    {
		String selectedER = ExeptionalRequstBox.getSelectionModel().getSelectedItem();
		if (selectedER == null)
			return;
    	ArrayList<String> data = new ArrayList<String>();
    	data.add("update descision");
    	data.add("update");
    	data.add("exceptional_request");
		data.add("comment");
		data.add(comment);
		data.add("conditions");
		data.add("comment");
		data.add(null);

    	try
    	{
    		Main.client.sendToServer(data);
    	}
    	catch (IOException e)
    	{
    		e.printStackTrace();
    	}
    }

    

    
    @FXML
    void initialize() {
        assert commentTF != null : "fx:id=\"commentTF\" was not injected: check your FXML file 'SchoolManagerHandlingExeptionalRequest.fxml'.";
        assert DenyMenuItem != null : "fx:id=\"DenyMenuItem\" was not injected: check your FXML file 'SchoolManagerHandlingExeptionalRequest.fxml'.";
        assert CommentsLabel != null : "fx:id=\"CommentsLabel\" was not injected: check your FXML file 'SchoolManagerHandlingExeptionalRequest.fxml'.";
        assert ExeptionalRequstBox != null : "fx:id=\"ExeptionalRequstBox\" was not injected: check your FXML file 'SchoolManagerHandlingExeptionalRequest.fxml'.";
        assert HandleExeptionalRequestLabel != null : "fx:id=\"HandleExeptionalRequestLabel\" was not injected: check your FXML file 'SchoolManagerHandlingExeptionalRequest.fxml'.";
        assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'SchoolManagerHandlingExeptionalRequest.fxml'.";
        assert ConformMenuItem != null : "fx:id=\"ConformMenuItem\" was not injected: check your FXML file 'SchoolManagerHandlingExeptionalRequest.fxml'.";
        assert DecisionMenu != null : "fx:id=\"DecisionMenu\" was not injected: check your FXML file 'SchoolManagerHandlingExeptionalRequest.fxml'.";
        assert SendAnswarButton != null : "fx:id=\"SendAnswarButton\" was not injected: check your FXML file 'SchoolManagerHandlingExeptionalRequest.fxml'.";


        Main.client.controller=this;
        allExeptionalRequests = new HashMap<>();
        loadAllExeptionalRequest();

    }

    
  
	@Override
	public void handleAnswer(Object result) {
		if (result == null)
		{
			// error

			return;
		}	
		ArrayList<String> arr = (ArrayList<String>) result;
		String type = arr.remove(0);
		if (type.equals("load all exeptional request"))
		{
			for (String row : arr)
			{
				String[] cols = row.split(";");
				HashMap<String, String> map = new HashMap<>();
				for (String col : cols)
				{
					String[] field = col.split("=");
					map.put(field[0], field[1]);
				}
				allExeptionalRequests.put(map.get("exceptonalRequestID"), map);
				String ER = map.get("exceptonalRequestID");
				ExeptionalRequstBox.getItems().add(ER + ": " + allExeptionalRequests.get(ER).get("type"));
			}
		}		
	}
}
