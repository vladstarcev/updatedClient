package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
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

    
	void findPupil()
	{
		ArrayList<String> data = new ArrayList<String>();
		data.add("find Pupil");
		data.add("select");
		data.add("pupil");
		data.add("userID");
		data.add(PupilIDTextField.getText());
		try
		{
			Main.client.sendToServer(data);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	void updateParentPermission(String ParentId)
	{
		ArrayList<String> data = new ArrayList<String>();
		data.add("Block Parent");
		data.add("update");
		data.add("user");
		data.add("permission");
		data.add("0");
		data.add("conditions");
		data.add("userId");
		data.add(ParentId);
		data.add("permission");
		data.add("6");

		
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
    void EnterPupilID(ActionEvent event) {

    }

    @FXML
    void BlockParent(ActionEvent event) {
    	findPupil();
    }

    @FXML
    void BackToMenu(ActionEvent event) {
    	UserWindow.createUserWindow((Stage) BackButton.getScene().getWindow(), "SchoolManagerMainWindow", getClass());

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
	public void handleAnswer(Object result) {
		
		if (result == null)
		{
			// error
			new Alert(AlertType.ERROR, "Item has not found.", ButtonType.OK).showAndWait();
			return;
		}

		ArrayList<String> arr = (ArrayList<String>) result;
		String type = arr.remove(0);
		if(type.equals("find Pupil"))
		{
			if (arr.size() == 0)
			{
				new Alert(AlertType.ERROR, "Pupil has not found.", ButtonType.OK).showAndWait();
			}
			else
			{
				for (String row : arr)
				{
					String[] cols = row.split(";");
					HashMap<String, String> map = new HashMap<>();
					for (String col : cols)
					{
						String[] field = col.split("=");
						map.put(field[0], field[1]);
						System.out.println(field[0]+ " "+ field[1]);
					}
					String ParentId = map.get("parentID");
					updateParentPermission(ParentId);
				}
			}
		}
		else if(type.equals("Block Parent"))
		{
			new Alert(AlertType.INFORMATION, "Parent Blocked Successfully!", ButtonType.OK).showAndWait();
		}

	}
}
