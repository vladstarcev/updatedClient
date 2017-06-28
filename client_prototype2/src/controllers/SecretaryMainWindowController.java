package controllers;

import java.net.URL;
import java.util.ResourceBundle;

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
 * The Class SecretaryMainWindowController.
 */
public class SecretaryMainWindowController implements IController{

    /** The resources. */
    @FXML
    private ResourceBundle resources;

    /** The location. */
    @FXML
    private URL location;

    /** The Choose menu button. */
    @FXML
    private MenuButton ChooseMenuButton;

    /** The Assign pupil. */
    @FXML
    private MenuItem AssignPupil;

    /** The Open course. */
    @FXML
    private MenuItem OpenCourse;

    /** The Assign pupil to class. */
    @FXML
    private MenuItem AssignPupilToClass;

    /** The Secretary menu lable. */
    @FXML
    private Label SecretaryMenuLable;

    /** The Open exeptional requst menu. */
    @FXML
    private MenuItem OpenExeptionalRequstMenu;

    /** The Choose operational menu. */
    @FXML
    private Label ChooseOperationalMenu;

    /** The Log out button. */
    @FXML
    private Button LogOutButton;

    /** The Re assign. */
    @FXML
    private MenuItem ReAssign;

    /** The Delete pupil. */
    @FXML
    private MenuItem DeletePupil;

    /** The Open semester. */
    @FXML
    private MenuItem OpenSemester;

    /** The Define class. */
    @FXML
    private MenuItem DefineClass;

    /**
     * Choose operation.
     *
     * @param event the event
     */
    @FXML
    void ChooseOperation(ActionEvent event) {

    }

    /**
     * Open exeptional requst window.
     *
     * @param event the event
     */
    @FXML
    void OpenExeptionalRequstWindow(ActionEvent event) {

    	UserWindow.createUserWindow((Stage) ChooseOperationalMenu.getScene().getWindow(),
				"SecretaryOpenExeptionalRequest", getClass());

    }

    /**
     * Assign pupil to class window.
     *
     * @param event the event
     */
    @FXML
    void AssignPupilToClassWindow(ActionEvent event) {

    	UserWindow.createUserWindow((Stage) ChooseOperationalMenu.getScene().getWindow(), "SecretaryAssignPupilToClass",
				getClass());

    }

    /**
     * Open course window.
     *
     * @param event the event
     */
    @FXML
    void OpenCourseWindow(ActionEvent event) {
    	
    		UserWindow.createUserWindow((Stage) ChooseOperationalMenu.getScene().getWindow(), "SecretaryOpenCourse",
				getClass());
    }

    /**
     * Open semester window.
     *
     * @param event the event
     */
    @FXML
    void OpenSemesterWindow(ActionEvent event) {

    	UserWindow.createUserWindow((Stage) ChooseOperationalMenu.getScene().getWindow(), "SecretaryOpenSemester",
				getClass());

    }

    /**
     * Define class window.
     *
     * @param event the event
     */
    @FXML
    void DefineClassWindow(ActionEvent event) {

    	UserWindow.createUserWindow((Stage) ChooseOperationalMenu.getScene().getWindow(), "SecretaryDefineClass",
				getClass());

    }

    /**
     * Assign pupil to course.
     *
     * @param event the event
     */
    @FXML
    void AssignPupilToCourse(ActionEvent event) {

		UserWindow.createUserWindow((Stage) ChooseOperationalMenu.getScene().getWindow(),
				"SecretaryAssignPupilToCourse", getClass());

    }

    /**
     * Delete pupil from course.
     *
     * @param event the event
     */
    @FXML
    void DeletePupilFromCourse(ActionEvent event) {

    	UserWindow.createUserWindow((Stage) ChooseOperationalMenu.getScene().getWindow(),
				"SecretaryDeletePupilFromCourse", getClass());

    }

    /**
     * Re assign teacher.
     *
     * @param event the event
     */
    @FXML
    void ReAssignTeacher(ActionEvent event) {

    	UserWindow.createUserWindow((Stage) ChooseOperationalMenu.getScene().getWindow(), "SecretaryReAssignTeacher",
				getClass());

    }

    /**
     * Secretary log out.
     *
     * @param event the event
     */
    @FXML
    void SecretaryLogOut(ActionEvent event) {

		UserWindow.closeUserWindow(getClass(), (Stage) SecretaryMenuLable.getScene().getWindow());

    }

    /**
     * Initialize.
     */
    @FXML
    void initialize() {
        assert ChooseMenuButton != null : "fx:id=\"ChooseMenuButton\" was not injected: check your FXML file 'SecretaryMainWindow.fxml'.";
        assert AssignPupil != null : "fx:id=\"AssignPupil\" was not injected: check your FXML file 'SecretaryMainWindow.fxml'.";
        assert OpenCourse != null : "fx:id=\"OpenCourse\" was not injected: check your FXML file 'SecretaryMainWindow.fxml'.";
        assert AssignPupilToClass != null : "fx:id=\"AssignPupilToClass\" was not injected: check your FXML file 'SecretaryMainWindow.fxml'.";
        assert SecretaryMenuLable != null : "fx:id=\"SecretaryMenuLable\" was not injected: check your FXML file 'SecretaryMainWindow.fxml'.";
        assert OpenExeptionalRequstMenu != null : "fx:id=\"OpenExeptionalRequstMenu\" was not injected: check your FXML file 'SecretaryMainWindow.fxml'.";
        assert ChooseOperationalMenu != null : "fx:id=\"ChooseOperationalMenu\" was not injected: check your FXML file 'SecretaryMainWindow.fxml'.";
        assert LogOutButton != null : "fx:id=\"LogOutButton\" was not injected: check your FXML file 'SecretaryMainWindow.fxml'.";
        assert ReAssign != null : "fx:id=\"ReAssign\" was not injected: check your FXML file 'SecretaryMainWindow.fxml'.";
        assert DeletePupil != null : "fx:id=\"DeletePupil\" was not injected: check your FXML file 'SecretaryMainWindow.fxml'.";
        assert OpenSemester != null : "fx:id=\"OpenSemester\" was not injected: check your FXML file 'SecretaryMainWindow.fxml'.";
        assert DefineClass != null : "fx:id=\"DefineClass\" was not injected: check your FXML file 'SecretaryMainWindow.fxml'.";

    }


	@Override
	public void handleAnswer(Object msg) {
		// TODO Auto-generated method stub
		
	}
}
