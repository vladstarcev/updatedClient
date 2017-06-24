package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ReportBetweenCoursesController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button BackButton;

    @FXML
    private Label ReportLabel1;

    @FXML
    private BarChart<?, ?> ReportChart;

    @FXML
    private Label ReportLabel2;

    @FXML
    void BackToMenu(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'ReportBetweenDiferentCoursesOfSpecificClass.fxml'.";
        assert ReportLabel1 != null : "fx:id=\"ReportLabel1\" was not injected: check your FXML file 'ReportBetweenDiferentCoursesOfSpecificClass.fxml'.";
        assert ReportChart != null : "fx:id=\"ReportChart\" was not injected: check your FXML file 'ReportBetweenDiferentCoursesOfSpecificClass.fxml'.";
        assert ReportLabel2 != null : "fx:id=\"ReportLabel2\" was not injected: check your FXML file 'ReportBetweenDiferentCoursesOfSpecificClass.fxml'.";

    }
}
