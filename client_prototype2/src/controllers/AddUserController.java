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

public class AddUserController implements IController {

    @FXML
    private Label fNameLblb;

    @FXML
    private TextField idTxt;

    @FXML
    private TextField lNameTxt;

    @FXML
    private Label lNameLbl;

    @FXML
    private TextField passTxt;

    @FXML
    private Button cancelBtn;

    @FXML
    private Button addUserBtn;

    @FXML
    private Label permLbl;

    @FXML
    private Label passLbl;

    @FXML
    private TextField fNameTxt;

    @FXML
    private TextField permTxt;

    @FXML
    private Label idLbl;

    @FXML
    void AddUser(ActionEvent event) {
    	
    	ArrayList<String> data = new ArrayList<>();
    	data.add("add user");
    	data.add("insert");
    	data.add("user");
    	data.add("userId");
    	data.add("userFirstName");
    	data.add("userLastName");
    	data.add("userPassword");
    	data.add("isLogged");
    	data.add("permission");
    	
    	data.add("values");
    	data.add(idTxt.getText());
    	data.add(fNameTxt.getText());
    	data.add(lNameTxt.getText());
    	data.add(passTxt.getText());
    	data.add("0");
    	data.add(permTxt.getText());
    	
    	try {
			Main.client.sendToServer(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

    @FXML
    void backToMenu(ActionEvent event) {
    	
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
			new Alert(AlertType.ERROR, "Error during executing the action.", ButtonType.OK).showAndWait();
			return;
		}
		ArrayList<String> arr = (ArrayList<String>) msg;
		String type = arr.remove(0);
		if (type.equals("add user"))
		{
			if (arr.size() == 0)
			{
				new Alert(AlertType.ERROR, "The course is already in DB", ButtonType.OK).showAndWait();
			}
			else
			{
				new Alert(AlertType.INFORMATION, "User was successfully added to DB", ButtonType.OK).showAndWait();
			}
		}
		UserWindow.closeUserWindow(getClass(), (Stage)cancelBtn.getScene().getWindow());
	}

}
