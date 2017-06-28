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
    	data.add("check if course exist");
    	data.add("select");
    	data.add("courses");
    	data.add("courseId");
    	data.add(idTxt.getText());
    	
    	try
    	{
    	 Main.client.sendToServer(data);
		}
    	catch (IOException e)
    	{
			e.printStackTrace();
		}
    }
    
    void delete(){
    	
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
    	
        assert idTxt != null : "fx:id=\"idTxt\" was not injected: check your FXML file 'SystemManagerDeleteCourse.fxml'.";
        assert cancelBtn != null : "fx:id=\"cancelBtn\" was not injected: check your FXML file 'SystemManagerDeleteCourse.fxml'.";
        assert enterLab != null : "fx:id=\"enterLab\" was not injected: check your FXML file 'SystemManagerDeleteCourse.fxml'.";
        assert deleteBtn != null : "fx:id=\"deleteBtn\" was not injected: check your FXML file 'SystemManagerDeleteCourse.fxml'.";
    	
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
		
		if (type.equals("check if course exist"))
		{
			if (arr.size() == 0)
			{
				new Alert(AlertType.ERROR, "Course Not Exist", ButtonType.OK).showAndWait();
			}
			else
			{
				delete();
			}
		}
		
		if(type.equals("delete course"))
		{
			new Alert(AlertType.INFORMATION, "Course Succesfully From DB", ButtonType.OK).showAndWait();
			UserWindow.closeUserWindow(getClass(), (Stage)cancelBtn.getScene().getWindow());
		}
	}

}
