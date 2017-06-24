package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import interfaces.IController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class PupilExeptionalRequestController implements IController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<?> ChooseCourseComboBox;

    @FXML
    private MenuItem AssignPupil;

    @FXML
    private TextField RequestIdTextField;

    @FXML
    private Button CheckIdButton;

    @FXML
    private ComboBox<?> ChoosePupilComboBox;

    @FXML
    private Button BackButton;

    @FXML
    private Label PupilExeptionalLable;

    @FXML
    private Label RequestIdLable;

    @FXML
    private MenuButton ChooseOperationMenuButton;

    @FXML
    private Label OperationLable;

    @FXML
    private MenuItem DeletePupil;

    @FXML
    private Button SendButton;

    @FXML
    private Label PupilIdLable;

    @FXML
    private Label CourseListLable;

    @FXML
    void CeckIdAvailability(ActionEvent event) {

    }

    @FXML
    void ChooseCourse(ActionEvent event) {

    }

    @FXML
    void ChoosePupil(ActionEvent event) {

    }

    @FXML
    void ChooseOperation(ActionEvent event) {

    }

    @FXML
    void AssignPupilToCourse(ActionEvent event) {

    }

    @FXML
    void AssignPupilMenu(ActionEvent event) {

    }

    @FXML
    void DeletePupilFromCourse(ActionEvent event) {

    }

    @FXML
    void DeletePupilMenu(ActionEvent event) {

    }

    @FXML
    void SendToSchoolManager(ActionEvent event) {

    }

    @FXML
    void BackToMenu(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert ChooseCourseComboBox != null : "fx:id=\"ChooseCourseComboBox\" was not injected: check your FXML file 'ExeptionalRequestForPupil.fxml'.";
        assert AssignPupil != null : "fx:id=\"AssignPupil\" was not injected: check your FXML file 'ExeptionalRequestForPupil.fxml'.";
        assert RequestIdTextField != null : "fx:id=\"RequestIdTextField\" was not injected: check your FXML file 'ExeptionalRequestForPupil.fxml'.";
        assert CheckIdButton != null : "fx:id=\"CheckIdButton\" was not injected: check your FXML file 'ExeptionalRequestForPupil.fxml'.";
        assert ChoosePupilComboBox != null : "fx:id=\"ChoosePupilComboBox\" was not injected: check your FXML file 'ExeptionalRequestForPupil.fxml'.";
        assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'ExeptionalRequestForPupil.fxml'.";
        assert PupilExeptionalLable != null : "fx:id=\"PupilExeptionalLable\" was not injected: check your FXML file 'ExeptionalRequestForPupil.fxml'.";
        assert RequestIdLable != null : "fx:id=\"RequestIdLable\" was not injected: check your FXML file 'ExeptionalRequestForPupil.fxml'.";
        assert ChooseOperationMenuButton != null : "fx:id=\"ChooseOperationMenuButton\" was not injected: check your FXML file 'ExeptionalRequestForPupil.fxml'.";
        assert OperationLable != null : "fx:id=\"OperationLable\" was not injected: check your FXML file 'ExeptionalRequestForPupil.fxml'.";
        assert DeletePupil != null : "fx:id=\"DeletePupil\" was not injected: check your FXML file 'ExeptionalRequestForPupil.fxml'.";
        assert SendButton != null : "fx:id=\"SendButton\" was not injected: check your FXML file 'ExeptionalRequestForPupil.fxml'.";
        assert PupilIdLable != null : "fx:id=\"PupilIdLable\" was not injected: check your FXML file 'ExeptionalRequestForPupil.fxml'.";
        assert CourseListLable != null : "fx:id=\"CourseListLable\" was not injected: check your FXML file 'ExeptionalRequestForPupil.fxml'.";

    }

	@Override
	public void handleAnswer(Object msg)
	{
		// TODO Auto-generated method stub
		
	}
}
