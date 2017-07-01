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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import ui.UserWindow;

/**
 * The Class AssignPupilToCourseController - this class is assigning pupil to course .
 */
public class AssignPupilToCourseController implements IController {

	/** The resources. */
	@FXML
	private ResourceBundle resources;

	/** The location. */
	@FXML
	private URL location;

	/** The Check pupil button. */
	@FXML
	private Button CheckPupilButton;

	/** The Pupil ID label. */
	@FXML
	private Label PupilIDlabla;

	/** The Check course button. */
	@FXML
	private Button CheckCourseButton;

	/** The Request id in text field. */
	@FXML
	private TextField RequestIdTextField;

	/** The Pupil ID in text field. */
	@FXML
	private TextField PupilIDtextField;

	/** The Check request button. */
	@FXML
	private Button CheckRequestButton;

	/** The Assign button. */
	@FXML
	private Button AssignButton;

	/** The Request id label. */
	@FXML
	private Label RequestIdLabel;

	/** The Assign pupil course label 1. */
	@FXML
	private Label AssignPupilCourseLable1;

	/** The Course Id in text field. */
	@FXML
	private TextField CourseIDtextField;

	/** The Back button. */
	@FXML
	private Button BackButton;

	/** The Course Id label. */
	@FXML
	private Label CourseIDlable;

    /** The check course ID. */
    private int checkCourseID;
    
    /** The check pupil ID. */
    private int checkPupilID;
    
    /** The Exceptional request FLAG. */
    private int ExeReFLAG;
    
