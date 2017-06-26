package controllers;

import java.io.IOException;
import java.util.ArrayList;

import application.Main;
import interfaces.IController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import ui.UserWindow;

public class CreateEvaluationFormController implements IController {

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
    private Button CheckPupilBtn;

    @FXML
    private Button CreateEvaluationFormButton;

    @FXML
    private TextField PupilGradeTextLabel;

    @FXML
    void CheckPupil(ActionEvent event) {
    	ArrayList<String> data = new ArrayList<String>();
		data.add("Check Pupil");
		data.add("select");
		data.add("pupil");
		data.add("userID");
		data.add(PupilIDTextField.getText());
		try
		{
			Main.client.sendToServer(data);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
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
    void initialize(){
    	Main.client.controller=this;
    }

	@Override
	public void handleAnswer(Object msg) {
		if (msg == null)
		{
			// error
			new Alert(AlertType.ERROR, "Error during executing the action.", ButtonType.OK).showAndWait();
			return;
		}
		ArrayList<String> arr = (ArrayList<String>) msg;
		String type = arr.remove(0);
		
		if (type.equals("Check Pupil"))
		{
			if (arr.size() == 0)
			{
				new Alert(AlertType.ERROR, "Pupil has not found.", ButtonType.OK).showAndWait();
			}
			else
			{
				new Alert(AlertType.INFORMATION, "Pupil has found.", ButtonType.OK).showAndWait();
			}
		}
		
	}

}
