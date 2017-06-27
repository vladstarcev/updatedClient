package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Main;
import interfaces.IController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ui.UserWindow;

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
        UserWindow.closeUserWindow(getClass(), (Stage)BackButton.getScene().getWindow());
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
    
    void loadEvaluationForm()
    {
    	ArrayList<String> data = new ArrayList<String>();
    	data.add("load evaluation form");
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

	@Override
	public void handleAnswer(Object msg) {
		// TODO Auto-generated method stub
		
	}
}
