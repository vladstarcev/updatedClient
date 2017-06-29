package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import interfaces.IController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import ui.UserWindow;

/**
 * The Class TeacherMainWindowController.
 */
public class TeacherMainWindowController implements IController {

    /** The resources. */
    @FXML
    private ResourceBundle resources;

    /** The location. */
    @FXML
    private URL location;

    /** The Define assignment. */
    @FXML
    private MenuItem DefineAssignment;

    /** The Teacher menu button. */
    @FXML
    private MenuButton TeacherMenuButton;

    /** The Evaluation form. */
    @FXML
    private MenuItem EvaluationForm;

    /** The Teacher choose lable. */
    @FXML
    private Label TeacherChooseLable;

    /** The Log out button. */
    @FXML
    private Button LogOutButton;

    /** The Teacher main lable. */
    @FXML
    private Label TeacherMainLable;

    /**
     * Teacher choose operation.
     *
     * @param event the event
     */
    @FXML
    void TeacherChooseOperation(ActionEvent event) {
    	
    }

    /**
     * Define assignment window.
     *
     * @param event the event
     */
    @FXML
    void DefineAssignmentWindow(ActionEvent event) {
    	UserWindow.createUserWindow((Stage) TeacherMenuButton.getScene().getWindow(), "TeacherDefineAssignment", getClass());
    	Main.stack.push("TeacherMainWindow");
    }

    /**
     * Define.
     *
     * @param event the event
     */
    @FXML
    void Define(ActionEvent event) {
    	
    }

    /**
     * Evaluation form window.
     *
     * @param event the event
     */
    @FXML
    void EvaluationFormWindow(ActionEvent event) {
    	UserWindow.createUserWindow((Stage) TeacherMenuButton.getScene().getWindow(), "TeacherCreateEvaluationForm", getClass());
    	Main.stack.push("TeacherMainWindow");
    }

    /**
     * Grade and comments.
     *
     * @param event the event
     */
    @FXML
    void GradeAndComments(ActionEvent event) {

    	
    }

    /**
     * Log out teacher.
     *
     * @param event the event
     */
    @FXML
    void LogOutTeacher(ActionEvent event) {

    	UserWindow.closeUserWindow(getClass(), (Stage) TeacherMenuButton.getScene().getWindow());
    }

    /**
     * Initialize.
     */
    @FXML
    void initialize() {
        assert DefineAssignment != null : "fx:id=\"DefineAssignment\" was not injected: check your FXML file 'TeacherMainWindow.fxml'.";
        assert TeacherMenuButton != null : "fx:id=\"TeacherMenuButton\" was not injected: check your FXML file 'TeacherMainWindow.fxml'.";
        assert EvaluationForm != null : "fx:id=\"EvaluationForm\" was not injected: check your FXML file 'TeacherMainWindow.fxml'.";
        assert TeacherChooseLable != null : "fx:id=\"TeacherChooseLable\" was not injected: check your FXML file 'TeacherMainWindow.fxml'.";
        assert LogOutButton != null : "fx:id=\"LogOutButton\" was not injected: check your FXML file 'TeacherMainWindow.fxml'.";
        assert TeacherMainLable != null : "fx:id=\"TeacherMainLable\" was not injected: check your FXML file 'TeacherMainWindow.fxml'.";

        Main.client.controller=this;
        
        Main.stack.push("TeacherMainWindow");
    }


	@Override
	public void handleAnswer(Object msg) {
		// TODO Auto-generated method stub
		
	}
}
