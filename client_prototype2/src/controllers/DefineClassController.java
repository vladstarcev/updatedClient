package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

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

public class DefineClassController implements IController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField MaximumPupilInClassTextField;

    @FXML
    private Label EnterClassNameLabel;

    @FXML
    private TextField ClassNameTextField;

    @FXML
    private Label EnterMAximumPupilLabel;

    @FXML
    private Button CheckAvailabilityButton;

    @FXML
    private Button BackButton;

    @FXML
    private Label DefineClassLabel;

    @FXML
    private Label FillFormLabel;

    @FXML
    private Button DefineClassButton;
    
    private int capacity;
    private String ClassId;
    
    @FXML
    void EnterMaxPupilForClass(ActionEvent event) {

    }

    @FXML
    void EnterClassName(ActionEvent event) {

    }

    @FXML
    void DefineClass(ActionEvent event) {
    	
    	
    	if (MaximumPupilInClassTextField.getText().startsWith("-")||MaximumPupilInClassTextField.getText().equals("0"))
    	{
    		new Alert(AlertType.ERROR, "Wrong Capacity", ButtonType.OK).showAndWait();
    		return;
    	}
    	else
    	{
    		InsertNewClass("1234");
    	}

    }
    void InsertNewClass(String classID)
    {
		ArrayList<String> data = new ArrayList<String>();
		data.add("Insert New Class");
		data.add("insert");
		data.add("class");
		data.add("classId");
		data.add("className");
		data.add("capacity");
		data.add("values");
		data.add(classID);
		data.add(ClassNameTextField.getText());
		data.add(MaximumPupilInClassTextField.getText());
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
    void BackToMenu(ActionEvent event) {

    }

    @FXML
    void CheckAvailability(ActionEvent event) {
    	
		ArrayList<String> data = new ArrayList<String>();
		data.add("Class Name");
		data.add("select");
		data.add("class");
		data.add("className");
		data.add(ClassNameTextField.getText());
		
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
    void initialize() {
        assert MaximumPupilInClassTextField != null : "fx:id=\"MaximumPupilInClassTextField\" was not injected: check your FXML file 'SecretaryDefineClass.fxml'.";
        assert EnterClassNameLabel != null : "fx:id=\"EnterClassNameLabel\" was not injected: check your FXML file 'SecretaryDefineClass.fxml'.";
        assert ClassNameTextField != null : "fx:id=\"ClassNameTextField\" was not injected: check your FXML file 'SecretaryDefineClass.fxml'.";
        assert EnterMAximumPupilLabel != null : "fx:id=\"EnterMAximumPupilLabel\" was not injected: check your FXML file 'SecretaryDefineClass.fxml'.";
        assert CheckAvailabilityButton != null : "fx:id=\"CheckAvailabilityButton\" was not injected: check your FXML file 'SecretaryDefineClass.fxml'.";
        assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'SecretaryDefineClass.fxml'.";
        assert DefineClassLabel != null : "fx:id=\"DefineClassLabel\" was not injected: check your FXML file 'SecretaryDefineClass.fxml'.";
        assert FillFormLabel != null : "fx:id=\"FillFormLabel\" was not injected: check your FXML file 'SecretaryDefineClass.fxml'.";
        assert DefineClassButton != null : "fx:id=\"DefineClassButton\" was not injected: check your FXML file 'SecretaryDefineClass.fxml'.";

        Main.client.controller=this;
        capacity=0;
        ClassId="";
    }

	@Override
	public void handleAnswer(Object msg) {
		// TODO Auto-generated method stub
		
		if (msg == null)
		{
			// error
			new Alert(AlertType.ERROR, "Item has not found.", ButtonType.OK).showAndWait();
			return;
		}
		
		ArrayList<String> arr = (ArrayList<String>) msg;
		String type = arr.remove(0);
		
		if (type.equals("Class Name"))
		{
			if (arr.size()==0)
				new Alert(AlertType.INFORMATION, "Name is Available", ButtonType.OK).showAndWait();
			else 
				new Alert(AlertType.ERROR, "Name is Already Exist.", ButtonType.OK).showAndWait();
		}
		if (type.equals("Insert New Class"))
		{
			if (arr.size()!=0)
				new Alert(AlertType.INFORMATION, "Class Defined Succesfully!", ButtonType.OK).showAndWait();
			//close window and back to secretary main
		}
	}
}
