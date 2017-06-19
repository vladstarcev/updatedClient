package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import interfaces.IController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BlockParentBySchoolManagerController implements IController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button BlockParentButton;

    @FXML
    private Label BlockUserLabel;

    @FXML
    private TextField PupilIDTextField;

    @FXML
    private Label EnterPupilIDLabel;

    @FXML
    private Button BackButton;

    @FXML
    void EnterPupilID(ActionEvent event) {

    }

    @FXML
    void BlockParent(ActionEvent event) {

    }

    @FXML
    void BackToMenu(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert BlockParentButton != null : "fx:id=\"BlockParentButton\" was not injected: check your FXML file 'SchoolManagerBlockUser.fxml'.";
        assert BlockUserLabel != null : "fx:id=\"BlockUserLabel\" was not injected: check your FXML file 'SchoolManagerBlockUser.fxml'.";
        assert PupilIDTextField != null : "fx:id=\"PupilIDTextField\" was not injected: check your FXML file 'SchoolManagerBlockUser.fxml'.";
        assert EnterPupilIDLabel != null : "fx:id=\"EnterPupilIDLabel\" was not injected: check your FXML file 'SchoolManagerBlockUser.fxml'.";
        assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'SchoolManagerBlockUser.fxml'.";

        Main.client.controller=this;
    }

	@Override
	public void handleAnswer(Object msg) {
		// TODO Auto-generated method stub
		
	}
}
