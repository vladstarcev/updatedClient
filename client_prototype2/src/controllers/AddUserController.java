package controllers;

import interfaces.IController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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

    }

    @FXML
    void backToMenu(ActionEvent event) {
    	Stage stage = new Stage();
    	UserWindow.closeUserWindow(getClass(), stage);
    }

	@Override
	public void handleAnswer(Object msg) {
		// TODO Auto-generated method stub
		
	}

}
