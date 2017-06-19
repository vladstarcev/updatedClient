package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import interfaces.IController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class UserController implements IController
{
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField passwordTextField;

	@FXML
	private Button loginBtn;

	@FXML
	private TextField userIdTextField;

	@FXML
	void login(ActionEvent event)
	{
		authorizeUser(userIdTextField.getText(), passwordTextField.getText());
	}

	public void authorizeUser(String name, String pass)
	{
		Main.client.controller = this;
		ArrayList<String> data = new ArrayList<String>();
		data.add("login");
		data.add(name);
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

	public void handleAnswer(Object result)
	{
		/*switch(permission){
		case "1":{
			Main.client.ui.hideWindow();
			SystemManagerUI sysadmin = new SystemManagerUI();
			sysadmin.createUserWindow();
			break;
		}
		case "2":{
			Main.client.ui.hideWindow();
			SchoolManagerInterface schoolmanager = new SchoolManagerInterface();
			schoolmanager.createUserWindow();
			break;
		}
		case "3":{
		
		}
		case "4":{
			
		}
		case "5":{
			
		}
		}*/
	}

	@FXML
	void initialize()
	{
		// dont push login to stack please
	}
}
