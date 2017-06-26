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
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import ui.UserWindow;

public class AddCourseController implements IController {

    @FXML
    private TextField hoursTxt;

    @FXML
    private TextField idTxt;

    @FXML
    private Label sUnitLbl;

    @FXML
    private Button cancelBtn;

    @FXML
    private Label hoursLbl;

    @FXML
    private TextField nameTxt;

    @FXML
    private TextField unitTxt;

    @FXML
    private Label courseNameLbl;

    @FXML
    private Label idLbl;

    @FXML
    private Button addBtn;

    @FXML
    void addCourse(ActionEvent event) {
    	ArrayList<String> data = new ArrayList<>();
    	data.add("add course");
    	data.add("insert");
    	data.add("courses");
    	data.add("courseId");
    	data.add("courseName");
    	data.add("weeklyStudyHours");
    	data.add("studyUnit");
    	
    	data.add("values");
    	data.add(idTxt.getText());
    	data.add(nameTxt.getText());
    	data.add(hoursTxt.getText());
    	data.add(unitTxt.getText());
    	
    	try {
			Main.client.sendToServer(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    @FXML
    void initialize(){
    	Main.client.controller=this;
    }

    @FXML
    void backToMenu(ActionEvent event) {
    	UserWindow.closeUserWindow(getClass(), (Stage)cancelBtn.getScene().getWindow());
    }

	@Override
	public void handleAnswer(Object msg) {
		if (msg == null)
		{
			// error
			new Alert(AlertType.ERROR, "Error during executing the action", ButtonType.OK).showAndWait();
			return;
		}
		ArrayList<String> arr = (ArrayList<String>) msg;
		String type = arr.remove(0);
		if (type.equals("add course"))
		{
			if (arr.size() == 0)
			{
				new Alert(AlertType.ERROR, "The course is already in DB", ButtonType.OK).showAndWait();
			}
			else
			{
				new Alert(AlertType.INFORMATION, "Course was successfully added to DB", ButtonType.OK).showAndWait();
			}
		}
		UserWindow.closeUserWindow(getClass(), (Stage)cancelBtn.getScene().getWindow());
		
	}

}
