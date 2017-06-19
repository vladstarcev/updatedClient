package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import interfaces.IController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ErrorMessageController implements IController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField EroorDetailsTextField;

    @FXML
    private Button OKButton;

    @FXML
    void PrintEroorMessage(ActionEvent event) {

    }

    @FXML
    void PressOK(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert EroorDetailsTextField != null : "fx:id=\"EroorDetailsTextField\" was not injected: check your FXML file 'ErrorMessageWindow.fxml'.";
        assert OKButton != null : "fx:id=\"OKButton\" was not injected: check your FXML file 'ErrorMessageWindow.fxml'.";

        Main.client.controller=this;
    }

	@Override
	public void handleAnswer(Object msg) {
		// TODO Auto-generated method stub
		
	}
}
