package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import interfaces.IController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;

public class PupilMainWindow implements IController{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuButton ChooseMenuButton;

    @FXML
    private Label PupilMenuLable;

    @FXML
    private Button LogOutButton;

    @FXML
    private Label ChooseOperationLable;

    @FXML
    void PupilChooseOperation(ActionEvent event) {

    }

    @FXML
    void PupilLogOut(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert ChooseMenuButton != null : "fx:id=\"ChooseMenuButton\" was not injected: check your FXML file 'PupilMainWindow.fxml'.";
        assert PupilMenuLable != null : "fx:id=\"PupilMenuLable\" was not injected: check your FXML file 'PupilMainWindow.fxml'.";
        assert LogOutButton != null : "fx:id=\"LogOutButton\" was not injected: check your FXML file 'PupilMainWindow.fxml'.";
        assert ChooseOperationLable != null : "fx:id=\"ChooseOperationLable\" was not injected: check your FXML file 'PupilMainWindow.fxml'.";

        Main.client.controller=this; 
    }

	@Override
	public void handleAnswer(Object msg) {
		// TODO Auto-generated method stub
		
	}
}
