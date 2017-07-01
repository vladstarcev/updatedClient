package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import interfaces.IController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import ui.UserWindow;


/**
 * The Class SystemManagerMainWindowController -this class display the main window of System Manager.
 */
public class SystemManagerMainWindowController implements IController {

    /** The resources. */
    @FXML
    private ResourceBundle resources;

    /** The location. */
    @FXML
    private URL location;

    /** The add course button. */
    @FXML
    private Button addCourseBtn;

    /** The delete course button. */
    @FXML
    private Button deleteCourseBtn;

    /** The Log out button. */
    @FXML
    private Button LogOutButton;

    /**
     * Adds the course.
     *
     * @param event - Adds the course
     */
    @FXML
    void addCourse(ActionEvent event) {
    	Main.stack.push("SystemManagerAddCourse");
    	UserWindow.createUserWindow((Stage)addCourseBtn.getScene().getWindow(), "SystemManagerAddCourse", getClass());	
    }

    /**
     * Delete course.
     *
     * @param event - Delete course
     */
    @FXML
    void deleteCourse(ActionEvent event) {
    	Main.stack.push("SystemManagerDeleteCourse");
    	UserWindow.createUserWindow((Stage)deleteCourseBtn.getScene().getWindow(), "SystemManagerDeleteCourse", getClass());  	
    }

    /**
     * Log out system manager.
     *
     * @param event - Log out system manager
     */
    @FXML
    void LogOutSystemManager(ActionEvent event) {    	
    	UserWindow.closeUserWindow(getClass(), (Stage) LogOutButton.getScene().getWindow());
    }

    /**
     * Initialize.
     */
    @FXML
    void initialize() {
        assert addCourseBtn != null : "fx:id=\"addCourseBtn\" was not injected: check your FXML file 'SystemManagerMainWindow.fxml'.";
        assert deleteCourseBtn != null : "fx:id=\"deleteCourseBtn\" was not injected: check your FXML file 'SystemManagerMainWindow.fxml'.";
        assert LogOutButton != null : "fx:id=\"LogOutButton\" was not injected: check your FXML file 'SystemManagerMainWindow.fxml'.";

        Main.client.controller=this;
        Main.stack.push("SystemManagerMainWindow");       
    }

    /**
     * Handles the answer from the server according to the type of answer.
     */   
	@Override
	public void handleAnswer(Object msg) {
		// TODO Auto-generated method stub	
	}
}
