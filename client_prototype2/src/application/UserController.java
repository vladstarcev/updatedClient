package application;

import java.awt.Label;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import interfaces.IController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

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
    private Label AISFHSlable;

    @FXML
    private Label ASHlable;

    @FXML
    private ImageView LoginImage;
	
	
	

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

	}

	@FXML
	void initialize()
	{
        assert passwordTextField != null : "fx:id=\"passwordTextField\" was not injected: check your FXML file 'loginFrame.fxml'.";
        assert loginBtn != null : "fx:id=\"loginBtn\" was not injected: check your FXML file 'loginFrame.fxml'.";
        assert userIdTextField != null : "fx:id=\"userIdTextField\" was not injected: check your FXML file 'loginFrame.fxml'.";
        assert AISFHSlable != null : "fx:id=\"AISFHSlable\" was not injected: check your FXML file 'loginFrame.fxml'.";
        assert ASHlable != null : "fx:id=\"ASHlable\" was not injected: check your FXML file 'loginFrame.fxml'.";
        assert LoginImage != null : "fx:id=\"LoginImage\" was not injected: check your FXML file 'loginFrame.fxml'.";
	}
}
