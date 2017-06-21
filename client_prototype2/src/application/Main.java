package application;

import java.util.Stack;

import javafx.application.Application;
import javafx.stage.Stage;
import ui.UserWindow;

public class Main extends Application
{
	public static Stack<String> stack;
	public static SchoolClient client;
	public static Object paramater;
	public static String userId = null;

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		stack = new Stack<>();
		client = new SchoolClient("localhost", 5556);
		//UserWindow.createUserWindow(primaryStage, "loginFrame", getClass());
		//stack.push("loginFrame");
		
		
		///*********************************test********************************/
		  UserWindow.createUserWindow(primaryStage, "SecretaryMainWindow", getClass());
		  stack.push("SecretaryMainWindow");
		  userId = "444444444";
		///*********************************test********************************/
	
	}

	public static void main(String[] args)
	{
		launch(args);
	}
}
