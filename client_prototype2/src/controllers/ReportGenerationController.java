package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import interfaces.IController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ReportGenerationController implements IController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField RequestReportTextField;

    @FXML
    private Button DisplayReportButton;

    @FXML
    private Button BackButton;

    @FXML
    private Label ReportWindowLabel;

    @FXML
    private ComboBox<?> ChooseReportFromListBox;

    @FXML
    private Label EnterRequstedReportLabel;

    @FXML
    void ChooseReport(ActionEvent event) {

    }

    @FXML
    void EnterRequstedReport(ActionEvent event) {

    }

    @FXML
    void DisplayReport(ActionEvent event) {

    }

    @FXML
    void BackToMenu(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert RequestReportTextField != null : "fx:id=\"RequestReportTextField\" was not injected: check your FXML file 'SchoolManagerReportGeneration.fxml'.";
        assert DisplayReportButton != null : "fx:id=\"DisplayReportButton\" was not injected: check your FXML file 'SchoolManagerReportGeneration.fxml'.";
        assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'SchoolManagerReportGeneration.fxml'.";
        assert ReportWindowLabel != null : "fx:id=\"ReportWindowLabel\" was not injected: check your FXML file 'SchoolManagerReportGeneration.fxml'.";
        assert ChooseReportFromListBox != null : "fx:id=\"ChooseReportFromListBox\" was not injected: check your FXML file 'SchoolManagerReportGeneration.fxml'.";
        assert EnterRequstedReportLabel != null : "fx:id=\"EnterRequstedReportLabel\" was not injected: check your FXML file 'SchoolManagerReportGeneration.fxml'.";

        Main.client.controller=this;
    }

	@Override
	public void handleAnswer(Object msg) {
		// TODO Auto-generated method stub
		
	}
}
