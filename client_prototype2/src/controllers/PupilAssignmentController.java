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
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.stage.Stage;
import ui.UserWindow;

public class PupilAssignmentController implements IController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label UploadTextField;

    @FXML
    private ComboBox<String> chooseCourseCB;

    @FXML
    private Label AssignmentTextField;

    @FXML
    private Button UploadButton;

    @FXML
    private Button BackButton;

    @FXML
    private Hyperlink FileHyperLink;

    @FXML
    private ComboBox<String> chooseAssCB;

    @FXML
    private ProgressIndicator ProgressUpload;

    @FXML
    private Label CourseTextField;

    
 private HashMap<String, HashMap<String, String>> allCourses;
 private HashMap<String, HashMap<String, String>> allAss;

 
    @FXML
    void UploadSolutionFile(ActionEvent event) {

    }

    @FXML
    void ChooseSolutionFile(ActionEvent event) {

    }

    @FXML
    void BackToPupilMenu(ActionEvent event) {
     UserWindow.closeUserWindow(getClass(), (Stage)BackButton.getScene().getWindow());     
    }

    @FXML
    void chooseCourse(ActionEvent event) {
     String selectedCourse= chooseCourseCB.getSelectionModel().getSelectedItem();
  if (selectedCourse == null)
   return;
  String ans[] = selectedCourse.split(":");
  loadAssOfCourse(ans[0]);
    }

    @FXML
    void chooseAss(ActionEvent event) {
     String selectedAss= chooseAssCB.getSelectionModel().getSelectedItem();
  if (selectedAss == null)
   return;
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
    
 void loadAllAss()
 {
  ArrayList<String> data = new ArrayList<String>();
  data.add("load all assignments");
  data.add("select");
  data.add("assignment");

  try
  {
   Main.client.sendToServer(data);
  }
  catch (IOException e)
  {
   e.printStackTrace();
  }
   
 }
 
 void loadAssOfCourse(String courseId)
 {  
 ArrayList<String> data = new ArrayList<String>();
 data.add("load assignment of course");
 data.add("select");
 data.add("assignment_in_course");
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
        assert UploadTextField != null : "fx:id=\"UploadTextField\" was not injected: check your FXML file 'PupilAssignment.fxml'.";
        assert chooseCourseCB != null : "fx:id=\"chooseCourseCB\" was not injected: check your FXML file 'PupilAssignment.fxml'.";
        assert AssignmentTextField != null : "fx:id=\"AssignmentTextField\" was not injected: check your FXML file 'PupilAssignment.fxml'.";
        assert UploadButton != null : "fx:id=\"UploadButton\" was not injected: check your FXML file 'PupilAssignment.fxml'.";
        assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'PupilAssignment.fxml'.";
        assert FileHyperLink != null : "fx:id=\"FileHyperLink\" was not injected: check your FXML file 'PupilAssignment.fxml'.";
        assert chooseAssCB != null : "fx:id=\"chooseAssCB\" was not injected: check your FXML file 'PupilAssignment.fxml'.";
        assert ProgressUpload != null : "fx:id=\"ProgressUpload\" was not injected: check your FXML file 'PupilAssignment.fxml'.";
        assert CourseTextField != null : "fx:id=\"CourseTextField\" was not injected: check your FXML file 'PupilAssignment.fxml'.";

        Main.client.controller=this;
        allCourses = new HashMap<>();
        allAss =  new HashMap<>();
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
    chooseCourseCB.getItems().add(courseId + ": " + allCourses.get(courseId).get("courseName"));
   }
   loadAllAss();
  }
  else if (type.equals("load all assignmens"))
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
    allAss.put(map.get("assignmentName"), map);
   }
  }
  
  else if (type.equals("load assignment of course"))
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
    String AssName = map.get("assignmentName");
    chooseAssCB.getItems().add(AssName);

   }
  }

 }

}