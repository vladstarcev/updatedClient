package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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

public class AddCourseController implements IController{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label OpenLabel;

    @FXML
    private TextField idTxt;

    @FXML
    private Button cancelBtn;

    @FXML
    private TextField nameTxt;

    @FXML
    private TextField unitTxt;

    @FXML
    private Button checkHoursBTN;

    @FXML
    private Label courseNameLbl;

    @FXML
    private Label idLbl;

    @FXML
    private Button addBtn;

    @FXML
    private Button checkCourseNameBTN;

    @FXML
    private TextField hoursTxt;

    @FXML
    private Label sUnitLbl;

    @FXML
    private Label hoursLbl;

    @FXML
    private Button checkCourseIDBTN;

    @FXML
    private Button CheckStudyUnitBTN;
    
    private int CourseIDf;
    private int CourseNamef;
    private int StuduUnit;
    private int WeeklyHours;

    @FXML
    void addCourse(ActionEvent event) {

    	if(CourseIDf==0)
    	{
    		new Alert(AlertType.ERROR, "Enter Currect Course ID and Check It.", ButtonType.OK).showAndWait();
    		
    	}
    	else if(CourseNamef==0)
    	{
    		new Alert(AlertType.ERROR, "Enter Currect Course Name and Check It.", ButtonType.OK).showAndWait();
    	}
    	else if(StuduUnit==0)
      	{
    		new Alert(AlertType.ERROR, "Enter Currect Study Unit and Check It.", ButtonType.OK).showAndWait();
    	}
    	else if(WeeklyHours==0)
      	{
    		new Alert(AlertType.ERROR, "Enter Currect Weekly Study Hours and Check It.", ButtonType.OK).showAndWait();
    	}
    	else
    	{
    		ArrayList<String> data = new ArrayList<>();
        	data.add("add course");
        	data.add("insert");
        	data.add("courses");
        	data.add("courseId");
        	data.add("courseName");
        	data.add("weeklyStudyHours");
        	data.add("studyUnit");
        	
        	data.add("values");
        	data.add(idTxt.getText());
        	data.add(nameTxt.getText());
        	data.add(hoursTxt.getText());
        	data.add(unitTxt.getText());
        	
        	try {
    			Main.client.sendToServer(data);
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        	

    	}
    	
    }

    @FXML
    void backToMenu(ActionEvent event) { ///problem? 

    	UserWindow.closeUserWindow(getClass(), (Stage) checkCourseNameBTN.getScene().getWindow());
    }

    @FXML
    void CheckStudyUnit(ActionEvent event) {

    	if(unitTxt.getText().length()!=2)
    	{
    		new Alert(AlertType.ERROR, "Styudy Unit must Contain 2 digits", ButtonType.OK).showAndWait();
    	}
    	else
    	{
     		ArrayList<String> data = new ArrayList<String>();
    		data.add("check if ST exist");
    		data.add("select");
    		data.add("study_unit");
    		data.add("studyUnitID");
    		data.add(unitTxt.getText());

    		try
    		{
    			Main.client.sendToServer(data);
    		}
    		catch (IOException e)
    		{
    			e.printStackTrace();
    		}
    	}
    }

    @FXML
    void checkHours(ActionEvent event) {
    	
    	int flag=0,num=0, i=0;
    	String hours=hoursTxt.getText();
    	if(hours.isEmpty())
    	{
    		new Alert(AlertType.ERROR, "Please Enter Course ID", ButtonType.OK).showAndWait();
    	}
    	else
    	{
    		for(i=0;i<hours.length();i++)
    		{
    			for(int j=0;j<9;j++)
    			{
    				String JS=Integer.toString(j);
    				if(hours.substring(i, i+1).equals(JS))
    				{
    					flag=1;
    					break;
    				}		
    			}
    			if(flag==0)
    			{
    				new Alert(AlertType.ERROR, "Ilegal Study Hours", ButtonType.OK).showAndWait();
    				break;
    			}
    			else
    			{
    				flag=0;
    			}
    		}
    	}
    	
    	if(i==hours.length())
    	{
    		num=Integer.parseInt(hours);
    		if(num<=0)
    		{
    			new Alert(AlertType.ERROR, "Wrong Weekly Study Hours", ButtonType.OK).showAndWait();
    		}
    		else
    		{
    			WeeklyHours=1;
    			new Alert(AlertType.INFORMATION, "Weekly Study Is OK", ButtonType.OK).showAndWait();
    		}
    	}
    }

    @FXML
    void checkCourseName(ActionEvent event) {

 		ArrayList<String> data = new ArrayList<String>();
		data.add("check if name availeble");
		data.add("select");
		data.add("courses");
		data.add("courseName");
		data.add(nameTxt.getText());

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
    void checkCourseID(ActionEvent event) {

    	if(idTxt.getText().length()!=5)
    	{
    		new Alert(AlertType.ERROR, "Course ID must Contain 5 digits", ButtonType.OK).showAndWait();
    	}
    	else
    	{
    		ArrayList<String> data = new ArrayList<String>();
    		data.add("check if course exist");
    		data.add("select");
    		data.add("courses");
    		data.add("courseId");
    		data.add(idTxt.getText());

    		try
    		{
    			Main.client.sendToServer(data);
    		}
    		catch (IOException e)
    		{
    			e.printStackTrace();
    		}
    	}
    }

    @FXML
    void initialize() {
        assert OpenLabel != null : "fx:id=\"OpenLabel\" was not injected: check your FXML file 'SystemManagerAddCourse.fxml'.";
        assert idTxt != null : "fx:id=\"idTxt\" was not injected: check your FXML file 'SystemManagerAddCourse.fxml'.";
        assert cancelBtn != null : "fx:id=\"cancelBtn\" was not injected: check your FXML file 'SystemManagerAddCourse.fxml'.";
        assert nameTxt != null : "fx:id=\"nameTxt\" was not injected: check your FXML file 'SystemManagerAddCourse.fxml'.";
        assert unitTxt != null : "fx:id=\"unitTxt\" was not injected: check your FXML file 'SystemManagerAddCourse.fxml'.";
        assert checkHoursBTN != null : "fx:id=\"checkHoursBTN\" was not injected: check your FXML file 'SystemManagerAddCourse.fxml'.";
        assert courseNameLbl != null : "fx:id=\"courseNameLbl\" was not injected: check your FXML file 'SystemManagerAddCourse.fxml'.";
        assert idLbl != null : "fx:id=\"idLbl\" was not injected: check your FXML file 'SystemManagerAddCourse.fxml'.";
        assert addBtn != null : "fx:id=\"addBtn\" was not injected: check your FXML file 'SystemManagerAddCourse.fxml'.";
        assert checkCourseNameBTN != null : "fx:id=\"checkCourseNameBTN\" was not injected: check your FXML file 'SystemManagerAddCourse.fxml'.";
        assert hoursTxt != null : "fx:id=\"hoursTxt\" was not injected: check your FXML file 'SystemManagerAddCourse.fxml'.";
        assert sUnitLbl != null : "fx:id=\"sUnitLbl\" was not injected: check your FXML file 'SystemManagerAddCourse.fxml'.";
        assert hoursLbl != null : "fx:id=\"hoursLbl\" was not injected: check your FXML file 'SystemManagerAddCourse.fxml'.";
        assert checkCourseIDBTN != null : "fx:id=\"checkCourseIDBTN\" was not injected: check your FXML file 'SystemManagerAddCourse.fxml'.";
        assert CheckStudyUnitBTN != null : "fx:id=\"CheckStudyUnitBTN\" was not injected: check your FXML file 'SystemManagerAddCourse.fxml'.";

        Main.client.controller=this;
        
        CourseIDf=0;
        CourseNamef=0;
        StuduUnit=0;
        WeeklyHours=0;
    }

	@Override
	public void handleAnswer(Object result) {
		// TODO Auto-generated method stub
		
	 	if (result == null)
	 	{
	 		// error
	
	 		return;
	 	}
	 	ArrayList<String> arr = (ArrayList<String>) result;
	 	String type = arr.remove(0);
	 	
	 	if(type.equals("add course"))
	 	{
	 		new Alert(AlertType.INFORMATION, "Course Add Succesfully To System", ButtonType.OK).showAndWait();
	 		UserWindow.closeUserWindow(getClass(), (Stage) checkCourseNameBTN.getScene().getWindow());
	 	}
	 	
	 	if(type.equals("check if course exist"))
	 	{
	 		if(arr.size()!=0)
	 		{
	 			new Alert(AlertType.ERROR, "Course Already Exist In System", ButtonType.OK).showAndWait();
	 		}
	 		else
	 		{
	 			CourseIDf=1;
	 			new Alert(AlertType.INFORMATION, "Course ID Available", ButtonType.OK).showAndWait();
	 		}
	 	}
	 	
	 	if(type.equals("check if name availeble"))
	 	{
			if(arr.size()!=0)
	 		{
	 			new Alert(AlertType.ERROR, "Course Name Not Available", ButtonType.OK).showAndWait();
	 		}
	 		else
	 		{
	 			CourseNamef=1;
	 			new Alert(AlertType.INFORMATION, "Course Name Available", ButtonType.OK).showAndWait();
	 		}
	 	}
	 	
	 	if(type.equals("check if ST exist"))
	 	{
			if(arr.size()!=0)
	 		{
				StuduUnit=1;
	 			new Alert(AlertType.INFORMATION, "Study Unit Exist", ButtonType.OK).showAndWait();
	 		}
	 		else
	 		{
	 			new Alert(AlertType.ERROR, "Study Unit Not Exist", ButtonType.OK).showAndWait();
	 		}
	 	}
	}
}
