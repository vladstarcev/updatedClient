package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ui.UserWindow;

public class CreateEvaluationFormController implements IController  {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> chooseCourseCB;

    @FXML
    private Label EvaluationFormWindowLabel;

    @FXML
    private Label GradeLabel;

    @FXML
    private Label CommentsLabel;

    @FXML
    private Label PupilLabel;

    @FXML
    private TextArea CommentsTextArea;

    @FXML
    private ComboBox<String> choosePupilCB;

    @FXML
    private Button BackButton;

    @FXML
    private Label CourseLabel;

    @FXML
    private Button CreateEvaluationFormButton;

    @FXML
    private TextField PupilGradeTextLabel;


	private HashMap<String, HashMap<String, String>> allCourses;
	private HashMap<String, HashMap<String, String>> allPupils;
	private HashMap<String, HashMap<String, String>> coursesOfTeacher;
	private ArrayList<String> pupilInClass;
	private HashMap<String,String> courseClass;

	private String courseId;
	private String classId;
	private String pupilId;

    @FXML
    void EnterPupilGrade(ActionEvent event) {

    }

    @FXML
    void CreateEvaluationForm(ActionEvent event) {
        String selectedCourse= chooseCourseCB.getSelectionModel().getSelectedItem();
        if (selectedCourse == null){
    		new Alert(AlertType.ERROR, "Missing Course!", ButtonType.OK).showAndWait();
        	return;
        }

       	String selectedPupil= choosePupilCB.getSelectionModel().getSelectedItem();
       	if (selectedPupil == null){
       		new Alert(AlertType.ERROR, "Missing Pupil!", ButtonType.OK).showAndWait();
       		return;
        }
        	
	   	String comments = CommentsTextArea.getText();
	   	String grade = PupilGradeTextLabel.getText();
	   	if (grade.equals("")){
	   		new Alert(AlertType.ERROR, "Missing grade!", ButtonType.OK).showAndWait();
	   		return;
	   	}
	   	for(int i=0;i<grade.length();i++)
	   	{
	   		if(!(grade.charAt(i)<='9'&&grade.charAt(i)>='0')){
	    		new Alert(AlertType.ERROR, "Error grade!", ButtonType.OK).showAndWait();
	   			return;
	   		}
	   	}
	   	int g = Integer.valueOf(grade);
    	if(g>100||g<0){
    		new Alert(AlertType.ERROR, "Error grade!", ButtonType.OK).showAndWait();
	   		return;
    	}
    	ArrayList<String> data = new ArrayList<String>();
    	data.add("create evaluation form");
    	data.add("insert");
    	data.add("evaluation_form");
		data.add("fileNumber");
		data.add("generalComments");
		data.add("finalGrade");
		data.add("courseID");
		data.add("pupilID");

		
		data.add("values");
		String fileNum = pupilId + courseId;
		data.add(fileNum);
		data.add(comments);
		data.add(grade);
		data.add(courseId);
		data.add(pupilId);

		try 
		{
			Main.client.sendToServer(data);
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Alert(AlertType.INFORMATION, "Evaluation Form was created successfully!", ButtonType.OK).showAndWait();

    }

    @FXML
    void BackToMenu(ActionEvent event) {
    	UserWindow.closeUserWindow(getClass(), (Stage)BackButton.getScene().getWindow());
    }

    @FXML
    void chooseCourse(ActionEvent event) {
    	String arr = chooseCourseCB.getSelectionModel().getSelectedItem();
    	String[] ans = arr.split(":");
    	courseId=ans[0];
    	classId = coursesOfTeacher.get(courseId).get("classId");
    	while(pupilInClass.size()>0) pupilInClass.remove(0);
        loadPupilInClass(classId);
    }

    @FXML
    void choosePupil(ActionEvent event) {
    	
    }
    void loadAllCourses()
    {
    	ArrayList<String> data = new ArrayList<String>();
    	data.add("load Courses");
    	data.add("select");
    	data.add("courses");
    	try
	  	{
    		Main.client.sendToServer(data);
	  	}
    	catch (IOException e)
    	{
    		e.printStackTrace();
    	}
    }
	    
    void loadCoursesOfTeacher()
    {
    	  ArrayList<String> data = new ArrayList<String>();
    	  data.add("load courses of teacher");
    	  data.add("select");
    	  data.add("course_in_class");
    	  data.add("teacherId");
    	  data.add(Main.userId);
    	  try
    	  {
    	   Main.client.sendToServer(data);
    	  }
    	  catch (IOException e)
    	  {
    	   e.printStackTrace();
    	  }
    }
    
    void loadAllPupils()
    {
		ArrayList<String> data = new ArrayList<String>();
		data.add("load all pupils");
		data.add("select");
		data.add("user");
		data.add("permission");
		data.add("6");

		try
		{
			Main.client.sendToServer(data);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
    }
    
    void loadPupilInClass(String classId)
    {
    	ArrayList<String> data = new ArrayList<String>();
    	data.add("load pupils in class");
   	  	data.add("select field");
   	  	data.add("pupil_ID");
   	  	data.add("pupil_in_class");
   	  	data.add("class_ID");
   	  	data.add(classId);
   	  	try
   		 {
   	  		Main.client.sendToServer(data);
   		 }
   	  	catch (IOException e)
   	  	{
   	  		e.printStackTrace();
   	  	}
    }
    
    void loadPupilsInCourse(String courseId)
    {
    	ArrayList<String> data = new ArrayList<String>();
    	data.add("load pupils in course");
   	  	data.add("select field");
   	  	data.add("userID");
   	  	data.add("pupil_in_course");
   	  	data.add("courseID");
   	  	data.add(courseId);
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
        assert chooseCourseCB != null : "fx:id=\"chooseCourseCB\" was not injected: check your FXML file 'TeacherCreateEvaluationForm.fxml'.";
        assert EvaluationFormWindowLabel != null : "fx:id=\"EvaluationFormWindowLabel\" was not injected: check your FXML file 'TeacherCreateEvaluationForm.fxml'.";
        assert GradeLabel != null : "fx:id=\"GradeLabel\" was not injected: check your FXML file 'TeacherCreateEvaluationForm.fxml'.";
        assert CommentsLabel != null : "fx:id=\"CommentsLabel\" was not injected: check your FXML file 'TeacherCreateEvaluationForm.fxml'.";
        assert PupilLabel != null : "fx:id=\"PupilLabel\" was not injected: check your FXML file 'TeacherCreateEvaluationForm.fxml'.";
        assert CommentsTextArea != null : "fx:id=\"CommentsTextArea\" was not injected: check your FXML file 'TeacherCreateEvaluationForm.fxml'.";
        assert choosePupilCB != null : "fx:id=\"choosePupilCB\" was not injected: check your FXML file 'TeacherCreateEvaluationForm.fxml'.";
        assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'TeacherCreateEvaluationForm.fxml'.";
        assert CourseLabel != null : "fx:id=\"CourseLabel\" was not injected: check your FXML file 'TeacherCreateEvaluationForm.fxml'.";
        assert CreateEvaluationFormButton != null : "fx:id=\"CreateEvaluationFormButton\" was not injected: check your FXML file 'TeacherCreateEvaluationForm.fxml'.";
        assert PupilGradeTextLabel != null : "fx:id=\"PupilGradeTextLabel\" was not injected: check your FXML file 'TeacherCreateEvaluationForm.fxml'.";

        Main.client.controller=this;
        allCourses = new HashMap<>();
        allPupils = new HashMap<>();
        coursesOfTeacher = new HashMap<>();
        pupilInClass = new ArrayList<>();
        loadAllCourses();
        loadAllPupils();
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
		if (type.equals("load Courses"))
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
			   allCourses.put(map.get("courseId"), map);
		   	}
		 	loadCoursesOfTeacher();
		}

		else if (type.equals("load courses of teacher"))
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
				coursesOfTeacher.put(map.get("courseId"), map);
			    courseId = map.get("courseId");
			    chooseCourseCB.getItems().add(courseId + ": " + allCourses.get(courseId).get("courseName"));
			}
		}
		else if(type.equals("load all pupils"))
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
				allPupils.put(map.get("userId"), map);
			}
		}
		else if(type.equals("load pupils in class"))
		{
			for (String row : arr)
			{
				String[] cols = row.split(";");
				HashMap<String, String> map = new HashMap<>();
				for (String col : cols)
				{
					String[] field = col.split("=");
					map.put(field[0], field[1]);
					pupilInClass.add(field[1]);
				}
			}
	        loadPupilsInCourse(courseId);


		}
		else if (type.equals("load pupils in course"))
		{
			while(choosePupilCB.getItems().size()>0)
			{
				choosePupilCB.getItems().remove(0);
			}

			for (String row : arr)
			{
				String[] cols = row.split(";");
				HashMap<String, String> map = new HashMap<>();
				for (String col : cols)
				{
					String[] field = col.split("=");
					map.put(field[0], field[1]);
				}
				
				pupilId = map.get("userID");
				for(String pupil : pupilInClass){
					if(pupilId.equals(pupil))choosePupilCB.getItems().add(pupilId + ": " + allPupils.get(pupilId).get("userFirstName") + " "
							+ allPupils.get(pupilId).get("userLastName"));
				}
			}
		}

	}
}
