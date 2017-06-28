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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BlockParentBySchoolManagerController  implements IController {

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
    private Button FreeParentButton;
    

    private String ParentId;
    private boolean flagBlock;
    private String access;

    @FXML
    void EnterPupilID(ActionEvent event) {

    }

    @FXML
    void BlockParent(ActionEvent event) {
    	flagBlock = true;
    	findPupil();
    }

    @FXML
    void BackToMenu(ActionEvent event) {

    }

    @FXML
    void FreeParent(ActionEvent event) {
    	flagBlock = false;
    	findPupil();
    }
    
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
    
	void updateParentPermission(String ParentId, String acc)
	{
		ArrayList<String> data = new ArrayList<String>();
		if(acc.equals("block"))
		{
			if (access.equals("1")){
				new Alert(AlertType.ERROR, "Parent is already Block!", ButtonType.OK).showAndWait();
				return;
			}
	    	
			data.add("Block Parent");
			data.add("update");
			data.add("pupil");
			data.add("ParentAccess");
			data.add("1");
			data.add("conditions");
			data.add("userID");
			data.add(PupilIDTextField.getText());
		}
		else if(acc.equals("free"))
		{
			if (access.equals("0")){
				new Alert(AlertType.ERROR, "Parent is already free!", ButtonType.OK).showAndWait();
				return;
			}
	    	
			data.add("Free Parent");
			data.add("update");
			data.add("pupil");
			data.add("ParentAccess");
			data.add("0");
			data.add("conditions");
			data.add("userID");
			data.add(PupilIDTextField.getText());
		}
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
        assert BlockParentButton != null : "fx:id=\"BlockParentButton\" was not injected: check your FXML file 'SchoolManagerBlockUser.fxml'.";
        assert BlockUserLabel != null : "fx:id=\"BlockUserLabel\" was not injected: check your FXML file 'SchoolManagerBlockUser.fxml'.";
        assert PupilIDTextField != null : "fx:id=\"PupilIDTextField\" was not injected: check your FXML file 'SchoolManagerBlockUser.fxml'.";
        assert EnterPupilIDLabel != null : "fx:id=\"EnterPupilIDLabel\" was not injected: check your FXML file 'SchoolManagerBlockUser.fxml'.";
        assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'SchoolManagerBlockUser.fxml'.";
        assert FreeParentButton != null : "fx:id=\"FreeParentButton\" was not injected: check your FXML file 'SchoolManagerBlockUser.fxml'.";

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
				return;
			}
			for (String row : arr)
			{
				String[] cols = row.split(";");
				HashMap<String, String> map = new HashMap<>();
				for (String col : cols)
				{
					String[] field = col.split("=");
					map.put(field[0], field[1]);
				}
				ParentId = map.get("parentID");
				access = map.get("ParentAccess");
			}
	    	if(flagBlock==true) updateParentPermission(ParentId,"block");
	    	else updateParentPermission(ParentId,"free");


		}
		else if(type.equals("Free Parent"))
			new Alert(AlertType.INFORMATION, "Parent Free Successfully!", ButtonType.OK).showAndWait();
		else if (type.equals("Block Parent"))
			new Alert(AlertType.INFORMATION, "Parent Blocked Successfully!", ButtonType.OK).showAndWait();		
	}
}
