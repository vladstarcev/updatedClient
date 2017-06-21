package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Main;
import interfaces.IController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ui.UserWindow;

public class CreateEvaluationFormController implements IController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label EvaluationFormWindowLabel;

    @FXML
    private Label PupilIDLabel;

    @FXML
    private Label GradeLabel;

    @FXML
    private Label CommentsLabel;

    @FXML
    private TextField PupilIDTextField;

    @FXML
    private TextArea CommentsTextArea;

    @FXML
    private Button BackButton;

    @FXML
    private Button CreateEvaluationFormButton;

    @FXML
    private TextField PupilGradeTextLabel;

    @FXML
    void EnterPupilID(ActionEvent event) {

    }

    @FXML
    void EnterPupilGrade(ActionEvent event) {

    }

    @FXML
    void CreateEvaluationForm(ActionEvent event) {
          	ArrayList<String> data = new ArrayList<>();
        	data.add("create evaluation form");
        	data.add("insert");
        	data.add("evaluation_form");
        	//data.add("fileNumber");
        	data.add("generalComments");
        	data.add("finalGrade");
        	//data.add("format");
        	
        	data.add("values");
        	//data.add(); //number of file
        	data.add(CommentsTextArea.getText());
        	data.add(PupilGradeTextLabel.getText());
        	//data.add(); //format of file
    }

    @FXML
    void BackToMenu(ActionEvent event) {
    	UserWindow.closeUserWindow(getClass(), (Stage)BackButton.getScene().getWindow());

    }

    @FXML
    void initialize() {
        assert EvaluationFormWindowLabel != null : "fx:id=\"EvaluationFormWindowLabel\" was not injected: check your FXML file 'TeacherCreateEvaluationForm.fxml'.";
        assert PupilIDLabel != null : "fx:id=\"PupilIDLabel\" was not injected: check your FXML file 'TeacherCreateEvaluationForm.fxml'.";
        assert GradeLabel != null : "fx:id=\"GradeLabel\" was not injected: check your FXML file 'TeacherCreateEvaluationForm.fxml'.";
        assert CommentsLabel != null : "fx:id=\"CommentsLabel\" was not injected: check your FXML file 'TeacherCreateEvaluationForm.fxml'.";
        assert PupilIDTextField != null : "fx:id=\"PupilIDTextField\" was not injected: check your FXML file 'TeacherCreateEvaluationForm.fxml'.";
        assert CommentsTextArea != null : "fx:id=\"CommentsTextArea\" was not injected: check your FXML file 'TeacherCreateEvaluationForm.fxml'.";
        assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'TeacherCreateEvaluationForm.fxml'.";
        assert CreateEvaluationFormButton != null : "fx:id=\"CreateEvaluationFormButton\" was not injected: check your FXML file 'TeacherCreateEvaluationForm.fxml'.";
        assert PupilGradeTextLabel != null : "fx:id=\"PupilGradeTextLabel\" was not injected: check your FXML file 'TeacherCreateEvaluationForm.fxml'.";

        Main.client.controller=this;
    }

	@Override
	public void handleAnswer(Object msg) {
		// TODO Auto-generated method stub
		
	}
}
