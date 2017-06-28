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
    private String UserID;
    private String AvailableHours;
    private String CourseID;
    
    @FXML
    void ChooseExeptionalRequst(ActionEvent event) {
    	
    	req=ExeptionalRequstBox.getSelectionModel().getSelectedItem();
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
    	
    	req = ExeptionalRequstBox.getSelectionModel().getSelectedItem();
    	com = commentTF.getText();
    	if(req.equals("")) 	new Alert(AlertType.ERROR, "No request selected!", ButtonType.OK).showAndWait();
    	else if(des.equals("")) 	new Alert(AlertType.ERROR, "No descition excepted!", ButtonType.OK).showAndWait();
    	else if(des.equals("confirm"))
    	{
    		
    		loadUserID();
    		if(req.contentEquals("Reassign"))
    		{
    			checkTeacherHours();
    		}
    		else if(req.contentEquals("assign"))
    		{
    			checkPreCourses();
    		}
    		else
    		{
    	    	updateDescision(des);
    	    	updateComment(com);
    			new Alert(AlertType.INFORMATION, "Your descision sent successfully!", ButtonType.OK).showAndWait();
    		}
    	}
    		
    	else	
    	{
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
    	data.add("descision");
    	data.add("panding");

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
		String selectedER = ExeptionalRequstBox.getSelectionModel().getSelectedItem();
		if (selectedER == null)
			return;
		String[] ans = selectedER.split(":");
    	ArrayList<String> data = new ArrayList<String>();
    	data.add("update descision");
    	data.add("update");
    	data.add("exceptional_request");
		data.add("descision");
		data.add(descision);
		data.add("conditions");
		data.add("exceptonalRequestID");
		data.add(ans[0]);

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
		String[] ans = selectedER.split(":");
		ArrayList<String> data = new ArrayList<String>();
    	data.add("update descision");
    	data.add("update");
    	data.add("exceptional_request");
		data.add("comment");
		data.add(comment);
		data.add("conditions");
		data.add("exceptonalRequestID");
		data.add(ans[0]);

    	try
    	{
    		Main.client.sendToServer(data);
    	}
    	catch (IOException e)
    	{
    		e.printStackTrace();
    	}
    }
    
    void loadUserID()
    {
    	String[] temp=req.split(":");
    	String reqID=temp[0];
    	
    	ArrayList<String> data = new ArrayList<String>();
    	data.add("load userID");
    	data.add("select");
    	data.add("exceptional_request");
    	data.add("exceptonalRequestID");
    	data.add(reqID);

    	try
    	{
    		Main.client.sendToServer(data);
    	}
    	catch (IOException e)
    	{
    		e.printStackTrace();
    	}
    	
    	
    }
    
    void checkTeacherHours()
    {
    	ArrayList<String> data = new ArrayList<String>();
    	data.add("check teacher hours");
    	data.add("select");
    	data.add("teacher");
    	data.add("userID");
    	data.add(UserID);

    	try
    	{
    		Main.client.sendToServer(data);
    	}
    	catch (IOException e)
    	{
    		e.printStackTrace();
    	}
    }

	void LoadCourseWeekHours()
	{
	   	ArrayList<String> data = new ArrayList<String>();
    	data.add("check course hours");
    	data.add("select");
    	data.add("courses");
    	data.add("courseId");
    	data.add(CourseID);

    	try
    	{
    		Main.client.sendToServer(data);
    	}
    	catch (IOException e)
    	{
    		e.printStackTrace();
    	}
	}
	
	void checkPreCourses()
	{
	   	ArrayList<String> data = new ArrayList<String>();
    	data.add("check pre course of course");
    	data.add("select");
    	data.add("courses");
    	data.add("courseId");
    	data.add(CourseID);

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
        com="";
        des="";
        req="";
        UserID="";
        AvailableHours="";
        CourseID="";
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
				UserID=map.get("userID");
				String TYPE1=map.get("type");
				String Course  =map.get("CourseID");
				String Class=map.get("classId");
				if(TYPE1.equals("assign")||TYPE1.equals("delete"))
				{
				ExeptionalRequstBox.getItems().add(ER + ": " + allExeptionalRequests.get(ER).get("type") + "Pupil with ID: " + UserID + " To Course With ID: " + Course + " In Class With ID: " + Class);
				}
				else if(TYPE1.equals("Reassign"))
				{
					ExeptionalRequstBox.getItems().add(ER + ": " + allExeptionalRequests.get(ER).get("type") + " Teacher with ID: " + UserID + " To Course With ID: " + Course + " In Class With ID: " + Class);
				}
			}
		}
		
		if(type.equals("load userID"))
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
				UserID=map.get("userID");
				CourseID=map.get("CourseID");
			}
		}
		
		if(type.equals("check teacher hours"))
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
				String MaxHours=map.get("MaxHoursForWeek");
				String WorkHours=map.get("workHours");
				int AvailableHours1=Integer.parseInt(MaxHours)-Integer.parseInt(WorkHours);
				AvailableHours=Integer.toString(AvailableHours1);
			}
			
			LoadCourseWeekHours();
		}
		
		if(type.equals("check course hours"))
		{
			int num=0;
			for (String row : arr)
			{
				String[] cols = row.split(";");
				HashMap<String, String> map = new HashMap<>();
				for (String col : cols)
				{
					String[] field = col.split("=");
					map.put(field[0], field[1]);
				}
				String courseHours=map.get("weeklyStudyHours");
				num=Integer.parseInt(AvailableHours)-Integer.parseInt(courseHours);
			}
			
			if(num<0)
			{
				new Alert(AlertType.INFORMATION, "Avialable Hours Of Teacher Not Enough For The Course!", ButtonType.OK).showAndWait();
			}
		}
	}
}
