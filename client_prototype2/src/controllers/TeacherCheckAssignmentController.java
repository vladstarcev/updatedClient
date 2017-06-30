package controllers;

import interfaces.IController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class TeacherCheckAssignmentController implements IController{

    @FXML
    private Button BackToMenuButton;
    
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> ChooseAssCB;

    @FXML
    private ComboBox<String> ChoosePupilCB;

    @FXML
    private ComboBox<String> ChooseCourseCB;

    @FXML
    private Button DownloadAssbutton;

    @FXML
    void ChooseCourse(ActionEvent event) {

    }

    @FXML
    void ChooseAss(ActionEvent event) {

    }

    @FXML
    void DownloadAss(ActionEvent event) {

    }

    @FXML
    void ChoosePupil(ActionEvent event) {

    }
     
    @FXML
    void BackToMenu(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert BackToMenuButton != null : "fx:id=\"BackToMenuButton\" was not injected: check your FXML file 'CheckAssignment.fxml'.";
        assert ChooseAssCB != null : "fx:id=\"ChooseAssCB\" was not injected: check your FXML file 'CheckAssignment.fxml'.";
        assert ChoosePupilCB != null : "fx:id=\"ChoosePupilCB\" was not injected: check your FXML file 'CheckAssignment.fxml'.";
        assert ChooseCourseCB != null : "fx:id=\"ChooseCourseCB\" was not injected: check your FXML file 'CheckAssignment.fxml'.";
        assert DownloadAssbutton != null : "fx:id=\"DownloadAssbutton\" was not injected: check your FXML file 'CheckAssignment.fxml'.";


    }



	@Override
	public void handleAnswer(Object msg) {
		// TODO Auto-generated method stub
		
	}

}
