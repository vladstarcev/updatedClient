package application;

import java.util.Stack;

import javafx.application.Application;
import javafx.stage.Stage;
import ui.UserWindow;

/**
 * The Class Main extends Application - this class is the main of client 
 */
public class Main extends Application {
	public static Stack<String> stack;
	public static SchoolClient client;
	public static Object paramater;
	public static String userId = null;
	public static String ip;
	public static String port;

    /**
     * start the school client and login to the system
     */   
	@Override
	public void start(Stage primaryStage) throws Exception {
		stack = new Stack<>();
		client = new SchoolClient(ip, Integer.parseInt(port));
		stack.push("loginFrame");

		UserWindow.createUserWindow(primaryStage, "loginFrame", getClass());
			
		///*********************************test********************************/

		// UserWindow.createUserWindow(primaryStage, "PupilFile", getClass());
		// stack.push("PupilFile");

		// userId = "333333333";

		/// *********************************test********************************/
	}


    /**
     * main
     * @param args - argument
     */   
	public static void main(String[] args)
	{
		ip=args[0];
		port=args[1];

		launch(args);
	}
}
