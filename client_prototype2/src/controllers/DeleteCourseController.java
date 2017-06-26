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

public class DeleteCourseController implements IController {

    @FXML
    private TextField idTxt;

    @FXML
    private Button cancelBtn;

    @FXML
    private Label enterLab;

    @FXML
    private Button deleteBtn;

    @FXML
    void DeleteCourse(ActionEvent event) {
    	ArrayList<String> data = new ArrayList<>();
    	data.add("delete course");
    	data.add("delete");
    	data.add("courses");
    	data.add("courseId");
    	data.add(idTxt.getText());
    	
    	try {
			Main.client.sendToServer(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void BackToMenu(ActionEvent event) {
    	UserWindow.closeUserWindow(getClass(), (Stage)cancelBtn.getScene().getWindow());
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
			new Alert(AlertType.ERROR, "Item has not found.", ButtonType.OK).showAndWait();
			return;
		}
		ArrayList<String> arr = (ArrayList<String>) msg;
		String type = arr.remove(0);
		if (type.equals("delete course"))
		{
			if (arr.size() == 0)
			{
				new Alert(AlertType.ERROR, "There is no user with such ID", ButtonType.OK).showAndWait();
			}
			else
			{
				new Alert(AlertType.INFORMATION, "Course was successfully deleted from DB", ButtonType.OK).showAndWait();
			}
		}
		UserWindow.closeUserWindow(getClass(), (Stage)cancelBtn.getScene().getWindow());
		
	}

}
