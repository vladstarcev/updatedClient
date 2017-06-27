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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import ui.UserWindow;

public class PupilFileController implements IController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label PupilFileLabel;

    @FXML
    private MenuButton ChooseMenuButton;

    @FXML
    private MenuItem showEvaluationFormItem;
    
    @FXML
    private MenuItem ShowGradeSheetIten;
    
    @FXML
    private ComboBox<String> CourseComboBox;

    @FXML
    private Button BackButton;

    @FXML
    private Label ChooseCourseLabel;

    @FXML
    private Label ChooseLable;

    private PupilShowEvaluationFormController PupilShowEvaluationFormController;
	private HashMap<String, HashMap<String, String>> allCourses;
    

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
    
	 void loadCoursesOfPupil()
	 {
		ArrayList<String> data = new ArrayList<String>();
		data.add("load courses of pupil");
		data.add("select");
		data.add("pupil_in_course");
	 	data.add("userID");
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
    
    @FXML
    void ShowCourseList(ActionEvent event) {

    }

    @FXML
    void BackToMenu(ActionEvent event) {
        UserWindow.closeUserWindow(getClass(), (Stage)BackButton.getScene().getWindow());
    }

    @FXML
    void ChooseOperation(ActionEvent event) {

    }
    
    @FXML
    void ShowEvaluationForm(ActionEvent event) {

    }

    @FXML
    void ShowGradeSheet(ActionEvent event) {

    }
    
    @FXML
    void initialize() {
        assert PupilFileLabel != null : "fx:id=\"PupilFileLabel\" was not injected: check your FXML file 'PupilFile.fxml'.";
        assert ChooseMenuButton != null : "fx:id=\"ChooseMenuButton\" was not injected: check your FXML file 'PupilFile.fxml'.";
        assert CourseComboBox != null : "fx:id=\"CourseComboBox\" was not injected: check your FXML file 'PupilFile.fxml'.";
        assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'PupilFile.fxml'.";
        assert showEvaluationFormItem != null : "fx:id=\"showEvaluationFormItem\" was not injected: check your FXML file 'PupilFile.fxml'.";
        assert ChooseCourseLabel != null : "fx:id=\"ChooseCourseLabel\" was not injected: check your FXML file 'PupilFile.fxml'.";
        assert ShowGradeSheetIten != null : "fx:id=\"ShowGradeSheetIten\" was not injected: check your FXML file 'PupilFile.fxml'.";
        assert ChooseLable != null : "fx:id=\"ChooseLable\" was not injected: check your FXML file 'PupilFile.fxml'.";

        Main.client.controller=this;
        allCourses = new HashMap<>();
        loadAllCourses();
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
	 		loadCoursesOfPupil();
	 	}
	 	else if (type.equals("load courses of pupil"))
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
		 		
	 			String courseId = map.get("courseID");
	 			CourseComboBox.getItems().add(courseId + ": " + allCourses.get(courseId).get("courseName"));
	 		}		
	 	}
	}
}