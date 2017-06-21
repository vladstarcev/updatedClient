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
import javafx.stage.Stage;
import ui.UserWindow;


public class DefineClassController implements IController{

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
    private TextField ClassIdTextField;

    @FXML
    private Label EnterClassIDLabel1;

    @FXML
    private Button CheckAvailabilityButton2;

    @FXML
    private Button CheckAvailabilityButton1;

    @FXML
    private Button BackButton;

    @FXML
    private Label DefineClassLabel;

    @FXML
    private Label FillFormLabel;

    @FXML
    private Button DefineClassButton;
    
    private int ClassNameF;
    private int ClassIDF;

    @FXML
    void EnterMaxPupilForClass(ActionEvent event) {

    }

    @FXML
    void EnterClassName(ActionEvent event) {

    }

    @FXML
    void DefineClass(ActionEvent event) {

    		if (MaximumPupilInClassTextField.getText().startsWith("-")
    				|| MaximumPupilInClassTextField.getText().equals("0")|| MaximumPupilInClassTextField.getText().isEmpty())
    		{
    			new Alert(AlertType.ERROR, "Wrong Capacity", ButtonType.OK).showAndWait();
    			return;
    		}
    		else if((ClassIDF==1) && (ClassNameF==1))
    		{
    			InsertNewClass();
    		}
    		else new Alert(AlertType.ERROR, "Missing Fields", ButtonType.OK).showAndWait();

    	}

	void InsertNewClass()
	{
		ArrayList<String> data = new ArrayList<String>();
		data.add("Insert New Class");
		data.add("insert");
		data.add("class");
		data.add("classId");
		data.add("className");
		data.add("capacity");
		data.add("values");
		data.add(ClassIdTextField.getText());
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
    	
    	ClassNameF=0;
   	    ClassIDF=0;
   	    UserWindow.closeUserWindow(getClass(), (Stage) FillFormLabel.getScene().getWindow());

    }

    @FXML
    void CheckAvailability2(ActionEvent event) {

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
    void EnterClassID(ActionEvent event) {

    }

    @FXML
    void CheckAvailability1(ActionEvent event) {

		ArrayList<String> data = new ArrayList<String>();
		data.add("Class ID");
		data.add("select");
		data.add("class");
		data.add("classId");
		data.add(ClassIdTextField.getText());

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
        assert ClassIdTextField != null : "fx:id=\"ClassIdTextField\" was not injected: check your FXML file 'SecretaryDefineClass.fxml'.";
        assert EnterClassIDLabel1 != null : "fx:id=\"EnterClassIDLabel1\" was not injected: check your FXML file 'SecretaryDefineClass.fxml'.";
        assert CheckAvailabilityButton2 != null : "fx:id=\"CheckAvailabilityButton2\" was not injected: check your FXML file 'SecretaryDefineClass.fxml'.";
        assert CheckAvailabilityButton1 != null : "fx:id=\"CheckAvailabilityButton1\" was not injected: check your FXML file 'SecretaryDefineClass.fxml'.";
        assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'SecretaryDefineClass.fxml'.";
        assert DefineClassLabel != null : "fx:id=\"DefineClassLabel\" was not injected: check your FXML file 'SecretaryDefineClass.fxml'.";
        assert FillFormLabel != null : "fx:id=\"FillFormLabel\" was not injected: check your FXML file 'SecretaryDefineClass.fxml'.";
        assert DefineClassButton != null : "fx:id=\"DefineClassButton\" was not injected: check your FXML file 'SecretaryDefineClass.fxml'.";
		
        Main.client.controller = this;
	    ClassNameF=0;
	    ClassIDF=0;
        
    }

	@Override
	public void handleAnswer(Object msg)
	{
		// TODO Auto-generated method stub

		if (msg == null)
		{
			// error
			new Alert(AlertType.ERROR, "Item has not found.", ButtonType.OK).showAndWait();
			return;
		}

		ArrayList<String> arr = (ArrayList<String>) msg;
		String type = arr.remove(0);
		if(type.equals("Class ID"))
		{
			if (arr.size() == 0)
			{
				new Alert(AlertType.INFORMATION, "ID is Available", ButtonType.OK).showAndWait();
				ClassIDF=1;
			}
			else
				new Alert(AlertType.ERROR, "ID is Already Exist.", ButtonType.OK).showAndWait();
		}
		if (type.equals("Class Name"))
		{
			if (arr.size() == 0)
			{
				new Alert(AlertType.INFORMATION, "Name is Available", ButtonType.OK).showAndWait();
				ClassNameF=1;
			}
			else
				new Alert(AlertType.ERROR, "Name is Already Exist.", ButtonType.OK).showAndWait();
		}
		if (type.equals("Insert New Class"))
		{
			if (arr.size() != 0)
			{
				new Alert(AlertType.INFORMATION, "Class Defined Succesfully!", ButtonType.OK).showAndWait();
				UserWindow.closeUserWindow(getClass(), (Stage) FillFormLabel.getScene().getWindow());
			}
		}
			
	}
}

