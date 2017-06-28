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
    	 TableView<Course> table = new TableView<Course>();
    	 ObservableList<Course> data;
    	 data = getInitialTableData();
    	 table.setItems(data);

    	    data = FXCollections.observableArrayList(
    	            new Course("Jacob", "Smith", "100"),
    	            new Course("Isabella", "Johnson", "80"),
    	            new Course("Ethan", "Williams", "70"),
    	            new Course("Emma", "Jones", "55"),
    	            new Course("Michael", "Brown", "90")
    	        );
    	
    	Stage stage = new Stage();
        Scene scene = new Scene(new Group());
        stage.setTitle("Table View Sample");
        stage.setWidth(450);
        stage.setHeight(500);
 
        final Label label = new Label("Address Book");
        label.setFont(new Font("Arial", 20));
 
        table.setEditable(true);
 
        TableColumn CourseIdCol = new TableColumn("Course ID");
        CourseIdCol.setMinWidth(100);
        CourseIdCol.setCellValueFactory(
                new PropertyValueFactory<Course, String>("CourseId"));
 
        TableColumn CourseNameCol = new TableColumn("Course Name");
        CourseNameCol.setMinWidth(100);
        CourseNameCol.setCellValueFactory(
                new PropertyValueFactory<Course, String>("CourseName"));
 
        TableColumn gradeCol = new TableColumn("Grade");
        gradeCol.setMinWidth(100);
        gradeCol.setCellValueFactory(
                new PropertyValueFactory<Course, String>("email"));
 
        table.setItems(data);
        table.getColumns().addAll(CourseIdCol, CourseNameCol, gradeCol);
 
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);
 
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
 
        stage.setScene(scene);
        stage.show();
    }
 
    
    private ObservableList<Course> getInitialTableData() {
		// TODO Auto-generated method stub
		return null;
	}


	public static class Course {
    	 
        private final SimpleStringProperty CourseId;
        private final SimpleStringProperty CourseName;
        private final SimpleStringProperty email;
 
        private Course(String fName, String lName, String email) {
            this.CourseId = new SimpleStringProperty(fName);
            this.CourseName = new SimpleStringProperty(lName);
            this.email = new SimpleStringProperty(email);
        }
 
        public String getCourseId() {
            return CourseId.get();
        }
 
        public void setCourseId(String fName) {
            CourseId.set(fName);
        }
 
        public String getCourseName() {
            return CourseName.get();
        }
 
        public void setCourseName(String fName) {
            CourseName.set(fName);
        }
 
        public String getEmail() {
            return email.get();
        }
 
        public void setEmail(String fName) {
            email.set(fName);
        }
    }
}