package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import interfaces.IController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import ui.UserWindow;

public class UserController implements IController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Button loginBtn;

    @FXML
    private TextField userIdTextField;

    @FXML
    private Label AISFHSlable;

    @FXML
    private Label ASHlable;

    
    private String   permission;
    
    public static String CurrentUserID;
	
    @FXML
    void login(ActionEvent event) {

    	authorizeUser(userIdTextField.getText(), passwordTextField.getText());
    }
    
	public void authorizeUser(String name, String pass)
	{
		Main.client.controller = this;
		ArrayList<String> data = new ArrayList<String>();
		data.add("login");
		data.add("select");
		data.add("user");
		data.add("userId");
		data.add(name);
		data.add("userPassword");
		data.add(pass);
		try
		{
			Main.client.sendToServer(data);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	void OpenMenu()
	{
		if(permission.equals("1"))
		{
		   	UserWindow.createUserWindow((Stage) loginBtn.getScene().getWindow(), "SystemManagerMainWindow", getClass());
		}
		if(permission.equals("2"))
		{
			UserWindow.createUserWindow((Stage) loginBtn.getScene().getWindow(), "SchoolManagerMainWindow", getClass());
		}
		if(permission.equals("3"))
		{
			UserWindow.createUserWindow((Stage) loginBtn.getScene().getWindow(), "SecretaryMainWindow", getClass());
		}
		if(permission.equals("4"))
		{
			UserWindow.createUserWindow((Stage) loginBtn.getScene().getWindow(), "TeacherMainWindow", getClass());
		}
		if(permission.equals("5"))
		{
			UserWindow.createUserWindow((Stage) loginBtn.getScene().getWindow(), "Parent", getClass());
		}
		if(permission.equals("6"))
		{
			UserWindow.createUserWindow((Stage) loginBtn.getScene().getWindow(), "PupilMainWindow", getClass());
		}
	}

    @FXML
    void initialize() {
        assert passwordTextField != null : "fx:id=\"passwordTextField\" was not injected: check your FXML file 'loginFrame.fxml'.";
        assert loginBtn != null : "fx:id=\"loginBtn\" was not injected: check your FXML file 'loginFrame.fxml'.";
        assert userIdTextField != null : "fx:id=\"userIdTextField\" was not injected: check your FXML file 'loginFrame.fxml'.";
        assert AISFHSlable != null : "fx:id=\"AISFHSlable\" was not injected: check your FXML file 'loginFrame.fxml'.";
        assert ASHlable != null : "fx:id=\"ASHlable\" was not injected: check your FXML file 'loginFrame.fxml'.";

        Main.client.controller=this;
        
        userIdTextField.setText("404040404");
        passwordTextField.setText("oshrat404");
        
        CurrentUserID="";
        permission="";
    }

	@Override
	public void handleAnswer(Object result) {
		// TODO Auto-generated method stub
		
		if (result == null)
		{
			// error

			return;
		}	
		ArrayList<String> arr = (ArrayList<String>) result;
		String type = arr.remove(0);
		
		if(type.equals("login"))
		{
			if(arr.size()==0)
			{
				new Alert(AlertType.ERROR, "Wrong Password OR ID", ButtonType.OK).showAndWait();
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
					}
					permission=map.get("permission");
					CurrentUserID=map.get("userId");
					Main.userId = CurrentUserID;
				}
				OpenMenu();
			}
		}
		
	}
}
