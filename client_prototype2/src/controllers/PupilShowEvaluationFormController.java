package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import interfaces.IController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PupilShowEvaluationFormController implements IController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField FinalGradeTextField;

    @FXML
    private Label CommentsLabel;

    @FXML
    private Label FormMenuLabel;

    @FXML
    private TextArea CommentsTextArea;

    @FXML
    private Button BackButton;

    @FXML
    private Label FinalGradeLabel;

    @FXML
    void PupilFinalGrade(ActionEvent event) {

    }

    @FXML
    void BackToMenu(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert FinalGradeTextField != null : "fx:id=\"FinalGradeTextField\" was not injected: check your FXML file 'PupilEvaluationForm.fxml'.";
        assert CommentsLabel != null : "fx:id=\"CommentsLabel\" was not injected: check your FXML file 'PupilEvaluationForm.fxml'.";
        assert FormMenuLabel != null : "fx:id=\"FormMenuLabel\" was not injected: check your FXML file 'PupilEvaluationForm.fxml'.";
        assert CommentsTextArea != null : "fx:id=\"CommentsTextArea\" was not injected: check your FXML file 'PupilEvaluationForm.fxml'.";
        assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'PupilEvaluationForm.fxml'.";
        assert FinalGradeLabel != null : "fx:id=\"FinalGradeLabel\" was not injected: check your FXML file 'PupilEvaluationForm.fxml'.";

        Main.client.controller=this;
    }

	@Override
	public void handleAnswer(Object msg) {
		// TODO Auto-generated method stub
		
	}
}
