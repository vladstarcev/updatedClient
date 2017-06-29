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

/**
 * The Class HandlingExeptionalRequestController.
 */
public class HandlingExeptionalRequestController implements IController{

    /** The resources. */
    @FXML
    private ResourceBundle resources;

    /** The location. */
    @FXML
    private URL location;

    /** The comment TF. */
    @FXML
    private TextField commentTF;

    /** The Deny menu item. */
    @FXML
    private MenuItem DenyMenuItem;

    /** The Comments label. */
    @FXML
    private Label CommentsLabel;

    /** The Exeptional requst box. */
    @FXML
    private ComboBox<String> ExeptionalRequstBox;

    /** The Handle exeptional request label. */
    @FXML
    private Label HandleExeptionalRequestLabel;

    /** The Back button. */
    @FXML
    private Button BackButton;

    /** The Conform menu item. */
    @FXML
    private MenuItem ConformMenuItem;

    /** The Decision menu. */
    @FXML
    private MenuButton DecisionMenu;

    /** The Send answar button. */
    @FXML
    private Button SendAnswarButton;

    /** The all exeptional requests. */
    private HashMap<String, HashMap<String, String>> allExeptionalRequests;
    
    /** The des. */
    private String des;
    
    /** The req. */
    private String req;
    
    /** The User ID. */
    private String UserID;
    
    /** The Available hours. */
    private String AvailableHours;
    
    /** The Course ID. */
    private String CourseID;
    
    /** The req type. */
    private String reqType;
      
    private boolean flag=false;
    /**
     * Choose exeptional requst.
     *
     * @param event the event
     */
    @FXML
    void ChooseExeptionalRequst(ActionEvent event) {
    	
    	req=ExeptionalRequstBox.getSelectionModel().getSelectedItem();
    	loadUserID();
    }

    /**
     * Choose decision.
     *
     * @param event the event
     */
    @FXML
    void ChooseDecision(ActionEvent event) {

    }

    /**
     * Conform exeptional request.
     *
     * @param event the event
     */
    @FXML
    void ConformExeptionalRequest(ActionEvent event) {
    	DecisionMenu.setText(ConformMenuItem.getText());
    	des= DecisionMenu.getText();

    }

    /**
     * Confirm.
     *
     * @param event the event
     */
    @FXML
    void Confirm(ActionEvent event) {
    
    }

    /**
     * Deny exeptional request.
     *
     * @param event the event
     */
    @FXML
    void DenyExeptionalRequest(ActionEvent event) {
    	
    	DecisionMenu.setText(DenyMenuItem.getText());
    	des= DecisionMenu.getText();

    }

    /**
     * Deny.
     *
     * @param event the event
     */
    @FXML
    void Deny(ActionEvent event) {

    }

    /**
     * Send answar.
     *
     * @param event the event
     */
    @FXML
    void SendAnswar(ActionEvent event) {
    	
    	req = ExeptionalRequstBox.getSelectionModel().getSelectedItem();
    	if(req==null){
    		new Alert(AlertType.ERROR, "No request selected!", ButtonType.OK).showAndWait();
    		return;
    	}
    	if(des.equals("")){
    		new Alert(AlertType.ERROR, "No descition excepted!", ButtonType.OK).showAndWait();
    		return;
    	}
    	if(des.equals("confirm"))
    	{
    	  		
    		if(reqType.equals("Reassign"))
    		{
    			flag=true;
    			checkTeacherHours();
    		}
    	}
    		
    	else	
    	{
	    	updateDescision(des);
			new Alert(AlertType.INFORMATION, "Your descision sent successfully!", ButtonType.OK).showAndWait();
			String selected = ExeptionalRequstBox.getSelectionModel().getSelectedItem();
			ExeptionalRequstBox.getItems().remove(selected);
			
    	}
    }

    /**
     * Back to menu.
     *
     * @param event the event
     */
    @FXML
    void BackToMenu(ActionEvent event) {
    	UserWindow.closeUserWindow(getClass(), (Stage) BackButton.getScene().getWindow());
    }

    /**
     * Comment text field.
     *
     * @param event the event
     */
    @FXML
    void commentTextField(ActionEvent event) {
    }

    /**
     * Load all exeptional request.
     */
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
    
    /**
     * Update descision.
     *
     * @param descision the descision
     */
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
    
    /**
     * Load user ID.
     */
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
    
    /**
     * Check teacher hours.
     */
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

	/**
	 * Load course week hours.
	 */
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
	
	/**
	 * Check pre courses.
	 */
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
    

    
    /**
     * Initialize.
     */
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
        Main.stack.push("SchoolManagerHandlingExeptionalRequest");
        
        allExeptionalRequests = new HashMap<>();
        des="";
        req="";
        UserID="";
        AvailableHours="";
        CourseID="";
        reqType="";
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
				reqType=map.get("type");
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
				return;
			}
			if(flag){
				updateDescision(des);
				new Alert(AlertType.INFORMATION, "Your descision sent successfully!", ButtonType.OK).showAndWait();
				String selected = ExeptionalRequstBox.getSelectionModel().getSelectedItem();
				ExeptionalRequstBox.getItems().remove(selected);
			}
			
		}
	}
}
