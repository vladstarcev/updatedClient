package controllers;

import java.io.IOException;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import application.Main;
import interfaces.IController;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.control.Alert.AlertType;
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
    
	private String courseId;
    private String grade;
    private String comments;
    private String gradeSheet="";
    
    
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
    
    void loadGradeSheets()
    {
    	ArrayList<String> data = new ArrayList<String>();
    	data.add("load grade sheet");
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
    	PupilShowEvaluationFormController = new PupilShowEvaluationFormController();
    	courseId = CourseComboBox.getSelectionModel().getSelectedItem();
    	if(courseId==null){
    		new Alert(AlertType.ERROR, "Missing Course!", ButtonType.OK).showAndWait();
    		return;
    	}
    	String[] ans = courseId.split(":");
    	PupilShowEvaluationFormController.loadEvaluationForm(ans[0]);
		UserWindow.createUserWindow((Stage) ChooseMenuButton.getScene().getWindow(), "PupilEvaluationForm", getClass());
     }

    @FXML
    void ShowGradeSheet(ActionEvent event) {
    	setGradeSheet();
    }
    
    void setGradeSheet()
    {
    	TableView table = new TableView();
    	ObservableList<Course> courses;
        
        Course course1 = new Course("1111", "ffff", "70");
        courses = FXCollections.observableArrayList(course1);

    	Stage stage = new Stage();
    	Scene scene = new Scene(new Group());
        stage.setTitle("Grade Sheet");
        stage.setWidth(340);
        stage.setHeight(500);
        
       	final Label label = new Label("Grade Sheet");
        label.setFont(new Font("Arial", 20));
        table.setEditable(true);
        
        TableColumn courseIdCol = new TableColumn("Course ID");
        courseIdCol.setMinWidth(100);
        courseIdCol.setCellValueFactory(
                new PropertyValueFactory<>("courseId"));
        
        TableColumn courseNameCol = new TableColumn("Course Name");
        courseNameCol.setMinWidth(100);
        courseNameCol.setCellValueFactory(
                new PropertyValueFactory<>("courseName"));
        
        
        TableColumn gradeCol = new TableColumn("Grade");
        gradeCol.setMinWidth(100);
        gradeCol.setCellValueFactory(
                new PropertyValueFactory<>("courseGrade"));
 
        
        table.setItems(courses);
        table.getColumns().addAll(courseIdCol, courseNameCol, gradeCol);
        final VBox vbox = new VBox();
        vbox.setSpacing(7);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);
 
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
 
        stage.setScene(scene);
        stage.show();
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
	 	else if (type.equals("load grade sheet"))
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
		 		String grade = map.get("gradeInCourse");
		 		String courseId = map.get("courseID");
		 		gradeSheet += courseId + "\t" + allCourses.get(courseId).get("courseName") + "\t" ;
		 		if(!(grade.equals("0")))	gradeSheet+= grade;
		 		gradeSheet+="\n";
	 		}
		 		
	 	}

	}
	public static class Course {
		 
        private SimpleStringProperty courseId;
        private SimpleStringProperty courseName;
        private SimpleStringProperty courseGrade;
 
        private Course (String Id, String name, String g) {
            this.courseId = new SimpleStringProperty(Id);
            this.courseName = new SimpleStringProperty(name);
            this.courseGrade = new SimpleStringProperty(g);
        }
 
        public String getId() {
            return courseId.get();
        }
        
        public void setId(String id) {
            courseId.set(id);
        }
        
        public String getName() {
            return courseName.get();
        }
        
        public void setName(String name) {
        	courseName.set(name);
        }
 
        public String getGrade() {
            return courseGrade.get();
        }
 
        public void setGrade(String g) {
            courseGrade.set(g);
        }
    }
}