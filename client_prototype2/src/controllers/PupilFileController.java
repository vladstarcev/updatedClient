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

/**
 * The Class PupilFileController.
 */
public class PupilFileController implements IController {

    /** The resources. */
    @FXML
    private ResourceBundle resources;

    /** The location. */
    @FXML
    private URL location;

    /** The Pupil file label. */
    @FXML
    private Label PupilFileLabel;

    /** The Choose menu button. */
    @FXML
    private MenuButton ChooseMenuButton;

    /** The show evaluation form item. */
    @FXML
    private MenuItem showEvaluationFormItem;
    
    /** The Show grade sheet iten. */
    @FXML
    private MenuItem ShowGradeSheetIten;
    
    /** The Course combo box. */
    @FXML
    private ComboBox<String> CourseComboBox;

    /** The Back button. */
    @FXML
    private Button BackButton;

    /** The Choose course label. */
    @FXML
    private Label ChooseCourseLabel;

    /** The Choose lable. */
    @FXML
    private Label ChooseLable;

    /** The Pupil show evaluation form controller. */
    private PupilShowEvaluationFormController PupilShowEvaluationFormController;
	
	/** The all courses. */
	private HashMap<String, HashMap<String, String>> allCourses;
    
	/** The course id. */
	private String courseId;
    
    /** The grade. */
    private String grade;
    
    /** The comments. */
    private String comments;
    
    /** The grade sheet. */
    private String gradeSheet="";
    
    
    /**
     * Load all courses.
     */
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
    
    /**
     * Load grade sheets.
     */
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
    
	 /**
 	 * Load courses of pupil.
 	 */
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
    
    /**
     * Show course list.
     *
     * @param event the event
     */
    @FXML
    void ShowCourseList(ActionEvent event) {

    }

    /**
     * Back to menu.
     *
     * @param event the event
     */
    @FXML
    void BackToMenu(ActionEvent event) {
        UserWindow.closeUserWindow(getClass(), (Stage)BackButton.getScene().getWindow());
    }

    /**
     * Choose operation.
     *
     * @param event the event
     */
    @FXML
    void ChooseOperation(ActionEvent event) {

    }
    
    /**
     * Show evaluation form.
     *
     * @param event the event
     */
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

    /**
     * Show grade sheet.
     *
     * @param event the event
     */
    @FXML
    void ShowGradeSheet(ActionEvent event) {
    	setGradeSheet();
    }

    
    /**
     * Initialize.
     */
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
	
    /**
     * Sets the grade sheet.
     */
    void setGradeSheet()
    {
    	Stage stage = new Stage();
    	Scene scene = new Scene(new Group());
        stage.setTitle("Grade Sheet");
        stage.setWidth(340);
        stage.setHeight(500);
        
    	TableView<Course> table = new TableView<Course>();
    	ObservableList<Course> courses = null;
    	
       	final Label label = new Label("Grade Sheet");
        label.setFont(new Font("Arial", 20));
        table.setEditable(true);
        
        TableColumn<Course,String> courseIdCol = new TableColumn("Course ID");
        courseIdCol.setMinWidth(100);
        courseIdCol.setCellValueFactory(new PropertyValueFactory<>("courseId"));
        
        TableColumn<Course,String> courseNameCol = new TableColumn("Course Name");
        courseNameCol.setMinWidth(100);
        courseNameCol.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        
        
        TableColumn<Course,String> gradeCol = new TableColumn("Grade");
        gradeCol.setMinWidth(100);
        gradeCol.setCellValueFactory(new PropertyValueFactory<>("courseGrade"));
        
        if(courses==null){
        	courses = FXCollections.observableArrayList(new Course("Dekel","556","80")); //add new course
        	courseIdCol.setCellValueFactory(new PropertyValueFactory<Course,String>("Course ID"));
        	courseNameCol.setCellValueFactory(new PropertyValueFactory<Course,String>("Course Name"));
        	gradeCol.setCellValueFactory(new PropertyValueFactory<Course,String>("Grade"));
	    	
            table.setItems(courses);        	
        }
        
        table.getColumns().addAll(courseIdCol, courseNameCol, gradeCol);
        final VBox vbox = new VBox();
        vbox.setSpacing(7);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);
 
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
 
        stage.setScene(scene);
        stage.show();
    }
    
    
	/**
	 * The Class Course.
	 */
	public static class Course {
		 
        /** The course id. */
        private String courseId;
        
        /** The course name. */
        private String courseName;
        
        /** The course grade. */
        private String courseGrade;
 
        /**
         * Instantiates a new course.
         *
         * @param courseId the course id
         * @param name the name
         * @param grade the grade
         */
        public Course (String courseId, String name, String grade) {
            this.courseId = courseId;
            this.courseName = name;
            this.courseGrade = grade;
        }
 
        /**
         * Gets the id.
         *
         * @return the id
         */
        public String getId() {
            return courseId;
        }
        
        /**
         * Sets the id.
         *
         * @param id the new id
         */
        public void setId(String id) {
            courseId = id;
        }
        
        /**
         * Gets the name.
         *
         * @return the name
         */
        public String getName() {
            return courseName;
        }
        
        /**
         * Sets the name.
         *
         * @param name the new name
         */
        public void setName(String name) {
        	courseName = name;
        }
 
        /**
         * Gets the grade.
         *
         * @return the grade
         */
        public String getGrade() {
            return courseGrade;
        }
 
        /**
         * Sets the grade.
         *
         * @param g the new grade
         */
        public void setGrade(String g) {
            courseGrade = g;
        }
    }
}