    /**
     * checking the pupil ID.
     *
     * @param event - the action of enter Pupil ID
     */
    @FXML
    void CheckPupilID(ActionEvent event) {
    	
    	try{
    		Integer.parseInt(PupilIDtextField.getText());
    	}
    	catch(NumberFormatException e){
    		new Alert(AlertType.ERROR, "Please enter the 9-digit pupil ID!", ButtonType.OK).showAndWait();
    		return;
    	}
    	
		ArrayList<String> data = new ArrayList<String>();
		data.add("Check Pupil");
		data.add("select");
		data.add("pupil");
		data.add("userID");
		data.add(PupilIDtextField.getText());
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
     * checking the course ID .
     *
     * @param event - the action of enter Course ID
     */
    @FXML
    void CheckCourseID(ActionEvent event) {
    	
    	try{
    		Integer.parseInt(CourseIDtextField.getText());
    	}
    	catch(NumberFormatException e){
    		new Alert(AlertType.ERROR, "Please enter the 5-digit course ID!", ButtonType.OK).showAndWait();
    		return;
    	}

		ArrayList<String> data = new ArrayList<String>();
		data.add("Check Course");
		data.add("select");
		data.add("courses");
		data.add("courseId");
		data.add(CourseIDtextField.getText());

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
     * checking the Assigning pupil to course.
     *
     * @param event - action that checking exceptional request flags , checking if the pupil Id entered correct, checking if the Course Id entered correct
     */
    @FXML
    void AssignPupilCourse(ActionEvent event) {
    	
    	if(ExeReFLAG==0)
    	{
    		new Alert(AlertType.ERROR, "Enter Availabele Request ID.", ButtonType.OK).showAndWait();
    	}
    	else if(checkPupilID==0)
    	{
    		new Alert(AlertType.ERROR, "Enter Availabele Pupil ID.", ButtonType.OK).showAndWait();
    	}
    	else if(checkCourseID==0)
    	{
    		new Alert(AlertType.ERROR, "Enter Availabele Course ID.", ButtonType.OK).showAndWait();
    	}
    	else
    	{
    		loadDecision();
    	}
    }

    /**
     * Back to menu.
     *
     * @param event - action that back to Secretary Menu
     */
    @FXML
    void BackToMenu(ActionEvent event) {

    	UserWindow.closeUserWindow(getClass(), (Stage) AssignPupilCourseLable1.getScene().getWindow());
    }
    
	/**
	 * checking the request ID of Exceptional request.
	 *
	 * @param event 
	 */
	@FXML
	void CheckRequestID(ActionEvent event)
	{
		
		try{
    		Integer.parseInt(RequestIdTextField.getText());
    	}
    	catch(NumberFormatException e){
    		new Alert(AlertType.ERROR, "Please enter the 4-digit request ID!", ButtonType.OK).showAndWait();
    		return;
    	}

		ArrayList<String> data = new ArrayList<String>();
		data.add("Check RequestID");
		data.add("select");
		data.add("exceptional_request");
		data.add("exceptonalRequestID");
		data.add(RequestIdTextField.getText());
		data.add("type");
		data.add("assign");

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
		assert CheckPupilButton != null : "fx:id=\"CheckPupilButton\" was not injected: check your FXML file 'SecretaryAssignPupilToCourse.fxml'.";
		assert PupilIDlabla != null : "fx:id=\"PupilIDlabla\" was not injected: check your FXML file 'SecretaryAssignPupilToCourse.fxml'.";
		assert CheckCourseButton != null : "fx:id=\"CheckCourseButton\" was not injected: check your FXML file 'SecretaryAssignPupilToCourse.fxml'.";
		assert RequestIdTextField != null : "fx:id=\"RequestIdTextField\" was not injected: check your FXML file 'SecretaryAssignPupilToCourse.fxml'.";
		assert PupilIDtextField != null : "fx:id=\"PupilIDtextField\" was not injected: check your FXML file 'SecretaryAssignPupilToCourse.fxml'.";
		assert CheckRequestButton != null : "fx:id=\"CheckRequestButton\" was not injected: check your FXML file 'SecretaryAssignPupilToCourse.fxml'.";
		assert AssignButton != null : "fx:id=\"AssignButton\" was not injected: check your FXML file 'SecretaryAssignPupilToCourse.fxml'.";
		assert RequestIdLabel != null : "fx:id=\"RequestIdLabel\" was not injected: check your FXML file 'SecretaryAssignPupilToCourse.fxml'.";
		assert AssignPupilCourseLable1 != null : "fx:id=\"AssignPupilCourseLable1\" was not injected: check your FXML file 'SecretaryAssignPupilToCourse.fxml'.";
		assert CourseIDtextField != null : "fx:id=\"CourseIDtextField\" was not injected: check your FXML file 'SecretaryAssignPupilToCourse.fxml'.";
		assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'SecretaryAssignPupilToCourse.fxml'.";
		assert CourseIDlable != null : "fx:id=\"CourseIDlable\" was not injected: check your FXML file 'SecretaryAssignPupilToCourse.fxml'.";


        Main.client.controller=this;
        Main.stack.push("SecretaryAssignPupilToCourse");
        checkCourseID=0;
        checkPupilID=0;
        ExeReFLAG=0;
    }
    
	
	/**
	 * Insert pupil to course.
	 */
	void InsertPupilToCourse()
	{
		ArrayList<String> data = new ArrayList<String>();
		data.add("Assign Pupil To Course");
		data.add("insert");
		data.add("pupil_in_course");
		data.add("userID");
		data.add("courseID");
		data.add("gradeInCourse");
		data.add("values");
		data.add(PupilIDtextField.getText());
		data.add(CourseIDtextField.getText());
		data.add("0");
		
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
	 * Loading the decision of School Manager.
	 */
	void loadDecision()
	 {
		ArrayList<String> data = new ArrayList<String>();
   		data.add("Check Exeptional Request Descision");
   		data.add("select field");
   		data.add("descision");
   		data.add("exceptional_request");
   		data.add("CourseID");
   		data.add(CourseIDtextField.getText());
   		data.add("userID");
   		data.add(PupilIDtextField.getText());
   		data.add("type");
   		data.add("assign");
   		data.add("exceptonalRequestID");
   		data.add(RequestIdTextField.getText());
   		
			
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
     * Handles the answer from the server according to the type of answer.
     */  
	@Override
	public void handleAnswer(Object result) {
		// TODO Auto-generated method stub
		
		if (result == null)
		{
			// error
			new Alert(AlertType.ERROR, "Item has not found.", ButtonType.OK).showAndWait();
			return;
		}

		ArrayList<String> arr = (ArrayList<String>) result;
		String type = arr.remove(0);
			
		if(type.equals("Check RequestID"))
		{
			if(arr.size()==0)
			{
				new Alert(AlertType.ERROR, "Exceptional Request has not found.", ButtonType.OK).showAndWait();
			}
			else
			{
				ExeReFLAG=1;
				new Alert(AlertType.INFORMATION, "Exceptional Request has found.", ButtonType.OK).showAndWait();
			}
		}
		if (type.equals("Check Pupil"))
		{
			if(arr.size() == 0)
			{
				new Alert(AlertType.ERROR, "Pupil has not found.", ButtonType.OK).showAndWait();
			}
			else
			{
				 
			    checkPupilID=1;
				new Alert(AlertType.INFORMATION, "Pupil has found.", ButtonType.OK).showAndWait();
			}
		}
		
		if(type.equals( "Check Course"))
		{
			if(arr.size()==0)
			{
				new Alert(AlertType.ERROR, "Course has not found.", ButtonType.OK).showAndWait();
			}
				
			else 
			{
				checkCourseID=1;
				new Alert(AlertType.INFORMATION, "Course has found.", ButtonType.OK).showAndWait();
			}		
		}
		
		if(type.equals("Check Exeptional Request Descision"))
			
		{
		String des="";
		if(arr.isEmpty()==true)
		{
			new Alert(AlertType.ERROR, "Exceptional Request for assigning pupil to course by details you entered not exist.", ButtonType.OK).showAndWait();	
		}
		else
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
			   des=map.get("descision");
			}
			if(des.equals("deny"))
			{
				
				new Alert(AlertType.ERROR, "The requst to assign pupil to this course not confirmed", ButtonType.OK).showAndWait();
			}
			else if(des.equals("confirm"))
			{
				InsertPupilToCourse();
			}
			else if(des.equals("panding"))
			{
				new Alert(AlertType.ERROR, "No Response To This Request Yet", ButtonType.OK).showAndWait();
			}
		}
		}
		
		if(type.equals("Assign Pupil To Course"))
		{
			if(arr.size()==0)
				
			{
				new Alert(AlertType.ERROR, "Assigning failed", ButtonType.OK).showAndWait();
			}
			else
			{
				new Alert(AlertType.INFORMATION, "Pupil Succesfully Assigned To Course", ButtonType.OK).showAndWait();
				UserWindow.closeUserWindow(getClass(), (Stage) AssignPupilCourseLable1.getScene().getWindow());	
			}
		}
	}
}
	


